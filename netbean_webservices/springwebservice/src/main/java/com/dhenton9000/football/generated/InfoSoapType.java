package com.dhenton9000.football.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.1
 * 2011-09-06T14:30:53.373-05:00
 * Generated source version: 2.4.1
 * 
 */
@WebService(targetNamespace = "http://footballpool.dataaccess.eu", name = "InfoSoapType")
@XmlSeeAlso({ObjectFactory.class})
public interface InfoSoapType {

    /**
     * Returns an array with the top N goal scorers and their current score. Pass 0 as TopN and you get them all.
     */
    @WebResult(name = "TopGoalScorersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TopGoalScorers", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TopGoalScorers")
    @WebMethod(operationName = "TopGoalScorers")
    @ResponseWrapper(localName = "TopGoalScorersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TopGoalScorersResponse")
    public com.dhenton9000.football.generated.ArrayOftTopGoalScorer topGoalScorers(
        @WebParam(name = "iTopN", targetNamespace = "http://footballpool.dataaccess.eu")
        int iTopN
    );

    /**
     * Number of games played so far
     */
    @WebResult(name = "GamesPlayedResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GamesPlayed", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GamesPlayed")
    @WebMethod(operationName = "GamesPlayed")
    @ResponseWrapper(localName = "GamesPlayedResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GamesPlayedResponse")
    public int gamesPlayed();

    /**
     * Returns the date of the last group game will be played. After this date the quarter finals are played.
     */
    @WebResult(name = "DateLastGroupGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateLastGroupGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateLastGroupGame")
    @WebMethod(operationName = "DateLastGroupGame")
    @ResponseWrapper(localName = "DateLastGroupGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateLastGroupGameResponse")
    public javax.xml.datatype.XMLGregorianCalendar dateLastGroupGame();

    /**
     * Returns an array with all stadiums. The array contains the names, the city where the stadium can be found and the seat capacity
     */
    @WebResult(name = "AllStadiumInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllStadiumInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllStadiumInfo")
    @WebMethod(operationName = "AllStadiumInfo")
    @ResponseWrapper(localName = "AllStadiumInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllStadiumInfoResponse")
    public com.dhenton9000.football.generated.ArrayOftStadiumInfo allStadiumInfo();

    /**
     * Returns the information we keep about a particular stadium, Pass the name of the stadium
     */
    @WebResult(name = "StadiumInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumInfo")
    @WebMethod(operationName = "StadiumInfo")
    @ResponseWrapper(localName = "StadiumInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumInfoResponse")
    public com.dhenton9000.football.generated.TStadiumInfo stadiumInfo(
        @WebParam(name = "sStadiumName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sStadiumName
    );

    /**
     * Returns an array with the names of all forwards. If you pass a country name the result will be filtered on that country, so you only get the forwards listed for the specified country
     */
    @WebResult(name = "AllForwardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllForwards", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllForwards")
    @WebMethod(operationName = "AllForwards")
    @ResponseWrapper(localName = "AllForwardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllForwardsResponse")
    public com.dhenton9000.football.generated.ArrayOfString allForwards(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sCountryName
    );

    /**
     * Returns an array with the id, name, country and flag reference of all players
     */
    @WebResult(name = "AllPlayerNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayerNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayerNames")
    @WebMethod(operationName = "AllPlayerNames")
    @ResponseWrapper(localName = "AllPlayerNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayerNamesResponse")
    public com.dhenton9000.football.generated.ArrayOftPlayerNames allPlayerNames(
        @WebParam(name = "bSelected", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSelected
    );

    /**
     * List all the members of a group/poule
     */
    @WebResult(name = "GroupCompetitorsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GroupCompetitors", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GroupCompetitors")
    @WebMethod(operationName = "GroupCompetitors")
    @ResponseWrapper(localName = "GroupCompetitorsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GroupCompetitorsResponse")
    public com.dhenton9000.football.generated.ArrayOftTeamInfo groupCompetitors(
        @WebParam(name = "sPoule", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sPoule
    );

    /**
     * Returns an array with players that have a red card. Note: You can only sort on Name or Red cards, not on a combination.
     */
    @WebResult(name = "AllPlayersWithRedCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithRedCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithRedCards")
    @WebMethod(operationName = "AllPlayersWithRedCards")
    @ResponseWrapper(localName = "AllPlayersWithRedCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithRedCardsResponse")
    public com.dhenton9000.football.generated.ArrayOftPlayersWithCards allPlayersWithRedCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByRedCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByRedCards
    );

    /**
     * Returns the date of the first game
     */
    @WebResult(name = "DateOfFirstGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateOfFirstGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateOfFirstGame")
    @WebMethod(operationName = "DateOfFirstGame")
    @ResponseWrapper(localName = "DateOfFirstGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateOfFirstGameResponse")
    public javax.xml.datatype.XMLGregorianCalendar dateOfFirstGame();

    /**
     * Returns the total number of red cards given during this tournament (so far)
     */
    @WebResult(name = "RedCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "RedCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.RedCardsTotal")
    @WebMethod(operationName = "RedCardsTotal")
    @ResponseWrapper(localName = "RedCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.RedCardsTotalResponse")
    public int redCardsTotal();

    /**
     * Returns a URL that can be used to show a small map of the stadium
     */
    @WebResult(name = "StadiumURLResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumURL", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumURL")
    @WebMethod(operationName = "StadiumURL")
    @ResponseWrapper(localName = "StadiumURLResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumURLResponse")
    public java.lang.String stadiumURL(
        @WebParam(name = "sStadiumName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sStadiumName
    );

    /**
     * Returns a number on how many times the given team competed at a worldcup football
     */
    @WebResult(name = "PlayedAtWorldCupResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "PlayedAtWorldCup", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.PlayedAtWorldCup")
    @WebMethod(operationName = "PlayedAtWorldCup")
    @ResponseWrapper(localName = "PlayedAtWorldCupResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.PlayedAtWorldCupResponse")
    public int playedAtWorldCup(
        @WebParam(name = "sTeamName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sTeamName
    );

    /**
     * Returns an array with the names of all the coaches and the team information he/she is coaching
     */
    @WebResult(name = "CoachesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Coaches", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.Coaches")
    @WebMethod(operationName = "Coaches")
    @ResponseWrapper(localName = "CoachesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.CoachesResponse")
    public com.dhenton9000.football.generated.ArrayOftCoaches coaches();

    /**
     * Returns a combination of the total number of yellow and red cards given during this tournament (so far)
     */
    @WebResult(name = "YellowAndRedCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "YellowAndRedCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.YellowAndRedCardsTotal")
    @WebMethod(operationName = "YellowAndRedCardsTotal")
    @ResponseWrapper(localName = "YellowAndRedCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.YellowAndRedCardsTotalResponse")
    public com.dhenton9000.football.generated.TCards yellowAndRedCardsTotal();

    /**
     * Returns an array of Games that are played in the passed city name
     */
    @WebResult(name = "GamesPerCityResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GamesPerCity", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GamesPerCity")
    @WebMethod(operationName = "GamesPerCity")
    @ResponseWrapper(localName = "GamesPerCityResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GamesPerCityResponse")
    public com.dhenton9000.football.generated.ArrayOftGameInfo gamesPerCity(
        @WebParam(name = "sCityName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sCityName
    );

    /**
     * Returns an array of games information
     */
    @WebResult(name = "AllGamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGames", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGames")
    @WebMethod(operationName = "AllGames")
    @ResponseWrapper(localName = "AllGamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGamesResponse")
    public com.dhenton9000.football.generated.ArrayOftGameInfo allGames();

    /**
     * Returns an array with the status codes for the games
     */
    @WebResult(name = "GameResultCodesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GameResultCodes", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GameResultCodes")
    @WebMethod(operationName = "GameResultCodes")
    @ResponseWrapper(localName = "GameResultCodesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GameResultCodesResponse")
    public com.dhenton9000.football.generated.ArrayOftGameResultCode gameResultCodes();

    /**
     * Returns an array of scored goals. If the game id is passed only for that game. You can get the game ID's via the method AllGames
     */
    @WebResult(name = "GoalsScoredResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GoalsScored", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GoalsScored")
    @WebMethod(operationName = "GoalsScored")
    @ResponseWrapper(localName = "GoalsScoredResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GoalsScoredResponse")
    public com.dhenton9000.football.generated.ArrayOftGoal goalsScored(
        @WebParam(name = "iGameId", targetNamespace = "http://footballpool.dataaccess.eu")
        int iGameId
    );

    /**
     * Returns an array of group id's and descriptions. Group is a poule collection of a knock out level
     */
    @WebResult(name = "GroupsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Groups", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.Groups")
    @WebMethod(operationName = "Groups")
    @ResponseWrapper(localName = "GroupsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GroupsResponse")
    public com.dhenton9000.football.generated.ArrayOftGroupInfo groups();

    /**
     * List all the members of all groups/poules
     */
    @WebResult(name = "AllGroupCompetitorsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGroupCompetitors", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGroupCompetitors")
    @WebMethod(operationName = "AllGroupCompetitors")
    @ResponseWrapper(localName = "AllGroupCompetitorsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGroupCompetitorsResponse")
    public com.dhenton9000.football.generated.ArrayOftGroupsCompetitors allGroupCompetitors();

    /**
     * Returns the date of the last game (usually the finals...)
     */
    @WebResult(name = "DateOfLastGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "DateOfLastGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateOfLastGame")
    @WebMethod(operationName = "DateOfLastGame")
    @ResponseWrapper(localName = "DateOfLastGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.DateOfLastGameResponse")
    public javax.xml.datatype.XMLGregorianCalendar dateOfLastGame();

    /**
     * Returns an array with players that have a yellow card. Note: You can only sort on Name or Yellow cards, not on a combination.
     */
    @WebResult(name = "AllPlayersWithYellowCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithYellowCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithYellowCards")
    @WebMethod(operationName = "AllPlayersWithYellowCards")
    @ResponseWrapper(localName = "AllPlayersWithYellowCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithYellowCardsResponse")
    public com.dhenton9000.football.generated.ArrayOftPlayersWithCards allPlayersWithYellowCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByYellowCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByYellowCards
    );

    /**
     * Returns the total number of yellow cards given during this tournament (so far)
     */
    @WebResult(name = "YellowCardsTotalResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "YellowCardsTotal", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.YellowCardsTotal")
    @WebMethod(operationName = "YellowCardsTotal")
    @ResponseWrapper(localName = "YellowCardsTotalResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.YellowCardsTotalResponse")
    public int yellowCardsTotal();

    /**
     * Returns an array with all the city names where games are played
     */
    @WebResult(name = "CitiesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Cities", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.Cities")
    @WebMethod(operationName = "Cities")
    @ResponseWrapper(localName = "CitiesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.CitiesResponse")
    public com.dhenton9000.football.generated.ArrayOfString cities();

    /**
     * Returns an array of country names. The country is a property of a participant. You need the country ID to call PersonsPerCountry.
     */
    @WebResult(name = "CountryNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "CountryNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.CountryNames")
    @WebMethod(operationName = "CountryNames")
    @ResponseWrapper(localName = "CountryNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.CountryNamesResponse")
    public com.dhenton9000.football.generated.ArrayOftCountryInfo countryNames(
        @WebParam(name = "bWithCompetitors", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bWithCompetitors
    );

    /**
     * Returns information (dates and number of games) about the tournament
     */
    @WebResult(name = "TournamentInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TournamentInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TournamentInfo")
    @WebMethod(operationName = "TournamentInfo")
    @ResponseWrapper(localName = "TournamentInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TournamentInfoResponse")
    public com.dhenton9000.football.generated.TTournamentInfo tournamentInfo();

    /**
     * Returns an array of stadium names where the games are played
     */
    @WebResult(name = "StadiumNamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "StadiumNames", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumNames")
    @WebMethod(operationName = "StadiumNames")
    @ResponseWrapper(localName = "StadiumNamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.StadiumNamesResponse")
    public com.dhenton9000.football.generated.ArrayOfString stadiumNames();

    /**
     * Returns the number of games in the tournament
     */
    @WebResult(name = "NumberOfGamesResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "NumberOfGames", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.NumberOfGames")
    @WebMethod(operationName = "NumberOfGames")
    @ResponseWrapper(localName = "NumberOfGamesResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.NumberOfGamesResponse")
    public int numberOfGames();

    /**
     * Returns an array with the team of this competition with the number of times competed and the number of times won
     */
    @WebResult(name = "TeamsCompeteListResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TeamsCompeteList", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TeamsCompeteList")
    @WebMethod(operationName = "TeamsCompeteList")
    @ResponseWrapper(localName = "TeamsCompeteListResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TeamsCompeteListResponse")
    public com.dhenton9000.football.generated.ArrayOftTeamCompete teamsCompeteList();

    /**
     * Returns all team info from a passed team; name, flag, playernames (by role), trainer
     */
    @WebResult(name = "FullTeamInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "FullTeamInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.FullTeamInfo")
    @WebMethod(operationName = "FullTeamInfo")
    @ResponseWrapper(localName = "FullTeamInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.FullTeamInfoResponse")
    public com.dhenton9000.football.generated.TFullTeamInfo fullTeamInfo(
        @WebParam(name = "sTeamName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sTeamName
    );

    /**
     * Returns an array of all teams that compete with a link to the picture of their flag
     */
    @WebResult(name = "TeamsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "Teams", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.Teams")
    @WebMethod(operationName = "Teams")
    @ResponseWrapper(localName = "TeamsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TeamsResponse")
    public com.dhenton9000.football.generated.ArrayOftTeamInfo teams();

    /**
     * Returns the number of groups in the tournament
     */
    @WebResult(name = "GroupCountResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GroupCount", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GroupCount")
    @WebMethod(operationName = "GroupCount")
    @ResponseWrapper(localName = "GroupCountResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GroupCountResponse")
    public int groupCount();

    /**
     * Returns an array with the names of all defenders. If you pass a country name the result will be filtered on that country, so you only get the defenders listed for the specified country
     */
    @WebResult(name = "AllDefendersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllDefenders", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllDefenders")
    @WebMethod(operationName = "AllDefenders")
    @ResponseWrapper(localName = "AllDefendersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllDefendersResponse")
    public com.dhenton9000.football.generated.ArrayOfString allDefenders(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sCountryName
    );

    /**
     * Returns an array with all given cards during the tournament
     */
    @WebResult(name = "AllCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllCards")
    @WebMethod(operationName = "AllCards")
    @ResponseWrapper(localName = "AllCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllCardsResponse")
    public com.dhenton9000.football.generated.ArrayOftCardInfo allCards();

    /**
     * Returns the information about a particular game
     */
    @WebResult(name = "GameInfoResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "GameInfo", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GameInfo")
    @WebMethod(operationName = "GameInfo")
    @ResponseWrapper(localName = "GameInfoResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.GameInfoResponse")
    public com.dhenton9000.football.generated.TGameInfo gameInfo(
        @WebParam(name = "iGameId", targetNamespace = "http://footballpool.dataaccess.eu")
        int iGameId
    );

    /**
     * Returns an array with the names of all midfields. If you pass a country name the result will be filtered on that country, so you only get the midfields listed for the specified country
     */
    @WebResult(name = "AllMidFieldsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllMidFields", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllMidFields")
    @WebMethod(operationName = "AllMidFields")
    @ResponseWrapper(localName = "AllMidFieldsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllMidFieldsResponse")
    public com.dhenton9000.football.generated.ArrayOfString allMidFields(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sCountryName
    );

    /**
     * Returns an array with the names of all goalkeepers. If you pass a country name the result will be filtered on that country, so you only get the goalkeepers listed for the specified country
     */
    @WebResult(name = "AllGoalKeepersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllGoalKeepers", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGoalKeepers")
    @WebMethod(operationName = "AllGoalKeepers")
    @ResponseWrapper(localName = "AllGoalKeepersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllGoalKeepersResponse")
    public com.dhenton9000.football.generated.ArrayOfString allGoalKeepers(
        @WebParam(name = "sCountryName", targetNamespace = "http://footballpool.dataaccess.eu")
        java.lang.String sCountryName
    );

    /**
     * Returns an array with players that have a red or a yellow card. Note: You can only sort on Name, Yellow or Red cards, not on a combination.
     */
    @WebResult(name = "AllPlayersWithYellowOrRedCardsResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "AllPlayersWithYellowOrRedCards", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithYellowOrRedCards")
    @WebMethod(operationName = "AllPlayersWithYellowOrRedCards")
    @ResponseWrapper(localName = "AllPlayersWithYellowOrRedCardsResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.AllPlayersWithYellowOrRedCardsResponse")
    public com.dhenton9000.football.generated.ArrayOftPlayersWithCards allPlayersWithYellowOrRedCards(
        @WebParam(name = "bSortedByName", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByName,
        @WebParam(name = "bSortedByYellowCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByYellowCards,
        @WebParam(name = "bSortedByRedCards", targetNamespace = "http://footballpool.dataaccess.eu")
        boolean bSortedByRedCards
    );

    /**
     * Returns information of the next game
     */
    @WebResult(name = "NextGameResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "NextGame", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.NextGame")
    @WebMethod(operationName = "NextGame")
    @ResponseWrapper(localName = "NextGameResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.NextGameResponse")
    public com.dhenton9000.football.generated.TGameInfo nextGame();

    /**
     * Returns an array with the top N selected goal scorers and how often they are selected. Pass 0 as TopN and you get them all.
     */
    @WebResult(name = "TopSelectedGoalScorersResult", targetNamespace = "http://footballpool.dataaccess.eu")
    @RequestWrapper(localName = "TopSelectedGoalScorers", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TopSelectedGoalScorers")
    @WebMethod(operationName = "TopSelectedGoalScorers")
    @ResponseWrapper(localName = "TopSelectedGoalScorersResponse", targetNamespace = "http://footballpool.dataaccess.eu", className = "com.dhenton9000.football.generated.TopSelectedGoalScorersResponse")
    public com.dhenton9000.football.generated.ArrayOftTopSelectedGoalScorer topSelectedGoalScorers(
        @WebParam(name = "iTopN", targetNamespace = "http://footballpool.dataaccess.eu")
        int iTopN
    );
}
