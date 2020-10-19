
package hotel;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistas.Principal;

/**
 *
 * @author Frank Paucar
 */
public class Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf() ); // Usar este
            //UIManager.setLookAndFeel(new FlatIntelliJLaf()); // Segunda alternativa
        } catch (UnsupportedLookAndFeelException e) {
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }
    
}
