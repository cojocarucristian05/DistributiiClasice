package main.distributii;

import main.Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Bernoulli extends AbstractDistribution {

    public Bernoulli(double p) {
        super(p);
    }

    @Override
    public String showOperation() {
        String result = "Bernoulli:\n" +
                        "1 - Calculeaza media\n" +
                        "2 - Calculeaza dispersia\n" +
                        "3 - Run-uri de biti\n" +
                        "4 - Back\n" +
                        "0 - Exit\n" +
                        "\nIntroduceti optiunea:";
        return result;
    }

    @Override
    public void execute(int operation) {
        while(true) {
            switch (operation) {
                case 1: {
                    JOptionPane.showMessageDialog(null,"Media = " + this.calculeazaMedia());
                    break;
                }

                case 2: {
                    JOptionPane.showMessageDialog(null,"Dispersia = " + this.calculeazaDispersia());
                    break;
                }

                case 3: {
                    int n = 0;
                    try {
                        n = Integer.parseInt(JOptionPane.showInputDialog("Introduceti numarul de aruncari:"));
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println(numberFormatException.getMessage());
                    }
                    String[] array = this.runBiti(n);
                    JOptionPane.showMessageDialog(null, array[0]);
                    JOptionPane.showMessageDialog(null, "Numarul de run-uri de biti: " + array[1]);
                    break;
                }

                case 4: {
                    Main.execute();
                    break;
                }

                case 0: {
                    JOptionPane.showMessageDialog(null,"Aplicatia s-a inchis cu succes!");
                    System.exit(0);
                    break;
                }

                default: {
                    JOptionPane.showMessageDialog(null,"Invalid operation !");
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
        return p;
    }

    @Override
    public double calculeazaDispersia() {
        return p * (1 - p);
    }

    public String[] runBiti(int n) {
        String [] array = new String[2];
        String result = "";
        Random random = new Random();
        ArrayList<Integer> biti = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < n; i++) {
            double p = random.nextDouble(1);
            if(p >= 0.5) {
                biti.add(1);
                result += "1 ";
            } else {
                biti.add(0);
                result += "0 ";
            }
        }

        if(biti.size() != 0) {
            if(biti.get(0) == 1) {
                count = 1;
            } else {
                count = 0;
            }
            for(int i = 1; i < biti.size(); i++) {
                if(biti.get(i) == 1 && biti.get(i-1) == 0) {
                    count++;
                }
            }
        } else {
            array[1] = "Nu exista biti!";
        }

        array[0] = result;
        array[1] = count + "";
        return array;
    }
}
