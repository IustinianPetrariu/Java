package com.company;

public class Optional {

    public static void displayMatrix( int [][] matrix , int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }
    public static void partialTree(int[][] matrix, int n)
    {
        int node=0;
        int first=0,last=0;
        int []viz = new int[n];
        int []coada = new int[n*n];
        int [][] adiacenta = new int[n][n];
        /// facem un bfs pentru a determina un arbore partial !
        while(first <= last )
        {
            node=coada[first];
            first ++;
            for(int i = 0 ; i < n; i++)
                if(matrix[node][i] == 1 && viz[i] == 0)
                {
                    last++;
                    adiacenta[node][i] = adiacenta[i][node] = 1;
                    //// construim matricea de adiacenta a arborelui partial !
                    coada[last] = i;
                    viz[i] = 1;
                }
        }
        displayMatrix(adiacenta, n);
    }

    public static void dfsComponent(int node, int numberOfComponents, int n, int[] visited, int [][] matrix)
    {
        visited[node]=numberOfComponents;
        for(int i = 0; i < n; i++)
            if(matrix[node][i] == 1 && visited[i] == 0)
                dfsComponent(i, numberOfComponents, n , visited,matrix);

    }
    public  static void displayConex(int [][] matrix, int n)
    {

        int []visited= new int[n];
        int numberOfComponents=0;
        for(int node = 0 ; node < n; node ++)
            if (visited[node] == 0)
            {
                numberOfComponents++;
                dfsComponent(node, numberOfComponents, n, visited, matrix);
            }
        System.out.println(numberOfComponents);
        if(numberOfComponents == 1)
        {
            System.out.println("Graph is connected ! ") ;
            System.out.println("Generate the partial tree of the graph! ");
            partialTree(matrix, n);

        }
        else
        {   /// afiseaza pentru fiecare componenta conexa nodurile din care este formata
            for(int i = 1 ; i <= numberOfComponents ; i++)
            {
                System.out.print("coponenta conexa: ");
                System.out.print(i);
                System.out.print(" : ");
                for(int j = 0 ; j < n; j++)
                    if(visited[j] == i)
                        System.out.print(j);
                System.out.println( );
            }

        }

    }
    public static void main(String[] args)
    {
        long  timeToStart = System.nanoTime();  /// to display the running time of the application in nanoseconds !
            if( args.length < 1 || args.length > 1)  /// am nevoie de macar un argument de la  linia de comanda si doar unul
           {
               System.out.println("Not enough arguments!");
               System.exit(1); /// iesim din program cu eroare - > adica afisam 1 ;
           }


        int n;
        long  timeToStop=System.nanoTime();
        long  totalTime = timeToStop-timeToStart;

        try {
            n = Integer.parseInt(args[0]); /// Exception Handling with NumberFormatException
            /// verify if the number is odd
            if (n % 2 != 1) {
                System.out.println("the argument must be an odd number");
                System.exit(2);
            } else {
                int[][] matrice = new int[n][n];
                ///Generam matricea de adiacenta
                for (int i = 0; i < n; i++)
                    for (int j = i + 1; j < n; j++)
                        matrice[i][j] = matrice[j][i] = (int) Math.round(Math.random());

                if (n < 30_000) {
                    System.out.println("n is less than 30_000 !");
                    displayMatrix(matrice, n);
                }
                displayConex(matrice, n);
            }
        } catch (NumberFormatException exc)
        {
            System.out.printf("Number from Input is invalid ");
        }

        System.out.println("Total time ( in nanoseconds) is : " + totalTime );
    }
}