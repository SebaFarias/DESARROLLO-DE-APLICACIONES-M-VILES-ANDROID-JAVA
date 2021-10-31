package com.example.contactoskotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactoskotlin.model.Contacto

class ContactoViewModel() : ViewModel()
{
    var contactos = MutableLiveData<ArrayList<Contacto>>()

    init{
       contactos.value = ArrayList()
    }
    fun guardar( contacto : Contacto )
    {
        contactos.value?.add( contacto )
    }

}