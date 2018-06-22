package cn.tedu.store.service.ex;

/**
 * 修改的数据不存在的异常类
 * @author chenjiabing
 *
 */
public class DataNotExisteException extends Exception {

	public DataNotExisteException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataNotExisteException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataNotExisteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotExisteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DataNotExisteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
