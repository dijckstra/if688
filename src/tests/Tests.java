package tests;

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
			
			ArrayList<String> edges1 = graph.nodes.get("samples.SampleOne.even(I)Z");
			ArrayList<String> edges2 = graph.nodes.get("samples.SampleOne.odd(I)Z");			
			
			assertTrue(edges1.contains("samples.SampleOne.odd(I)Z") && edges2.contains("samples.SampleOne.even(I)Z"));

		} catch (Exception e) { fail(e.getMessage()); }
	}
	
	/**
	 * Test to see if a class has been instantiated but none of its methods were used.
	 */
	@Test
	public void classNotUsedTest() {
		try {
			CallGraph cg;
			StringGraph graph;			
			cg = CGUtils.buildCG(SamplePaths.SAMPLE_ONE);
			graph = new StringGraph(cg);
			
			ArrayList<String> edges = graph.nodes.get("samples.SampleOne.main([Ljava/lang/String;)V");
			
			assertTrue(edges.contains("samples.B.<init>()V") && !edges.contains("samples.B.foo()I"));
			
			assertTrue(true);
			
		} catch (Exception e) { fail(e.getMessage()); }
	}
}