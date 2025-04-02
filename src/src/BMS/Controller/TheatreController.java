package BMS.Controller;

import BMS.Entities.Enums.City;
import BMS.Entities.Records.Show;
import BMS.Entities.Records.Theatre;

import java.util.*;

public class TheatreController {
    Map<City, List<Theatre>> theatreMap;
    List<Theatre> theatreList;

    public TheatreController() {
        theatreMap = new HashMap<>();
        theatreList = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        if(!theatreList.contains(theatre)) {
            theatreList.add(theatre);
        }

        if(theatreMap.containsKey(city)) {
            if(!theatreMap.get(city).contains(theatre)) {
                theatreMap.get(city).add(theatre);
            }
        }else{
            theatreMap.put(city, theatreList);
        }
    }

    public List<Show> getShows(int movieId, City city) {
        List<Theatre> theatreList = theatreMap.get(city);
        List<Show> shows = theatreList.stream()
                .flatMap(theatre -> theatre.shows().stream()).toList();
        return shows;
    }
}
