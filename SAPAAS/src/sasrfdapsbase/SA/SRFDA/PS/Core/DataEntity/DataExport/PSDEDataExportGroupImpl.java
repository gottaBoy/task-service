/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataExport;

import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExport;
import SA.SRFDA.PS.Core.DataEntity.DataExport.IPSDEDataExportGroup;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEGridColumn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataExportGroupImpl
extends PSObjectImpl
implements IPSDEDataExportGroup {
    private static final Log log = LogFactory.getLog(PSDEDataExportGroupImpl.class);
    private IPSDEDataExport iPSDEDataExport = null;
    private PSDEGridColumn psDEGridColumn = null;
    private String strCaption = "";
    private IPSLanguageRes capPSLanguageRes = null;
    private String strAlign = null;

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
        this.strCaption = this.psDEGridColumn.getCAPTION();
        if (!StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getCAPPSLANRESID())) {
            this.capPSLanguageRes = this.getPSDEDataExport().getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEGridColumn.getCAPPSLANRESID());
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        IPSDEDataExportGroup parentPSDEDataExportGroup = this.getParentPSDEDataExportGroup();
        while (parentPSDEDataExportGroup != null) {
            if (StringHelper.Compare((String)parentPSDEDataExportGroup.getId(), (String)this.getId(), (boolean)false) == 0) {
                throw new Exception(String.format("\u5bfc\u51fa\u5206\u7ec4[%1$s]\u5b58\u5728\u9012\u5f52\u5f15\u7528", this.getName()));
            }
            parentPSDEDataExportGroup = parentPSDEDataExportGroup.getParentPSDEDataExportGroup();
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataExport().getPSSysModelInstId();
    }

    @Override
    public IPSDEDataExport getPSDEDataExport() {
        return this.iPSDEDataExport;
    }

    @Override
    public String getModelType() {
        if (StringHelper.Compare((String)this.getPSDEDataExport().getModelType(), (String)"PSAPPDEDATAEXP", (boolean)true) == 0) {
            return "PSAPPDEDATAEXPGROUP";
        }
        return "PSDEDATAEXPGROUP";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEDataExport().getModelId(), (Object)this.getName());
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
    @PSModelRTMeta(description="\u7236\u6570\u636e\u5bfc\u51fa\u5206\u7ec4", dumpref=true, ignorepf=true, from="IPSDEDataExport")
    public IPSDEDataExportGroup getParentPSDEDataExportGroup() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEGridColumn.getPPSDEGRIDCOLID())) {
            return this.getPSDEDataExport().getPSDEDataExportGroup(this.psDEGridColumn.getPPSDEGRIDCOLID(), false);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u7ea7\u522b", ignoredumpvalues="1")
    public int getGroupLevel() throws Exception {
        IPSDEDataExportGroup iPSDEDataExportGroup = this.getParentPSDEDataExportGroup();
        if (iPSDEDataExportGroup != null) {
            return iPSDEDataExportGroup.getGroupLevel() + 1;
        }
        return 1;
    }

    @Override
    @PSModelRTMeta(description="\u6c34\u5e73\u5bf9\u9f50", codelist="GridColAlign")
    public String getAlign() {
        return this.strAlign;
    }

    @Override
    public String getModelName() {
        if (StringHelper.IsNullOrEmpty((String)this.getCaption())) {
            return this.getName();
        }
        return StringHelper.Format((String)"%1$s(%2$s)", (Object)this.getName(), (Object)this.getCaption());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataExport().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEDataExport().getFullModelName(), (Object)this.getModelName());
    }
}

