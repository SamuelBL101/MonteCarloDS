package Cv1.Generator;

import java.util.Random;

public abstract class Generator {
    private Random rndnasada;
    private Random seed;
    public Generator(Random seed){
        if(seed != null){
            this.rndnasada = new Random(seed.nextLong());
        }
        else {
            this.rndnasada = new Random();
        }
    }
    public Random getNasada(){
        return  this.rndnasada;
    }
    public Random getSeed(){
        return this.seed;
    }
    abstract double getCislo();
    abstract int getIntCislo();
}
