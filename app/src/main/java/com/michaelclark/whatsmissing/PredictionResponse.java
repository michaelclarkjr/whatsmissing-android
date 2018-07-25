package com.michaelclark.whatsmissing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PredictionResponse
{
    private String                 id;
    private String                 project;
    private String                 iteration;
    private String                 created;
    private List<PredictionResult> predictions = new ArrayList<>();

    public PredictionResponse()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getProject()
    {
        return project;
    }

    public void setProject(String project)
    {
        this.project = project;
    }

    public String getIteration()
    {
        return iteration;
    }

    public void setIteration(String iteration)
    {
        this.iteration = iteration;
    }

    public String getCreated()
    {
        return created;
    }

    public void setCreated(String created)
    {
        this.created = created;
    }

    public List<PredictionResult> getPredictions()
    {
        return predictions;
    }

    public void setPredictions(List<PredictionResult> predictions)
    {
        this.predictions = predictions;
    }

    public List<PredictionResult> getAcceptableResults()
    {
        List<PredictionResult> acceptableResults = new ArrayList<>();

        for (PredictionResult result : getPredictions())
        {
            if (result.isAcceptable() && !acceptableResults.contains(result))
            {
                acceptableResults.add(result);
            }
        }
        return acceptableResults;
    }

}
