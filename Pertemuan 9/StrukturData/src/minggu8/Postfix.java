
package minggu8;

import java.util.Scanner;

public class Postfix {
    int n;
    int top;
    char stack[];
    
    public Postfix(int total){
        n = total;
        top = -1;
        stack = new char[n];
        push('(');
    }
    public void push(char c){
        top++;
        stack[top] = c;
    }
    
    public char pop(){
        char item = stack[top];
        top--;
        return item;
    }
     
    public boolean IsOperand(char c){
        if ((c >= 'A' && c<= 'Z') || (c >= 'a' && c<='z') || (c >= '0' && c <= '9') || (c == ' ' && c == '.') ) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean IsOperator(char c){
        if (c== '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+') {
           return true;
        }
        else{
            return false;
        }
    }
    
    public int presedence(char c){
        switch(c){
            case '^' : return 3;
            case '%' : return 2;
            case '/' : return 2;
            case '*' : return 2;
            case '-' : return 1;
            case '+' : return 1;
            default: return 0;
        }
    }
    
    public String koversi(String Q){
        String P = "";
        char c;
        for (int i = 0; i < n; i++) {
            c = Q.charAt(i);
            if (IsOperand(c)) {
                P = P +c;
            }
            if (c == '(') {
                push(c);
            }
            if (c == ')') {
                while (stack[top] != '(') {                    
                    P = P + pop();
                }
                char temp = pop();
            }
            if (IsOperator(c)) {
                while (presedence(stack[top]) >= presedence(c)) {                    
                    P = P + pop();
                }
                push(c);
            }
        }
        return P;
    }
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String P,Q;
        System.out.println("Masukkan ekspresi matematika");
        Q = sc.next();
        Q = Q.trim();
        Q = Q + ')';
        
        int total = Q.length();
        Postfix post = new Postfix(total);
        P = post.koversi(Q);
        System.out.println("Postfix : " + P);
        
    }
    
    
    
    
}
