package Cv1.Generator;

import java.util.Arrays;
import java.util.Random;

public class DiskretneEmpirickeGenerator extends Generator{
    private Random random;
    private Random uni;
    int [] rozdelenieHodnot;
    double [] rozdeleniePravdepodobnostiIn;
    public DiskretneEmpirickeGenerator(double[] rozdeleniePravdepodobnosti, int[] rozdelenieHodnot, Random seed){
        super(seed);
        this.random = super.getNasada();
        this.uni = new Random(seed.nextLong());

        this.rozdelenieHodnot = rozdelenieHodnot;
        this.rozdeleniePravdepodobnostiIn = Arrays.copyOf(rozdeleniePravdepodobnosti, rozdeleniePravdepodobnosti.length);
        for (int i = 1; i < rozdeleniePravdepodobnosti.length; i++) {
            this.rozdeleniePravdepodobnostiIn[i] = this.rozdeleniePravdepodobnostiIn[i - 1] + rozdeleniePravdepodobnosti[i];
        }
    };
    @Override
    public double getCislo() {
        return getIntCislo();
    }

    @Override
    public int getIntCislo() {
        double cisloPreUni = uni.nextDouble();
        int x = 0;

        for (int i = 0; i < this.rozdeleniePravdepodobnostiIn.length; i++) {
            if (cisloPreUni <= this.rozdeleniePravdepodobnostiIn[i]) {
                x = i;
                break;
            }
        }
        return rozdelenieHodnot[x] + random.nextInt(rozdelenieHodnot[x + 1] - rozdelenieHodnot[x]);
    }
}
