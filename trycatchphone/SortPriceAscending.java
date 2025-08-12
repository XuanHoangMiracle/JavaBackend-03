package trycatchphone;

import java.util.Comparator;

public class SortPriceAscending implements Comparator<Phone> {
    @Override
    public int compare(Phone p1, Phone p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
