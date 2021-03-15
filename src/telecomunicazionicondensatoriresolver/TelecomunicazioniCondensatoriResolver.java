package telecomunicazionicondensatoriresolver;

import java.io.*;
import java.util.Scanner;
import java.lang.Math.*;
import java.text.DecimalFormat;

/**
 *
 * @author Nick
 */
public class TelecomunicazioniCondensatoriResolver {

    public static void main(String[] args) {
        DecimalFormat formatter;
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Inserisci precisione (il numero degli zeri dopo la virgola): ");
        String numberOfZeroes = sc.nextLine();
        switch(numberOfZeroes){
            case "":
                formatter = new DecimalFormat("0.00000");      
                System.out.println("Decmal format e' impostato sul valore di default: 0.00000");
                break;
            default:
                String decimalFormat = "0.";
                int i;
                int numberOfZeroes_ = Integer.parseInt(numberOfZeroes);
                for(i = 0; i < numberOfZeroes_; i++)
                    decimalFormat += "0";
                formatter = new DecimalFormat(decimalFormat);      
                System.out.println("Decimal format e' impostato sul valore impostato da te: "+decimalFormat);
                break;
        }
        
        //System.out.println(formatter .format(a));
        
        
        
        System.out.println("Inserisci il valore della resistenza: ");
        
        double resistenza = sc.nextDouble();
        System.out.println("Il valore della resistenza e': " + formatter.format(resistenza));
        System.out.println("Inserisci il valore del condensatore: ");
        double condensatore = sc.nextDouble();
        System.out.println("Il valore del condensatore e': " + formatter.format(condensatore));
        System.out.println("Inserisci il valore del generatore: ");
        double generatore = sc.nextDouble();
        System.out.println("Il valore del generatore e': " + formatter.format(generatore));
        
        double tau = resistenza * condensatore;
        double cinquetau = tau * 5;
        System.out.println("Tau corrisponde a: " + formatter.format(tau) + ", mentre cinquetau e' uguale a: " + formatter.format(cinquetau));
        
        System.out.println("V di che tempo ti interessa?");
        double t = sc.nextDouble();
        double Vc = generatore * (1 - Math.exp(-t/tau));
        System.out.println(Vc);
        
        
    }
}
