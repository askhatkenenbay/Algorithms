class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for(ListNode node : lists){
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
        }
        list.sort((a,b) -> a - b);
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        for(int i : list){
            ListNode curr = new ListNode(i);
            prev.next = curr;
            prev = curr;
        }
        return head.next;
    }


    public ListNode mergeKListsWithMergeSort(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end){
        if(end - start == 1){
            return mergeTwo(lists[start], lists[end]);
        }else if(end == start || end == -1){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid - 1);
        ListNode right = merge(lists, mid, end);
        return mergeTwo(left, right);
    }

    public ListNode mergeTwo(ListNode a, ListNode b){
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while(a != null && b != null){
            if(a.val > b.val){
                res.next = new ListNode(b.val);
                b = b.next;
            }else{
                res.next = new ListNode(a.val);
                a = a.next;
            }
            res = res.next;
        }
        while(a != null){
            res.next = new ListNode(a.val);
            a = a.next;
            res = res.next;
        }
        while(b != null){
            res.next = new ListNode(b.val);
            b = b.next;
            res = res.next;
        }
        return head.next;
    }
}