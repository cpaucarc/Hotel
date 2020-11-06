/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import Conexion.Control;
import Database.Controller;
import java.sql.SQLException;

/**
 *
 * @author Frank Paucar
 */
public interface Interfaz {
    
    Mensajes msg = new Mensajes();
    Validador vld = new Validador();
    Controller control = Control.getControl();
    
    public void configuracion() throws SQLException;
    public boolean camposLlenos();
    public void limpiarCampos();
    
}
