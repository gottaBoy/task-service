/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.ModelBaseImpl
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.ISystemModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psrt.srv.wx.entity.WXAccount
 *  net.ibizsys.psrt.srv.wx.entity.WXEntApp
 *  net.ibizsys.psrt.srv.wx.entity.WXMessage
 *  net.ibizsys.psrt.srv.wx.service.WXAccountService
 *  net.ibizsys.psrt.srv.wx.service.WXEntAppService
 *  net.ibizsys.pswx.bean.WXDept
 *  net.ibizsys.pswx.bean.WXUser
 *  net.ibizsys.pswx.core.IWXAccountModel
 *  net.ibizsys.pswx.core.IWXEntApp
 *  net.ibizsys.pswx.core.IWXEntAppModel
 *  net.ibizsys.pswx.core.IWXLogicModel
 *  net.ibizsys.pswx.core.IWXMenu
 *  org.apache.log4j.Logger
 */
package net.ibizsys.pswx.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.entity.WXMessage;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;
import net.ibizsys.pswx.api.WXEntAddressBookApi;
import net.ibizsys.pswx.bean.WXDept;
import net.ibizsys.pswx.bean.WXUser;
import net.ibizsys.pswx.core.IWXAccountModel;
import net.ibizsys.pswx.core.IWXEntApp;
import net.ibizsys.pswx.core.IWXEntAppModel;
import net.ibizsys.pswx.core.IWXLogicModel;
import net.ibizsys.pswx.core.IWXMenu;
import org.apache.log4j.Logger;

public abstract class WXAccountModelBase
extends ModelBaseImpl
implements IWXAccountModel {
    private static final Logger log = Logger.getLogger(WXAccountModelBase.class);
    protected ArrayList<IWXLogicModel> wxLogicModelList = new ArrayList();
    private IWXMenu defaultWXMenu = null;
    private String strCorpId = null;
    private String strCorpSecret = null;
    private HashMap<String, IWXEntAppModel> wxEntAppModelMap = new HashMap();
    private static HashMap<String, String> wxEntAppModelRuntimeMap = new HashMap();
    private Object objRuntimeId = null;

    protected void registerWXLogicModel(IWXLogicModel iWXLogicModel) throws Exception {
    }

    protected void registerWXEntAppModel(IWXEntAppModel iWXEntAppModel) throws Exception {
        this.wxEntAppModelMap.put(iWXEntAppModel.getId(), iWXEntAppModel);
    }

    public IWXMenu getDefaultWXMenu() {
        return this.defaultWXMenu;
    }

    protected void setDefaultWXMenu(IWXMenu defaultWXMenu) {
        this.defaultWXMenu = defaultWXMenu;
    }

    public String getCorpId() {
        return this.strCorpId;
    }

    public void setCropId(String strCropId) {
        this.strCorpId = strCropId;
    }

    public abstract ISystemModel getSystemModel();

    public void processWXMessage(WXMessage wxMessage) throws Exception {
    }

    protected boolean testWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
        if (StringHelper.compare((String)wxMessage.getMsgType(), (String)"event", (boolean)true) == 0) {
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"enter_agent", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"app_in", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"LOCATION", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"location_in", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"batch_job_result", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"asynctask_finish", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"click", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"menu_click", (boolean)true) == 0) {
                return true;
            }
            if (StringHelper.compare((String)wxMessage.getEvent(), (String)"view", (boolean)true) == 0 && StringHelper.compare((String)iWXLogicModel.getEventType(), (String)"message_in", (boolean)true) == 0) {
                return true;
            }
        }
        return true;
    }

    protected void processWXMessage(IWXLogicModel iWXLogicModel, WXMessage wxMessage) throws Exception {
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public String getCorpSecret() {
        return this.strCorpSecret;
    }

    public void setCropSecret(String strCropSecret) {
        this.strCorpSecret = strCropSecret;
    }

    public IWXEntApp getWXEntApp(String strWXEntAppId) throws Exception {
        IWXEntApp iWXEntApp = (IWXEntApp)this.wxEntAppModelMap.get(strWXEntAppId);
        if (iWXEntApp == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strWXEntAppId));
        }
        return iWXEntApp;
    }

    public IWXEntAppModel getWXEntAppModel(String strWXEntAppId) throws Exception {
        IWXEntAppModel iWXEntApp = this.wxEntAppModelMap.get(strWXEntAppId);
        if (iWXEntApp == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strWXEntAppId));
        }
        return iWXEntApp;
    }

    public IWXEntAppModel getWXEntAppModel(int nAgentId) throws Exception {
        for (IWXEntAppModel iWXEntAppModel : this.wxEntAppModelMap.values()) {
            if (iWXEntAppModel.getAgentId() != nAgentId) continue;
            return iWXEntAppModel;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\uff0c\u4e1a\u52a1\u6807\u8bc6\u4e3a[%1$s]", (Object)nAgentId));
    }

    public CallResult syncWXDept(Collection<WXDept> depts) {
        CallResult result = new CallResult();
        ArrayList<String> errorList = new ArrayList<String>();
        try {
            CallResult callResult2;
            IWXEntAppModel entApp = this.getWXEntAppModel(1);
            CallResult callResult = WXEntAddressBookApi.listDeptEx(entApp.getAccessToken(), 1);
            if (!callResult.isOk()) {
                result.setErrorInfo(callResult.getErrorInfo());
                result.setRetCode(callResult.getRetCode());
                return result;
            }
            List currentList = (List)callResult.getUserObject();
            HashMap<Integer, WXDept> newMap = new HashMap<Integer, WXDept>();
            HashMap<Integer, WXDept> currentMap = new HashMap<Integer, WXDept>();
            ArrayList<WXDept> createList = new ArrayList<WXDept>();
            ArrayList<WXDept> updateList = new ArrayList<WXDept>();
            ArrayList deleteList = new ArrayList();
            for (WXDept dept : depts) {
                newMap.put(dept.getId(), dept);
            }
            for (WXDept dept : currentList) {
                currentMap.put(dept.getId(), dept);
            }
            for (WXDept dept : depts) {
                if (currentMap.containsKey(dept.getId())) {
                    WXDept currentDept = (WXDept)currentMap.remove(dept.getId());
                    if (dept.isSame(currentDept)) continue;
                    updateList.add(dept);
                    continue;
                }
                createList.add(dept);
            }
            deleteList.addAll(currentMap.values());
            Collections.sort(createList, new Comparator<WXDept>(){

                @Override
                public int compare(WXDept o1, WXDept o2) {
                    return o1.getId() > o2.getId() ? 1 : -1;
                }
            });
            Collections.sort(updateList, new Comparator<WXDept>(){

                @Override
                public int compare(WXDept o1, WXDept o2) {
                    return o1.getId() > o2.getId() ? 1 : -1;
                }
            });
            Collections.sort(deleteList, new Comparator<WXDept>(){

                @Override
                public int compare(WXDept o1, WXDept o2) {
                    return o1.getId() > o2.getId() ? -1 : 1;
                }
            });
            for (WXDept dept : createList) {
                if (dept.getId() == 1) continue;
                callResult2 = WXEntAddressBookApi.createDept(entApp.getAccessToken(), dept.toJSON());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u521b\u5efa\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u521b\u5efa\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                errorList.add(String.valueOf(dept.getId()));
            }
            for (WXDept dept : updateList) {
                if (dept.getId() == 1) continue;
                callResult2 = WXEntAddressBookApi.updateDept(entApp.getAccessToken(), dept.toJSON());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u66f4\u65b0\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u66f4\u65b0\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                log.error((Object)dept.toJSON());
                errorList.add(String.valueOf(dept.getId()));
            }
            for (WXDept dept : deleteList) {
                if (dept.getId() == 1) continue;
                callResult2 = WXEntAddressBookApi.deleteDept(entApp.getAccessToken(), dept.getId());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u5220\u9664\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u5220\u9664\u5fae\u4fe1\u90e8\u95e8[" + dept.getId() + "-" + dept.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                errorList.add(String.valueOf(dept.getId()));
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u540c\u6b65\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u5931\u8d25", (Throwable)ex);
            result.setErrorInfo("\u540c\u6b65\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u5931\u8d25");
            result.setRetCode(-1);
        }
        if (result.isOk() && errorList.size() > 0) {
            result.setRetCode(-1);
            result.setErrorInfo("\u540c\u6b65\u90e8\u95e8\u5931\u8d25");
        }
        return result;
    }

    public CallResult syncWXUsers(Collection<WXUser> users) {
        CallResult result = new CallResult();
        ArrayList<String> errorList = new ArrayList<String>();
        try {
            CallResult callResult2;
            IWXEntAppModel entApp = this.getWXEntAppModel(1);
            CallResult callResult = WXEntAddressBookApi.listUserEx(entApp.getAccessToken(), 1, true, 0);
            if (!callResult.isOk()) {
                result.setErrorInfo(callResult.getErrorInfo());
                result.setRetCode(callResult.getRetCode());
                return result;
            }
            List currentList = (List)callResult.getUserObject();
            HashMap<String, WXUser> newMap = new HashMap<String, WXUser>();
            HashMap<String, WXUser> currentMap = new HashMap<String, WXUser>();
            ArrayList<WXUser> createList = new ArrayList<WXUser>();
            ArrayList<WXUser> updateList = new ArrayList<WXUser>();
            ArrayList deleteList = new ArrayList();
            for (WXUser user : users) {
                newMap.put(user.getUserid(), user);
            }
            for (WXUser user : currentList) {
                currentMap.put(user.getUserid(), user);
            }
            for (WXUser user : users) {
                if (currentMap.containsKey(user.getUserid())) {
                    WXUser currentUser = (WXUser)currentMap.remove(user.getUserid());
                    if (user.isSame(currentUser)) continue;
                    updateList.add(user);
                    continue;
                }
                createList.add(user);
            }
            deleteList.addAll(currentMap.values());
            for (WXUser user : createList) {
                callResult2 = WXEntAddressBookApi.createUser(entApp.getAccessToken(), user.toJSON());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u521b\u5efa\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u521b\u5efa\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                errorList.add(String.valueOf(user.getUserid()));
            }
            for (WXUser user : updateList) {
                callResult2 = WXEntAddressBookApi.updateUser(entApp.getAccessToken(), user.toJSON());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u66f4\u65b0\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u66f4\u65b0\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                log.error((Object)user.toJSON());
                errorList.add(String.valueOf(user.getUserid()));
            }
            for (WXUser user : deleteList) {
                callResult2 = WXEntAddressBookApi.deleteUser(entApp.getAccessToken(), user.getUserid());
                if (callResult2.isOk()) {
                    log.debug((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u5220\u9664\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u6210\u529f"));
                    continue;
                }
                log.error((Object)("[\u5fae\u4fe1\u4f01\u4e1a\u53f7\u90e8\u95e8\u540c\u6b65]\u5220\u9664\u5fae\u4fe1\u7528\u6237[" + user.getUserid() + "-" + user.getName() + "]\u5931\u8d25," + callResult2.getErrorInfo()));
                errorList.add(String.valueOf(user.getUserid()));
            }
        }
        catch (Exception ex) {
            log.error((Object)"\u540c\u6b65\u5fae\u4fe1\u4f01\u4e1a\u53f7\u7528\u6237\u5931\u8d25", (Throwable)ex);
            result.setErrorInfo("\u540c\u6b65\u5fae\u4fe1\u4f01\u4e1a\u53f7\u7528\u6237\u5931\u8d25");
            result.setRetCode(-1);
        }
        if (result.isOk() && errorList.size() > 0) {
            result.setRetCode(-1);
            result.setErrorInfo("\u540c\u6b65\u7528\u6237\u5931\u8d25");
        }
        return result;
    }

    public void refresh() throws Exception {
        WXAccountService wxAccountService = (WXAccountService)ServiceGlobal.getService(WXAccountService.class);
        WXEntAppService wxEntAppService = (WXEntAppService)ServiceGlobal.getService(WXEntAppService.class);
        WXAccount account = new WXAccount();
        account.setWXAccountId(this.getId());
        if (wxAccountService.select((IEntity)account, true)) {
            this.setCropId(account.getAPIAppId());
            this.setCropSecret(account.getAPIAppSecret());
        }
        for (IWXEntAppModel app : this.wxEntAppModelMap.values()) {
            WXEntApp wxEntApp = new WXEntApp();
            wxEntApp.setWXEntAppId(app.getId());
            if (wxEntAppService.select((IEntity)wxEntApp, true)) {
                if (wxEntApp.getAgentId() != null) {
                    app.setAgentId(wxEntApp.getAgentId().intValue());
                }
                app.setAppURL(wxEntApp.getAppURL());
                app.setReportEnter(wxEntApp.getREPENTERFlag() != null && wxEntApp.getREPENTERFlag() == 1);
                app.setReportLocation(wxEntApp.getRepLocationFlag() != null && wxEntApp.getRepLocationFlag() == 1);
                app.setAppSecret(wxEntApp.getAPIAppSecret());
                app.setToken(wxEntApp.getAPIToken());
                app.setEncodingAESKey(wxEntApp.getAPIEncodingAESKey());
                continue;
            }
            log.error((Object)("\u521d\u59cb\u5316\u5fae\u4fe1\u4f01\u4e1a\u5e94\u7528\u5931\u8d25,\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528[" + app.getId() + "]"));
        }
    }

    public Object getRuntimeId() {
        if (this.objRuntimeId == null) {
            return this.getId();
        }
        return this.objRuntimeId;
    }

    public void setRuntimeId(Object objRuntimeId) {
        this.objRuntimeId = objRuntimeId;
    }

    public void setWXEntAppModelRuntimeId(String strWXEntAppModelId, Object runtimeId) throws Exception {
        IWXEntAppModel iWXEntAppModel = this.getWXEntAppModel(strWXEntAppModelId);
        if (iWXEntAppModel != null) {
            iWXEntAppModel.setRuntimeId(runtimeId);
        }
        wxEntAppModelRuntimeMap.put(runtimeId.toString(), strWXEntAppModelId);
    }

    public IWXEntAppModel getWXEntAppModelByRuntimeId(Object runtimeId) throws Exception {
        String strRuntimeId = runtimeId.toString();
        String strRealId = wxEntAppModelRuntimeMap.get(strRuntimeId);
        if (strRealId == null) {
            return this.getWXEntAppModel(strRuntimeId);
        }
        return this.getWXEntAppModel(strRealId);
    }
}

