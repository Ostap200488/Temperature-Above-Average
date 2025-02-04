package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Create a linked list
    public Node createdLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert in linked list
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createdLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    // Traverse a Linked List
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("\n");
        }
    }

    // Search for a Node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Deleting a Node from the linked list
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist.");
            return;
        }

        if (location == 0) { // Deleting the first node
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size - 1) { // Deleting the last node
            if (size == 1) { // If there's only one node
                head = null;
                tail = null;
                size--;
                return;
            }
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { // Deleting a node from the middle
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.createdLinkedList(5);
        sll.insertInLinkedList(10, 1);
        sll.insertInLinkedList(15, 2);
        sll.insertInLinkedList(20, 3);
        sll.traverseLinkedList(); // Output: 5 -> 10 -> 15 -> 20

        sll.deleteNode(2); // Deleting the node with value 15
        sll.traverseLinkedList(); // Output: 5 -> 10 -> 20

        sll.deleteNode(0); // Deleting the first node
        sll.traverseLinkedList(); // Output: 10 -> 20

        sll.deleteNode(1); // Deleting the last node
        sll.traverseLinkedList(); // Output: 10
    }
}

class Node {
    public int value;
    public Node next;
}