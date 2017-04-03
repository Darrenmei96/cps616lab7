
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
        Problem1 problem1;
        Problem2 problem2;

        for (int i=10; i<=150; i+=10) {
            problem = new Problem(i,i);
            problem1 = new Problem1(i,i);
            problem2 = new Problem2(i,i);
            process2(problem2);
            //process1(problem1);
            //process(problem);
        }
        
        Scanner in = new Scanner(System.in);
        while (in.hasNext())    {
            // Read and print input Kanpsack
            problem = new Problem(in);
            process(problem);
        }
    }
    
    /**
     * Processes a knapsack Problem: prints it, solves it, and prints the solution
     * <br>DO NOT MODIFY
     * @param problem Knapsack Problem
     */
    private static void process(Problem problem) {
        Solution solution;
        System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");   
    }
    
    /**
     * Processes a knapsack Problem1: prints it, solves it, and prints the solution
     * <br>DO NOT MODIFY
     * @param problem Knapsack Problem1
     */
    private static void process1(Problem1 problem) {
        Solution1 solution;
        System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");   
    }
    
    /**
     * Processes a knapsack Problem2: prints it, solves it, and prints the solution
     * <br>DO NOT MODIFY
     * @param problem Knapsack Problem2
     */
    private static void process2(Problem2 problem) {
        Solution2 solution;
        System.out.println(problem);
        long time = System.nanoTime();
        solution = problem.solve();
        time = System.nanoTime() - time;
        System.out.println(solution);
        System.out.println("was calculated in " + time + "nanoseconds.\n");   
    }
      
}
