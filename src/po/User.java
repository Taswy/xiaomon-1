package po;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String openid) {
		super(openid);
	}

	/** full constructor */
	public User(Hongbao hongbao, String openid, Boolean userStatus) {
		super(hongbao, openid, userStatus);
	}

}
