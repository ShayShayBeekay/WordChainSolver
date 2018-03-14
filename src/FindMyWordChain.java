import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Find chains between 2 words
 * @author Shay Brennan-Kelly
 */
public class FindMyWordChain {

    public static void main( String [] args ) {
        if ( args.length != 2 ) {
            System.err.println( "Please submit only 2 words" );
            System.exit( 1 );
        }

        Wordchain wc = new WordchainImplementation( loadDict(), 10 );
        for( String s: wc.getChain( args[0], args[1]) ) {
            System.out.println( s );
        }
    }

    public static String [] loadDict() {
        try ( BufferedReader reader = new BufferedReader( new InputStreamReader(  FindMyWordchain.class.getResourceAsStream("/websters-dictionary.txt") )  ) ) {
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