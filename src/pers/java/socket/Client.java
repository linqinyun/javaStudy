package pers.java.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Client {
	//客户端socket tcp
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "127.0.0.1";
        int port = 8919;
        try {
          Socket client = new Socket(host, port);
          Writer writer = new OutputStreamWriter(client.getOutputStream());
          writer.write("Hello From Client");
          writer.flush();
          writer.close();
          client.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

	}

}
