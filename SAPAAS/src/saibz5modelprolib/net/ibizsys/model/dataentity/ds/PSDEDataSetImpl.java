/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.security.IPSSysUserDR
 *  net.ibizsys.model.service.IPSRESTfulAPI
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSetGroupParam
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSetGroupParam;
import net.ibizsys.model.dataentity.ds.IPSDEDataSetRuntime;
import net.ibizsys.model.dataentity.ds.PSDEDataSetGroupParamImpl;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSDEDSDQ;
import net.ibizsys.model.entity.PSDEDSGroupParam;
import net.ibizsys.model.entity.PSDEDataSet;
import net.ibizsys.model.security.IPSSysUserDR;
import net.ibizsys.model.service.IPSRESTfulAPI;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSetImpl
extends PSDataEntityObjectImpl
implements IPSDEDataSetRuntime,
IPSRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSDEDataSetImpl.class);
    protected PSDEDataSet psDEDataSet = null;
    protected ArrayList<IPSDEDataQuery> psDEDataQueryList = new ArrayList();
    protected ArrayList<IDEDataQuery> deDataQueryList = new ArrayList();
    protected ArrayList<IPSDEDataSetGroupParam> psDEDSGroupParamList = new ArrayList();
    protected ArrayList<IDEDataSetGroupParam> deDSGroupParamList = new ArrayList();
    protected HashMap<String, IPSDEDataSetGroupParam> psDEDSGroupParamMap = new HashMap();
    protected boolean bDefaultMode = false;
    protected String strCodeName = "";
    private boolean bEnableGroup = false;
    private int nGroupTopCount = -1;
    private IPSCodeList iPSCodeList = null;
    private int nExtendMode = 0;
    private String strLogicName = null;
    private boolean bEnableOrgDR = false;
    private boolean bEnableSecDR = false;
    private boolean bEnableSecBC = false;
    private long nOrgDR = 0L;
    private long nSecDR = 0L;
    private String strSecBC = "";
    private boolean bEnableUserDR = false;
    private String strUserDRAction = "READ";
    private String strCustomDRModeParam = "";
    private String strCustomDRMode2Param = "";
    private IPSSysUserDR iPSSysUserDR = null;
    private IPSSysUserDR iPSSysUserDR2 = null;
    private boolean bEnableCache = false;
    private String strCacheScope = null;
    private int nCacheTimeout = -1;
    private IPSDEField majorSortPSDEField = null;
    private IPSDEField minorSortPSDEField = null;
    private String strMajorSortDir = null;
    private String strMinorSortDir = null;
    private int nPageSize = -1;
    private String strRequestPath = null;
    private IPSDELogic activeDataPSDELogic = null;
    private String strRequestMethod = "POST";
    private boolean bEnableTempData = false;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity majorPSDataEntity, PSDEDataSet psDEDataSet) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(majorPSDataEntity);
            this.psDEDataSet = psDEDataSet;
            this.setId(this.psDEDataSet.getPSDEDATASETID());
            this.setName(this.psDEDataSet.getPSDEDATASETNAME());
            this.setPSObjectData(this.psDEDataSet);
            if (!this.psDEDataSet.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEDataSet.getDEFAULTMODE();
            }
            this.strCodeName = this.psDEDataSet.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEDataSet.getPSDEDATASETNAME().toLowerCase();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEDataSet.isENABLEGROUPNull()) {
                this.bEnableGroup = this.psDEDataSet.getENABLEGROUP();
            }
            if (!StringHelper.isNullOrEmpty((String)psDEDataSet.getPSCODELISTID())) {
                this.iPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(psDEDataSet.getPSCODELISTID());
            }
            if (!this.psDEDataSet.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEDataSet.getEXTENDMODE();
            }
            this.strLogicName = this.psDEDataSet.getLOGICNAME();
            if (StringHelper.isNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataSet.getREQUESTPATH())) {
                this.strRequestPath = this.psDEDataSet.getREQUESTPATH();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataSet.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEDataSet.getREQUESTMETHOD();
            }
            if (this.getPSDataEntity().isEnableTempData()) {
                this.bEnableTempData = true;
                if (!this.psDEDataSet.isENABLETEMPDATANull()) {
                    this.bEnableTempData = this.psDEDataSet.getENABLETEMPDATA();
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEDataSet.isENABLEORGDRNull()) {
            this.bEnableOrgDR = this.psDEDataSet.getENABLEORGDR();
            if (this.bEnableOrgDR) {
                this.nOrgDR = this.psDEDataSet.getORGDR();
            }
        }
        if (!this.psDEDataSet.isENABLESECDRNull()) {
            this.bEnableSecDR = this.psDEDataSet.getENABLESECDR();
            if (this.bEnableSecDR) {
                this.nSecDR = this.psDEDataSet.getSECDR();
            }
        }
        if (!this.psDEDataSet.isENABLESECBCNull()) {
            this.bEnableSecBC = this.psDEDataSet.isENABLESECBCNull();
            if (this.bEnableSecBC) {
                this.strSecBC = this.psDEDataSet.getSECBC();
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEDataSet.getMAJORPSDEFID())) {
            this.majorSortPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataSet.getMAJORPSDEFID());
            this.strMajorSortDir = this.psDEDataSet.getMAJORSORTDIR();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEDataSet.getMINORPSDEFID())) {
            this.minorSortPSDEField = this.getPSDataEntity().getPSDEField(this.psDEDataSet.getMINORPSDEFID());
            this.strMinorSortDir = this.psDEDataSet.getMINORSORTDIR();
        }
        if (!this.psDEDataSet.isPAGESIZENull()) {
            this.nPageSize = this.psDEDataSet.getPAGESIZE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEDataSet.getADPSDELOGICID())) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEDataSet.getADPSDELOGICID());
        }
        this.onPreparePSDEDSDQs();
        this.deDataQueryList.clear();
        this.deDataQueryList.addAll(this.psDEDataQueryList);
        this.onPreparePSDEDSGroupParams();
        this.deDSGroupParamList.clear();
        this.deDSGroupParamList.addAll(this.psDEDSGroupParamList);
    }

    protected void onPreparePSDEDSDQs() throws Exception {
        this.psDEDataQueryList.clear();
        Vector<PSDEDSDQ> psDEDSDQList = new Vector<PSDEDSDQ>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDSDQs(this.getId(), psDEDSDQList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u67e5\u8be2\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        IPSDEDataQuery lastPSDEDataQuery = null;
        for (PSDEDSDQ psDEDSDQ : psDEDSDQList) {
            IPSDEDataQuery iPSDEDataQuery = this.getPSDataEntity().getPSDEDataQuery(psDEDSDQ.getPSDEDQID());
            if (lastPSDEDataQuery == null) {
                lastPSDEDataQuery = iPSDEDataQuery;
            } else if (iPSDEDataQuery.getViewLevel() != lastPSDEDataQuery.getViewLevel()) {
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u6570\u636e\u67e5\u8be2[%1$s]\u5b58\u5728\u89c6\u56fe\u5217\u7ea7\u522b\u4e0d\u4e00\u81f4\u60c5\u51b5", (Object)iPSDEDataQuery.getName()));
            }
            this.psDEDataQueryList.add(iPSDEDataQuery);
        }
    }

    protected void onPreparePSDEDSGroupParams() throws Exception {
        this.psDEDSGroupParamList.clear();
        Vector<PSDEDSGroupParam> psDEDSGroupParamList = new Vector<PSDEDSGroupParam>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEDSGroupParams(this.getId(), psDEDSGroupParamList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5206\u7ec4\u53c2\u6570\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEDSGroupParam psDEDSGroupParam : psDEDSGroupParamList) {
            PSDEDataSetGroupParamImpl iPSDEDSGroupParam = new PSDEDataSetGroupParamImpl();
            iPSDEDSGroupParam.init(this.getPSModelStorageContext(), this, psDEDSGroupParam);
            this.psDEDSGroupParamList.add(iPSDEDSGroupParam);
            this.psDEDSGroupParamMap.put(iPSDEDSGroupParam.getName().toLowerCase(), iPSDEDSGroupParam);
        }
    }

    @PSModelRTMeta(description="\u6570\u636e\u96c6\u67e5\u8be2\u96c6\u5408", hideempty2=true)
    public Iterator<IPSDEDataQuery> getPSDEDataQueries() {
        if (this.psDEDataQueryList.size() == 0) {
            return null;
        }
        return this.psDEDataQueryList.iterator();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    public Iterator<IDEDataQuery> getDEDataQueries() throws Exception {
        return this.deDataQueryList.iterator();
    }

    public Iterator<IDEDataSetQuery> getDEDataSetQueries() {
        return null;
    }

    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4")
    public boolean isEnableGroup() {
        if (StringHelper.isNullOrEmpty((String)this.getPredefinedType())) {
            return this.bEnableGroup;
        }
        return false;
    }

    public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams() {
        return this.deDSGroupParamList.iterator();
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5206\u7ec4\u53c2\u6570\u7ed3\u5408", hideempty=true)
    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams() {
        return this.psDEDSGroupParamList.iterator();
    }

    public IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String strName, boolean bTry) throws Exception {
        IPSDEDataSetGroupParam iPSDEDataSetGroupParam = this.psDEDSGroupParamMap.get(strName = strName.toLowerCase());
        if (iPSDEDataSetGroupParam == null && !bTry) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u96c6\u5408\u5206\u7ec4\u53c2\u6570\uff0c\u6807\u8bc6\u4e3a[%1$s]", (Object)strName));
        }
        return iPSDEDataSetGroupParam;
    }

    public int getGroupTopCount() {
        return -1;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.strLogicName;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public boolean isEnableOrgDR() {
        return this.bEnableOrgDR;
    }

    public boolean isEnableSecDR() {
        return this.bEnableSecDR;
    }

    public boolean isEnableSecBC() {
        return this.bEnableSecBC;
    }

    public long getOrgDR() {
        return this.nOrgDR;
    }

    public long getSecDR() {
        return this.nSecDR;
    }

    public String getSecBC() {
        return this.strSecBC;
    }

    public boolean isEnableUserDR() {
        return this.bEnableUserDR;
    }

    public String getUserDRAction() {
        return this.strUserDRAction;
    }

    public String getPredefinedType() {
        return this.psDEDataSet.getPREDEFINETYPE();
    }

    public boolean isEnableCache() {
        return this.bEnableCache;
    }

    public String getCacheScope() {
        return this.strCacheScope;
    }

    public int getCacheTimeout() {
        return this.nCacheTimeout;
    }

    public String getMajorSortField() {
        return this.strMajorSortDir;
    }

    public String getMajorSortDir() {
        if (this.getMajorSortPSDEField() != null) {
            return this.getMajorSortPSDEField().getName();
        }
        return null;
    }

    public String getMinorSortField() {
        if (this.getMinorSortPSDEField() != null) {
            return this.getMinorSortPSDEField().getName();
        }
        return null;
    }

    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    public int getPageSize() {
        return this.nPageSize;
    }

    @PSModelRTMeta(description="\u4e3b\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMajorSortPSDEField() {
        return this.majorSortPSDEField;
    }

    @PSModelRTMeta(description="\u4ece\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEField() {
        return this.minorSortPSDEField;
    }

    public String getRequestPath() {
        return this.strRequestPath;
    }

    public String getRequestMethod() {
        return this.strRequestMethod;
    }

    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    public String getActiveDataDELogicId() {
        if (this.getActiveDataPSDELogic() != null) {
            return this.getActiveDataPSDELogic().getId();
        }
        return null;
    }

    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e")
    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    public String getCustomDRMode() {
        return null;
    }

    public String getCustomDRMode2() {
        return null;
    }

    public String getCustomDRModeParam() {
        return null;
    }

    public String getCustomDRMode2Param() {
        return null;
    }

    public String getCacheUniStateId() {
        return null;
    }

    public String getCacheUniStateDELogicId() {
        return null;
    }

    public String getCacheHookState() {
        return null;
    }
}

