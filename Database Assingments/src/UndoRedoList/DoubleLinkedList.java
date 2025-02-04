package UndoRedoList;

class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;  // Points to the current state
    private Node head;          // Points to the first node in the list
    private Node tail;          // Points to the last node in the list

    // Undo operation: Navigate to the previous state
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        System.out.println("No more undo steps available.");
        return null;
    }

    // Redo operation: Navigate to the next state
    public T redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        System.out.println("No more redo steps available.");
        return null;
    }

    // Add a new state and set it as the current state
    public void addState(T newState) {
        Node newNode = new Node(newState);

        if (currentState == null) {
            head = tail = currentState = newNode;
        } else {
            newNode.prev = currentState;
            currentState.next = newNode;
            tail = newNode;
            currentState = newNode;
        }
    }

    // Display the entire state sequence
    public void displayStates() {
        Node temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            if (temp == currentState) {
                sb.append("[").append(temp.state).append("]"); // Highlight current state
            } else {
                sb.append(temp.state);
            }
            if (temp.next != null) {
                sb.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println("State Sequence: " + sb.toString());
    }

    // Main method for testing
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        // Adding states
        manager.addState("1");
        manager.addState("2");
        manager.addState("3");
        manager.addState("4");
        manager.addState("5");

        // Display the sequence
        manager.displayStates();

        // Performing undo and redo operations
        System.out.println("Undo: " + manager.undo());
        manager.displayStates();
        System.out.println("Undo: " + manager.undo());
        manager.displayStates();
        System.out.println("Redo: " + manager.redo());
        manager.displayStates();
        System.out.println("Redo: " + manager.redo());
        manager.displayStates();
        System.out.println("Undo: " + manager.undo());
        manager.displayStates();
    }
}
