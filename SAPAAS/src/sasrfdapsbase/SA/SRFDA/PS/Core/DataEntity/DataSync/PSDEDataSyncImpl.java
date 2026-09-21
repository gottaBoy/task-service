/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataSync;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDEDataSync;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataSyncImpl
extends PSDataEntityObjectImpl
implements IPSDEDataSync,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDataSyncImpl.class);
    protected PSDEDataSync psDEDataSync;
    protected String strCodeName = "";
    private IPSDEAction inPSDEAction = null;
    private IPSDEAction outPSDEAction = null;
    private String strSyncDir = null;
    private boolean bExportFull = false;
    private int nEventType = 0;
    private IPSSysDataSyncAgent inPSSysDataSyncAgent = null;
    private IPSSysDataSyncAgent outPSSysDataSyncAgent = null;
    private boolean bValidFlag = false;
    private boolean bInMode = false;
    private int nOutputMode = 1;
    private boolean bInputCustomCode = false;
    private boolean bOutputCustomCode = false;
    private ArrayList<String> deNameList = new ArrayList();
    private IPSDEAction importPSDEAction = null;
    private IPSDEDataSet outPSDEDataSet = null;
    private IPSDEDataSet inPSDEDataSet = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDataSync psDEDataSync) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDEDataSync = psDEDataSync;
            this.setId(psDEDataSync.getPSDEDATASYNCID());
            this.setName(psDEDataSync.getPSDEDATASYNCNAME());
            this.setPSObjectData(this.psDEDataSync);
            this.strCodeName = this.psDEDataSync.getCODENAME();
            this.strSyncDir = this.psDEDataSync.getSYNCDIR();
            if (!this.psDEDataSync.isEXPORTFULLNull()) {
                this.bExportFull = this.psDEDataSync.getEXPORTFULL();
            }
            this.nEventType = this.psDEDataSync.getEVENTTYPE();
            if (!this.psDEDataSync.isVALIDFLAGNull()) {
                this.bValidFlag = this.psDEDataSync.getVALIDFLAG();
            }
            boolean bl = this.bInMode = SA.SRFramework.Utility.StringHelper.Compare((String)this.strSyncDir, (String)"IN", (boolean)true) == 0;
            if (this.bInMode) {
                this.bInputCustomCode = !this.psDEDataSync.isINCUSTOMMODENull() ? this.psDEDataSync.getINCUSTOMMODE() : !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getINCUSTOMCODE());
            } else {
                if (!this.psDEDataSync.isOUTMODENull()) {
                    this.nOutputMode = this.psDEDataSync.getOUTMODE();
                }
                this.bOutputCustomCode = !this.psDEDataSync.isOUTCUSTOMMODENull() ? this.psDEDataSync.getOUTCUSTOMMODE() : !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getOUTCUSTOMCODE());
            }
            String strDENames = this.psDEDataSync.getDENAMES();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strDENames)) {
                String[] deNames;
                strDENames = strDENames.trim().toUpperCase();
                String[] stringArray = deNames = SA.SRFramework.Utility.StringHelper.SplitEx((String)strDENames);
                int n = deNames.length;
                int n2 = 0;
                while (n2 < n) {
                    String strDEname = stringArray[n2];
                    this.deNameList.add(strDEname);
                    ++n2;
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
        String strPSSysSFPluginId;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getOUTPSSYSDATASYNCAGENTID())) {
            this.outPSSysDataSyncAgent = this.getPSDataEntity().getPSSystem().getPSSysDataSyncAgent(this.psDEDataSync.getOUTPSSYSDATASYNCAGENTID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getINPSSYSDATASYNCAGENTID())) {
            this.inPSSysDataSyncAgent = this.getPSDataEntity().getPSSystem().getPSSysDataSyncAgent(this.psDEDataSync.getINPSSYSDATASYNCAGENTID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getINPSDEACTIONID())) {
            this.inPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDataSync.getINPSDEACTIONID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getOUTPSDEACTIONID())) {
            this.outPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDataSync.getOUTPSDEACTIONID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getINPSDEDATASETID())) {
            this.inPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEDataSync.getINPSDEDATASETID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getOUTPSDEDATASETID())) {
            this.outPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDEDataSync.getOUTPSDEDATASETID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDataSync.getIMPORTPSDEACTIONID())) {
            this.importPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDataSync.getIMPORTPSDEACTIONID());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strPSSysSFPluginId = this.psDEDataSync.getPSSYSSFPLUGINID()))) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
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
        return "PSDEDATASYNC";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5224\u65ad\u5b9e\u4f53\u884c\u4e3a", from="IPSDataEntity", dumpref=true, fields={"INPSDEACTIONID"})
    public IPSDEAction getInTestPSDEAction() {
        return this.inPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u5224\u65ad\u5b9e\u4f53\u884c\u4e3a", from="IPSDataEntity", dumpref=true, fields={"OUTPSDEACTIONID"})
    public IPSDEAction getOutTestPSDEAction() {
        return this.outPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity", fields={"IMPORTPSDEACTIONID"})
    public IPSDEAction getImportPSDEAction() {
        return this.importPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u65b9\u5411", codelist="DataSyncDir", fields={"SYNCDIR"})
    public String getSyncDir() {
        return this.strSyncDir;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u51fa\u5168\u90e8", fields={"EXPORTFULL"})
    public boolean isExportFull() {
        return this.bExportFull;
    }

    @Override
    @PSModelRTMeta(description="\u4e8b\u4ef6\u7c7b\u578b", codelist="DataSyncInformType", fields={"EVENTTYPE"})
    public int getEventType() {
        return this.nEventType;
    }

    public Iterator<String> getDENames() {
        if (this.deNameList == null || this.deNameList.size() == 0) {
            return null;
        }
        return this.deNameList.iterator();
    }

    public String getTestDEActionName() {
        if (this.isInMode()) {
            if (this.getInTestPSDEAction() != null) {
                return this.getInTestPSDEAction().getName();
            }
        } else if (this.getOutTestPSDEAction() != null) {
            return this.getOutTestPSDEAction().getName();
        }
        return null;
    }

    public String getImportDEActionName() {
        if (this.getImportPSDEAction() == null) {
            return null;
        }
        return this.getImportPSDEAction().getName();
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getSyncAgent() {
        if (this.isInMode()) {
            if (this.getInPSSysDataSyncAgent() != null) {
                return this.getInPSSysDataSyncAgent().getId();
            }
        } else if (this.getOutPSSysDataSyncAgent() != null) {
            return this.getOutPSSysDataSyncAgent().getId();
        }
        return null;
    }

    @PSModelRTMeta(description="\u8f93\u5165\u6a21\u5f0f", doc="\u7b49\u540c{@link #getSyncDir}\u7b49\u4e8e[IN]")
    public boolean isInMode() {
        return this.bInMode;
    }

    public Iterator<String> getFileFields() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"INPSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getInPSSysDataSyncAgent() {
        return this.inPSSysDataSyncAgent;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406\u5bf9\u8c61", hideempty2=true, dumpref=true, fields={"OUTPSSYSDATASYNCAGENTID"})
    public IPSSysDataSyncAgent getOutPSSysDataSyncAgent() {
        return this.outPSSysDataSyncAgent;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true")
    public boolean isValid() {
        return this.bValidFlag;
    }

    @PSModelRTMeta(description="\u540c\u6b65\u6807\u8bb0", doc="\u6765\u6e90{@link #getCodeName}")
    public String getSyncTag() {
        return this.strCodeName;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u8c03\u7528\u811a\u672c\u4ee3\u7801", fields={"INCUSTOMCODE"})
    public String getInScriptCode() {
        if (!this.isInCustomCode()) {
            return "";
        }
        return this.psDEDataSync.getINCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u8c03\u7528\u811a\u672c\u4ee3\u7801", fields={"OUTCUSTOMCODE"})
    public String getOutScriptCode() {
        if (!this.isOutCustomCode()) {
            return "";
        }
        return this.psDEDataSync.getOUTCUSTOMCODE();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u51fa\u6570\u636e\u96c6\u5408", dumpref=true, from="IPSDataEntity", fields={"OUTPSDEDATASETID"})
    public IPSDEDataSet getOutPSDEDataSet() {
        return this.outPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u6570\u636e\u96c6\u5408", dumpref=true, from="IPSDataEntity", fields={"INPSDEDATASETID"})
    public IPSDEDataSet getInPSDEDataSet() {
        return this.inPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u8f93\u5165\u5904\u7406\u811a\u672c", ignoredumpvalues="false", fields={"INCUSTOMMODE"})
    public boolean isInCustomCode() {
        return this.bInputCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u8f93\u51fa\u5904\u7406\u811a\u672c", ignoredumpvalues="false", fields={"OUTCUSTOMMODE"})
    public boolean isOutCustomCode() {
        return this.bOutputCustomCode;
    }

    @Override
    @PSModelRTMeta(description="\u540c\u6b65\u8f93\u51fa\u6a21\u5f0f", ignoredumpvalues="1", codelist="DataSyncOutMode", fields={"OUTMODE"})
    public int getOutputMode() {
        return this.nOutputMode;
    }
}

