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
}
