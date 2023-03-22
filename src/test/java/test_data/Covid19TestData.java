package test_data;

import java.util.HashMap;
import java.util.Map;

public class Covid19TestData {
    public Map<String,Integer> expectedDataMethod(Integer TotalConfirmed,Integer TotalDeaths,Integer TotalRecovered ){

        Map<String,Integer> map = new HashMap<>();
        map.put("TotalConfirmed",TotalConfirmed);
        map.put("TotalDeaths",TotalDeaths);
        map.put("TotalRecovered",TotalRecovered);
        return map;

    }














}
