package com.example.test.data.database;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class FilterCard {

    @Inject
    public FilterCard() {
    }

    public Map<String, String> filterMap(Map<String, String> inputMap) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(inputMap.entrySet());
        for (int i = 0; i < entryList.size(); i++) {
            String key = entryList.get(i).getKey();
            String value = entryList.get(i).getValue();
            if (validValue(value)) {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }

    private Boolean validValue(String string) {
        return string != null && !string.isEmpty();
    }
}