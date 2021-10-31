package com.example.contactoskotlin.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.contactoskotlin.R
import com.example.contactoskotlin.databinding.FragmentDetalleBinding
import com.example.contactoskotlin.model.Contacto
import com.example.contactoskotlin.viewmodel.ContactoViewModel
import kotlinx.coroutines.CoroutineScope

class DetalleFragment : Fragment() {

    lateinit var binding : FragmentDetalleBinding
    private lateinit var model : ContactoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        val bundle = arguments
        val model : ContactoViewModel by viewModels()
        model.contactos.value = bundle?.get("data") as ArrayList<Contacto>

        with(binding)
        {
            if( bundle != null && bundle["action"] != null){
                if( bundle["action"] == "add" ){
                    tvNombre.text = "Nuevo Contacto"
                    tvNumero.text = "Ingresa nombre y número"
                    btnSave.setOnClickListener{
                        val nombre = txtNombre.editText?.text
                        val numero = txtNumero.editText?.text.toString().toInt()
                        val newBundle : Bundle = Bundle()
                        if( !nombre!!.isEmpty() && numero is Int){
                            model.guardar( Contacto( nombre.toString(), numero ) )
                            newBundle.putSerializable(
                                "data" , model.contactos.value
                            )
                            findNavController().navigate(R.id.action_detalleFragment_to_listaFragment,newBundle)
                        }
                    }
                }
            }
            if( bundle != null && bundle["contacto"] != null ){
                val c = bundle["contacto"] as Contacto
                txtNombre.editText?.text = c.nombre as Editable
            }
            btnBack.setOnClickListener {
                findNavController().navigate(R.id.action_detalleFragment_to_listaFragment, bundleOf(
                    "data" to model.contactos.value
                ))
            }
        }
        return binding.root
    }


}