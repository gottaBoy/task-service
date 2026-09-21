/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
import SA.IM.Ctrl.Data.IMDisGroup;
import SA.IM.Ctrl.Data.IMDisGroupDetail;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMUGDetail;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.Data.IMUserGroup;
import SA.IM.Ctrl.Data.IMUserInform;
import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.IIMCometEvent;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMStateServerContext;
import SA.IM.Ctrl.IIMUserSessionInstance;
import SA.IM.Ctrl.IMMessageBase;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMObjectBase;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.Message.IMInformMessage;
import SA.IM.Ctrl.Message.IMUserInformMessage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMUserSessionInstance
extends IMObjectBase
implements IIMUserSessionInstance {
    protected Vector<IMMessageBase> imMessageList = new Vector();
    protected Vector<IMMessageBase> imMessageList2 = new Vector();
    protected IMUserSession imUserSession = null;
    protected IIMCometEvent cometEvent = null;
    private static final Log log = LogFactory.getLog(IMUserSessionInstance.class);
    private Object cometEventLock = new Object();
    private Date activeDate = null;
    private Object activeDateLock = new Object();
    private Date lastLiveDate = null;
    protected IIMStateServerContext imStateServerContext = null;
    protected Timestamp userLastInformTime = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IIMStateServerContext imStateServerContext, IMUserSession imUserSession) throws Exception {
        this.setGlobalHelper(iDAGlobalHelper);
        this.imStateServerContext = imStateServerContext;
        this.imUserSession = imUserSession;
        this.activeDate = new Date();
        this.userLastInformTime = this.imUserSession.getLASTINFORMTIME();
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public String getUserId() {
        return this.imUserSession.getIMUSERID();
    }

    @Override
    public String getUserSessionId() {
        return this.imUserSession.getIMUSERSESSIONID();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void AddMessageToQueue(IMMessageBase imMessageBase, boolean bImmediately) {
        if (!this.OnTestAddMessageToQueue(imMessageBase)) {
            return;
        }
        if (bImmediately) {
            Vector<IMMessageBase> vector = this.imMessageList2;
            synchronized (vector) {
                this.imMessageList2.add(imMessageBase);
            }
        }
        Vector<IMMessageBase> vector = this.imMessageList;
        synchronized (vector) {
            this.imMessageList.add(imMessageBase);
        }
        try {
            this.SendMessageToClient();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void SendMessageToClient() throws Exception {
        Object object = this.cometEventLock;
        synchronized (object) {
            block27: {
                Object imMessageBase;
                if (this.cometEvent == null) {
                    return;
                }
                Vector<Object> sendList = null;
                int nCount = 0;
                Vector<IMMessageBase> vector = this.imMessageList2;
                synchronized (vector) {
                    if (this.imMessageList2.size() > 0) {
                        if (sendList == null) {
                            sendList = new Vector<Object>();
                        }
                        while (this.imMessageList2.size() > 0 && nCount < 200) {
                            imMessageBase = this.imMessageList2.remove(0);
                            sendList.add(imMessageBase);
                            ++nCount;
                        }
                    }
                }
                Timestamp lastInformTime = null;
                imMessageBase = this.imMessageList;
                synchronized (imMessageBase) {
                    if (this.imMessageList.size() > 0) {
                        if (sendList == null) {
                            sendList = new Vector();
                        }
                        while (this.imMessageList.size() > 0 && nCount < 200) {
                            IMUserInformMessage imUserInformMessage;
                            IMMessageBase iMMessageBase = this.imMessageList.remove(0);
                            sendList.add(iMMessageBase);
                            ++nCount;
                            if (!(iMMessageBase instanceof IMUserInformMessage) || (imUserInformMessage = (IMUserInformMessage)iMMessageBase).getInformTime() == null || lastInformTime != null && imUserInformMessage.getInformTime().getTime() <= lastInformTime.getTime()) continue;
                            lastInformTime = imUserInformMessage.getInformTime();
                        }
                    }
                }
                if (sendList == null) {
                    return;
                }
                IMMessagePackage imMessagePackage = new IMMessagePackage();
                for (IMMessageBase iMMessageBase : sendList) {
                    imMessagePackage.AddMessage(iMMessageBase);
                }
                try {
                    String string = imMessagePackage.toJSONString();
                    this.cometEvent.getHttpServletResponse().getWriter().print(string);
                    this.cometEvent.getHttpServletResponse().getWriter().flush();
                    if (lastInformTime != null) {
                        this.OnUpdateIMUserInformTime(lastInformTime);
                        this.userLastInformTime = lastInformTime;
                    }
                    break block27;
                }
                catch (Exception exception) {
                    Vector<IMMessageBase> vector2 = this.imMessageList2;
                    synchronized (vector2) {
                        int i = 0;
                        while (i < sendList.size()) {
                            IMMessageBase imMessageBase3 = (IMMessageBase)sendList.get(i);
                            this.imMessageList2.add(i, imMessageBase3);
                            ++i;
                        }
                    }
                }
                log.error((Object)StringHelper.Format((String)"\u53d1\u751f\u6d88\u606f\u5230\u7528\u6237\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            }
            try {
                this.cometEvent.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            this.cometEvent = null;
        }
    }

    protected void OnUpdateIMUserInformTime(Timestamp lastInformTime) throws Exception {
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(this.getUserId());
        imUser.setLASTINFORMTIME(new Timestamp(lastInformTime.getTime() + 1000L));
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            IDEDataCtrl imUserDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0070", "SYSTEM", null);
            callResult = imUserDataCtrl.Save(false, (BaseDataEntity)imUser);
        } else {
            IMRemoteDEDataCtrl imUserDataCtrl = new IMRemoteDEDataCtrl();
            imUserDataCtrl.Init("", "IM0070", "SYSTEM");
            callResult = imUserDataCtrl.Save(false, imUser);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7528\u6237\u6700\u540e\u901a\u77e5\u65f6\u95f4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected boolean OnTestAddMessageToQueue(IMMessageBase imMessageBase) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void RegisterUserConnection(IIMCometEvent cometEvent) {
        Object object = this.cometEventLock;
        synchronized (object) {
            this.cometEvent = cometEvent;
            if (this.cometEvent != null) {
                Object object2 = this.activeDateLock;
                synchronized (object2) {
                    this.activeDate = new Date();
                }
            }
        }
        try {
            this.SendMessageToClient();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void UnregisterUserConnection() {
        Object object = this.cometEventLock;
        synchronized (object) {
            this.cometEvent = null;
        }
    }

    @Override
    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return this.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGIN", (boolean)true) == 0) {
            return this.OnUserSessionLogin(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERSESSIONLOGOUT", (boolean)true) == 0) {
            return this.OnUserSessionLogout(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERINFOSYNC", (boolean)true) == 0) {
            return new IMMessagePackage();
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERICONSYNC", (boolean)true) == 0) {
            return new IMMessagePackage();
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERFULLINFOSYNC", (boolean)true) == 0) {
            return new IMMessagePackage();
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERRESETRECENT", (boolean)true) == 0) {
            return new IMMessagePackage();
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPCREATE", (boolean)true) == 0) {
            return this.OnUserGroupCreate(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPRENAME", (boolean)true) == 0) {
            return this.OnUserGroupRename(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPREMOVE", (boolean)true) == 0) {
            return this.OnUserGroupRemove(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPRESET", (boolean)true) == 0) {
            return this.OnUserGroupReset(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILCREATE", (boolean)true) == 0) {
            return this.OnUserGroupDetailCreate(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILREMOVE", (boolean)true) == 0) {
            return this.OnUserGroupDetailRemove(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPREORDER", (boolean)true) == 0) {
            return this.OnUserGroupReorder(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERGROUPDETAILREORDER", (boolean)true) == 0) {
            return this.OnUserGroupDetailReorder(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPCREATE", (boolean)true) == 0) {
            return this.OnDisGroupCreate(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPRENAME", (boolean)true) == 0) {
            return this.OnDisGroupRename(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPREMOVE", (boolean)true) == 0) {
            return this.OnDisGroupRemove(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILCREATE", (boolean)true) == 0) {
            return this.OnDisGroupDetailCreate(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILREMOVE", (boolean)true) == 0) {
            return this.OnDisGroupDetailRemove(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPREORDER", (boolean)true) == 0) {
            return this.OnDisGroupReorder(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"DISGROUPDETAILREORDER", (boolean)true) == 0) {
            return this.OnDisGroupDetailReorder(iIMRemoteActionContext);
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERRESETRECENT", (boolean)true) == 0) {
            return new IMMessagePackage();
        }
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"USERDISGROUPLIST", (boolean)true) == 0) {
            return this.OnUserDisGroupList(iIMRemoteActionContext);
        }
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8fdc\u7a0b\u8bf7\u6c42[%1$s]", (Object)iIMRemoteActionContext.getAction()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected IMMessagePackage OnUserSessionLogin(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMUserGroup imUserGroup2;
        JSONObject joUserGroup;
        IMRemoteDEDataCtrl imUserDataCtrl;
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(this.getUserId());
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0070", "SYSTEM", null);
            callResult = imUserDataCtrl.Get(imUser);
        } else {
            imUserDataCtrl = new IMRemoteDEDataCtrl();
            imUserDataCtrl.Init("", "IM0070", "SYSTEM");
            callResult = imUserDataCtrl.Get(imUser);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7528\u6237\u4fe1\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IMUser imUser2 = new IMUser();
        imUser.CopyTo(imUser2, "NICKNAME|IMUSERID|PHONE|OFFICEPHONE|SEX|SHORTPHONE|SHORTPHONE2|EMAIL|DUTY|DUTYLEVEL|WORKPLACE|HOLIDAYSTATE|BIRTHDAY|USERDATA|USERDATA2|USERDATA3|USERDATA4|USERDATA5|USERDATA6|USERDATA7|USERDATA8|USERDATA9|USERDATA10", false);
        imMessagePackage.setExtInfo("FULLUSERINFO", imUser2.ToJSONString());
        imMessagePackage.setExtInfo("ONLINESTATE", this.imUserSession.GetParamStringValue("ONLINESTATE", ""));
        imMessagePackage.setExtInfo("ONLINESTATEINFO", this.imUserSession.GetParamStringValue("ONLINESTATEINFO", ""));
        imMessagePackage.setExtInfo("USERINFO", this.imUserSession.GetParamStringValue("USERINFO", ""));
        imMessagePackage.setExtInfo("IMUSERNAME", this.imUserSession.GetParamStringValue("IMUSERNAME", ""));
        imMessagePackage.setExtInfo("ICONPATH", this.imUserSession.GetParamStringValue("ICONPATH", ""));
        Vector<IMDisGroup> imDisGroups = new Vector<IMDisGroup>();
        callResult = this.getIMModelHelper().GetIMUserDisGroups(this.getUserId(), imDisGroups);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<JSONObject> disGroups = new Vector<JSONObject>();
        for (IMDisGroup imDisGroup : imDisGroups) {
            joUserGroup = new JSONObject();
            joUserGroup.put("id", (Object)imDisGroup.getIMDISGROUPID());
            joUserGroup.put("name", (Object)imDisGroup.getIMDISGROUPNAME());
            joUserGroup.put("memo", (Object)imDisGroup.getMEMO());
            joUserGroup.put("orderflag", imDisGroup.getORDERFLAG());
            joUserGroup.put("ownerid", (Object)imDisGroup.getIMUSERID());
            String strDisGroupType = imDisGroup.getDISGROUPTYPE();
            if (StringHelper.IsNullOrEmpty((String)strDisGroupType)) {
                strDisGroupType = "PUBLIC";
            }
            joUserGroup.put("type", (Object)strDisGroupType);
            disGroups.add(joUserGroup);
        }
        String strDisGroupJson = JSONArray.fromArray((Object[])disGroups.toArray()).toString();
        imMessagePackage.setExtInfo("DISGROUPS", strDisGroupJson);
        Vector<IMMeeting> imMeetings = new Vector<IMMeeting>();
        callResult = this.getIMModelHelper().GetLastIMMeetings(this.getUserId(), imMeetings);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6700\u540e\u4f1a\u8bae\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<JSONObject> lastMeetings = new Vector<JSONObject>();
        for (IMMeeting imMeeting : imMeetings) {
            joUserGroup = new JSONObject();
            joUserGroup.put("id", (Object)imMeeting.getIMMEETINGID());
            if (imMeeting.getMEETINGTYPE() == 2) {
                joUserGroup.put("name", (Object)imMeeting.getIMMEETINGNAME());
            } else {
                Vector<IMParticipant> imParticipants = new Vector<IMParticipant>();
                callResult = this.getIMModelHelper().GetIMParticipants(imMeeting.getIMMEETINGID(), imParticipants);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u53c2\u4e0e\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Iterator<IMUserGroup> strName = "";
                Iterator<IMParticipant> iterator = imParticipants.iterator();
                while (iterator.hasNext()) {
                    IMParticipant imParticipant = iterator.next();
                    if (StringHelper.Compare((String)imParticipant.getIMUSERID(), (String)this.getUserId(), (boolean)false) == 0) continue;
                    if (!StringHelper.IsNullOrEmpty((String)((Object)strName))) {
                        strName = String.valueOf(strName) + ",";
                    }
                    strName = String.valueOf(strName) + imParticipant.getIMUSERNAME();
                }
                if (StringHelper.IsNullOrEmpty((String)((Object)strName))) continue;
                joUserGroup.put("name", (Object)strName);
            }
            joUserGroup.put("type", imMeeting.getMEETINGTYPE());
            joUserGroup.put("lastmessage", (Object)imMeeting.getLASTMESSAGE());
            lastMeetings.add(joUserGroup);
        }
        strDisGroupJson = JSONArray.fromArray((Object[])lastMeetings.toArray()).toString();
        imMessagePackage.setExtInfo("MEETINGS", strDisGroupJson);
        Vector<IMUserGroup> imUserGroups = new Vector<IMUserGroup>();
        callResult = this.getIMModelHelper().GetIMUserGroups(this.getUserId(), imUserGroups);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<IMUGDetail> imUGDetails = new Vector<IMUGDetail>();
        callResult = this.getIMModelHelper().GetIMUserGroupDetails(this.getUserId(), imUGDetails);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Hashtable<String, IMUserGroup> systemGroup = new Hashtable<String, IMUserGroup>();
        Vector<JSONObject> userGroups = new Vector<JSONObject>();
        for (IMUserGroup imUserGroup2 : imUserGroups) {
            if (StringHelper.IsNullOrEmpty((String)imUserGroup2.getUGTYPE())) continue;
            systemGroup.put(imUserGroup2.getUGTYPE(), imUserGroup2);
        }
        if (!systemGroup.containsKey("FAVOUR")) {
            IMRemoteDEDataCtrl imUserGroupDataCtrl;
            imUserGroup2 = new IMUserGroup();
            imUserGroup2.setIMUSERID(this.getUserId());
            imUserGroup2.setIMUSERGROUPID(StringHelper.Format((String)"UG_%1$s_%2$s", (Object)this.getUserId(), (Object)"FAVOUR"));
            imUserGroup2.setIMUSERGROUPNAME("\u5e38\u7528\u8054\u7cfb\u4eba");
            imUserGroup2.setUGTYPE("FAVOUR");
            if (this.imStateServerContext.isLocalMode()) {
                imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
                callResult = imUserGroupDataCtrl.Save(true, imUserGroup2);
            } else {
                imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
                imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
                callResult = imUserGroupDataCtrl.Save(true, imUserGroup2);
            }
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u5e38\u7528\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            systemGroup.put("FAVOUR", imUserGroup2);
            imUserGroups.add(0, imUserGroup2);
        } else {
            imUserGroup2 = (IMUserGroup)((Object)systemGroup.get("FAVOUR"));
            imUserGroups.remove((Object)imUserGroup2);
            imUserGroups.add(0, imUserGroup2);
        }
        Hashtable imUserGroupDetailMap = new Hashtable();
        for (IMUGDetail imUserGroupDetail : imUGDetails) {
            Vector<JSONObject> imUserGroupDetails = (Vector<JSONObject>)imUserGroupDetailMap.get(imUserGroupDetail.getIMUSERGROUPID());
            if (imUserGroupDetails == null) {
                imUserGroupDetails = new Vector<JSONObject>();
                imUserGroupDetailMap.put(imUserGroupDetail.getIMUSERGROUPID(), imUserGroupDetails);
            }
            JSONObject joUserGroupDetail = new JSONObject();
            joUserGroupDetail.put("id", (Object)imUserGroupDetail.getIMUSERID());
            joUserGroupDetail.put("name", (Object)imUserGroupDetail.getIMUSERNAME());
            joUserGroupDetail.put("level", imUserGroupDetail.getUSERLEVEL());
            imUserGroupDetails.add(joUserGroupDetail);
        }
        for (IMUserGroup imUserGroup3 : imUserGroups) {
            Vector userGroupDetails;
            JSONObject joUserGroup2 = new JSONObject();
            joUserGroup2.put("id", (Object)imUserGroup3.getIMUSERGROUPID());
            joUserGroup2.put("name", (Object)imUserGroup3.getIMUSERGROUPNAME());
            joUserGroup2.put("type", (Object)imUserGroup3.getUGTYPE());
            if (StringHelper.Compare((String)imUserGroup3.getUGTYPE(), (String)"FAVOURDEPT", (boolean)true) == 0) {
                joUserGroup2.put("orgid", (Object)imUserGroup3.getIMORGID());
                joUserGroup2.put("orgname", (Object)imUserGroup3.getIMORGID());
            }
            if ((userGroupDetails = (Vector)imUserGroupDetailMap.get(imUserGroup3.getIMUSERGROUPID())) != null) {
                joUserGroup2.put("details", (Object)userGroupDetails.toArray());
            }
            userGroups.add(joUserGroup2);
        }
        String strUserGroupJson = JSONArray.fromArray((Object[])userGroups.toArray()).toString();
        imMessagePackage.setExtInfo("USERGROUPS", strUserGroupJson);
        Vector<IMUser> imUsers = new Vector<IMUser>();
        this.imStateServerContext.ListUsers(imUsers);
        int nLoopCount = 0;
        for (IMUser imUser3 : imUsers) {
            if (StringHelper.Compare((String)imUser3.getIMUSERID(), (String)this.getUserId(), (boolean)true) == 0) continue;
            IMInformMessage imInformMessage = new IMInformMessage();
            IMUser iMUser = imUser3;
            synchronized (iMUser) {
                if (!imUser3.getONLINEFLAG()) {
                    continue;
                }
                imInformMessage.setMessageType(1000);
                imInformMessage.setUserId(imUser3.getIMUSERID());
                imInformMessage.setOnlineState(imUser3.getONLINESTATE());
                imInformMessage.setOnlineStateInfo(imUser3.getONLINESTATEINFO());
                imInformMessage.setUserInfo(imUser3.getUSERINFO());
                imInformMessage.setNickName(imUser3.getNICKNAME());
                imInformMessage.setUserIcon(imUser3.getICONPATH());
                imInformMessage.setIMDomain(imUser3.getIMDOMAIN());
                String strUserFullInfo = imUser3.GetParamStringValue("USERFULLINFO", "");
                imInformMessage.setParam(strUserFullInfo);
            }
            if (nLoopCount <= 500) {
                imMessagePackage.AddMessage(imInformMessage);
                ++nLoopCount;
                continue;
            }
            this.AddMessageToQueue(imInformMessage, false);
        }
        Timestamp lastInformTime = this.userLastInformTime;
        Vector<IMUserInform> imUserInforms = new Vector<IMUserInform>();
        callResult = this.getIMModelHelper().GetOfflineIMUserInforms(this.getUserId(), lastInformTime, imUserInforms);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u79bb\u7ebf\u901a\u77e5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (IMUserInform imUserInform : imUserInforms) {
            String strSender = imUserInform.getSENDER();
            String strReceiverType = imUserInform.getRECEIVERTYPE();
            String strReceiver = imUserInform.getRECEIVER();
            IMUserInformMessage imUserInformMessage = new IMUserInformMessage();
            imUserInformMessage.setSender(strSender);
            imUserInformMessage.setMessageType(imUserInform.getINFORMTYPE());
            imUserInformMessage.setSubject(imUserInform.getIMUSERINFORMNAME());
            imUserInformMessage.setContent(imUserInform.getCONTENT());
            imUserInformMessage.setRichContent(imUserInform.getRICHCONTENT());
            imUserInformMessage.setUrl(imUserInform.getURL());
            imUserInformMessage.setInformTime(imUserInform.getINFORMTIME());
            this.AddMessageToQueue(imUserInformMessage, false);
        }
        Vector<IMMeeting> imMeetings2 = new Vector<IMMeeting>();
        callResult = this.getIMModelHelper().GetOfflineIMMeetings(this.getUserId(), imMeetings2);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u79bb\u7ebf\u6d88\u606f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (IMMeeting imMeeting : imMeetings2) {
            try {
                IMRemoteAction imRemoteAction = new IMRemoteAction();
                imRemoteAction.setAction("MEETINGREOPEN");
                imRemoteAction.setParam("MEETINGID", imMeeting.getIMMEETINGID());
                IMMessagePackage imMessagePackageServer = this.imStateServerContext.SendRemoteAction(imRemoteAction);
                if (imMessagePackageServer.getRetCode() == 0) {
                    String strMeetingId = imMessagePackageServer.getExtInfo("MEETINGID", "");
                    String strServerPath = imMessagePackageServer.getExtInfo("SERVERPATH", "");
                    String strServerCometPath = imMessagePackageServer.getExtInfo("SERVERCOMETPATH", "");
                    IMInformMessage imInformMessage = new IMInformMessage();
                    imInformMessage.setMessageType(1100);
                    imInformMessage.setMsgTargetType(2);
                    imInformMessage.setMsgTarget(this.getUserId());
                    imInformMessage.setMeetingId(strMeetingId);
                    imInformMessage.setParam(strServerPath);
                    imInformMessage.setParam2(strServerCometPath);
                    imMessagePackage.AddMessage(imInformMessage);
                    continue;
                }
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u91cd\u65b0\u5f00\u542f\u4f1a\u8bae\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)imMessagePackageServer.getRetInfo()));
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u91cd\u65b0\u5f00\u542f\u4f1a\u8bae\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserDisGroupList(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        Vector<IMDisGroup> imDisGroups = new Vector<IMDisGroup>();
        CallResult callResult = this.getIMModelHelper().GetIMUserDisGroups(this.getUserId(), imDisGroups);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector<JSONObject> disGroups = new Vector<JSONObject>();
        for (IMDisGroup imDisGroup : imDisGroups) {
            JSONObject joUserGroup = new JSONObject();
            joUserGroup.put("id", (Object)imDisGroup.getIMDISGROUPID());
            joUserGroup.put("name", (Object)imDisGroup.getIMDISGROUPNAME());
            joUserGroup.put("memo", (Object)imDisGroup.getMEMO());
            joUserGroup.put("orderflag", imDisGroup.getORDERFLAG());
            joUserGroup.put("ownerid", (Object)imDisGroup.getIMUSERID());
            String strDisGroupType = imDisGroup.getDISGROUPTYPE();
            if (StringHelper.IsNullOrEmpty((String)strDisGroupType)) {
                strDisGroupType = "PUBLIC";
            }
            joUserGroup.put("type", (Object)strDisGroupType);
            disGroups.add(joUserGroup);
        }
        String strDisGroupJson = JSONArray.fromArray((Object[])disGroups.toArray()).toString();
        imMessagePackage.setExtInfo("DISGROUPS", strDisGroupJson);
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserSessionLogout(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnUserGroupCreate(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDataCtrl;
        String strOrgId;
        String strUserGroupName = iIMRemoteActionContext.getParam("USERGROUPNAME", "");
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERID(this.getUserId());
        imUserGroup.setIMUSERGROUPNAME(strUserGroupName);
        String strUserGroupType = iIMRemoteActionContext.getParam("USERGROUPTYPE", "");
        if (!StringHelper.IsNullOrEmpty((String)strUserGroupType)) {
            imUserGroup.setUGTYPE(strUserGroupType);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strOrgId = iIMRemoteActionContext.getParam("ORGID", "")))) {
            imUserGroup.setIMORGID(strOrgId);
        }
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Save(true, imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Save(true, imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        JSONObject joUserGroup = new JSONObject();
        joUserGroup.put("id", (Object)imUserGroup.getIMUSERGROUPID());
        joUserGroup.put("name", (Object)imUserGroup.getIMUSERGROUPNAME());
        joUserGroup.put("type", (Object)imUserGroup.getUGTYPE());
        joUserGroup.put("orgid", (Object)imUserGroup.getIMORGID());
        joUserGroup.put("orgname", (Object)imUserGroup.getIMORGNAME());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("USERGROUP", joUserGroup.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupRename(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDataCtrl;
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        String strUserGroupName = iIMRemoteActionContext.getParam("USERGROUPNAME", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u540d\u79f0");
        }
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imUserGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6240\u6709\u8005"));
        }
        imUserGroup.Reset();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        imUserGroup.setIMUSERGROUPNAME(strUserGroupName);
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Save(false, imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Save(false, imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u8054\u7cfb\u4eba\u7ec4\u540d\u79f0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        JSONObject joUserGroup = new JSONObject();
        joUserGroup.put("id", (Object)imUserGroup.getIMUSERGROUPID());
        joUserGroup.put("name", (Object)imUserGroup.getIMUSERGROUPNAME());
        joUserGroup.put("type", (Object)imUserGroup.getUGTYPE());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("USERGROUP", joUserGroup.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupReset(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDetailDataCtrl;
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        Vector<IMUGDetail> imUGDetails = new Vector<IMUGDetail>();
        CallResult callResult = this.getIMModelHelper().GetIMUserGroupDetails2(strUserGroupId, imUGDetails);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
            for (IMUGDetail imUGDetail : imUGDetails) {
                callResult = imUserGroupDetailDataCtrl.Remove(imUGDetail);
                if (!callResult.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u7528\u6237\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        } else {
            imUserGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDetailDataCtrl.Init("", "IM0096", "SYSTEM");
            for (IMUGDetail imUGDetail : imUGDetails) {
                callResult = imUserGroupDetailDataCtrl.Remove(imUGDetail);
                if (!callResult.IsError()) continue;
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u7528\u6237\u7ec4\u6210\u5458\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupRemove(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDataCtrl;
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imUserGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6240\u6709\u8005"));
        }
        if (StringHelper.Compare((String)imUserGroup.getUGTYPE(), (String)"FAVOUR", (boolean)true) == 0) {
            throw new Exception(StringHelper.Format((String)"\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u4e3a\u7cfb\u7edf\u4fdd\u7559\uff0c\u4e0d\u80fd\u5220\u9664"));
        }
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Remove(imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Remove(imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u79fb\u9664\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupReorder(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserGroupOrderInfo = iIMRemoteActionContext.getContent();
        String[] userGroups = strUserGroupOrderInfo.split("[;]");
        IDEDataCtrl imUserGroupDataCtrl = null;
        IMRemoteDEDataCtrl imUserGroupRemoteDataCtrl = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
        } else {
            imUserGroupRemoteDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupRemoteDataCtrl.Init("", "IM0095", "SYSTEM");
        }
        int nOrderFlag = 100;
        String[] stringArray = userGroups;
        int n = userGroups.length;
        int n2 = 0;
        while (n2 < n) {
            String strUserGroupId = stringArray[n2];
            IMUserGroup imUserGroup = new IMUserGroup();
            imUserGroup.setIMUSERGROUPID(strUserGroupId);
            imUserGroup.setORDERFLAG(nOrderFlag);
            CallResult callResult = null;
            callResult = this.imStateServerContext.isLocalMode() ? imUserGroupDataCtrl.Save(false, (BaseDataEntity)imUserGroup) : imUserGroupRemoteDataCtrl.Save(false, imUserGroup);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ++nOrderFlag;
            ++n2;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupDetailReorder(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        IDEDataCtrl imUserGroupDetailDataCtrl = null;
        IMRemoteDEDataCtrl imUserGroupDetailRemoteDataCtrl = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
        } else {
            imUserGroupDetailRemoteDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDetailRemoteDataCtrl.Init("", "IM0096", "SYSTEM");
        }
        String strUserOrderInfo = iIMRemoteActionContext.getContent();
        String[] users = strUserOrderInfo.split("[;]");
        int nOrderFlag = 100;
        String[] stringArray = users;
        int n = users.length;
        int n2 = 0;
        while (n2 < n) {
            String strUserId = stringArray[n2];
            IMUGDetail imUGDetail = new IMUGDetail();
            String strUGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strUserGroupId, (Object)strUserId);
            imUGDetail.setIMUGDETAILID(strUGDetailId);
            imUGDetail.setORDERFLAG(nOrderFlag);
            CallResult callResult = null;
            callResult = this.imStateServerContext.isLocalMode() ? imUserGroupDetailDataCtrl.Save(false, (BaseDataEntity)imUGDetail) : imUserGroupDetailRemoteDataCtrl.Save(false, imUGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8054\u7cfb\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ++nOrderFlag;
            ++n2;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupDetailCreate(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDetailDataCtrl;
        IMRemoteDEDataCtrl imUserGroupDataCtrl;
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        String strUserId = iIMRemoteActionContext.getParam("UGDETAILUSERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u6807\u8bc6");
        }
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imUserGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6240\u6709\u8005"));
        }
        IMUGDetail imUGDetail = new IMUGDetail();
        String strUGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strUserGroupId, (Object)strUserId);
        imUGDetail.setIMUGDETAILID(strUGDetailId);
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
            if (imUserGroupDetailDataCtrl.CheckKeyState2(imUGDetail) == 0) {
                imUGDetail.setIMUSERGROUPID(strUserGroupId);
                imUGDetail.setIMUSERID(strUserId);
                callResult = imUserGroupDetailDataCtrl.Save(true, imUGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8054\u7cfb\u4eba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            } else {
                callResult = imUserGroupDetailDataCtrl.Get(imUGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8054\u7cfb\u4eba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        } else {
            imUserGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDetailDataCtrl.Init("", "IM0096", "SYSTEM");
            imUGDetail.setIMUSERGROUPID(strUserGroupId);
            imUGDetail.setIMUSERID(strUserId);
            callResult = imUserGroupDetailDataCtrl.Save(true, imUGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8054\u7cfb\u4eba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        JSONObject joUserGroupDetail = new JSONObject();
        joUserGroupDetail.put("id", (Object)imUGDetail.getIMUSERID());
        joUserGroupDetail.put("name", (Object)imUGDetail.getIMUSERNAME());
        joUserGroupDetail.put("level", imUGDetail.getUSERLEVEL());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("USERGROUPDETAIL", joUserGroupDetail.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnUserGroupDetailRemove(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imUserGroupDetailDataCtrl;
        IMRemoteDEDataCtrl imUserGroupDataCtrl;
        String strUserGroupId = iIMRemoteActionContext.getParam("USERGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6807\u8bc6");
        }
        String strUserId = iIMRemoteActionContext.getParam("UGDETAILUSERID", "");
        if (StringHelper.IsNullOrEmpty((String)strUserGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u6807\u8bc6");
        }
        IMUserGroup imUserGroup = new IMUserGroup();
        imUserGroup.setIMUSERGROUPID(strUserGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0095", "SYSTEM", null);
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        } else {
            imUserGroupDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDataCtrl.Init("", "IM0095", "SYSTEM");
            callResult = imUserGroupDataCtrl.Get(imUserGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8054\u7cfb\u4eba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imUserGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8054\u7cfb\u4eba\u7ec4\u6240\u6709\u8005"));
        }
        IMUGDetail imUGDetail = new IMUGDetail();
        String strUGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strUserGroupId, (Object)strUserId);
        imUGDetail.setIMUGDETAILID(strUGDetailId);
        if (this.imStateServerContext.isLocalMode()) {
            imUserGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
            if (imUserGroupDetailDataCtrl.CheckKeyState2(imUGDetail) == 1) {
                imUGDetail.setIMUSERGROUPID(strUserGroupId);
                imUGDetail.setIMUSERID(strUserId);
                callResult = imUserGroupDetailDataCtrl.Remove(imUGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8054\u7cfb\u4eba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        } else {
            imUserGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imUserGroupDetailDataCtrl.Init("", "IM0096", "SYSTEM");
            imUGDetail.setIMUSERGROUPID(strUserGroupId);
            imUGDetail.setIMUSERID(strUserId);
            callResult = imUserGroupDetailDataCtrl.Remove(imUGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8054\u7cfb\u4eba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupCreate(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imDisGroupDetailDataCtrl;
        IMRemoteDEDataCtrl imDisGroupDataCtrl;
        String strDisGroupName = iIMRemoteActionContext.getParam("DISGROUPNAME", "");
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.setIMUSERID(this.getUserId());
        imDisGroup.setIMDISGROUPNAME(strDisGroupName);
        imDisGroup.setDISGROUPTYPE("PRIVATE");
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Save(true, imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Save(true, imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
        imDisGroupDetail.setIMUSERID(this.getUserId());
        imDisGroupDetail.setIMDISGROUPID(imDisGroup.getIMDISGROUPID());
        imDisGroupDetail.setADMINFLAG(true);
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0098", "SYSTEM", null);
            callResult = imDisGroupDetailDataCtrl.Save(true, imDisGroupDetail);
        } else {
            imDisGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailDataCtrl.Init("", "IM0098", "SYSTEM");
            callResult = imDisGroupDetailDataCtrl.Save(true, imDisGroupDetail);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        JSONObject joDisGroup = new JSONObject();
        joDisGroup.put("id", (Object)imDisGroup.getIMDISGROUPID());
        joDisGroup.put("name", (Object)imDisGroup.getIMDISGROUPNAME());
        joDisGroup.put("type", (Object)imDisGroup.getDISGROUPTYPE());
        joDisGroup.put("memo", (Object)imDisGroup.getMEMO());
        joDisGroup.put("orderflag", imDisGroup.getORDERFLAG());
        joDisGroup.put("ownerid", (Object)imDisGroup.getIMUSERID());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("DISGROUP", joDisGroup.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupRename(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imDisGroupDataCtrl;
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6807\u8bc6");
        }
        String strDisGroupName = iIMRemoteActionContext.getParam("DISGROUPNAME", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u540d\u79f0");
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.setIMDISGROUPID(strDisGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imDisGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6240\u6709\u8005"));
        }
        imDisGroup.Reset();
        imDisGroup.setIMDISGROUPID(strDisGroupId);
        imDisGroup.setIMDISGROUPNAME(strDisGroupName);
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Save(false, imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Save(false, imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u8ba8\u8bba\u7ec4\u540d\u79f0\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        JSONObject joDisGroup = new JSONObject();
        joDisGroup.put("id", (Object)imDisGroup.getIMDISGROUPID());
        joDisGroup.put("name", (Object)imDisGroup.getIMDISGROUPNAME());
        joDisGroup.put("type", (Object)imDisGroup.getDISGROUPTYPE());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("DISGROUP", joDisGroup.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupRemove(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imDisGroupDataCtrl;
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6807\u8bc6");
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.setIMDISGROUPID(strDisGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imDisGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6240\u6709\u8005"));
        }
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Remove(imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Remove(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u79fb\u9664\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupReorder(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strDisGroupOrderInfo = iIMRemoteActionContext.getContent();
        String[] userGroups = strDisGroupOrderInfo.split("[;]");
        IDEDataCtrl imDisGroupDataCtrl = null;
        IMRemoteDEDataCtrl imDisGroupRemoteDataCtrl = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
        } else {
            imDisGroupRemoteDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupRemoteDataCtrl.Init("", "IM0097", "SYSTEM");
        }
        int nOrderFlag = 100;
        String[] stringArray = userGroups;
        int n = userGroups.length;
        int n2 = 0;
        while (n2 < n) {
            String strDisGroupId = stringArray[n2];
            IMDisGroup imDisGroup = new IMDisGroup();
            imDisGroup.setIMDISGROUPID(strDisGroupId);
            imDisGroup.setORDERFLAG(nOrderFlag);
            CallResult callResult = null;
            callResult = this.imStateServerContext.isLocalMode() ? imDisGroupDataCtrl.Save(false, (BaseDataEntity)imDisGroup) : imDisGroupRemoteDataCtrl.Save(false, imDisGroup);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ++nOrderFlag;
            ++n2;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupDetailReorder(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6807\u8bc6");
        }
        IDEDataCtrl imDisGroupDetailDataCtrl = null;
        IMRemoteDEDataCtrl imDisGroupDetailRemoteDataCtrl = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
        } else {
            imDisGroupDetailRemoteDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailRemoteDataCtrl.Init("", "IM0096", "SYSTEM");
        }
        String strUserOrderInfo = iIMRemoteActionContext.getContent();
        String[] users = strUserOrderInfo.split("[;]");
        int nOrderFlag = 100;
        String[] stringArray = users;
        int n = users.length;
        int n2 = 0;
        while (n2 < n) {
            String strUserId = stringArray[n2];
            IMUGDetail imUGDetail = new IMUGDetail();
            String strUGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strDisGroupId, (Object)strUserId);
            imUGDetail.setIMUGDETAILID(strUGDetailId);
            imUGDetail.setORDERFLAG(nOrderFlag);
            CallResult callResult = null;
            callResult = this.imStateServerContext.isLocalMode() ? imDisGroupDetailDataCtrl.Save(false, (BaseDataEntity)imUGDetail) : imDisGroupDetailRemoteDataCtrl.Save(false, imUGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u8054\u7cfb\u4eba\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            ++nOrderFlag;
            ++n2;
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupDetailCreate(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imDisGroupDetailDataCtrl;
        IMRemoteDEDataCtrl imDisGroupDataCtrl;
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6807\u8bc6");
        }
        String strUserId = iIMRemoteActionContext.getParam("UGDETAILUSERID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u6807\u8bc6");
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.setIMDISGROUPID(strDisGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imDisGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6240\u6709\u8005"));
        }
        IMDisGroupDetail imDGDetail = new IMDisGroupDetail();
        String strDGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strDisGroupId, (Object)strUserId);
        imDGDetail.setIMDISGRPDETAILID(strDGDetailId);
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
            if (imDisGroupDetailDataCtrl.CheckKeyState2(imDGDetail) == 0) {
                imDGDetail.setIMDISGROUPID(strDisGroupId);
                imDGDetail.setIMUSERID(strUserId);
                callResult = imDisGroupDetailDataCtrl.Save(true, imDGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            } else {
                callResult = imDisGroupDetailDataCtrl.Get(imDGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        } else {
            imDisGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailDataCtrl.Init("", "IM0096", "SYSTEM");
            imDGDetail.setIMDISGROUPID(strDisGroupId);
            imDGDetail.setIMUSERID(strUserId);
            callResult = imDisGroupDetailDataCtrl.Save(true, imDGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u8ba8\u8bba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        JSONObject joDisGroupDetail = new JSONObject();
        joDisGroupDetail.put("id", (Object)imDGDetail.getIMUSERID());
        joDisGroupDetail.put("name", (Object)imDGDetail.getIMUSERNAME());
        joDisGroupDetail.put("level", imDGDetail.getORDERFLAG());
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        imMessagePackage.setExtInfo("DISGROUPDETAIL", joDisGroupDetail.toString());
        return imMessagePackage;
    }

    protected IMMessagePackage OnDisGroupDetailRemove(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        IMRemoteDEDataCtrl imDisGroupDetailDataCtrl;
        IMRemoteDEDataCtrl imDisGroupDataCtrl;
        String strDisGroupId = iIMRemoteActionContext.getParam("DISGROUPID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6807\u8bc6");
        }
        String strUserId = iIMRemoteActionContext.getParam("UGDETAILUSERID", "");
        if (StringHelper.IsNullOrEmpty((String)strDisGroupId)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8054\u7cfb\u4eba\u6807\u8bc6");
        }
        IMDisGroup imDisGroup = new IMDisGroup();
        imDisGroup.setIMDISGROUPID(strDisGroupId);
        CallResult callResult = null;
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0097", "SYSTEM", null);
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        } else {
            imDisGroupDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDataCtrl.Init("", "IM0097", "SYSTEM");
            callResult = imDisGroupDataCtrl.Get(imDisGroup);
        }
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8ba8\u8bba\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (StringHelper.Compare((String)imDisGroup.getIMUSERID(), (String)this.getUserId(), (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u4e0d\u662f\u6307\u5b9a\u8ba8\u8bba\u7ec4\u6240\u6709\u8005"));
        }
        IMDisGroupDetail imDGDetail = new IMDisGroupDetail();
        String strDGDetailId = StringHelper.Format((String)"%1$s_%2$s", (Object)strDisGroupId, (Object)strUserId);
        imDGDetail.setIMDISGRPDETAILID(strDGDetailId);
        if (this.imStateServerContext.isLocalMode()) {
            imDisGroupDetailDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrl("IM0096", "SYSTEM", null);
            if (imDisGroupDetailDataCtrl.CheckKeyState2(imDGDetail) == 1) {
                imDGDetail.setIMDISGROUPID(strDisGroupId);
                imDGDetail.setIMUSERID(strUserId);
                callResult = imDisGroupDetailDataCtrl.Remove(imDGDetail);
                if (callResult.IsError()) {
                    throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        } else {
            imDisGroupDetailDataCtrl = new IMRemoteDEDataCtrl();
            imDisGroupDetailDataCtrl.Init("", "IM0096", "SYSTEM");
            imDGDetail.setIMDISGROUPID(strDisGroupId);
            imDGDetail.setIMUSERID(strUserId);
            callResult = imDisGroupDetailDataCtrl.Remove(imDGDetail);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u5220\u9664\u8ba8\u8bba\u7ec4\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        IMMessagePackage imMessagePackage = new IMMessagePackage();
        return imMessagePackage;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void Close() {
        log.debug((Object)StringHelper.Format((String)"IM UserSession[%1$s] \u5173\u95ed", (Object)this.getUserSessionId()));
        try {
            Object object = this.cometEventLock;
            synchronized (object) {
                if (this.cometEvent != null) {
                    this.cometEvent.close();
                }
            }
        }
        catch (IOException e) {
            log.error((Object)e);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean isTimeout() {
        Date curDate = new Date();
        Object object = this.cometEventLock;
        synchronized (object) {
            if (this.cometEvent != null) {
                this.SendLiveMessage();
                return false;
            }
        }
        object = this.activeDateLock;
        synchronized (object) {
            if (this.activeDate == null) {
                this.SendLiveMessage();
                return false;
            }
            if (curDate.getTime() - this.activeDate.getTime() >= 300000L) {
                return true;
            }
            this.SendLiveMessage();
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void SendLiveMessage() {
        Date curDate = new Date();
        if (this.lastLiveDate == null || curDate.getTime() - this.lastLiveDate.getTime() >= 45000L) {
            this.lastLiveDate = curDate;
            IMInformMessage imInformMessage = new IMInformMessage();
            imInformMessage.setMessageType(1004);
            Vector<IMMessageBase> vector = this.imMessageList;
            synchronized (vector) {
                this.imMessageList.add(imInformMessage);
            }
        }
    }
}

