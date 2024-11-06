import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}


public class KnapsackFractional {
    public static double fractionKnapsack(Item[] items,int capacity){
        
        // sort  profit/ weight ratio in acceding order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double ratio1 = (double) o1.value / o1.weight;
                double ratio2 = (double) o2.value / o2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });

        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take the whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take the fractional part of the item
                totalValue += item.value * ((double) capacity / item.weight);
                break; // Knapsack is full
            }
        }
        return  totalValue;
    }

    public static void main(String[] args) {
        Item []items={
            new Item(10, 60),
            new Item(20, 10),
            new Item(30, 30),
        };
        int capacity=45;

        double maxProfit=fractionKnapsack(items,capacity);
        System.out.println(maxProfit);
    }
    
}
