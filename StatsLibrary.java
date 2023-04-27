package project2;
import java.util.*;
import org.apache.commons.*;

// https://stackoverflow.com/questions/22949281/java-generalized-hypergeometric-function
//https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
//https://stackoverflow.com/questions/4253500/uniform-distribution-with-random
public class StatsLibrary {
	public static void main(String[] args) {
		
		//coin flips used to demonstrate distribution and probability
       
		// Hypergeometric distribution
        System.out.println("Hypergeometric distribution:");
        int C = 52; 
        int A = 4; 
        int CDrawn = 2;
        int AAces = 2; 
        double hypergeometricProb = hypergeometricProbability(C, A, CDrawn, AAces);
        System.out.println("Probability of drawing 2 aces from a deck of cards: " + hypergeometricProb);
        
        // Poisson probability
        System.out.println("\nPoisson probability:");
        double p = 0.5; 
        int n = 10; 
        int k = 8; 
        double poissonProb = poissonProbability(p, n, k);
        System.out.println("Probability of getting 8 heads in 10 coin flips: " + poissonProb);
        
       
    	// Uniform distribution
        System.out.println("\nUniform distribution:");
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(rand.nextDouble());
        }
    }
    
    public static double poissonProbability(double p, int n, int k) {
        double lambda = p * n;
        double numerator = Math.pow(lambda, k) * Math.exp(-lambda);
        double denominator = factorial(k);
        return numerator / denominator;
    }
    
    public static double hypergeometricProbability(int C, int A, int CDrawn, int AAces) {
        double numerator = choose(A, AAces) * choose(C - A, CDrawn - AAces);
        double denominator = choose(C, CDrawn);
        return numerator / denominator;
    }
    private static int choose(int C, int AAces) {
		return 0;
	}
	public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

