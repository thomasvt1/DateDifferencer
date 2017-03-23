
public class App {
	
	private static Window w;
	
	public static void main(String[] args) {
		
		w = new Window();
		w.launchWindow();
		
	}

	public static Window getW() {
		return w;
	}
}