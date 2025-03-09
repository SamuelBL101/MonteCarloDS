package Cv1.Strategie;

import Cv1.Generator.*;
import Cv1.SimJadro;

import java.util.Random;

public class StrategiaA extends SimJadro {
    private SpojiteRovnomerneGenerator Dodavatel1Prve;
    private SpojiteRovnomerneGenerator Dodavatel1PrveP;
    private SpojiteRovnomerneGenerator Dodavatel1Druhe;
    private SpojiteEmpirickeGenerator Dodavatel2Prvy;
    private SpojiteEmpirickeGenerator Dodavatel2Druhy;
    private DiskretneRovnomerneGenerator TlmiceG;
    private DiskretneRovnomerneGenerator BrzdyG;
    private DiskretneEmpirickeGenerator SvetlaG;
    private SpojiteRovnomerneGenerator dodal;
    private RandomSingleton seed;
    //2* spoj emp
    //2* spoj rovn
    //2* disk rov
    // 1* disk spoj
    private static final double NakladyTlmice = 0.20;
    private static final double NakladyBrzdy = 0.30;
    private static final double NakladySvetlomety = 0.25;
    //kazdy tyzden piatok odberatel nahodny pocet tychto veci chce zobrat
    private static final double Pokuta = 0.30;
    private static final int ObjednavkaTlmice = 100;
    private static final int ObjednavkaBrzdy = 200;
    private static final int ObjednavkaSvetla = 150;
    private static final int pocetTyzdnov = 30;

    private static final int[] Tlmice = {50,100};
    private static final int[] Brzdy = {60,250};
    private static final double[] PravdePodobnostiSvetla = {0.2,0.4,0.3,0.1};
    private static final int[] HodnotaSvetla = {30,60,100,140,160};

    private static final double[] Dodavatel1Prvy = {10,70};
    private static final double[] Dodavatel1Druhy = {30,95};

    private static final double[] PravdePodobnostiDovatel2Prve = {0.4,0.3,0.2,0.06,0.04};
    private static final double[] PravdePodobnostiDovatel2Druhe = {0.2,0.4,0.3,0.06,0.04};
    private static final int[] HodnotaDodavatel2 = {5,10,50,70,80,95};

    private long pocetReplikacii;
    private int pocet_brzd = 0;
    private int pocet_tlmic = 0;
    private int pocet_svetla = 0;
    private int Financie = 0;
    private int den = 0;
    private double naklady;
    private double celkoveNaklady = 0;

    @Override
    protected //generatory
    void beforeSim(long n) {
        this.pocetReplikacii = n;
        this.seed = new RandomSingleton();
        this.seed.setSeed(123L);
        this.Dodavatel1Prve = new SpojiteRovnomerneGenerator(Dodavatel1Prvy,seed.getRandom());
        this.Dodavatel1Druhe = new SpojiteRovnomerneGenerator(Dodavatel1Druhy,seed.getRandom());
        this.Dodavatel2Prvy = new SpojiteEmpirickeGenerator(PravdePodobnostiDovatel2Prve,HodnotaDodavatel2, seed.getRandom());
        this.Dodavatel2Druhy = new SpojiteEmpirickeGenerator(PravdePodobnostiDovatel2Druhe, HodnotaDodavatel2, seed.getRandom());
        this.TlmiceG = new DiskretneRovnomerneGenerator(Tlmice,seed.getRandom());
        this.BrzdyG = new DiskretneRovnomerneGenerator(Brzdy,seed.getRandom());
        this.SvetlaG = new DiskretneEmpirickeGenerator(PravdePodobnostiSvetla,HodnotaSvetla,seed.getRandom());
        this.celkoveNaklady = 0;
        this.dodal = new SpojiteRovnomerneGenerator(new double[]{0, 100},seed.getRandom());

    }

    @Override
    protected //zbieranie vysledkov
    void afterSim() {

    }

    @Override
    protected void experiment() {
        for (int i = 0; i < pocetTyzdnov; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0) {
                    if (i < 10) {
                        double cislo = Dodavatel1Prve.getCislo();
                        //SpojiteRovnomerneGenerator dodal = new SpojiteRovnomerneGenerator(new double[]{0, 100});
                        double cidodal =this.dodal.getCislo();
                        if (cidodal < cislo) {
                            this.pocet_brzd += ObjednavkaBrzdy;
                            this.pocet_svetla += ObjednavkaSvetla;
                            this.pocet_tlmic += ObjednavkaTlmice;
                        }
                    } else {
                        double cislo = Dodavatel1Druhe.getCislo();
                        //SpojiteRovnomerneGenerator dodal = new SpojiteRovnomerneGenerator(new double[]{0, 100});
                        double cidodal =this.dodal.getCislo();
                        if (cidodal < cislo) {
                            this.pocet_brzd += ObjednavkaBrzdy;
                            this.pocet_svetla += ObjednavkaSvetla;
                            this.pocet_tlmic += ObjednavkaTlmice;
                        }
                    }
                } else if (j == 4){
                    int tlmiceObjednavka = this.TlmiceG.getIntCislo();
                    int brzdyObjednavka = this.BrzdyG.getIntCislo();
                    int svetlaObjednavka = this.SvetlaG.getIntCislo();
                    if (tlmiceObjednavka > this.pocet_tlmic) {
                        this.naklady += (tlmiceObjednavka - this.pocet_tlmic) * Pokuta;
                        this.pocet_tlmic = 0;
                    } else {
                        this.pocet_tlmic -= tlmiceObjednavka;
                    }
                    if (brzdyObjednavka > this.pocet_brzd) {
                        this.naklady += (brzdyObjednavka - this.pocet_brzd) * Pokuta;
                        this.pocet_brzd = 0;
                    } else {
                        this.pocet_brzd -= brzdyObjednavka;
                    }
                    if (svetlaObjednavka > this.pocet_svetla) {
                        this.naklady += (svetlaObjednavka - this.pocet_svetla) * Pokuta;
                        this.pocet_svetla = 0;
                    } else {
                        this.pocet_svetla -= svetlaObjednavka;
                    }
                }
                this.naklady += this.pocet_brzd * NakladyBrzdy;
                this.naklady += this.pocet_tlmic * NakladyTlmice;
                this.naklady += this.pocet_svetla * NakladySvetlomety;
                this.den += 1;
            }
        }
    }

    @Override
    protected void beforeRep() {
         this.pocet_brzd = 0;
         this.pocet_tlmic = 0;
         this.pocet_svetla = 0;
         this.Financie = 0;
         this.den = 0;
         this.naklady = 0;

    }

    @Override
    protected double afterRep() {
        this.celkoveNaklady += this.naklady;
        return this.celkoveNaklady;
    }
}
