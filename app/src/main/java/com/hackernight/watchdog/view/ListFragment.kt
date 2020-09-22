package com.hackernight.watchdog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackernight.watchdog.R
import com.hackernight.watchdog.model.DogBreed
import com.hackernight.watchdog.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    lateinit var viewModel : ListViewModel
    private val dogListAdapter = DogListAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //instantiate view model
        viewModel =ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerViewDogList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter  = dogListAdapter
        }

        observerViewModel()

    }

    private fun observerViewModel() {
        viewModel.dogs.observe(viewLifecycleOwner, Observer {dogs:List<DogBreed> ->
            dogs?.let {
                recyclerViewDogList.visibility = View.VISIBLE
                dogListAdapter.updateList(dogs)
            }
        })

        viewModel.dogLoadError.observe(viewLifecycleOwner, Observer { isError:Boolean ->
                isError?.let {
                        listError.visibility = if (isError) View.VISIBLE else View.GONE
                }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {isLoading:Boolean ->
            isLoading.let {
                loadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
                if (isLoading){
                    listError.visibility = View.GONE
                    recyclerViewDogList.visibility = View.GONE
                }
            }
        })

    }

}