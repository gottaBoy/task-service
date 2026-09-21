/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQuery
 *  net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode
 *  net.ibizsys.model.service.IPSRESTfulAPI
 *  net.ibizsys.paas.core.IDEDataQueryCode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.ds;

import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.PSDataEntityObjectImpl;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQueryCodeRuntime;
import net.ibizsys.model.dataentity.ds.PSDEDataQueryCodeGlobalModel;
import net.ibizsys.model.entity.PSDEDataQuery;
import net.ibizsys.model.service.IPSRESTfulAPI;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataQueryImpl
extends PSDataEntityObjectImpl
implements IPSDEDataQuery,
IPSRESTfulAPI {
    private static final Log log = LogFactory.getLog(PSDEDataQueryImpl.class);
    protected PSDEDataQuery psDEDataQuery = null;
    protected PSDEDataQueryCodeGlobalModel psDEDataQueryCodeGlobalModel = new PSDEDataQueryCodeGlobalModel();
    private String strCodeName = "";
    private boolean bCustomCode = false;
    private boolean bPrivQuery = false;
    private int nExtendMode = 0;
    private String strLogicName = "";
    private boolean bDefaultMode = false;
    private int nViewLevel = -1;
    private boolean bPubFlag = false;
    private String strRequestPath = null;
    private String strRequestMethod = "POST";
    private boolean bQueryFromView = false;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity majorPSDataEntity, PSDEDataQuery psDEDataQuery) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDataEntity(majorPSDataEntity);
            this.psDEDataQuery = psDEDataQuery;
            this.setId(this.psDEDataQuery.getPSDEDATAQUERYID());
            this.setName(this.psDEDataQuery.getPSDEDATAQUERYNAME());
            this.setPSObjectData(this.psDEDataQuery);
            this.psDEDataQueryCodeGlobalModel.init(iPSModelStorageContext, this);
            this.strCodeName = this.psDEDataQuery.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEDataQuery.getPSDEDATAQUERYNAME().toLowerCase();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!this.psDEDataQuery.isCUSTOMMODENull()) {
                this.bCustomCode = this.psDEDataQuery.getCUSTOMMODE();
            }
            if (!this.psDEDataQuery.isPRIVMODENull()) {
                this.bPrivQuery = this.psDEDataQuery.getPRIVMODE();
            }
            if (!this.psDEDataQuery.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEDataQuery.getEXTENDMODE();
            }
            if (!this.psDEDataQuery.isDEFAULTMODENull()) {
                this.bDefaultMode = this.psDEDataQuery.getDEFAULTMODE();
            }
            this.strLogicName = this.psDEDataQuery.getLOGICNAME();
            if (StringHelper.isNullOrEmpty((String)this.strLogicName)) {
                this.strLogicName = this.getName();
            }
            if (!this.psDEDataQuery.isVIEWCOLLEVELNull()) {
                this.nViewLevel = this.psDEDataQuery.getVIEWCOLLEVEL();
            }
            if (!this.psDEDataQuery.isQUERYVIEWFLAGNull()) {
                this.bQueryFromView = this.psDEDataQuery.getQUERYVIEWFLAG();
            }
            if (!this.psDEDataQuery.isPUBMODENull()) {
                this.bPubFlag = this.psDEDataQuery.getPUBMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataQuery.getREQUESTPATH())) {
                this.strRequestPath = this.psDEDataQuery.getREQUESTPATH();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEDataQuery.getREQUESTMETHOD())) {
                this.strRequestMethod = this.psDEDataQuery.getREQUESTMETHOD();
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
        this.loadAll();
        super.onInit();
    }

    public IPSDEDataQueryCode getPSDEDataQueryCode(String strDBType) throws Exception {
        String strPSDEDQCodeId = KeyValueHelper.genUniqueId((String)this.getId(), (String)strDBType);
        return (IPSDEDataQueryCode)this.psDEDataQueryCodeGlobalModel.findModelHelper(strPSDEDQCodeId);
    }

    public Iterator<IPSDEDataQueryCode> getAllPSDEDataQueryCodes() throws Exception {
        return this.psDEDataQueryCodeGlobalModel.getAllModelHelpers();
    }

    public IDEDataQueryCode getDEDataQueryCode(String strDBType) throws Exception {
        return this.getPSDEDataQueryCode(strDBType);
    }

    public void loadAll() throws Exception {
        Iterator<IPSDEDataQueryCode> psDEDataQueryCodes = this.getAllPSDEDataQueryCodes();
        while (psDEDataQueryCodes.hasNext()) {
            IPSDEDataQueryCode iPSDEDataQueryCode = psDEDataQueryCodes.next();
            ((IPSDEDataQueryCodeRuntime)iPSDEDataQueryCode).loadAll();
        }
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u67e5\u8be2")
    public boolean isDefaultMode() {
        return this.bDefaultMode;
    }

    @PSModelRTMeta(description="\u9009\u62e9\u5217\u7ea7\u522b", codelist="DEFieldViewColLevel")
    public int getViewLevel() {
        return this.nViewLevel;
    }

    public String getRequestPath() {
        return this.strRequestPath;
    }

    public String getRequestMethod() {
        return this.strRequestMethod;
    }
}

