package competition.kitchen;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int numAllCustomers = in.nextInt(); // ALL CLIENTS
        List<String> customerItems = new ArrayList<>();
        List<Integer> customerAwards = new ArrayList<>();

        for (int i = 0; i < numAllCustomers; i++) {
            customerItems.add(in.next()); // the food the customer is waiting for DISH BLUEBERRIES ICE_CREAM
            customerAwards.add(in.nextInt()); // the number of points awarded for delivering the food
        }

        // KITCHEN INPUT
        Kitchen k = new Kitchen();
        k.init(in);

        // GAME LOOP
        while (true) {
            int turnsRemaining = in.nextInt();
            // PLAYERS INPUT
            int playerX = in.nextInt();
            int playerY = in.nextInt();
            String playerItem = in.next();

            int partnerX = in.nextInt();
            int partnerY = in.nextInt();
            String partnerItem = in.next();

            int numTablesWithItems = in.nextInt();

            for (int i = 0; i < numTablesWithItems; i++) {
                int tableX = in.nextInt();
                int tableY = in.nextInt();
                String item = in.next();
                k.addItemAtTable(new Position(tableX,tableY),item);

            }

            // oven to ignore until bronze
            String ovenContents = in.next();
            int ovenTimer = in.nextInt();

            // CURRENT CUSTOMERS INPUT
            int numCustomers = in.nextInt();

            for (int i = 0; i < numCustomers; i++) {
                String customerItem = in.next();
                int customerAward = in.nextInt();
            }

            final Position playerP = new Position(playerX,playerY);
            final Position partnerP = new Position(partnerX,partnerY);

            // GAME LOGIC
            // fetch dish, then blueberries, then ice cream, then drop it at first empty table
            if (!playerItem.contains("DISH")) {
                Table table = k.tables.stream().filter(t -> t.isDish()).findFirst().get();
                table.use();
            }
            else if (!playerItem.contains("BLUEBERRIES")) {
                k.tables.stream().filter(t -> t.isBlueBerries()).findFirst().get().use();
            }
            else if (!playerItem.contains("ICE_CREAM")) {
                k.tables.stream().filter(t -> t.isIceCream()).findFirst().get().use();
            }
            else {
                // Get position of Window :
                Position window = k.tables.stream().filter(Table::isWindow).findFirst().get().p;

                // Get to the nearest between partner and bell :
                if(partnerP.distance(playerP) < playerP.distance(window)) {

                    if (partnerItem.contains("DISH")) {
                        System.out.println("USE " + window.x + " "+ window.y + "; Java Starter AI");
                        //k.tables.stream().filter(t -> t.isEmpty()).sorted(Comparator.comparing(t -> t.p.distance(playerP))).findFirst().get().use();
                    } else {
                        // drop next to partner if partner has no dish !
                        k.tables.stream().filter(t -> t.isEmpty()).sorted(Comparator.comparing(t -> t.p.distance(partnerP))).findFirst().get().use();
                    }
                }
                else {
                    // head to the Window !!
                    System.out.println("USE " + window.x + " "+ window.y + "; Java Starter AI");
                }

            }
        }
    }
}

class Kitchen {

    List<Table> tables;

    public Kitchen() {
        tables = new ArrayList<Table>();
    }

    public void init(Scanner in) {
        in.nextLine();
        for (int i = 0; i < 7; i++) {
            String kitchenLine = in.nextLine();
            for (int j = 0; j < kitchenLine.length(); j++) {
                char c = kitchenLine.charAt(j);
                TableType t = TableType.get(c);
                if (t != null) {
                    tables.add(new Table(t, new Position(j, i)));
                }
            }
            System.err.println(kitchenLine);
        }
    }

    public void addItemAtTable(Position p, String item) {

        if(item.contains("DISHES")) {

            tables.forEach(t -> {
                if (t.p == p) {
                    t.updateItem(TableType.PLATES);

                }
            });
        }
    }
}

class Position {

    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int distance(Position p) {

        return (int)Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2));
    }


}

class Table {

    TableType type;

    Position p;

    public Table(TableType t, Position p) {
        type = t;
        this.p = p;
    }

    public void error() {
        System.err.println("Table of type "+type+" at "+p.x+" "+p.y);
    }

    public boolean isDish() {
        return isTableType(TableType.PLATES);
    }

    public boolean isBlueBerries() {
        return isTableType(TableType.BLUEBERRY);
    }

    public boolean isIceCream() {
        return isTableType(TableType.ICE_CREAM);
    }

    public boolean isEmpty() {
        return isTableType(TableType.EMPTY);
    }

    public boolean isWindow() {
        return isTableType(TableType.WINDOW);
    }

    private boolean isTableType(TableType t) {
        return type.equals(t);
    }

    public void use() {
        System.out.println("USE "+p.x+" "+p.y+"; Java Starter AI");
    }

    public void updateItem(TableType tp) {
        this.type = tp;
    }
}

enum TableType {

    BLUEBERRY,
    ICE_CREAM,
    PLATES,
    EMPTY,
    WINDOW;

    static TableType get(Character c) {
        switch (c) {
            case 'D':
                return PLATES;
            case 'B':
                return BLUEBERRY;
            case 'I':
                return ICE_CREAM;
            case 'W':
                return WINDOW;
            case '#':
                return EMPTY;

        }
        return null;
    }
}