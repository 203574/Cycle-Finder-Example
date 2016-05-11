import java.util.List;

import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.cycle.TiernanSimpleCycles;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class Main {

	public static void main(String[] args) {

		DefaultDirectedGraph<Integer, DefaultEdge> graph;
		graph = new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);

		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);

		// First cycle
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 1);

		// Second cycle
		graph.addEdge(2, 1);

		System.out.println("Grafo creato: " + graph.vertexSet().size() + " nodi, " + graph.edgeSet().size() + " archi\n");

		System.out.println("Uso CycleDetector");

		CycleDetector<Integer, DefaultEdge> cycleDetector;
		cycleDetector = new CycleDetector<Integer, DefaultEdge>(graph);

		// Esistono cicli?
		System.out.println("Esistono cicli?");
		System.out.println(cycleDetector.detectCycles());

		for (Integer vertex : graph.vertexSet()) {
			System.out.println("vertex: " + vertex);
			System.out.println(cycleDetector.findCyclesContainingVertex(vertex));
			System.out.println(" ");
		}

		System.out.println("Uso TiernanSimpleCycles");

		TiernanSimpleCycles<Integer, DefaultEdge> superCycleDetector;
		superCycleDetector = new TiernanSimpleCycles<Integer, DefaultEdge>(graph);

		List<List<Integer>> cycles = superCycleDetector.findSimpleCycles();

		int counter = 0;
		for (List<Integer> cycle : cycles) {
			System.out.println("Cycle #: " + counter++ + ". Numer of vertex: " + cycle.size());
			System.out.println(cycle);
			System.out.println(" ");
		}

	}

}
