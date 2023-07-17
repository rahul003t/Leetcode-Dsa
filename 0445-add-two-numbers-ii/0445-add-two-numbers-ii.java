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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        ListNode list;

        while(l1 != null){
            a1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            a2.add(l2.val);
            l2 = l2.next;
        }
        int carry =0;
        int n = a1.size()-2;
        int m = a2.size()-2;
        int su = a1.get(n+1) + a2.get(m+1) + carry;
        if(su > 9){
            list = new ListNode(su%10);
            //newNode.next = list;
            //list = newNode;
            carry = su/10;
        }
        else{
            list = new ListNode(su);
            carry =0;
        }
        while(n >= 0 && m >= 0){
            int sum = a1.get(n) + a2.get(m) + carry;
            if(sum > 9){
                ListNode newNode = new ListNode(sum%10);
                newNode.next = list;
                list = newNode;
                carry = sum/10;
            }
            else{
                ListNode newNode = new ListNode(sum);
                newNode.next = list;
                list = newNode;
                carry =0;
            }
            n--;
            m--;
        }
        while(n >= 0 ){
            int sum = a1.get(n) + carry;
            if(sum > 9){
                ListNode newNode = new ListNode(sum%10);
                newNode.next = list;
                list = newNode;
                carry = sum/10;
            }
            else{
                ListNode newNode = new ListNode(sum);
                newNode.next = list;
                list = newNode;
                carry =0;
            }
            n--;
        }
        while(m >= 0){
            int sum = carry + a2.get(m);
            if(sum > 9){
                ListNode newNode = new ListNode(sum%10);
                newNode.next = list;
                list = newNode;
                carry = sum/10;
            }
            else{
                ListNode newNode = new ListNode(sum);
                newNode.next = list;
                list = newNode;
                carry =0;
            }
            m--;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = list;
            list = newNode;
        }
        return list;
    }
}