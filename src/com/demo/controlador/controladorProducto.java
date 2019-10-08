/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Presentacion;
import com.demo.modelo.entidades.Producto;
import com.demo.modelo.entidades.Proveedor;
import com.demo.modelo.entidades.Zona;
import com.demo.modelo.modeloProducto;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorProducto {
    
   public void guardaProducto(int id, String descripcion, double precio, double peso, int codigo, Marca marca, int iva, 
                                Presentacion presentacion, Proveedor proveedor, int stock, Zona zona) {

        Producto producto = new Producto();
        
        producto.setCodigo(codigo);
        producto.setDescripcionProducto(descripcion);
        producto.setIdProducto(id);
        producto.setIva(iva);
        producto.setMarca(marca);
        producto.setPeso(peso);
        producto.setPrecio(precio);
        producto.setPresentacion(presentacion);
        producto.setProveedor(proveedor);
        producto.setStock(stock);
        producto.setZona(zona);
        modeloProducto.guardaProducto(producto);
    }

    public void modificaProducto(String descripcion, double precio, double peso, int codigo, Marca marca, int iva, 
                                Presentacion presentacion, Proveedor proveedor, int stock, Zona zona, Producto producto) {
 
        producto.setCodigo(codigo);
        producto.setDescripcionProducto(descripcion);
        producto.setIva(iva);
        producto.setMarca(marca);
        producto.setPeso(peso);
        producto.setPrecio(precio);
        producto.setPresentacion(presentacion);
        producto.setProveedor(proveedor);
        producto.setStock(stock);
        producto.setZona(zona);
        modeloProducto.actualizaProducto(producto);

    }

    public void eliminaProducto(Producto producto) {
        modeloProducto.eliminaProducto(producto);
    }

    public List<Producto> listaProducto() {
        List<Producto> listaProducto = null;

        listaProducto = modeloProducto.listarProducto();

        return listaProducto;
    }

    public Producto buscaProducto(int idProducto) {
        Producto producto = null;
        producto = modeloProducto.buscarProducto(idProducto);
        return producto;
    }    
}
