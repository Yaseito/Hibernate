/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controlador;

import com.demo.modelo.Marca;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class controladorMarca {

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

    public int guardaMarca(Marca marca) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(marca);
        terminaOperacion();
        return id;
    }

    public void actualizaMarca(Marca marca) {
        iniciaOperacion();
        sesion.update(marca);
        terminaOperacion();
    }

    public void eliminaMarca(Marca marca) {
        iniciaOperacion();
        sesion.delete(marca);
        terminaOperacion();
    }

    public Marca buscarMarca(int idMarca) {
        Marca marca = null;

        iniciaOperacion();
        marca = (Marca) sesion.get(Marca.class, idMarca);
        terminaOperacion();
        return marca;
    }

    public List<Marca> listarMarca() {
        List<Marca> listaMarca = null;
        iniciaOperacion();
        listaMarca = sesion.createQuery("from Marca").list();
        terminaOperacion();
        return listaMarca;
    }
}
