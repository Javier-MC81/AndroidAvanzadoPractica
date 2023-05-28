package com.jmoreno.androidavanzadopractica.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jmoreno.androidavanzadopractica.R
import com.jmoreno.androidavanzadopractica.databinding.FragmentDetailBinding
import com.jmoreno.androidavanzadopractica.utils.viewBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewSecond.text = args.superheroId

    }

}