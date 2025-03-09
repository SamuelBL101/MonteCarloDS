package Cv1.Generator;

import java.util.Random;

//poslem hodnoty asi ake a on potom
public class SpojiteRovnomerneGenerator extends Generator{
    double [] rozdelenie;
    public SpojiteRovnomerneGenerator( double[] rozdelenie, Random seed){
        super(seed);
        this.rozdelenie = rozdelenie;
    };
    @Override
    public double getCislo() {
        double nulaAzJeden = super.getNasada().nextDouble();
        double cislo = rozdelenie[0] + (nulaAzJeden * (rozdelenie[rozdelenie.length - 1] - rozdelenie[0]));
        return cislo;
    }

    @Override
    int getIntCislo() {
        return 0;
    }
    public Random getSeed(){
        return super.getSeed();
    }
}
