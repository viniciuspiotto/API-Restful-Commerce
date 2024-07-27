package com.piotto.apiproduct.domain.enums;

public enum PaymentState {
    PENDING(1, "Pending"),
    PAID(2, "Paid"),
    CANCELLED(3, "Cancelled");

    private final Integer id;
    private final String description;

    PaymentState(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentState toEnum(Integer id) {
        if (id == null) {
            return null;
        }
        for (PaymentState state : PaymentState.values()) {
            if (state.getId() == id) {
                return state;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + id);
    }
}
