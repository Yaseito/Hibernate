/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Presentacion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloPresentacion {

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

    public int guardaPresentacion(Presentacion presentacion) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(presentacion);
        terminaOperacion();
        return id;
    }

    public void actualizaPresentacion(Presentacion presentacion) {
        iniciaOperacion();
        sesion.update(presentacion);
        terminaOperacion();
    }

    public void eliminaPresentacion(Presentacion presentacion) {
        iniciaOperacion();
        sesion.delete(presentacion);
        terminaOperacion();
    }

    public Presentacion buscarPresentacion(int idPresentacion) {
        Presentacion presentacion = null;

        iniciaOperacion();
        presentacion = (Presentacion) sesion.get(Presentacion.class, idPresentacion);
        terminaOperacion();
        return presentacion;
    }

    public List<Presentacion> listarPresentacion() {
        List<Presentacion> listaPresentacion = null;
        iniciaOperacion();
        listaPresentacion = sesion.createQuery("from Presentacion").list();
        terminaOperacion();
        return listaPresentacion;
    }
}
