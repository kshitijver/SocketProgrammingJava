import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class CalcClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",3000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers and operation seperated by spaces..");
        String input = br.readLine();
        PrintWriter pr = new PrintWriter(s.getOutputStream(),true);
        pr.println(input);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(in.readLine());
    }
}
