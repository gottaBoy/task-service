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
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBSPPartTempl;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcTempl;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSDBSysProcCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.PSDBCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSDEFColumnMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSDEFSPParamMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSDEFieldMethod;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Data.PSDBSysProcTempl;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.PS.Data.PSDEDBSysProcCode;
import SA.SRFDA.PS.Data.PSDEDBSysProcCodePart;
import SA.SRFDA.PS.Data.PSDEDBSysProcField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public abstract class PSDBSysProcCodePublisherImpl
extends PSDBCodePublisherImpl
implements IPSDBSysProcCodePublisher {
    private static final Log log = LogFactory.getLog(PSDBSysProcCodePublisherImpl.class);
    protected IPSDBType iPSDBType = null;
    protected IPSDBSysProcTempl iPSDBSysProcTempl = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSSystem iPSSystem = null;
    protected IPSDataEntity iPSDataEntity = null;
    protected PSDEDBSysProc psDESysProc = null;
    protected PSDEFieldMethod psDEFieldMethod = null;
    protected PSDEFColumnMethod psDEFColumnMethod = null;
    protected PSDEFSPParamMethod psDEFSPParamMethod = null;
    protected ArrayList<IPSDEFDTColumn> defieldParamList = new ArrayList();
    protected ArrayList<IPSDEFDTColumn> defieldDeclareList = new ArrayList();
    protected HashMap<String, String> defieldParamMap = new HashMap();
    protected HashMap<String, IPSDEFDTColumn> defieldParamMap2 = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDBSysProcTempl iPSDBSysProcTempl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSDBSysProcTempl = iPSDBSysProcTempl;
        this.iPSDBType = this.iPSDBSysProcTempl.getPSDBType();
        this.onInit();
    }

    protected String getDBType() {
        return this.iPSDBType.getId();
    }

    protected IPSDBType getPSDBTyp() {
        return this.iPSDBType;
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, PSDEDBSysProc psDESysProc) throws Exception {
        this.psDESysProc = psDESysProc;
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSDataEntity = this.getPSModelStorage().getPSDataEntity(psDESysProc.getPSDEID());
        this.iPSSystem = this.iPSDataEntity.getPSSystem();
        IDEDataCtrl psDEDBProcFieldDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2074");
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDESYSPROCID", (Object)psDESysProc.getPSDESYSPROCID());
        Vector psDEDBSysProcFieldList = new Vector();
        CallResult callResult = psDEDBProcFieldDataCtrl.Select(cond, psDEDBSysProcFieldList, PSDEDBSysProcField.class.getName(), "", "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u5c5e\u6027\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        IDEDataCtrl psDEDBProcCodePartDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2073");
        cond.Reset();
        cond.setParamValue("PSDESYSPROCID", (Object)psDESysProc.getPSDESYSPROCID());
        Vector psDEDBSysProcCodePartList = new Vector();
        callResult = psDEDBProcCodePartDataCtrl.Select(cond, psDEDBSysProcCodePartList, PSDEDBSysProcCodePart.class.getName(), "", "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u7ec4\u6210\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDBSysProcField psDEDBSysProcField : psDEDBSysProcFieldList) {
            if (psDEDBSysProcField.getPROCPARAM()) {
                IPSDEFDTColumn iPSDEFDTColumn = this.iPSDataEntity.getPSDEField(psDEDBSysProcField.getPSDEFID(), false).getPSDTColumn(this.iPSDBType.getId());
                this.defieldParamList.add(iPSDEFDTColumn);
                this.defieldParamMap.put(psDEDBSysProcField.getPSDEFNAME().toUpperCase(), StringHelper.Format((String)"VAR_%1$s", (Object)psDEDBSysProcField.getPSDEFNAME()).toUpperCase());
                this.defieldParamMap2.put(psDEDBSysProcField.getPSDEFNAME().toUpperCase(), iPSDEFDTColumn);
            }
            if (!psDEDBSysProcField.getDECLAREPARAM()) continue;
            this.defieldDeclareList.add(this.iPSDataEntity.getPSDEField(psDEDBSysProcField.getPSDEFID(), false).getPSDTColumn(this.iPSDBType.getId()));
            this.defieldParamMap.put(psDEDBSysProcField.getPSDEFNAME().toUpperCase(), StringHelper.Format((String)"VAREX_%1$s", (Object)psDEDBSysProcField.getPSDEFNAME()).toUpperCase());
        }
        if (!this.defieldParamMap.containsKey(this.iPSDataEntity.getKeyPSDEField().getName())) {
            this.defieldParamList.add(this.iPSDataEntity.getPSDEField(this.iPSDataEntity.getKeyPSDEField().getId(), false).getPSDTColumn(this.iPSDBType.getId()));
            this.defieldParamMap.put(this.iPSDataEntity.getKeyPSDEField().getName().toUpperCase(), StringHelper.Format((String)"VAR_%1$s", (Object)this.iPSDataEntity.getKeyPSDEField().getName()).toUpperCase());
        }
        this.psDEFieldMethod = new PSDEFieldMethod(this.iPSDataEntity);
        this.psDEFColumnMethod = new PSDEFColumnMethod(this.iPSDataEntity, this.iPSDBType);
        this.psDEFSPParamMethod = new PSDEFSPParamMethod(this.defieldParamMap);
        this.onGenerateCode();
    }

    protected abstract void onGenerateCode() throws Exception;

    protected IPSGenerateCodeResult generateCode(String strType, Object obj, HashMap<String, Object> params2) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("item", obj);
        params.put("sys", this.iPSSystem);
        params.put("de", this.iPSDataEntity);
        params.put("db", this.iPSDBType);
        params.put("procname", this.psDESysProc.getPSDESYSPROCNAME());
        if (params2 != null) {
            params.putAll(params2);
        }
        this.onFillGenerateCodeParams(strType, obj, params);
        String strPSDBSPPartTemplId = Helper.GenUniqueId((String)this.iPSDBSysProcTempl.getId(), (String)strType);
        IPSDBSPPartTempl iPSDBSPPartTempl = this.iPSDBSysProcTempl.getPSDBSPPartTempl(strPSDBSPPartTemplId);
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(obj);
        psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)iPSDBSPPartTempl.getPSDBSPPartTemplData(), "TEMPLCODE", params));
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        params.put("def", this.psDEFieldMethod);
        params.put("defcol", this.psDEFColumnMethod);
        params.put("defparam", this.psDEFSPParamMethod);
        params.put("defparams", this.defieldParamList);
        params.put("defdelares", this.defieldDeclareList);
        params.put("defields", this.defieldParamMap.keySet());
    }

    protected void savePSDESysProcCode(Object obj, PSDEDBSysProcCode psDESysProcCodeSrc, HashMap<String, Object> params2) throws Exception {
        PSDEDBSysProcCode psDESysProcCode = new PSDEDBSysProcCode();
        psDESysProcCode.setPSDEID(this.iPSDataEntity.getId());
        psDESysProcCode.setPSDESPCODENAME(this.iPSDBType.getId());
        psDESysProcCode.setPSDESYSPROCID(this.psDESysProc.getPSDESYSPROCID());
        psDESysProcCode.setPSDESYSPROCNAME(this.psDESysProc.getPSDESYSPROCNAME());
        if (psDESysProcCodeSrc != null) {
            psDESysProcCodeSrc.CopyTo(psDESysProcCode, false);
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("item", obj);
        params.put("sys", this.iPSSystem);
        params.put("de", this.iPSDataEntity);
        params.put("procname", this.psDESysProc.getPSDESYSPROCNAME());
        params.put("db", this.iPSDBType);
        if (params2 != null) {
            params.putAll(params2);
        }
        this.onFillGenerateCodeParams("", obj, params);
        PSDBSysProcTempl psDBSysProcTempl = this.iPSDBSysProcTempl.getPSDBSysProcTemplData();
        String strPubCode = PSTemplHelper.generateCode((BaseDataEntity)psDBSysProcTempl, "CODETEMPL", params);
        psDESysProcCode.setFULLCODE(strPubCode);
        psDESysProcCode.setCOMPILEFLAG(99);
        IDEDataCtrl iPSDESysProcCodeDataCtrl = this.iPSPublisherContext.getDEDataCtrl("DE2072");
        CallResult callResult = iPSDESysProcCodeDataCtrl.AutoSave((BaseDataEntity)psDESysProcCode);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b58\u50a8\u8fc7\u7a0b\u4ee3\u7801\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (iPSDESysProcCodeDataCtrl.getTransactionManager() != null) {
            iPSDESysProcCodeDataCtrl.getTransactionManager().CommitAndBegin();
        }
    }

    protected IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    protected void onClose() {
        this.defieldParamList.clear();
        this.defieldDeclareList.clear();
        this.defieldParamMap.clear();
        this.psDEFSPParamMethod = null;
        this.psDEFieldMethod = null;
        this.psDEFColumnMethod = null;
        this.iPSPublisherContext = null;
        this.iPSDataEntity = null;
        this.iPSSystem = null;
        super.onClose();
        this.iPSDBSysProcTempl.releasePSDBSysProcCodePublisher(this);
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDBSysProcTempl.getPSSysModelInstId();
    }
}

