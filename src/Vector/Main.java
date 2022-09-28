package Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector2D v2 = new Vector2D(4, 1);
        Vector2D v3 = new Vector3D(4, 2, 3);

        v2.length();
        v3.length();

        v2.info();
        v3.info();

        v3.scalarProduct(v2);
        v2.scalarProduct(v3);

        v2.addition(v2);
        v3.addition(v3);

        v2.subtraction(v2);
        v3.subtraction(v3);

        Arrays.stream(Vector2D.generateVectors(4)).forEach(v -> v.info());
        Arrays.stream(Vector3D.generateVectors(4)).forEach(v -> v.info());

        Vector v6 = new Vector(5);
        Vector v7 = new Vector(5);
        v6.info();
        v7.info();
        v6.addition(new Vector());
        v6.scalarProduct(v7);
        v6.addition(v7);
        v6.subtraction(v7);
        Arrays.stream(Vector.generateVectors(5)).forEach(v -> v.info());

    }
}
