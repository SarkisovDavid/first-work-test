package com.example.test;

import java.util.Map;

public class CompositeConverter {

    private final ConverterMAP mConverterMAP = new ConverterMAP();
    private final MapExsample mMapExsample = new MapExsample();

    public Map<String, String> mapMergeMap (Card card) {
        Map<String, String> merge = mConverterMAP.convert(card);
        merge.putAll(mMapExsample.convert(card));
        return merge;
    }
}
