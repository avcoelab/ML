public class GradientDecent {

    // Define the function f(x) = (x + 3)^2
    public static double f(double x) {
        return Math.pow(x + 3, 2);
    }

    // Define the derivative of the function f'(x) = 2 * (x + 3)
    public static double fDerivative(double x) {
        return 2 * (x + 3);
    }

    public static void main(String[] args) {
        // Gradient Descent parameters
        double learningRate = 0.1; // Step size
        double precision = 1e-6;   // Threshold for stopping
        int maxIterations = 1000;  // Max number of iterations

        // Starting point
        double x = 2;
        int iteration = 0;

        // Gradient Descent loop
        for (int i = 0; i < maxIterations; i++) {
            double gradient = fDerivative(x);
            double newX = x - learningRate * gradient;

            // Check if the change is below the precision threshold
            if (Math.abs(newX - x) < precision) {
                break;
            }

            x = newX;
            iteration++;
        }

        // Output the results
        System.out.println("Local minimum at x = " + x);
        System.out.println("Function value at local minimum f(x) = " + f(x));
        System.out.println("Iterations taken: " + iteration);
    }
   
}


