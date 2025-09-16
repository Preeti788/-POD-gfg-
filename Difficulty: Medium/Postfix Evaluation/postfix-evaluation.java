class Solution {
    public int evaluatePostfix(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for (String token : arr) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
                int b = st.pop();
                int a = st.pop();
                int result = 0;
                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/":
                        int q = a / b;
                        if ((a ^ b) < 0 && a % b != 0) q--;
                        result = q;
                        break;
                    case "^": result = powInt(a, b); break;
                }
                st.push(result);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private int powInt(int a, int b) {
        if (b < 0) return 0;
        long res = 1;
        long base = a;
        int exp = b;
        while (exp > 0) {
            if ((exp & 1) == 1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return (int) res;
        
    }
}