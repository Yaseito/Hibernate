/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.Marca;
import com.demo.modelo.Presentacion;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class controladorPresentacion {

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

    public int guardaMarca(Presentacion presentacion) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(presentacion);
        terminaOperacion();
        return id;
    }

    public void actualizaMarca(Presentacion presentacion) {
        iniciaOperacion();
        sesion.update(presentacion);
        terminaOperacion();
    }

    public void eliminaMarca(Presentacion presentacion) {
        iniciaOperacion();
        sesion.delete(presentacion);
        terminaOperacion();
    }

    public Presentacion buscarMarca(int idPresentacion) {
        Presentacion presentacion = null;

        iniciaOperacion();
        presentacion = (Presentacion) sesion.get(Presentacion.class, idPresentacion);
        terminaOperacion();
        return presentacion;
    }

    public List<Presentacion> listarMarca() {
        List<Presentacion> listaPresentacion = null;
        iniciaOperacion();
        listaPresentacion = sesion.createQuery("from Presentacion").list();
        terminaOperacion();
        return listaPresentacion;
    }    
}
