import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class OS {
    static char[][] mainMemory = new char[100][4];
    static char[][] buffer = new char[10][4];
    static char[] IC = new char[2];
    static char[] IR = new char[4];
    static boolean toggle;
    static char[] R = new char[4];

    public static void init() {
        IC[0] = '~';
        IC[1] = '~';

        for (int i = 0; i < 4; i++) {
            IR[i] = '~';
            R[i] = '~';
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 4; j++) {
                mainMemory[i][j] = '~';
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                buffer[i][j] = '~';
            }
        }

        toggle = false;
    }

    public static void load() {
        String filePath = "inputFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<Character> verifyCharList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                for (char character : line.toCharArray()) {
                    if (character == ' ') {
                        break;
                    }
                    verifyCharList.add(character);
                }
            }

            char[] verifyChar = new char[verifyCharList.size()];
            for (int i = 0; i < verifyCharList.size(); i++) {
                verifyChar[i] = verifyCharList.get(i);
            }

            System.out.println(new String(verifyChar));

            char[] programCard = {'$', 'A', 'M', 'J'};
            for (int i = 0; i < 4; i++) {
                if (programCard[i] != verifyChar[i]) {
                    System.out.println("No program card found");
                    return; // Exit if program card doesn't match
                }
            }

            System.out.println("Program Card Found");
            init();

//            for (int i = 0; i < 100; i++) {
//                for (int j = 0; j < 4; j++) {
//                    System.out.print(mainMemory[i][j] + " ");
//                }
//                System.out.println(" ");
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        load();
    }
}