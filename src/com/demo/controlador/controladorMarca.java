/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.modeloMarca;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorMarca {

    public int guardaMarca(String descripcion) {
        int id = 0;

        Marca marca = new Marca();
        marca.setDescripcion(descripcion);
        id = modeloMarca.guardaMarca(marca);
        return id;
    }

    public void modificaMarca(String descripcion) {
        
        Marca marca = null;
        marca.setDescripcion(descripcion);
        modeloMarca.actualizaMarca(marca);

    }

    public void eliminaMarca(String descripcion) {
        Marca marca = null;
        marca.setDescripcion(descripcion);
        modeloMarca.eliminaMarca(marca);
    }

    public List<Marca> listaMarca() {
        List<Marca> listaMarca = null;

        listaMarca = modeloMarca.listarMarca();

        return listaMarca;
    }
    
    public Marca buscaMarca(int idMarca){
        Marca marca = null;
        marca = modeloMarca.buscarMarca(idMarca);
        return marca;
    }
}
