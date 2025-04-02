package BMS.Entities.Records;

import BMS.Entities.Enums.City;

import java.util.List;

public record Theatre(
        int id,
        String name,
        String address,
        City city,
        List<Show> shows,
        List<Screen> screens
) {
}
