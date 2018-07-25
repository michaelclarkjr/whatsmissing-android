package com.michaelclark.whatsmissing;

import com.google.gson.Gson;

import java.util.List;

public class PredictionParser
{
    public List<PredictionResult> parse(String json)
    {
        Gson gson = new Gson();
        PredictionResponse response = gson.fromJson(json, PredictionResponse.class);
        return response.getAcceptableResults();
    }
}
