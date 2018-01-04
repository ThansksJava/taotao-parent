import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author fengjie
 * @Description
 * @Date Created in 2017/12/26
 * @Time 10:49
 */
public class Demo1 {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.25.4",6379);
//        System.out.println(jedis.ping());
        Map<String,String> map = new HashMap<>();
        System.out.println( map.get("hhh"));
    }
}
