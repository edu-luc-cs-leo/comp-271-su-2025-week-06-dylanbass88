public class Stack extends DynamicArray implements Comparable<Stack>, Xifo<String>, Lifo<String> {

    public void push(String e) {
        // Push to the front: shift everything to the right
        if (getOccupancy() == this.underlying.length) {
            this.resize();
        }
        for (int i = getOccupancy(); i > 0; i--) {
            this.underlying[i] = this.underlying[i - 1];
        }
        this.underlying[0] = e;
        this.occupancy++;
    } // method push

    public String peek() {
        // Return the first element without removing it
        if (getOccupancy() == 0) {
            return null;
        }
        return this.underlying[0];
    } // method peek

    public String pop() {
        // Remove and return the first element
        if (getOccupancy() == 0) {
            return null;
        }
        return this.remove(0);
    } // method pop

    public String toString() {
        return "Stack contents: " + super.toString();
    } // method toString

    public int compareTo(Stack other) {
        // Compare based on occupancy (size of the stack)
        return this.getOccupancy() - other.getOccupancy();
    } // method compareTo

} // class Stack
