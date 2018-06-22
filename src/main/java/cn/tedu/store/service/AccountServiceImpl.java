package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements IAccountService {

	@Resource
	private AccountMapper accountMapper;
	
	public void test(String id1, String id2, Integer money) {
		Integer a1=accountMapper.updateAccount(id1, 600-money);
		
		if (a1==0) {
			throw new RuntimeException("update1异常");
		}
		
		Integer a2=accountMapper.updateAccount(id2,400+money);
		
		if (a2==0) {
			throw new RuntimeException("update2异常");
		}
	}

	//获取余额
	public Integer getMoneyById(String id) {
		return accountMapper.selectAccountById(id);
	}

	public void modifyMoneyById(String id) throws Exception {
		Integer n=accountMapper.updateAccount(id, 100);
		if (n==0) {
			throw new Exception("n==0");
		}
		accountMapper.updateAccount("1000", 1000);
	}
	
	
}
