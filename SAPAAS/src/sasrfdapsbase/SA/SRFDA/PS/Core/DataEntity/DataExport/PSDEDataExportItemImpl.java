/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.IDEDataExport
 *  net.ibizsys.paas.data.IDataItemParam
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExportItem;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridDataItem;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportItem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.data.IDataItemParam;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataExportItemImpl
extends PSObjectImpl
implements IPSDEDataExportItem,
IPSAppDEDataExportItem {
    private static final Log log = LogFactory.getLog(PSDEDataExportItemImpl.class);
    private IPSDEDataExport iPSDEDataExport = null;
    private PSDEGridColumn psDEGridColumn = null;
    private IPSDEGridDataItem iPSDEGridDataItem = null;
    private String strCaption = "";
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSDEField iPSDEField = null;
    private IPSCodeList iPSCodeList = null;
    private IPSAppDEField iPSAppDEField = null;
    private String strPSCodeListId = null;
    private String strAlign = null;
    private boolean bHidden = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataExport iPSDEDataExport, PSDEGridColumn psDEGridColumn) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataExport = iPSDEDataExport;
            this.psDEGridColumn = psDEGridColumn;
            this.setId(this.psDEGridColumn.getPSDEGRIDCOLID());
            this.setName(this.psDEGridColumn.getPSDEGRIDCOLNAME());
            this.setPSObjectData(this.psDEGridColumn);
            this.strCaption = this.psDEGridColumn.getCAPTION();
            this.strAlign = this.psDEGridColumn.getALIGN();
            if (!this.psDEGridColumn.isHIDDENDATAITEMNull()) {
                this.bHidden = this.psDEGridColumn.getHIDDENDATAITEM();
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
        IPSAppDataEntity iPSAppDataEntity = null;
        if (this.iPSDEDataExport instanceof IPSAppDEDataExport) {
            iPSAppDataEntity = ((IPSAppDEDataExport)this.iPSDEDataExport).getPSAppDataEntity();
        }
        this.iPSDEField = this.getPSDEDataExport().getPSDataEntity().getPSDEField(this.psDEGridColumn.getPSDEFID(), false);
        if (iPSAppDataEntity != null) {
            this.iPSAppDEField = iPSAppDataEntity.getPSAppDEField(this.iPSDEField, true);
        }
        IPSDEFUIMode iPSDEFUIMode = null;
        iPSDEFUIMode = SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getPSDEFUIMODEID()) ? this.iPSDEField.getPSDEFUIMode("DEFAULT") : this.iPSDEField.getPSDEFUIMode(this.psDEGridColumn.getPSDEFUIMODEID());
        IPSDEFGridColumn iPSDEFGridColumn = iPSDEFUIMode.getPSDEFGridColumn();
        Iterator<IPSDEGridDataItem> psDEGridDataItems = iPSDEFGridColumn.getPSDEGridDataItems();
        if (psDEGridDataItems.hasNext()) {
            this.iPSDEGridDataItem = psDEGridDataItems.next();
        }
        if (this.iPSDEGridDataItem == null) {
            throw new Exception("\u5bfc\u51fa\u5217\u6570\u636e\u9879\u65e0\u6548");
        }
        this.strPSCodeListId = this.iPSDEGridDataItem.getCodeListId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCodeListId()) && this.iPSDEGridDataItem.getDataItemParam() != null) {
            this.strPSCodeListId = this.iPSDEGridDataItem.getDataItemParam().getCodeListId();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            this.strCaption = iPSDEFGridColumn.getCaption("");
        }
        this.capPSLanguageRes = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getCAPPSLANRESID()) ? this.getPSDEDataExport().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEGridColumn.getCAPPSLANRESID()) : iPSDEFGridColumn.getCapPSLanguageRes();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCodeListId())) {
            this.iPSCodeList = iPSAppDataEntity != null ? iPSAppDataEntity.getPSApplication().getPSAppCodeList(this.getCodeListId()) : this.getPSDEDataExport().getPSDataEntity().getPSSystem().getPSCodeList(this.getCodeListId());
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u6743\u9650\u6807\u8bc6")
    public String getPrivilegeId() {
        return this.iPSDEGridDataItem.getPrivilegeId();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    public String getText(IWebContext iWebContext, Object object, boolean bEnableItemPrivilege) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public int getDataType() {
        return this.iPSDEGridDataItem.getDataType();
    }

    public IDataItemParam[] getDataItemParams() {
        return this.iPSDEGridDataItem.getDataItemParams();
    }

    @Override
    @PSModelRTMeta(description="\u683c\u5f0f\u5316")
    public String getFormat() {
        return this.iPSDEGridDataItem.getFormat();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c")
    public Object getDefaultValue() {
        return this.iPSDEGridDataItem.getDefaultValue();
    }

    public String getCodeListId() {
        return this.strPSCodeListId;
    }

    public Object getValue(IWebContext iWebContext, Object object) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataExport().getPSSysModelInstId();
    }

    public IDEDataExport getDEDataExport() {
        return this.getPSDEDataExport();
    }

    @Override
    public IPSDEDataExport getPSDEDataExport() {
        return this.iPSDEDataExport;
    }

    @Override
    public String getModelType() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSDEDataExport().getModelType(), (String)"PSAPPDEDATAEXP", (boolean)true) == 0) {
            return "PSAPPDEDATAEXPITEM";
        }
        return "PSDEDATAEXPITEM";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataExport().getModelId(), (Object)this.getName());
    }

    @Override
    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getModelName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return this.getName();
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s(%2$s)", (Object)this.getName(), (Object)this.getCaption());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataExport().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDataExport().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868", dumpref=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u6c34\u5e73\u5bf9\u9f50", codelist="GridColAlign", fields={"ALIGN"})
    public String getAlign() {
        return this.strAlign;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, ignorepf=true, from="IPSDataEntity", fields={"PSDEFID"})
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5bfc\u51fa\u5206\u7ec4", dumpref=true, ignorepf=true, from="IPSDEDataExport")
    public IPSDEDataExportGroup getPSDEDataExportGroup() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getPPSDEGRIDCOLID())) {
            return this.getPSDEDataExport().getPSDEDataExportGroup(this.psDEGridColumn.getPPSDEGRIDCOLID(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9690\u85cf\u9879", ignoredumpvalues="false")
    public boolean isHidden() {
        return this.bHidden;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668", ignorepf=true, dumpref=true)
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        return this.getPSDEField().getExportPSSysTranslator();
    }
}

