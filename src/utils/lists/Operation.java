package utils.lists;

import java.util.ArrayList;

public class Operation {
    public static ArrayList<Integer> sum(ArrayList<Integer> a, ArrayList<Integer> b) throws Exception {
        if (a.size() != b.size()) {
            throw new Exception("Incompatible elements");
        }
        ArrayList<Integer> result = new ArrayList<>(a.size());
        for (int k = 0; k < a.size(); k++) {
            result.add(a.get(k) + b.get(k));
        }
        return result;
    }

    public static ArrayList<Integer> substract(ArrayList<Integer> a, ArrayList<Integer> b) throws Exception {
        if (a.size() != b.size()) {
            throw new Exception("Incompatible elements");
        }
        ArrayList<Integer> result = new ArrayList<>(a.size());
        for (int k = 0; k < a.size(); k++) {
            result.add(a.get(k) - b.get(k));
        }
        return result;
    }

    public static ArrayList<Integer> scalarMultiplication(int a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>(b.size());
        for (Integer integer : b) {
            result.add(a * integer);
        }
        return result;
    }
}
