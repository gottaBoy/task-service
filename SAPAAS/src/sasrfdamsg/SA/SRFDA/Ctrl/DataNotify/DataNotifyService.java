/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAQueryModelHelper
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.BaseService
 *  SA.SRFDA.Ctrl.Data.DEDataLog
 *  SA.SRFDA.Ctrl.Data.DataNotify
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.DEDataLog;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataNotifyService
extends BaseService {
    private static Log log = LogFactory.getLog(DataNotifyService.class);
    private Timer notifyTimer = null;
    int nSendTimer = 30000;
    protected boolean bDebug = false;
    int nPageSize = 100;
    String strQuerySQL = "";
    boolean bSending = false;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        String strQMHelperObject = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strQMHelperObject)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61"));
            return callResult;
        }
        BaseDAQueryModelHelper daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strQMHelperObject);
        if (daQueryModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strQMHelperObject));
            return callResult;
        }
        this.nPageSize = Integer.parseInt(this.GetServiceParam("PAGESIZE", "100"));
        this.strQuerySQL = daQueryModelHelper.GetPagingSQL("SELECT * FROM T_SRFDEDATALOG ", 0, this.nPageSize, "CREATEDATE", "ASC", "", "");
        this.bDebug = Boolean.parseBoolean(this.GetServiceParam("DEBUG", "FALSE"));
        return callResult;
    }

    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        if (this.notifyTimer == null) {
            this.notifyTimer = new Timer("DATANOTIFYQUEUE");
            this.notifyTimer.schedule((TimerTask)((Object)this), this.nSendTimer, (long)this.nSendTimer);
        }
        log.info((Object)StringHelper.Format((String)"\u6570\u636e\u901a\u77e5\u5f02\u6b65\u670d\u52a1\u542f\u52a8"));
        return callResult;
    }

    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"\u6570\u636e\u901a\u77e5\u5f02\u6b65\u670d\u52a1\u505c\u6b62"));
        if (this.notifyTimer != null) {
            this.notifyTimer.cancel();
            this.notifyTimer = null;
        }
        return super.OnStop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        DataNotifyService dataNotifyService = this;
        synchronized (dataNotifyService) {
            if (this.bSending) {
                return;
            }
            this.bSending = true;
        }
        this.InternalSend();
        dataNotifyService = this;
        synchronized (dataNotifyService) {
            this.bSending = false;
        }
    }

    protected void InternalSend() {
        Vector deDataLogs = new Vector();
        CallResult callResult = BaseDEDataCtrl.SelectMulti((ISRFDAGlobalHelper)this.iDAGlobalHelper, (String)this.strQuerySQL, null, deDataLogs, (String)DEDataLog.class.getName());
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u672a\u5904\u7406\u7684\u6570\u636e\u5f02\u6b65\u901a\u77e5\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        if (deDataLogs.size() == 0) {
            return;
        }
        IDEDataCtrl deDataLogDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0116", "SYSTEM", null);
        if (deDataLogDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0116"));
            return;
        }
        try {
            for (DEDataLog deDataLog : deDataLogs) {
                IDEDataCtrl iDEDataCtrl = deDataLogDataCtrl.GetRelatedDataCtrl(deDataLog.getDEID());
                if (iDEDataCtrl != null) {
                    IDEHelper iDEHelper = iDEDataCtrl.GetDEHelper();
                    BaseDataEntity lastDataEntity = null;
                    BaseDataEntity dataEntity = null;
                    if (!StringHelper.IsNullOrEmpty((String)deDataLog.getOLDDATA())) {
                        lastDataEntity = BaseDataEntity.FromString((String)deDataLog.getOLDDATA());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)deDataLog.getNEWDATA())) {
                        dataEntity = BaseDataEntity.FromString((String)deDataLog.getNEWDATA());
                    }
                    if (iDEHelper.HasDataNotify(deDataLog.getEVENTTYPE(), true)) {
                        Vector list = new Vector();
                        iDEHelper.ListDataNotifies(deDataLog.getEVENTTYPE(), true, list);
                        for (DataNotify dataNotify : list) {
                            iDEHelper.GetDataNotifyHelper(dataNotify).Notify(iDEDataCtrl, dataNotify, lastDataEntity, dataEntity);
                        }
                    }
                    if (deDataLog.getEVENTTYPE() == 4) {
                        String strDEData = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
                        Vector list = iDEHelper.GetDataNotifies();
                        for (DataNotify dataNotify : list) {
                            if (StringHelper.Compare((String)dataNotify.getNOTIFYTYPE(), (String)"TIME", (boolean)true) != 0) continue;
                            iDEHelper.GetDataNotifyHelper(null).RemoveTimeNotify(dataNotify.getDATANOTIFYID(), strDEData);
                        }
                    }
                }
                deDataLogDataCtrl.Remove((BaseDataEntity)deDataLog);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

