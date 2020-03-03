import java.util.ArrayList;

public class LeagueManagerImpl implements LeagueManager {

    private static ArrayList<SC2Player> list = new ArrayList<SC2Player>();

    @Override
    public void addPlayer(SC2Player player){ list.add(player); }

    @Override
    public void removePlayer(SC2Player player){
        list.remove(player);
    }

    @Override
    public SC2Player getPlayer(String name){
        for (SC2Player player : list){
            if (player.nickName.equals(name)){
                return player;
            }
        }
        return new SC2Player();
    }

    @Override
    public SC2Player[] getAllPlayers(){
        return list.toArray(new SC2Player[list.size()]);
    }

    @Override
    public SC2Player[] getPlayers(League league){
        ArrayList<SC2Player> res = new ArrayList<SC2Player>();
        for (SC2Player player : list){
            if(player.league == league){
                res.add(player);
            }
        }
        return res.toArray(new SC2Player[res.size()]);
    }

    @Override
    public SC2Player[] getPlayers(Race race){
        ArrayList<SC2Player> res = new ArrayList<SC2Player>();
        for (SC2Player player : list){
            if(player.race == race){
                res.add(player);
            }
        }
        return res.toArray(new SC2Player[res.size()]);
    }

    @Override
    public void addPoints(String name, int points){
        SC2Player player = getPlayer(name);
        player.setPoints(points);
    }


}
