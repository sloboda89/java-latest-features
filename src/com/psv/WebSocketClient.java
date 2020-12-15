package com.psv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class WebSocketClient {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);

        WebSocket ws = HttpClient
                .newHttpClient()
                .newWebSocketBuilder()
                .buildAsync(URI.create("wss://echo.websocket.org"), new WebSocketListener(latch))
                .join();
        ws.sendText("Hello!", true);
        latch.await();
    }

    private static class WebSocketListener implements WebSocket.Listener {
        private final CountDownLatch latch;

        public WebSocketListener(CountDownLatch latch) { this.latch = latch; }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("Echo message received: " + data); // Echo message received: Hello!
            latch.countDown();
            return WebSocket.Listener.super.onText(webSocket, data, last);
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Something went wrong: " + webSocket.toString());
            WebSocket.Listener.super.onError(webSocket, error);
        }
    }
}
