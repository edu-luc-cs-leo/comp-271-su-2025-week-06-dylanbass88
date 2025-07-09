/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    protected String[] underlying;

    /** How many elements have been added to the underlying array */
    protected int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        this.underlying = new String[size];
        this.occupancy = 0;
    }

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    }

    /** Simple accessor for occupancy */
    public int getOccupancy() {
        return this.occupancy;
    }

    /** Resize the underlying array as needed. */
    protected void resize() {
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    }

    /** Adds a new item to the array. */
    public void add(String string) {
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    }

    /** Method to find the position of an element in the underlying array */
    public int indexOf(String string) {
        int i = 0;
        while (i < this.occupancy && !this.underlying[i].equals(string)) {
            i++;
        }
        return (i == this.occupancy) ? -1 : i;
    }

    /** Tells if a string exists in the array */
    public boolean contains(String string) {
        return this.indexOf(string) > -1;
    }

    /** Counts how many times a string appears in the array */
    public int countOf(String string) {
        int counter = 0;
        if (string != null) {
            for (int i = 0; i < this.occupancy; i++) {
                if (string.equals(this.underlying[i])) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    /** Removes an item by index */
    public String remove(int index) {
        String removed = null;
        if (this.occupancy > 0 && index > -1 && index < this.occupancy) {
            removed = this.underlying[index];
            for (int i = index; i < this.occupancy - 1; i++) {
                this.underlying[i] = this.underlying[i + 1];
            }
            this.underlying[this.occupancy - 1] = null;
            this.occupancy -= 1;
        }
        return removed;
    }

    /** Removes the first occurrence of a string */
    public String remove(String string) {
        return this.remove(this.indexOf(string));
    }

    private static final String EMPTY_ARRAY = "The underlying array is empty.";
    private static final String FMT_HEADER = "Underlying array occupancy/length: %d/%d.\n[ %s";
    private static final String FMT_ELEMENT = ", %s";
    private static final String FMT_FOOTER = " ]";

    /** String representation of the object */
    public String toString() {
        StringBuilder sb = new StringBuilder(EMPTY_ARRAY);
        if (this.occupancy > 0) {
            sb = new StringBuilder(
                String.format(FMT_HEADER, this.occupancy, this.underlying.length, this.underlying[0]));
            for (int i = 1; i < this.occupancy; i++) {
                sb.append(String.format(FMT_ELEMENT, this.underlying[i]));
            }
            sb.append(FMT_FOOTER);
        }
        return sb.toString();
    }
}
