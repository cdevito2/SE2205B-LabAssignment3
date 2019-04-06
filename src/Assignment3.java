import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//cdevito2 //mdsilva6
class Flow {

//last two arguments indicate the
//labels/numbers assigned to the vertices (start and end nodes

    public void maximizeFlowNetwork(Graph fN, int s, int t)
    {

    }


    public int breadthFirstPathSearch(Graph FN, int s, int d)
    {
        int visitedNodes[] = new int[FN.numVertices()];
        //initializes an array that is equal in size to the number of vertices in the graph
        for (int i = 0; i < FN.numVertices(); i ++){
            visitedNodes[i] = 0; //setting all elements in visitedNodes array to 0
        }
        LinkedList<Integer> queue  = new LinkedList<Integer>() { // change to Queue?
        };
        queue.add(s); //change to enqueue(s)?
        visitedNodes[s] = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int j = 0; j < FN.numVerticies; j++){
                Edge<E> edge = FN.getEdge(s,j);
                if(visitedNodes[j] == 0 && (edge.flowCapacity() - edge.flow())>0){
                    // set parent of node j to node x
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