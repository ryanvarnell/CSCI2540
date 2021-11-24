package activity11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity11 {
    public static void main(String[] args) {
        String fileName = "activity11_input.txt";
        try {
            Scanner inputStream = new Scanner(new File(fileName));
            ArrayList<String> cities = new ArrayList<>();
            while (inputStream.hasNextLine()) {
                cities.add(inputStream.next());
            }
            treeSort(cities);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
            e.printStackTrace();
        }
    }

    public static void treeSort(ArrayList<String> list) {
        BinarySearchTree<City, String> bst = new BinarySearchTree<City, String>();
        
    }
}
