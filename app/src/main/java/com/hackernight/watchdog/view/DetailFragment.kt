package com.hackernight.watchdog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.hackernight.watchdog.R
import com.hackernight.watchdog.model.DogBreed
import com.hackernight.watchdog.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var detailViewModel : DetailViewModel
    private var dogUuid = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //instantiate detail view model
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() {
        detailViewModel.dogLiveData.observe(viewLifecycleOwner, Observer {dogs:List<DogBreed> ->
            dogs?.let {
                textViewDetailsDogName.text = dogs[0].dogBreed
                textViewDetailsDogPurpose.text = dogs[0].breedGroup
                textViewDetailsDogTemperament.text = dogs[0].temperament
                textViewDetailsDogLifeSpan.text =dogs[0].lifeSpan
            }
        })
    }

}