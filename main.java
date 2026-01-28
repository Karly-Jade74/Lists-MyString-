import MyString.java;
import settings.json;

public class Main {
    public static void main(String[] args) {
        MyString str1 = new MyString("Hello");
        MyString str2 = new MyString(" World");

        str1.concat(str2);
        System.out.println("Concatenated String: " + str1.toString());
        
        System.out.println("Character at index 1: " + str1.charAt(1));
        System.out.println("Index of 'World': " + str1.indexOf(new MyString("World")));
        System.out.println("Substring (0, 5): " + str1.substring(0, 5).toString());
        System.out.println("Length: " + str1.length());
    }
}
