package cn.tedu.store.service.ex;

/**
 * 密码不匹配的异常
 * 重写父类的所有构造方法
 * @author chenjiabing
 *
 */
public class PassWordNotMatchException extends Exception {

	public PassWordNotMatchException() {
		super();
	}

	public PassWordNotMatchException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PassWordNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PassWordNotMatchException(String message) {
		super(message);
	}

	public PassWordNotMatchException(Throwable cause) {
		super(cause);
	}

}
