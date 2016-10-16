package aa.mine.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "t_message")
public class Message {

	//在加载数据的时候可以为其指定顺序  用于集合中
	//@OrderBy(value = "group_name ASC, name DESC")
	/**
	 * 定义属性名首字母必须小写，否则报错：
	 * 
	 * Unable to locate Attribute with the the given name [id] on this
	 * ManagedType [aa.mine.model.Message]
	 * 
	 * 在getter、setter过程中，首字母会被改为大写 无法定位给定名称的属性
	 * 
	 * 总之：根据 POJO 规范，首字母要小写
	 */
	@Id
	// 设置主键生成策略 该模式只支持MySQL、SQL Server
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, updatable = false, length = 16)
	private String name;

	@Column(nullable = false, updatable = false)
	private Date publishDate;

	@Column(nullable = false, updatable = false, length = 16)
	private String publisher;

	@Column(nullable = false, updatable = false, length = 128)
	private String content;

	@Column(nullable = false, updatable = false, length = 16)
	private String aaBbCcDd;

	@Version
	@Column(nullable = false, updatable = false)
	private long version;

	// 多对一关系维护
	@ManyToOne(cascade = CascadeType.DETACH) // 当前实体和cate的关系
	@JoinColumn(name = "cateId", referencedColumnName="cateName",nullable = false, updatable = false) // 分类表的主键在当前消息表中的标示字段名称
	private MessageCategory cate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAaBbCcDd() {
		return aaBbCcDd;
	}

	public void setAaBbCcDd(String aaBbCcDd) {
		this.aaBbCcDd = aaBbCcDd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MessageCategory getCate() {
		return cate;
	}

	public void setCate(MessageCategory cate) {
		this.cate = cate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
