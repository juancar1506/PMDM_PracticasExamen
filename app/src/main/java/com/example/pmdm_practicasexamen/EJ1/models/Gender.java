package com.example.pmdm_practicasexamen.EJ1.models;

import java.io.IOException;

public enum Gender {
    FEMALE, MALE, UNKNOWN;

    public String toValue() {
        switch (this) {
            case FEMALE: return "Female";
            case MALE: return "Male";
            case UNKNOWN: return "unknown";
        }
        return null;
    }

    public static Gender forValue(String value) throws IOException {
        if (value.equals("Female")) return FEMALE;
        if (value.equals("Male")) return MALE;
        if (value.equals("unknown")) return UNKNOWN;
        throw new IOException("Cannot deserialize Gender");
    }
}
