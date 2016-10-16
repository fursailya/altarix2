/**
 * Created by Ilya Fursa
 */
public class AnnuityCalculator {
    /*
   Находим процентную ставку как,
   годовая ставка / 100 / 12 месяцев
    */
    public double calculatePercentRate(double percent) {
        return percent / 100 / 12;
    }

    public double calculateMonthPayment(double primaryCredit, double percentRate, int monthPeriod) {
        double mPay = primaryCredit * (percentRate / (1 - Math.pow(1 + percentRate, -monthPeriod)));
        return mPay;
    }

    /*
    Подсчет переплаты!
    Для того, чтобы посчитать переплату по кредиту необходимо:
    Размер ежемесячного платежа * кол-во месяцев и от полученного числа отнять сумму кредита
     */
    public double overPay(double mPay, int monthPeriod, double primaryCredit) {
        double overPay = (mPay * monthPeriod) - primaryCredit;
        return overPay;
    }

    public double sumWithOverPay(double mPay, int monthPeriod) {
        return mPay * monthPeriod;
    }

    public void printPaymentInfo(int monthPeriod, double primaryCredit, double yPerRate, double mPay) {
        double sum = primaryCredit;
        double debt = 0;
        double pay = 0;


        for (int i = 1; i < monthPeriod + 1; i++) {

            debt = sum * yPerRate / 12 / 100;
            pay = mPay - debt;
            sum -= pay;

            System.out.println("Месяц " + i);
            System.out.printf("Проценты по кредиту, руб: " + String.format("%.2f", debt) + " руб");
            System.out.println();
            System.out.printf("Платеж в счет погашения долга: " + String.format("%.2f", pay) + " руб");
            System.out.println();
            System.out.printf("Ежемесячный платеж: " + String.format("%.2f", mPay) + " руб");
            System.out.println();
            System.out.println("Остаток: " + String.format("%.2f", (sum)) + " руб");
            System.out.println();

        }

        System.out.println("------------------------------------------------");
        System.out.println("Cумма вашего кредита с учетом переплат составит: "
                + String.format("%.2f",sumWithOverPay(mPay, monthPeriod)) + " руб");
    }
}