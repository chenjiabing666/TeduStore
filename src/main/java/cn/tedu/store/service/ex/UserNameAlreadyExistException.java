package cn.tedu.store.service.ex;

/**
 * 用户名存在抛出的异常
 * 继承RuntimeException，实现其中的构造方法
 * @author chenjiabing
 */
public class UserNameAlreadyExistException extends Exception {

	public UserNameAlreadyExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNameAlreadyExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNameAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNameAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
