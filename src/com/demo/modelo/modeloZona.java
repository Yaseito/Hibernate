/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Proveedor;
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

   static private Session sesion;

    static private void iniciaOperacion() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }

    static private void terminaOperacion() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    static public int guardaZona(Zona zona) {
        int id = zona.getIdZona();

        iniciaOperacion();
        id = (int) sesion.save(zona);
        terminaOperacion();

        return id;
    }

    static public void actualizaZona(Zona zona) {
        iniciaOperacion();
        sesion.update(zona);
        terminaOperacion();
    }

    static public void eliminaZona(Zona zona) {
        iniciaOperacion();
        sesion.delete(zona);
        terminaOperacion();
    }

    static public Zona buscarZona(int idZona) {
        Zona zona = null;

        iniciaOperacion();
        zona = (Zona) sesion.get(Zona.class, idZona);
        terminaOperacion();
        return zona;
    }

    static public List<Zona> listarZona() {
        List<Zona> listaZona = null;
        iniciaOperacion();
        listaZona = sesion.createQuery("from Zona").list();
        terminaOperacion();
        return listaZona;
    }
}
