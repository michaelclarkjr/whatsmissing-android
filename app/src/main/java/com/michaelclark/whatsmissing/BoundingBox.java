package com.michaelclark.whatsmissing;

import java.math.BigDecimal;

public class BoundingBox implements Comparable<BoundingBox>
{
    private BigDecimal left = new BigDecimal(0D);
    private BigDecimal top = new BigDecimal(0D);
    private BigDecimal width = new BigDecimal(0D);
    private BigDecimal height = new BigDecimal(0D);

    public BoundingBox()
    {
    }

    public BigDecimal getLeft()
    {
        return left;
    }

    public void setLeft(BigDecimal left)
    {
        this.left = left;
    }

    public BigDecimal getTop()
    {
        return top;
    }

    public void setTop(BigDecimal top)
    {
        this.top = top;
    }

    public BigDecimal getWidth()
    {
        return width;
    }

    public void setWidth(BigDecimal width)
    {
        this.width = width;
    }

    public BigDecimal getHeight()
    {
        return height;
    }

    public void setHeight(BigDecimal height)
    {
        this.height = height;
    }

    @Override
    public int compareTo(BoundingBox boundingBox)
    {
        return this.getLeft().compareTo(boundingBox.getLeft());
    }
}
