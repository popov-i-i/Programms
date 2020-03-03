public class Main {

    public static void main(String[] args) {

        LeagueManagerImpl game = new LeagueManagerImpl();
        SC2Player player1 = new SC2Player("First", 1, League.PRACTICE, Race.TERRAN);
        SC2Player player2 = new SC2Player("Second", 2, League.GOLD, Race.ZERG);
        SC2Player player3 = new SC2Player("Third", 3, League.PRO, Race.TERRAN);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        System.out.println(game.getPlayer("First"));

        for (SC2Player player : game.getPlayers(League.GOLD)) {
            System.out.println(player);
        }

        game.addPoints("First", 15);
        System.out.println(player1);
    }
}
