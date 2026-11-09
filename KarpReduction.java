import java.util.ArrayList;

public class KarpReduction {
    Kattio io;
    int V, E, m;
    int[] from, to;
    boolean[] vertices;

    void readGraph() {
        V = io.getInt();
        E = io.getInt();
        m = io.getInt();
        m = Math.min(m, V);
        from = new int[E];
        to = new int[E];
        vertices = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            int u = io.getInt();
            int v = io.getInt();
            from[i] = u;
            to[i] = v;
            vertices[u] = true;
            vertices[v] = true;
        }
    }

    void writeReduction() {
        int isolatedVerticesCount = 0;
        ArrayList<Integer> isolatedVertices = new ArrayList<Integer>();
        for (int i = 1; i < V + 1; i++) {
            if (!vertices[i]) {
                isolatedVerticesCount++;
                isolatedVertices.add(i);
            }
        }

        int n = V + 2;
        int s = E + 2 + isolatedVerticesCount;
        int k = m + 2;
        io.println(n);
        io.println(s);
        io.println(k);

        for (int i = 0; i < V; i++) {
            io.print(m);
            for (int j = 3; j <= k; j++) {
                io.print(" " + j);
            }
            io.println();
        }

        io.println(1 + " " + 1);
        io.println(1 + " " + 2);
        for (int i = 0; i < E; i++) {
            io.println(2 + " " + from[i] + " " + to[i]);
        }

        io.println(2 + " " + (V+1) + " " + 1);
        io.println(2 + " " + (V+2) + " " + 1);
        for (int i = 0; i < isolatedVerticesCount; i++) {
            io.println(2 + " " + (V+1) + " " + isolatedVertices.get(i));
        }
        io.flush();

    }
        KarpReduction() {
            io = new Kattio(System.in, System.out);
            readGraph();
            writeReduction();
            io.close();
        }
    public static void main(String args[]) {
        new KarpReduction();
    }
}
