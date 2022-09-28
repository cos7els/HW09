package Vector;

import java.util.Random;

public class Vector3D extends Vector2D {
    private int z;

    public Vector3D(int x, int y, int z) {
        super(x, y, "This is vector for three-dimensional coordinate system");
        this.z = z;
    }

    @Override
    public double length() {
        double result = Math.sqrt((Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(z, 2)));
        System.out.printf("The length of %s = %f\n", getClass().getSimpleName(), result);
        return result;
    }

    @Override
    public int scalarProduct(Vector2D vector) {
        int result = 0;
        if (getClass() != vector.getClass()) {
            System.out.println("The argument object is incorrect");
            return result;
        } else {
            result = super.scalarProduct(vector) + z * ((Vector3D) vector).z;
        }
        System.out.printf("The scalar product of vector's 3D = %d\n", result);
        return result;
    }

    @Override
    public Vector3D addition(Vector2D vector) {
        Vector3D result = null;
        if (getClass() != vector.getClass()) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            Vector2D temp = super.addition(vector);
            result = new Vector3D(temp.getX(), temp.getY(), z + ((Vector3D) vector).z);
        }
        System.out.print("The result of addition vectors: ");
        result.info();
        return result;
    }

    @Override
    public Vector3D subtraction(Vector2D vector) {
        Vector3D result = null;
        if (getClass() != vector.getClass()) {
            System.out.println("The argument object is incorrect");
            return null;
        } else {
            Vector2D temp = super.subtraction(vector);
            result = new Vector3D(temp.getX(), temp.getY(), Math.abs(z - ((Vector3D) vector).z));
        }
        System.out.print("The result of subtraction vectors: ");
        result.info();
        return result;
    }

    public static Vector3D[] generateVectors(int n) {
        Random random = new Random();
        Vector3D[] result = new Vector3D[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Vector3D(random.nextInt(10), random.nextInt(10), random.nextInt(10));
        }
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", Z = " + this.z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3D vector3D)) return false;
        if (!super.equals(o)) return false;

        return z == vector3D.z;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + z;
        return result;
    }

}
