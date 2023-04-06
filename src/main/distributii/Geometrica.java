package main.distributii;

import main.Main;
import main.utilities.PlotWithMatlab;

import javax.swing.*;

public class Geometrica extends AbstractDistribution {


    public Geometrica(double p) {
        super(p);
    }

    public String showOperation() {
        String operation =  "Geometrica:\n" +
                            "1 - Calculeaza media\n" +
                            "2 - Calculeaza dispersia\n" +
                            "3 - Afiseaza distributia pe un interval dat\n" +
                            "4 - Back\n" +
                            "0 - Exit\n" +
                            "\nIntroduceti operatia:";
        return operation;
    }

    public void execute(int operation) {
        while(true) {
            switch (operation) {
                case 1: {
                    JOptionPane.showMessageDialog(null, "Media = " + this.calculeazaMedia());
                    break;
                }

                case 2 : {
                    JOptionPane.showMessageDialog(null, "Dispersia = " + this.calculeazaDispersia());
                    break;
                }

                case 3 : {
                    int start = 0;
                    int stop = 0;
                    try {
                        start = Integer.parseInt(JOptionPane.showInputDialog("Introduceti limita inferioara:"));
                        stop = Integer.parseInt(JOptionPane.showInputDialog("Introduceti limita superioara:"));
                    } catch (NumberFormatException numberFormatException) {
                        System.out.println(numberFormatException.getMessage());
                    }
                    this.calculeazaDistributia(start, stop);
                    break;
                }

                case 4 : {
                    Main.execute();
                    break;
                }

                case 0: {
                    System.out.println("Aplicatia s-a inchis cu succes!");
                    System.exit(0);
                }

                default : {
                    JOptionPane.showMessageDialog(null, "Invalid input !");
                    break;
                }
            }
            int geometricOperation = 0;
            try {
                geometricOperation = Integer.parseInt(JOptionPane.showInputDialog(this.showOperation()));
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
            }
            this.execute(geometricOperation);
        }
    }

    public void calculeazaDistributia(int start, int stop) {
        if(start < 0 || start > stop) {
            throw new RuntimeException();
        }

        String x = "x = [" + start + ":1:" + stop + "];";
        String y = "y = [";
        for(int i = start; i < stop; i++) {
            y += Math.pow(1-p, i-1) * p + ",";
        }
        y += Math.pow(1-p, stop) * p + "];";
        PlotWithMatlab.plot(x, y);
    }

    public double calculeazaMedia() {
        return 1/p;
    }

    public double calculeazaDispersia() {
        return (1-p)/(p*p);
    }
 }
