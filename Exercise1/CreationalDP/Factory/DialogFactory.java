package Exercise1.CreationalDP.Factory;

public abstract class DialogFactory {
    public abstract Button createButton();

    public void renderDialog() {
        Button okButton = createButton();
        okButton.render();
    }
}