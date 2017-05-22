package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.service.back.abs.AbstractService;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;
@Service
public class DeptServiceBackImpl extends AbstractService implements IDeptServiceBack {
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private IEmpDAO empDAO;

	@Override
	public Map<String, Object> listAllDnameAndEname() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("allEmpManagerName", this.deptDAO.findAllManagerNameForDeptName());

		
		map.put("allDeptName", this.deptDAO.findAllDeptName());
		
		
		return map;
	}

/**
 * 实现更新部门名称的操作
 */
	@Override
	public boolean updateDeptName(Dept dept) {
		// TODO Auto-generated method stub
		System.out.println(deptDAO.doUpdate(dept));
//		if(deptDAO.doUpdateDeptName(did,deptNewName)){
//			return true;
//			
//		}
		return false;
	}
	
	


}
