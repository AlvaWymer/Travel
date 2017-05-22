package cn.mldn.travel.action.back;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.vo.Dept;
import cn.mldn.travel.vo.Emp;
import cn.mldn.travel.vo.Level;
import cn.mldn.util.action.abs.AbstractBaseAction;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/pages/back/admin/emp/*")
public class EmpActionBack extends AbstractBaseAction {
	private static final String FLAG = "雇员";

	@RequestMapping("add_pre")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.add.page"));
		return mav;
	}

	@RequestMapping("add")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:add")
	public ModelAndView add(Emp vo, MultipartFile pic, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "emp.add.action", "vo.add.failure",
		// FLAG);
		super.setUrlAndMsg(request, "emp.add.action", "vo.add.success", FLAG);
		return mav;
	}

	@RequestMapping("edit_pre")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	public ModelAndView editPre(String eid) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.edit.page"));
		return mav;
	}

	@RequestMapping("edit")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:edit")
	public ModelAndView edit(Emp vo, MultipartFile pic, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "emp.list.action", "vo.edit.failure",
		// FLAG);
		super.setUrlAndMsg(request, "emp.list.action", "vo.edit.success", FLAG);
		return mav;
	}

//	根据雇员的id 查询到雇员的信息
	@Resource
	private IEmpServiceBack iEmpServiceBack;
	@RequestMapping("get")
	@RequiresUser
//	@RequiresRoles({ "emp", "empshow" })
//	@RequiresPermissions({ "emp:get", "empshow:get" })
	public ModelAndView get(String eid, HttpServletResponse response) {
		System.out.println("0000000000"+iEmpServiceBack.getInformationModal(eid));

		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		Emp emp =(Emp) this.iEmpServiceBack.getInformationModal(eid).get("allemp");
		Dept dept = (Dept) this.iEmpServiceBack.getInformationModal(eid).get("alldept");
		Level level = (Level) this.iEmpServiceBack.getInformationModal(eid).get("alllevel");
		
		JSONObject json = new JSONObject();   
		
		
		
		json.put("modalphoto",emp.getPhoto()); 
		
		json.put("modalename",emp.getEname()); 
	        json.put("modallid", level.getTitle());   
	        json.put("modaldname", dept.getDname());   
	        json.put("modalphone", emp.getPhone());   
	        json.put("modalhiredate", simple.format(emp.getHiredate()).toString()); 
	        json.put("modalenote", emp.getNote()); 
			super.print(response, json);
			return null;

		
		
	

//		super.print(response, json.put("json",iEmpServiceBack.getInformationModal(eid)));
//		
//
//		return null;
	}

	@RequestMapping("list")
	@RequiresUser
	@RequiresRoles(value = { "emp", "empshow" }, logical = Logical.OR)
	@RequiresPermissions(value = { "emp:list", "empshow:list" }, logical = Logical.OR)
	public ModelAndView list(String ids, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("emp.list.page"));
		return mav;
	}

	@RequestMapping("delete")
	@RequiresUser
	@RequiresRoles("emp")
	@RequiresPermissions("emp:delete")
	public ModelAndView delete(String ids, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getUrl("back.forward.page"));
		// super.setUrlAndMsg(request, "emp.list.action", "vo.delete.failure",
		// FLAG);
		super.setUrlAndMsg(request, "emp.list.action", "vo.delete.success", FLAG);
		return mav;
	}
}
