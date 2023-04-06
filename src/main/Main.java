package main;

import main.distributii.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static String showMenu() {
        return  "Selectati distributia:\n" +
                "1 - Bernoulli\n" +
                "2 - Binomiala\n" +
                "3 - Geometrica\n" +
                "4 - Poisson\n" +
                "0 - Exit\n" +
                "\nIntroduceti optiunea: ";
    }

    private static double citesteProbabilitate() {
        double probabilitate = 0;
        try {
            probabilitate = Double.parseDouble(JOptionPane.showInputDialog("Introduceti probabilitatea succesului: "));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
        }
        return probabilitate;
    }

    private static int citesteOperatia(AbstractDistribution abstractDistribution) {
//        System.out.println(c);

        int option = 0;
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(abstractDistribution.showOperation()));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
        }
        return option;
    }

    public static void execute() {
        JFrame frame = new JFrame("Distributii clasice de probabilitate");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int option = 0;
        try {
            option = Integer.parseInt(JOptionPane.showInputDialog(showMenu()));
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
        }

        while(true) {
            switch (option) {
                case 1: {
//                    System.out.println("Bernoulli");
                    double probabilitate = citesteProbabilitate();
                    Bernoulli bernoulli = new Bernoulli(probabilitate);
                    int operatie = citesteOperatia(bernoulli);
                    bernoulli.execute(operatie);
                    break;
                }

                case 2 : {
                    double probabilitate = citesteProbabilitate();
                    int numar_incercari = 0;
                    try {
                        numar_incercari = Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul de incercari:"));
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println(numberFormatException.getMessage());
                    }
                    Binomiala binomiala = new Binomiala(numar_incercari, probabilitate);
                    int operatie = citesteOperatia(binomiala);
                    binomiala.execute(operatie);
                    break;
                }

                case 3 : {
                    double probabilitate = citesteProbabilitate();
                    Geometrica geometrica = new Geometrica(probabilitate);
                    int geometricOperation = citesteOperatia(geometrica);
                    geometrica.execute(geometricOperation);
                    break;
                }

                case 4 : {
                    System.out.println("Poisson");
                    double probabilitate = citesteProbabilitate();
                    Poisson poisson = new Poisson(probabilitate);
                    int operatie = citesteOperatia(poisson);
                    poisson.execute(operatie);
                    break;
                }

                case 0 : {
                    System.out.println("Program closed!");
                    JOptionPane.showMessageDialog(null, "Aplicatia s-a inchis cu succes!");
                    System.exit(0);
                }

                default : {
                    JOptionPane.showMessageDialog(null,"Invalid distribution !");
                    break;
                }
            }
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog(showMenu()));
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        execute();
    }
}
