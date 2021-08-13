package co.com.tipi.test.modules.pingpong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PingPongService {

    public List<String> pingPong(Integer count){
        List<String> response = new ArrayList<String>();

        for( int i = 1; i <= count;i++){
            if( i%3 == 0 && i%5 == 0)
                response.add("Ping-Pong");
            else if( i%3==0 )
                response.add("Ping");
            else if( i%5==0 )
                response.add("Pong");
            else
            	response.add(String.valueOf(i));
        }
        return response;
    }

}
