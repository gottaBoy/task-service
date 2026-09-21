/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.psba.core.IBATable
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BA;

import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.BA.IPSSysBDTableDE;
import SA.SRFDA.PS.Core.BA.PSSysBDTableObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysBDTableDE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.psba.core.IBATable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBDTableDEImpl
extends PSSysBDTableObjectImpl
implements IPSSysBDTableDE {
    private static final Log log = LogFactory.getLog(PSSysBDTableDEImpl.class);
    protected PSSysBDTableDE psSysBDTableDE = null;
    private IPSDataEntity iPSDataEntity = null;
    private int nBATableDEType = 1;
    private String strRowKeyFormat = null;
    private String strRowKeyParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBDTable iPSSysBDTable, PSSysBDTableDE psSysBDTableDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBDTable(iPSSysBDTable);
            this.psSysBDTableDE = psSysBDTableDE;
            this.setId(this.psSysBDTableDE.getPSSYSBDTABLEDEID());
            this.setName(this.psSysBDTableDE.getPSSYSBDTABLEDENAME());
            this.setPSObjectData(this.psSysBDTableDE);
            if (!this.psSysBDTableDE.isDEFAULTFLAGNull()) {
                this.nBATableDEType = this.psSysBDTableDE.GetParamIntValue("DEFAULTFLAG", 0);
            }
            this.iPSDataEntity = this.getPSSysBDScheme().getPSSystem().getPSDataEntity2(this.psSysBDTableDE.getPSDEID());
            this.strRowKeyFormat = this.psSysBDTableDE.getROWKEYFORMAT();
            this.strRowKeyParams = this.psSysBDTableDE.getROWKEYPARAMS();
            if (StringHelper.IsNullOrEmpty((String)this.strRowKeyFormat) || StringHelper.IsNullOrEmpty((String)this.strRowKeyParams)) {
                this.strRowKeyFormat = null;
                this.strRowKeyParams = null;
                if (this.iPSSysBDTable.getBATableType() == 3 && this.nBATableDEType == 3 && !StringHelper.IsNullOrEmpty((String)this.iPSSysBDTable.getPickupDEFName())) {
                    this.strRowKeyFormat = "%1$s" + this.getPSSysBDScheme().getRowKeySeparator() + "%2$s";
                    this.strRowKeyParams = String.valueOf(this.iPSDataEntity.getKeyPSDEField().getName()) + ";" + this.iPSSysBDTable.getPickupDEFName();
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSBDTABLEDE";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public IBATable getBATable() {
        return this.getPSSysBDTable();
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    public int getBATableDEType() {
        return this.nBATableDEType;
    }

    public String getBAColSetName() {
        return this.psSysBDTableDE.getPSSYSBDCOLSETNAME();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u952e\u503c\u683c\u5f0f\u5316", hideempty2=true)
    public String getRowKeyFormat() {
        return this.strRowKeyFormat;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u952e\u503c\u53c2\u6570", hideempty2=true)
    public String getRowKeyParams() {
        return this.strRowKeyParams;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u8868\u5b9e\u4f53\u7c7b\u578b", codelist="BDTableDEType")
    public int getBDTableDEType() {
        return this.nBATableDEType;
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSSysBDTable().getModelId(), (Object)super.getModelId());
    }
}

