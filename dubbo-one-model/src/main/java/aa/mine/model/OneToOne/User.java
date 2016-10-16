package aa.mine.model.OneToOne;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity  
public class User implements Serializable {  
	
	private static final long serialVersionUID = 905654767215634L;
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
	
    @Column(name="USER_NAME",length=100)
    private String userName;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private Address address;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}