public class TestGradesTracker
{
  public static void main( String[] args )
  {
    GradesTracker gt = new GradesTracker();
    gt.enterGrades();
    gt.calculateGrade();
    System.out.println( "Based on the marks you entered," );
    System.out.println( "your course grade so far is: " + gt.getCourseGrade() );
  }
}
