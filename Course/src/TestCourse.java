
public class TestCourse
{
  public static void main( String[] args )
  {
    Course cosc111 = new Course( 30, 70 ); 
    cosc111.makeNewAsgn( 25 );
    cosc111.makeNewAsgn( 34 );
    cosc111.makeNewTest( 40 );
    
    int studId = 12345;
    cosc111.addStudent( "Ann", "Aronaut", studId );
    cosc111.addAsgnMarkForStudent( studId, 22.5 );
    cosc111.addAsgnMarkForStudent( studId, 30 );
    cosc111.addTestMarkForStudent( studId, 39 );

    /*
    studId = 23456;
    cosc111.addStudent( "Bob", "Berrille", studId );
    cosc111.addAsgnMarkForStudent( studId, 12.5 );
    cosc111.addAsgnMarkForStudent( studId, 17 );
    cosc111.addTestMarkForStudent( studId, 20 );
    */
    
    studId = 34567;
    cosc111.addStudent( "Cam", "Camolot", studId );
    cosc111.addAsgnMarkForStudent( studId, 25 );
    cosc111.addAsgnMarkForStudent( studId, 34 );
    cosc111.addTestMarkForStudent( studId, 40 );
    
    System.out.println( cosc111.toString() );
  }

}
