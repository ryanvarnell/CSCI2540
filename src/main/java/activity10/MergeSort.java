package activity10;

import java.util.ArrayList;

/**
 * @author Ryan Varnell
 * @author Deidre Whitehead
 */
public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(2);
        list.add(15);
        list.add(20);
        list.add(65);
        list.add(43);
        list.add(94);
        list.add(17);

        list = mergeSort(list);

        System.out.println(list);
    }
    public static ArrayList<Integer> merge(ArrayList<Integer> first, ArrayList<Integer> second) {
        int end = first.get(first.size() - 1);
        int start = second.get(0);

        if (end < start) {
            first.addAll(second);
            return first;
        } else {
            second.addAll(first);
            return second;
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        int size = list.size();
        ArrayList<Integer> first = new ArrayList<>(list.subList(0, size / 2));
        ArrayList<Integer> second = new ArrayList<>(list.subList(size / 2, size));

        if (first.size() != 1)
            first = mergeSort(first);

        else if (second.size() != 1)
            second = mergeSort(second);

        return merge(first, second);
    }
}
