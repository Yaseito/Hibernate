/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Presentacion;
import com.demo.modelo.modeloPresentacion;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorPresentacion {

    public void guardaPresentacion(int id, String descripcion) {

        Presentacion presentacion = new Presentacion();
        presentacion.setDescripcion(descripcion);
        presentacion.setIdPresentacion(id);
        modeloPresentacion.guardaPresentacion(presentacion);
    }

    public void modificaPresentacion(String descripcion, Presentacion presentacion) {

        presentacion.setDescripcion(descripcion);
        modeloPresentacion.actualizaPresentacion(presentacion);

    }

    public void eliminaPresentacion(Presentacion presentacion) {
        modeloPresentacion.eliminaPresentacion(presentacion);
    }

    public List<Presentacion> listaPresentacion() {
        List<Presentacion> listaPresentacion = null;

        listaPresentacion = modeloPresentacion.listarPresentacion();

        return listaPresentacion;
    }

    public Presentacion buscaPresentacion(int idPresentacion) {
        Presentacion presentacion = null;
        presentacion = modeloPresentacion.buscarPresentacion(idPresentacion);
        return presentacion;
    }
}
