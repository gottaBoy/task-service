/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
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
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.sql.Timestamp;
import java.util.Vector;

public interface IIMModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetIMServer(String var1, IMServer var2);

    public CallResult GetIMCatalogServer(String var1, IMCatalogServer var2);

    public CallResult GetIMStateServer(String var1, IMStateServer var2);

    public CallResult GetIMMTServer(String var1, IMMTServer var2);

    public CallResult GetIMUserSession(String var1, IMUserSession var2);

    public CallResult GetIMMeeting(String var1, IMMeeting var2);

    public CallResult GetLastIMMeeting(String var1, IMMeeting var2);

    public CallResult GetIMParticipant(String var1, IMParticipant var2);

    public CallResult GetIMParticipants(String var1, Vector<IMParticipant> var2);

    public CallResult GetIMUser(String var1, IMUser var2);

    public CallResult GetOnlineIMContacts(String var1, Vector<IMUser> var2);

    public CallResult GetOfflineIMMeetings(String var1, Vector<IMMeeting> var2);

    public CallResult GetUnsendIMMessageLogs(String var1, String var2, Vector<IMMessageLog> var3);

    public CallResult GetUnsendIMFiles(String var1, String var2, Vector<IMFile> var3);

    public CallResult GetIMUserGroups(String var1, Vector<IMUserGroup> var2);

    public CallResult GetIMUserGroupDetails(String var1, Vector<IMUGDetail> var2);

    public CallResult GetIMUserGroupDetails2(String var1, Vector<IMUGDetail> var2);

    public CallResult GetValidIMVersions(Vector<IMVersion> var1);

    public CallResult GetIMContacts(Vector<IMUser> var1);

    public CallResult GetIMOrgTrees(Vector<IMOrgTree> var1);

    public CallResult ResetIMUserOnlineStateByStateServer(String var1);

    public CallResult GetOfflineIMUserInforms(String var1, Timestamp var2, Vector<IMUserInform> var3);

    public CallResult GetIMDomain(String var1, IMDomain var2);

    public CallResult GetIMAddrRanges(String var1, Vector<IMAddrRange> var2);

    public CallResult GetIMConfigType(String var1, IMConfigType var2);

    public CallResult GetIMConfigValues(String var1, Vector<IMConfigValue> var2);

    public CallResult GetIMUserDisGroups(String var1, Vector<IMDisGroup> var2);

    public CallResult GetIMDisGroupDetails(String var1, Vector<IMDisGroupDetail> var2);

    public CallResult GetIMDisGroup(String var1, IMDisGroup var2);

    public CallResult GetLastIMMessageLog(String var1, IMMessageLog var2);

    public CallResult GetLastIMMeetings(String var1, Vector<IMMeeting> var2);

    public CallResult GetIMDisGroupDetail(String var1, IMDisGroupDetail var2);

    public CallResult ResetIMUserOnlineState();
}

