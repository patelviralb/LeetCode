/**
https://leetcode.com/problems/add-two-numbers/
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
/**
1563 / 1563 test cases passed.
Runtime: 2 ms
Memory Usage: 40.7 MB
*/

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer;
        ListNode answerPointer = new ListNode(0);
        answer = answerPointer;
        int sum = 0;
        int temp = 0;
        
        while(l1 != null || l2 != null) {
            if (l1 == null) {
                sum = l2.val + temp;
            } else if (l2 == null) {
                sum = l1.val + temp;
            } else {
                sum = l1.val + l2.val + temp;
            }
            
            if (sum > 9) {
                answerPointer.next = new ListNode(sum % 10);
                temp = sum / 10;
            } else {
                answerPointer.next = new ListNode(sum);
                temp = 0;
            }
            answerPointer = answerPointer.next;
            
            if (l1 == null) {
                l2 = l2.next;
            } else if (l2 == null) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
                l1 = l1.next;
            }
        }
        
        if (temp > 0) {
            answerPointer.next = new ListNode(temp);
        }
        return answer.next;//finalList(l1.next, l2.next, answer.next);
    }
}

public class AddTwoNumbers {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            
            ListNode ret = new Solution().addTwoNumbers(l1, l2);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}