package BMS.Controller;

import BMS.Entities.Enums.City;
import BMS.Entities.Enums.SeatType;
import BMS.Entities.Records.Movie;
import BMS.Entities.Records.Screen;
import BMS.Entities.Records.Seat;
import BMS.Entities.Records.Show;
import BMS.Entities.Records.Theatre;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    private MovieController movieController;
    private TheatreController theatreController;

    public BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }


    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        bookMyShow.initialize();

        bookMyShow.createBooking(City.Delhi, "Avengers");
        bookMyShow.createBooking(City.Delhi, "Avengers");

    }

    public void createBooking(City city, String movieTitle) {
        List<Show> shows = theatreController.theatreMap.get(city)
                .stream()
                .flatMap(theatre -> theatre.shows().stream())
                .toList();
        List<Show> showWithMovie = shows.stream()
                .filter(show -> show.movie().name().equals(movieTitle))
                .toList();

        Show interestedShow = showWithMovie.get(0);
        int seatId= 3;
        List<Integer> bookedSeat = interestedShow.bookSeats();
        if(!bookedSeat.contains(seatId)) {
            bookedSeat.add(seatId);
            //start Payment
            Booking booking = new Booking();

        }else{
            System.out.println(seatId+" is already booked");
            return;
        }
        System.out.println(seatId+" is booked successfully");
    }

    private void initialize(){
        createMovie();
        createTheatre();

    }

    private void createTheatre() {
        List<Screen> inoxScreens = createScreens();
        List<Screen> pvrScreens = createScreens();
        Show InoxShow1 = createShows(
                1,
                123,
                movieController.getMovieFromList("Avengers"),
                inoxScreens

        );
        Show InoxShow2 = createShows(
                2,
                321,
                movieController.getMovieFromList("SpiderMan"),
                inoxScreens

        );
        Show pvrShow1 = createShows(
                1,
                123,
                movieController.getMovieFromList("Avengers"),
                pvrScreens

        );
        Show pvrShow2 = createShows(
                2,
                321,
                movieController.getMovieFromList("SpiderMan"),
                pvrScreens

        );
        Theatre theatre1 = new Theatre(
                1,
                "Inox",
                "xyz",
                City.Delhi,
                new ArrayList<>(List.of(InoxShow1, InoxShow2)),
                inoxScreens
        );

        Theatre theatre2 = new Theatre(
                2,
                "PVR",
                "dvds",
                City.Bangalore,
                new ArrayList<>(List.of(pvrShow1, pvrShow2)),
                pvrScreens
        );
        theatreController.addTheatre(theatre1, City.Delhi);
        theatreController.addTheatre(theatre2, City.Bangalore);

    }

    private void createMovie() {
        Movie movie1 = new Movie(
                1,
                "Avengers",
                120
        );
        Movie movie2 = new Movie(
                2,
                "SpiderMan",
                180
        );
        Movie movie3 = new Movie(
                3,
                "Thor",
                100
        );
        movieController.addMovie(movie1, City.Delhi);
        movieController.addMovie(movie2, City.Delhi);
        movieController.addMovie(movie3, City.Delhi);
        movieController.addMovie(movie1, City.Mumbai);
        movieController.addMovie(movie2, City.Mumbai);
        movieController.addMovie(movie3, City.Mumbai);
        movieController.addMovie(movie1, City.Bangalore);
        movieController.addMovie(movie2, City.Bangalore);
        movieController.addMovie(movie3, City.Bangalore);
    }

    public Show createShows(Integer id, int time, Movie movie, List<Screen> screens){
//        List<Show> shows = new ArrayList<>();
        Show show1 = new Show(
                id,
                time,
                movie,
                screens,
                new ArrayList<>(List.of())
        );
        return show1;
    }

    public List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen(
                1,
                createSeats()
        );
        Screen screen2 = new Screen(
                2,
                createSeats()
        );
        screens.add(screen1);
        screens.add(screen2);
        return screens;
    }

    public List<Seat> createSeats(){
        List<Seat> seats = new ArrayList<>();
        for(int i = 1; i <= 90; i++) {
            if(i <=30) {
                Seat seat = new Seat(
                        i,
                        SeatType.SILVER,
                        i % 10
                );
                seats.add(seat);
            }else if(i<=60){
                Seat seat = new Seat(
                        i,
                        SeatType.GOLD,
                        i % 10
                );
                seats.add(seat);
            }else{
                Seat seat = new Seat(
                        i,
                        SeatType.PLATINUM,
                        i % 10
                );
                seats.add(seat);
            }
        }
        return seats;
    }
}
