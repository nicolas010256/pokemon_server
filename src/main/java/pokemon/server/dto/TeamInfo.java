package pokemon.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamInfo {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}