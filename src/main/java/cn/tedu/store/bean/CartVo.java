package cn.tedu.store.bean;

import java.io.Serializable;

/**
 * 购物车的值对象
 * 用于接收多表连接查询的结果
 * @author chenjiabing
 */
public class CartVo implements Serializable {
	private static final long serialVersionUID = 8904622535687816912L;
	private Integer id;    //主键 购物车表中的主键
	private String goodsId;  //商品的id
	private Integer uid;  //用户id
	private String image;  //图片地址
	private String title;  //商品标题
	private Integer price; //商品价格
	private Integer num;  //加入购物车的商品数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", goodsId=" + goodsId + ", uid=" + uid
				+ ", image=" + image + ", title=" + title + ", price=" + price
				+ ", num=" + num + "]";
	}
	
}
