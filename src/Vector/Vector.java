package Vector;

import java.util.Arrays;
import java.util.Random;

public class Vector {
    private int[] coordinates;
    private final String about;
    private static Random random = new Random();

    public Vector() {
        coordinates = new int[random.nextInt(1, 10)];
        init();
        about = coordinates.length + "D vector";
    }

    public Vector(int n) {
        coordinates = new int[n];
        init();
        about = coordinates.length + "D vector";
    }

    public Vector(int[] coordinates) {
        this.coordinates = coordinates;
        about = coordinates.length + "D vector";
    }

    private void init() {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = random.nextInt(1, 10);
        }
    }

    public double length() {
        double result = 0;
        for (int i : coordinates) {
            result += Math.pow(i, 2);
        }
        result = Math.sqrt(result);
        System.out.printf("The length of %s = %f\n", about, result);
        return result;
    }

    public int scalarProduct(Vector v) {
        int result = 0;
        if (coordinates.length != v.coordinates.length) {
            System.out.println("The argument object is incorrect");
            return 0;
        } else {
            for (int i = 0; i < coordinates.length; i++) {
                result += coordinates[i] * v.coordinates[i];
            }
        }
        System.out.printf("The scalar product of %s's = %d\n", about, result);
        return result;
    }

    public Vector addition(Vector v) {
        int[] result = new int[coordinates.length];
        if (coordinates.length != v.coordinates.length) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            for (int i = 0; i < coordinates.length; i++) {
                result[i] = coordinates[i] + v.coordinates[i];
            }
        }
        System.out.print("The result of addition vectors: ");
        Vector vector = new Vector(result);
        vector.info();
        return vector;
    }

    public Vector subtraction(Vector v) {
        int[] result = new int[coordinates.length];
        if (coordinates.length != v.coordinates.length) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            for (int i = 0; i < coordinates.length; i++) {
                result[i] = Math.abs(coordinates[i] - v.coordinates[i]);
            }
        }
        System.out.print("The result of subtraction vectors: ");
        Vector vector = new Vector(result);
        vector.info();
        return vector;
    }

    public void info() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return about + ", coordinates: " + Arrays.toString(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        if (!Arrays.equals(coordinates, vector.coordinates)) return false;
        return about.equals(vector.about);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(coordinates);
        result = 31 * result + about.hashCode();
        return result;
    }

    public static Vector[] generateVectors(int n) {
        Vector[] result = new Vector[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Vector(n);
        }
        return result;
    }

}
