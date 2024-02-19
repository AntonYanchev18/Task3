import java.util.Scanner;
public class CreditCalculator2 {


        public static void main(String[] args) {

            //Пишеш си имената и взима само фамилията
            Scanner scanner = new Scanner(System.in);
            System.out.print("Въведете пълното си име: ");
            String fullName = scanner.nextLine();
            String[] nameParts = fullName.split(" ");
            String lastName = nameParts[nameParts.length - 1];

            //Въвеждаш пол и ти изкарва г-н или г-жо
            System.out.println("Въведете пол (мъж/жена): ");
            String gender = scanner.next();
            String title = "";
            if ("мъж".equalsIgnoreCase(gender)) {
                title = "г-н";
            } else if ("жена".equalsIgnoreCase(gender)) {
                title = "г-жо";
            } else {
                System.out.println("Невалиден пол");
                return;
            }

            //Години
            System.out.print("Въведете годините си: ");
            int age = scanner.nextInt();

            //Каква сума искаш да изтеглиш
            System.out.print("Въведете сумата, която искате да изтеглите: ");
            double amount = scanner.nextDouble();

            //За колко време
            System.out.print("Въведете броя на месеците за изплащане: ");
            int months = scanner.nextInt();

            //Колко ти е дохода
            System.out.print("Въведете месечния си доход: ");
            double monthlyIncome = scanner.nextDouble();


            checkCreditEligibility(lastName, title, fullName, age, amount, months, monthlyIncome);
            double interestRate = getInterestRate(amount);



            scanner.close();
        }

        public static void checkCreditEligibility(String lastName, String title, String fullName, int age, double amount, int months, double monthlyIncome) {

            double interestRate = getInterestRate(amount);
            double totalAmount = amount + (amount * interestRate * months / 12);
            double monthlyPayment = totalAmount / months;


            if (age < 18) {
                System.out.println("Трябва да имате навършени 18 години, за да изтеглите кредит.");
            } else  if (amount < 1000 && months >= 12) {
                System.out.println("Не може да изтеглите сумата за този период.");
            } else if (amount > 1000 && months >= 12) {
                System.out.println("Уважаеми " + title + " " + lastName + ", месечна вноска за изтеглената сума от " + amount + " лева за " +
                        months + " месеца е " + monthlyPayment + " лева общо с лихвата, която е " + (interestRate * 100) + "%");
            } else if (amount >= 50000 && amount < 100000 && monthlyIncome >= 2000) {
                            System.out.println("Уважаеми " + title + " " + lastName + ", " + "месечна вноска за изтеглената сума от " + amount + " лева за " +
                                    months + " месеца е " + monthlyPayment + " лева общо с лихвата, която е " + (interestRate * 100) + "%");
                        } else if (amount < 50000 && monthlyIncome < 2000) {
                            System.out.println("Съжаляваме, но максимума за такъв доход е 20000 лева.");
                        } else if (amount < 50000 && monthlyIncome >= 2000) {
                             System.out.println("Съжаляваме, но максимума за такъв доход е 20000 лева.");
                         } else if (amount >= 50000 && monthlyIncome < 2000) {
                             System.out.println("Съжаляваме, но максимума за такъв доход е 20000 лева.");
                             } else if (amount >= 100000 && monthlyIncome >= 5000) {
                            System.out.println("Уважаеми" + " " + title + " " + lastName + ", месечна вноска за изтеглената сума от " + amount + " лева за " +
                                    months + " месеца е " + monthlyPayment + " лева общо с лихвата, която е " + (interestRate * 100) + "%");
                            System.out.println("С такъв доход можем да ви предложим 100000 лева.");
                        } else {
                            System.out.println("Съжаляваме, но максимума за такъв доход е 50000 лева.");
                        }


        }

        private static double getInterestRate(double amount) {
            if (amount <= 5000) {
                return 0.05; // 5% лихва за суми до 5000 лева
            } else if (amount <= 10000) {
                return 0.04; // 4% лихва за суми до 10000 лева
            } else {
                return 0.03; // 3% лихва за суми над 10000 лева
            }
        }
    }



