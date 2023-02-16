package com.github.albertloubet.pixmanager.base;

import com.github.albertloubet.pixmanager.base.gson.LocalDateDeserializer;
import com.github.albertloubet.pixmanager.base.gson.LocalDateSerializer;
import com.github.albertloubet.pixmanager.base.gson.LocalDateTimeDeserializer;
import com.github.albertloubet.pixmanager.base.gson.LocalDateTimeSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class BaseControllerTest {

    protected MockMvc mockMvc;

    protected Gson gson;

    public BaseControllerTest() {
        buildGson();
    }

    private void buildGson() {
        var gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

        gson = gsonBuilder.setPrettyPrinting().create();
    }
}