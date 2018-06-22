package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
	
	//根据id查询余额
	Integer selectAccountById(String id);
	
	//修改的id的余额
	Integer updateAccount(@Param("id")String id,@Param("money")Integer money);
	
}
