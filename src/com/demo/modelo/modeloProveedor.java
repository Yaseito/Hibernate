/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Presentacion;
import com.demo.modelo.entidades.Proveedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloProveedor {

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

    static public int guardaProveedor(Proveedor proveedor) {
        int id = proveedor.getIdProveedor();
        try {
            iniciaOperacion();
            id = (int) sesion.save(proveedor);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return id;
    }

    static public void actualizaProveedor(Proveedor proveedor) {
        try {
            iniciaOperacion();
            sesion.update(proveedor);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public void eliminaProveedor(Proveedor proveedor) {
        try {
            iniciaOperacion();
            sesion.delete(proveedor);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public Proveedor buscarProveedor(int idProveedor) {
        Proveedor proveedor = null;
        try {
            iniciaOperacion();
            proveedor = (Proveedor) sesion.get(Proveedor.class, idProveedor);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return proveedor;
    }

    static public List<Proveedor> listarProveedor() {
        List<Proveedor> listaProveedor = null;
        try {
            iniciaOperacion();
            listaProveedor = sesion.createQuery("from Proveedor").list();
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return listaProveedor;
    }
}
