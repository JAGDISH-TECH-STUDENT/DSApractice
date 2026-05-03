class rotateString {
    public boolean rotateStrings(String s, String goal) {
      
        if (s.length() != goal.length()) return false;

        String doubled = s + s;
        return doubled.contains(goal);
    }
    public static void main(String[] args) {
        rotateString solution = new rotateString();
        String s = "abcde";
        String goal = "cdeab";
        boolean result = solution.rotateStrings(s, goal);
        System.out.println(result); // Output: true
    }
}
