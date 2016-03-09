package po;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Hongbao hongbao;
	private String openid;
	private Boolean userStatus;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String openid) {
		this.openid = openid;
	}

	/** full constructor */
	public AbstractUser(Hongbao hongbao, String openid, Boolean userStatus) {
		this.hongbao = hongbao;
		this.openid = openid;
		this.userStatus = userStatus;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Hongbao getHongbao() {
		return this.hongbao;
	}

	public void setHongbao(Hongbao hongbao) {
		this.hongbao = hongbao;
	}

	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Boolean getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

}