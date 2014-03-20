public class TestBlog
{
  public static void main( String[] args )
  {
    // create comments + test them
    System.out.println( "Testing Comment class..." );
    Comment c1 = new Comment( "bitz", "yo that was good" );
    Comment c2 = new Comment( "bitz", "yeah i know" );
    Comment c3 = new Comment( "yo that was good" );
    
    System.out.println( "Checking nodes..." );
    System.out.println( c1 );
    System.out.println( c2 );
    System.out.println( c3 );

    // c1.setNext( c3 );
    // c3.setNext( c2 );
    
    System.out.println( "Checking comparisons..." );
    System.out.println( c1.compareTo( c3 ) );
    System.out.println( c1.compareTo( c2 ) );
    System.out.println( c1.compareTo( c1 ) );

    System.out.println( "Testing Post class..." );
    Post p1 = new Post( "casper", "today, we went for a long nap..." );
    System.out.println( p1 );

    p1.delete( new Comment( "boooo") );

    p1.add( c3 );
    p1.add( c1 );
    p1.add( c2 );
    System.out.println( p1 );

    System.out.println( "Testing deletion..." );
    // delete c3: front of list
    // delete c1: middle of list
    // delete c2: end of list
    // p1.delete( c2 );
    p1.delete( new Comment( "boooo") );
    System.out.println( p1 );
  }
}
