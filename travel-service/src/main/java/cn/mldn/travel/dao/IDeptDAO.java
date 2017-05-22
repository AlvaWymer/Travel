package cn.mldn.travel.dao;

import java.util.List;
import java.util.Set;

import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;
import cn.mldn.util.dao.IBaseDAO;

public interface IDeptDAO extends IBaseDAO<Long, Dept> {
	
	/**
	 * 查询所有的部门名称
	 * @return 返回全部的部门名称集合
	 */
	public Set<Dept> findAllDeptName() ;
	
	/**
	 * 根据部门表中查到的eid 查询到 雇员表中 部门所对应的部门经理 
	 * @param dept 部门
	 * @return 返回的部门管理者的名字
	 */
	public List<Emp> findAllManagerNameForDeptName() ;
	
	//```````````````````````````````````````````````````````````
/**
 *  根据雇员的id，查询到雇员对应的部门
 * @param eid
 * @return
 */
	public Dept findById(String eid);
	
	//```````````````````````````````````````````````````````````
//	/**
//	 * 根据 部门的id 来实现更新部门的名字
//	 * @param did
//	 * @return
//	 */
//	public boolean doUpdateDeptName(Long did,String dname);
}
