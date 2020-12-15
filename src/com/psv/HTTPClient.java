package com.psv;

import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HTTPClient {

    public static void main(String[] args) throws Exception {

        HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://scooterlabs.com/echo?test=test"))
                .setHeader("User-Agent", "Java 11 HttpClient For Cursor Education")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);

        System.out.println(result);
    }
}

/*
Array
(
    [method] => GET
    [headers] => Array
        (
            [User-Agent] => Java 11 HttpClient For Cursor Education
            [Http2-Settings] => AAEAAEAAAAIAAAABAAMAAABkAAQBAAAAAAUAAEAA
            [Host] => scooterlabs.com
            [Content-Length] => 0
            [Connection] => close
            [Authorization] =>
        )

    [request] => Array
        (
            [test] => test
        )

    [client_ip] => 127.0.0.1
    [time_utc] => 2020-12-15T09:34:13+0000
    [info] => Echo service from Scooterlabs (http://www.scooterlabs.com)
)
*/
