

/**
 * An Solution is a solution to a knapsack Problem.
 * It is a knapsack which includes items selected to maximize the value.
 * Note that there may be more than one possible solution to each knapsack problem.
 * @author Sophie Quigley
 * @author Darren Mei
 */
public class Solution implements Cloneable{
    /**
     * Total capacity of knapsack when empty
     */
    int totalCapacity;
    /**
     * Remaining capacity with current contents
     */
    int remainingCapacity;
    /**
     * Number of possible Items which may be added to knapsack
     */
    int maxItems;
    /**
     * Actual total number of Items in knapsack
     */
    int totalItems = 0;
    /**
     * Set of items:
     * <ul>
     * <li>when ith possible Item is not included, items[i]=null;
     * <li>otherwise items[i] is an Item
     * </ul>
     */
    Item[] items;

    int totalValue;

    /**
     * Returns a new Solution representing an empty knapsack
     * @param totalcapacity Capacity of knapsack when empty
     * @param totalitems Number of possible items which may be added to knapsack
     */
    Solution ( int totalcapacity, int totalitems  ) {
        totalCapacity = totalcapacity;
        remainingCapacity = totalcapacity;
        this.maxItems = totalitems;
        items = new Item[totalitems];
        totalValue = 0;
    }

    Solution (Solution from){
        this.totalCapacity = from.totalCapacity;
        this.remainingCapacity = from.remainingCapacity;
        this.maxItems = from.maxItems;
        this.items = new Item[maxItems];
        for(int i = -1; ++i < maxItems; this.items[i]=from.items[i]);
        this.totalValue = from.totalValue;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Solution(this);
    }

    /**
     * Returns a string describing the Solution to the knapsack Problem
     * @return String description of knapsack Solution
     */
    @Override
    public String toString() {
        String result = "Solution: knapsack of capacity " + totalCapacity + " contains:\n";
        for (int i=0; i<maxItems; i++)
            if (items[i] != null)
                result += "- " + items[i]+"\n";
        result += "with a total value of " + getWorth();
        return result;
    }

    /**
     * Adds the ith Item to the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be added
     * @param item Item added
     * @return The updated knapsack
     */
    public Solution add(int i, Item item) {
        items[i] = item;
        remainingCapacity -= item.getWeight();
        totalItems++;
        return this;
    }

    /**
     * Adds the ith Item to the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be added
     * @param item Item added
     * @return The updated knapsack
     */
    public Solution add1(int i, Item item) {
        items[i] = item;
        remainingCapacity -= item.getWeight();
        totalValue += item.getValue();
        totalItems++;
        return this;
    }


    /**
     * Removes the ith Item from the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be removed
     * @return The updated knapsack
     */
    public Solution remove(int i) {
        remainingCapacity += items[i].getWeight();
        items[i] = null;
        totalItems--;
        return this;
    }

    /**
     * Removes the ith Item from the knapsack, and adjusts remaining capacity accordingly
     * @param i index of new Item to be removed
     * @return The updated knapsack
     */
    public Solution remove1(int i) {
        Item item = items[i];
        remainingCapacity += item.getWeight();
        totalValue -= item.getValue();
        items[i] = null;
        totalItems--;
        return this;
    }

    /**
     * Getter for an Item in the knapsack
     * @param i index of Item to be returned.
     * @return ith Item in knapsack
     */
    public Item getItem(int i) {
        return items[i];
    }

    /**
     * Getter for the total value of the current knapsack contents
     * @return the total value of the current contents of the knapsack
     */
    public int getWorth() {
        int result = 0;
        for (int i=0; i<maxItems; i++)
            if (items[i] != null)
                result += items[i].getValue();
        return result;
    }

    /**
     * Getter for the total value of the current knapsack contents
     * @return the total value of the current contents of the knapsack
     */
    public int getWorth1() {
        return totalValue;
    }
}
