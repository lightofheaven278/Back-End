public class problems4_printPrimeNumberLessThan100 {
    public static void main(String[] args) {
        boolean checkPrime = true;
        int number = 2;
        while (number < 100) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    checkPrime = false;
                    break;
                } else {
                    checkPrime = true;
                }
            }
            if (checkPrime) {
                System.out.println(number + " is prime number.");
            }
            number++;
        }
    }
}
