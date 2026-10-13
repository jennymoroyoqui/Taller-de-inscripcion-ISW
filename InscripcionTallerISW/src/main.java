
import controller.InscripcionController;
import controller.TallerController;
import javax.swing.SwingUtilities;
import view.FrmTalleres;

public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TallerController tallerController = new TallerController();
            InscripcionController inscripcionController = new InscripcionController();
            FrmTalleres frm = new FrmTalleres(tallerController, inscripcionController);
            frm.setVisible(true);
        });
    }
}
