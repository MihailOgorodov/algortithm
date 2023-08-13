/*
package org.example.sem1;

import java.util.Random;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int upper = 1000000;

        Random rand = new Random();
        int x = rand.nextInt(upper + 1);

        perebor(x);
        randomGuess(x);
        smartRandomGuess(x);
        fromList(x);
        binarySearch(x);
    }

    public static void perebor(int x) {
        long start = System.currentTimeMillis();
        for (int i = 0; i <= upper; i++) {
            if (i == x) {
                break;
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Число отгадано и это " + i + " за " + (fin - start) + " итераций");
        System.out.println("Время выполнения " + (fin - start) + " миллисекунд");
        System.out.println();
    }

    public static void random_guess(int x) {
        long start = System.currentTimeMillis();
        int k = 1;
        Random rand = new Random();
        int num = rand.nextInt(upper + 1);
        while (x != num) {
            num = rand.nextInt(upper + 1);
            k++;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Число отгадано и это " + num + " за " + k + " итераций");
        System.out.println("Время выполнения " + (fin - start) + " миллисекунд");
        System.out.println();
    }

    public static void smart_random_guess(int x) {
        long start = System.currentTimeMillis();
        int k = 1;
        Random rand = new Random();
        int num = rand.nextInt(upper + 1);
        HashSet<Integer> s = new HashSet<>();
        while (x != num) {
            while (s.contains(num)) {
                num = rand.nextInt(upper + 1);
            }
            s.add(num);
            k++;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Число отгадано и это " + num + " за " + k + " итераций");
        System.out.println("Время выполнения " + (fin - start) + " миллисекунд");
        System.out.println();
    }

    public static void fromList(int x) {
        long start = System.currentTimeMillis();
        int k = 0;
        List<Integer> sp = new ArrayList<>();
        for (int i = 0; i <= upper; i++) {
            sp.add(i);
        }
        Integer a = null;
        while (!x.equals(a)) {
            int index = new Random().nextInt(sp.size());
            a = sp.remove(index);
            k++;
        }
        long fin = System.currentTimeMillis();
        System.out.println("Число отгадано и это " + a + " за " + k + " итераций");
        System.out.println("Время выполнения " + (fin - start) + " мс");
        System.out.println();
    }

    public static void binarySearch(int x) {
        long start = System.currentTimeMillis();
        int k = 1;
        int left = 0;
        int right = upper;
        int current = Math.round((right + left) / 2);
        while (current != x) {
            if (current < x) {
                left = current + 1;
            } else {
                right = current - 1;
            }
            current = Math.round((right + left) / 2);
            k++;
            // System.out.println("Left: " + left + " Right: " + right + " Current: " + current);
            // Scanner scanner = new Scanner(System.in);
            // scanner.nextLine();
        }
        long fin = System.currentTimeMillis();
        System.out.println("Число найдено и это " + current + " за " + k + " итераций");
        System.out.println("Время выполнения составило " + (fin - start) + " миллисекунд");
        System.out.println();
    }
}
*/
