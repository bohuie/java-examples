public class Reading
{
  protected int    numberOfPages;
  protected int    publicationYear;
  protected String title;

  public Reading( String materialTitle, int pubYear, int numPages )
  {
    numberOfPages = numPages;
    publicationYear = pubYear;
    title = materialTitle;
  }

  public int getNumberOfPages()   { return numberOfPages; }
  public int getPublicationYear() { return publicationYear; }
  public String getTitle()        { return title; }
  public void setNumberOfPages( int newNumPages ) { numberOfPages = newNumPages; }
  public void setPublicationYear( int newYear )   { publicationYear = newYear; }
  public void setTitle( String newTitle )         { title = newTitle; }

  public String toString()
  {
    return "Title: " + title + "\n"
         + "Publication Year: " + publicationYear + "\n" 
         + "Number of Pages: "  + numberOfPages + "\n"; 
  }
}