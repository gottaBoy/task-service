/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDESysProcPublisher;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSDBSysProcPublisherImpl
extends PSObjectImpl
implements IPSDESysProcPublisher {
    private static final Log log = LogFactory.getLog(PSDBSysProcPublisherImpl.class);
    protected IPSDBType iPSDBType = null;
    protected IPSDataEntity iPSDataEntity = null;
    protected String strProcType = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected PSDEDBSysProcCode psDESysProcCode = null;
    protected boolean bDALog = false;
    protected String strProcName = "";
    protected String strDBSCHEMA = "";
    protected IPSDEDBConfig iPSDEDBConfig = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType, IPSDataEntity iPSDataEntity, String strProcType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDBType = iPSDBType;
        this.iPSDataEntity = iPSDataEntity;
        this.strProcType = strProcType;
        this.iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSDBType.getId());
        this.onInit();
    }

    protected IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected IPSDBType getPSDBType() {
        return this.iPSDBType;
    }

    protected String getDBType() {
        return this.iPSDBType.getId();
    }

    protected String getProcType() {
        return this.strProcType;
    }

    @Override
    public void publish(IPSPublisherContext iPSPublisherContext) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.onPreparePublish();
        this.onPublish();
        this.onFinishPublish();
    }

    protected void onPreparePublish() throws Exception {
        this.psDESysProcCode = new PSDEDBSysProcCode();
        String strProcId = Helper.GenUniqueId((String)this.getPSDataEntity().getId(), (String)this.strProcType);
        String strDESysProcCodeId = Helper.GenUniqueId((String)strProcId, (String)this.getDBType());
        this.psDESysProcCode.setPSDESPCODEID(strDESysProcCodeId);
        this.psDESysProcCode.setPSDESPCODENAME(this.getDBType());
        IDEDataCtrl psDESysProcCodeDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2072");
        CallResult callResult = psDESysProcCodeDataCtrl.Get((BaseDataEntity)this.psDESysProcCode);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        this.strProcName = this.psDESysProcCode.getPSDESYSPROCNAME();
    }

    protected void onPublish() throws Exception {
    }

    protected void onFinishPublish() throws Exception {
        IDEDataCtrl psDESysProcCodeDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2072");
        CallResult callResult = psDESysProcCodeDataCtrl.AutoSave((BaseDataEntity)this.psDESysProcCode);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }
}

