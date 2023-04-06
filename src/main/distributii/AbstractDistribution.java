package main.distributii;

public abstract class AbstractDistribution {

    protected double p = 0;

    public AbstractDistribution(double p) {
        this.p = p;
    }

    public abstract double calculeazaMedia();

    public abstract double calculeazaDispersia();

    public abstract String showOperation();

    public abstract void execute(int operation);
}
