public class Pot2 {
    public static void main(String[] args) {
        int[] nums = {1, 140, 128, 137, 65535, 65536, 33554432};

        for (int i : nums) {
            int[] res = ePotenciaDe2(i);

            if (res[0] == 1) {
                System.out.printf("%d true %d\n", i, res[1]);
            } else {
                System.out.printf("%d false\n", i);
            }
        }
    }

    public static int[] ePotenciaDe2(double num) {
        int cont = 0;
        /* 0: num é potencia de 2?
           1: se sim, qual numnero deve-se elevar 2 para obter num?
         */
        int[] ret = new int[2];
        double log = log2(num);

        if (log - Math.floor(log) == 0) {
            ret[0] = 1;
            ret[1] = (int) log;
        } else {
            ret[0] = 0;
        }

        return ret;
    }

    public static double log2(double num) {
        return Math.log(num) / Math.log(2);
    }
}
