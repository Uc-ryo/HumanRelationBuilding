package relation.dto;


public class UserDto {

	public UserDto() {}

	public UserDto(String userId, String password) {
		this.userId   = userId;
		this.password = password;
	}

	public String userId;

	public String password;

	public String errorMasage;
}
