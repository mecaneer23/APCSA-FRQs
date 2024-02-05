import java.util.ArrayList;

public class FRQ1_2010_CookieOrder {
    public static void main(String[] args) {
        MasterOrder goodies = new MasterOrder();

        goodies.addOrder(new CookieOrder("Chocolate Chip", 1));
        goodies.addOrder(new CookieOrder("Shortbread", 5));
        goodies.addOrder(new CookieOrder("Macaroon", 2));
        goodies.addOrder(new CookieOrder("Chocolate Chip", 3));

        System.out.println();
        System.out.println(goodies);

        goodies.removeVariety("Chocolate Chip");

        System.out.println();
        System.out.println(goodies);

        System.out.println();

    }
}

class MasterOrder {
    private ArrayList<CookieOrder> orders;

    public MasterOrder() {
        orders = new ArrayList<CookieOrder>();
    }

    public int getTotalBoxes() {
        int sum = 0;
        for (CookieOrder cookieOrder : orders) {
            sum += cookieOrder.getNumBoxes();
        }
        return sum;
    }

    public int removeVariety(String cookieVar) {
        int sum = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getVariety().equals(cookieVar)) {
                sum += orders.get(i).getNumBoxes();
                orders.remove(i);
                i--;
            }
        }
        return sum;
    }

    public void addOrder(CookieOrder theOrder) {
        orders.add(theOrder);
    }

    public String toString() {
        String output = "---MASTER ORDER---\n";

        for (CookieOrder c : orders) {
            output += c + "\n";
        }

        return output + "---END MASTER ORDER---";
    }
}

class CookieOrder {
    private String variety;
    private int numBoxes;

    public CookieOrder(String theVariety, int theNumBoxes) {
        variety = theVariety;
        numBoxes = theNumBoxes;
    }

    public String getVariety() {
        return variety;
    }

    public int getNumBoxes() {
        return numBoxes;
    }

    public void setVariety(String theVariety) {
        variety = theVariety;
    }

    public void setNumBoxes(int theNumBoxes) {
        numBoxes = theNumBoxes;
    }

    public String toString() {
        return String.format("{ CookieOrder - variety: %s,  numBoxes: %d }",
                variety, numBoxes);
    }

}