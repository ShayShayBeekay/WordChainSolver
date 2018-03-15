import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// import WordChain;
// import WordChainImplementation;

/**
 * Find chains between 2 words
 * @author Shay Brennan-Kelly
 */


public class FindMyWordChain {

    public static void main( String [] args ) {
        if ( args.length < 2 ) {
            System.err.println( "Please submit 2 words, no words submitted" );
            System.exit( 1 );
        }
        else if ( args.length != 2 ) {
            System.err.println( "Please submit only 2 words" );
            System.exit( 1 );
        }

        WordChain wc = new WordChainImplementation( loadDict(), 10 );
        String[] chain = wc.getChain( args[0], args[1]);
        if(chain.length<1){
            System.out.println("No chain found for "+args[0]+" and "+args[1]);
        }else{
            for( String s: chain ) {
                System.out.println( s );
            }
        }
    }

    public static String [] loadDict() {
        try ( BufferedReader reader = new BufferedReader( new InputStreamReader(FindMyWordChain.class.getResourceAsStream("websters-dictionary.txt") )  ) ) {
            List<String> l = new ArrayList<>();
            String s;
            while ( (s = reader.readLine() ) !=null ) {
                l.add(s);
            }
            return l.toArray(new String[l.size()]);
        }
        catch( IOException e ) {
            throw new RuntimeException(e);
        }
    }

}