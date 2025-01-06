public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for (int l = 0, r = s.length() - 1; l <= r; l++, r--)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}