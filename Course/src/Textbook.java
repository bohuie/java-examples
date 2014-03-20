public class Textbook extends Reading
{
  private String subject;
  private String author;

  public Textbook( String title, int year, int numPages,  
      String sub, String auth )
  {
    super( title, year, numPages );
    subject = sub;
    author = auth;
  }

  public String getSubject()    { return subject; }
  public String getAuthor()     { return author; }
  public int getNumberOfPages() { return numberOfPages; }
  public void setSubject( String newSub )      { subject = newSub; }
  public void setAuthor( String newAuth )      { author = newAuth; }
  public void setNumberOfPages( int newReads ) { numberOfPages = newReads; }

  public String toString()
  {
    return super.toString() 
         + "Subject: " + subject + "\n" 
         + "Author: "  + author + "\n";
  }
}
