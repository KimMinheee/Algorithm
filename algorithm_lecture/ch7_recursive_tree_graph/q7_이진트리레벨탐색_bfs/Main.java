package algorithm_lecture.ch7_recursive_tree_graph.q7_이진트리레벨탐색_bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    public Node(int data){
        this.data = data;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;
    public void BFS(Node root){
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int L = 0;//계층 변수
        while(!que.isEmpty()){
            int len = que.size();

            System.out.print(L+" : ");
            for(int i=0; i<len; i++){
                Node cur = que.poll();
                System.out.print(cur.data+" ");
                if(cur.lt!=null) que.offer(cur.lt);
                if(cur.rt!=null) que.offer(cur.rt);
            }
            System.out.println("");
            L++;
        }


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
        tree.BFS(tree.root);
    }
}
