package componentes;

import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Validador {
    
    public boolean validarCampo(JTextField campo){
        return !campo.getText().isEmpty();
    }
    
    public boolean validarCampoConLongitud(JTextField campo, int longitud){
        return campo.getText().length() == longitud;
    }
    
    public boolean validarCombo(JComboBox combo){
        return combo.getSelectedIndex() > 0;
    }
    
    public boolean validarFechas(Date fecha1, Date fecha2){
        if (fecha1 != null && fecha2 != null){
            return fecha2.compareTo(fecha1) > 0;
        }else{
            return false;
        }
    }
    
}
