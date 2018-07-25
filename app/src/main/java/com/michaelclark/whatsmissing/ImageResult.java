package com.michaelclark.whatsmissing;



import java.util.Date;
import java.util.List;

public class ImageResult {

    public String id;
    public String project;
    public String iteration;
    public Date created;
    public List<Prediction> predictions;
}
