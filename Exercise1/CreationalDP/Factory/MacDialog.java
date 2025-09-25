package Exercise1.CreationalDP.Factory;

public class MacDialog extends DialogFactory {
    public Button createButton() {
        return new MacButton();
    }
}