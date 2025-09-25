package Exercise1.CreationalDP.Factory;

public class WindowsDialog extends DialogFactory {
    public Button createButton() {
        return new WindowsButton();
    }
}