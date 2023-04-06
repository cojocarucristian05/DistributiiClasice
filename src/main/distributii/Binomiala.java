package main.distributii;

import main.Main;

import javax.swing.*;

import static main.utilities.Functions.calculeazaCombinari;

public class Binomiala extends AbstractDistribution {

    private int n = 0;
    public Binomiala(int n, double p) {
        super(p);
        this.n = n;
    }
    @Override
    public String showOperation() {
        String result = "Binomiala:\n" +
                        "1 - Calculeaza media:\n" +
                        "2 - Calculeaza dispersia\n" +
                        "3 - Calculeaza probabilitate succes aruncare\n" +
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
                    JOptionPane.showMessageDialog(null, this.calculeazaProbabilitateAruncare());
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

    @Override
    public double calculeazaMedia() {
        return n*p;
    }

    @Override
    public double calculeazaDispersia() {
        return n*p*(1-p);
    }


    public String calculeazaProbabilitateAruncare() {
        String x = "";
        String y = "";
        for(int k = 0; k < n; k++) {
            x += k + "           ";
            y += calculeazaCombinari(n, k) * Math.pow(p, k) * Math.pow(1-p, n-k) + "    ";
        }
        x += n;
        y += Math.pow(p, n);
//        JOptionPane.showMessageDialog(null, x + "\n" + y);
//        PlotWithMatlab.plot(x, y);
        return x + "\n" + y;
    }
}
