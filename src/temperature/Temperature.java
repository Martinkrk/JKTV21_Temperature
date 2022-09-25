package temperature;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);

        String sMax = "", sMin = "";
        int max = 0, min = 0;
        int factor = 0;
        int temperature = 0;
        int avg;
        int input, monthIn, dayIn;
        int[] averages = new int[12];
        int[][] months = new int[12][];

        for(int i = 0; i < months.length; i++){
            if(i == 1){
                months[i] = new int[28];
                factor++;
            }
            else if(i < 7){
                //number of days
                if(i % 2 == 0){
                    months[i] = new int[31];
                }else{
                    months[i] = new int[30];
                }

                //temperature
                factor++;
            }
            else{
                //number of days
                if(i % 2 == 0){
                    months[i] = new int[30];
                }else{
                    months[i] = new int[31];
                }

                //temperature
                factor--;
            }


            for(int j = 0; j < months[i].length; j++){
                temperature = -28 + factor * 8;
                months[i][j] = rnd.nextInt(9) + (temperature - 4);

                //max and min
                if(months[i][j] > max){
                    max = months[i][j];
                    sMax = "Month: " + (i+1) + "\tDay: " + (j+1) + "\tTemperature: " + max;
                }else if(months[i][j] < min){
                    min = months[i][j];
                    sMin = "Month: " + (i+1) + "\tDay: " + (j+1) + "\tTemperature: " + min;
                }
            }
            //average
            avg = Arrays.stream(months[i]).sum() / months[i].length;
            averages[i] = avg;
        }

        //main loop
        System.out.println("Welcome! Choose enter a number!");

        mainloop: do {
            System.out.println("\n1. Day temperature");
            System.out.println("2. Coldest and hottest days");
            System.out.println("3. Monthly average temp");
            System.out.println("4. Exit");
            try {
                input = scn.nextInt();
            }
            catch (Exception e){
                System.err.println(e);
                continue;
            }
            finally {
                scn.nextLine();
            }

            switch (input){
                case 1:
                    System.out.println("Enter a month number");
                    monthIn = scn.nextInt();
                    scn.nextLine();
                    System.out.println("Enter a day");
                    dayIn = scn.nextInt();
                    scn.nextLine();
                    System.out.println("The temperature is: " + months[monthIn-1][dayIn-1] + "C");
                    break;
                case 2:
                    System.out.println(sMax + "\n" + sMin);
                    break;
                case 3:
                    System.out.println("Enter a month number");
                    monthIn = scn.nextInt();
                    scn.nextLine();
                    System.out.println("Average temperature is: " + averages[monthIn-1] + "C");
                    break;
                case 4:
                    break mainloop;
            }

        }while (true);
    }
}
