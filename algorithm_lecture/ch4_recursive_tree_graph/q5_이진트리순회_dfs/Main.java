package algorithm_lecture.ch4_recursive_tree_graph.q5_이진트리순회_dfs;

class Node{
    int data;
    Node lt, rt; //노드의 왼쪽 자식노드, 오른쪽 자식 노드의 주소값을 저장한다.
    public Node(int data){
        this.data = data;
        lt = rt = null;
    }
}

public class Main {
    Node root;
    public void DFS(Node root){
        if(root == null) return;

        System.out.println(root.data);
        DFS(root.lt);
        DFS(root.rt);
    }

    public static void main(String[] args){
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.DFS(tree.root);
    }
}
