package com.example.test.data.database

import javax.inject.Inject

class FilterCard @Inject constructor() {

    fun filterMap(inputMap: Map<String, String> ): Map<String, String> {
        val resultMap = LinkedHashMap<String, String>();
        val entryList = ArrayList(inputMap.entries);
        for ((key, value) in entryList) {
            if (validValue(value)) {
                resultMap[key] = value
            }
            }
        return resultMap
    }

    private fun validValue(string: String ): Boolean {
        return !string.isNullOrEmpty()
    }
}