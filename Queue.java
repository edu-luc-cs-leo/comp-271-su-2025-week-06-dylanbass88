public class Queue extends DynamicArray implements Comparable<Queue>, Xifo<String>, Fifo<String> {

    public void add(String e) {
        // Add to the rear (end of the array)
        super.add(e);
    } // method add

    public String peek() {
        // Return the first element without removing it
        if (getOccupancy() == 0) {
            return null;
        }
        return this.underlying[0];
    } // method peek

    public String pop() {
        // Remove and return the first element (front of the queue)
        if (getOccupancy() == 0) {
            return null;
        }
        return this.remove(0);
    } // method pop

    public String toString() {
        return "Queue contents: " + super.toString();
    } // method toString

    public int compareTo(Queue other) {
        // Compare based on occupancy (size of the queue)
        return this.getOccupancy() - other.getOccupancy();
    } // method compareTo

} // class Queue
