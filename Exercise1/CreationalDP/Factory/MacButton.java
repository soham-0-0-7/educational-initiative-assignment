package Exercise1.CreationalDP.Factory;

public class MacButton implements Button {
    public void render() { System.out.println("Rendering a button in macOS style."); }
    public void onClick() { System.out.println("macOS button clicked!"); }
}