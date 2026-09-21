/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataImport
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataImport;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImportItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImportItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEDataImportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataImportItemImpl
extends PSObjectImpl
implements IPSDEDataImportItem,
IPSAppDEDataImportItem {
    private static final Log log = LogFactory.getLog(PSDEDataImportItemImpl.class);
    private IPSDEDataImport iPSDEDataImport = null;
    private PSDEDataImportItem psDEDataImportItem = null;
    private String strCaption = "";
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSDEField iPSDEField = null;
    private boolean bUniqueItem = false;
    private boolean bHiddenDataItem = false;
    private String strCreateDVT = "";
    private String strCreateDV = "";
    private String strUpdateDVT = "";
    private String strUpdateDV = "";
    private IPSCodeList iPSCodeList = null;
    private IPSAppDEField iPSAppDEField = null;
    private int nOrderValue = 99999;
    private IPSSysTranslator iPSSysTranslator = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataImport iPSDEDataImport, PSDEDataImportItem psDEDataImportItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataImport = iPSDEDataImport;
            this.psDEDataImportItem = psDEDataImportItem;
            this.setId(this.psDEDataImportItem.getPSDEDATAIMPITEMID());
            this.setName(this.psDEDataImportItem.getPSDEDATAIMPITEMNAME());
            this.setPSObjectData(this.psDEDataImportItem);
            this.strCaption = this.psDEDataImportItem.getCAPTION();
            if (!this.psDEDataImportItem.isKEYFLAGNull()) {
                this.bUniqueItem = this.psDEDataImportItem.getKEYFLAG();
            }
            IPSAppDataEntity iPSAppDataEntity = null;
            if (iPSDEDataImport instanceof IPSAppDEDataImport) {
                iPSAppDataEntity = ((IPSAppDEDataImport)iPSDEDataImport).getPSAppDataEntity();
            }
            this.iPSDEField = this.getPSDEDataImport().getPSDataEntity().getPSDEField(this.psDEDataImportItem.getPSDEFID(), false);
            if (iPSAppDataEntity != null) {
                this.iPSAppDEField = iPSAppDataEntity.getPSAppDEField(this.iPSDEField, true);
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
                this.strCaption = this.iPSDEField.getImportTag();
                if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
                    this.strCaption = this.iPSDEField.getLogicName();
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImportItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDEDataImport().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDataImportItem.getCAPPSLANRESID());
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strCaption, (String)this.iPSDEField.getLogicName(), (boolean)false) == 0) {
                this.capPSLanguageRes = this.iPSDEField.getLNPSLanguageRes();
            }
            if (!psDEDataImportItem.isHIDDENDATAITEMNull()) {
                this.bHiddenDataItem = psDEDataImportItem.getHIDDENDATAITEM();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImportItem.getPSCODELISTID())) {
                this.iPSCodeList = iPSAppDataEntity != null ? iPSAppDataEntity.getPSApplication().getPSAppCodeList(this.psDEDataImportItem.getPSCODELISTID()) : this.getPSDEDataImport().getPSDataEntity().getPSSystem().getPSCodeList(this.psDEDataImportItem.getPSCODELISTID());
            }
            if (this.getPSCodeList() == null) {
                this.iPSCodeList = this.getPSDEField().getPSCodeList();
                if (this.iPSCodeList != null && iPSAppDataEntity != null) {
                    this.iPSCodeList = iPSAppDataEntity.getPSApplication().getPSAppCodeList(this.iPSCodeList.getId());
                }
            }
            this.strCreateDVT = this.psDEDataImportItem.getCREATEDVT();
            this.strCreateDV = this.psDEDataImportItem.getCREATEDV();
            this.strUpdateDVT = this.psDEDataImportItem.getUPDATEDVT();
            this.strUpdateDV = this.psDEDataImportItem.getUPDATEDV();
            if (!this.psDEDataImportItem.isORDERVALUENull()) {
                this.nOrderValue = this.psDEDataImportItem.getORDERVALUE();
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
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataImport().getPSSysModelInstId();
    }

    public IDEDataImport getDEDataImport() {
        return this.getPSDEDataImport();
    }

    @Override
    public IPSDEDataImport getPSDEDataImport() {
        return this.iPSDEDataImport;
    }

    public String getDEFName() {
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bc6\u522b\u9879", ignoredumpvalues="false", fields={"KEYFLAG"})
    public boolean isUniqueItem() {
        return this.bUniqueItem;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", ignorepf=true, dumpref=true, from="IPSDataEntity", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    public IDEField getDEField() {
        return this.getPSDEField();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataImport().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDataImport().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u6570\u636e\u9879", ignoredumpvalues="false", fields={"HIDDENDATAITEM"})
    public boolean isHiddenDataItem() {
        return this.bHiddenDataItem;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"CREATEDVT"})
    public String getCreateDVT() {
        return this.strCreateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u9ed8\u8ba4\u503c", fields={"CREATEDV"})
    public String getCreateDV() {
        return this.strCreateDV;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="FieldDefaultValueType", fields={"UPDATEDVT"})
    public String getUpdateDVT() {
        return this.strUpdateDVT;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u9ed8\u8ba4\u503c", fields={"UPDATEDV"})
    public String getUpdateDV() {
        return this.strUpdateDV;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    public String getModelType() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDataImport().getModelType(), (String)"PSAPPDEDATAIMP", (boolean)true) == 0) {
            return "PSAPPDEDATAIMPITEM";
        }
        return "PSDEDATAIMPITEM";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataImport().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity", fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6b21\u5e8f", ignoredumpvalues="99999", fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668", ignorepf=true, dumpref=true)
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImportItem.getPSSYSTRANSLATORID())) {
            if (this.iPSSysTranslator == null) {
                this.iPSSysTranslator = this.getPSDEDataImport().getPSDataEntity().getPSSystem().getPSSysTranslator(this.psDEDataImportItem.getPSSYSTRANSLATORID());
            }
            return this.iPSSysTranslator;
        }
        return this.getPSDEField().getImportPSSysTranslator();
    }
}

