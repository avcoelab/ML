import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Node class to represent each character and its frequency
class Node {
    char symbol;       // character (symbol)
    int freq;          // frequency of the symbol
    Node left;         // left child in the Huffman tree
    Node right;        // right child in the Huffman tree
    String huff;       // Huffman code for the node

    // Constructor to initialize a node
    Node(char symbol, int freq, Node left, Node right) {
        this.symbol = symbol;
        this.freq = freq;
        this.left = left;
        this.right = right;
        this.huff = "";
    }
}

// Main class for Huffman Encoding
public class HuffmanEncoding {
    
    // Function to print the Huffman codes for each symbol in the tree
    public static void printNodes(Node node, String val) {
        // Append the current node's Huffman direction
        String newVal = val + node.huff;

        // Traverse left and right children if the node is not a leaf
        if (node.left != null) {
            printNodes(node.left, newVal);
        }
        if (node.right != null) {
            printNodes(node.right, newVal);
        }

        // If node is a leaf (no children), print its symbol and Huffman code
        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + " -> " + newVal);
        }
    }

    public static void main(String[] args) {
        // Characters and their corresponding frequencies
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};

        // List to hold the nodes
        ArrayList<Node> nodes = new ArrayList<>();

        // Convert characters and frequencies into nodes and add them to the list
        for (int i = 0; i < chars.length; i++) {
            nodes.add(new Node(chars[i], freq[i], null, null));
        }

        // Build the Huffman tree until only one node remains
        while (nodes.size() > 1) {
            // Sort nodes in ascending order by frequency
            Collections.sort(nodes, Comparator.comparingInt(node -> node.freq));

            // Take the two nodes with the smallest frequencies
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            // Assign '0' to the left node and '1' to the right node
            left.huff = "0";
            right.huff = "1";

            // Create a new parent node with combined frequency
            Node newNode = new Node('\0', left.freq + right.freq, left, right);

            // Remove the two nodes from the list and add the new parent node
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(newNode);
        }

        // The Huffman tree is built; print the Huffman codes
        printNodes(nodes.get(0), "");
    }
}
