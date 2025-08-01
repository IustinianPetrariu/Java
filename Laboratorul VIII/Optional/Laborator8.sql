                                                          LABORATORUL 8 - JAVA  - WORKING WITH DATABASE 

DROP TABLE DIRECTORS
/
CREATE TABLE DIRECTORS ( ID NUMBER(5), NAME VARCHAR2(50), COUNTRY VARCHAR2(50), DURATIONTIME INT , MOVIE VARCHAR2(50) );

DROP TABLE ACTORS
/
CREATE TABLE ACTORS ( ID NUMBER(5), NAME VARCHAR2(50), COUNTRY VARCHAR2(50));

--SELECT *FROM MOVIES;
--
--ALTER TABLE MOVIES MODIFY TITLE VARCHAR2(100);
--
---make a sequence for movie
DROP SEQUENCE idMovie;
/
CREATE SEQUENCE idMovie START WITH 1;
/
--- MAKE A TRIGGER FOR MOVIE 

create or replace TRIGGER idMovieTrigger 
BEFORE INSERT ON MOVIES
FOR EACH ROW
BEGIN
  IF :new.id is null then
  SELECT idMovie.NEXTVAL INTO :new.id FROM DUAL;
  END IF;
END;
