package aa.mine.model.OneToOne;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class test implements Serializable{
	
	private static final long serialVersionUID = 5260045025079981216L;

	@Id
	private long teid;
	
	@Id
	private long stid;
}
