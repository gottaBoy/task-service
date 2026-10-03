/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.WT.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.WT.Ctrl.IWTAPIHelper;
import SA.WT.Ctrl.IWTAccountHelper;
import SA.WT.Ctrl.IWTServiceHelper;
import SA.WT.Ctrl.WTAPIHelper;
import SA.WT.Ctrl.WTBaseObject;
import SA.WT.Ctrl.WTCallResult;
import SA.WT.Data.WTAccessToken;
import SA.WT.Data.WTAccount;
import SA.WT.Data.WTIncomeMessage;
import SA.WT.Data.WTMenu;
import SA.WT.Data.WTServiceBase;
import SA.WT.Data.WTServiceSession;
import SA.WT.Data.WTUser;
import SA.WT.Data.WTUserGroup;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WTAccountHelper
extends WTBaseObject
implements IWTAccountHelper {
    private static final Log log = LogFactory.getLog(WTAccountHelper.class);
    private WTAccount wtAccount = null;
    private IWTAPIHelper iWTAPIHelper = null;
    private String strAccessToken = "";
    private WTAccessToken wtAccessTokenActive = new WTAccessToken();
    private Timer wtAccountTimer = null;
    private HashMap<String, WTUser> wtUserMap = new HashMap();
    private HashMap<String, WTServiceSession> wtServiceSessionMap = new HashMap();
    private HashMap<String, ArrayList<IDEDataCtrl>> wtDataCtrlMap = new HashMap();
    private String strDefaultWTServiceId = "";
    private String strVerifyWTServiceId = "";
    private String strSubscribeWTServiceId = "";
    private HashMap<String, String> predefinedWTServiceMap = new HashMap();
    private boolean bAdvAPI = true;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, WTAccount wtAccount) throws Exception {
        this.wtAccount = wtAccount;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.wtAccount.getWTACCOUNTID());
        this.setName(this.wtAccount.getWTACCOUNTNAME().toUpperCase());
        if (!this.wtAccount.isENABLEADVAPINull()) {
            this.bAdvAPI = this.wtAccount.getENABLEADVAPI();
        }
        this.OnInit();
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        Vector<WTServiceBase> wtServiceBaseList = new Vector<WTServiceBase>();
        CallResult callResult = this.getWTModelHelper().GetPredefinedWTService(this.getId(), wtServiceBaseList);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u53f7\u4e0e\u5b9a\u4e49\u670d\u52a1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (WTServiceBase wtServiceBase : wtServiceBaseList) {
            this.predefinedWTServiceMap.put(wtServiceBase.getPRESERVICEMODE(), wtServiceBase.getWTSERVICEBASEID());
        }
        this.strDefaultWTServiceId = this.predefinedWTServiceMap.get("DEFAULTSERVICE");
        this.strVerifyWTServiceId = this.predefinedWTServiceMap.get("VERIFYSERVICE");
        this.strSubscribeWTServiceId = this.predefinedWTServiceMap.get("SUBSCRIBESERVICE");
        this.iWTAPIHelper = new WTAPIHelper();
        this.iWTAPIHelper.Init(this.iDAGlobalHelper, this);
        this.OnPrepareWTAccessToken();
        this.wtAccountTimer = new Timer("WFACCOUNT_" + this.getId());
        this.wtAccountTimer.schedule((TimerTask)new WFAccountTimerTask(), 60000L, 60000L);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnPrepareWTAccessToken() throws Exception {
        IDEDataCtrl wtAccessTokenDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("WT0030", "SYSTEM", null);
        WTAccessToken wtAccessToken = new WTAccessToken();
        wtAccessToken.setWTACCOUNTID(this.getId());
        CallResult callResult = wtAccessTokenDataCtrl.Select((BaseDataEntity)wtAccessToken, "", "ORDER BY EXPIREDTIME DESC");
        if (callResult.IsError() && callResult.getRetCode() != 3) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6700\u540e\u7684\u51ed\u8bc1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Date curDate = new Date();
        boolean bRenew = true;
        if (!wtAccessToken.isEXPIREDTIMENull() && wtAccessToken.getEXPIREDTIME().getTime() - curDate.getTime() > 3600000L) {
            WTAccessToken wTAccessToken = this.wtAccessTokenActive;
            synchronized (wTAccessToken) {
                this.strAccessToken = wtAccessToken.getACCESSTOKEN();
                wtAccessToken.CopyTo(this.wtAccessTokenActive, true);
            }
            bRenew = false;
        }
        if (bRenew) {
            WTCallResult wtCallResult = this.getWTAPI().getAccessToken();
            if (wtCallResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u51ed\u8bc1\u53d1\u751f\u9519\u8bef, %1$s", (Object)wtCallResult.getErrorInfo()));
            }
            wtAccessToken.Reset();
            wtAccessToken.setWTACCOUNTID(this.getId());
            if (wtCallResult.getRawObject().has("access_token")) {
                wtAccessToken.setACCESSTOKEN(wtCallResult.getRawObject().getString("access_token"));
            }
            if (wtCallResult.getRawObject().has("expires_in")) {
                long nSeconds = wtCallResult.getRawObject().getInt("expires_in");
                Timestamp dtExpired = new Timestamp(curDate.getTime() + nSeconds * 1000L);
                wtAccessToken.setEXPIREDTIME(dtExpired);
            }
            if ((callResult = wtAccessTokenDataCtrl.Save(true, (BaseDataEntity)wtAccessToken)).IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bbf\u95ee\u51ed\u8bc1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            WTAccessToken wTAccessToken = this.wtAccessTokenActive;
            synchronized (wTAccessToken) {
                this.strAccessToken = wtAccessToken.getACCESSTOKEN();
                wtAccessToken.CopyTo(this.wtAccessTokenActive, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void RefreshWTAccessToken() throws Exception {
        CallResult callResult;
        Date curDate = new Date();
        IDEDataCtrl wtAccessTokenDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("WT0030", "SYSTEM", null);
        WTCallResult wtCallResult = this.getWTAPI().getAccessToken();
        if (wtCallResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u51ed\u8bc1\u53d1\u751f\u9519\u8bef, %1$s", (Object)wtCallResult.getErrorInfo()));
        }
        WTAccessToken wtAccessToken = new WTAccessToken();
        wtAccessToken.Reset();
        wtAccessToken.setWTACCOUNTID(this.getId());
        if (wtCallResult.getRawObject().has("access_token")) {
            wtAccessToken.setACCESSTOKEN(wtCallResult.getRawObject().getString("access_token"));
        }
        if (wtCallResult.getRawObject().has("expires_in")) {
            long nSeconds = wtCallResult.getRawObject().getInt("expires_in");
            Timestamp dtExpired = new Timestamp(curDate.getTime() + nSeconds * 1000L);
            wtAccessToken.setEXPIREDTIME(dtExpired);
        }
        if ((callResult = wtAccessTokenDataCtrl.Save(true, (BaseDataEntity)wtAccessToken)).IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8bbf\u95ee\u51ed\u8bc1\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        WTAccessToken wTAccessToken = this.wtAccessTokenActive;
        synchronized (wTAccessToken) {
            this.strAccessToken = wtAccessToken.getACCESSTOKEN();
            wtAccessToken.CopyTo(this.wtAccessTokenActive, true);
        }
    }

    @Override
    public String getAPIAppId() {
        return this.wtAccount.getAPIAPPID();
    }

    @Override
    public String getAPIAppSecret() {
        return this.wtAccount.getAPIAPPSECRET();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String getAPIAccessToken() {
        WTAccessToken wTAccessToken = this.wtAccessTokenActive;
        synchronized (wTAccessToken) {
            return this.strAccessToken;
        }
    }

    @Override
    public IWTAPIHelper getWTAPI() {
        return this.iWTAPIHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnAccountTimer() {
        Date curDate = new Date();
        boolean bRefreshWTAccessToken = false;
        WTAccessToken wTAccessToken = this.wtAccessTokenActive;
        synchronized (wTAccessToken) {
            if (this.wtAccessTokenActive.getEXPIREDTIME().getTime() - curDate.getTime() <= 1800000L) {
                bRefreshWTAccessToken = true;
            }
        }
        if (bRefreshWTAccessToken) {
            try {
                this.RefreshWTAccessToken();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5237\u65b0\u51ed\u8bc1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    @Override
    public void PublishWTMenu() throws Exception {
        JSONObject joMenu = this.PrepareWTMenuObject();
        log.debug((Object)StringHelper.Format((String)"\u53d1\u5e03\u83dc\u5355\r\n%1$s", (Object)joMenu.toString()));
        WTCallResult wtCallResult = this.getWTAPI().PublishMenu(joMenu);
        if (wtCallResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
        }
    }

    protected JSONObject PrepareWTMenuObject() throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("WTACCOUNTID", (Object)this.getId());
        cond.SetParamValue("VALIDFLAG", (Object)1);
        IDEDataCtrl wtMenuDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("WT0060", "SYSTEM", null);
        Vector wtMenuList = new Vector();
        CallResult callResult = wtMenuDataCtrl.Select(cond, wtMenuList, WTMenu.class.getName(), "ORDER BY ORDERFLAG");
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u83dc\u5355\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        ArrayList<JSONObject> topMenuList = new ArrayList<JSONObject>();
        int i = 0;
        while (i < wtMenuList.size()) {
            WTMenu wtMenu = (WTMenu)((Object)wtMenuList.get(i));
            if (StringHelper.IsNullOrEmpty((String)wtMenu.getPWTMENUID())) {
                JSONObject topMenu = new JSONObject();
                topMenu.put("name", (Object)wtMenu.getWTMENUNAME());
                ArrayList<JSONObject> childMenuList = new ArrayList<JSONObject>();
                int j = 0;
                while (j < wtMenuList.size()) {
                    WTMenu wtMenu2 = (WTMenu)((Object)wtMenuList.get(j));
                    if (StringHelper.Compare((String)wtMenu2.getPWTMENUID(), (String)wtMenu.getWTMENUID(), (boolean)true) == 0) {
                        JSONObject childMenu = new JSONObject();
                        childMenu.put("name", (Object)wtMenu2.getWTMENUNAME());
                        childMenu.put("type", (Object)wtMenu2.getMENUTYPE());
                        if (StringHelper.Compare((String)wtMenu2.getMENUTYPE(), (String)"view", (boolean)true) == 0) {
                            childMenu.put("url", (Object)wtMenu2.getVIEWURL());
                        } else if (StringHelper.Compare((String)wtMenu2.getMENUTYPE(), (String)"click", (boolean)true) == 0) {
                            childMenu.put("key", (Object)wtMenu2.getWTSERVICEBASEID());
                        }
                        childMenuList.add(childMenu);
                    }
                    ++j;
                }
                if (childMenuList.size() > 0) {
                    topMenu.put("sub_button", (Object)childMenuList.toArray());
                } else {
                    topMenu.put("type", (Object)wtMenu.getMENUTYPE());
                    if (StringHelper.Compare((String)wtMenu.getMENUTYPE(), (String)"view", (boolean)true) == 0) {
                        topMenu.put("url", (Object)wtMenu.getVIEWURL());
                    } else if (StringHelper.Compare((String)wtMenu.getMENUTYPE(), (String)"click", (boolean)true) == 0) {
                        topMenu.put("key", (Object)wtMenu.getWTSERVICEBASEID());
                    }
                }
                topMenuList.add(topMenu);
            }
            ++i;
        }
        JSONObject ret = new JSONObject();
        ret.put("button", (Object)topMenuList.toArray());
        return ret;
    }

    @Override
    public void SyncWTUserGroup(boolean bRefreshLocal) throws Exception {
        BaseDataEntity cond = new BaseDataEntity();
        cond.SetParamValue("WTACCOUNTID", (Object)this.getId());
        cond.SetParamValue("VALIDFLAG", (Object)1);
        IDEDataCtrl wtUserGroupDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("WT0022", "SYSTEM", null);
        Vector<WTUserGroup> wtUserGroupList = new Vector<WTUserGroup>();
        CallResult callResult = wtUserGroupDataCtrl.Select(cond, wtUserGroupList, WTUserGroup.class.getName());
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, WTUserGroup> wtUserGroupMap = new HashMap<String, WTUserGroup>();
        HashMap<String, WTUserGroup> wtUserGroupMap2 = new HashMap<String, WTUserGroup>();
        for (WTUserGroup wtUserGroup : wtUserGroupList) {
            if (StringHelper.IsNullOrEmpty((String)wtUserGroup.getWTUSEROBJECTNO())) {
                wtUserGroupMap2.put(wtUserGroup.getWTUSERGROUPNAME(), wtUserGroup);
                continue;
            }
            wtUserGroupMap.put(wtUserGroup.getWTUSEROBJECTNO(), wtUserGroup);
        }
        wtUserGroupList.clear();
        WTCallResult wtCallResult = this.getWTAPI().ListUserGroup(wtUserGroupList);
        if (wtCallResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"API\u67e5\u8be2\u5fae\u4fe1\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
        }
        for (WTUserGroup wtUserGroup : wtUserGroupList) {
            WTUserGroup wtUserGroup2;
            if (wtUserGroupMap.containsKey(wtUserGroup.getWTUSEROBJECTNO())) {
                wtUserGroup2 = (WTUserGroup)((Object)wtUserGroupMap.get(wtUserGroup.getWTUSEROBJECTNO()));
                if (StringHelper.Compare((String)wtUserGroup.getWTUSERGROUPNAME(), (String)wtUserGroup2.getWTUSERGROUPNAME(), (boolean)false) == 0) continue;
                if (bRefreshLocal) {
                    wtUserGroup2.setWTUSERGROUPNAME(wtUserGroup.getWTUSERGROUPNAME());
                    callResult = wtUserGroupDataCtrl.Save(false, (BaseDataEntity)wtUserGroup2);
                    if (!callResult.IsError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                wtCallResult = this.getWTAPI().UpdateUserGroup(wtUserGroup2);
                if (!wtCallResult.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"API\u66f4\u65b0\u5fae\u4fe1\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
            }
            wtUserGroup2 = (WTUserGroup)((Object)wtUserGroupMap2.get(wtUserGroup.getWTUSERGROUPNAME()));
            if (wtUserGroup2 != null) {
                wtUserGroup2.setWTUSEROBJECTNO(wtUserGroup.getWTUSEROBJECTNO());
                callResult = wtUserGroupDataCtrl.Save(false, (BaseDataEntity)wtUserGroup2);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                wtUserGroupMap2.remove(wtUserGroup.getWTUSERGROUPNAME());
                continue;
            }
            callResult = wtUserGroupDataCtrl.Save(true, (BaseDataEntity)wtUserGroup);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (WTUserGroup wtUserGroup2 : wtUserGroupMap2.values()) {
            wtCallResult = this.getWTAPI().CreateUserGroup(wtUserGroup2);
            if (wtCallResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"API\u5efa\u7acb\u5fae\u4fe1\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
            }
            callResult = wtUserGroupDataCtrl.Save(false, (BaseDataEntity)wtUserGroup2);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public void SyncWTUser(boolean bRefreshLocal) throws Exception {
        ArrayList<String> openIdList = new ArrayList<String>();
        WTCallResult wtCallResult = this.getWTAPI().ListUser(openIdList);
        if (wtCallResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"API\u67e5\u8be2\u5fae\u4fe1\u7528\u6237\u5217\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
        }
        IDEDataCtrl wtUserDataCtrl = this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl("WT0021", "SYSTEM", null);
        for (String strOpenId : openIdList) {
            WTUser wtUser = new WTUser();
            wtUser.setWTACCOUNTID(this.getId());
            wtUser.setWTUSERID(strOpenId);
            wtUser.setWTUSEROBJECTNO(strOpenId);
            wtCallResult = this.getWTAPI().GetUser(wtUser);
            if (wtCallResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"API\u67e5\u8be2\u5fae\u4fe1\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
            }
            CallResult callResult = wtUserDataCtrl.AutoSave((BaseDataEntity)wtUser);
            if (!callResult.IsError()) continue;
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public String ProcessIncomeMessage(String strMessage) throws Exception {
        try {
            WTIncomeMessage wtIncomeMessage = WTIncomeMessage.FromRawContent(strMessage);
            BaseDEDataCtrl.SetCallParamDALog((BaseDataEntity)wtIncomeMessage, (boolean)false);
            BaseDEDataCtrl.SetCallParamCheckKey((BaseDataEntity)wtIncomeMessage, (boolean)false);
            IDEDataCtrl wtIncomeMessageDataCtrl = this.getDEDataCtrl("WT0025");
            CallResult callResult = wtIncomeMessageDataCtrl.Save(true, (BaseDataEntity)wtIncomeMessage);
            this.ReleaseDEDataCtrl(wtIncomeMessageDataCtrl);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u8f93\u5165\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)"text", (boolean)true) == 0) {
                return this.OnProcessTextMessage(wtIncomeMessage);
            }
            if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)"voice", (boolean)true) == 0) {
                return this.OnProcessTextMessage(wtIncomeMessage);
            }
            if (StringHelper.Compare((String)wtIncomeMessage.getMSGTYPE(), (String)"event", (boolean)true) == 0) {
                return this.OnProcessEventMessage(wtIncomeMessage);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
        }
        return "";
    }

    protected String OnProcessTextMessage(WTIncomeMessage wtIncomeMessage) throws Exception {
        String strFromUserName = wtIncomeMessage.getFROMUSERNAME();
        WTUser wtUser = this.getWTUser(strFromUserName);
        WTServiceSession wtServiceSession = this.getUserLastServiceSession(strFromUserName);
        if (wtServiceSession != null) {
            IWTServiceHelper iWTServiceHelper = this.getWTModelStorage().FindWTService(wtServiceSession.getWTSERVICEBASEID());
            String strRep = iWTServiceHelper.ContinueSession(wtUser, wtServiceSession, wtIncomeMessage);
            IDEDataCtrl wtServiceSessionDataCtrl = this.getDEDataCtrl("WT0070");
            CallResult callResult = wtServiceSessionDataCtrl.Save(false, (BaseDataEntity)wtServiceSession);
            this.ReleaseDEDataCtrl(wtServiceSessionDataCtrl);
            if (wtServiceSession.getSTOPSESSION()) {
                this.setUserLastServiceSession(strFromUserName, null);
            }
            return strRep;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strDefaultWTServiceId)) {
            return this.StartNewServiceSession(this.strDefaultWTServiceId, wtIncomeMessage, null);
        }
        return "";
    }

    protected String OnProcessEventMessage(WTIncomeMessage wtIncomeMessage) throws Exception {
        if (StringHelper.Compare((String)wtIncomeMessage.getEVENT(), (String)"CLICK", (boolean)true) == 0) {
            String strEventKey = wtIncomeMessage.getCONTENT();
            return this.StartNewServiceSession(strEventKey, wtIncomeMessage, null);
        }
        if (StringHelper.Compare((String)wtIncomeMessage.getEVENT(), (String)"SUBSCRIBE", (boolean)true) == 0) {
            if (!StringHelper.IsNullOrEmpty((String)this.strSubscribeWTServiceId)) {
                return this.StartNewServiceSession(this.strSubscribeWTServiceId, wtIncomeMessage, null);
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strDefaultWTServiceId)) {
                return this.StartNewServiceSession(this.strDefaultWTServiceId, wtIncomeMessage, null);
            }
        }
        if (StringHelper.Compare((String)wtIncomeMessage.getEVENT(), (String)"SCAN", (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)this.strDefaultWTServiceId)) {
            return this.StartNewServiceSession(this.strDefaultWTServiceId, wtIncomeMessage, null);
        }
        return "";
    }

    protected String StartNewServiceSession(String strWTServiceId, WTIncomeMessage wtIncomeMessage, IWTServiceHelper referWTServiceHelper) throws Exception {
        String strFromUserName = wtIncomeMessage.getFROMUSERNAME();
        this.setUserLastServiceSession(strFromUserName, null);
        IWTServiceHelper iWTServiceHelper = this.getWTModelStorage().FindWTService(strWTServiceId);
        WTUser wtUser = this.getWTUser(strFromUserName);
        if (iWTServiceHelper.isRequireVerify() && !wtUser.getVERIFYFLAG()) {
            if (StringHelper.IsNullOrEmpty((String)this.strVerifyWTServiceId)) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u8eab\u4efd\u8bc6\u522b\u670d\u52a1"));
            }
            return this.StartNewServiceSession(this.strVerifyWTServiceId, wtIncomeMessage, referWTServiceHelper);
        }
        WTServiceSession wtServiceSession = iWTServiceHelper.StartSession(wtUser);
        IDEDataCtrl wtServiceSessionDataCtrl = this.getDEDataCtrl("WT0070");
        CallResult callResult = wtServiceSessionDataCtrl.Save(true, (BaseDataEntity)wtServiceSession);
        this.setUserLastServiceSession(strFromUserName, wtServiceSession);
        String strRep = iWTServiceHelper.ContinueSession(wtUser, wtServiceSession, wtIncomeMessage);
        wtServiceSessionDataCtrl.Save(false, (BaseDataEntity)wtServiceSession);
        this.ReleaseDEDataCtrl(wtServiceSessionDataCtrl);
        return strRep;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WTUser getWTUser(String strWTUserId) throws Exception {
        WTCallResult wtCallResult;
        WTUser wtUser = null;
        HashMap<String, WTUser> hashMap = this.wtUserMap;
        synchronized (hashMap) {
            wtUser = this.wtUserMap.get(strWTUserId);
        }
        if (wtUser != null) {
            return wtUser;
        }
        wtUser = new WTUser();
        wtUser.setWTACCOUNTID(this.getId());
        wtUser.setWTUSERID(strWTUserId);
        wtUser.setWTUSEROBJECTNO(strWTUserId);
        if (this.bAdvAPI && (wtCallResult = this.getWTAPI().GetUser(wtUser)).IsError()) {
            throw new Exception(StringHelper.Format((String)"API\u67e5\u8be2\u5fae\u4fe1\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)wtCallResult.getErrorInfo()));
        }
        IDEDataCtrl wtUserDataCtrl = this.getDEDataCtrl("WT0021");
        CallResult callResult = wtUserDataCtrl.AutoSave((BaseDataEntity)wtUser);
        System.out.println(wtUser.getWTUSERID());
        this.ReleaseDEDataCtrl(wtUserDataCtrl);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, WTUser> hashMap2 = this.wtUserMap;
        synchronized (hashMap2) {
            this.wtUserMap.put(strWTUserId, wtUser);
        }
        return wtUser;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setUserLastServiceSession(String strWTUserId, WTServiceSession wtServiceSession) {
        HashMap<String, WTServiceSession> hashMap = this.wtServiceSessionMap;
        synchronized (hashMap) {
            if (wtServiceSession == null) {
                this.wtServiceSessionMap.remove(strWTUserId);
            } else {
                this.wtServiceSessionMap.put(strWTUserId, wtServiceSession);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected WTServiceSession getUserLastServiceSession(String strWTUserId) {
        Date updateDate;
        WTServiceSession wtServiceSession = null;
        HashMap<String, WTServiceSession> hashMap = this.wtServiceSessionMap;
        synchronized (hashMap) {
            wtServiceSession = this.wtServiceSessionMap.get(strWTUserId);
        }
        if (wtServiceSession != null && (updateDate = wtServiceSession.getUPDATEDATE()) != null && new Date().getTime() - updateDate.getTime() >= 600000L) {
            HashMap<String, WTServiceSession> hashMap2 = this.wtServiceSessionMap;
            synchronized (hashMap2) {
                this.wtServiceSessionMap.remove(strWTUserId);
            }
            wtServiceSession = null;
        }
        return wtServiceSession;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IDEDataCtrl getDEDataCtrl(String strDEId) throws Exception {
        ArrayList<IDEDataCtrl> list = null;
        Cloneable cloneable = this.wtDataCtrlMap;
        synchronized (cloneable) {
            list = this.wtDataCtrlMap.get(strDEId);
            if (list == null) {
                list = new ArrayList<IDEDataCtrl>();
                this.wtDataCtrlMap.put(strDEId, list);
            }
        }
        cloneable = list;
        synchronized (cloneable) {
            if (list.size() > 0) {
                return (IDEDataCtrl)list.remove(0);
            }
        }
        return this.getDAGlobalHelper().getDAModelStorage().FindDEDataCtrl2(strDEId, "SYSTEM", null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void ReleaseDEDataCtrl(IDEDataCtrl iDEDataCtrl) {
        ArrayList<IDEDataCtrl> list = null;
        Cloneable cloneable = this.wtDataCtrlMap;
        synchronized (cloneable) {
            list = this.wtDataCtrlMap.get(iDEDataCtrl.GetDEHelper().getId());
            if (list == null) {
                list = new ArrayList<IDEDataCtrl>();
                this.wtDataCtrlMap.put(iDEDataCtrl.GetDEHelper().getId(), list);
            }
        }
        cloneable = list;
        synchronized (cloneable) {
            if (list.size() < 20) {
                list.add(iDEDataCtrl);
            }
        }
    }

    protected class WFAccountTimerTask
    extends TimerTask {
        private boolean bRunTimer = false;

        protected WFAccountTimerTask() {
        }

        @Override
        public void run() {
            if (this.bRunTimer) {
                return;
            }
            this.bRunTimer = true;
            WTAccountHelper.this.OnAccountTimer();
            this.bRunTimer = false;
        }
    }
}
