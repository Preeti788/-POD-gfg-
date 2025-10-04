class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(s, target, 0, 0, 0, "", result);
        Collections.sort(result);
        return result;
    }

    private void helper(String s, int target, int index, long currValue, long prevValue, String expr, ArrayList<String> result) {
        if (index == s.length()) {
            if (currValue == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(index) == '0') break;

            String part = s.substring(index, i + 1);
            long currNum = Long.parseLong(part);

            if (index == 0) {
                helper(s, target, i + 1, currNum, currNum, part, result);
            } else {
                helper(s, target, i + 1, currValue + currNum, currNum, expr + "+" + part, result);
                helper(s, target, i + 1, currValue - currNum, -currNum, expr + "-" + part, result);
                helper(s, target, i + 1, currValue - prevValue + prevValue * currNum, prevValue * currNum, expr + "*" + part, result);
            }
        }
    }
}
