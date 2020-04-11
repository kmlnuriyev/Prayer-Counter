package com.example.firstapplication.utils;

import java.util.Collections;
import java.util.List;

public class NumberUtils {
    public static int findSmallestNumber(List<Integer> numbers) {

        Collections.sort(numbers);

        return numbers.get(0);
    }
}
