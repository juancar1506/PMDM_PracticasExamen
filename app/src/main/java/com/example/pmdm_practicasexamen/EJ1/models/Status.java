package com.example.pmdm_practicasexamen.EJ1.models;

import java.io.IOException;

public enum Status {
    ALIVE, DEAD, UNKNOWN;

    public String toValue() {
        switch (this) {
            case ALIVE: return "Alive";
            case DEAD: return "Dead";
            case UNKNOWN: return "unknown";
        }
        return null;
    }

    public static Status forValue(String value) throws IOException {
        if (value.equals("Alive")) return ALIVE;
        if (value.equals("Dead")) return DEAD;
        if (value.equals("unknown")) return UNKNOWN;
        throw new IOException("Cannot deserialize Status");
    }
}
