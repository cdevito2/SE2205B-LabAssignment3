import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//cdevito2, mdsilva6
class Flow {

    // made interfaces for Graph and Edge to remove errors
    /*interface Graph{
        int numVertices();
        Edge<E> getEdge(Vertex<V> u, Vertex<V> v);
    }

    interface Edge<E>{
        int flowCapacity();
        int flow();
    }*/

//last two arguments indicate the
//labels/numbers assigned to the vertices (start and end nodes

    public void maximizeFlowNetwork(Graph fN, int s, int t)
    {
        int parent[] = new int[fn.numVerticies()];
        int maxFlow = 0;
        while(breadthFirstPathSearch(fN, s, t)==1){ // runs while these is a path, as determined by BFS algorithm
            int pathFlow = Integer.MAX_VALUE; // this is cuase to calculate the bottleneck, so it is set to a very high value

            for( int i = 0; i!= s; i = parent[i]){
                int j = parent[i];
                pathFlow = Math.min(pathFlow, fN.opposite(j,i)) // returns the minimum of the two values
            }

            for (int i = t; i != s; i = parent[i]){
                int j = parent[i];
                fN.opposite(j,i) -= pathFlow; // accounting for backflow 
                fN.opposite(i,j) += pathFlow;

            }
            maxFlow += pathFlow;
        }
    }


    public int breadthFirstPathSearch(Graph FN, int s, int d)
    {
        int visitedNodes[] = new int[FN.numVertices()]; // array to store visited vertices
        int parent[] = new int[FN.numVerticies()];
        //initializes an array that is equal in size to the number of vertices in the graph
        for (int i = 0; i < FN.numVertices(); i ++){
            visitedNodes[i] = 0; //setting all elements in visitedNodes array to 0
        }
        LinkedListQueue<Integer> queue  = new LinkedListQueue<Integer>; // Declaring a queue to store the nodes
        queue.enqueue(s);
        visitedNodes[s] = 1;
        parent[s] = -1;

        while(!queue.isEmpty()){ // runs while the queue is not empty
            int x = queue.poll();
            for (int j = 0; j < FN.numVertices(); j++){ // checking edges
                if(visitedNodes[j] == 0 && (edge.flowCapacity() - edge.flow())>0){
                    // if this case is true, then there is an edge
                    parent[j] = x;
                    queue.enqueue(j);
                    visitedNodes[j] = 1;
                }
            }
        }
        if (visitedNodes[d] == 1){
            return 1; // return 1 if destination node has been visited
        }
        else
            return 0; // else returns 0

    }




}