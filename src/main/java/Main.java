import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Server server = new Server();
        // Pass over 50 random integers from 40 to 200 one at a time to the server class.
        for (int i = 0; i < 50; i++) {
            int randomInt = random.nextInt(160) + 40;
            server.addToArray(randomInt);
            server.tempArray[i] = randomInt;
        }


        System.out.println(server);
    }
}

