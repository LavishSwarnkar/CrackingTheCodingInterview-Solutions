package C4_TreesAndGraphs;

public class P1_RouteBetweenNodes {

    public static void main(String args[]){
        GraphNode A = new GraphNode("A")
                , B = new GraphNode("B")
                , C = new GraphNode("C")
                , D = new GraphNode("D");
        A.children = new GraphNode[]{B, C};
        B.children = new GraphNode[]{C};
        C.children = new GraphNode[]{D};

        Graph graph = new Graph(new GraphNode[]{A, B, C, D});

        System.out.println(doesRouteExists(graph, A, D));
        System.out.println(doesRouteExists(graph, B, C));
        System.out.println(doesRouteExists(graph, C, A));
    }

    private static boolean doesRouteExists(Graph graph, GraphNode rootNode, GraphNode destNode){
        markAllAsNotVisited(graph);
        Queue<GraphNode> queue = new Queue<>();
        queue.enqueue(rootNode);

        while (!queue.isEmpty()){
            GraphNode node = queue.dequeue();
            if(node == destNode)
                return true;

            for(GraphNode child : node.children){
                if(!child.visited){
                    queue.enqueue(child);
                    child.visited = true;
                }
            }
        }
        return false;
    }

    private static void markAllAsNotVisited(Graph graph) {
        for(GraphNode node : graph.nodes)
            node.visited = false;
    }

}
