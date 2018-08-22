package az.mm.displaymenu;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Submenu {
    
    private final int from;
    private final int to;
    private final String name;
    private boolean visited;

    public Submenu(int from, int to, String name) {
        this.from = from;
        this.to = to;
        this.name = name;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public String name() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
