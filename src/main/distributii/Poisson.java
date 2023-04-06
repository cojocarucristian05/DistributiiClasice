package main.distributii;

import main.Main;
import main.utilities.PlotWithMatlab;
import main.utilities.Functions;

import javax.swing.*;

public class Poisson extends AbstractDistribution {

    public Poisson(double lambda) {
        super(lambda);
    }


    @Override
    public String showOperation() {
        String result = "Poisson:\n" +
                        "1 - Calculeaza media\n" +
                        "2 - Calculeaza dispersia\n" +
                        "3 - Afiseaza distributia\n" +
                        "4 - Back\n" +
                        "0 - Exit\n" +
                        "\nIntroduceti operatia:";
        return result;
    }

    @Override
    public void execute(int operation) {
        while(true) {
            switch(operation) {
                case 1 : {
                    JOptionPane.showMessageDialog(null, "Media = " + this.calculeazaMedia());
                    break;
                }
                case 2 : {
                    JOptionPane.showMessageDialog(null, "Dispersia = " + this.calculeazaDispersia());
                    break;
                }

                case 3 : {
                    int k = 0;
                    try {
                        k = Integer.parseInt(JOptionPane.showInputDialog("Introduceti valoarea lui \"k\":"));
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println(numberFormatException.getMessage());
                    }
                    this.afiseaza(k);
                    break;
                }

                case 4 : {
                    Main.execute();
                    break;
                }

                case 0: {
                    System.out.println("Program closed!");
                    JOptionPane.showMessageDialog(null, "Aplicatia s-a inchis cu succes !");
                    System.exit(0);
                }

                default : {
                    JOptionPane.showMessageDialog(null, "Invalid input !");
                    break;
                }
            }
            int op = 0;
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(this.showOperation()));
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
            this.execute(op);
        }
    }


    public double calculeazaMedia() {
        return p;
    }

    public double calculeazaDispersia() {
        return p;
    }

    public void afiseaza(int k) {
        String x = "x = [";
        String y = "y = [";
        for(int i = 0; i < k; i++) {
            x += i + ",";
            y += (Math.exp(-p) * Math.pow(p, i))/ Functions.calculeazaFactorial(i) + ",";
        }

        x += k + "];";
        y += (Math.exp(-p) * Math.pow(p, k))/ Functions.calculeazaFactorial(k) + "];";
        System.out.println(x);
        System.out.println(y);
        PlotWithMatlab.plot(x, y);
    }
}
