package aa.mine.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_message_cate")
public class MessageCategory {

	@Id
	// 设置主键生成策略 该模式只支持MySQL、SQL Server
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long cateId;

	@Column(nullable = false, updatable = false, length = 16)
	private String cateName;

	@Column(nullable = false, updatable = false, length = 32)
	private String descCate;

	@Version
	@Column(nullable = false, updatable = false)
	private long version;
	
	// 多对一关系维护
	/**
	 * 消息分类表下的所有消息
	 */
	//mappedBy = "cateId" 指向多的那方的pojo的关联外键字段 ,避免再生成一个表存储两个实体的主键 
	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "cateId")
	private Set<MessageCategory> cate;

	public long getCateId() {
		return cateId;
	}

	public void setCateId(long cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescCate() {
		return descCate;
	}

	public void setDescCate(String descCate) {
		this.descCate = descCate;
	}

	public Set<MessageCategory> getCate() {
		return cate;
	}

	public void setCate(Set<MessageCategory> cate) {
		this.cate = cate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
