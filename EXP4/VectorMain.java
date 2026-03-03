public class VectorMain {
    public static void main(String[] args) {
// Replacing java.util.Vector with a standard array
        Vector[] myVectors = new Vector[2];
        try {
// Setup two 3D vectors
            myVectors[0] = new Vector(new double[]{1.0, 2.0, 3.0});
            myVectors[1] = new Vector(new double[]{4.0, 5.0, 6.0});
            System.out.println("Stored Vectors:");
            for (Vector v : myVectors) {
                v.display();
            }
// Perform operations
            Vector sum = myVectors[0].add(myVectors[1]);
            System.out.print("Sum: ");
            sum.display();
            double dot = myVectors[0].dotProduct(myVectors[1]);
            System.out.println("Dot Product: " + dot);
            System.out.println("\nTesting Error Handling:");
// Attempt to create an invalid 4D vector
            Vector vInvalid = new Vector(new double[]{1, 2, 3, 4});
        } catch (VectorException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }
    }
}
