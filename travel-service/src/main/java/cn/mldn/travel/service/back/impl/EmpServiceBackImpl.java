package cn.mldn.travel.service.back.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.travel.dao.IActionDAO;
import cn.mldn.travel.dao.IDeptDAO;
import cn.mldn.travel.dao.IEmpDAO;
import cn.mldn.travel.dao.ILevelDAO;
import cn.mldn.travel.dao.IRoleDAO;
import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.service.back.abs.AbstractService;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;

@Service
public class EmpServiceBackImpl extends AbstractService implements IEmpServiceBack {
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private IEmpDAO empDAO;
	@Resource
	private IRoleDAO roleDAO;
	@Resource
	private IActionDAO actionDAO;
	@Resource
	private ILevelDAO levelDAO;

	@Override
	public Map<String, Object> get(String eid, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		Emp emp = this.empDAO.findById(eid);
		if (emp != null) {
			if (password.equals(emp.getPassword())) {
				map.put("level", this.levelDAO.findById(emp.getLid()));
			}
		}
		map.put("emp", emp);
		return map;
	}

	@Override
	public Map<String, Set<String>> listRoleAndAction(String eid) {
		Map<String, Set<String>> map = new HashMap<String, Set<String>>();
		map.put("allRoles", this.roleDAO.findAllIdByEmp(eid));
		map.put("allActions", this.actionDAO.findAllIdByEmp(eid));
		return map;
	}
//获得领导的个人信息
	@Override
	public Emp getEmpInfo(String eid) {
	
		Emp emp = this.empDAO.findById(eid);
		return emp;
	}

//	获取领导的个人信息
	@Override
	public Map<String, Object> getInformationModal(String eid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
//		对应的领导的的信息
		Emp emp= empDAO.findById(eid);
		map.put("allemp", emp);
		System.out.println(emp.getDid());
//		对应的领导的部门信息
//```````````````````````````````````````````````````````````
		map.put("alldept", deptDAO.findById(eid));
//		map.put("alldept", deptDAO.findById(emp.getDid()));
//```````````````````````````````````````````````````````````
//		对应的领导的等级信息
		map.put("alllevel", levelDAO.findById(emp.getLid()));
		return map;
	}

}
