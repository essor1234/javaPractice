import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10, 11};
        int[] arr2 = {1,0,3,0,5,6,7,0,9,10, 11};
        int[] arr3 = {1,2,3,4,5,6,8,9,10};


//        System.out.println(Arrays.toString(reverseArray(arr, 0, arr.length-1)));
//        System.out.println(Arrays.toString(resize(arr2, arr2.length*2)));
//        System.out.println(missingNum(arr3));

//        System.out.println(isPalindrome("eheh"));
//

//       --------------------- LINKED LIST------------------------------
        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList.ListNode head = new SinglyLinkedList.ListNode(10);
        SinglyLinkedList.ListNode second = new SinglyLinkedList.ListNode(1);
        SinglyLinkedList.ListNode third = new SinglyLinkedList.ListNode(8);
        SinglyLinkedList.ListNode fourth = new SinglyLinkedList.ListNode(11);
//        Now we will connect them together to form a chain
        sll.setHead(head); // 10
        sll.linkNodes(head, second); // 10-->1
        sll.linkNodes(second,third); // 10 --> 1 --> 8
        sll.linkNodes(third, fourth); // 10 --> 1 --> 8 --> 11 --> null
//        Insert new node add the head of the linked list
        sll.insertFirst(2);
//        Print the linked out
//        sll.displayLinkedList();
        sll.displayLinkedList();
        sll.insertFirst(12);
        System.out.println();
        sll.displayLinkedList();
        System.out.println();
//        Add new node at the end of the linked list
        sll.insertLast(28);
        sll.displayLinkedList();
//        Add new node at any position
        sll.insert(19,3); //12->2->19->10->1->8->11->28->null
        sll.insert(77,1);
        System.out.println();
        sll.displayLinkedList();
//        Remove first node of the list
        System.out.println();
        System.out.println("Remove first Node");
        sll.deleteFirst();
        sll.displayLinkedList();
//        Remove last node of the list
        System.out.println();
        System.out.println("Remove Last Node");
        System.out.println(sll.deleteLast().data);
        sll.displayLinkedList();
//        Remove any node
        System.out.println();
        System.out.println("Remove Last Node");
        System.out.println(sll.delete(3).data);
        System.out.println(sll.delete(1).data);

        sll.displayLinkedList();





    }



    public static boolean isPalindrome(String word){
//        Convert the word into an array of character
        char[] arr = word.toCharArray();
//        get the start and end index
        int start = 0;
        int end = arr.length-1;
//        Start a loop until the start index > end index
        while(start < end){
//            Check if the word is equals
            if(arr[start] != arr[end]){
                return false;
            }
//            Update start increase by 1 and end decrease by 1
            start++;
            end--;
        }
        return true;
    }

    public static int[] returnOddArr(int[] arr){
//        loop through the array to get the array length
        int count=0;
        for(int i=0; i<arr.length;i++){
//            Check if the current value is even or odd
            if(arr[i]%2 != 0){
                count++;
            }
        }
//        Create a array based on the count
        int[] result = new int[count];
//        Initialize the index
        int idx =  0;

//        Loop through the array to get what value is odd, then put it into the array
        for(int i=0; i<arr.length;i++){
            if(arr[i]%2!=0){
//                If the value is odd, define that value to the current idx of the new array
                result[idx] = arr[i];
//                Update the index
                idx++;
            }
        }

        return result;
    }

    public static int[] reverseArray(int[] arr, int start, int end){
//        Check of the start point is lower than the end point(index)
        while(end > start){
//            create a temporary to store first value
            int temp = arr[start];
//            move the end value to the start
            arr[start] = arr[end];
//            move temp value into the end position
            arr[end] = temp;
//            Increase value start by 1 and decrease value end by one
            start++;
            end--;

        }
        return arr;

    }

    public static int findMin(int[] arr){
//        Define the min value as the first value in the array
        int min = arr[0];
//        loop through the array, start by the second value(index=1)
        for(int i=1; i<arr.length;i++){
//            check if the current min value is higher the current value in the loop
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findSecondMax(int[] arr){
//        Define the default value for max and second max as a min value
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
//        Loop through the array
        for(int i=0; i<arr.length;i++){
//            Check if the current value is the maximum value
//            if yes => move the the current max value to the second max value
            if(arr[i] > max){
                secMax = max;
                max = arr[i];
            }
//            Check if the current value is higher than the current second max value,
//            but not the current max value itself
            else if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
            }
        }

        return secMax;
    }

    public static int[] zeroToEnd(int[] arr){
//       Create an initial value
        int j = 0;
//        loop through the array
        for(int i=0; i<arr.length; i++){
//            check the value of index i is not 0, and value of index j is 0
            if(arr[i]!=0 && arr[j]==0){
//                Swap the position of two values
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
//            Check if the current value of j index is 0
//             if not => increase the value by 1
            if(arr[j] !=0){
                j++;
            }
        }
        return arr;
    }

    public static int[] resize(int[] arr, int size){
//        Create a new array with the require size
        int[] temp = new int[size];
//        Copy values of the old array into the new one
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }

        return temp;
    }

    public static int missingNum(int[] arr){
//        Get the range of the array, start from 1
        int n = arr.length+1;
//        Get the sum of the array from 1 to n
        int sum = (n*(n+1))/2;
//        Start the for loop to minus all the value in the array,
//        the remain value is the result
        for(int i=0; i<arr.length; i++){
            sum -= arr[i];
        }
        return sum;
    }
}