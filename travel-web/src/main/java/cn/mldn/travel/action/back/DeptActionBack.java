package cn.mldn.travel.action.back;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.vo.Dept;
import cn.mldn.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/dept/*")
public class DeptActionBack extends AbstractBaseAction {
	@Resource
	private IEmpServiceBack iEmpServiceBack;
	@Resource
	private IDeptServiceBack ideptServiceBack;
	@RequestMapping("list")
	@RequiresUser
	@RequiresRoles(value = { "emp", "empshow" }, logical = Logical.OR)
	@RequiresPermissions(value = { "dept:list", "deptshow:list" }, logical = Logical.OR)
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("dept.list.page"));
		mav.addAllObjects(ideptServiceBack.listAllDnameAndEname());
		
		return mav;
	}

	
	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("dept:edit")
	
//	注意：前台js传入的iid 的值
	public ModelAndView edit(HttpServletResponse response,Dept dept) {
//		Dept dept= new Dept();
//		dept.setDid((Long)did);
//		dept.setDname(dname);
////		dept.setEid("mldn-dev3");
//		System.out.println(ideptServiceBack.updateDeptName(dept));
		if(ideptServiceBack.updateDeptName(dept)){
			
			super.print(response, "true");
		}
		
//		super.print(response, "false");
//		System.out.println("````````"+did);
//		System.out.println("```````++++`"+dname);
		
		return null;
	}
}
