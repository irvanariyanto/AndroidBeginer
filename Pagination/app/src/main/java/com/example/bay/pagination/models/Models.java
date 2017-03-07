package com.example.bay.pagination.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BAY on 2/23/2017.
 */

public class Models {
    private Admin admin;
    private Dates dates;
    private Result result;
    private Response response;
    private ResponseNewes responseNewes;
    private Example example;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public ResponseNewes getResponseNewes() {
        return responseNewes;
    }

    public void setResponseNewes(ResponseNewes responseNewes) {
        this.responseNewes = responseNewes;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    /**
     *
     * @return
     *     The admin
     */

    public Admin getAdmin() {
        return admin;
    }
    public Dates getDates(){
        return dates;
    }

    public Result getResult() {
        return result;
    }
    public Response getResponse() {
        return response;
    }




    /**
     *
     * @param admin
     *     The admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setDates(Dates dates){
        this.dates = dates;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    public void setResponse(Response response) {
        this.response =response;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
