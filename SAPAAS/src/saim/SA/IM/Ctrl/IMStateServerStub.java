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

import SA.IM.Ctrl.Data.IMStateServer;
import SA.IM.Ctrl.Data.IMUser;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMServerInstance;
import SA.IM.Ctrl.IIMStateServerInstance;
import SA.IM.Ctrl.IIMStateServerStub;
import SA.IM.Ctrl.IMFuncServerStub;
import SA.IM.Ctrl.IMMessagePackage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IMStateServerStub
extends IMFuncServerStub
implements IIMStateServerStub {
    protected IMStateServer imStateServer = null;
    protected IIMStateServerInstance iIMStateServerInstance = null;
    protected int nUserSessionCount = 0;
    private static final Log log = LogFactory.getLog(IMStateServerStub.class);
    protected int nMaxUserSessionCount = 2000;
    protected String strServerStatusInfo = "";

    @Override
    protected void OnInit() throws Exception {
        super.OnInit();
        this.imStateServer = new IMStateServer();
        CallResult callResult = this.getIMModelHelper().GetIMStateServer(this.getServerId(), this.imStateServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    protected IIMServerInstance getLocalServerInstance() throws Exception {
        if (this.iIMStateServerInstance != null) {
            return this.iIMStateServerInstance;
        }
        Object objStateServerInstance = this.getGlobalHelper().GetGlobalValue("SAIMSTATESERVERKEY");
        if (objStateServerInstance == null) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b");
        }
        if (!(objStateServerInstance instanceof IIMStateServerInstance)) {
            throw new Exception("\u65e0\u6cd5\u4ece\u5168\u5c40\u5b58\u50a8\u4e2d\u83b7\u53d6\u72b6\u6001\u670d\u52a1\u5668\u5b9e\u4f8b\uff0c\u7c7b\u578b\u4e0d\u6b63\u786e");
        }
        this.iIMStateServerInstance = (IIMStateServerInstance)objStateServerInstance;
        return this.iIMStateServerInstance;
    }

    @Override
    public int getUserSessionCount() {
        return this.nUserSessionCount;
    }

    @Override
    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (StringHelper.Compare((String)iIMRemoteActionContext.getAction(), (String)"SERVERSYNC", (boolean)true) == 0) {
            return this.OnServerSync(iIMRemoteActionContext);
        }
        return super.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnServerSync(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        String strUserSessionCount = iIMRemoteActionContext.getParam("USERSESSIONCOUNT", "0");
        this.nUserSessionCount = Integer.parseInt(strUserSessionCount);
        log.debug((Object)StringHelper.Format((String)"\u4f1a\u8bae\u670d\u52a1\u5668[%1$s]\u540c\u6b65\uff0c\u5f53\u524d\u7528\u6237\u6570[%2$s]", (Object)this.getServerId(), (Object)this.nUserSessionCount));
        this.strServerStatusInfo = StringHelper.Format((String)"\u5f53\u524d\u7528\u6237\u6570[%1$s]", (Object)this.nUserSessionCount);
        return new IMMessagePackage();
    }

    @Override
    public String getServerStatus() {
        return this.strServerStatusInfo;
    }

    @Override
    protected int OnCalcPriority(IIMRemoteAction iIMRemoteAction) throws Exception {
        if (this.nUserSessionCount >= this.nMaxUserSessionCount) {
            return 0;
        }
        String imUserId = iIMRemoteAction.getParam("USERID", "");
        IMUser imUser = new IMUser();
        imUser.setIMUSERID(imUserId);
        CallResult callResult = this.getIMModelHelper().GetIMUser(imUserId, imUser);
        if (callResult.IsOk() && StringHelper.Compare((String)imUser.getIMDOMAIN(), (String)this.imServer.getIMDOMAIN(), (boolean)true) == 0) {
            return this.nMaxUserSessionCount - this.nUserSessionCount + 1000;
        }
        return this.nMaxUserSessionCount - this.nUserSessionCount;
    }
}

