 enum TypeOfSource
{
    WAREHOUSE, FACTORY;
}

public class Source {

   private String name;
   private int capacity;
   TypeOfSource typeSource;
   /// make your own type of Source
   public Source( TypeOfSource myType)
   {
     this.typeSource=myType;
   }
   /// this method will set the name for the Source
   public void setName(String name)
   {
        this.name=name;
   }
   public void setCapacity(int capacity)
   {
       this.capacity=capacity;
   }
  public String getName()
  {
      return this.name;
  }
  public int getCapacity()
  {
       return this.capacity;
  }

  /// method print precious information on the screen for user about sources
    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", TypeOfSource=" + typeSource +
                '}';
    }
}
