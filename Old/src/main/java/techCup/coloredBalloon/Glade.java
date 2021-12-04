package techCup.coloredBalloon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Glade {
    private List<Glade> connections = new ArrayList<Glade>();
    private int color = 0;
    private int gladeNum;
    
    public Glade (int gladeNum) {
	this.gladeNum = gladeNum;
    }
    
    public List<Glade> getConnections () {
        return connections;
    }

    public int getColor () {
        return color;
    }

    public void setColor (int color) {
        this.color = color;
    }

    public int getGladeNum () {
        return gladeNum;
    }

    public Set<Integer> colorFinder () {
	Set<Integer> set = new TreeSet<Integer>();
	for (Glade glade : connections) {
	    for (Glade gl : glade.getConnections()) {
		set.add(gl.getColor());
	    }  
	    set.add(glade.getColor());
	}
	return set;
    }

    @Override
    public String toString () {
        return gladeNum + "";
    }
}