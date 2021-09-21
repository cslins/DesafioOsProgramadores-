import java.util.Scanner;
import java.io.*;

public class Fracoes {

    public static int MDC(int a, int b) {
        if (b == 0)
            return a;

        return MDC(b, a % b);

    }

    public static String resposta(int numerador, int denominador){
        if (denominador == 0)
            return "ERR";

        int parteInt = 0;

        if (numerador >= denominador) {
            parteInt = numerador / denominador;
            numerador = numerador % denominador;
        }
        int mdc = MDC(numerador, denominador);

        if (parteInt > 0){
            if (numerador > 0)
                return parteInt + " " + numerador/mdc + "/" + denominador/mdc;
            return String.valueOf(parteInt);
        }

        return numerador/mdc + "/" + denominador/mdc;


    }

    public static void main(String[] args) throws FileNotFoundException{

        File f;

        if (args.length > 0){
            f = new File(args[0]);
        }else{
            f = new File("src/frac.txt");
        }

        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()){
            String[] fracao = sc.nextLine().split("/");

            int numerador = Integer.parseInt(fracao[0]);
            int denominador = 1;

            if (fracao.length == 2)
                denominador = Integer.parseInt(fracao[1]);


            System.out.println(resposta(numerador, denominador));

        }

        sc.close();

    }

}

