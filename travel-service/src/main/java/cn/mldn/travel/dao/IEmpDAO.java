package cn.mldn.travel.dao;

import java.util.Set;

import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;
import cn.mldn.util.dao.IBaseDAO;

public interface IEmpDAO extends IBaseDAO<String, Emp> {

	/**
	 * 根据用户的id查询员工的详细信息
	 * @param eid 员工的id
	 * @return 员工的详细信息
	 */
	public Emp findById(String eid) ;

}
