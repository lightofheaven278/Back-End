public class problems3_print20PrimeNumber {
    public static void main(String[] args) {
        boolean checkPrime = true;
        int count = 0;
        int number = 2;
        while (count <= 20) {
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
                count++;
            }
            number++;
        }
    }
}
