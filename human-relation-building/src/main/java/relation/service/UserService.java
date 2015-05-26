package relation.service;

import java.util.ArrayList;
import java.util.List;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relation.dto.UserDto;
import relation.entity.User;

public class UserService extends S2AbstractService<User> {

	/**
	 * ユーザIDとパスワードをチェックするメソッド
	 * @param userDto
	 * @return
	 */
	public boolean checkUser(UserDto userDto) {
		List<UserDto> userDtos = getAllDto();
		for (UserDto user : userDtos) {
			if (userDto.userId.equals(user.userId) &&
					userDto.password.equals(user.password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * findAllが探してきたデータを取得する
	 * @return
	 */
	public List<UserDto> getAllDto() {
		List<User> users = findAll();
		List<UserDto> userDto = createDto(users);
		return userDto;
	}

	/**
	 * Dtoにentityの値を入れる
	 * @param users
	 * @return
	 */
	private List<UserDto> createDto(List<User> users) {
		List<UserDto> userList = new ArrayList<UserDto>();
		for (User user : users) {
			UserDto userDisp = new UserDto(user.userId, user.password);

			userList.add(userDisp);
		}
		return userList;
	}
}

