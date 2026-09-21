/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DTS;

import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DTS.IPSDEDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEDTSQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDTSQueueImpl
extends PSDataEntityObjectImpl
implements IPSDEDTSQueue,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDTSQueueImpl.class);
    protected PSDEDTSQueue psDEDTSQueue = null;
    private boolean bDefault = false;
    private IPSDEAction confirmPSDEAction = null;
    private IPSDEAction cancelPSDEAction = null;
    private int nCancelTimeout = -1;
    private int nRefreshTimer = -1;
    private IPSDEAction pushPSDEAction = null;
    private IPSDEAction refreshPSDEAction = null;
    private IPSSysDTSQueue iPSSysDTSQueue = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDTSQueue psDEDTSQueue) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.psDEDTSQueue = psDEDTSQueue;
            this.setId(this.psDEDTSQueue.getPSDEDTSQUEUEID());
            this.setName(this.psDEDTSQueue.getPSDEDTSQUEUENAME());
            this.setPSObjectData(this.psDEDTSQueue);
            if (!psDEDTSQueue.isDEFAULTFLAGNull()) {
                this.bDefault = psDEDTSQueue.getDEFAULTFLAG();
            }
            if (!this.psDEDTSQueue.isCANCELTIMEOUTNull() && this.psDEDTSQueue.getCANCELTIMEOUT() > 0) {
                this.nCancelTimeout = this.psDEDTSQueue.getCANCELTIMEOUT();
            }
            if (!this.psDEDTSQueue.isREFRESHTIMERNull() && this.psDEDTSQueue.getREFRESHTIMER() > 0) {
                this.nRefreshTimer = this.psDEDTSQueue.getREFRESHTIMER();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDTSQueue.getCANCELPSDEACTIONID())) {
                this.cancelPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDTSQueue.getCANCELPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDTSQueue.getFINISHPSDEACTIONID())) {
                this.confirmPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDTSQueue.getFINISHPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDTSQueue.getPUSHPSDEACTIONID())) {
                this.pushPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDTSQueue.getPUSHPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDTSQueue.getREFRESHPSDEACTIONID())) {
                this.refreshPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDTSQueue.getREFRESHPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDTSQueue.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psDEDTSQueue.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSSysDTSQueue = this.getPSDataEntity().getPSSystem().getPSSysDTSQueue(this.psDEDTSQueue.getPSDEDTSQUEUEID());
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5f02\u6b65\u5904\u7406\u961f\u5217", ignoredumpvalues="false", group="\u57fa\u672c", order=125, fields={"DEFAULTFLAG"})
    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5f02\u6b65\u5904\u7406\u961f\u5217", dumpref=true)
    public IPSSysDTSQueue getPSSysDTSQueue() {
        return this.iPSSysDTSQueue;
    }

    @Override
    @PSModelRTMeta(description="\u53d6\u6d88\u64cd\u4f5c\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getCancelPSDEAction() {
        return this.cancelPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u786e\u8ba4\u64cd\u4f5c\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getConfirmPSDEAction() {
        return this.confirmPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u53d6\u6d88\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getCancelTimeout() {
        return this.nCancelTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getRefreshTimer() {
        return this.nRefreshTimer;
    }

    @Override
    @PSModelRTMeta(description="\u63a8\u9001\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getPushPSDEAction() {
        return this.pushPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getRefreshPSDEAction() {
        return this.refreshPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getModelType() {
        return "PSDEDTSQUEUE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEDTSQueue.getCODENAME();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }
}

