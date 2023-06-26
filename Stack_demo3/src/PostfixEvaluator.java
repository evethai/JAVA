
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class PostfixEvaluator {
    public static boolean isOperator(String S){
        return (S.equals("+")||S.equals("-")||
                S.equals("*")||S.equals("/"));
    }
    //Evaluate a simple expression
    public static double evaluate(String op, double n1, double n2){
        if(op.equals("+"))return n1+n2;
        if(op.equals("-"))return n1-n2;
        if(op.equals("*"))return n1*n2;
        if(op.equals("/")){
            if(n2==0)throw new RuntimeException("divede by 0!");
            return n1/n2;
        }
        throw new RuntimeException("operator is not supported!");
    }
    public static double evaluate(String exp){
        double result=0;
        //split expression to sub-strings
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack<Double> stack = new Stack();
        double n1, n2;
        while(stk.hasMoreElements()){
            String part = stk.nextToken();//get a part of exp.
            //check S with operators
            if(!isOperator(part))stack.push(Double.parseDouble(part));
            else{//part is an operator
                //pop 2 value form stack
                n1=stack.pop();
                n2=stack.pop();
                //evalute sub-expression n1 part n2
                result = evaluate(part, n1, n2);
                stack.push(result);//push temporary result to stack
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String exp="((3)(4)*(5)(6)* +(3)*)";
        System.out.println(evaluate(exp));
    }
}
