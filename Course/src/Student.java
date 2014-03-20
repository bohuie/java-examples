
public class Student
{
   private String lastName;
   private String firstName;
   private int studentId;
   private double[] scores;

   // constants
   private final int numScores = 2;
   private final int asgns_index = 0;
   private final int tests_index = 1;
   
   public Student( String first, String last )
   {
     initVars( first, last, -1 );
   }
   
   public Student( String first, String last, int id )
   {
     initVars( first, last, id );
   }
   
   private void initVars( String first, String last, int id )
   {
     firstName = first;
     lastName = last;
     studentId = id;   
     scores = new double[ numScores ];
     for( int i=0; i<scores.length; i++ )
       scores[ i ] = 0;     
   }
   
   public void setId( int newId )
   {
     studentId = newId;
   }
   
   public int getId()
   {
     return studentId;
   }
   
   public void addAssignmentScore( double mark )
   {
     scores[ asgns_index ] += mark;
   }
     
   public void addTestScore( double mark )
   {
     scores[ tests_index ] += mark;
   }
   
   private double calcPercent( double mark, int total, int weight )
   {
     double result = ( mark / total ) * weight;
     return result;
   }
   
   private double calcAsgnPercent()
   {
     return calcPercent( scores[ asgns_index ], Course.asgns_total, Course.asgns_weight );
   }

   private double calcTestPercent()
   {
     return calcPercent( scores[ tests_index ], Course.tests_total, Course.tests_weight );
   }

   public double calcCoursePercent()
   {
     return calcAsgnPercent() + calcTestPercent();
   }
   
   public String toString()
   {
     String str = "";
     str += "Student: " + lastName + ", " + firstName + "\t";
     str += "Course grade: " + (calcAsgnPercent() + calcTestPercent()) + "\n";
     return str;
   }
}
