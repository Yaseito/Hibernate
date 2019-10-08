/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.modeloMarca;
import org.hibernate.exception.ConstraintViolationException;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorMarca {

    public void guardaMarca(int id, String descripcion) {

        Marca marca = new Marca();
        marca.setDescripcion(descripcion);
        marca.setIdMarca(id);
        modeloMarca.guardaMarca(marca);
    }

    public void modificaMarca(String descripcion, Marca marca) {

        marca.setDescripcion(descripcion);
        modeloMarca.actualizaMarca(marca);

    }

    public void eliminaMarca(Marca marca) {
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
