package de.braun.model;

public enum AddressType {
    HOME("HOME", 0),
    HOME_2ND("HOME_2ND", 1),
    DELIVERY("DELIVERY", 2);

    private String name;
    private int value;

    private static final AddressType VALUES[];

    static {
        VALUES = new AddressType[]{HOME, HOME_2ND, DELIVERY};
    }

    AddressType(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    public static int getValue(final String name) {
        try {
            return AddressType.valueOf(name).ordinal();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}
