package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品的实体类
 * @author chenjiabing
 */
public class Goods implements Serializable { 
	private static final long serialVersionUID = -1318651275645945833L;
	private String id;  //主键id
	private Integer categoryId;  // 分类的id
	private String itemType; // 商品系列
	private String title ;   //商品标题
	private String sellPoint;  //商品卖点
	private Integer price;   //价格
	private Integer num;  //数量
	private String barCode;  //条形码
	private String image;   // 图片路径
	private Integer status;  //商品状态 1：上架   2：下架   3：删除'
	private Integer priority;  //显示优先级
	private String createdUser;  //创建的人
	private Date createdTime;   //创建时间
	private String modifiedUser;  //修改的人
	private Date modifiedTime;   //修改时间
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
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
	@Override
	public String toString() {
		return "Goods [id=" + id + ", categoryId=" + categoryId + ", itemType="
				+ itemType + ", title=" + title + ", sellPoint=" + sellPoint
				+ ", price=" + price + ", num=" + num + ", barCode=" + barCode
				+ ", image=" + image + ", status=" + status + ", priority="
				+ priority + ", createdUser=" + createdUser + ", createdTime="
				+ createdTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
	
}
