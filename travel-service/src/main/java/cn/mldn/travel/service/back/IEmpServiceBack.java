package cn.mldn.travel.service.back;

import java.util.Map;
import java.util.Set;

import cn.mldn.travel.vo.Emp;

public interface IEmpServiceBack {
	
	/**
	 * 根据员工的信息查询出员工的信息
	 * @param eid
	 * @return 包括如下内容：<br>
	 * 1. key="allemp",value="",要调用的方法：IEmpDAO.java 继承的IbaseDAO 中findById<br>
	 * 2. key="alldept",value="",要调用的方法：IDeptDAO.java 继承的IbaseDAO 中findById<br>
	 * 3. key="alllevel",value="",要调用的方法：ILevelDAO.java 继承的IbaseDAO 中findById 
	 * 根据上面的第1个方法来查到对应的等级信息
	 */
	public Map<String,Object> getInformationModal(String eid) ;
	
	/**
	 * 根据员工的id查询出员工的所有信息
	 * @param eid 员工的id
	 * @return 员工 vo
	 */
	public Emp getEmpInfo(String eid);
	/**
	 * 根据雇员id获得雇员完整信息
	 * @param eid 雇员编号
	 * @return 包括如下内容：<br>
	 * 1、key = emp、value = 雇员对象，如果该雇员不存在返回null<br>
	 * 2、如果雇员信息可以查询成功，则查询对应级别信息。key = level
	 */
	public Map<String,Object> get(String eid,String password) ;
	/**
	 * 根据雇员编号取得雇员对应的角色与权限数据信息，该操作主要执行如下功能：<br>
	 * 1、调用IRoleDAO.findAllIdByEmp()查询出所有的角色标记信息；<br>
	 * 2、调用IActionDAO.findAllIdByEmp()查询出所有的权限标记信息；<br>
	 * @param eid 要查询角色和权限的雇员编号
	 * @return 返回Map集合数据包含有如下内容：<br>
	 * 1、key = allRoles、value = 所有的角色标记信息；<br>
	 * 2、key = allActions、value = 所有的权限标记信息；<br>
	 */
	public Map<String,Set<String>> listRoleAndAction(String eid) ;
	
}
