package algorithm_lecture.ch7_recursive_tree_graph.q10_tree말단노드까지가장짧은경로_bfs;

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    int data;
    Node2 lt, rt;
    public Node2(int data){
        this.data = data;
        lt = rt = null;
    }
}
public class Solution {
    Node2 root;
    public int BFS(Node2 root){
        Queue<Node2> que = new LinkedList<>();
        que.offer(root);
        int L = 0;
        while(!que.isEmpty()){
            int len = que.size();
            for(int i=0; i<len; i++){ //que에 들은 갯수만큼 반복
                Node2 cur = que.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) que.offer(cur.lt);
                if(cur.rt != null) que.offer(cur.rt);
            }
            L++;
        }
        return 0 ;
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node2(1);
        tree.root.lt = new Node2(2);
        tree.root.rt = new Node2(3);
        tree.root.lt.lt = new Node2(4);
        tree.root.lt.rt = new Node2(5);

        System.out.println(tree.BFS(tree.root));
    }
}
