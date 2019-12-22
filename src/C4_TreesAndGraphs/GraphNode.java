package C4_TreesAndGraphs;

public class GraphNode {

    private String name;
    GraphNode[] children;
    boolean visited = false;

    GraphNode(String name, GraphNode[] children){
        this.name = name;
        this.children = children;
    }

    GraphNode(String name){
        this.name = name;
        this.children = new GraphNode[]{};
    }

    @Override
    public String toString() {
        return name;
    }
}
