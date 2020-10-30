package componentes;

import javax.swing.JOptionPane;

public class Mensajes {

    public void Exito(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Error(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void Advertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public int Pregunta(String pregunta) {
        return JOptionPane.showConfirmDialog(null, pregunta, "Pregunta", JOptionPane.YES_NO_OPTION);
    }
    
}
