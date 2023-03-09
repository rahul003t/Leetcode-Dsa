//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int arr1[] = new int[26]; //initially the arrays have 0 in it
        int arr2[] = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            arr1[ch - 'a']++;
        }
        
        int n = s.length();
        //to get the size of the linkedlist 
        int count = 0;
        Node ptr = head;
        Node curr = head;
        while(ptr!=null){
            count++;
            char c = ptr.data;
            arr2[c - 'a']++;
            //check if the count is equal to the size of the given string
            if(count == n){
                //check for anagram
                if(isAnagram(arr1,arr2)){
                    //if true create a node and add it to the list
                    //why to create a new Node we can do the operation in the given linkedlist and add it to
                    //the arraylist
                    Node next = ptr.next; //create a pointer infront of the ptr
                    ptr.next = null; //break the link for the time being
                    ans.add(curr); //add it to the list
                    ptr = next; //place the ptr at the next pointer
                    curr = ptr; //place the curr pointer at the place of ptr
                    //set the counter to 0 and reset the arrays 
                    count = 0;
                    Arrays.fill(arr2,0);
                }else{
                    //if not anagram
                    char ch1 = curr.data;
                    arr2[ch1 - 'a']--;
                    ptr = ptr.next;
                    curr = curr.next;
                    count--;
                }
            }else{
                ptr = ptr.next;
            }
        }
        return ans;
    }
    public static boolean isAnagram(int arr1[], int arr2[]){
        for(int i=0; i<26; i++){
            //check wheathear the array has same value at the same indexes
            //if they are different they are not anagram
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}