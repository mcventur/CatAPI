package com.mpd.pmdm.catapi.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.ui.adapters.MyCatItemRecyclerViewAdapter
import com.mpd.pmdm.catapi.ui.viewmodel.CatsViewModel
import com.mpd.pmdm.catapi.ui.viewmodel.CatsViewModelFactory

/**
 * A fragment representing a list of Items.
 */
class CatListFragment : Fragment() {

    private var columnCount = 2
    private lateinit var adapterCats: MyCatItemRecyclerViewAdapter
    private val viewModel: CatsViewModel by activityViewModels { CatsViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cat_list, container, false)
        adapterCats = MyCatItemRecyclerViewAdapter(emptyList())
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = adapterCats
            }
        }

        val recycler =view as RecyclerView
        (recycler).setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if(!recycler.canScrollVertically(1)){
                viewModel.moreCats()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.catList.observe(viewLifecycleOwner){
            adapterCats.updateList(it)
        }




    }
}