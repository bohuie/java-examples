public abstract class Entry
{ 
  protected String author;
  protected String text;

  public abstract String getAuthor();
  public abstract String getText();
  public String toString() { return text + " By: " + author; }
}
