package Cv1.Generator;

import java.util.Arrays;
import java.util.Random;

public class SpojiteEmpirickeGenerator extends Generator{
    private Random random;
    private Random uni;
    int [] rozdelenieHodnot;
    double [] rozdeleniePravdepodobnosti;
    public SpojiteEmpirickeGenerator(double[] rozdeleniePravdepodobnosti, int[] rozdelenieHodnot, Random seed){
        super(seed);
        this.random = super.getNasada();
        this.uni = new Random(seed.nextLong());

        this.rozdelenieHodnot = rozdelenieHodnot;
        this.rozdeleniePravdepodobnosti = Arrays.copyOf(rozdeleniePravdepodobnosti,rozdeleniePravdepodobnosti.length);
        for (int i = 1; i < rozdeleniePravdepodobnosti.length; i++) {
            this.rozdeleniePravdepodobnosti[i] = this.rozdeleniePravdepodobnosti[i - 1] + rozdeleniePravdepodobnosti[i];
        }
    };
    @Override
    public double getCislo() {
        double cisloPreUni = uni.nextDouble();
        int x = 0;
        for (int i = 0; i < this.rozdeleniePravdepodobnosti.length; i++) {
            if (cisloPreUni <= this.rozdeleniePravdepodobnosti[i]){
                x = i;
                break;
            }
        }
        double druhe = random.nextDouble();
        double cislo = rozdelenieHodnot[x] + (druhe * (rozdelenieHodnot[x + 1] - rozdelenieHodnot[x]));
        return cislo;
    }

    @Override
    int getIntCislo() {
        return 0;
    }
}
