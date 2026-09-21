/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMAddrRange;
import SA.IM.Ctrl.Data.IMCatalogServer;
import SA.IM.Ctrl.Data.IMConfigType;
import SA.IM.Ctrl.Data.IMConfigValue;
import SA.IM.Ctrl.Data.IMDisGroup;
import SA.IM.Ctrl.Data.IMDisGroupDetail;
import SA.IM.Ctrl.Data.IMDomain;
import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMTServer;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMMessageLog;
import SA.IM.Ctrl.Data.IMOrgTree;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMServer;
import SA.IM.Ctrl.Data.IMStateServer;
import SA.IM.Ctrl.Data.IMUGDetail;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.Data.IMUserGroup;
import SA.IM.Ctrl.Data.IMUserInform;
import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.Data.IMVersion;
import SA.IM.Ctrl.IIMModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.sql.Timestamp;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMModelHelper
implements IIMModelHelper {
    private static final Log log = LogFactory.getLog(IMModelHelper.class);
    protected ISRFDAGlobalHelper iGlobalHelper = null;

    @Override
    public void Init(ISRFDAGlobalHelper iGlobalHelper) throws Exception {
        this.iGlobalHelper = iGlobalHelper;
    }

    @Override
    public CallResult GetIMServer(String strServerId, IMServer imServer) {
        return this.SelectSingle(this.GetSQL_GetIMServer(strServerId), imServer, "SYSTEM");
    }

    protected String GetSQL_GetIMServer(String strServerId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMSERVER t1 where t1.ENABLE=1 AND  t1.IMSERVERID='%1$s'", (Object)strServerId);
    }

    @Override
    public CallResult GetIMCatalogServer(String strServerId, IMCatalogServer imServer) {
        return this.SelectSingle(this.GetSQL_GetIMCatalogServer(strServerId), imServer, "SYSTEM");
    }

    protected String GetSQL_GetIMCatalogServer(String strServerId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMCATALOGSERVER t1 where t1.ENABLE=1 AND  t1.IMCATALOGSERVERID='%1$s'", (Object)strServerId);
    }

    @Override
    public CallResult GetIMStateServer(String strServerId, IMStateServer imServer) {
        return this.SelectSingle(this.GetSQL_GetIMStateServer(strServerId), imServer, "SYSTEM");
    }

    protected String GetSQL_GetIMStateServer(String strServerId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMSTATESERVER t1 where t1.ENABLE=1 AND  t1.IMSTATESERVERID='%1$s'", (Object)strServerId);
    }

    @Override
    public CallResult GetIMMTServer(String strServerId, IMMTServer imServer) {
        return this.SelectSingle(this.GetSQL_GetIMMTServer(strServerId), imServer, "SYSTEM");
    }

    protected String GetSQL_GetIMMTServer(String strServerId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMMTSERVER t1 where t1.ENABLE=1 AND  t1.IMMTSERVERID='%1$s'", (Object)strServerId);
    }

    @Override
    public CallResult GetIMMeeting(String strIMMeetingId, IMMeeting imMeeting) {
        return this.SelectSingle(this.GetSQL_GetIMMeeting(strIMMeetingId), imMeeting, "SYSTEM");
    }

    protected String GetSQL_GetIMMeeting(String strIMMeetingId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMMEETING t1 where t1.ENABLE=1 AND  t1.IMMEETINGID='%1$s'", (Object)strIMMeetingId);
    }

    @Override
    public CallResult GetIMParticipants(String strIMMeetingId, Vector<IMParticipant> imParticipants) {
        return this.SelectMulti(this.GetSQL_GetIMParticipants(strIMMeetingId), imParticipants, IMParticipant.class, "SYSTEM");
    }

    protected String GetSQL_GetIMParticipants(String strIMMeetingId) {
        return StringHelper.Format((String)"select t1.*,t3.PARTICIPANTOBJ from SRFV_IMPARTICIPANT t1 INNER JOIN SRFT_IMUSER_BASE t2 ON t1.IMUSERID=t2.IMUSERID LEFT JOIN  SRFT_IMUSERTYPE_BASE t3 ON t2.USERTYPE = t3.IMUSERTYPEID  where t1.IMMEETINGID = '%1$s'", (Object)strIMMeetingId);
    }

    @Override
    public CallResult GetIMParticipant(String strIMParticipantId, IMParticipant imParticipant) {
        return this.SelectSingle(this.GetSQL_GetIMParticipant(strIMParticipantId), imParticipant, "SYSTEM");
    }

    protected String GetSQL_GetIMParticipant(String strIMParticipantId) {
        return StringHelper.Format((String)"select t1.*,t3.PARTICIPANTOBJ from SRFV_IMPARTICIPANT t1 INNER JOIN SRFT_IMUSER_BASE t2 ON t1.IMUSERID=t2.IMUSERID LEFT JOIN  SRFT_IMUSERTYPE_BASE t3 ON t2.USERTYPE = t3.IMUSERTYPEID  where t1.IMPARTICIPANTID = '%1$s'", (Object)strIMParticipantId);
    }

    @Override
    public CallResult GetIMUserSession(String strIMUserSessionId, IMUserSession imUserSession) {
        return this.SelectSingle(this.GetSQL_GetIMUserSession(strIMUserSessionId), imUserSession, "SYSTEM");
    }

    protected String GetSQL_GetIMUserSession(String strIMUserSessionId) {
        return StringHelper.Format((String)"select t1.*,t3.SESSIONOBJ from SRFV_IMUSERSESSION t1 INNER JOIN SRFT_IMUSER_BASE t2 ON t1.IMUSERID=t2.IMUSERID LEFT JOIN  SRFT_IMUSERTYPE_BASE t3 ON t2.USERTYPE = t3.IMUSERTYPEID where t1.IMUSERSESSIONID='%1$s'", (Object)strIMUserSessionId);
    }

    @Override
    public CallResult GetIMUser(String strIMUserId, IMUser imUser) {
        return this.SelectSingle(this.GetSQL_GetIMUser(strIMUserId), imUser, "SYSTEM");
    }

    protected String GetSQL_GetIMUser(String strIMUserId) {
        return StringHelper.Format((String)"SELECT T1.USERLEVEL,T1.TALKLEVEL,T1.IMUSERID,T1.LASTINFORMTIME,T1.IMDOMAIN FROM SRFT_IMUSER_BASE t1 WHERE T1.IMUSERID='%1$s'", (Object)strIMUserId);
    }

    @Override
    public CallResult GetOnlineIMContacts(String strIMUserId, Vector<IMUser> imUsers) {
        return this.SelectMulti(this.GetSQL_GetOnlineIMContacts(strIMUserId), imUsers, IMUser.class, "SYSTEM");
    }

    protected String GetSQL_GetOnlineIMContacts(String strIMUserId) {
        return StringHelper.Format((String)"select IMUSERID,USERINFO,ONLINESTATE,NICKNAME,ICONPATH from SRFT_IMUSER_BASE t1 WHERE t1.ENABLE = 1 AND t1.ONLINEFLAG = 1  ", (Object)strIMUserId);
    }

    @Override
    public CallResult GetIMContacts(Vector<IMUser> imUsers) {
        return this.SelectMulti(this.GetSQL_GetIMContacts(), imUsers, IMUser.class, "SYSTEM");
    }

    protected String GetSQL_GetIMContacts() {
        return StringHelper.Format((String)"select t1.* from SRFT_IMUSER_BASE t1 WHERE t1.ENABLE = 1 ");
    }

    @Override
    public CallResult GetLastIMMeeting(String strIMUserIds, IMMeeting imMeeting) {
        return this.SelectSingle(this.GetSQL_GetLastIMMeeting(strIMUserIds), imMeeting, "SYSTEM");
    }

    protected String GetSQL_GetLastIMMeeting(String strIMUserIds) {
        String[] userIds = strIMUserIds.split("[;]");
        return StringHelper.Format((String)"select t1.* from srft_immeeting_base t1 where  NOT exists (   select * from SRFT_IMPARTICIPANT_BASE t2 WHERE t2.IMMEETINGID = t1.IMMEETINGID and t2.IMUSERID not in('%1$s','%2$s')  )  and t1.IMUSERIDS='%3$s' AND t1.ENABLE=1  order by t1.CREATEDATE DESC", (Object)userIds[0], (Object)userIds[1], (Object)strIMUserIds);
    }

    @Override
    public CallResult GetOfflineIMMeetings(String strIMUserId, Vector<IMMeeting> imMeetings) {
        return this.SelectMulti(this.GetSQL_GetOfflineIMMeetings(strIMUserId), imMeetings, IMMeeting.class, "SYSTEM");
    }

    protected String GetSQL_GetOfflineIMMeetings(String strIMUserId) {
        return StringHelper.Format((String)" select t3.IMMEETINGID from SRFT_IMUSERFILE_BASE t2  LEFT JOIN SRFT_IMFILE_BASE t3 on t2.IMFILEID = t3.IMFILEID  where  t2.IMUSERID='%1$s' and t2.SENDERFLAG=0 AND t2.RECVFLAG = 0  UNION  select t3.IMMEETINGID from SRFT_IMUSERMESSAGE_BASE t2  LEFT JOIN SRFT_IMMESSAGELOG_BASE t3 on t2.IMMESSAGELOGID = t3.IMMESSAGELOGID  where  t2.IMUSERID='%1$s' and t2.SENDERFLAG=0 AND t2.RECVFLAG = 0  ", (Object)strIMUserId);
    }

    @Override
    public CallResult GetUnsendIMMessageLogs(String strIMMeetingId, String strIMUserId, Vector<IMMessageLog> imMessageLogs) {
        return this.SelectMulti(this.GetSQL_GetUnsendIMMessageLogs(strIMMeetingId, strIMUserId), imMessageLogs, IMMessageLog.class, "SYSTEM");
    }

    protected String GetSQL_GetUnsendIMMessageLogs(String strIMMeetingId, String strIMUserId) {
        return StringHelper.Format((String)"select t1.* from srfv_IMMESSAGELOG t1\tINNER JOIN SRFT_IMUSERMESSAGE_BASE t2 on t2.IMMESSAGELOGID = t1.IMMESSAGELOGID\tWHERE t2.IMUSERID='%2$s' and t2.SENDERFLAG=0 and t2.RECVFLAG=0 and t1.IMMEETINGID='%1$s'\torder by t1.CREATEDATE", (Object)strIMMeetingId, (Object)strIMUserId);
    }

    @Override
    public CallResult GetOfflineIMUserInforms(String strIMUserId, Timestamp lastInformTime, Vector<IMUserInform> imUserInforms) {
        CallParamList callParamList = new CallParamList();
        if (lastInformTime != null) {
            callParamList.AddDateTime((Object)lastInformTime);
            callParamList.Add((Object)strIMUserId);
            return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iGlobalHelper, null, (String)"", (String)this.GetSQL_GetOfflineIMUserInforms(), (Vector)callParamList.GetList(), imUserInforms, (String)IMUserInform.class.getName());
        }
        callParamList.Add((Object)strIMUserId);
        return BaseDEDataCtrl.SelectMultiEx((ISRFDAGlobalHelper)this.iGlobalHelper, null, (String)"", (String)this.GetSQL_GetOfflineIMUserInforms2(), (Vector)callParamList.GetList(), imUserInforms, (String)IMUserInform.class.getName());
    }

    protected String GetSQL_GetOfflineIMUserInforms() {
        return "select t1.* from srft_imuserinform_base t1 where  t1.CANCELFLAG = 0 AND t1.EXPIREDTIME is not null and t1.EXPIREDTIME>=FU_SRFCURTIME() and t1.INFORMTIME>=? AND ((t1.RECEIVERTYPE='ALL')  OR (t1.RECEIVERTYPE='USER' AND t1.RECEIVER=?))";
    }

    protected String GetSQL_GetOfflineIMUserInforms2() {
        return "select t1.* from srft_imuserinform_base t1 where t1.CANCELFLAG = 0 AND  t1.EXPIREDTIME is not null and t1.EXPIREDTIME>=FU_SRFCURTIME() AND ((t1.RECEIVERTYPE='ALL')  OR (t1.RECEIVERTYPE='USER' AND t1.RECEIVER=?))";
    }

    @Override
    public CallResult GetUnsendIMFiles(String strIMMeetingId, String strIMUserId, Vector<IMFile> imFiles) {
        return this.SelectMulti(this.GetSQL_GetUnsendIMFiles(strIMMeetingId, strIMUserId), imFiles, IMFile.class, "SYSTEM");
    }

    protected String GetSQL_GetUnsendIMFiles(String strIMMeetingId, String strIMUserId) {
        return StringHelper.Format((String)"select t1.* from srfv_IMFILE t1\tINNER JOIN SRFT_IMUSERFILE_BASE t2 on t2.IMFILEID = t1.IMFILEID\tWHERE t2.IMUSERID='%2$s' and t2.SENDERFLAG=0 and t2.RECVFLAG=0 and t1.IMMEETINGID='%1$s'\torder by t1.CREATEDATE", (Object)strIMMeetingId, (Object)strIMUserId);
    }

    @Override
    public CallResult GetIMUserGroups(String strIMUserId, Vector<IMUserGroup> imUserGroups) {
        return this.SelectMulti(this.GetSQL_GetIMUserGroups(strIMUserId), imUserGroups, IMUserGroup.class, "SYSTEM");
    }

    protected String GetSQL_GetIMUserGroups(String strIMUserId) {
        int nVersion = this.iGlobalHelper.getDAModelHelper().GetDEModelVersion("IM0095");
        switch (nVersion) {
            case 10: {
                return StringHelper.Format((String)"select t1.* from SRFT_IMUSERGROUP_BASE t1 where t1.IMUSERID = '%1$s' ORDER BY t1.ORDERFLAG ", (Object)strIMUserId);
            }
        }
        return StringHelper.Format((String)"select t1.* from SRFT_IMUSERGROUP_BASE t1 where t1.IMUSERID = '%1$s'", (Object)strIMUserId);
    }

    @Override
    public CallResult GetIMUserGroupDetails(String strIMUserId, Vector<IMUGDetail> imUGDetails) {
        return this.SelectMulti(this.GetSQL_GetIMUserGroupDetails(strIMUserId), imUGDetails, IMUGDetail.class, "SYSTEM");
    }

    protected String GetSQL_GetIMUserGroupDetails(String strIMUserId) {
        int nVersion = this.iGlobalHelper.getDAModelHelper().GetDEModelVersion("IM0096");
        switch (nVersion) {
            case 10: {
                return StringHelper.Format((String)"select t1.IMUSERID,t2.IMUSERNAME,t2.USERLEVEL,t1.IMUSERGROUPID,t1.ORDERFLAG from srft_IMUGDETAIL_BASE t1 INNER JOIN SRFT_IMUSER_BASE t2 ON t1.IMUSERID = t2.IMUSERID INNER JOIN SRFT_IMUSERGROUP_BASE t3 ON t1.IMUSERGROUPID = t3.IMUSERGROUPID WHERE t3.IMUSERID = '%1$s'  ORDER BY t1.ORDERFLAG ", (Object)strIMUserId);
            }
        }
        return StringHelper.Format((String)"select t1.IMUSERID,t2.IMUSERNAME,t2.USERLEVEL,t1.IMUSERGROUPID from srft_IMUGDETAIL_BASE t1 INNER JOIN SRFT_IMUSER_BASE t2 ON t1.IMUSERID = t2.IMUSERID INNER JOIN SRFT_IMUSERGROUP_BASE t3 ON t1.IMUSERGROUPID = t3.IMUSERGROUPID WHERE t3.IMUSERID = '%1$s' ", (Object)strIMUserId);
    }

    @Override
    public CallResult GetIMUserGroupDetails2(String strIMUserGroupId, Vector<IMUGDetail> imUGDetails) {
        return this.SelectMulti(this.GetSQL_GetIMUserGroupDetails2(strIMUserGroupId), imUGDetails, IMUGDetail.class, "SYSTEM");
    }

    protected String GetSQL_GetIMUserGroupDetails2(String strIMUserGroupId) {
        return StringHelper.Format((String)"select t1.* from srft_IMUGDETAIL_BASE t1 WHERE t1.IMUSERGROUPID = '%1$s' ", (Object)strIMUserGroupId);
    }

    @Override
    public CallResult GetValidIMVersions(Vector<IMVersion> imVersions) {
        return this.SelectMulti(this.GetSQL_GetValidIMVersions(), imVersions, IMVersion.class, "SYSTEM");
    }

    protected String GetSQL_GetValidIMVersions() {
        return StringHelper.Format((String)"select t1.* from srft_imversion_base t1 where supportflag=1 order by internalver desc");
    }

    @Override
    public CallResult GetIMOrgTrees(Vector<IMOrgTree> imOrgTrees) {
        return this.SelectMulti(this.GetSQL_GetIMOrgTrees(), imOrgTrees, IMOrgTree.class, "SYSTEM");
    }

    protected String GetSQL_GetIMOrgTrees() {
        return StringHelper.Format((String)"SELECT t1.*,t2.VERSION as orgversion FROM SRFT_IMORGTREE_BASE t1 inner join SRFT_IMORG_BASE  t2 on t1.IMORGTREEID = t2.IMORGID where t2.PIMORGID is null ");
    }

    @Override
    public CallResult ResetIMUserOnlineState() {
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iGlobalHelper, (String)this.GetSQL_ResetIMUserOnlineState(), null);
    }

    protected String GetSQL_ResetIMUserOnlineState() {
        int nVersion = this.iGlobalHelper.getDAModelHelper().GetDEModelVersion("IM0070");
        if (nVersion >= 3) {
            return StringHelper.Format((String)"update SRFT_IMUSER_BASE t1 set ONLINEFLAG=0, IMUSERSESSIONID=NULL where exists  ( select * from SRFT_IMUSERSESSION_BASE t2 where t1.IMUSERSESSIONID = t2.IMUSERSESSIONID AND t2.LOGOUTTIME IS NULL ) and t1.ALWAYSONLINE <>1 AND  t1.ONLINEFLAG=1");
        }
        return StringHelper.Format((String)"update SRFT_IMUSER_BASE t1 set ONLINEFLAG=0, IMUSERSESSIONID=NULL where exists  ( select * from SRFT_IMUSERSESSION_BASE t2 where t1.IMUSERSESSIONID = t2.IMUSERSESSIONID  AND t2.LOGOUTTIME IS NULL ) and t1.ONLINEFLAG=1");
    }

    @Override
    public CallResult ResetIMUserOnlineStateByStateServer(String strIMStateServerId) {
        return BaseDEDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.iGlobalHelper, (String)this.GetSQL_ResetIMUserStateByStateServer(strIMStateServerId), null);
    }

    protected String GetSQL_ResetIMUserStateByStateServer(String strIMStateServerId) {
        int nVersion = this.iGlobalHelper.getDAModelHelper().GetDEModelVersion("IM0070");
        if (nVersion >= 3) {
            return StringHelper.Format((String)"update SRFT_IMUSER_BASE t1 set ONLINEFLAG=0, IMUSERSESSIONID=NULL where exists  ( select * from SRFT_IMUSERSESSION_BASE t2 where t1.IMUSERSESSIONID = t2.IMUSERSESSIONID AND  t2.IMSTATESERVERID='%1$s' AND t2.LOGOUTTIME IS NULL ) and t1.ALWAYSONLINE <>1 AND  t1.ONLINEFLAG=1", (Object)strIMStateServerId);
        }
        return StringHelper.Format((String)"update SRFT_IMUSER_BASE t1 set ONLINEFLAG=0, IMUSERSESSIONID=NULL where exists  ( select * from SRFT_IMUSERSESSION_BASE t2 where t1.IMUSERSESSIONID = t2.IMUSERSESSIONID AND  t2.IMSTATESERVERID='%1$s' AND t2.LOGOUTTIME IS NULL ) and t1.ONLINEFLAG=1", (Object)strIMStateServerId);
    }

    @Override
    public CallResult GetIMDomain(String strIMDomainId, IMDomain imDomain) {
        return this.SelectSingle(this.GetSQL_GetIMDomain(strIMDomainId), imDomain, "SYSTEM");
    }

    protected String GetSQL_GetIMDomain(String strIMDomainId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMDOMAIN t1 where t1.IMIMDOMAINID='%1$s'", (Object)strIMDomainId);
    }

    @Override
    public CallResult GetIMAddrRanges(String strIMDomainId, Vector<IMAddrRange> imAddrRanges) {
        return this.SelectMulti(this.GetSQL_GetIMAddrRanges(strIMDomainId), imAddrRanges, IMAddrRange.class, "SYSTEM");
    }

    protected String GetSQL_GetIMAddrRanges(String strIMDomainId) {
        return StringHelper.Format((String)"select t1.* from SRFT_IMADDRRANGE_BASE t1 where t1.IMIMDOMAINID = '%1$s'  ", (Object)strIMDomainId);
    }

    @Override
    public CallResult GetIMConfigType(String strIMConfigTypeId, IMConfigType IMConfigType2) {
        return this.SelectSingle(this.GetSQL_GetIMConfigType(strIMConfigTypeId), IMConfigType2, "SYSTEM");
    }

    protected String GetSQL_GetIMConfigType(String strIMConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMCONFIGTYPE t1 where t1.IMCONFIGTYPEID='%1$s'  ", (Object)strIMConfigTypeId);
    }

    @Override
    public CallResult GetIMConfigValues(String strIMConfigTypeId, Vector<IMConfigValue> imConfigValues) {
        return this.SelectMulti(this.GetSQL_GetIMConfigValues(strIMConfigTypeId), imConfigValues, IMConfigValue.class, "SYSTEM");
    }

    protected String GetSQL_GetIMConfigValues(String strIMConfigTypeId) {
        return StringHelper.Format((String)"select t1.* from SRFT_IMCONFIGVALUE_BASE t1 WHERE t1.IMCONFIGTYPEID= '%1$s'  ORDER BY t1.ORDERFLAG", (Object)strIMConfigTypeId);
    }

    @Override
    public CallResult GetIMUserDisGroups(String strIMUserId, Vector<IMDisGroup> imDisGroups) {
        return this.SelectMulti(this.GetSQL_GetIMUserDisGroups(strIMUserId), imDisGroups, IMDisGroup.class, "SYSTEM");
    }

    protected String GetSQL_GetIMUserDisGroups(String strIMUserId) {
        return StringHelper.Format((String)"select t1.* from SRFT_IMDISGROUP_BASE t1 where t1.ENABLE=1 and t1.VALIDFLAG=1  and exists (select * from srft_imdisgrpdetail_base t2 where t1.IMDISGROUPID = t2.IMDISGROUPID and t2.IMUSERID = '%1$s') order by t1.ORDERFLAG,t1.IMDISGROUPNAME", (Object)strIMUserId);
    }

    @Override
    public CallResult GetIMDisGroupDetails(String strIMDisGroupId, Vector<IMDisGroupDetail> imDisGroupDetails) {
        return this.SelectMulti(this.GetSQL_GetIMDisGroupDetails(strIMDisGroupId), imDisGroupDetails, IMDisGroupDetail.class, "SYSTEM");
    }

    protected String GetSQL_GetIMDisGroupDetails(String strIMDisGroupId) {
        return StringHelper.Format((String)"select t1.*,t2.USERLEVEL,t2.IMUSERNAME,t3.PARTICIPANTOBJ from SRFT_IMDISGRPDETAIL_BASE t1 inner join srft_imuser_base t2 on t1.IMUSERID = t2.IMUSERID LEFT JOIN  SRFT_IMUSERTYPE_BASE t3 ON t2.USERTYPE = t3.IMUSERTYPEID  where t1.IMDISGROUPID='%1$s' order by t1.ORDERFLAG ,t2.USERLEVEL,t2.IMUSERNAME ", (Object)strIMDisGroupId);
    }

    @Override
    public CallResult GetIMDisGroup(String strIMDisGroupId, IMDisGroup imDisGroup) {
        return this.SelectSingle(this.GetSQL_GetIMDisGroup(strIMDisGroupId), imDisGroup, "SYSTEM");
    }

    protected String GetSQL_GetIMDisGroup(String strIMDisGroupId) {
        return StringHelper.Format((String)"select t1.* from SRFV_IMDISGROUP t1 where t1.IMDISGROUPID='%1$s'  ", (Object)strIMDisGroupId);
    }

    @Override
    public CallResult GetLastIMMessageLog(String strIMMeetingId, IMMessageLog imMessageLog) {
        return this.SelectSingle(this.GetSQL_GetLastIMMessageLog(strIMMeetingId), imMessageLog, "SYSTEM");
    }

    protected String GetSQL_GetLastIMMessageLog(String strIMMeetingId) {
        return StringHelper.Format((String)"SELECT t1.* FROM SRFT_IMMESSAGELOG_BASE t1  WHERE  IMMEETINGID = '%1$s' order by CREATEDATE desc  ", (Object)strIMMeetingId);
    }

    @Override
    public CallResult GetLastIMMeetings(String strIMUserId, Vector<IMMeeting> imMeetings) {
        return this.SelectMulti(this.GetSQL_GetLastIMMeetings(strIMUserId), imMeetings, IMMeeting.class, "SYSTEM");
    }

    protected String GetSQL_GetLastIMMeetings(String strIMUserId) {
        return StringHelper.Format((String)" select t1.* from srft_immeeting_base t1 where \t\t (  exists (select * from SRFT_IMPARTICIPANT_BASE t2  inner join srft_imuser_base t3 on t2.imuserid=t3.imuserid  WHERE t2.IMMEETINGID = t1.IMMEETINGID and t2.IMUSERID  = '%1$s'  and( t3.recentfromtime is null or t1.lastmessagetime >= t3.RECENTFROMTIME) ) OR\t      exists (select * from SRFT_IMDISGRPDETAIL_BASE  t2  inner join srft_imuser_base t3 on t2.imuserid=t3.imuserid  WHERE t2.IMDISGROUPID = t1.IMMEETINGID and t2.IMUSERID  = '%1$s' and( t3.recentfromtime is null or t1.lastmessagetime >= t3.RECENTFROMTIME) ) )\t\t  and t1.ENABLE=1 AND T1.LASTMESSAGETIME IS NOT NULL  order by t1.LASTMESSAGETIME desc  ", (Object)strIMUserId);
    }

    protected CallResult SelectSingle2(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            if (selectResult.getMainTable().GetRowCount() == 0) {
                callResult.setRetCode(3);
                return callResult;
            }
            dataEntity.FromDataRow(selectResult.getMainTable().GetRow(0));
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    @Override
    public CallResult GetIMDisGroupDetail(String strIMDisGroupDetailId, IMDisGroupDetail imDisGroupDetail) {
        return this.SelectSingle(this.GetSQL_GetIMDisGroupDetail(strIMDisGroupDetailId), imDisGroupDetail, "SYSTEM");
    }

    protected String GetSQL_GetIMDisGroupDetail(String strIMDisGroupDetailId) {
        return StringHelper.Format((String)"select t1.*,t2.USERLEVEL,t2.IMUSERNAME,t3.PARTICIPANTOBJ from SRFT_IMDISGRPDETAIL_BASE t1 inner join srft_imuser_base t2 on t1.IMUSERID = t2.IMUSERID LEFT JOIN  SRFT_IMUSERTYPE_BASE t3 ON t2.USERTYPE = t3.IMUSERTYPEID  where t1.IMDISGRPDETAILID='%1$s'  ", (Object)strIMDisGroupDetailId);
    }

    protected CallResult SelectSingle(String strSQL, BaseDataEntity dataEntity, String strOpPersonId) {
        CallResult callResult;
        block7: {
            callResult = new CallResult();
            SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS((ISRFDAGlobalHelper)this.iGlobalHelper, null, (String)"", (String)strSQL, null);
            if (selectResult == null || selectResult.getRetCode() != 0) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884cSQL\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo())));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            int nReadSize = 0;
            try {
                try {
                    nReadSize = selectResult.getMainTable().ReadRows(1);
                    if (nReadSize > 0) {
                        DataRow dr = selectResult.getMainTable().GetRow(0);
                        dataEntity.FromDataRow(dr, true);
                        break block7;
                    }
                    callResult.setRetCode(3);
                }
                catch (Exception ex) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u8bbf\u95ee\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()));
                    log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
                    selectResult.Close();
                }
            }
            finally {
                selectResult.Close();
            }
        }
        return callResult;
    }

    protected CallResult SelectMulti(String strSQL, Vector list, Class classType, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (classType != null && (obj = ObjectHelper.Create((Class)classType)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected CallResult SelectMulti(String strSQL, Vector list, String strObjectName, String strOpPersonId) {
        CallResult callResult = new CallResult();
        try {
            SelectResult selectResult = this.iGlobalHelper.getDBCaller().CallRaw2(strSQL);
            if (selectResult == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u4e0d\u660e\u9519\u8bef");
                return callResult;
            }
            if (selectResult.getRetCode() != 0) {
                callResult.From((DBResult)selectResult);
                return callResult;
            }
            if (selectResult.getMainTable() == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u6570\u636e\u8868\u5bf9\u8c61");
                return callResult;
            }
            int nRowCount = selectResult.getMainTable().GetRowCount();
            int i = 0;
            while (i < nRowCount) {
                Object obj;
                BaseDataEntity dataEntity = null;
                if (!StringHelper.IsNullOrEmpty((String)strObjectName) && (obj = ObjectHelper.Create((String)strObjectName)) != null && obj instanceof BaseDataEntity) {
                    dataEntity = (BaseDataEntity)obj;
                }
                if (dataEntity == null) {
                    dataEntity = new BaseDataEntity();
                }
                dataEntity.FromDataRow(selectResult.getMainTable().GetRow(i));
                list.add(dataEntity);
                ++i;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }
}

