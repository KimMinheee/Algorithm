package algorithm_lecture.ch4_recursive_tree_graph.q10_tree말단노드까지가장짧은경로_bfs;


import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    int depth;
    Node lt,rt;
    public Node(int data, int depth){
        this.data = data;
        this.depth = depth;
        this.lt = null;
        this.rt = null;
    }
    public Node(int data){
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
public class Main {
    Node root;
    static int min = Integer.MAX_VALUE;

    public void BFS(Node root, int depth){
        root.depth = depth;

        Queue que = new LinkedList<>();
        que.offer(root);//처음 root 큐에 담기

        while(!que.isEmpty()){
            Node node = (Node)que.poll();
            System.out.println(node.data+ " "+node.depth);
            if(node.lt==null && node.rt == null){
                min = Math.min(min,node.depth);
                return; //발견하면 그냥 끝내도 무방. return 하지 않으면 모든 노드를 돈다.
            }
            if(node.lt!=null) {
                node.lt.depth = node.depth+1;
                que.offer(node.lt);
            }
            if(node.rt!=null){
                node.rt.depth = node.depth+ 1;
                que.offer(node.rt);
            }
        }
    }

    public static void main(String[] args){
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.BFS(tree.root,0);
        System.out.println(min);
    }
}
