/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.core.IDEDataImportItem
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataImport;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImport;
import SA.SRFDA.PS.Core.DataEntity.DataImport.IPSDEDataImportItem;
import SA.SRFDA.PS.Core.DataEntity.DataImport.PSDEDataImportItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEDataImport;
import SA.SRFDA.PS.Data.PSDEDataImportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDEDataImportItem;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataImportImpl
extends PSDataEntityObjectImpl
implements IPSDEDataImport,
IPSAppDEDataImport,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataImportImpl.class);
    protected PSDEDataImport psDEDataImport;
    protected ArrayList<IPSDEDataImportItem> psDEDataImportItemList = new ArrayList();
    protected ArrayList<IDEDataImportItem> deDataImportItemList = new ArrayList();
    protected String strCodeName = "";
    private IPSDEAction createPSDEAction = null;
    private IPSDEAction updatePSDEAction = null;
    private boolean bDefault = false;
    private boolean bIgnoreError = false;
    private IPSDEOPPriv createPSDEOPPriv = null;
    private IPSDEOPPriv updatePSDEOPPriv = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppDEAction createPSAppDEAction = null;
    private IPSAppDEAction updatePSAppDEAction = null;
    private int nActionHolder = 3;
    private boolean bCustomActionHolder = false;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private int nBatchSize = 1000;
    private int nPOTime = -1;
    private boolean bValid = true;
    private Properties impParams = null;
    private boolean bEnableCustomized = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppDataEntity iPSAppDataEntity, PSDEDataImport psDEDataImport) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.init(iDAGlobalHelper, this.iPSAppDataEntity.getPSDataEntity(), psDEDataImport);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDataImport psDEDataImport) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEDataImport = psDEDataImport;
            this.setId(psDEDataImport.getPSDEDATAIMPID());
            this.setName(psDEDataImport.getPSDEDATAIMPNAME());
            this.setPSObjectData(this.psDEDataImport);
            this.strCodeName = this.psDEDataImport.getCODENAME();
            if (!this.psDEDataImport.isDEFAULTFLAGNull()) {
                this.bDefault = this.psDEDataImport.getDEFAULTFLAG();
            }
            if (!this.psDEDataImport.isSTOPWHENERRORNull()) {
                boolean bl = this.bIgnoreError = !this.psDEDataImport.getSTOPWHENERROR();
            }
            if (!this.psDEDataImport.isBATCHSIZENull()) {
                this.nBatchSize = this.psDEDataImport.getBATCHSIZE();
            }
            if (this.nBatchSize <= 0) {
                this.nBatchSize = 1000;
            }
            if (!this.psDEDataImport.isACTIONHOLDERNull()) {
                this.nActionHolder = this.psDEDataImport.getACTIONHOLDER();
                this.bCustomActionHolder = true;
            }
            this.createPSDEAction = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getCREATEPSDEACTIONID()) ? this.getPSDataEntity().getPSDEAction(this.psDEDataImport.getCREATEPSDEACTIONID()) : this.getPSDataEntity().getPSDEAction("CREATE", true);
            this.updatePSDEAction = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getUPDATEPSDEACTIONID()) ? this.getPSDataEntity().getPSDEAction(this.psDEDataImport.getUPDATEPSDEACTIONID()) : this.getPSDataEntity().getPSDEAction("UPDATE", true);
            this.createPSDEOPPriv = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getCREATEPSDEOPPRIVID()) ? this.getPSDataEntity().getPSDEOPPriv(this.psDEDataImport.getCREATEPSDEOPPRIVID()) : this.getPSDataEntity().getPSDEOPPriv("CREATE", true);
            this.updatePSDEOPPriv = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getUPDATEPSDEOPPRIVID()) ? this.getPSDataEntity().getPSDEOPPriv(this.psDEDataImport.getUPDATEPSDEOPPRIVID()) : this.getPSDataEntity().getPSDEOPPriv("UPDATE", true);
            if (this.getPSAppDataEntity() != null) {
                if (this.getCreatePSDEAction() != null) {
                    this.createPSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getCreatePSDEAction(), true);
                }
                if (this.getUpdatePSDEAction() != null) {
                    this.updatePSAppDEAction = this.getPSAppDataEntity().getPSAppDEAction(this.getUpdatePSDEAction(), true);
                }
            }
            if (!this.psDEDataImport.isPOTIMENull() && this.psDEDataImport.getPOTIME() > 0) {
                this.nPOTime = this.psDEDataImport.getPOTIME();
            }
            if (!this.psDEDataImport.isVALIDFLAGNull()) {
                this.bValid = this.psDEDataImport.getVALIDFLAG();
            }
            if (!this.psDEDataImport.isENABLECUSTOMIZEDNull()) {
                this.bEnableCustomized = this.psDEDataImport.getENABLECUSTOMIZED();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getIMPPARAMS())) {
                this.impParams = PropertiesHelper.Load((String)this.psDEDataImport.getIMPPARAMS());
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDataImport.getPSSYSPFPLUGINID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataImport.getPSSYSSFPLUGINID())) {
            this.iPSSysSFPlugin = this.getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDEDataImport.getPSSYSSFPLUGINID());
        }
        if (this.getPSAppDataEntity() != null) {
            if (this.getPSSysPFPlugin() != null) {
                this.getPSAppDataEntity().getPSApplication().getPSSysPFPlugin(this.getPSSysPFPlugin().getId(), "DEDATAIMPORT", null, null);
                String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDataEntity().getPSApplication().getPSPF().getId());
                IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                if (iPSSysPFPluginTempl != null) {
                    this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
                }
            }
        } else if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDEDataImportItems();
    }

    protected void onPreparePSDEDataImportItems() throws Exception {
        CallResult callResult;
        this.psDEDataImportItemList.clear();
        this.deDataImportItemList.clear();
        Vector<PSDEDataImportItem> psDEDataImportItemList = new Vector<PSDEDataImportItem>();
        if (!this.isAutoModel() && (callResult = this.getPSModelHelper().getPSDEDataImportItems(this.getId(), psDEDataImportItemList)).isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        if (psDEDataImportItemList.size() == 0 && this.isDefaultMode()) {
            Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getAllPSDEFields();
            ArrayList<IPSDEField> impPSDEFieldList = new ArrayList<IPSDEField>();
            if (psDEFields != null) {
                while (psDEFields.hasNext()) {
                    IPSDEField iPSDEField = psDEFields.next();
                    if (iPSDEField.getImportOrder() < 0) continue;
                    impPSDEFieldList.add(iPSDEField);
                }
            }
            if (impPSDEFieldList.size() > 0) {
                Collections.sort(impPSDEFieldList, new Comparator<IPSDEField>(){

                    @Override
                    public int compare(IPSDEField o1, IPSDEField o2) {
                        int nRet = o1.getImportOrder() - o2.getImportOrder();
                        if (nRet == 0) {
                            return 0;
                        }
                        if (nRet > 0) {
                            return 1;
                        }
                        return -1;
                    }
                });
                for (IPSDEField iPSDEField : impPSDEFieldList) {
                    PSDEDataImportItem psDEDataImportItem = new PSDEDataImportItem();
                    psDEDataImportItem.setPSDEFID(iPSDEField.getId());
                    psDEDataImportItem.setPSDEFNAME(iPSDEField.getName());
                    psDEDataImportItem.setORDERVALUE(iPSDEField.getImportOrder());
                    psDEDataImportItem.setPSDEDATAIMPITEMNAME(iPSDEField.getName());
                    psDEDataImportItem.setPSDEDATAIMPITEMID(iPSDEField.getId());
                    psDEDataImportItem.setVALIDFLAG(true);
                    PSDEDataImportItemImpl iPSDEDataImportItem = new PSDEDataImportItemImpl();
                    iPSDEDataImportItem.init(this.getDAGlobalHelper(), this, psDEDataImportItem);
                    this.psDEDataImportItemList.add(iPSDEDataImportItem);
                }
            }
        } else {
            for (PSDEDataImportItem psDEDataImportItem : psDEDataImportItemList) {
                PSDEDataImportItemImpl iPSDEDataImportItem = new PSDEDataImportItemImpl();
                iPSDEDataImportItem.init(this.getDAGlobalHelper(), this, psDEDataImportItem);
                this.psDEDataImportItemList.add(iPSDEDataImportItem);
            }
        }
        this.deDataImportItemList.addAll(this.psDEDataImportItemList);
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEDATAIMP";
        }
        return "PSDEDATAIMP";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    public Iterator<IDEDataImportItem> getDEDataImportItems() {
        return this.deDataImportItemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u9879\u96c6\u5408", child=true)
    public Iterator<IPSDEDataImportItem> getPSDEDataImportItems() {
        return this.psDEDataImportItemList.iterator();
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5bfc\u5165\u9519\u8bef", fields={"STOPWHENERROR"})
    public boolean isIgnoreError() {
        return this.bIgnoreError;
    }

    public String getCreateDEActionName() {
        if (this.getCreatePSDEAction() != null) {
            return this.getCreatePSDEAction().getName();
        }
        return null;
    }

    public String getUpdateDEActionName() {
        if (this.getUpdatePSDEAction() != null) {
            return this.getUpdatePSDEAction().getName();
        }
        return null;
    }

    public boolean isDefault() {
        return this.bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u6570\u636e\u884c\u4e3a", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"CREATEPSDEACTIONID"})
    public IPSDEAction getCreatePSDEAction() {
        return this.createPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u6570\u636e\u884c\u4e3a", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"UPDATEPSDEACTIONID"})
    public IPSDEAction getUpdatePSDEAction() {
        return this.updatePSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6", fields={"CREATEPSDEOPPRIVID"})
    public String getCreateDataAccessAction() {
        if (this.getCreatePSDEOPPriv() != null) {
            return this.getCreatePSDEOPPriv().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u64cd\u4f5c\u6807\u8bc6", fields={"UPDATEPSDEOPPRIVID"})
    public String getUpdateDataAccessAction() {
        if (this.getUpdatePSDEOPPriv() != null) {
            return this.getUpdatePSDEOPPriv().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, dump=false)
    public IPSDEOPPriv getCreatePSDEOPPriv() {
        return this.createPSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, dump=false)
    public IPSDEOPPriv getUpdatePSDEOPPriv() {
        return this.updatePSDEOPPriv;
    }

    @Override
    @PSModelRTMeta(description="\u5efa\u7acb\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"CREATEPSDEACTIONID"})
    public IPSAppDEAction getCreatePSAppDEAction() {
        return this.createPSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u66f4\u65b0\u5e94\u7528\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSAppDataEntity", fields={"UPDATEPSDEACTIONID"})
    public IPSAppDEAction getUpdatePSAppDEAction() {
        return this.updatePSAppDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getActionHolder() {
        return this.nActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", fields={"ACTIONHOLDER"})
    public boolean isEnableBackend() {
        return (this.getActionHolder() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", fields={"ACTIONHOLDER"})
    public boolean isEnableFront() {
        return (this.getActionHolder() & 2) == 2;
    }

    protected boolean isCustomActionHolder() {
        return this.bCustomActionHolder;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u6279\u5bfc\u5165\u6570\u91cf", fields={"BATCHSIZE"})
    public int getBatchSize() {
        return this.nBatchSize;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    public String getDynaModelFilePath() {
        if (this.getPSAppDataEntity() != null) {
            return null;
        }
        return super.getDynaModelFilePath();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bfc\u5165", ignoredumpvalues="false", fields={"DEFAULTFLAG"})
    public boolean isDefaultMode() {
        return this.isDefault();
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1", fields={"POTIME"})
    public int getPOTime() {
        return this.nPOTime;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() {
        return this.bValid;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bb0", fields={"IMPTAG"})
    public String getImpTag() {
        return this.psDEDataImport.getIMPTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bb02", fields={"IMPTAG2"})
    public String getImpTag2() {
        return this.psDEDataImport.getIMPTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"IMPPARAMS"})
    public Properties getImpParams() {
        return this.impParams;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u5b9a\u4e49", ignoredumpvalues="false", fields={"ENABLECUSTOMIZED"})
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }
}

