/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.DEDataCtrl.IMRemoteDEDataCtrl;
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
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMModelRemoteHelper
implements IIMModelHelper {
    protected ISRFDAGlobalHelper iGlobalHelper = null;
    private static final Log log = LogFactory.getLog(IMModelRemoteHelper.class);

    @Override
    public void Init(ISRFDAGlobalHelper iGlobalHelper) throws Exception {
        this.iGlobalHelper = iGlobalHelper;
    }

    @Override
    public CallResult GetIMServer(String strServerId, IMServer imServer) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        imServer.setIMSERVERID(strServerId);
        return imServerCtrl.Get(imServer);
    }

    @Override
    public CallResult GetIMCatalogServer(String strServerId, IMCatalogServer imServer) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0030", "SYSTEM");
        imServer.setIMCATALOGSERVERID(strServerId);
        return imServerCtrl.Get(imServer);
    }

    @Override
    public CallResult GetIMStateServer(String strServerId, IMStateServer imServer) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0040", "SYSTEM");
        imServer.setIMSTATESERVERID(strServerId);
        return imServerCtrl.Get(imServer);
    }

    @Override
    public CallResult GetIMMTServer(String strServerId, IMMTServer imServer) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0050", "SYSTEM");
        imServer.setIMMTSERVERID(strServerId);
        return imServerCtrl.Get(imServer);
    }

    @Override
    public CallResult GetIMMeeting(String strIMMeetingId, IMMeeting imMeeting) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0080", "SYSTEM");
        imMeeting.setIMMEETINGID(strIMMeetingId);
        return imServerCtrl.Get(imMeeting);
    }

    @Override
    public CallResult GetIMParticipants(String strIMMeetingId, Vector<IMParticipant> imParticipants) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMMEETINGID", (Object)strIMMeetingId);
        CallResult callResult = imServerCtrl.Select("GETIMPARTICIPANTS", dataEntity, imParticipants, IMParticipant.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMParticipant(String strIMParticipantId, IMParticipant imParticipant) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMPARTICIPANTID", (Object)strIMParticipantId);
        Vector imParticipants = new Vector();
        CallResult callResult = imServerCtrl.Select("GETIMPARTICIPANT", dataEntity, imParticipants, IMParticipant.class.getName());
        if (imParticipants.size() > 0) {
            if (imParticipant == null) {
                imParticipant = new IMParticipant();
            }
            imParticipant.Proxy((BaseDataEntity)imParticipants.get(0));
        }
        return callResult;
    }

    @Override
    public CallResult GetIMUserSession(String strIMUserSessionId, IMUserSession imUserSession) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERSESSIONID", (Object)strIMUserSessionId);
        Vector sessions = new Vector();
        CallResult callResult = imServerCtrl.Select("GETIMUSERSESSION", dataEntity, sessions, IMUserSession.class.getName());
        if (sessions.size() > 0) {
            if (imUserSession == null) {
                imUserSession = new IMUserSession();
            }
            imUserSession.Proxy((BaseDataEntity)sessions.get(0));
        }
        return callResult;
    }

    @Override
    public CallResult GetIMUser(String strIMUserId, IMUser imUser) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0070", "SYSTEM");
        imUser.setIMUSERID(strIMUserId);
        return imServerCtrl.Get(imUser);
    }

    @Override
    public CallResult GetOnlineIMContacts(String strIMUserId, Vector<IMUser> imUsers) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETONLINEIMCONTACTS", dataEntity, imUsers, IMUser.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMContacts(Vector<IMUser> imUsers) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = imServerCtrl.Select("GETIMCONTACTS", dataEntity, imUsers, IMUser.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetLastIMMeeting(String strIMUserIds, IMMeeting imMeeting) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERIDS", (Object)strIMUserIds);
        Vector meetings = new Vector();
        CallResult callResult = imServerCtrl.Select("GETLASTIMMEETING", dataEntity, meetings, IMMeeting.class.getName());
        if (meetings.size() > 0) {
            if (imMeeting == null) {
                imMeeting = new IMMeeting();
            }
            imMeeting.Proxy((BaseDataEntity)meetings.get(0));
        }
        return callResult;
    }

    @Override
    public CallResult GetOfflineIMMeetings(String strIMUserId, Vector<IMMeeting> imMeetings) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETOFFLINEIMMEETINGS", dataEntity, imMeetings, IMMeeting.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetUnsendIMMessageLogs(String strIMMeetingId, String strIMUserId, Vector<IMMessageLog> imMessageLogs) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        dataEntity.SetParamValue("IMMEETINGID", (Object)strIMMeetingId);
        CallResult callResult = imServerCtrl.Select("GETUNSENDIMMESSAGELOGS", dataEntity, imMessageLogs, IMMessageLog.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetOfflineIMUserInforms(String strIMUserId, Timestamp lastInformTime, Vector<IMUserInform> imUserInforms) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        dataEntity.SetParamValue("LASTINFORMTIME", (Object)lastInformTime);
        CallResult callResult = imServerCtrl.Select("GETOFFLINEIMUSERINFORMS", dataEntity, imUserInforms, IMUserInform.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetUnsendIMFiles(String strIMMeetingId, String strIMUserId, Vector<IMFile> imFiles) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        dataEntity.SetParamValue("IMMEETINGID", (Object)strIMMeetingId);
        CallResult callResult = imServerCtrl.Select("GETUNSENDIMFILES", dataEntity, imFiles, IMFile.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMUserGroups(String strIMUserId, Vector<IMUserGroup> imUserGroups) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETIMUSERGROUPS", dataEntity, imUserGroups, IMUserGroup.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMUserGroupDetails(String strIMUserId, Vector<IMUGDetail> imUGDetails) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETIMUSERGROUPDETAILS", dataEntity, imUGDetails, IMUGDetail.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMUserGroupDetails2(String strIMUserGroupId, Vector<IMUGDetail> imUGDetails) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERGROUPID", (Object)strIMUserGroupId);
        CallResult callResult = imServerCtrl.Select("GETIMUSERGROUPDETAILS2", dataEntity, imUGDetails, IMUGDetail.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetValidIMVersions(Vector<IMVersion> imVersions) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = imServerCtrl.Select("GETVALIDIMVERSIONS", dataEntity, imVersions, IMVersion.class.getName());
        return callResult;
    }

    @Override
    public CallResult ResetIMUserOnlineStateByStateServer(String strIMStateServerId) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = imServerCtrl.CustomCall("RESETIMUSERONLINESTATEBYSTATESERVER", dataEntity);
        return callResult;
    }

    @Override
    public CallResult GetIMDomain(String strIMDomainId, IMDomain imDomain) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0069", "SYSTEM");
        imDomain.setIMDOMAINID(strIMDomainId);
        return imServerCtrl.Get(imDomain);
    }

    @Override
    public CallResult GetIMAddrRanges(String strIMDomainId, Vector<IMAddrRange> imAddrRanges) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMDOMAINID", (Object)strIMDomainId);
        CallResult callResult = imServerCtrl.Select("GETIMADDRRANGES", dataEntity, imAddrRanges, IMAddrRange.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMConfigType(String strIMConfigTypeId, IMConfigType imConfigType) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0003", "SYSTEM");
        imConfigType.setIMCONFIGTYPEID(strIMConfigTypeId);
        return imServerCtrl.Get(imConfigType);
    }

    @Override
    public CallResult GetIMConfigValues(String strIMConfigTypeId, Vector<IMConfigValue> imConfigValues) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMCONFIGTYPEID", (Object)strIMConfigTypeId);
        CallResult callResult = imServerCtrl.Select("GETIMCONFIGVALUES", dataEntity, imConfigValues, IMConfigValue.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMUserDisGroups(String strIMUserId, Vector<IMDisGroup> imDisGroups) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETIMUSERDISGROUPS", dataEntity, imDisGroups, IMDisGroup.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMDisGroupDetails(String strIMDisGroupId, Vector<IMDisGroupDetail> imDisGroupDetails) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMDISGROUPID", (Object)strIMDisGroupId);
        CallResult callResult = imServerCtrl.Select("GETIMDISGROUPDETAILS", dataEntity, imDisGroupDetails, IMDisGroupDetail.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMDisGroup(String strIMDisGroupId, IMDisGroup imDisGroup) {
        imDisGroup.setIMDISGROUPID(strIMDisGroupId);
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0097", "SYSTEM");
        return imServerCtrl.Get(imDisGroup);
    }

    @Override
    public CallResult GetLastIMMessageLog(String strIMMeetingId, IMMessageLog imMessageLog) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMMEETINGID", (Object)strIMMeetingId);
        Vector logs = new Vector();
        CallResult callResult = imServerCtrl.Select("GETLASTIMMESSAGELOG", dataEntity, logs, IMMessageLog.class.getName());
        if (logs.size() > 0) {
            if (imMessageLog == null) {
                imMessageLog = new IMMessageLog();
            }
            imMessageLog.Proxy((BaseDataEntity)logs.get(0));
        }
        return callResult;
    }

    @Override
    public CallResult GetLastIMMeetings(String strIMUserId, Vector<IMMeeting> imMeetings) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMUSERID", (Object)strIMUserId);
        CallResult callResult = imServerCtrl.Select("GETLASTIMMEETINGS", dataEntity, imMeetings, IMMeeting.class.getName());
        return callResult;
    }

    @Override
    public CallResult GetIMDisGroupDetail(String strIMDisGroupDetailId, IMDisGroupDetail imDisGroupDetail) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue("IMDISGROUPDETAILID", (Object)strIMDisGroupDetailId);
        Vector details = new Vector();
        CallResult callResult = imServerCtrl.Select("GETIMDISGROUPDETAIL", dataEntity, details, IMDisGroupDetail.class.getName());
        if (details.size() > 0) {
            if (imDisGroupDetail == null) {
                imDisGroupDetail = new IMDisGroupDetail();
            }
            imDisGroupDetail.Proxy((BaseDataEntity)details.get(0));
        }
        return callResult;
    }

    @Override
    public CallResult GetIMOrgTrees(Vector<IMOrgTree> imOrgTrees) {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        BaseDataEntity dataEntity = new BaseDataEntity();
        CallResult callResult = imServerCtrl.Select("GETORGTREES", dataEntity, imOrgTrees, IMOrgTree.class.getName());
        return callResult;
    }

    @Override
    public CallResult ResetIMUserOnlineState() {
        IMRemoteDEDataCtrl imServerCtrl = new IMRemoteDEDataCtrl();
        imServerCtrl.Init("", "IM0021", "SYSTEM");
        CallResult callResult = imServerCtrl.CustomCall("RESETIMUSERONLINESTATEBYSTATESERVER", new BaseDataEntity());
        return callResult;
    }
}

