/**id:24
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = head.next;
        ListNode temp = head;
        swap(temp);
        return res;
    }

    public ListNode swap(ListNode node){
        if(node == null)return null;
        ListNode first = node;
        ListNode second = node.next;
        if(second == null)return first;
        ListNode third = node.next.next;

        second.next = first;
        first.next = swap(third);
        return second;
    }
}