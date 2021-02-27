public class Problem {
    /// default constructor for class Problem
    public Source []sources;
    public int numberOfSources;
    public Destination []destinations;
    public int numberOfDestinations;
    public  int [][]  cost;
    public Problem()
    {
        System.out.println("Constructor default for Problem is called!");
    }
    /// this method takes a list of sources and save them into the array
    /// this will help later to construct the problem
   public void setSource(Source ...a)
   {
       System.out.println("Number of object of type source: " + a.length);
       this.numberOfSources=a.length;
       sources= new Source[a.length];
       for(int i = 0 ; i < a.length; i++)
           sources[i]=a[i];
   }
   /// similar to setSource, this method save de destination list into an array
    /// this will help later to construct the problem
   public void setDestination(Destination ...a)
   {
       System.out.println("Number of object of type destination: " + a.length);
       this.numberOfDestinations=a.length;
       destinations= new Destination[a.length];
       for(int i = 0 ; i < a.length; i++)
           destinations[i]=a[i];

   }

   /// once you set your own destination and source, you have to construct a matrix of cost
    /// this method takes a list of cost and construct a matrix of cost between sources and destinations
   public void setCost(int ...a)
   {
       System.out.println("number of sources is: " + numberOfSources);
       System.out.println("number of destination is: " + numberOfDestinations);
       cost= new int[numberOfSources][numberOfDestinations];
       int nr=0;
       for(int i = 0 ; i < numberOfSources; i++)
       {
           for(int j = 0 ; j < numberOfDestinations; j++)
                cost[i][j]=a[nr++];

       }
   }

}
