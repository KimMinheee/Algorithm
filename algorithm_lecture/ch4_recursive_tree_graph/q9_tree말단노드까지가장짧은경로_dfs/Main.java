package algorithm_lecture.ch4_recursive_tree_graph.q9_tree말단노드까지가장짧은경로_dfs;
//자식이 양쪽 다 존재한다는 전제가 필요.
class Node{
    int data;
    Node lt,rt;

    public Node(int data){
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}

public class Main {
    Node root;
    static int min = Integer.MAX_VALUE;

    public void DFS(Node root,int depth){
        if(root.lt == null && root.rt == null){
            min = Math.min(depth,min);
            return;
        }

        DFS(root.lt,depth+1); //b
        DFS(root.rt, depth+1); //d
    }

    public static void main(String[] args){
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.DFS(tree.root,0);
        System.out.println(min);
    }
}

