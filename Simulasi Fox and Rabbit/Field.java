import java.util.ArrayList;
import java.util.List;

public class Field {

    private Object[][] field;

    public Field(int depth, int width) {
        field = new Object[depth][width];
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location) {
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }


    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location);

        for (Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        return free.isEmpty() ? null : free.get(0);
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();

        int row = location.getRow();
        int col = location.getCol();
    
        addLocation(locations, row - 1, col);
        addLocation(locations, row + 1, col); 
        addLocation(locations, row, col - 1); 
        addLocation(locations, row, col + 1);
    
        return locations;
        
    }
    
    private void addLocation(List<Location> locations, int row, int col) {
        if (row >= 0 && row < field.length && col >= 0 && col < field[0].length) {
            locations.add(new Location(row, col));
        }
    }
    
    public void printField() {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[0].length; c++) {
    
                if (field[r][c] instanceof Rabbit) {
                    System.out.print(" R ");
                }
                else if (field[r][c] instanceof Fox) {
                    System.out.print(" F ");
                }
                else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

}
