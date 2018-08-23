package az.mm.displaymenu;

import java.util.List;
import java.util.Map;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Main {
    
    private final Map<Integer, List<Submenu>> adjMap;

    public Main() {
        adjMap = DBConnection.getMenu();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.displayMenu(0, "", "", "MENU");
    }
    
    void displayMenu(int pId, String padding, String rowNum, String name) {
        System.out.printf("%s%s %s%n", padding, rowNum, name);
        int row = 1;
        if(adjMap.get(pId) != null)
            for (Submenu s: adjMap.get(pId)) 
                if (!s.isVisited()) {
                    s.setVisited(true);
                    String newPadding = padding + "\t";
                    String newRowNum = "".equals(rowNum) ? String.valueOf(row++) : (rowNum + "." + row++);
                    displayMenu(s.to(), newPadding, newRowNum, s.name());
                }
    }
}
