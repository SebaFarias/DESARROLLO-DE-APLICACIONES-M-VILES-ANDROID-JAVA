package com.example.contactoskotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactoskotlin.R
import com.example.contactoskotlin.adpater.ContactoAdapter
import com.example.contactoskotlin.databinding.FragmentListaBinding
import com.example.contactoskotlin.model.Contacto
import com.example.contactoskotlin.viewmodel.ContactoViewModel

class ListaFragment : Fragment() {

    private lateinit var binding : FragmentListaBinding
    private lateinit var model : ContactoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater,container,false)

        model = ViewModelProvider(this).get(ContactoViewModel::class.java)
        var contactos : ArrayList<Contacto>? = arguments?.getSerializable("data") as ArrayList<Contacto>?
        if( contactos != null )
        {
            model.contactos.value = contactos
        }

        val adapter = ContactoAdapter()

        with(binding)
        {
            rvLista.layoutManager = LinearLayoutManager(this@ListaFragment.context)
            rvLista.adapter = adapter
            btnAgregar.setOnClickListener {
                val bundle : Bundle = bundleOf(
                    "action" to "add",
                    "data" to model.contactos.value
                )
                findNavController().navigate(R.id.action_listaFragment_to_detalleFragment,bundle)
            }
        }
        model.contactos.observe(viewLifecycleOwner, Observer {
            adapter.setContactos( it )
        })
        return binding.root
    }


}