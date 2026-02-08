package com.inventario.sistemainventario.controller;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@FacesConverter(value = "entityConverter", managed = true)
public class EntityConverter implements Converter<Object> {
    private static final Map<String, Object> cache = new HashMap<>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        return cache.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        String uuid = UUID.randomUUID().toString();
        cache.put(uuid, value);

        return uuid;
    }
}
