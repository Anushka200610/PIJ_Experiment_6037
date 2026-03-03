public class Vector {
    // Manual array to store components instead of hardcoded x, y, z
    private double[] components;
    public Vector(double[] input) throws VectorException {
// Validation: Check if input array is null
        if (input == null || input.length==0) {
            throw new VectorException("Vector input cannot be null");
        }
// Requirement: Only 2D or 3D allowed
        if (input.length != 2 && input.length != 3) {
            throw new VectorException("Invalid dimensions: Only 2D or 3D vectors allowed.");
        }
// Store the components locally
        this.components = input.clone();
    }
    //check dimensions before operations
    private void checkDimensions(Vector v) throws VectorException {
        if (v == null) {
            throw new VectorException("Null vector provided.");
        }
        if (this.components.length != v.components.length) {
            throw new VectorException("Dimensions must match for this  operation.");
        }
    }
    public Vector add(Vector v) throws VectorException {
        checkDimensions(v);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] + v.components[i];
        }
        return new Vector(result);
    }
    public Vector subtract(Vector v) throws VectorException {
        checkDimensions(v);
        double[] result = new double[this.components.length];
        for (int i = 0; i < this.components.length; i++) {
            result[i] = this.components[i] - v.components[i];
        }
        return new Vector(result);
    }
    public double dotProduct(Vector v) throws VectorException {
        checkDimensions(v);
        double result = 0;
        for (int i = 0; i < this.components.length; i++) {
            result += this.components[i] * v.components[i];
        }
        return result;
    }
    public void display() {
        System.out.print(this.components.length + "D Vector: (");
        for (int i = 0; i < this.components.length; i++) {
            System.out.print(this.components[i] + (i == this.components.length -
                    1 ? "" : ", "));
        }
        System.out.println(")");
    }
}