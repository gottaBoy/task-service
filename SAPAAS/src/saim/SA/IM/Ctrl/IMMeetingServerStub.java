/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMMTServer;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.IIMMeetingServerInstance;
import SA.IM.Ctrl.IIMMeetingServerStub;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMServerInstance;
import SA.IM.Ctrl.IMFuncServerStub;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMMeetingServerStub
extends IMFuncServerStub
implements IIMMeetingServerStub {
    protected IMMTServer imMTServer = null;
    protected IIMMeetingServerInstance iIMMeetingServerInstance = null;
    protected int nMeetingCount = 0;
    protected int nMaxMeetingCount = 500;
    protected String strServerStatusInfo = "";
    private static final Log log = LogFactory.getLog(IMMeetingServerStub.class);
    private static final Hashtable<String, String> meetingProcessActionMap = new Hashtable();

    static {
        meetingProcessActionMap.put("MEETINGATTEND", "MEETINGATTEND");
        meetingProcessActionMap.put("MEETINGQUIT", "MEETINGQUIT");
        meetingProcessActionMap.put("MEETINGMESSAGE", "MEETINGMESSAGE");
        meetingProcessActionMap.put("MEETINGKEYDOWN", "MEETINGKEYDOWN");
        meetingProcessActionMap.put("MEETINGINVITE", "MEETINGINVITE");
        meetingProcessActionMap.put("MEETINGKICKEDOUT", "MEETINGKICKEDOUT");
        meetingProcessActionMap.put("MEETINGFILEUPLOAD", "MEETINGFILEUPLOAD");
        meetingProcessActionMap.put("MEETINGFILEUPLOADED", "MEETINGFILEUPLOADED");
        meetingProcessActionMap.put("MEETINGFILEDOWNLOADING", "MEETINGFILEDOWNLOADING");
        meetingProcessActionMap.put("MEETINGFILEDOWNLOADED", "MEETINGFILEDOWNLOADED");
        meetingProcessActionMap.put("MEETINGTALKCALL", "MEETINGTALKCALL");
        meetingProcessActionMap.put("MEETINGTALKANSWER", "MEETINGTALKANSWER");
        meetingProcessActionMap.put("MEETINGTALKREJECT", "MEETINGTALKREJECT");
        meetingProcessActionMap.put("MEETINGTALKSYNC", "MEETINGTALKSYNC");
        meetingProcessActionMap.put("MEETINGTALKCLOSE", "MEETINGTALKCLOSE");
        meetingProcessActionMap.put("MEETINGMESSAGECONFIRM", "MEETINGMESSAGECONFIRM");
        meetingProcessActionMap.put("MEETINGACTIVE", "MEETINGACTIVE");
        meetingProcessActionMap.put("MEETINGACTIVE", "MEETINGACTIVE");
        meetingProcessActionMap.put("USERSESSIONLOGIN", "USERSESSIONLOGIN");
        meetingProcessActionMap.put("USERSESSIONLOGOUT", "USERSESSIONLOGOUT");
    }

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.imMTServer = new IMMTServer();
        CallResult callResult = this.getIMModelHelper().GetIMMTServer(this.getServerId(), this.imMTServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected IIMServerInstance getLocalServerInstance() throws Exception {
        if (this.iIMMeetingServerInstance != null) {
            return this.iIMMeetingServerInstance;
        }
        Object objMeetingServerInstance = this.getGlobalHelper().GetGlobalValue("SAIMMEETINGSERVERKEY");
        if (objMeetingServerInstance == null) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objMeetingServerInstance instanceof IIMMeetingServerInstance)) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u4f1a\u8bae\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iIMMeetingServerInstance = (IIMMeetingServerInstance)objMeetingServerInstance;
        return this.iIMMeetingServerInstance;
    }

    @Override
    public int getMeetingCount() {
        return this.nMeetingCount;
    }

    @Override
    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERSYNC", (boolean)true) == 0) {
            return this.OnServerSync(iIMRemoteActionContext);
        }
        return super.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    @Override
    protected IMMessagePackage OnSendRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (meetingProcessActionMap.contains(iIMRemoteActionContext.getAction())) {
            return super.OnSendRemoteAction(iIMRemoteActionContext);
        }
        return new IMMessagePackage();
    }

    protected IMMessagePackage OnServerSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strMeetingCount = iIMRemoteActionContext.getParam("MEETINGCOUNT", "0");
        this.nMeetingCount = Integer.parseInt(strMeetingCount);
        String strAsyncDataCount = iIMRemoteActionContext.getParam("ASYNCDATACOUNT", "0");
        log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]\u540c\u6b65\uff0c\u5f53\u524d\u4f1a\u8bae\u6570[%2$s]\uff0c\u5f02\u6b65\u4fdd\u5b58\u6570\u636e\u6570\u91cf[%3$s]", (Object)this.getServerId(), (Object)this.nMeetingCount, (Object)strAsyncDataCount));
        this.strServerStatusInfo = StringHelper.Format((String)"\u5f53\u524d\u4f1a\u8bae\u6570[%1$s]\uff0c\u5f02\u6b65\u4fdd\u5b58\u6570\u636e\u6570\u91cf[%2$s]", (Object)this.nMeetingCount, (Object)strAsyncDataCount);
        return new IMMessagePackage();
    }

    @Override
    public String getServerStatus() {
        return this.strServerStatusInfo;
    }

    @Override
    protected int OnCalcPriority(IIMRemoteAction iIMRemoteAction) throws Exception {
        if (this.nMeetingCount >= this.nMaxMeetingCount) {
            return 0;
        }
        String imUserId = iIMRemoteAction.getParam("USERID", "");
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(imUserId);
        CallResult callResult = this.getIMModelHelper().GetIMUser(imUserId, imUser);
        if (callResult.IsOk() && StringHelper.Compare((String)imUser.getIMDOMAIN(), (String)this.imServer.getIMDOMAIN(), (boolean)true) == 0) {
            return this.nMaxMeetingCount - this.nMeetingCount + 1000;
        }
        return this.nMaxMeetingCount - this.nMeetingCount;
    }
}

