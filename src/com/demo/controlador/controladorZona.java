/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.entidades.Zona;
import com.demo.modelo.modeloZona;
import java.util.List;

/**
 *
 * @author Hijos
 */
public class controladorZona {

    public void guardaZona(int id, String descripcion) {

        Zona zona = new Zona();
        zona.setDescripcion(descripcion);
        zona.setIdZona(id);
        modeloZona.guardaZona(zona);
    }

    public void modificaZona(String descripcion, Zona zona) {

        zona.setDescripcion(descripcion);
        modeloZona.actualizaZona(zona);

    }

    public void eliminaZona(Zona zona) {
        modeloZona.eliminaZona(zona);
    }

    public List<Zona> listaZona() {
        List<Zona> listaZona = null;

        listaZona = modeloZona.listarZona();

        return listaZona;
    }

    public Zona buscaZona(int idZona) {
        Zona zona = null;
        zona = modeloZona.buscarZona(idZona);
        return zona;
    }
}
