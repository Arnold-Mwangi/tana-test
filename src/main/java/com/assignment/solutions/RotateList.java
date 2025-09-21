package com.assignment.solutions;

import java.util.Collections;
import java.util.LinkedList;

public class RotateList {

    /**
     * Rotates a LinkedList n times to the right.
     * @param list the LinkedList to rotate
     * @param n number of steps to rotate
     * @return the rotated LinkedList
     */
    public static LinkedList<String> rotateRight(LinkedList<String> list, int n) {
        if (list == null || list.isEmpty()) {
            return list;
        }

        // modulate n by the list size.
        n = ((n % list.size()) + list.size()) % list.size();


        Collections.rotate(list, n);
        return list;
    }

}
