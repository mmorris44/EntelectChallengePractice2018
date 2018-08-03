package BlindGraphTraversal;

import java.util.Scanner;

import ProofSystem.ProofStatement;

public class AcyclicShortestPathSearcher {

	Scanner sc = new Scanner(System.in);
	HaltingCondition haltCondition;
	private AcyclicBreadthFirstPathTraverser traverser;
	
	public AcyclicShortestPathSearcher(HaltingCondition halt) {
		this.haltCondition = halt;
	}
	
	public AcyclicPath findPathFrom(Nodal startNode) {
		traverser = new AcyclicBreadthFirstPathTraverser(startNode);
		
		Path nextPath;
		
		int prevCost = 0;
		
		while((nextPath = traverser.nextPath()) != null) {
			if(this.haltCondition.isSatisfiedBy(nextPath)) break;
		
			if(nextPath.getCost()!=prevCost) {
				prevCost = nextPath.getCost();
			}
			
			ProofStatement.visitedStatements.put(((ProofStatement) nextPath.getLastNode()).getStatement().toString(), true);
			//System.out.println(((ProofStatement) nextPath.getLastNode()).getStatement().toString());
			//sc.nextLine();
		}
		
		return (AcyclicPath) nextPath;
	}
	
	public int getNumEdges() {
		return this.traverser.getNumEdges();
	}

}
