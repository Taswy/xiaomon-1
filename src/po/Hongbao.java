package po;

import java.util.Set;

/**
 * Hongbao entity. @author MyEclipse Persistence Tools
 */
public class Hongbao extends AbstractHongbao implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Hongbao() {
	}

	/** minimal constructor */
	public Hongbao(String kouling) {
		super(kouling);
	}

	/** full constructor */
	public Hongbao(String kouling, Boolean stauts, Set users) {
		super(kouling, stauts, users);
	}

}
