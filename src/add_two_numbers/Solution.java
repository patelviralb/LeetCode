package add_two_numbers;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer;
        ListNode answerPointer = new ListNode(0);
        answer = answerPointer;
        int sum = 0;
        int temp = 0;

        while (l1 != null || l2 != null) {
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

        return answer.next;
    }
}
