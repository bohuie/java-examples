/*
 * A course has multiple components to it, such as assignments and tests.
 * Each course may have a maximum of 300 students.
 */
public class Course
{
  // attributes
  Student[]         students;
  int               numStudents;

  // class constants
  private final int MAXSTUDENTS = 300;

  // class variables to designate the total number of points possible for
  // each component of the course
  public static int asgns_total;
  public static int tests_total;

  // class variables to designate how much each component is worth for the
  // course
  public static int asgns_weight;
  public static int tests_weight;

  // constructor
  public Course( int aw, int tw )
  {
    // initially, there are no students in the course
    students = new Student[MAXSTUDENTS];
    numStudents = 0;

    // initially, there are no scores yet
    asgns_total = 0;
    tests_total = 0;

    // assignments are collectively worth 30% of the course, tests are
    // collectively worth 70%, etc.
    asgns_weight = aw;
    tests_weight = tw;
  }

  /*
   * when a new assignment is created for the course, the max possible
   * score for that assignment is added to the total assignment score for
   * the course
   */
  public void makeNewAsgn( int possibleScore )
  {
    asgns_total += possibleScore;
  }

  /*
   * when a new test is created for the course, the max possible score for
   * that test is added to the total test score for the course
   */
  public void makeNewTest( int possibleScore )
  {
    tests_total += possibleScore;
  }

  /*
   * add a student to the course with the given information
   */
  public void addStudent( String first, String last, int id )
  {
    Student stud = new Student( first, last, id );
    students[numStudents] = stud;
    numStudents++;
  }

  /*
   * adds a specific assignment mark for a specific student
   */
  public void addAsgnMarkForStudent( int id, double mark )
  {
    for( int i = 0; i < numStudents; i++ )
      if( students[i].getId() == id )
        students[i].addAssignmentScore( mark );
  }

  /*
   * adds a specific test mark for a specific student
   */
  public void addTestMarkForStudent( int id, double mark )
  {
    for( int i = 0; i < numStudents; i++ )
      if( students[i].getId() == id )
        students[i].addTestScore( mark );
  }

  /*
   * print out each student's name and overall course grade
   */
  public String toString()
  {
    String str = "";
    for( int i = 0; i < numStudents; i++ )
      str += students[i].toString();
    return str;
  }
}
