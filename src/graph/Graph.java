package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;//顶点个数
    private LinkedList<Integer>[] adj;//邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    //s到t的路径
    public void dfs(int s, int t) {
        if (s == t){
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        while (!queue.isEmpty()){
            int edge = queue.poll();
            for(int i=0;i<adj[edge].size();i++){
                if ()
            }
        }
    }
}
