package com.example.contactoskotlin.adpater

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactoskotlin.R
import com.example.contactoskotlin.databinding.ContactCardBinding
import com.example.contactoskotlin.model.Contacto

class ContactoAdapter : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    private var lista : ArrayList<Contacto> = ArrayList()

    class ContactoViewHolder( val view: View ) : RecyclerView.ViewHolder( view ) {

        private val binding = ContactCardBinding.bind( view )
        fun bindData( contacto: Contacto)
        {
            binding.tvNombre.text = contacto.nombre
            binding.tvNumero.text = contacto.numero.toString()
            binding.btnEditar.setOnClickListener {

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.contact_card,parent,false)
        return ContactoViewHolder( view )
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    fun setContactos( contactos : ArrayList<Contacto> )
    {
        this.lista = contactos
        notifyDataSetChanged()
    }
}