package com.doomsday.roadtodoomsday.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.doomsday.roadtodoomsday.model.Movie;
import com.doomsday.roadtodoomsday.repository.MovieRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) {

        addMovie("Iron Man", "2008-05-02", "Phase 1",
                "Tony Stark becomes Iron Man.", "Essential");

        addMovie("The Incredible Hulk", "2008-06-13", "Phase 1",
                "Bruce Banner struggles to control the Hulk.", "Essential");

        addMovie("Iron Man 2", "2010-05-07", "Phase 1",
                "Tony Stark faces new enemies and the consequences of being Iron Man.", "Essential");

        addMovie("Thor", "2011-05-06", "Phase 1",
                "Thor is banished to Earth and learns what it means to be worthy.", "Essential");

        addMovie("Captain America: The First Avenger", "2011-07-22", "Phase 1",
                "Steve Rogers becomes Captain America during World War II.", "Essential");

        addMovie("The Avengers", "2012-05-04", "Phase 1",
                "Earth's heroes unite to stop Loki and the Chitauri.", "Essential");

        // Phase 2

        addMovie("Iron Man 3", "2013-05-03", "Phase 2",
                "Tony Stark faces the Mandarin and struggles after the Battle of New York.", "Essential");

        addMovie("Thor: The Dark World", "2013-11-08", "Phase 2",
                "Thor faces an ancient enemy seeking the Aether.", "Important");

        addMovie("Captain America: The Winter Soldier", "2014-04-04", "Phase 2",
                "Steve Rogers uncovers a conspiracy within S.H.I.E.L.D.", "Essential");

        addMovie("Guardians of the Galaxy", "2014-08-01", "Phase 2",
                "A group of unlikely heroes must protect an Infinity Stone.", "Essential");

        addMovie("Avengers: Age of Ultron", "2015-05-01", "Phase 2",
                "The Avengers face Ultron and his army.", "Essential");

        addMovie("Ant-Man", "2015-07-17", "Phase 2",
                "Scott Lang becomes Ant-Man.", "Important");

        // Phase 3

        addMovie("Captain America: Civil War", "2016-05-06", "Phase 3",
                "The Avengers split over the Sokovia Accords.", "Essential");

        addMovie("Doctor Strange", "2016-11-04", "Phase 3",
                "Stephen Strange discovers the mystic arts.", "Essential");

        addMovie("Guardians of the Galaxy Vol. 2", "2017-05-05", "Phase 3",
                "The Guardians discover more about Peter Quill's heritage.", "Important");

        addMovie("Spider-Man: Homecoming", "2017-07-07", "Phase 3",
                "Peter Parker balances high school with being Spider-Man.", "Essential");

        addMovie("Thor: Ragnarok", "2017-11-03", "Phase 3",
                "Thor must prevent Ragnarok and the destruction of Asgard.", "Essential");

        addMovie("Black Panther", "2018-02-16", "Phase 3",
                "T'Challa returns to Wakanda and faces a challenger to the throne.", "Essential");

        addMovie("Avengers: Infinity War", "2018-04-27", "Phase 3",
                "The Avengers and their allies face Thanos.", "Essential");

        addMovie("Ant-Man and the Wasp", "2018-07-06", "Phase 3",
                "Scott Lang teams up with Hope van Dyne.", "Important");

        addMovie("Captain Marvel", "2019-03-08", "Phase 3",
                "Carol Danvers becomes Captain Marvel.", "Important");

        addMovie("Avengers: Endgame", "2019-04-26", "Phase 3",
                "The Avengers attempt to undo the Snap.", "Essential");

        addMovie("Spider-Man: Far From Home", "2019-07-02", "Phase 3",
                "Peter Parker faces a new threat after Endgame.", "Essential");
        
        // Phase 4

addMovie(
        "Black Widow",
        "2021-07-09",
        "Phase 4",
        "Natasha Romanoff confronts her past and the people connected to her history.",
        "Important"
);

addMovie(
        "Shang-Chi and the Legend of the Ten Rings",
        "2021-09-03",
        "Phase 4",
        "Shang-Chi is drawn into the mysterious Ten Rings organization.",
        "Important"
);

addMovie(
        "Eternals",
        "2021-11-05",
        "Phase 4",
        "The Eternals reunite to protect Earth from an ancient threat.",
        "Optional"
);

addMovie(
        "Spider-Man: No Way Home",
        "2021-12-17",
        "Phase 4",
        "Peter Parker's identity is revealed, causing the multiverse to open.",
        "Essential"
);

addMovie(
        "Doctor Strange in the Multiverse of Madness",
        "2022-05-06",
        "Phase 4",
        "Doctor Strange journeys through the multiverse to confront new threats.",
        "Essential"
);

addMovie(
        "Thor: Love and Thunder",
        "2022-07-08",
        "Phase 4",
        "Thor faces Gorr the God Butcher and reunites with Jane Foster.",
        "Important"
);

addMovie(
        "Black Panther: Wakanda Forever",
        "2022-11-11",
        "Phase 4",
        "Wakanda faces new threats following the death of King T'Challa.",
        "Essential"
);



// Phase 5

addMovie("Ant-Man and the Wasp: Quantumania", "2023-02-17", "Phase 5",
        "Scott Lang and his family become trapped in the Quantum Realm.",
        "Important");

addMovie("Guardians of the Galaxy Vol. 3", "2023-05-05", "Phase 5",
        "The Guardians face a dangerous enemy and confront Rocket's past.",
        "Essential");

addMovie("The Marvels", "2023-11-10", "Phase 5",
        "Captain Marvel, Ms. Marvel and Monica Rambeau become connected through their powers.",
        "Important");

addMovie("Deadpool & Wolverine", "2024-07-26", "Phase 5",
        "Deadpool teams up with Wolverine in a multiverse adventure.",
        "Essential");

        // Phase 5 - continued

addMovie("Captain America: Brave New World", "2025-02-14", "Phase 5",
        "Sam Wilson takes on the mantle of Captain America and faces a dangerous international conspiracy.",
        "Essential");

addMovie("Thunderbolts*", "2025-05-02", "Phase 5",
        "A group of unconventional heroes and antiheroes are brought together for a dangerous mission.",
        "Essential");

addMovie("The Fantastic Four: First Steps", "2025-07-25", "Phase 6",
        "Marvel's First Family enters the MCU and faces a major cosmic threat.",
        "Essential");

// Phase 6

addMovie("Spider-Man: Brand New Day", "2026-07-31", "Phase 6",
        "Peter Parker returns for a new adventure following the events of No Way Home.",
        "Essential");
    }

    private void addMovie(
        String title,
        String releaseDate,
        String phase,
        String description,
        String importance) {

    if (movieRepository.findByTitle(title).isPresent()) {
        return;
    }

    Movie movie = new Movie();

    movie.setTitle(title);
    movie.setReleaseDate(releaseDate);
    movie.setPhase(phase);
    movie.setDescription(description);
    movie.setPosterUrl("");
    movie.setTrailerUrl("");
    movie.setImportance(importance);
    movie.setWatched(false);

    movieRepository.save(movie);

    }
}