package BMS.Entities.Records;

import java.util.List;

public record Show(
        int id,
        int time,
        Movie movie,
        List<Screen> screens,
        List<Integer> bookSeats) {

}
