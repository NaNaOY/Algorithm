package Graph;

import java.util.Queue;

public abstract class AbstractGraph<T> implements Graph<T> {
    protected static final int MAX_WEIGHT=0x0000fffff;
    protected SeqList<T> vertexlist;
    public AbstractGraph() {
        this.vertexlist = new SeqList<T>();
    }
    public int vertexCount() {
        return this.vertexlist.size();
    }
    public String toString() {
        return "顶点集合：" +this.vertexlist.toString()+"\n";
    }
    public T get(int i) {
        return this.vertexlist.get(i);
    }
    public void set(int i, T x) {
        this.vertexlist.set(i, x);
    }
    public int search(T key) {
        return this.vertexlist.search(key);
    }
    public T remove(T key) {
        return this.remove(this.search(key));
    }
    protected abstract int next(int i, int j);

    public void DFSTraverse(int i) {
        if(i<0 || i>=this.vertexCount())
            return;
        boolean[] visited=new boolean[this.vertexCount()];
        int j=i;
        do {
            if(!visited[j]) {
                System.out.print("{ ");
                this.depthfs(j,visited);
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();
        }while(j!=i);
        System.out.println();
    }
    private void depthfs(int i, boolean[] visited) {
        System.out.print(this.get(i) + " ");
        visited[i] = true;
        for(int j=next(i,-1); j!=-1; j=next(i,j))
            if(!visited[j])
                depthfs(j,visited);
    }
    public void BFSTraverse(int i) {
        if(i<0 || i>=this.vertexCount())
            return;
        boolean[] visited = new boolean[this.vertexCount()];
        SeqQueue<Integer> que = new SeqQueue<Integer>(this.vertexCount()-1);
        int j=i;
        do {
            if(!visited[j]) {
                System.out.print("{ ");
                breadthfs(j, visited, que);
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();
        }while(j!=i);
        System.out.println();
    }
    private void breadthfs(int i, boolean[] visited, SeqQueue<Integer> que) {
        System.out.print(this.get(i)+" ");
        visited[i] = true;
        que.add(i);
        while(!que.isEmpty()) {
            i = que.poll();
            for(int j =next(i,-1); j!=-1; j=next(i,j)) {
                if(!visited[j]) {
                    System.out.print(this.get(j)+" ");
                    visited[j] = true;
                    que.add(j);
                }
            }
        }
    }
    public void minSpanTree() {
        Triple[] mst = new Triple[vertexCount()-1];
        for(int i=0; i<mst.length; i++)
            mst[i]=new Triple(0, i+1, this.weight(0, i+1));
        for(int i=0; i<mst.length; i++) {
            int min =i;
            for(int j=i+1; j<mst.length; j++)
                if(mst[j].value < mst[min].value)
                    min = j;
            Triple edge = mst[min];
            if(min !=i) {
                mst[min] = mst[i];
                mst[i] = edge;
            }
            int tv = edge.column;
            for(int j=i+1; j<mst.length; j++) {
                int v = mst[j].column,w;
                if((w=weight(tv,v)) < mst[j].value)
                    mst[j] = new Triple(tv,v,w);
            }
        }
        System.out.print("\n最小生成树的边集合： ");
        int mincost=0;
        for(int i=0; i<mst.length; i++) {
            System.out.print(mst[i]+" ");
            mincost += mst[i].value;
            System.out.println(", 最小代价为"+mincost);
        }
    }
    public void shortestPath(int i) {
        int n = this.vertexCount();
        boolean[] S = new boolean[n];
        S[i] = true;
        int[] path=new int[n], dist=new int[n];
        for(int j=0; j<n; j++) {
            dist[j] = this.weight(i,j);
            path[j] = (j!=i && dist[j]<MAX_WEIGHT) ? i : -1;
        }
        for(int j=(i+1)%n; j!=i; j=(j+1)%n) {
            int mindist = MAX_WEIGHT, min=0, w;
            for(int k=0; k<n; k++) {
                if(!S[k] && dist[k]<mindist) {
                    mindist = dist[k];
                    min = k;
                }
            }
            if(mindist==MAX_WEIGHT)
                break;
            S[min] = true;
            for(int k=0; k<n; k++) {
                if(!S[k] && (w=weight(min, k))<MAX_WEIGHT && dist[min]+w<dist[k]) {
                    dist[k] = dist[min] + w;
                    path[k] = min;
                }
            }
        }
        System.out.print(this.get(i)+"顶点的单源最短路径： ");
        for(int j=0; j<n; j++)
            if(j!=i)
                System.out.print(toPath(path, i, j)+"长度"+(dist[j]==MAX_WEIGHT ? "∞" : dist[j])+" ");
        System.out.println();
    }
    private String toPath(int[] path, int i, int j) {
        SinglyList<T> link = new SinglyList<T>();
        link.insert(this.get(j));
        for(int k=path[j]; k!=i &&k!=j && k!=-1; k=path[k])
            link.insert(0, this.get(k));
        link.insert(0, this.get(i));
        return link.toString();
    }
}
