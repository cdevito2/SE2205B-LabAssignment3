import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//cdevito2 //mdsilva6
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
        while(breadthFirstPathSearch(fN, s, t)==1){

<<<<<<< HEAD
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
=======
>>>>>>> parent of 9dc11ef... implementing maximizeFlowNetwork(...)
        }

    }


    public int breadthFirstPathSearch(Graph FN, int s, int d)
    {
        int visitedNodes[] = new int[FN.numVertices()];
        int parent[] = new int[FN.numVerticies()]; // one less?
        //initializes an array that is equal in size to the number of vertices in the graph
        for (int i = 0; i < FN.numVertices(); i ++){
            visitedNodes[i] = 0; //setting all elements in visitedNodes array to 0
        }
        LinkedList<Integer> queue  = new LinkedList<Integer>() { // change to Queue?
        };
        queue.add(s); //change to enqueue(s)?
        visitedNodes[s] = 1;
        parent[s] = -1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int j = 0; j < FN.numVertices(); j++){
                Edge<Integer> edge = FN.getEdge(s,j);
                if(visitedNodes[j] == 0 && (edge.flowCapacity() - edge.flow())>0){
                    parent[j] = x;
                    queue.add(j);
                    visitedNodes[j] = 1;
                }
            }
        }
        if (visitedNodes[d] == 1){
            return 1;
        }
        else
            return 0;

    }




}