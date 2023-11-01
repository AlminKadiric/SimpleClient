
//1. Kreirati socket i otvori ga za komunikaciju
// 2. Otvori input stream i output stream
// 3. Cita podatke iz streamova
// 4. Zatvorit stream i socket !!1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Server connection is not configured and it doesnt work very well");
            System.exit(1);
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try (Socket clientSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);

            String message = scanner.nextLine();
            out.println(message);
            System.out.println("Ogovor - > " + in.readLine());

        } catch (UnknownHostException exception) {
            System.err.println(exception.getMessage());
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }


    }
}
