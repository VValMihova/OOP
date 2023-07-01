package Encapsulation_02.Exsersice.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {

//+	getRating() : double
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void removePlayer(String player){
        boolean isRemoved = this.players.removeIf(player1 -> player1.getName().equals(player));
        if (!isRemoved){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }

        }

    public double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
