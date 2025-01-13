package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. Destination City
 */
public class P_1436 {

//  ======================= SOLUTION - 1 =======================
    public String destCity(List<List<String>> paths) {

        String res = "";
        Set<String> out = new HashSet<>();
        Set<String> in = new HashSet<>();

        for (List<String> cities : paths) {
            out.add(cities.get(0));
            in.add(cities.get(1));
        }

        for (String city : in) {
            if (!out.contains(city)) {
                res = city;
                break;
            }
        }

        return res;
    }


//    ======================= SOLUTION - 2 =======================
//    public String destCity(List<List<String>> paths) {

//        Map<String, String> map = new HashMap<>();
//
//        for (int i = 0; i < paths.size(); i++) {
//            map.put(paths.get(i).get(0), paths.get(i).get(1));
//        }
//
//        String city = paths.get(0).get(0);
//
//        while (map.get(city) != null){
//            city = map.get(city);
//        }
//
//        return city;
//    }

}
