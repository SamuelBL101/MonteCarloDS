package Cv1;

/**
 * Abstraktna Trieda Sim jadro
 * Obsahuje Simulate metodu ktora sa sklada z metod
 */
public abstract class SimJadro{

    public double simulacia(long n){
        double x = 0;
        beforeSim(n);
        for (int i = 0; i < n; i++) {
            beforeRep();
            experiment();
            double v = afterRep();
            x = v/(i+ 1);
        }
        afterSim();
        return x;
    };

    protected abstract void beforeSim(long n); //generatory
    protected abstract void afterSim(); //zbieranie vysledkov
    protected abstract void experiment();
    protected abstract void beforeRep();
    protected abstract double afterRep();
}

