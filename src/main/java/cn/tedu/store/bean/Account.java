package cn.tedu.store.bean;

public class Account {
	private String id;
	private Integer money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", money=" + money + "]";
	}
	
}
