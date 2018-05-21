package practice.repository;

import practice.connection.Connection;

import java.io.*;

public class Client extends Connection {

    public Client(String tipo, int port, String host) throws IOException {
        super(tipo, port, host);
    }

    public void startClient(){

        try
        {
            //Flujo de datos hacia el servidor
            serverOutput = new DataOutputStream(cs.getOutputStream());

            //Get the return message from the server
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("From server : " +message);

            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
                serverOutput.writeUTF("Este es el mensaje número " + (i+1) + "\n");
            }

            cs.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void startClient2(){

        try
        {
            //Send the message to the server
            OutputStream os = cs.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String number = "2";

            String sendMessage = "I'm the client!! \n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("To server : " + sendMessage);

            //Get the return message from the server
            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("From server : " +message);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                cs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
