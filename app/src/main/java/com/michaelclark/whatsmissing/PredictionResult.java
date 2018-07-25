package com.michaelclark.whatsmissing;

import java.math.BigDecimal;
import java.util.Objects;

public class PredictionResult
{
    private String     tagId;
    private String     tagName;
    private BigDecimal probability = new BigDecimal(0D);

    private static final BigDecimal threshold = new BigDecimal(.75D);

    public PredictionResult()
    {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PredictionResult that = (PredictionResult) o;
        return Objects.equals(tagId, that.tagId) &&
                Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tagId, tagName);
    }

    public String getTagId()
    {
        return tagId;
    }

    public void setTagId(String tagId)
    {
        this.tagId = tagId;
    }

    public String getTag()
    {
        return tagName;
    }

    public void setTag(String tag)
    {
        this.tagName = tag;
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
}
