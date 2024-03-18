package com.mpd.pmdm.catapi.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpd.pmdm.catapi.R
import com.mpd.pmdm.catapi.testdata.CatsTestList
import com.mpd.pmdm.catapi.ui.adapters.MyCatItemRecyclerViewAdapter

/**
 * A fragment representing a list of Items.
 */
class CatListFragment : Fragment() {

    private var columnCount = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cat_list, container, false)

        val catAdapter = MyCatItemRecyclerViewAdapter()
        catAdapter.submitList(CatsTestList.lista)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = catAdapter
            }
        }
        return view
    }
}