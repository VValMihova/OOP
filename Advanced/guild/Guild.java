package Advanced.guild;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Guild {
    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < capacity) {
            this.roster.put(player.getName(), player);
        }

    }

    public boolean removePlayer(String name) {
        return this.roster.remove(name) != null;
    }

    public int count() {
        return roster.size();
    }

    public void promotePlayer(String name) {
        Player player = this.roster.get(name);
        player.setRank("Member");
    }

    public void demotePlayer(String name) {
        Player player = this.roster.get(name);
        player.setRank("Trial");
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<String> names = new ArrayList<>();
        for (var entry : roster.entrySet()) {
            Player player = entry.getValue();
            if (player.getClazz().equals(clazz)) {
                names.add(entry.getKey());
            }
        }
        Player[] removedPlayers = new Player[names.size()];
        for (int i = 0; i < names.size(); i++) {
            Player player = this.roster.remove(names.get(i));
            removedPlayers[i] = player;
        }
        return removedPlayers;

    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Players in the guild: ").append(name).append(":");
        for (Map.Entry<String, Player> entry : roster.entrySet()) {
            sb.append(System.lineSeparator());
            sb.append(entry.getValue());
        }

        return sb.toString();
    }


    //•	Method report() - returns a String in the following format:
    //o	"Players in the guild: {guildName}:
    //{Player1}
    //{Player2}
    //(…)"
}
