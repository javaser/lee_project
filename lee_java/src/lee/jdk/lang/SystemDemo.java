package lee.jdk.lang;

import java.util.Iterator;
import java.util.Properties;

/**
 * @author Lee
 * @since 2017/1/4
 */
public class SystemDemo {
    public static void main(String[] args) {
//        Map<String, String> map = System.getenv();
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        Iterator<Map.Entry<String, String>> iter = set.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
        Properties properties = System.getProperties();
        Iterator iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
