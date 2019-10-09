/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.modelo;

import com.demo.modelo.entidades.Marca;
import com.demo.modelo.entidades.Presentacion;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Hijos
 */
public class modeloPresentacion {

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

    static public int guardaPresentacion(Presentacion presentacion) {
        int id = presentacion.getIdPresentacion();
        try {
            iniciaOperacion();
            id = (int) sesion.save(presentacion);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return id;
    }

    static public void actualizaPresentacion(Presentacion presentacion) {
        try {
            iniciaOperacion();
            sesion.update(presentacion);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public void eliminaPresentacion(Presentacion presentacion) {
        try {
            iniciaOperacion();
            sesion.delete(presentacion);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    static public Presentacion buscarPresentacion(int idPresentacion) {
        Presentacion presentacion = null;
        try {
            iniciaOperacion();
            presentacion = (Presentacion) sesion.get(Presentacion.class, idPresentacion);
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return presentacion;
    }

    static public List<Presentacion> listarPresentacion() {
        List<Presentacion> listaPresentacion = null;
        try {
            iniciaOperacion();
            listaPresentacion = sesion.createQuery("from Presentacion").list();
            terminaOperacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return listaPresentacion;
    }
}
