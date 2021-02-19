package com.company;

public class Bonus {

    public static void generateRandomRootedTree(int curentLevel, int curentNode,  int maximLevel, int maximNodes)
    {
        //// vom incepe cu conditia de root, + node0
        if( curentLevel == 0 ) {
            System.out.println("+node" + curentLevel);
            curentNode++;
            /// testam o probabilitate de a continua sau nu
            int probability = (int) Math.round(Math.random());
            if (probability == 1) /// continuam
            {
                curentLevel=curentLevel+ 1;
                generateRandomRootedTree(curentLevel, curentNode,  maximLevel, maximNodes);
            }
        }
        else
        {
            /// testam sa nu depasim limita de nivele maxim admisa
            if(curentLevel <= maximLevel) {
                int noduri = (int) (Math.random() * (maximNodes + 1));
                System.out.println(" " + "+node" + curentNode);
                curentNode++;
                for (int j = 0; j < noduri; j++)
                {
                    System.out.println("    " + "-node" + curentNode);
                    curentNode++;
                }
                int probability = (int) Math.round(Math.random() );
                if (probability == 1) /// continuam
                {
                    curentLevel = curentLevel + 1;
                    generateRandomRootedTree(curentLevel, curentNode, maximLevel, maximNodes);
                }
            }

        }

    }
    public static void main(String[] args) {
        /// vom seta de la inceput cate nivele dorim sa avem
        /// si cate noduri pe fiecare nivel dorim  sa avem
        /// dupa care vom genera random noduri pentru fiecare nivel , avand grija sa nu depasim limita impusa
        int numberOfTotalNodes = 6;
        int numberOfTotalLevels = 7 ;
        generateRandomRootedTree(0, 0,  numberOfTotalLevels, numberOfTotalNodes );
    }
}
