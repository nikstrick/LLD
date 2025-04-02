package BMS.Entities.Enums;

public enum SeatType {
    SILVER(100),
    GOLD(200),
    PLATINUM(300);

    private final int value;

    SeatType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
