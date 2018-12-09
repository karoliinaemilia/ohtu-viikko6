
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Operaatio {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }
    
    @Override
    protected int laske() {
        sovellus.plus(Integer.parseInt(syotekentta.getText()));
        edellinen = Integer.parseInt(tuloskentta.getText());
        return sovellus.tulos();
    }

    @Override
    public void peru() {
        sovellus.miinus(Integer.parseInt(tuloskentta.getText())-edellinen);
        tuloskentta.setText("" + edellinen);
        
    }
    
}
