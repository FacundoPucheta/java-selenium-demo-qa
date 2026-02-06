package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponseDTO {
    @JsonProperty("data")
    private UserDTO data;

    public UserDTO getData() {
        return data;
    }

    public void setData(UserDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.getUserData();
    }
}
