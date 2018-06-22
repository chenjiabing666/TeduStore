package cn.tedu.store.bean;

import java.util.List;

/**
 * 封装异步请求的返回的结果类型
 * @author chenjiabing
 * @param <T>  泛型，用于封装返回数据，如果创建对象为这样ResponseResult<List<User>> responseResult=new ResponseResult<List<User>>();
 * 				那么此时的data类型是List<User>类型的
 */
public class ResponseResult<T> {
	private Integer state;  //响应状态码
	private String message;   //响应信息
	private T data;  //响应的数据
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		ResponseResult other = (ResponseResult) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message
				+ ", data=" + data + "]";
	}
	
}
