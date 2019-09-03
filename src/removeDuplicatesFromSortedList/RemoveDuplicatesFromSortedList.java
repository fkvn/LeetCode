package removeDuplicatesFromSortedList;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Example:
 * 		Input: 1->1->2
 * 		Output: 1->2
 * 
 * 		Input: 1->1->2->3->3
 * 		Output: 1->2->3
 */

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = node1;
		node1.next = new ListNode(1);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(3);
		node1 = node1.next;
		node1.next = new ListNode(3);
		node1 = node2;
		System.out.print("ListNode: ");
		
		while (node1 != null) {
			System.out.print(" " + node1.val);
			node1 = node1.next;
		}
		
		node1 = node2;
		
		ListNode result = deleteDuplicates(node1);
		
		System.out.print("\nResult: ");
		while (result != null) {
			System.out.print(" " + result.val);
			result = result.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		ListNode pre = head;
		
		while (current != null) {
			if (current.next != null) {
				if(current.next.val != pre.val) {
					pre.next = current.next;
					pre = pre.next;
				}
			}
			else {
				if (current.val == pre.val && current != pre)
					pre.next = current.next;
			}
			current = current.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}