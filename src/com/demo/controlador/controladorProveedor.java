/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Proveedor;
import com.demo.modelo.modeloProveedor;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorProveedor {
    
    public void guardaProveedor(int id, String descripcion) {

        Proveedor proveedor = new Proveedor();
        proveedor.setDescripcion(descripcion);
        proveedor.setIdProveedor(id);
        modeloProveedor.guardaProveedor(proveedor);
    }

    public void modificaProveedor(String descripcion, Proveedor proveedor) {

        proveedor.setDescripcion(descripcion);
        modeloProveedor.actualizaProveedor(proveedor);

    }

    public void eliminaProveedor(Proveedor proveedor) {
        modeloProveedor.eliminaProveedor(proveedor);
    }

    public List<Proveedor> listaProveedor() {
        List<Proveedor> listaProveedor = null;

        listaProveedor = modeloProveedor.listarProveedor();

        return listaProveedor;
    }

    public Proveedor buscaProveedor(int idProveedor) {
        Proveedor proveedor = null;
        proveedor = modeloProveedor.buscarProveedor(idProveedor);
        return proveedor;
    }    
}
