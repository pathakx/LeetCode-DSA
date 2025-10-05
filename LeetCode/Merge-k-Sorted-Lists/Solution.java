/**
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }

        var pq=new PriorityQueue<ListNode>((a,b)->a.val-b.val);

        for(ListNode ln:lists){
            if(ln!=null){
              pq.add(ln);
            }
        }

        var dummy = new ListNode();
        var curr=dummy;

        while(!pq.isEmpty()){
            var min =pq.poll();
            curr.next=min;
            curr=curr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}