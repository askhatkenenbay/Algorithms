class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half of the linked list.
        ListNode nextNode;
        ListNode prev = null;
        while(slow != null){
            nextNode = slow.next;
            slow.next = prev;

            prev = slow;
            slow = nextNode;
        }

        ListNode temp = head;
        int res = 0;
        while(prev != null){
            int val = temp.val + prev.val;
            res = Math.max(res, val);
            prev = prev.next;
            temp = temp.next;
        }
        return res;
    }
}