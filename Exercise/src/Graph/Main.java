package Graph;


public class Main {
    public static void main(String[] args) {
        String[] vertexes= {"A","B","C","D","E","F"};
        Triple[] edges= {new Triple(0,1,45), new Triple(0,2,28),new Triple(0,3,10),new Triple(1,0,45), new Triple(1,2,12), new Triple(1,4,21),new Triple(2,0,28), new Triple(2,1,12), new Triple(2,3,17),new Triple(2,4,26),new Triple(3,0,10), new Triple(3,2,17), new Triple(3,4,15), new Triple( 3,5,13), new Triple(4,1,21),new Triple(4,2,26), new Triple(4,3,15), new Triple(4,5,11),new Triple(5,3,13), new Triple(5,4,11)};
        MatrixGraph<String> graph= new MatrixGraph<String>(vertexes, edges);
        System.out.println("带权无向图G3,"+graph.toString());
        graph.minSpanTree();
        graph.BFSTraverse(1);
        graph.DFSTraverse(1);
        graph.shortestPath(1);
    }
}