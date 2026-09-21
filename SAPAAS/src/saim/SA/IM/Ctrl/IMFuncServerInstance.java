/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.IM.Ctrl;

import SA.IM.Ctrl.IIMCatalogServerStub;
import SA.IM.Ctrl.IIMFuncServerContext;
import SA.IM.Ctrl.IIMFuncServerInstance;
import SA.IM.Ctrl.IIMRemoteAction;
import SA.IM.Ctrl.IMMessagePackage;
import SA.IM.Ctrl.IMRemoteAction;
import SA.IM.Ctrl.IMServerInstance;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class IMFuncServerInstance
extends IMServerInstance
implements IIMFuncServerInstance,
IIMFuncServerContext {
    private static final Log log = LogFactory.getLog(IMFuncServerInstance.class);
    protected IIMCatalogServerStub iIMCatalogServerStub = null;
    protected Vector<IIMRemoteAction> remoteActionQueue = new Vector();
    private boolean bLoginFlag = false;
    private boolean bAddRemoteActionToQueue = true;
    private DispatchRemoteActionThread dispatchRemoteActionThread = new DispatchRemoteActionThread();

    @Override
    public void setCatalogServerStub(IIMCatalogServerStub iIMCatalogServerStub) {
        this.iIMCatalogServerStub = iIMCatalogServerStub;
    }

    protected IIMCatalogServerStub getCatalogServerStub() {
        return this.iIMCatalogServerStub;
    }

    @Override
    protected void OnStartServer() throws Exception {
        super.OnStartServer();
        if (this.getCatalogServerStub() == null) {
            throw new Exception("\u76ee\u5f55\u670d\u52a1\u5668\u5b58\u6839\u5bf9\u8c61\u65e0\u6548");
        }
        this.dispatchRemoteActionThread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void OnShutdownServer() throws Exception {
        this.bAddRemoteActionToQueue = false;
        while (true) {
            Vector<IIMRemoteAction> vector = this.remoteActionQueue;
            synchronized (vector) {
                if (this.remoteActionQueue.size() == 0) {
                    break;
                }
            }
            Thread.sleep(100L);
        }
        this.dispatchRemoteActionThread.setStopFlag();
        while (this.dispatchRemoteActionThread.isAlive()) {
            Thread.sleep(100L);
        }
        try {
            this.OnServerLogout();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u5668\u901a\u77e5\u6ce8\u9500\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        super.OnShutdownServer();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void AddRemoteActionToQueue(IMRemoteAction imRemoteActionContext) {
        if (!this.bAddRemoteActionToQueue) {
            return;
        }
        imRemoteActionContext.setFromServer(true);
        imRemoteActionContext.setParam("SERVERID", this.getServerId());
        Vector<IIMRemoteAction> vector = this.remoteActionQueue;
        synchronized (vector) {
            this.remoteActionQueue.add(imRemoteActionContext);
        }
    }

    @Override
    public IMMessagePackage SendRemoteAction(IMRemoteAction imRemoteAction) throws Exception {
        imRemoteAction.setFromServer(true);
        imRemoteAction.setParam("SERVERID", this.getServerId());
        return this.getCatalogServerStub().SendRemoteAction(imRemoteAction);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void OnDispatchRemoteAction() {
        int nErrorRetryCnt = 0;
        while (true) {
            IIMRemoteAction iIMRemoteAction = null;
            Vector<IIMRemoteAction> vector = this.remoteActionQueue;
            synchronized (vector) {
                if (this.remoteActionQueue.size() > 0) {
                    iIMRemoteAction = this.remoteActionQueue.remove(0);
                }
            }
            if (iIMRemoteAction == null) break;
            try {
                IMMessagePackage imMessagePackage = this.iIMCatalogServerStub.SendRemoteAction(iIMRemoteAction);
                if (imMessagePackage.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5411\u670d\u52a1\u5668\u53d1\u9001\u8fdc\u7a0b\u64cd\u4f5c[%1$s]\u8fd4\u56de\u9519\u8bef\uff0c%2$s", (Object)iIMRemoteAction.getAction(), (Object)imMessagePackage.getRetCode()));
                    throw new Exception(StringHelper.Format((String)"\u5411\u670d\u52a1\u5668\u53d1\u9001\u8fdc\u7a0b\u64cd\u4f5c[%1$s]\u8fd4\u56de\u9519\u8bef\uff0c%2$s", (Object)iIMRemoteAction.getAction(), (Object)imMessagePackage.getRetCode()));
                }
                nErrorRetryCnt = 0;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u8fdc\u7a0b\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                if (++nErrorRetryCnt > 3) continue;
                this.remoteActionQueue.add(0, iIMRemoteAction);
            }
        }
    }

    @Override
    protected void OnServerTimer() {
        super.OnServerTimer();
        if (!this.isServerLogin()) {
            try {
                this.OnServerLogin();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884c\u670d\u52a1\u5668\u767b\u5f55\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void OnServerLogin() throws Exception {
        IMMessagePackage imMessagePackage;
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("SERVERLOGIN");
        imRemoteAction.setParam("SERVERID", this.getServerId());
        if (this.getCatalogServerStub().isLocalMode()) {
            imRemoteAction.setParam("LOCALMODE", "TRUE");
        }
        if ((imMessagePackage = this.getCatalogServerStub().SendRemoteAction(imRemoteAction)).getRetCode() == 0) {
            this.bLoginFlag = true;
        } else {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u5668\u767b\u5f55\u53d1\u751f\u9519\u8bef\uff0c\u76ee\u5f55\u670d\u52a1\u5668\u8fd4\u56de[%1$s][%2$s]", (Object)imMessagePackage.getRetCode(), (Object)imMessagePackage.getRetInfo()));
        }
    }

    protected void OnServerShuttingDown() throws Exception {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("SERVERSHUTTINGDOWN");
        imRemoteAction.setParam("SERVERID", this.getServerId());
        IMMessagePackage imMessagePackage = this.getCatalogServerStub().SendRemoteAction(imRemoteAction);
        if (imMessagePackage.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u5668\u901a\u77e5\u5173\u95ed\u53d1\u751f\u9519\u8bef\uff0c\u76ee\u5f55\u670d\u52a1\u5668\u8fd4\u56de[%1$s][%2$s]", (Object)imMessagePackage.getRetCode(), (Object)imMessagePackage.getRetInfo()));
        }
    }

    protected void OnServerLogout() throws Exception {
        IMRemoteAction imRemoteAction = new IMRemoteAction();
        imRemoteAction.setAction("SERVERLOGOUT");
        imRemoteAction.setParam("SERVERID", this.getServerId());
        IMMessagePackage imMessagePackage = this.getCatalogServerStub().SendRemoteAction(imRemoteAction);
        if (imMessagePackage.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u5668\u6ce8\u9500\u53d1\u751f\u9519\u8bef\uff0c\u76ee\u5f55\u670d\u52a1\u5668\u8fd4\u56de[%1$s][%2$s]", (Object)imMessagePackage.getRetCode(), (Object)imMessagePackage.getRetInfo()));
        }
    }

    public boolean isServerLogin() {
        return this.bLoginFlag;
    }

    @Override
    public String getServerCometPath() {
        return this.imServer.getSERVERCOMETPATH();
    }

    @Override
    public String getServerPath() {
        return this.imServer.getSERVERPATH();
    }

    @Override
    protected void OnBeforeShutdownServer() throws Exception {
        try {
            this.OnServerShuttingDown();
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u670d\u52a1\u5668\u901a\u77e5\u5173\u95ed\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
        super.OnBeforeShutdownServer();
    }

    private class DispatchRemoteActionThread
    extends Thread {
        protected boolean bStopFlag = false;

        private DispatchRemoteActionThread() {
        }

        public void setStopFlag() {
            this.bStopFlag = true;
        }

        @Override
        public void run() {
            while (!this.bStopFlag) {
                try {
                    IMFuncServerInstance.this.OnDispatchRemoteAction();
                    Thread.sleep(50L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

