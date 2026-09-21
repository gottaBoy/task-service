/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.DefaultDEVersionHelper;
import SA.SRFDA.Ctrl.IDEVersionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAModelVersionHelper {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Hashtable<String, IDEVersionHelper> deVersionMap = new Hashtable();
    private static final Log log = LogFactory.getLog(DAModelVersionHelper.class);
    private boolean bEnabled = false;
    private DAModelVersionTimer daModelVersionTimer = null;
    protected ArrayList<IDEVersionHelper> deVersionList = new ArrayList();

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
        if (this.iDAGlobalHelper.getDAModelVersion() < 11033000) {
            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53\u6a21\u578b\u7248\u672c\u8f85\u52a9\u5bf9\u8c61\u4e0d\u542f\u7528\uff0c\u6a21\u578b\u7248\u672c\u4e0d\u80fd\u6ee1\u8db3\u8981\u6c42"));
        } else {
            this.bEnabled = true;
            this.daModelVersionTimer = new DAModelVersionTimer();
            this.daModelVersionTimer.Start();
        }
        return new CallResult();
    }

    public void Quit() {
        this.daModelVersionTimer.Stop();
    }

    public boolean getEnabled() {
        return this.bEnabled;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void RunTimer() {
        Date date = new Date();
        this.deVersionList.clear();
        Hashtable<String, IDEVersionHelper> hashtable = this.deVersionMap;
        synchronized (hashtable) {
            this.deVersionList.addAll(this.deVersionMap.values());
        }
        for (IDEVersionHelper deVersion : this.deVersionList) {
            deVersion.RunTimer(date.getTime());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int GetDEDataVersion(String strDEId, Object objDataId, boolean bReset) {
        if (!this.bEnabled) {
            return -1;
        }
        IDEVersionHelper deVersion = this.deVersionMap.get(strDEId);
        if (deVersion == null) {
            try {
                deVersion = this.CreateDEVersionHelper(strDEId);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage());
                return -1;
            }
            Hashtable<String, IDEVersionHelper> hashtable = this.deVersionMap;
            synchronized (hashtable) {
                this.deVersionMap.put(strDEId, deVersion);
            }
        }
        return deVersion.GetDataVersion(objDataId, bReset);
    }

    protected IDEVersionHelper CreateDEVersionHelper(String strDEId) throws Exception {
        DataEntity dataEntity = new DataEntity();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetDataEntity(strDEId, dataEntity);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\uff0c%2$s", (Object)strDEId, (Object)callResult.getErrorInfo()));
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\uff0c%2$s", (Object)strDEId, (Object)callResult.getErrorInfo()));
        }
        if (!dataEntity.getVERSIONCHECK()) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u542f\u7528\u7248\u672c\u68c0\u67e5", (Object)strDEId));
            throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u542f\u7528\u7248\u672c\u68c0\u67e5", (Object)strDEId));
        }
        IDEVersionHelper deVersion = null;
        String strVerObject = dataEntity.getVERHELPER();
        if (StringHelper.IsNullOrEmpty((String)strVerObject)) {
            deVersion = new DefaultDEVersionHelper();
        } else {
            Object objDEVersion = ObjectHelper.Create((String)strVerObject);
            if (objDEVersion == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u7248\u672c\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strVerObject));
            }
            if (!(objDEVersion instanceof IDEVersionHelper)) {
                throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u7248\u672c\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strVerObject));
            }
            deVersion = (IDEVersionHelper)objDEVersion;
        }
        deVersion.Init(this.iDAGlobalHelper, dataEntity);
        return deVersion;
    }

    class DAModelVersionTimer
    extends TimerTask {
        private Timer timer = null;
        private boolean bRun = false;

        DAModelVersionTimer() {
        }

        public void Start() {
            if (this.timer == null) {
                this.timer = new Timer("DAMODELVERSIONTIMER");
                this.timer.schedule((TimerTask)this, 5000L, 5000L);
            }
        }

        public void Stop() {
            if (this.timer != null) {
                this.timer.cancel();
                this.timer = null;
            }
        }

        @Override
        public void run() {
            if (!this.bRun) {
                this.bRun = true;
                DAModelVersionHelper.this.RunTimer();
                this.bRun = false;
            }
        }
    }
}

