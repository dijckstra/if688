/***
 * @author Dicksson Rammon Oliveira de Almeida (droa)
 * 
 * Mutual recursion sample.
 * See https://en.wikipedia.org/wiki/Mutual_recursion
 * 
 */
package samples;

public class SampleOne {

	boolean even( int number ) {    
	    if( number == 0 )
	        return true;
	    else
	        return odd(Math.abs(number)-1);
	}

	boolean odd( int number ) {
	    if( number == 0 )
	        return false;
	    else
	        return even(Math.abs(number)-1);
	}
	
	public static void main(String[] args) {
		SampleOne tester = new SampleOne();
		tester.even(5);
	}
}
