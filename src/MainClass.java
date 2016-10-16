import java.io.IOException;
import java.util.Scanner;
/**
 * Created by Ilya Fursa
 */
public class MainClass {
    public static final double PERCENT_RATE = 12;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();

        System.out.print("Введите период(мес): ");
        int period = scanner.nextInt();
        System.out.println();
        System.out.print("Введите сумму(руб): ");
        double sum = scanner.nextDouble();

        double mPercentRate = annuityCalculator.calculatePercentRate(PERCENT_RATE); //считаем месячную процентную ставку
        double mCredit = annuityCalculator.calculateMonthPayment(sum, mPercentRate, period); //ежемесячный платеж
        double overPay = annuityCalculator.overPay(mCredit, period, sum); //переплата по кредиту
        double overSum = annuityCalculator.sumWithOverPay(mCredit, period); //сумма с учетом переплат

//        System.out.println("Сумма вашего кредита: " + sum);
//        System.out.println("Срок погашения: " + period);
//        System.out.println("Ежемесячный платеж: " + mCredit);

        System.out.println();
        System.out.println();

        annuityCalculator.printPaymentInfo(period, sum, PERCENT_RATE, mCredit);
    }
}
