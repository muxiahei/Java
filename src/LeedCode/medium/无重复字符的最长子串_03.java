package LeedCode.medium;


import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 *
 */
public class 无重复字符的最长子串_03 {


    /**
     * 暴力解法，声称所有的字串，判断字串是否有重复元素，获取最大的无重复字符的最大子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i,j);
                if(allUnique(sub)) {
                    maxLength = Math.max(maxLength,j - i);
                }
            }
        }
        return maxLength;
    }

    public static boolean allUnique(String s) {
        Set<Character> hashSet = new HashSet();
        for (int k = 0; k < s.length(); k++) {
            Character c = s.charAt(k);
            if (hashSet.contains(c)) {
                return false;
            }
            hashSet.add(c);
        }
        return true;
    }

    /**
     * 利用滑动窗口的思想，来对暴力解法进行优化
     * 判断字符串在不在一个字符串中，我们可以用hash来进行进一步的优化
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap();
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if(hashMap.containsKey(s.charAt(j))) {
                //因为没有删除，
                i = Math.max(hashMap.get(s.charAt(j)),i);
                hashMap.put(s.charAt(i),(int)hashMap.get(s.charAt(i)));
            }
            maxLength = Math.max(maxLength,j - i + 1);
            hashMap.put(s.charAt(j),j + 1);
        }
        return maxLength;
    }


    /**
     * 利用 Ascii 编码值作为数组的下标，数组存储该字符所在字符串的位置。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int[] index = new int[128];
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            System.out.println(Arrays.toString(index));
             i = Math.max(index[s.charAt(j)], i);
             maxLength = Math.max(maxLength, j - i + 1);
             index[s.charAt(j)] = j + 1;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcbbsjfksdjkfjewuiowqiodpaioivopaipvidapoif"));
    }
}
