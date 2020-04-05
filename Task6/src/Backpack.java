import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Backpack {

    private List<Item> stuff;
    private int tonnage;

    public int getTonnage() {
        return tonnage;
    }

    private List<Integer> getWeight() {
        List<Integer> weight = new ArrayList<Integer>();
        for (Item item : this.stuff) {
            weight.add(item.getWeight());
        }
        return weight;
    }

    private List<Integer> getPrice() {
        List<Integer> price = new ArrayList<Integer>();
        for (Item item : this.stuff) {
            price.add(item.getPrice());
        }
        return price;
    }

    private Table getMemtable() throws IndexOutOfBoundsException {
        List<Integer> weight = getWeight();
        List<Integer> price = getPrice();
        List<List<Integer>> volume = new ArrayList();
        try {
            for (int i = 0; i < this.stuff.size() + 1; ++i) {
                volume.add(Arrays.stream(new int[this.tonnage + 1]).boxed().collect(Collectors.toList())); // array of zeros
            }
            for (int i = 0; i < this.stuff.size() + 1; ++i) {
                for (int a = 0; a < this.tonnage + 1; ++a) {
                    if (i == 0 || a == 0) {
                        volume.get(i).set(a, 0);
                    } else {
                        if (weight.get(i - 1) <= a) {
                            volume.get(i).set(a, Math.max(price.get(i - 1) + volume.get(i - 1).get(a - weight.get(i - 1))
                                    , volume.get(i - 1).get(a)));
                        } else {
                            volume.get(i).set(a, volume.get(i - 1).get(a));
                        }
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("It`s a bug of getMemtable() method");
        }
        return new Table(volume, weight, price);
    }

    public List<Item> getSelectedItems() throws IndexOutOfBoundsException {
        List<Item> itemsList = new ArrayList();
        try {
            Table  table = getMemtable();
            int n = this.stuff.size();
            int res = table.getVolume().get(n).get(this.tonnage);
            int a = this.tonnage;
            for (int i = n; i >= 1; --i) {
                if (res <= 0) break;
                if (res == table.getVolume().get(i - 1).get(a)) continue;
                else {
                    itemsList.add(this.stuff.get(i - 1));
                    res -= table.getPrice().get(i - 1);
                    a -= table.getWeight().get(i - 1);
                }
            }
        }
        catch (IndexOutOfBoundsException ex) {
            throw ex;
        }
        return itemsList;
    }

    public Backpack (List<Item> stuff, int tonnage) {
        if (stuff == null) throw new NullPointerException("List of stuff is empty!");
        this.stuff = stuff;
        this.tonnage = tonnage;
    }

}
