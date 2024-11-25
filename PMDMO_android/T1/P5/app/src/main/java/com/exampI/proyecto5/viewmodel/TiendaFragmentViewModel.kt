package com.exampI.proyecto5.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.exampI.proyecto5.modelo.Producto
import com.exampI.proyecto5.modelo.Tienda

class TiendaFragmentViewModel: ViewModel() {
    var productos : List<Producto> = emptyList()

    fun cargarProductos(context: Context){
        productos = Tienda.cargarDatos(context).stock
    }
}