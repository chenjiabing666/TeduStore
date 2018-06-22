package cn.tedu.store.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface IAccountService {
	
	@Transactional(propagation=Propagation.REQUIRED) 
	void modifyMoneyById(String id) throws Exception;
	
	void test(String id1, String id2, Integer money); 
	
	
	@Transactional(readOnly=true)
	Integer getMoneyById(String id);
}
