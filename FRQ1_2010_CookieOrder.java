import java.util.ArrayList;

public class FRQ1_2010_CookieOrder {
    public static void main(String[] args) {
        throw new UnsupportedOperationException("Tester not implemented yet");
    }
}

class MasterOrder {
    private ArrayList<CookieOrder> orders;

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

}