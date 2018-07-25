package com.michaelclark.whatsmissing;

import java.math.BigDecimal;

public class PredictionResult implements Comparable<PredictionResult>
{
    private String     tagId;
    private String     tagName;
    private BigDecimal probability = new BigDecimal(0D);
    private BoundingBox boundingBox = new BoundingBox();

    private static final BigDecimal threshold = new BigDecimal(.75D);

    public PredictionResult()
    {
    }

    public String getTagId()
    {
        return tagId;
    }

    public void setTagId(String tagId)
    {
        this.tagId = tagId;
    }

    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    public BigDecimal getProbability()
    {
        return probability;
    }

    public void setProbability(BigDecimal probability)
    {
        this.probability = probability;
    }

    public boolean isAcceptable()
    {
        return this.probability.compareTo(threshold) >= 0;
    }

    public BoundingBox getBoundingBox()
    {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox)
    {
        this.boundingBox = boundingBox;
    }

    @Override
    public int compareTo(PredictionResult predictionResult)
    {
        return this.getBoundingBox().compareTo(predictionResult.getBoundingBox());
	}
}
