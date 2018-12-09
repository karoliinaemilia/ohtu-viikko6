
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Erotus extends Operaatio {

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected int laske() {
        sovellus.miinus(Integer.parseInt(syotekentta.getText()));
        edellinen = Integer.parseInt(tuloskentta.getText());
        return sovellus.tulos();
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen - Integer.parseInt(tuloskentta.getText()));
        tuloskentta.setText("" + edellinen);
    }

}
