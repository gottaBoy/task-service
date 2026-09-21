/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DS;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQEngine;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDSCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.PSDBCodePublisherImpl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Data.PSDEDataSetCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDSCodePublisherImpl
extends PSDBCodePublisherImpl
implements IPSDEDSCodePublisher {
    private static final Log log = LogFactory.getLog(PSDEDSCodePublisherImpl.class);
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSDEDataSet iPSDEDataSet = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBType iPSDBType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDBType(iPSDBType);
        this.onInit();
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSDEDataSet = iPSDEDataSet;
        this.onGenerateCode();
    }

    protected void onGenerateCode() throws Exception {
        String strQueryCode = "";
        if (this.iPSDEDataSet.getPSDEDataQueries() != null) {
            Iterator<IPSDEDataQuery> psDEDataQueries = this.iPSDEDataSet.getPSDEDataQueries();
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                IPSDEDQEngine iPSDEDQEngine = iPSDEDataQuery.getPSDEDQEngine(this.getPSDBType().getId());
                if (StringHelper.IsNullOrEmpty((String)strQueryCode)) {
                    strQueryCode = String.valueOf(strQueryCode) + "\r\nUNION\r\n";
                }
                strQueryCode = iPSDEDQEngine.getQueryScript();
            }
        } else {
            strQueryCode = "";
        }
        PSDEDataSetCode psDEDataSetCode = new PSDEDataSetCode();
        psDEDataSetCode.setPSDEDATASETID(this.iPSDEDataSet.getId());
        psDEDataSetCode.setDBTYPE(this.getPSDBType().getId());
        psDEDataSetCode.setPSDEDSCODENAME(this.getPSDBType().getName());
        psDEDataSetCode.setQUERYCODE(strQueryCode);
        IDEDataCtrl psDEDataSetCodeDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2062");
        CallResult callResult = psDEDataSetCodeDataCtrl.AutoSave((BaseDataEntity)psDEDataSetCode);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b9e\u4f53\u6570\u636e\u96c6\u5408\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public void close() {
        this.iPSPublisherContext = null;
        this.iPSDEDataSet = null;
        this.onClose();
        this.getPSDBType().releasePSDEDSCodePublisher(this);
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSDEDataSet != null) {
            return this.iPSDEDataSet.getPSSysModelInstId();
        }
        return null;
    }
}

