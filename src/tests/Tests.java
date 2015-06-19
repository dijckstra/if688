package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import builder.CGUtils;
import builder.StringGraph;

import com.ibm.wala.ipa.callgraph.CallGraph;

/**
 * @author Dicksson Rammon Oliveira de Almeida (droa
 *
 * Class used to perform tests on call-graphs generated from samples.
 */
public class Tests {	
	/**
	 * Tests to see if the specific class has mutual recursion. 
	 */
	@Test
	public void mutualRecursionTest() {
		try {
			CallGraph cg;
			StringGraph graph;			
			cg = CGUtils.buildCG(SamplePaths.SAMPLE_ONE);
			graph = new StringGraph(cg);
			
			ArrayList<String> edges1 = graph.nodes.get("samples.SampleFour.even(I)Z");
			ArrayList<String> edges2 = graph.nodes.get("samples.SampleFour.odd(I)Z");			
			
			assertTrue(edges1.contains("samples.SampleFour.odd(I)Z") && edges2.contains("samples.SampleFour.even(I)Z"));

		} catch (Exception e) { fail(e.getMessage()); }
	}
}