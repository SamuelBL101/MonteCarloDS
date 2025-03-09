package Cv1.Generator;

import java.util.Random;


import java.util.Random;

public class RandomSingleton {
    private static RandomSingleton instance;
    private Random random;

    public RandomSingleton() {
        // Initialize the Random object without a seed.
        this.random = new Random();
    }

    public static RandomSingleton getInstance() {
        if (instance == null) {
            instance = new RandomSingleton();
        }
        return instance;
    }

    public Random getRandom() {
        return random;
    }

    // Optional: If you want to allow setting a custom seed later:
    public void setSeed(long seed) {
        this.random.setSeed(seed);
    }
}
