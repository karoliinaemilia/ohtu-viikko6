
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Operaatio {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    protected int laske() {
        sovellus.nollaa();
        edellinen = Integer.parseInt(tuloskentta.getText());
        return sovellus.tulos();
    }

    @Override
    public void peru() {
        tuloskentta.setText("" + edellinen);
    }
    
}
