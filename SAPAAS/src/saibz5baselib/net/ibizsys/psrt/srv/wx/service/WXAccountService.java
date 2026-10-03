/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.entity.OrgSector;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.ibizsys.psrt.srv.common.service.OrgSectorService;
import net.ibizsys.psrt.srv.common.service.OrgService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.entity.WXOrgSector;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.WXGlobal;

import org.springframework.stereotype.Component;

/**
 * 实体[WXAccount] 服务对象
 */
@Component
public class WXAccountService extends WXAccountServiceBase {
	public WXAccountService() {
		super();

	}

	@Override
	protected void onPubMenu(WXAccount wXAccount) throws Exception {
	}

	private void loadOrgData(Org porg, int pid,Map<String, WXDept> xtDeptMap,List<Org> allList) throws Exception {
		OrgService orgService = (OrgService) ServiceGlobal.getService(OrgService.class, getSessionFactory());
		// 获取组织的子组织
		List<Org> suborgList = orgService.selectByPorg(porg);
		
		for (Org subOrg : suborgList) {
			if (subOrg.getValidFlag() != null && subOrg.getValidFlag() == 0) {
				continue;
			}
			
			WXDept wxDept = new WXDept();
			wxDept.setId(Integer.parseInt(subOrg.getOrgCode()));
			wxDept.setName(subOrg.getOrgName());
			wxDept.setParentid(pid);
			wxDept.setOrder(wxDept.getId());
			xtDeptMap.put(subOrg.getOrgId(), wxDept);
			
			allList.add(subOrg);
			
			loadOrgData(subOrg,wxDept.getId(),xtDeptMap,allList);
		}
	}

	@Override
	protected void onSyncOrgSector(WXAccount wXAccount) throws Exception {
		IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXAccount.getWXAccountId());
		if (accountModel == null) {
			throw new Exception("无法获取微信企业号模型对象");
		}

		OrgService orgService = (OrgService) ServiceGlobal.getService(OrgService.class, getSessionFactory());
		OrgSectorService orgSectorService = (OrgSectorService) ServiceGlobal.getService(OrgSectorService.class, getSessionFactory());
		WXOrgSectorService wxOrgSectorService = (WXOrgSectorService) ServiceGlobal.getService(WXOrgSectorService.class, getSessionFactory());
		Org org = new Org();
		org.setOrgId(wXAccount.getOrgId());

		Map<String, WXDept> xtDeptMap = new HashMap<String, WXDept>();

		if (!orgService.select(org, true)) {
			throw new Exception("无法获取公众号根组织[" + wXAccount.getOrgId() + "]");
		}

		WXDept rootDept = new WXDept();
		rootDept.setId(1);
		rootDept.setName(org.getOrgName());
		rootDept.setOrder(1);

		xtDeptMap.put(org.getOrgId(), rootDept);
		
		List<Org> suborgList  = new ArrayList<Org>();
		suborgList.add(org);
		
		loadOrgData(org,1,xtDeptMap,suborgList);
		
		
		ArrayList<OrgSector> allDepts = new ArrayList<OrgSector>();

		for (Org curOrg : suborgList) {
			ArrayList<OrgSector> list = orgSectorService.selectByOrg(curOrg);

			allDepts.addAll(list);

			for (OrgSector sector : list) {
				if (sector.getValidFlag() != null && sector.getValidFlag() == 0) {
					continue;
				}
				WXOrgSector wxSector = new WXOrgSector();
				wxSector.setWXOrgSectorId(sector.getOrgSectorId());

				if (!wxOrgSectorService.select(wxSector, true)) {
					throw new Exception("无法获取部门[" + sector.getOrgSectorId() + "]在微信部门中对应的数据");
				}

				WXDept wxDept = new WXDept();
				wxDept.setId(wxSector.getDeptId());
				wxDept.setName(wxSector.getWXOrgSectorName());

				wxDept.setOrder(sector.getOrderValue() == null ? 1 : Math.abs(sector.getOrderValue()));

				xtDeptMap.put(sector.getOrgSectorId(), wxDept);
			}
		}

		for (OrgSector sector : allDepts) {
			if (sector.getValidFlag() != null && sector.getValidFlag() == 0) {
				continue;
			}

			String pid = sector.getPOrgSectorId();
			int nPid = 1;
			if (!StringHelper.isNullOrEmpty(pid)) {
				nPid = xtDeptMap.get(pid).getId();
			} else {
				String orgId = sector.getOrgId();
				if (!StringHelper.isNullOrEmpty(orgId)) {
					WXDept dept = xtDeptMap.get(orgId);
					if (dept != null) {
						nPid = dept.getId();
					}
				}
			}
			WXDept dept = xtDeptMap.get(sector.getOrgSectorId());

			if (dept != null && dept.getId() != 1) {
				dept.setParentid(nPid);
			}
		}
		
		xtDeptMap.remove(org.getOrgId());

		// 将数据同步到微信中
		CallResult callResult = accountModel.syncWXDept(xtDeptMap.values());

		if (callResult.isError()) {
			throw new Exception(callResult.getErrorInfo());
		}
	}

	private void loadAllOrgs(Org porg,List<Org> allList) throws Exception {
		OrgService orgService = (OrgService) ServiceGlobal.getService(OrgService.class, getSessionFactory());
		// 获取组织的子组织
		List<Org> suborgList = orgService.selectByPorg(porg);
		
		for (Org subOrg : suborgList) {
			if (subOrg.getValidFlag() != null && subOrg.getValidFlag() == 0) {
				continue;
			}
			allList.add(subOrg);
			loadAllOrgs(subOrg,allList);
		}
	}
	
	@Override
	protected void onSyncOrgUser(WXAccount wXAccount) throws Exception {
		IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXAccount.getWXAccountId());
		if (accountModel == null) {
			throw new Exception("无法获取微信企业号模型对象");
		}

		OrgUserService orgUserService = (OrgUserService) ServiceGlobal.getService(OrgUserService.class, getSessionFactory());
		WXOrgSectorService wxOrgSectorService = (WXOrgSectorService) ServiceGlobal.getService(WXOrgSectorService.class, getSessionFactory());
		MsgAccountService msgAccountService = (MsgAccountService) ServiceGlobal.getService(MsgAccountService.class, getSessionFactory());
		Org org = new Org();
		org.setOrgId(wXAccount.getOrgId());

		
		List<Org> allOrgs = new ArrayList<Org>();
		allOrgs.add(org);
		
		loadAllOrgs(org,allOrgs);
		
		
		List<OrgUser> allUsers = new ArrayList<OrgUser>();
		
		for(Org subOrg : allOrgs){
			ArrayList<OrgUser> list = orgUserService.selectByOrg(subOrg);
			
			allUsers.addAll(list);
		}

		Map<String, WXUser> xtUserMap = new HashMap<String, WXUser>();

		for (OrgUser user : allUsers) {
			if (user.getValidFlag() != null && user.getValidFlag() == 0) {
				continue;
			}

			// 获取对应的微信部门
			WXOrgSector wxSector = new WXOrgSector();
			wxSector.setWXOrgSectorId(user.getOrgSectorId());

			if (!wxOrgSectorService.select(wxSector, true)) {
				throw new Exception("无法获取部门[" + user.getOrgSectorId() + "]在微信部门中对应的数据");
			}

			// 获取对应的消息账户
			MsgAccount account = new MsgAccount();
			account.setMsgAccountId(user.getOrgUserId());

			if (!msgAccountService.select(account, true)) {
				throw new Exception("无法获取用户[" + user.getOrgUserId() + "]在消息账户中对应的数据");
			}

			WXUser wxUser = new WXUser();
			// 微信账号
			wxUser.setUserid(account.getWXAddr());
			// 姓名
			wxUser.setName(user.getOrgUserName());
			// 部门
			wxUser.setDepartment(wxSector.getDeptId());
			// 邮件地址
			wxUser.setEmail(account.getMailAddress());
			// 手机号
			wxUser.setMobile(account.getMobile());
			// 是否启用
			wxUser.setEnable(user.getValidFlag() != null ? (int) user.getValidFlag() : 1);

			wxUser.setOrder(user.getOrderValue() == null ? 1 : Math.abs(user.getOrderValue()));

			xtUserMap.put(wxUser.getUserid(), wxUser);
		}

		// 将数据同步到微信中
		CallResult callResult = accountModel.syncWXUsers(xtUserMap.values());
		if (callResult.isError()) {
			throw new Exception(callResult.getErrorInfo());
		}
	}
}