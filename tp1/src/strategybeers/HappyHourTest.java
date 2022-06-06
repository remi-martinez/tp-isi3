package strategybeers;

public class HappyHourTest {

    public static void main(String[] args) {

        System.out.println("=== pattern strategy ===");

        /* initialize strategy */
        HappyHourStrategy noDiscount = new NoDiscount();
        HappyHourStrategy tenPercent = new TenPercent();
        HappyHourStrategy twentyFivePercent = new TwentyFivePercent();
        HappyHourStrategy fiftyPercent = new FiftyPercent();

        /* initialize Beers */
        Beer chouffe = new Beer("Chouffe", 3.0);
        Beer paleAle = new Beer("Pale Ale", 4.0);
        Beer ipa = new Beer("IPA", 5.0);
        Beer paixDieu = new Beer("Paix-dieu", 8.0);


        /* waiter */
        PubWaiter bob = new PubWaiter("Bob");

        /* orders */
        bob.setStrategy(noDiscount);
        double paleAlePrice = bob.calculatePrice(paleAle);

        bob.setStrategy(tenPercent);
        double chouffePrice = bob.calculatePrice(chouffe);

        bob.setStrategy(twentyFivePercent);
        double ipaPrice = bob.calculatePrice(ipa);

        bob.setStrategy(fiftyPercent);
        double paixDieuPrice = bob.calculatePrice(paixDieu);

        if (paleAlePrice == 4.0)
            System.out.println("Le prix de la biere paleAle est correct");
        else
            System.out.println("Le prix de la biere paleAle n'est pas correct");

        if (chouffePrice == 2.7)
            System.out.println("Le prix de la biere chouffe est correct");
        else
            System.out.println("Le prix de la biere chouffe n'est pas correct");

        if (ipaPrice == 3.75)
            System.out.println("Le prix de la biere IPA est correct");
        else
            System.out.println("Le prix de la biere IPA n'est pas correct");

        if (paixDieuPrice == 4)
            System.out.println("Le prix de la biere Paix-Dieu est correct");
        else
            System.out.println("Le prix de la biere Paix-Dieu n'est pas correct");
    }
}
