import java.util.List;

public class SinglyLinkedList {
    private ListNode head;



    public void setHead(ListNode node) {
        this.head = node;
    }

    public void linkNodes(ListNode currentNode, ListNode nextNode){
        currentNode.next = nextNode;
    }
    static class ListNode{
        int data; //Generic type
        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Method to display the linked list
    public void displayLinkedList() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print("null");
    }

    public int count(){
//        Initialize the value count
        int count =0;
//        Create a current value that store the head node
        ListNode current = head;
//        Start a while loop until reach null value
        while(current != null){
//            Update count by one
            count++;
//            update current value to the next value
            current = current.next;
        }

        return count;
    }

    public void insertFirst(int value){
        // Create new node
        SinglyLinkedList.ListNode newNode = new SinglyLinkedList.ListNode(value);
        // Connect it to the current head
        newNode.next = head;
        // make newNode become the head of the link list
        head = newNode;
    }
    public void insertLast(int value){
//        Create a new node
        ListNode newNode = new ListNode(value);
//        Check if the current list is null
        if(head == null){
            head = newNode;
//            End the method
            return;
        }
//        If not, create a pointer and initialize it at the head position
        ListNode current = head;
//        Start a while loop to move the current pointer to the end pf the list
//        Check that the next node is null or not, run until reach null
        while(current.next != null){
//            move the current pointer if not null yet
            current = current.next;
        }
//        If reach the end of the list, connect the current node to the new one
        current.next = newNode;
    }

//    Insert node at any position
//    NOTE: THe position gonna start from 1
    public void insert(int value, int position){
//        Create a new node
        ListNode node = new ListNode(value);

//        Check if insert at the first position
//        If the first position, make the new node become the head
//        Else: loop to the required position and start link the node
        if(position ==1){
//            Insert node as the head
//            Link the new node to the current head
            node.next = head;
//            move the head position to the new node
            head = node;
        }else{
//            Need a Count value to start the loop
//            Start from 1. 'cause the default node is the head node
//             THis value help move the previous pointer to the position-1
            int count = 1;
//            previous pointer for getting the node before the required position
            ListNode previous = head;
//            To set the previous pointer to the position the before the required position
//            need to decrease the required position bý
            while(count < position-1){
//                Update the previous pointer
                previous = previous.next;
//                Update the count
                count++;
            }
//            Connect new node to the next and previous node
//            Create the current pointer,, this pointer will get the node that
//            next to the previous one, aka The node after the required position
            ListNode current = previous.next;
//            connect the new node to the current pointer's node
            node.next = current;
//            Connect the new node to the previous node
            previous.next = node;

        }
    }

    public ListNode deleteFirst(){
//        Check if there is nodes in the list
        if(head == null){
            return null;
        }
//        Create a temporary to store current head node
        ListNode temp = head;
//        Move the head position of the list to the next node
        head = temp.next;
//        Disconnect the first node from the list
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast(){
//        Check if there's any node, or only have one node in the list
        if(head == null || head.next == null){
            return null;
        }
//        Create 2 pointers current and previous
//        Initialize the current pointer to head
        ListNode current = head;
        //        Initialize the previous pointer to head
        ListNode previous = null;
//        Start the loop until reach the null value
        while(current.next != null){
//            Update the previous pointer to the current pointer's position
            previous = current;
//            Update the current  pointer to the next node
            current = current.next;
        }
//        Disconnect the last node
        previous.next = null;
        return current;
    }

//    Get any position to delete
    public ListNode delete(int position){
//         Check if the position is the first node
//        If true, just need to move the head to the next node
        if(position == 1){
//            Current pointer hear to get the current head
            ListNode current = head;
            head = head.next;
            return current;
        }else{
//            Need a pointer that gonna pointing to the node before the required node
//            Initialize it point to the head node
            ListNode previous = head;
//            Need a count value, set it to 1, since we start from the first node
            int count=1;
//            Start a while loop, that run until the previous pointer
//            point to the node before the required node
            while(count < position-1){
//                Update the previous pointer position
                previous = previous.next;
//                Update count
                count++;
            }
//            Need to change the connection from the node before the require node
//            to the node after the required node,, that can make the required node disconnect from the list
            // Create a current pointer to point to the required node
            ListNode current = previous.next;
            // Change the connect of the previous' node to the node next to the current pointer
            previous.next = current.next;
            return current;
        }
    }

//    Searching value in linked list
    public boolean search(int value){
//        Create a pointer that gonna point to the head
        ListNode current = head;
//        Start a while loop, run until it reach the end of the list
        while(current != null){
//            Check if the current value of the node is the required value
            if(current.data == value){
                return true;
            }
//            If not the required value, update the current pointer to the next node
            current = current.next;
        }
//        If there's no required value in the list
        return false;
    }

    public void reverse(){
        if(head == null){
            return;
        }
//        The current pointer for pointing at the node need to reverse
//        Initialize at head node
        ListNode current = head;
//        The previous pointer to point of the node before the current pointer
        ListNode previous = null;
//        The next pointer to get the next node from the current pointer
        ListNode next = null;
//        Start the loop until reach the end of the list
        while(current != null){
//            Update the next pointer
            next = current.next;
//            Update connection of node
            current.next = previous;
 //          Update previous pointer to current position
            previous = current;
//            Update urrent pointer
            current = next;
        }
        // Update the head of the list to the new head (i.e., the last node of the original list)
        head = previous;

    }

    public void removeDuplicate(){
        if(head == null){
            return;
        }
//        Create a pointer that point at the head node
        ListNode current = head;
//        Start a loop until reach null at the current and next null
        while(current != null && current.next != null){
//            Check if the data of current and next node is the same
            if(current.data == current.next.data){
//             Change the connection of the current node to the following node
                current.next = current.next.next;
            }else{
//                Update the current pointer if not equal
                current = current.next;
            }
        }
    }

    public void insertNodeSort(int value){
        // Create new node
        ListNode node = new ListNode(value);
        // If the list is empty or the new node should be inserted before the head
        if(head == null || head.data > node.data){
            node.next = head;
            head = node;
        } else {
            // Create a pointer that points at the head node
            ListNode current = head;
            // Create a while loop until it reaches null
            // or the new node is smaller than the next node
            ListNode temp = null;
            while(current != null && current.data < node.data){
                // Create a temporary to get the previous node
                temp = current;
                // Update current node
                current = current.next;
            }
            // Connect new node to the list
            node.next = current;
            temp.next = node;
        }
    }

    public void removeByKey(int value){

//        Pointer that gonna point to the head
        ListNode current = head;
//        pointer that's a temporary
        ListNode temp = null;
        if(current != null && current.data == value){
            head = current.next;
            return;
        }
//        Loop through the the list until it reach null or required value
        while(current != null && current.data != value){
//            Update the temp to the current pointer
            temp = current;
//            Update the current pointer
            current = current.next;
        }
//       Check if current is null
        if(current == null){
            return;
        }
//        remove the node the match value and
//        connect the temp to the following one
        temp.next = current.next;




    }


}
