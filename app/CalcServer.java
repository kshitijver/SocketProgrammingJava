import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class CalcServer{
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for clients...");
        ServerSocket ss = new ServerSocket(3000);
        Socket socket = ss.accept();
        System.out.println("Server connected...");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String[] inputs = br.readLine().split(" "); 
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        PrintWriter pr = new PrintWriter(socket.getOutputStream(),true);
        int answer = 0;
        switch(inputs[2]){
            case "+":{
                answer = n+m;
                break;
            }
            case "-":{
                answer = n-m;
                break;
            }
            case "*":{
                answer = n*m;
                break;
            }
            case "/":{
                answer = n/m;
                break;
            }
            default:
                pr.println("Server says: Invalid operation entered");
                System.exit(0);
        }
        pr.println("Server says: "+answer);
    }
}