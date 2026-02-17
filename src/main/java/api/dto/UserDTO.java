package api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name; // POST

    @JsonProperty("job")
    private String job;

    @JsonProperty("first_name")
    private String firstName; // GET

    @JsonProperty("last_name")
    private String lastName; // GET

    @JsonProperty("email")
    private String email;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("createdAt")
    private String createdAt;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCreationData() {
        return "<<< Datos Obtenidos >> "
                + "\nName: " + name
                + "\nJob: " + job
                + "\nId: " + id
                + "\nCreatedAt: " + createdAt
                + "\n";
    }

    public String getUserData() {
        return "<<< Datos Obtenidos >> "
                + "\nId: " + id
                + "\nFirst Name: " + firstName
                + "\nLast Name: " + lastName
                + "\nEmail: " + email
                + "\nAvatar: " + avatar
                + "\n";
    }
}