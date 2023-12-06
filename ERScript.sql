--
-- ER/Studio Data Architect SQL Code Generation
-- Project :      imdb.DM1
--
-- Date Created : Sunday, December 03, 2023 15:16:12
-- Target DBMS : MySQL 8.x
--

-- 
-- TABLE: Bridge_MovieGenre 
--

CREATE TABLE Bridge_MovieGenre(
    movieGenre_id    INT            NOT NULL,
    genre_id         INT            NOT NULL,
    tconst           VARCHAR(18)    NOT NULL,
    PRIMARY KEY (movieGenre_id, genre_id, tconst)
)ENGINE=MYISAM
;



-- 
-- TABLE: Bridge_MoviePerson 
--

CREATE TABLE Bridge_MoviePerson(
    moviePerson_id    INT             NOT NULL,
    tconst            VARCHAR(18)     NOT NULL,
    person_id         INT             NOT NULL,
    role              VARCHAR(50),
    primaryName       VARCHAR(255),
    PRIMARY KEY (moviePerson_id, tconst, person_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Bridge_MovieRegion 
--

CREATE TABLE Bridge_MovieRegion(
    region_id         INT            NOT NULL,
    tconst            VARCHAR(18)    NOT NULL,
    movieRegion_id    INT,
    PRIMARY KEY (region_id, tconst)
)ENGINE=MYISAM
;



-- 
-- TABLE: Dim_date 
--

CREATE TABLE Dim_date(
    date_id    VARCHAR(18)    NOT NULL,
    year       INT,
    quarter    INT,
    month      INT,
    date       VARCHAR(18),
    PRIMARY KEY (date_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Dim_genre 
--

CREATE TABLE Dim_genre(
    genre_id        INT             NOT NULL,
    primaryTitle    VARCHAR(500),
    genre           VARCHAR(50),
    PRIMARY KEY (genre_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Dim_movie 
--

CREATE TABLE Dim_movie(
    tconst           VARCHAR(18)     NOT NULL,
    titleType        VARCHAR(50),
    primaryTitle     VARCHAR(255),
    originalTitle    VARCHAR(255),
    PRIMARY KEY (tconst)
)ENGINE=MYISAM
;



-- 
-- TABLE: Dim_person 
--

CREATE TABLE Dim_person(
    person_id         INT             NOT NULL,
    nconst            VARCHAR(50)     NOT NULL,
    primaryName       VARCHAR(50),
    birthYear         VARCHAR(18),
    deathYear         VARCHAR(18),
    knownForTitles    VARCHAR(500),
    PRIMARY KEY (person_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Dim_region 
--

CREATE TABLE Dim_region(
    region_id    INT            NOT NULL,
    region       VARCHAR(50),
    language     VARCHAR(50),
    PRIMARY KEY (region_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Fact_movie 
--

CREATE TABLE Fact_movie(
    movie_id          INT            NOT NULL,
    tconst            VARCHAR(18)    NOT NULL,
    isAdult           TINYINT,
    startYear         VARCHAR(18),
    endYear           VARCHAR(18),
    runtimeMinutes    VARCHAR(18),
    averageRating     FLOAT(8, 0),
    numVotes          INT,
    PRIMARY KEY (movie_id, tconst)
)ENGINE=MYISAM
;



-- 
-- TABLE: Fact_movieEarning 
--

CREATE TABLE Fact_movieEarning(
    earning_id    INT            NOT NULL,
    date_id       VARCHAR(18)    NOT NULL,
    tconst        VARCHAR(18)    NOT NULL,
    movie_id      INT            NOT NULL,
    gross         VARCHAR(18),
    grossUSA      VARCHAR(18),
    PRIMARY KEY (earning_id, date_id, tconst, movie_id)
)ENGINE=MYISAM
;



-- 
-- TABLE: Bridge_MovieGenre 
--

ALTER TABLE Bridge_MovieGenre ADD CONSTRAINT RefDim_movie47 
    FOREIGN KEY (tconst)
    REFERENCES Dim_movie(tconst)
;

ALTER TABLE Bridge_MovieGenre ADD CONSTRAINT RefDim_genre26 
    FOREIGN KEY (genre_id)
    REFERENCES Dim_genre(genre_id)
;


-- 
-- TABLE: Bridge_MoviePerson 
--

ALTER TABLE Bridge_MoviePerson ADD CONSTRAINT RefDim_movie45 
    FOREIGN KEY (tconst)
    REFERENCES Dim_movie(tconst)
;

ALTER TABLE Bridge_MoviePerson ADD CONSTRAINT RefDim_person17 
    FOREIGN KEY (person_id)
    REFERENCES Dim_person(person_id)
;


-- 
-- TABLE: Bridge_MovieRegion 
--

ALTER TABLE Bridge_MovieRegion ADD CONSTRAINT RefDim_movie46 
    FOREIGN KEY (tconst)
    REFERENCES Dim_movie(tconst)
;

ALTER TABLE Bridge_MovieRegion ADD CONSTRAINT RefDim_region21 
    FOREIGN KEY (region_id)
    REFERENCES Dim_region(region_id)
;


-- 
-- TABLE: Fact_movie 
--

ALTER TABLE Fact_movie ADD CONSTRAINT RefDim_movie22 
    FOREIGN KEY (tconst)
    REFERENCES Dim_movie(tconst)
;


-- 
-- TABLE: Fact_movieEarning 
--

ALTER TABLE Fact_movieEarning ADD CONSTRAINT RefDim_date25 
    FOREIGN KEY (date_id)
    REFERENCES Dim_date(date_id)
;

ALTER TABLE Fact_movieEarning ADD CONSTRAINT RefFact_movie31 
    FOREIGN KEY (movie_id, tconst)
    REFERENCES Fact_movie(movie_id, tconst)
;


