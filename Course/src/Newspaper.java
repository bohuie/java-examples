public class Newspaper extends Reading
{
  private int    numberOfArticles;
  private String publisher;

  public Newspaper( String title, int year, int numPages,  
      String pubber, int numArticles )
  {
    super( title, year, numPages );
    numberOfArticles = numArticles;
    publisher = pubber;
  }

  public int getNumberOfArticles() { return numberOfArticles; }
  public String getPublisher()     { return publisher; }
  public void setNumberOfArticles( int newNum ) { numberOfArticles = newNum; }
  public void setPublisher( String newPub )     { publisher = newPub; }
  
  public String toString()
  {
    return super.toString() 
         + "Publisher: " + publisher + "\n"
    + "Number of Articles: " + numberOfArticles + "\n" ;
  }
}
