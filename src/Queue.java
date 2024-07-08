import java.util.EmptyStackException;

public class Queue {
//    gonna need front, rear, and length
    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }


    private class ListNode{
        private int data;
        private ListNode next;

//        Need a constructor
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

        public int length(){
            return length;
        }

        public boolean isEmpty(){
            return length==0;
        }


        public void enqueue(int data){
            ListNode temp = new ListNode(data);
//            Check if the list is empty
            if(isEmpty()){
//                put the front pointer at the temp node
                front = temp;
            }else{
//                else, connect the new node to the list
                rear.next = temp;
            }
//            put the rear placed at the newest node
            rear = temp;
            length++;
        }

        public int dequeue(int data){
//          check if the list is null
            if(isEmpty()){
                throw new EmptyStackException();
            }

//            get data of the node the gonna be removed
            int result = front.data;
//            assign front pointer to the next node
            front = front.next;
//            Check if the next front is null, so the rear should be null too
            if(front == null){
                rear = null;
            }
//            update the length
            length--;
            return result;
        }

    }
}
