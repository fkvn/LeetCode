package removeDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = node1;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(2);
		node1 = node1.next;
		node1.next = new ListNode(3);
		node1 = node1.next;
		node1.next = new ListNode(3);
		node1 = node1.next;
		node1.next = new ListNode(4);
		node1 = node1.next;
		node1.next = new ListNode(5);
		node1 = node1.next;
		node1.next = new ListNode(5);
		node1 = node2;
		System.out.print("ListNode: ");
		
		while (node1 != null) {
			System.out.print(" " + node1.val);
			node1 = node1.next;
		}
		
		node1 = node2;
		
		ListNode result = deleteDuplicates(null);
		
		System.out.print("\nResult: ");
		while (result != null) {
			System.out.print(" " + result.val);
			result = result.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = null;
        ListNode pre = null;
        ListNode post = null;
       
        
        if (head !=null && head.next != null)
        {
        	post = head.next;
        	pre = null;
        	current = head;
        	
        	head = null;
        	
        	while (post != null) {
            	if (post.val != current.val) {
            		if (current.next == post)
            		{
            			if(head == null) {
            				head = current;
            				pre = head;
            			}
            			else 
            			{
            				pre.next = current;
            				pre = pre.next;
            			}
            			pre.next = null;
            		}
            		current = post;
            	}
            	
            	post = post.next;
            	
            	if(post == null) {
            		if (current.next == null) {
            			if (head == null)
            				head = current;
            			else
            				pre.next = current;
            		}
            	}
            }
        }
        
		return head;
    }
}

