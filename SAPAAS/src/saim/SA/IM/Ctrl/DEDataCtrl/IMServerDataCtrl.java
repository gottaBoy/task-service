/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl.DEDataCtrl;

import SA.IM.Ctrl.Data.IMAddrRange;
import SA.IM.Ctrl.Data.IMConfigValue;
import SA.IM.Ctrl.Data.IMDisGroup;
import SA.IM.Ctrl.Data.IMDisGroupDetail;
import SA.IM.Ctrl.Data.IMFile;
import SA.IM.Ctrl.Data.IMMeeting;
import SA.IM.Ctrl.Data.IMMessageLog;
import SA.IM.Ctrl.Data.IMOrgTree;
import SA.IM.Ctrl.Data.IMParticipant;
import SA.IM.Ctrl.Data.IMUGDetail;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.Data.IMUserGroup;
import SA.IM.Ctrl.Data.IMUserInform;
import SA.IM.Ctrl.Data.IMUserSession;
import SA.IM.Ctrl.Data.IMVersion;
import SA.IM.Ctrl.IIMModelHelper;
import SA.IM.Ctrl.IMModelHelperFactory;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Vector;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMServerDataCtrl
extends BaseDEDataCtrl {
    public static final String IMACTION_GETIMPARTICIPANTS = "GETIMPARTICIPANTS";
    public static final String IMACTION_GETIMPARTICIPANT = "GETIMPARTICIPANT";
    public static final String IMACTION_GETIMUSERSESSION = "GETIMUSERSESSION";
    public static final String IMACTION_GETONLINEIMCONTACTS = "GETONLINEIMCONTACTS";
    public static final String IMACTION_GETIMCONTACTS = "GETIMCONTACTS";
    public static final String IMACTION_GETLASTIMMEETING = "GETLASTIMMEETING";
    public static final String IMACTION_GETOFFLINEIMMEETINGS = "GETOFFLINEIMMEETINGS";
    public static final String IMACTION_GETUNSENDIMMESSAGELOGS = "GETUNSENDIMMESSAGELOGS";
    public static final String IMACTION_GETOFFLINEIMUSERINFORMS = "GETOFFLINEIMUSERINFORMS";
    public static final String IMACTION_GETUNSENDIMFILES = "GETUNSENDIMFILES";
    public static final String IMACTION_GETIMUSERGROUPS = "GETIMUSERGROUPS";
    public static final String IMACTION_GETIMUSERGROUPDETAILS = "GETIMUSERGROUPDETAILS";
    public static final String IMACTION_GETIMUSERGROUPDETAILS2 = "GETIMUSERGROUPDETAILS2";
    public static final String IMACTION_GETVALIDIMVERSIONS = "GETVALIDIMVERSIONS";
    public static final String IMACTION_RESETIMUSERONLINESTATEBYSTATESERVER = "RESETIMUSERONLINESTATEBYSTATESERVER";
    public static final String IMACTION_RESETIMUSERONLINESTATE = "RESETIMUSERONLINESTATE";
    public static final String IMACTION_GETIMADDRRANGES = "GETIMADDRRANGES";
    public static final String IMACTION_GETIMCONFIGVALUES = "GETIMCONFIGVALUES";
    public static final String IMACTION_GETIMUSERDISGROUPS = "GETIMUSERDISGROUPS";
    public static final String IMACTION_GETIMDISGROUPDETAILS = "GETIMDISGROUPDETAILS";
    public static final String IMACTION_GETLASTIMMESSAGELOG = "GETLASTIMMESSAGELOG";
    public static final String IMACTION_GETLASTIMMEETINGS = "GETLASTIMMEETINGS";
    public static final String IMACTION_GETIMDISGROUPDETAIL = "GETIMDISGROUPDETAIL";
    public static final String IMACTION_GETORGTREES = "GETORGTREES";
    private static final Log log = LogFactory.getLog(IMServerDataCtrl.class);

    public CallResult Select(String strAction, BaseDataEntity dataEntity, Vector list, String clzz) {
        try {
            IIMModelHelper iMModelHelper = IMModelHelperFactory.Create(this.getGlobalHelper());
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMPARTICIPANTS, (boolean)true) == 0) {
                String strIMMeetingId = dataEntity.GetParamStringValue("IMMEETINGID", "");
                Vector<IMParticipant> imParticipants = new Vector<IMParticipant>();
                CallResult callResult = iMModelHelper.GetIMParticipants(strIMMeetingId, imParticipants);
                list.addAll(imParticipants);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMPARTICIPANT, (boolean)true) == 0) {
                String strIMParticipantId = dataEntity.GetParamStringValue("IMPARTICIPANTID", "");
                IMParticipant imParticipant = new IMParticipant();
                CallResult callResult = iMModelHelper.GetIMParticipant(strIMParticipantId, imParticipant);
                list.add(imParticipant);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERSESSION, (boolean)true) == 0) {
                String strIMUserSessionId = dataEntity.GetParamStringValue("IMUSERSESSIONID", "");
                IMUserSession imUserSession = new IMUserSession();
                CallResult callResult = iMModelHelper.GetIMUserSession(strIMUserSessionId, imUserSession);
                list.add(imUserSession);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETONLINEIMCONTACTS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMUser> imUsers = new Vector<IMUser>();
                CallResult callResult = iMModelHelper.GetOnlineIMContacts(strIMUserId, imUsers);
                list.addAll(imUsers);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMCONTACTS, (boolean)true) == 0) {
                Vector<IMUser> imUsers = new Vector<IMUser>();
                CallResult callResult = iMModelHelper.GetIMContacts(imUsers);
                list.addAll(imUsers);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETLASTIMMEETING, (boolean)true) == 0) {
                String strIMUserIds = dataEntity.GetParamStringValue("IMUSERIDS", "");
                IMMeeting imMeeting = new IMMeeting();
                CallResult callResult = iMModelHelper.GetLastIMMeeting(strIMUserIds, imMeeting);
                list.add(imMeeting);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETOFFLINEIMMEETINGS, (boolean)true) == 0) {
                String strIMUserIds = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMMeeting> imMeetings = new Vector<IMMeeting>();
                CallResult callResult = iMModelHelper.GetOfflineIMMeetings(strIMUserIds, imMeetings);
                list.addAll(imMeetings);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETUNSENDIMMESSAGELOGS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                String strIMMeetingId = dataEntity.GetParamStringValue("IMMEETINGID", "");
                Vector<IMMessageLog> imMessageLogs = new Vector<IMMessageLog>();
                CallResult callResult = iMModelHelper.GetUnsendIMMessageLogs(strIMMeetingId, strIMUserId, imMessageLogs);
                list.addAll(imMessageLogs);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETOFFLINEIMUSERINFORMS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMUserInform> imUserInforms = new Vector<IMUserInform>();
                Timestamp lastInformTime = dataEntity.GetParamTimestampValue("LASTINFORMTIME", null);
                CallResult callResult = iMModelHelper.GetOfflineIMUserInforms(strIMUserId, lastInformTime, imUserInforms);
                list.addAll(imUserInforms);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETUNSENDIMFILES, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                String strIMMeetingId = dataEntity.GetParamStringValue("IMMEETINGID", "");
                Vector<IMFile> imFiles = new Vector<IMFile>();
                CallResult callResult = iMModelHelper.GetUnsendIMFiles(strIMMeetingId, strIMUserId, imFiles);
                list.addAll(imFiles);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERGROUPS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMUserGroup> imUserGroups = new Vector<IMUserGroup>();
                CallResult callResult = iMModelHelper.GetIMUserGroups(strIMUserId, imUserGroups);
                list.addAll(imUserGroups);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERGROUPS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMUserGroup> imUserGroups = new Vector<IMUserGroup>();
                CallResult callResult = iMModelHelper.GetIMUserGroups(strIMUserId, imUserGroups);
                list.addAll(imUserGroups);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERGROUPDETAILS, (boolean)true) == 0) {
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                Vector<IMUGDetail> imUGDetails = new Vector<IMUGDetail>();
                CallResult callResult = iMModelHelper.GetIMUserGroupDetails(strIMUserId, imUGDetails);
                list.addAll(imUGDetails);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERGROUPDETAILS2, (boolean)true) == 0) {
                String strIMUserGroupID = dataEntity.GetParamStringValue("IMUSERGROUPID", "");
                Vector<IMUGDetail> imUGDetails = new Vector<IMUGDetail>();
                CallResult callResult = iMModelHelper.GetIMUserGroupDetails2(strIMUserGroupID, imUGDetails);
                list.addAll(imUGDetails);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETVALIDIMVERSIONS, (boolean)true) == 0) {
                Vector<IMVersion> imVersions = new Vector<IMVersion>();
                CallResult callResult = iMModelHelper.GetValidIMVersions(imVersions);
                list.addAll(imVersions);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMADDRRANGES, (boolean)true) == 0) {
                Vector<IMAddrRange> imAddrRanges = new Vector<IMAddrRange>();
                String strIMDomainId = dataEntity.GetParamStringValue("IMDOMAINID", "");
                CallResult callResult = iMModelHelper.GetIMAddrRanges(strIMDomainId, imAddrRanges);
                list.addAll(imAddrRanges);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMCONFIGVALUES, (boolean)true) == 0) {
                Vector<IMConfigValue> imConfigValues = new Vector<IMConfigValue>();
                String strIMConfigTypeId = dataEntity.GetParamStringValue("IMCONFIGTYPEID", "");
                CallResult callResult = iMModelHelper.GetIMConfigValues(strIMConfigTypeId, imConfigValues);
                list.addAll(imConfigValues);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMUSERDISGROUPS, (boolean)true) == 0) {
                Vector<IMDisGroup> imDisGroups = new Vector<IMDisGroup>();
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                CallResult callResult = iMModelHelper.GetIMUserDisGroups(strIMUserId, imDisGroups);
                list.addAll(imDisGroups);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMDISGROUPDETAILS, (boolean)true) == 0) {
                Vector<IMDisGroupDetail> imDisGroupDetails = new Vector<IMDisGroupDetail>();
                String strIMDisGroupId = dataEntity.GetParamStringValue("IMDISGROUPID", "");
                CallResult callResult = iMModelHelper.GetIMDisGroupDetails(strIMDisGroupId, imDisGroupDetails);
                list.addAll(imDisGroupDetails);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETLASTIMMESSAGELOG, (boolean)true) == 0) {
                IMMessageLog imMessageLog = new IMMessageLog();
                String strIMMeetingId = dataEntity.GetParamStringValue("IMMEETINGID", "");
                CallResult callResult = iMModelHelper.GetLastIMMessageLog(strIMMeetingId, imMessageLog);
                list.add(imMessageLog);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETLASTIMMEETINGS, (boolean)true) == 0) {
                Vector<IMMeeting> imMeetings = new Vector<IMMeeting>();
                String strIMUserId = dataEntity.GetParamStringValue("IMUSERID", "");
                CallResult callResult = iMModelHelper.GetLastIMMeetings(strIMUserId, imMeetings);
                list.addAll(imMeetings);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETIMDISGROUPDETAIL, (boolean)true) == 0) {
                IMDisGroupDetail imDisGroupDetail = new IMDisGroupDetail();
                String strIMDisGroupDetailId = dataEntity.GetParamStringValue("IMDISGROUPDETAILID", "");
                CallResult callResult = iMModelHelper.GetIMDisGroupDetail(strIMDisGroupDetailId, imDisGroupDetail);
                list.add(imDisGroupDetail);
                return callResult;
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_GETORGTREES, (boolean)true) == 0) {
                Vector<IMOrgTree> imVersions = new Vector<IMOrgTree>();
                CallResult callResult = iMModelHelper.GetIMOrgTrees(imVersions);
                list.addAll(imVersions);
                return callResult;
            }
            return super.Select(strAction, dataEntity, list, clzz);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    protected CallResult OnCustomCall(String strAction, BaseDataEntity dataEntity) {
        try {
            IIMModelHelper iMModelHelper = IMModelHelperFactory.Create(this.getGlobalHelper());
            if (StringHelper.Compare((String)strAction, (String)IMACTION_RESETIMUSERONLINESTATEBYSTATESERVER, (boolean)true) == 0) {
                String strIMStateServerId = dataEntity.GetParamStringValue("IMSTATESERVERID", "");
                return iMModelHelper.ResetIMUserOnlineStateByStateServer(strIMStateServerId);
            }
            if (StringHelper.Compare((String)strAction, (String)IMACTION_RESETIMUSERONLINESTATE, (boolean)true) == 0) {
                return iMModelHelper.ResetIMUserOnlineState();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return super.OnCustomCall(strAction, dataEntity);
    }

    public static Object ToJSONObject(JSONArray arr) {
        JSONObject jo = new JSONObject();
        jo.put("items", (Object)arr);
        return jo.toString();
    }
}

