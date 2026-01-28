
public class MyString {
    private int capacity;
    private int length;
    private char[] data;

    // Default constructor
    public MyString() {
        this.capacity = 16;
        this.length = 0;
        this.data = new char[capacity];
    }

    // Constructor with custom capacity
    public MyString(int capacity) {
        this.capacity = Math.max(capacity, 16);
        this.length = 0;
        this.data = new char[this.capacity];
    }

    // Constructor from a String
    public MyString(String text) {
        this.capacity = Math.max(text.length(), 16);
        this.length = text.length();
        this.data = new char[this.capacity];
        store(text);
    }

    // Returns character at specified index
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    // Concatenates another MyString to this one
    public void concat(MyString text) {
        int newLength = this.length + text.length;
        makeCapacity(newLength);
        for (int i = 0; i < text.length; i++) {
            this.data[this.length + i] = text.charAt(i);
        }
        this.length = newLength;
    }

    // Checks if two MyStrings are equal
    public boolean equals(MyString text) {
        if (this.length != text.length) return false;
        for (int i = 0; i < length; i++) {
            if (this.data[i] != text.charAt(i)) return false;
        }
        return true;
    }

    // Finds the index of a substring
    public int indexOf(MyString text) {
        String mainStr = this.toString();
        String subStr = text.toString();
        return mainStr.indexOf(subStr);
    }

    // Returns the length of the stored string
    public int length() {
        return length;
    }

    // Ensures the capacity is at least the given value
    public void makeCapacity(int capacity) {
        if (capacity <= this.capacity) return;
        char[] newData = new char[capacity];
        System.arraycopy(this.data, 0, newData, 0, this.length);
        this.data = newData;
        this.capacity = capacity;
    }

    // Stores a String in the MyString object
    public void store(String text) {
        makeCapacity(text.length());
        this.length = text.length();
        for (int i = 0; i < length; i++) {
            data[i] = text.charAt(i);
        }
    }

    // Stores another MyString in this MyString object
    public void store(MyString text) {
        store(text.toString());
    }

    // Returns a substring as a new MyString object
    public MyString substring(int start, int end) {
        if (start < 0 || end > length || start > end) {
            throw new StringIndexOutOfBoundsException("Invalid substring range");
        }
        return new MyString(new String(data, start, end - start));
    }

    // Converts to a standard String
    @Override
    public String toString() {
        return new String(data, 0, length);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        MyString s1 = new MyString("Hello");
        MyString s2 = new MyString(" World");
        s1.concat(s2);
        System.out.println("Concatenated: " + s1.toString());
        System.out.println("Index of 'World': " + s1.indexOf(new MyString("World")));
        System.out.println("Substring (0, 5): " + s1.substring(0, 5).toString());
        System.out.println("Equals 'Hello World': " + s1.equals(new MyString("Hello World")));
    }
}
