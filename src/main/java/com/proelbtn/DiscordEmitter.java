package com.proelbtn;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.proelbtn.interfaces.Emitter;

public class DiscordEmitter implements Emitter {
    String webhook_uri;
    String name;

    public DiscordEmitter(String webhook_uri, String name) {
        this.webhook_uri = webhook_uri;
        this.name = name;
    }

    @Override
    public boolean sendMessage(String message) {
        try {
            HttpResponse<JsonNode> response = Unirest.post(webhook_uri)
                    .field("content", message)
                    .field("username", this.name)
                    .asJson();

            return response.getStatus() == 200;
        }
        catch (UnirestException e) {
            return false;
        }
    }
}
