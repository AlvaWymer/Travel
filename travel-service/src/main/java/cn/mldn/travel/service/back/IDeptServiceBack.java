package cn.mldn.travel.service.back;

import java.util.Map;
import java.util.Set;

import cn.mldn.travel.vo.Dept;

public interface IDeptServiceBack {

	/**
	 * 列出所有的部门姓名，部门的管理人员的姓名
	 * 1.调用IDeptDAO.findAllDeptName() 查询出所有的部门的名称 <br>
	 * 2.调用IDeptDAO.findAllManagerNameForDeptName()
	 * 根据部门信息里面的部门负责人员的id查询出该部门的 负责人的姓名<br>
	 * @return 返回Map集合数据包含有如下内容：<br>
	 * 
	 */
	public Map<String, Object> listAllDnameAndEname();
	/**
	 * 根据传入的部门id，实现，更新部门信息的操作
	 * @param dept vo对象
	 * @return 如果成功返回true，如果失败，返回false
	 */
	public boolean updateDeptName(Dept dept);
}
