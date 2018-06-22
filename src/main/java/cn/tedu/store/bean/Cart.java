package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物车的实体类类
 * @author chenjiabing
 */
public class Cart implements Serializable{
	private static final long serialVersionUID = -3734383107924979200L;
	private Integer id;  //主键
	private Integer goodsId;  //商品的id
	private Integer uid;  //用户id
	private Integer num;  //商品的数量
	private String createdUser;  //创建的人
	private Date createdTime;   //创建时间
	private String modifiedUser;  //修改的人
	private Date modifiedTime;   //修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", goodsId=" + goodsId + ", uid=" + uid
				+ ", num=" + num + ", createdUser=" + createdUser
				+ ", createdTime=" + createdTime + ", modifiedUser="
				+ modifiedUser + ", modifiedTime=" + modifiedTime + "]";
	}
	
	
}
