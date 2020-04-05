import java.util.List;

public class Table {
    private List<List<Integer>> volume;
    private List<Integer> weight;
    private List<Integer> price;

    public List<List<Integer>> getVolume() {
        return volume;
    }

    public List<Integer> getPrice() {
        return price;
    }

    public List<Integer> getWeight() {
        return weight;
    }

    public Table (List<List<Integer>> volume, List<Integer> weight, List<Integer> price) {
        if (volume == null || weight == null || price == null)
            throw new NullPointerException();
        this.volume = volume;
        this.weight = weight;
        this.price = price;
    }
}
