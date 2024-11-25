package com.exampI.proyecto5.vista

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.exampI.proyecto5.databinding.ProductoBinding
import com.exampI.proyecto5.modelo.Producto

/*
Esta clase está especializada en transportar una vista "producto.xml"
que se va a ver en el RecycleView

El constructor recibe como parámetro la mochila binding de "producto.xml", y
le pasamos al padre con "super" el root de la mochila binding
*/



class ProductoHolder(val binding: ProductoBinding) : RecyclerView.ViewHolder(binding.root){

    //el producto que se ve en "producto.xml"
    lateinit var producto: Producto

    //este método pone los datos del producto "p"
    //en la interfaz de "producto.xml"

    fun mostrarProducto(p: Producto){
        producto = p
        binding.txtNombre.text = p.nombre
        binding.txtPrecio.text =
            if(p.disponibilidad)
                p.precio.toString()
            else "no disponible"
        binding.txtInformacion.text =
            "Color: ${p.informacion.color} Tallas: ${p.informacion.tallas.joinToString(",")}"

        val foto = cargarFoto("p_${p.id}")
        binding.imgProducto.setImageDrawable(foto)
    }

    fun cargarFoto(ruta:String): Drawable {
        //obtenemos el context
        val context = binding.root.context
        //obtenemos la carpeta res
        val carpetaRes = context.resources
        //obtenemos el id de la foto
        val id = carpetaRes.getIdentifier(ruta, "drawable", context.packageName)
        //cargar la imagen
        Log.d("IMAGEN", "id: $id ruta: $ruta")
        val imagen = carpetaRes.getDrawable(id, null)
        return imagen
    }
}