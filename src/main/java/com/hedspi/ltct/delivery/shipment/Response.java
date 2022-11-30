package com.example.demo.shipment;

import java.util.List;

public class Response {
    private Result result;
    private List<Sorder> data;

    public Result getResult() {
        return result;
    }

    public List<Sorder> getData() {
        return data;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setData(List<Sorder> data) {
        this.data = data;
    }

    public Response(Result result, List<Sorder> data) {
        this.result = result;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", data=" + data +
                '}';
    }
}
