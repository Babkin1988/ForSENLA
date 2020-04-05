/*
 * Created by Alexey Babkin
 * April 2020
 */

import java.util.List;
import java.util.Arrays;

public class Program {

    public static void main(String[] args)  {
        // List of stuff for choice
        List<Item> stuff = Arrays.asList(
                new Item("hat", 1, 12),
                new Item("pistol", 4, 32),
                new Item("ball", 4, 24),
                new Item("gold", 19, 100),
                new Item("beer", 4, 10),
                new Item("milk", 5, 6),
                new Item("spoon", 1, 12),
                new Item("fork", 1, 19),
                new Item("hairbrush", 1, 1),
                new Item("boots", 6, 22),
                new Item("knife", 2, 9),
                new Item("cartridges", 6, 12)
        );
        int totalPrice = 0;
        int totalWeight = 0;
        try {
            Backpack backpack = new Backpack(stuff, 14); // You have to change tonnage to get different results
            List<Item> result = backpack.getSelectedItems();
            System.out.println("Next stuff was selected:");
            for (Item item : result) {
                totalPrice += item.getPrice();
                totalWeight += item.getWeight();
                System.out.println(item.getName());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println("Total price = " + totalPrice);
        System.out.println("Total weight = " + totalWeight);
    }
}
