import java.util.Random;

/**
 * Define a class called Stats that computes and prints the mean and
 * variance of a list of N randomly generated integers in the range of 0 to
 * 100 inclusive. These integers are designated as x1 , x2 , ..., xN , for
 * a total of N = 99.
 * 
 * @author bohuie
 */
public class Stats
{
  private Random    gen;
  private int[]     numbers;

  // constant
  private final int N   = 99;
  private final int MAX = 101;

  public Stats()
  {
    numbers = new int[N];
    gen = new Random();
    // generate random values for array
    for( int i = 0; i < N; i++ )
      numbers[i] = gen.nextInt( MAX );
  }

  public double computeMean()
  {
    double mu = 0.0;
    int sum = 0;
    for( int i = 0; i < N; i++ )
      sum += numbers[i];
    mu = sum / N;
    return mu;
  }

  public double computeVar()
  {
    double var = 0.0;
    double numer = 0;
    double mean = computeMean();
    for( int i = 0; i < N; i++ )
      numer += (numbers[i] - mean) * (numbers[i] - mean);
    var = numer / N;
    return var;
  }

  public String toString()
  {
    String str = "";
    // print everything in numbers
    str += "Numbers generated are: \n";
    for( int i = 0; i < N; i++ )
      str += numbers[i] + ", ";
    str += "\n";

    // print calculated mean and var
    str += "Mean = " + computeMean() + "\n";
    str += "Var = " + computeVar() + "\n";
    return str;
  }
}
