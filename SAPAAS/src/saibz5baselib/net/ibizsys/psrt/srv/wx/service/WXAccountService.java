/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
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
import net.ibizsys.psrt.srv.wx.service.WXAccountServiceBase;
import net.ibizsys.psrt.srv.wx.service.WXOrgSectorService;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.WXGlobal;
import org.springframework.stereotype.Component;

@Component
public class WXAccountService
extends WXAccountServiceBase {
    @Override
    protected void onPubMenu(WXAccount wXAccount) throws Exception {
    }

    private void loadOrgData(Org porg, int pid, Map<String, WXDept> xtDeptMap, List<Org> allList) throws Exception {
        OrgService orgService = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
        ArrayList<Org> suborgList = orgService.selectByPorg(porg);
        for (Org subOrg : suborgList) {
            if (subOrg.getValidFlag() != null && subOrg.getValidFlag() == 0) continue;
            WXDept wxDept = new WXDept();
            wxDept.setId(Integer.parseInt(subOrg.getOrgCode()));
            wxDept.setName(subOrg.getOrgName());
            wxDept.setParentid(pid);
            wxDept.setOrder(wxDept.getId());
            xtDeptMap.put(subOrg.getOrgId(), wxDept);
            allList.add(subOrg);
            this.loadOrgData(subOrg, wxDept.getId(), xtDeptMap, allList);
        }
    }

    @Override
    protected void onSyncOrgSector(WXAccount wXAccount) throws Exception {
        IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXAccount.getWXAccountId());
        if (accountModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u6a21\u578b\u5bf9\u8c61");
        }
        OrgService orgService = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
        OrgSectorService orgSectorService = (OrgSectorService)ServiceGlobal.getService(OrgSectorService.class, this.getSessionFactory());
        WXOrgSectorService wxOrgSectorService = (WXOrgSectorService)ServiceGlobal.getService(WXOrgSectorService.class, this.getSessionFactory());
        Org org = new Org();
        org.setOrgId(wXAccount.getOrgId());
        HashMap<String, WXDept> xtDeptMap = new HashMap<String, WXDept>();
        if (!orgService.select(org, true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u516c\u4f17\u53f7\u6839\u7ec4\u7ec7[" + wXAccount.getOrgId() + "]");
        }
        WXDept rootDept = new WXDept();
        rootDept.setId(1);
        rootDept.setName(org.getOrgName());
        rootDept.setOrder(1);
        xtDeptMap.put(org.getOrgId(), rootDept);
        ArrayList<Org> suborgList = new ArrayList<Org>();
        suborgList.add(org);
        this.loadOrgData(org, 1, xtDeptMap, suborgList);
        ArrayList<OrgSector> allDepts = new ArrayList<OrgSector>();
        for (Org curOrg : suborgList) {
            ArrayList<OrgSector> list = orgSectorService.selectByOrg(curOrg);
            allDepts.addAll(list);
            for (OrgSector sector : list) {
                if (sector.getValidFlag() != null && sector.getValidFlag() == 0) continue;
                WXOrgSector wxSector = new WXOrgSector();
                wxSector.setWXOrgSectorId(sector.getOrgSectorId());
                if (!wxOrgSectorService.select(wxSector, true)) {
                    throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u90e8\u95e8[" + sector.getOrgSectorId() + "]\u5728\u5fae\u4fe1\u90e8\u95e8\u4e2d\u5bf9\u5e94\u7684\u6570\u636e");
                }
                WXDept wxDept = new WXDept();
                wxDept.setId(wxSector.getDeptId());
                wxDept.setName(wxSector.getWXOrgSectorName());
                wxDept.setOrder(sector.getOrderValue() == null ? 1 : Math.abs(sector.getOrderValue()));
                xtDeptMap.put(sector.getOrgSectorId(), wxDept);
            }
        }
        for (OrgSector sector : allDepts) {
            if (sector.getValidFlag() != null && sector.getValidFlag() == 0) continue;
            String pid = sector.getPOrgSectorId();
            int nPid = 1;
            if (!StringHelper.isNullOrEmpty(pid)) {
                nPid = ((WXDept)xtDeptMap.get(pid)).getId();
            } else {
                WXDept dept;
                String orgId = sector.getOrgId();
                if (!StringHelper.isNullOrEmpty(orgId) && (dept = (WXDept)xtDeptMap.get(orgId)) != null) {
                    nPid = dept.getId();
                }
            }
            WXDept dept = (WXDept)xtDeptMap.get(sector.getOrgSectorId());
            if (dept == null || dept.getId() == 1) continue;
            dept.setParentid(nPid);
        }
        xtDeptMap.remove(org.getOrgId());
        CallResult callResult = accountModel.syncWXDept(xtDeptMap.values());
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }

    private void loadAllOrgs(Org porg, List<Org> allList) throws Exception {
        OrgService orgService = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
        ArrayList<Org> suborgList = orgService.selectByPorg(porg);
        for (Org subOrg : suborgList) {
            if (subOrg.getValidFlag() != null && subOrg.getValidFlag() == 0) continue;
            allList.add(subOrg);
            this.loadAllOrgs(subOrg, allList);
        }
    }

    @Override
    protected void onSyncOrgUser(WXAccount wXAccount) throws Exception {
        IWXAccountModel accountModel = WXGlobal.getWXAccountModel(wXAccount.getWXAccountId());
        if (accountModel == null) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5fae\u4fe1\u4f01\u4e1a\u53f7\u6a21\u578b\u5bf9\u8c61");
        }
        OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class, this.getSessionFactory());
        WXOrgSectorService wxOrgSectorService = (WXOrgSectorService)ServiceGlobal.getService(WXOrgSectorService.class, this.getSessionFactory());
        MsgAccountService msgAccountService = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class, this.getSessionFactory());
        Org org = new Org();
        org.setOrgId(wXAccount.getOrgId());
        ArrayList<Org> allOrgs = new ArrayList<Org>();
        allOrgs.add(org);
        this.loadAllOrgs(org, allOrgs);
        ArrayList<OrgUser> allUsers = new ArrayList<OrgUser>();
        for (Org subOrg : allOrgs) {
            ArrayList<OrgUser> list = orgUserService.selectByOrg(subOrg);
            allUsers.addAll(list);
        }
        HashMap<String, WXUser> xtUserMap = new HashMap<String, WXUser>();
        for (OrgUser user : allUsers) {
            if (user.getValidFlag() != null && user.getValidFlag() == 0) continue;
            WXOrgSector wxSector = new WXOrgSector();
            wxSector.setWXOrgSectorId(user.getOrgSectorId());
            if (!wxOrgSectorService.select(wxSector, true)) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u90e8\u95e8[" + user.getOrgSectorId() + "]\u5728\u5fae\u4fe1\u90e8\u95e8\u4e2d\u5bf9\u5e94\u7684\u6570\u636e");
            }
            MsgAccount account = new MsgAccount();
            account.setMsgAccountId(user.getOrgUserId());
            if (!msgAccountService.select(account, true)) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u7528\u6237[" + user.getOrgUserId() + "]\u5728\u6d88\u606f\u8d26\u6237\u4e2d\u5bf9\u5e94\u7684\u6570\u636e");
            }
            WXUser wxUser = new WXUser();
            wxUser.setUserid(account.getWXAddr());
            wxUser.setName(user.getOrgUserName());
            wxUser.setDepartment(wxSector.getDeptId());
            wxUser.setEmail(account.getMailAddress());
            wxUser.setMobile(account.getMobile());
            wxUser.setEnable(user.getValidFlag() != null ? user.getValidFlag() : 1);
            wxUser.setOrder(user.getOrderValue() == null ? 1 : Math.abs(user.getOrderValue()));
            xtUserMap.put(wxUser.getUserid(), wxUser);
        }
        CallResult callResult = accountModel.syncWXUsers(xtUserMap.values());
        if (callResult.isError()) {
            throw new Exception(callResult.getErrorInfo());
        }
    }
}

