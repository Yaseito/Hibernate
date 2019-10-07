/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Zona;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloZona {

    private Session sesion;

    private void iniciaOperacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }

    private void terminaOperacion() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    public int guardaZona(Zona zona) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(zona);
        terminaOperacion();
        return id;
    }

    public void actualizaZona(Zona zona) {
        iniciaOperacion();
        sesion.update(zona);
        terminaOperacion();
    }

    public void eliminaZona(Zona zona) {
        iniciaOperacion();
        sesion.delete(zona);
        terminaOperacion();
    }

    public Zona buscarZona(int idZona) {
        Zona zona = null;

        iniciaOperacion();
        zona = (Zona) sesion.get(Zona.class, idZona);
        terminaOperacion();
        return zona;
    }

    public List<Zona> listarZona() {
        List<Zona> listaZona = null;
        iniciaOperacion();
        listaZona = sesion.createQuery("from Zona").list();
        terminaOperacion();
        return listaZona;
    }    
}
