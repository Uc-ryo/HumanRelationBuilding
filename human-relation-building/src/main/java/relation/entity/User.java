package relation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "user_id", nullable = false)
	public String userId;

	@Column(name = "password", nullable = false)
	public String password;
}
