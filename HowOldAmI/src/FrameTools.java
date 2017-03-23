import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

public class FrameTools {
	
	private HashMap<String, Component> componentMap = new HashMap<String, Component>(); 
	private JFrame frame;
	
	public FrameTools(JFrame frame) {
		super();
		this.frame = frame;
		fillComponentMap();
	}

	public List<Component> getAllComponents() {
		return (getAllComponents(frame.getContentPane()));
	}
	
	public Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
	}
	
	private List<Component> getAllComponents(Container c) {
	    Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container)
	            compList.addAll(getAllComponents((Container) comp));
	    }
	    return compList;
	}
	
	private void fillComponentMap() {
		for (Component c: getAllComponents()) {
			componentMap.put(c.getName(), c);
		}
	}
}