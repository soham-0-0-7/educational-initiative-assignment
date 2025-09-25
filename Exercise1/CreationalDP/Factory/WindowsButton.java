package Exercise1.CreationalDP.Factory;

public class WindowsButton implements Button {
    public void render() { System.out.println("Rendering a button in Windows style."); }
    public void onClick() { System.out.println("Windows button clicked!"); }
}