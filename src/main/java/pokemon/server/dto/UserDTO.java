package pokemon.server.dto;

public class UserDTO {
  private String username;
  private String email;

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the password to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the password to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  
}