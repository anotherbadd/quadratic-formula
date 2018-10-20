// Packages organize a project. Java may require this file to be placed in
// nested folders: edu/sanjosehighschool.robotics/QuadraticEquation.java
package edu.sanjosehighschool.robotics;

// javac edu/sanjosehighschool/robotics/QuadraticEquation.java  && java edu/sanjosehighschool/robotics/Main

/*
 Quadratic Equation solver

 Learning Objectives:
 * What's a double? What's a comment? I need a semicolon? Etc.
 * Objects are instances of classes
 * Instance variables, getters, setters
 * Objects have methods that act on their instance variables
 * Methods, including constructors, can be passed arguments
 * Methods can return values
 * Decompose parts of the program into different classes

 Your assignment:
 * Download VsCode and figure out how to compile and run this code.
 * There is a bug: the reported values incorrect. Figure out why and fix it.
 * Print the exact form of the result in addition to the numeric approximation.
 * Simplify common factors in the exact form.
 * What happens if the equation has no (real) zeroes? Can you come up with better behavior?

*/


/*
 This class holds the values a, b, and c of a quadratic equation ax² + bx + c = 0.
 It's a very simple class, repetitive even, but it should demonstrate the pattern of
 instance variables with getters and setters very clearly. That pattern is all over robot code.
*/
class Quadratic {
    // Declare instance variables. Each object of this class its own values of a, b, and c.
    // The type double indicates a real number. Don't ask why.
    private double a, b, c;

    // This is a constructor: it gets called when you instantiate the class to make a new object.
    // This constructor takes arguments, which we copy into the instance variables we just defined.
    Quadratic(double newA, double newB, double newC){
        a = newA;
        b = newB;
        c = newC;
    }

    // getters take no arguments and return a value
    double getA(){
        return a;
    }

    double getB(){
        return b;
    }

    double getC(){
        return c;
    }

    // setters take an argument and return nothing, or "void".
    void setA(double newA){
        a = newA;
    }

    void setB(double newB){
        b = newB;
    }

    void setC(double newC){
        c = newC;
    }
}

/*
  The Solution class is responsible for computing the solution to a given qudratic equation.
*/
class Solution {
    /*   q ± r √ s
     *   ---------
     *       t
     */
    private double q, r, s, t;

    Solution(Quadratic equation){
        double a = equation.getA();
        double b = equation.getB();
        double c = equation.getC();

        q = -b;
        r = 1.0;
        s = b * b - 4 * a *c;
        t = 2 * a;
    }

    double approximation1(){
        return q + r * Math.sqrt(s) / t;
    }

    double approximation2(){
        return q - r * Math.sqrt(s) / t;
    }
}

class Main {

    // If you have the same code in multiple places, put it in a reusable method.
    private static void printSolution(Quadratic equation){
        Solution solution = new Solution(equation);

        System.out.println(equation.getA() + "x² + " + equation.getB() + "x + " + equation.getC() + " = 0");
        System.out.println("x = " + solution.approximation1());
        System.out.println("x = " + solution.approximation2());
    }


    // The main method is called when the program starts running. On the robot, that's handled for you.
    public static void main(String[] args){
        // Here's the punchline: we create three objects of class Quadratic. They share the same behavior
        // but have their own variables.
        Quadratic equation1 = new Quadratic(-2, 5, 8);
        Quadratic equation2 = new Quadratic(-5, 2, 0);
        Quadratic equation3 = new Quadratic(5, -8, -2);

        printSolution(equation1);
        printSolution(equation2);
        printSolution(equation3);
    }
}


