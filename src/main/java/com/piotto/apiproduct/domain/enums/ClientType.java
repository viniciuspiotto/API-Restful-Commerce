package com.piotto.apiproduct.domain.enums;

public enum ClientType {

    INDIVIDUAL(1, "Individual"),
    CORPORATE(2, "Corporate");

    private final Integer id;
    private final String description;

    ClientType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static ClientType toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (ClientType client : ClientType.values()) {
            if (client.getId() == id) {
                return client;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + id);
    }
}
