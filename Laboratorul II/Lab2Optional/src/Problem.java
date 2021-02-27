/**
 * This class allow you to create your own problem by customizing the source type and destination type.
 * You are allowed to customize your own type of Source by setting: supply number, name or type of Source.
 * This is similar for Destination as well.
 */
public class Problem {

    /// default constructor for class Problem
    public Source []sources;
    public int numberOfSources;
    public Destination []destinations;
    public int numberOfDestinations;
    public  int [][]  cost;
    public int[]arrayOfCost;
    public Problem()
    {
        System.out.println("Constructor default for Problem is called!");
    }

    /**
     * Here you can add to the problem your own type of Sources that have different supply and name.
     *  Be careful, this method use variable number of arguments!
     * @param a this parameter is of type Source and it's even a Warehouse or a Factorie
     */
    public void setSource(Source ...a)
    {
        System.out.println("Number of object of type source: " + a.length);
        this.numberOfSources=a.length;
        sources= new Source[a.length];
        for(int i = 0 ; i < a.length; i++)
            sources[i]=a[i];
    }

    /**
     * Here you can add to the problem your own Destinations that have different demands and name.
     * Be careful, this method use variable number of arguments!
     * @param a this parameter is of type Destination
     */
    public void setDestination(Destination ...a)
    {
        System.out.println("Number of object of type destination: " + a.length);
        this.numberOfDestinations=a.length;
        destinations= new Destination[a.length];
        for(int i = 0 ; i < a.length; i++)
            destinations[i]=a[i];

    }

    /**
     * Once you made your own Sources and Destinations you have to set a cost between them. That is, you just introduce some
     * numbers to this method that will represents the cost between locations.
     * Be careful, this method use variable number of arguments!
     * @param a is a list of positive numbers that will represent the cost
     */
    public void setCost(int ...a)
    {
        System.out.println("number of sources is: " + numberOfSources);
        System.out.println("number of destination is: " + numberOfDestinations);
        cost= new int[numberOfSources][numberOfDestinations];
        arrayOfCost = new int [a.length];
        for(int i = 0 ; i < a.length; i++)
             arrayOfCost[i]=a[i];
        int nr=0;
        for(int i = 0 ; i < numberOfSources; i++)
        {
            for(int j = 0 ; j < numberOfDestinations; j++)
                cost[i][j]=a[nr++];

        }
    }

}
