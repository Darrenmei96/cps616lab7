
import java.util.Scanner;

/**
  * Test program for the problem problem.
  * @author Sophie Quigley
  * @author Darren Mei
  *
  */
public class Test {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Problem problem;

        for (int i=10; i<=150; i+=10) {
            problem = new Problem(i,i);
            System.out.println(problem);
            System.out.println();
            System.out.print("Dynamic Programming: ");
            processDP(problem);
            System.out.print("Optimized: ");
            processOPT(problem);
            System.out.print("Naive: ");
            process(problem);
        }

        Scanner in = new Scanner(System.in);
        while (in.hasNext())    {
            // Read and print input Knapsack
            problem = new Problem(in);
            //process(problem);
        }
    }

    /**
     * Processes a knapsack Problem: prints it, solves it, and prints the solution
     * <br>DO NOT MODIFY
     * @param problem Knapsack Problem
     */
    private static void process(Problem problem) {
        Solution solution;
        //System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");
    }
    private static void processOPT(Problem problem) {
        Solution solution;
        //System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve1();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");
    }
    private static void processDP(Problem problem) {
        Solution solution;
        //System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve2();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");
    }
}
