package cn.tedu.store.bean;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
	private static final long serialVersionUID = -417656563566744263L;
	private Integer id;  //主键
	private Integer uid;  //用户表的外键
	private String recvName;   //收件人姓名
	private String recvProvince;  //省份
	private String recvCity;   //城市
	private String recvArea;  //市区
	private String recvDistrict;  //省份，城市，市区的结合 比如： 江苏省淮安市盱眙县
	private String recvAddress;  //详细地址  比如什么小区，几单元房间号
	private String recvPhone;  //手机电话号码
	private String recvTel;     //固定电话
	private Integer recvZip;  //邮件地址
	private String recvTag;   //地址名称，比如家，宿舍，公司
	private Integer isDefault;  //判断改地址是默认的，1表示默认，0表示非默认
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvProvince() {
		return recvProvince;
	}
	public void setRecvProvince(String recvProvince) {
		this.recvProvince = recvProvince;
	}
	public String getRecvCity() {
		return recvCity;
	}
	public void setRecvCity(String recvCity) {
		this.recvCity = recvCity;
	}
	public String getRecvArea() {
		return recvArea;
	}
	public void setRecvArea(String recvArea) {
		this.recvArea = recvArea;
	}
	public String getRecvDistrict() {
		return recvDistrict;
	}
	public void setRecvDistrict(String recvDistrict) {
		this.recvDistrict = recvDistrict;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvTel() {
		return recvTel;
	}
	public void setRecvTel(String recvTel) {
		this.recvTel = recvTel;
	}
	public Integer getRecvZip() {
		return recvZip;
	}
	public void setRecvZip(Integer recvZip) {
		this.recvZip = recvZip;
	}
	public String getRecvTag() {
		return recvTag;
	}
	public void setRecvTag(String recvTag) {
		this.recvTag = recvTag;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result
				+ ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result
				+ ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result
				+ ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result
				+ ((recvAddress == null) ? 0 : recvAddress.hashCode());
		result = prime * result
				+ ((recvArea == null) ? 0 : recvArea.hashCode());
		result = prime * result
				+ ((recvCity == null) ? 0 : recvCity.hashCode());
		result = prime * result
				+ ((recvDistrict == null) ? 0 : recvDistrict.hashCode());
		result = prime * result
				+ ((recvName == null) ? 0 : recvName.hashCode());
		result = prime * result
				+ ((recvPhone == null) ? 0 : recvPhone.hashCode());
		result = prime * result
				+ ((recvProvince == null) ? 0 : recvProvince.hashCode());
		result = prime * result + ((recvTag == null) ? 0 : recvTag.hashCode());
		result = prime * result + ((recvTel == null) ? 0 : recvTel.hashCode());
		result = prime * result + ((recvZip == null) ? 0 : recvZip.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (recvAddress == null) {
			if (other.recvAddress != null)
				return false;
		} else if (!recvAddress.equals(other.recvAddress))
			return false;
		if (recvArea == null) {
			if (other.recvArea != null)
				return false;
		} else if (!recvArea.equals(other.recvArea))
			return false;
		if (recvCity == null) {
			if (other.recvCity != null)
				return false;
		} else if (!recvCity.equals(other.recvCity))
			return false;
		if (recvDistrict == null) {
			if (other.recvDistrict != null)
				return false;
		} else if (!recvDistrict.equals(other.recvDistrict))
			return false;
		if (recvName == null) {
			if (other.recvName != null)
				return false;
		} else if (!recvName.equals(other.recvName))
			return false;
		if (recvPhone == null) {
			if (other.recvPhone != null)
				return false;
		} else if (!recvPhone.equals(other.recvPhone))
			return false;
		if (recvProvince == null) {
			if (other.recvProvince != null)
				return false;
		} else if (!recvProvince.equals(other.recvProvince))
			return false;
		if (recvTag == null) {
			if (other.recvTag != null)
				return false;
		} else if (!recvTag.equals(other.recvTag))
			return false;
		if (recvTel == null) {
			if (other.recvTel != null)
				return false;
		} else if (!recvTel.equals(other.recvTel))
			return false;
		if (recvZip == null) {
			if (other.recvZip != null)
				return false;
		} else if (!recvZip.equals(other.recvZip))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvName=" + recvName
				+ ", recvProvince=" + recvProvince + ", recvCity=" + recvCity
				+ ", recvArea=" + recvArea + ", recvDistrict=" + recvDistrict
				+ ", recvAddress=" + recvAddress + ", recvPhone=" + recvPhone
				+ ", recvTel=" + recvTel + ", recvZip=" + recvZip
				+ ", recvTag=" + recvTag + ", isDefault=" + isDefault
				+ ", createdUser=" + createdUser + ", createdTime="
				+ createdTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
	
	
	
}
