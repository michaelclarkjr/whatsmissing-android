package com.michaelclark.whatsmissing;

import com.microsoft.applicationinsights.core.dependencies.http.HttpEntity;
import com.microsoft.applicationinsights.core.dependencies.http.HttpResponse;
import com.microsoft.applicationinsights.core.dependencies.http.client.HttpClient;
import com.microsoft.applicationinsights.core.dependencies.http.client.methods.HttpPost;
import com.microsoft.applicationinsights.core.dependencies.http.client.utils.URIBuilder;
import com.microsoft.applicationinsights.core.dependencies.http.entity.ByteArrayEntity;
import com.microsoft.applicationinsights.core.dependencies.http.impl.client.HttpClients;
import com.microsoft.applicationinsights.core.dependencies.http.util.EntityUtils;

import java.net.URI;

public class PredictionApiClient
{
    HttpClient httpclient = null;

    public PredictionApiClient()
    {
        httpclient = HttpClients.createDefault();
    }

    private HttpPost prepareRequest(byte[] bytes)
    {
        HttpPost request = null;
        try
        {
            URIBuilder builder = new URIBuilder(
                    "https://southcentralus.api.cognitive.microsoft.com/customvision/v2.0/Prediction/7c05d726-372e-4ee5-9ab7-aa939817bc5e/image");


            URI uri = builder.build();
            request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Prediction-Key", "4ee2436c09234fba8988e1395baabf68");


            // Request body
            ByteArrayEntity reqEntity = new ByteArrayEntity(bytes);
            request.setEntity(reqEntity);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return request;
    }

    public String call(byte[] bytes)
    {
        HttpResponse response = null;
        try
        {
            response = httpclient.execute(prepareRequest(bytes));
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                return EntityUtils.toString(entity);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
