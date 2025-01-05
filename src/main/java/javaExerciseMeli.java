public class javaExerciseMeli {
    public static void main(String[] args) {
         String[] city = {
                 "Londres",
                 "Madrid",
                 "Nova York",
                 "Buenos Aires",
                 "Assunção",
                 "São Paulo",
                 "Lima",
                 "Santiago de Chile",
                 "Lisboa",
                 "Tokio"
         };

         int[][] temp = {
                 {-2, 33},
                 {-3, 32},
                 {-8, 27},
                 {4, 37},
                 {6, 42},
                 {5, 43},
                 {0, 39},
                 {-7, 26},
                 {-1, 31},
                 {-10, 35}
         };

         int lowerTemp = 9999;
         int higherTemp = 0;
         int indexOfLowerTemp = 0;
         int indexOfHigherTemp = 0;



         for(int i = 0; i<temp.length; i++) {
             for(int j = 0; j<temp[i].length; j++) {
                if(lowerTemp > temp[i][j]) {
                    lowerTemp = temp[i][j];
                    indexOfLowerTemp = i;
                } else if (higherTemp < temp[i][j]) {
                    higherTemp = temp[i][j];
                    indexOfHigherTemp = i;
                }
             }
         }


        String nameCityLowerTemp = city[indexOfLowerTemp];
        String nameCityHigherTemp = city[indexOfHigherTemp];

        System.out.println("menor temperatura : " + lowerTemp);
        System.out.println("Cidade de menor temperatura : " + nameCityLowerTemp);
        System.out.println("maior temperatura : " + higherTemp);
        System.out.println("Cidade de maior temperatura : " + nameCityHigherTemp);
    }
}
