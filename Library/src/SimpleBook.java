
public class SimpleBook
{
  protected int pages;
  
  public SimpleBook( int maxPages )
  {
    pages = maxPages;
  }
  
  public void setPages( int numPages ) { pages = numPages; }
  public int getPages()                { return pages; }
}
