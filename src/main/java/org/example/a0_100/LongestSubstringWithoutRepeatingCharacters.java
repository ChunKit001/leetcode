package org.example.a0_100;//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10158 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int left = -1, max = 0, len = s.length();
        for (int right = 0; right < len; right++) {
            if (dic.containsKey(s.charAt(right))) {
                left = Math.max(left, dic.get(s.charAt(right))); // 更新左指针
            }
            dic.put(s.charAt(right), right); // 哈希表记录
            max = Math.max(max, right - left); // 更新结果
        }
        return max;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
