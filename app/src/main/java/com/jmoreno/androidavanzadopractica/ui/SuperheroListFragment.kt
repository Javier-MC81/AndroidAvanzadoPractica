package com.jmoreno.androidavanzadopractica.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmoreno.androidavanzadopractica.databinding.FragmentSuperheroListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class SuperheroListFragment : Fragment() {

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSuperheroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SuperheroAdapter() { superheroId: String ->
            findNavController().navigate(
                SuperheroListFragmentDirections.actionSuperheroListFragmentToDetailFragment(superheroId)
            )
        }

        binding.superheroList.adapter = adapter

        viewModel.heros.observe(viewLifecycleOwner) { heros ->
            adapter.submitList(heros)

        }
        /*viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiListState.collect{
                when (it) {
                    //SecondActivityViewModel.UiListState.Empty -> {}
                    is SuperheroViewModel.UiListState.Error -> {} // Mostrar un mensaje de error
                    SuperheroViewModel.UiListState.Idle -> {} // Mostrar el loading (si tienes)
                    is SuperheroViewModel.UiListState.OnHeroReceived -> {
                        //showHero(it.personaje)
                    } // Abrir el otro fragment
                    is SuperheroViewModel.UiListState.OnListReceived -> {
                        val listaPersonajes = it.heroeList
                        val adapter = SuperheroAdapter(listaPersonajes,)
                        binding.superheroList.layoutManager = LinearLayoutManager(binding.root.context)
                        binding.superheroList.adapter = adapter
                    }
                }
            }
        }*/



    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}