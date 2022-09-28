package Vector;

import java.util.Random;

public class Vector2D {
    private int x;
    private int y;
    private final String about;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
        this.about = "This is vector for two-dimensional coordinate system";
    }

    public Vector2D(int x, int y, String about) {
        this.x = x;
        this.y = y;
        this.about = about;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getAbout() {
        return about;
    }

    public double length() {
        double result = Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
        System.out.printf("The length of %s = %f\n", this.getClass().getSimpleName(), result);
        return result;
    }

    public int scalarProduct(Vector2D vector) {
        int result = 0;
        if (getClass() != vector.getClass()) {
            System.out.println("The argument object is incorrect");
            return result;
        } else {
            result = this.x * vector.x + this.y * vector.y;
            if (getClass() == Vector3D.class) {
                return result;
            }
        }
        System.out.printf("The scalar product of vector's 2D = %d\n", result);
        return result;
    }

    public Vector2D addition(Vector2D vector) {
        Vector2D result = null;
        if (getClass() != vector.getClass()) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            result = new Vector2D(x + vector.x, y + vector.y);
            if (getClass() == Vector3D.class) {
                return result;
            }
        }
        System.out.print("The result of addition vectors: ");
        result.info();
        return result;
    }

    public Vector2D subtraction(Vector2D o) {
        Vector2D result = null;
        if (getClass() != o.getClass()) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            result = new Vector2D(Math.abs(x - o.x), Math.abs(y - o.y));
            if (getClass() == Vector3D.class) {
                return result;
            }
        }
        System.out.print("The result of subtraction vectors: ");
        result.info();
        return result;
    }

    public static Vector2D[] generateVectors(int n) {
        Random random = new Random();
        Vector2D[] result = new Vector2D[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Vector2D(random.nextInt(10), random.nextInt(10));
        }
        return result;
    }

    public void info() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return this.about + ", X = " + this.x + ", Y = " + this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2D vector2D = (Vector2D) o;

        if (x != vector2D.x) return false;
        if (y != vector2D.y) return false;
        return about.equals(vector2D.about);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + about.hashCode();
        return result;
    }

}
