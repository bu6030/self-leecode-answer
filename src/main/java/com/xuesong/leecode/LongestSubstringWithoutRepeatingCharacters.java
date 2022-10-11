package com.xuesong.leecode;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i <= s.length(); i++) {
            int curMax = 1;
            if (max > s.length() - i) {
                break;
            }
            for (int j = i + 1; j <= s.length(); j++) {
                String a = s.substring(i, j);
                if (j < s.length()) {
                    String b = s.substring(j, j + 1);
                    if (a.contains(b)) {
                        break;
                    } else {
                        curMax = a.length() + 1;
                        if (curMax > max) {
                            max = curMax;
                        }
                    }
                } else {
                    if (a.length() > max) {
                        max = a.length();
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
}
