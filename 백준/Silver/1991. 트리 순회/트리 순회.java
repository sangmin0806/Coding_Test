import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        Tree t = new Tree();
        t.setRoot(new Node('A',null,null));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            t.makeNode(t.getRoot(),left,data,right);
        }
        t.preorder(t.getRoot());
        System.out.println();
        t.inorder(t.getRoot());
        System.out.println();
        t.postorder(t.getRoot());
    }
}
class Node{
    char data;
    Node left;
    Node right;
    Node(char data,Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class Tree{
    private Node root;
    public void setRoot(Node node){
        this.root = node;
    }
    public Node getRoot(){
        return root;
    }
    public void makeNode(Node node,char left, char data, char right){
        if(node.data==data){ //root일때,
            if(left=='.'){
                node.left = null;
            }
            else {
                node.left = new Node(left,null,null);
            }
            if(right=='.'){
                node.right = null;
            }
            else {
                node.right = new Node(right,null,null);
            }
        }
        else { //root 말고 다른거 들어왔을때,
            if(node.left != null){
                makeNode(node.left,left,data,right);
            }
            if(node.right != null){
                makeNode(node.right,left,data,right);
            }
        }
    }
    public void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }
    public void preorder(Node node){
        if(node != null){
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postorder(Node node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
}
