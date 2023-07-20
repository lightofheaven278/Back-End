import java.util.Scanner;

public class problems1_numberToWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a number");
        int number = input.nextInt();
        if (number > 0 && number < 1000) {
            if (number < 10) {
                switch (number) {
                    case 1:
                        System.out.println(number + " is read as one");
                        break;
                    case 2:
                        System.out.println(number + " is read as two");
                        break;
                    case 3:
                        System.out.println(number + " is read as three");
                        break;
                    case 4:
                        System.out.println(number + " is read as four");
                        break;
                    case 5:
                        System.out.println(number + " is read as five");
                        break;
                    case 6:
                        System.out.println(number + " is read as six");
                        break;
                    case 7:
                        System.out.println(number + " is read as seven");
                        break;
                    case 8:
                        System.out.println(number + " is read as eight");
                        break;
                    case 9:
                        System.out.println(number + " is read as nine");
                        break;
                    default:
                        System.err.println(number + " is out of ability");
                }
            } else if (number < 20) {
                int ones = (int) Math.floor(number / 10);
                switch (ones) {
                    case 1:
                        System.out.println(number + " is read as eleven");
                        break;
                    case 2:
                        System.out.println(number + " is read as twelve");
                        break;
                    case 3:
                        System.out.println(number + " is read as thirteen");
                        break;
                    case 4:
                        System.out.println(number + " is read as fourteen");
                        break;
                    case 5:
                        System.out.println(number + " is read as fifteen");
                        break;
                    case 6:
                        System.out.println(number + " is read as sixteen");
                        break;
                    case 7:
                        System.out.println(number + " is read as seventeen");
                        break;
                    case 8:
                        System.out.println(number + " is read as eighteen");
                        break;
                    case 9:
                        System.out.println(number + " is read as nineteen");
                        break;
                    default:
                        System.err.println(number + " is out of ability");
                }
            } else if (number < 100) {
                int ones = (int) Math.floor(number % 10);
                int tens = (int) Math.floor((number / 10) % 10);
                switch (tens) {
                    case 2:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as twenty");
                                break;
                            case 1:
                                System.out.println(number + " is read as twenty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as twenty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as twenty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as twenty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as twenty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as twenty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as twenty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as twenty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as twenty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 3:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as thirty");
                                break;
                            case 1:
                                System.out.println(number + " is read as thirty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as thirty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as thirty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as thirty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as thirty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as thirty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as thirty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as thirty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as thirty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 4:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as forty");
                                break;
                            case 1:
                                System.out.println(number + " is read as forty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as forty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as forty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as forty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as forty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as forty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as forty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as forty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as forty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 5:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as fifty");
                                break;
                            case 1:
                                System.out.println(number + " is read as fifty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as fifty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as fifty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as fifty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as fifty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as fifty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as fifty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as fifty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as fifty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 6:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as sixty");
                                break;
                            case 1:
                                System.out.println(number + " is read as sixty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as sixty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as sixty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as sixty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as sixty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as sixty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as sixty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as sixty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as sixty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 7:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as seventy");
                                break;
                            case 1:
                                System.out.println(number + " is read as seventy one");
                                break;
                            case 2:
                                System.out.println(number + " is read as seventy two");
                                break;
                            case 3:
                                System.out.println(number + " is read as seventy three");
                                break;
                            case 4:
                                System.out.println(number + " is read as seventy four");
                                break;
                            case 5:
                                System.out.println(number + " is read as seventy five");
                                break;
                            case 6:
                                System.out.println(number + " is read as forty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as seventy seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as seventy eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as seventy nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 8:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as eighty");
                                break;
                            case 1:
                                System.out.println(number + " is read as eighty one");
                                break;
                            case 2:
                                System.out.println(number + " is read as eighty two");
                                break;
                            case 3:
                                System.out.println(number + " is read as eighty three");
                                break;
                            case 4:
                                System.out.println(number + " is read as eighty four");
                                break;
                            case 5:
                                System.out.println(number + " is read as eighty five");
                                break;
                            case 6:
                                System.out.println(number + " is read as eighty six");
                                break;
                            case 7:
                                System.out.println(number + " is read as eighty seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as eighty eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as eighty nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    case 9:
                        switch (ones) {
                            case 0:
                                System.out.println(number + " is read as ninety");
                                break;
                            case 1:
                                System.out.println(number + " is read as ninety one");
                                break;
                            case 2:
                                System.out.println(number + " is read as ninety two");
                                break;
                            case 3:
                                System.out.println(number + " is read as ninety three");
                                break;
                            case 4:
                                System.out.println(number + " is read as ninety four");
                                break;
                            case 5:
                                System.out.println(number + " is read as ninety five");
                                break;
                            case 6:
                                System.out.println(number + " is read as ninety six");
                                break;
                            case 7:
                                System.out.println(number + " is read as ninety seven");
                                break;
                            case 8:
                                System.out.println(number + " is read as ninety eight");
                                break;
                            case 9:
                                System.out.println(number + " is read as ninety nine");
                            default:
                                System.err.println(number + " is out of ability");
                        }
                        break;
                    default:
                        System.err.println(number + " is out of ability");
                }
            } else {
                int ones = (int) Math.floor(number % 10);
                int tens = (int) Math.floor((number / 10) % 10);
                int hundreds = (int) Math.floor((number / 100) % 10);
            }
        }
    }
}
