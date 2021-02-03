package it.mulders.spark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JsonResponseTransformer
        implements ResponseTransformer
{
    private final Gson gson = new GsonBuilder().create();

    @Override
    public String render( final Object model )
    {
        return gson.toJson( model );
    }
}
