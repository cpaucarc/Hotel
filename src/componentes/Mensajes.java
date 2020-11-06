package componentes;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mensajes {

    public void Exito(String mensaje) {
        try {
            final ImageIcon icon = new ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_success_msg.png"));
            JOptionPane.showMessageDialog(null, mensaje, "Correcto", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, mensaje, "Correcto", JOptionPane.INFORMATION_MESSAGE);
        }
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

    public String Entrada(String mensaje) {               
        try {
            String rsta = JOptionPane.showInputDialog(null, mensaje, "Entrada", JOptionPane.QUESTION_MESSAGE);
            if (rsta.isEmpty()) {
                return null;
            }
            return rsta;
        } catch (NullPointerException e) {
            return null;
        }
    }

}
