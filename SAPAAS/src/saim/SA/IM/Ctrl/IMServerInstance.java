/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.Data.IMServer;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IIMServerInstance;
import SA.IM.Ctrl.IMException;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMObjectBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Timer;
import java.util.TimerTask;

public abstract class IMServerInstance
extends IMObjectBase
implements IIMServerInstance {
    private boolean bServerStart = false;
    private Timer serverTimer = null;
    private boolean bServerShuttingDown = false;
    protected IMServer imServer = null;

    @Override
    public void Init(ISRFDAGlobalHelper iSRFDAGlobalHelper, String strServerId) throws Exception {
        this.setGlobalHelper(iSRFDAGlobalHelper);
        IMServer imServer = new IMServer();
        CallResult callResult = this.getIMModelHelper().GetIMServer(strServerId, imServer);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u670d\u52a1\u5668[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strServerId, (Object)callResult.getErrorInfo()));
        }
        this.imServer = imServer;
        this.OnInit();
    }

    @Override
    public void Init(ISRFDAGlobalHelper iSRFDAGlobalHelper, IMServer imServer) throws Exception {
        this.setGlobalHelper(iSRFDAGlobalHelper);
        this.imServer = imServer;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    protected void OnServerTimer() {
    }

    @Override
    public String getServerId() {
        return this.imServer.getIMSERVERID();
    }

    @Override
    public IMMessagePackage ProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        if (this.isServerShuttingDown()) {
            throw new IMException(10007);
        }
        return this.OnProcessRemoteAction(iIMRemoteActionContext);
    }

    protected IMMessagePackage OnProcessRemoteAction(IIMRemoteAction iIMRemoteActionContext) throws Exception {
        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u5904\u7406\u7684\u8fdc\u7a0b\u8bf7\u6c42[%1$s]", (Object)iIMRemoteActionContext.getAction()));
    }

    @Override
    public synchronized void StartServer() throws Exception {
        if (this.isServerStart()) {
            throw new Exception("\u670d\u52a1\u5668\u5df2\u7ecf\u542f\u52a8");
        }
        this.OnStartServer();
        this.bServerStart = true;
    }

    @Override
    public synchronized void ShutdownServer() throws Exception {
        if (!this.isServerStart()) {
            throw new Exception("\u670d\u52a1\u5668\u672a\u542f\u52a8");
        }
        this.bServerShuttingDown = true;
        this.OnBeforeShutdownServer();
        this.OnShutdownServer();
        this.bServerStart = false;
    }

    @Override
    public boolean isServerStart() {
        return this.bServerStart;
    }

    protected void OnStartServer() throws Exception {
        this.serverTimer = new Timer("IMSERVER" + this.getServerId());
        this.serverTimer.schedule((TimerTask)new IMServerTimerTask(), 5000L, 5000L);
    }

    protected void OnBeforeShutdownServer() throws Exception {
    }

    protected void OnShutdownServer() throws Exception {
        this.serverTimer.cancel();
        this.serverTimer = null;
    }

    @Override
    public boolean isServerShuttingDown() {
        return this.bServerShuttingDown;
    }

    protected class IMServerTimerTask
    extends TimerTask {
        private boolean bRunTimer = false;

        protected IMServerTimerTask() {
        }

        @Override
        public void run() {
            if (this.bRunTimer) {
                return;
            }
            this.bRunTimer = true;
            IMServerInstance.this.OnServerTimer();
            this.bRunTimer = false;
        }
    }
}

