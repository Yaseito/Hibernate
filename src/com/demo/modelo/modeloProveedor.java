/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloProveedor {

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

    public int guardaProveedor(Proveedor proveedor) {
        int id = 0;
        iniciaOperacion();
        id = (int) sesion.save(proveedor);
        terminaOperacion();
        return id;
    }

    public void actualizaProveedor(Proveedor proveedor) {
        iniciaOperacion();
        sesion.update(proveedor);
        terminaOperacion();
    }

    public void eliminaProveedor(Proveedor proveedor) {
        iniciaOperacion();
        sesion.delete(proveedor);
        terminaOperacion();
    }

    public Proveedor buscarProveedor(int idProveedor) {
        Proveedor proveedor = null;

        iniciaOperacion();
        proveedor = (Proveedor) sesion.get(Proveedor.class, idProveedor);
        terminaOperacion();
        return proveedor;
    }

    public List<Proveedor> listarProveedor() {
        List<Proveedor> listaProveedor = null;
        iniciaOperacion();
        listaProveedor = sesion.createQuery("from Proveedor").list();
        terminaOperacion();
        return listaProveedor;
    }    
}
