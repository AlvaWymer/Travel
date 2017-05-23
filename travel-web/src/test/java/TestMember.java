
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.travel.service.back.IDeptServiceBack;
import cn.mldn.travel.service.back.IEmpServiceBack;
import cn.mldn.travel.service.back.impl.DeptServiceBackImpl;
import cn.mldn.travel.service.back.impl.EmpServiceBackImpl;
import cn.mldn.travel.vo.Dept;

@ContextConfiguration(locations = {"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMember {
	
	@Resource
	private IDeptServiceBack ideptServiceBack;
	/**
	 * 验证用户名
	 */
	@Test
	public void testGet() {
		System.out.println("+++++++"+ideptServiceBack.listAllDnameAndEname());
	}
//	/**
//	 * 验证根据用户名 是否能够得到 用户对应的权限和角色
//	 *
//	 */
//	@Test
//	public void testRoleAndAction() {
//		System.out.println(memberService.getRoleAndAction("mldn"));
//	}
	
	/**
	 * 验证获取用户的个人信息
	 */
	@Resource
	private IEmpServiceBack iEmpServiceBack;
	@Test
	public void testGet1() {
		System.out.println("testGet1()+++++++-----"+iEmpServiceBack.getEmpInfo("mldn1"));
	}
	

	/**
	 * 根据部门id 更新部门的名称
	 */
	
	@Test
	public void testGet2() {
		Dept dept= new Dept();
		dept.setDid(7L);
		dept.setDname("shichangbu");
		dept.setEid("mldn-dev3");
		System.out.println(ideptServiceBack.updateDeptName(dept));
	}
	
//	@Resource
//	private IDeptServiceBack ideptServiceBack;
	
	@Test
	public void testGet3() {
		System.out.println(iEmpServiceBack.getInformationModal("mldn-dev1"));
	}
	
	@Test
	public void testGet4() {
		System.out.println(ideptServiceBack.updateDeptNameAndManager(7l,"mldn-human"));
	}
	
	
}
