package dev.danvega.jpasecurity.Netty.handler;

@org.springframework.stereotype.Service
public class Service {

    public String[] macAndNameFetch(String message)
    {
        String[] data=new String[2];
        data[0]=message.trim().substring("register ".length(),26);
        data[1]=message.trim().substring(28);
        return data;
    }
    public String macFetch(String message)
    {
      return message.trim().substring("login ".length());
    }
}
