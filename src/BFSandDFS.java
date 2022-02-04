import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFSandDFS {
    private LinkedList<Integer> adj[];
    public BFSandDFS(int v){
        adj = new LinkedList[v];
        for(int i =0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int source,int destination){
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public int bfs(int source,int destination){
        boolean vis[] = new boolean[adj.length];
        int parent[]  = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        parent[source]= -1;
        vis[source]=true;

        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur == destination){
                break;
            }
            for (int neighbour: adj[cur]){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.add(neighbour);//q generated
                    parent[neighbour] = cur;//parent array generated
                }
            }
        }
        //now checking
        int cur= destination;
        int dist =0;
        while (parent[cur] !=-1){
            System.out.println(cur+ " ->");
            cur = parent[cur];
            dist++;
        }
        return dist;
    }
    private boolean dfsUtil(int source,int destination,boolean vis[]){
        if(source == destination) return  true;//base case...u are at destination
        for(int neighbour: adj[source]){
            if (!vis[neighbour]){
                vis[neighbour] = true;
                boolean isConnected = dfsUtil(neighbour,destination,vis);
                if(isConnected) return true;
            }
        }
        return false;
    }
    public boolean dfs(int source,int destination){
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        return dfsUtil(source,destination,vis);
    }
    public boolean dfsStack(int source,int destination){
        boolean vis[] = new boolean[adj.length];
        vis[source]=true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            System.out.println(cur + " ");
            if(cur==destination) return true;
            for(int neighbor: adj[cur]){
                if(!vis[neighbor]){
                    vis[neighbor]= true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        BFSandDFS graph = new BFSandDFS(v);
        System.out.println("Enter "+ e + " edges");
        for(int i =0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source,destination);
        }
        System.out.println("Enter source and destination: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("For DFS : ");
        System.out.println("Path possible: "+ graph.dfsStack(a,b));

        //bfs
        System.out.println("For bfs : ");
        int distance = graph.bfs(a,b);
        System.out.println("Shortest distance= "+distance);
    }
}
//"C:\Program Files\Java\jdk-16.0.1\bin\java.exe" "-javaagent:C:\Users\apurv\Desktop\IntelliJ IDEA Community Edition 2020.2.2\lib\idea_rt.jar=52575:C:\Users\apurv\Desktop\IntelliJ IDEA Community Edition 2020.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\apurv\IdeaProjects\Java-Basic-course\Practice for basic programming and dsa\out\production\Practice for basic programming and dsa;C:\Users\apurv\AppData\Local\Programs\Python\Python38\DLLs;C:\Users\apurv\AppData\Local\Programs\Python\Python38\Lib;C:\Users\apurv\AppData\Local\Programs\Python\Python38;C:\Users\apurv\venv\Python3.8;C:\Users\apurv\venv\Python3.8\Lib\site-packages;C:\Users\apurv\AppData\Local\JetBrains\IdeaIC2020.2\python_stubs\246410025;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\python-skeletons;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\typeshed\stdlib\3.7;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\typeshed\stdlib\3;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\typeshed\stdlib\2and3;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\typeshed\third_party\3;C:\Users\apurv\AppData\Roaming\JetBrains\IdeaIC2020.2\plugins\python-ce\helpers\typeshed\third_party\2and3" BFSandDFS
//Enter number of vertices and edges
//6
//8
//Enter 8 edges
//2 4
//2 5
//1 6
//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
//	at BFSandDFS.addEdge(BFSandDFS.java:17)
//	at BFSandDFS.main(BFSandDFS.java:93)
//
//Process finished with exit code 1