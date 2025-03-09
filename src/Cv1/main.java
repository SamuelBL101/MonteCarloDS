package Cv1;

import Cv1.Strategie.StrategiaA;
//import Cv1.Strategie.StrategiaB;
//import Cv1.Strategie.StrategiaC;
//import Cv1.Strategie.StrategiaD;

public class main {
    public static void main(String[] args) {
        StrategiaA janNakladyPrevadzka = new StrategiaA();
//        StrategiaB janNakladyPrevadzkaB = new StrategiaB();
//        StrategiaC janNakladyPrevadzkaC = new StrategiaC();
//        StrategiaD janNakladyPrevadzkaD = new StrategiaD();

        double a = janNakladyPrevadzka.simulacia(1000000);
//        double d = janNakladyPrevadzkaD.simulacia(10000000);

        //double a = janNakladyPrevadzka.simulacia(10000000);
        //double b = janNakladyPrevadzkaB.simulacia(10000000);
        System.out.println(a);
//        System.out.println(d);

//       double[] hodnoty = {0,99};
//       int [] hodnotyINT = {0,99};
//      int n = 1000;
//        int[] HodnotyEMPINT = {5,10,50,70,80,95};
//       double[] PravdePodobnostiEMP = {0.2,0.4,0.3,0.06,0.04};
//       SpojiteRovnomerneGenerator SpojiteRovnomerne = new SpojiteRovnomerneGenerator(hodnoty);
//       DiskretneRovnomerneGenerator DiskretneRomnerne = new DiskretneRovnomerneGenerator(hodnotyINT);
//       DiskretneEmpirickeGenerator DiskretneEmpiricke = new DiskretneEmpirickeGenerator(PravdePodobnostiEMP,HodnotyEMPINT);
//       SpojiteEmpirickeGenerator SpojiteEmpiricke = new SpojiteEmpirickeGenerator(PravdePodobnostiEMP, HodnotyEMPINT);
//        double[] SpojiteRovnomerne_data = new double[n];
//        int[] DiskretneRovnomerne_data = new int[n];
//        int[] DiskretneEMP_data = new int[n];
//        double[] SpojiteEMP_data = new double[n];
//        for (int i = 0; i < n; i++) {
//           SpojiteRovnomerne_data[i] = SpojiteRovnomerne.getCislo();
//            DiskretneRovnomerne_data[i] = DiskretneRomnerne.getIntCislo();
//            DiskretneEMP_data[i] = DiskretneEmpiricke.getIntCislo();
//            SpojiteEMP_data[i] = SpojiteEmpiricke.getCislo();
//        }
////
//        try (FileWriter writer = new FileWriter("SpojiteRovnomerne.txt")) {
//            for (double cislo : SpojiteRovnomerne_data) {
//                writer.write(cislo + "\n");
//            }
//            System.out.println("Dáta boli úspešne zapísané do súboru 'SpojiteRovnomerne.txt'.");
//        } catch (IOException e) {
//            System.err.println("Chyba pri zápise do súboru: " + e.getMessage());
//        }
//
//        try (FileWriter writer = new FileWriter("DiskretneRovnomerne.txt")) {
//            for (int cislo : DiskretneRovnomerne_data) {
//                writer.write(cislo + "\n");
//            }
//            System.out.println("Dáta boli úspešne zapísané do súboru 'DiskretneRovnomerne.txt'.");
//        } catch (IOException e) {
//            System.err.println("Chyba pri zápise do súboru: " + e.getMessage());
//        }
//
//        try (FileWriter writer = new FileWriter("DiskretneEMP.txt")) {
//            for (int cislo : DiskretneEMP_data) {
//                writer.write(cislo + "\n");
//            }
//            System.out.println("Dáta boli úspešne zapísané do súboru 'DiskretneEMP.txt'.");
//        } catch (IOException e) {
//            System.err.println("Chyba pri zápise do súboru: " + e.getMessage());
//        }
//
//        try (FileWriter writer = new FileWriter("SpojiteEMP.txt")) {
//            for (double cislo1 : SpojiteEMP_data) {
//                writer.write(cislo1 + "\n");
//            }
//            System.out.println("Dáta boli úspešne zapísané do súboru 'SpojiteEMP.txt'.");
//        } catch (IOException e) {
//            System.err.println("Chyba pri zápise do súboru: " + e.getMessage());
//        }
    }
}
