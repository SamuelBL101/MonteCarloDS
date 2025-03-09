package Cv1.Generator;

import java.util.Random;

public class DiskretneRovnomerneGenerator extends Generator {
    int [] rozdelenie;
    public DiskretneRovnomerneGenerator( int[] rozdelenie, Random seed){
        super(seed);
        this.rozdelenie = rozdelenie;
    };
    @Override
    public double getCislo() {
       return getIntCislo();
    }

    @Override
    public int getIntCislo() {
        int cislo = super.getNasada().nextInt(rozdelenie[rozdelenie.length - 1] - rozdelenie[0] + 1) + rozdelenie[0];

        return cislo;
    }
}


