import java.io.*;
import java.net.*;
class ser
{ 
 public static void main(String[] args) throws Exception 
 { 
  ServerSocket sersock = new ServerSocket(3000); 
  System.out.println("SERVER READY TO GO"); 
  Socket sock = sersock.accept( ); 
  BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 
  OutputStream ostream = sock.getOutputStream(); 
  PrintWriter pwrite = new PrintWriter(ostream, true);  
  InputStream istream = sock.getInputStream(); 
  BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));   
  String receiveMessage, sendMessage,fun;
  int a,b,c;
  while(true) 
  {
   fun = receiveRead.readLine();
   if(fun != null) 
    System.out.println("Operation : "+fun);
   a = Integer.parseInt(receiveRead.readLine());
   System.out.println("Parameter 1 : "+a);
   b = Integer.parseInt(receiveRead.readLine());
   if(fun.compareTo("inc")==0)
   {
    c=++a;
    System.out.println("increment = "+c);
    pwrite.println("increment = "+c);
    c=++b;
    System.out.println("increment = "+c);
    pwrite.println("increment = "+c);  
   }
   if(fun.compareTo("dec")==0)
   {
    c=--a;
    System.out.println("decrement = "+c);
    pwrite.println("decrement= "+c); 
    c=--b;
    System.out.println("decrement = "+c);
    pwrite.println("decrement= "+c); 
   }
   if(fun.compareTo("mul")==0)
   {
    c=a*b;
    System.out.println("Multiplication = "+c);
    pwrite.println("Multiplication = "+c); 
   }
   if(fun.compareTo("div")==0)
   {
    c=a/b;
    System.out.println("Division = "+c);
    pwrite.println("Division = "+c); 
   }
   System.out.flush();
  } 
 } 
}
