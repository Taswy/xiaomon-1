package po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractHongbao entity provides the base persistence definition of the
 * Hongbao entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractHongbao implements java.io.Serializable {

	// Fields

	private Integer idHongbao;
	private String kouling;
	private Boolean stauts;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractHongbao() {
	}

	/** minimal constructor */
	public AbstractHongbao(String kouling) {
		this.kouling = kouling;
	}

	/** full constructor */
	public AbstractHongbao(String kouling, Boolean stauts, Set users) {
		this.kouling = kouling;
		this.stauts = stauts;
		this.users = users;
	}

	// Property accessors

	public Integer getIdHongbao() {
		return this.idHongbao;
	}

	public void setIdHongbao(Integer idHongbao) {
		this.idHongbao = idHongbao;
	}

	public String getKouling() {
		return this.kouling;
	}

	public void setKouling(String kouling) {
		this.kouling = kouling;
	}

	public Boolean getStauts() {
		return this.stauts;
	}

	public void setStauts(Boolean stauts) {
		this.stauts = stauts;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}