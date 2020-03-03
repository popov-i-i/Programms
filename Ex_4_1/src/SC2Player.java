public class SC2Player {
    String nickName;
    int points;
    League league;
    Race race;

    public SC2Player(String nickName, int points, League league, Race race){
        this.nickName = nickName;
        this.points = points;
        this.league = league;
        this.race = race;
    }

    public SC2Player(){
        nickName = "Player";
        points = 0;
        league = League.PRACTICE;
        race = Race.TERRAN;
    }

    public void setPoints(int points){
        this.points = points;
    }

    @Override
    public String toString(){
        return "Player: " + nickName + "/ Points: " + points + "/ League: " + league +  "/ Race: "+ race;
    }
}
