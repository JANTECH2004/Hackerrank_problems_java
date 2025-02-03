import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Linkedlist {
    Node head;
    public void add(int data) {
        Node newnode=new Node(data);
        if (head==null) {
            head=newnode;
            return;
        }
        Node temp=head;
        while (temp.next!=null)temp=temp.next;
        temp.next=newnode;
    }
    public void rearrange() {
        if (head==null || head.next==null) return;
        Node oddHead=new Node(0), evenHead=new Node(0);
        Node odd=oddHead, even=evenHead;
        Node temp=head;

        while (temp!=null) {
            if (temp.data%2!=0) { 
                odd.next=temp;
                odd=odd.next;
            } else { 
                even.next=temp;
                even=even.next;
            }
            temp=temp.next;
        }

        odd.next=evenHead.next;
        even.next=null;
        head=oddHead.next;
    }

    public void display() {
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist list = new Linkedlist();
        int a=sc.nextInt();
        while (a!=-1) {
            list.add(a);
            a=sc.nextInt();
        }
        list.rearrange();
        list.display();
    }
}
