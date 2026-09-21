/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeHierarchy;
import SA.SRFDA.PS.Core.App.BI.PSAppBICubeHierarchyImpl;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSSysBIHierarchy;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBICubeDimensionImpl
extends PSObjectImpl
implements IPSAppBICubeDimension {
    private static final Log log = LogFactory.getLog(PSAppBICubeDimensionImpl.class);
    private IPSAppBICube iPSAppBICube = null;
    private IPSSysBICubeDimension iPSSysBICubeDimension = null;
    private IPSAppDEField iPSAppDEField = null;
    private IPSAppDEField textPSAppDEField = null;
    private Map<String, IPSAppBICubeHierarchy> psAppBICubeHierarchyMap = new LinkedHashMap<String, IPSAppBICubeHierarchy>();
    private IPSAppCodeList iPSAppCodeList = null;
    private IPSAppDEUIAction paramPSAppDEUIAction = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBICube iPSAppBICube, IPSSysBICubeDimension iPSSysBICubeDimension) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBICube = iPSAppBICube;
            this.iPSSysBICubeDimension = iPSSysBICubeDimension;
            this.setId(this.iPSSysBICubeDimension.getId());
            this.setName(this.iPSSysBICubeDimension.getName());
            if (!StringHelper.IsNullOrEmpty((String)iPSSysBICubeDimension.getParamPSDEUIActionId())) {
                this.paramPSAppDEUIAction = this.getPSAppBICube().getPSAppDataEntity().getPSAppDEUIAction(iPSSysBICubeDimension.getParamPSDEUIActionId());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysBICubeDimension();
    }

    @Override
    protected void onInit() throws Exception {
        Iterator<? extends IPSSysBICubeLevel> psSysBICubeLevels;
        if (this.getPSSysBICubeDimension().getPSDEField() != null && this.getPSAppBICube().getPSAppDataEntity() != null) {
            this.iPSAppDEField = this.getPSAppBICube().getPSAppDataEntity().getPSAppDEField(this.getPSSysBICubeDimension().getPSDEField(), false);
        }
        if (this.getPSSysBICubeDimension().getTextPSDEField() != null && this.getPSAppBICube().getPSAppDataEntity() != null) {
            this.textPSAppDEField = this.getPSAppBICube().getPSAppDataEntity().getPSAppDEField(this.getPSSysBICubeDimension().getTextPSDEField(), false);
        }
        if (this.getPSSysBICubeDimension().getPSCodeList() != null) {
            this.iPSAppCodeList = this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSAppCodeList(this.getPSSysBICubeDimension().getPSCodeList(), false);
        }
        super.onInit();
        if (this.getPSSysBICubeDimension().getPSSysBIDimension() != null && (psSysBICubeLevels = this.getPSSysBICubeDimension().getAllPSSysBICubeLevels()) != null) {
            while (psSysBICubeLevels.hasNext()) {
                IPSSysBICubeLevel iPSSysBICubeLevel = psSysBICubeLevels.next();
                IPSSysBIHierarchy iPSSysBIHierarchy = iPSSysBICubeLevel.getPSSysBIHierarchy();
                if (this.psAppBICubeHierarchyMap.containsKey(iPSSysBIHierarchy.getId())) continue;
                PSAppBICubeHierarchyImpl psAppBICubeHierarchyImpl = new PSAppBICubeHierarchyImpl();
                psAppBICubeHierarchyImpl.init(this.getDAGlobalHelper(), this, iPSSysBIHierarchy);
                this.psAppBICubeHierarchyMap.put(psAppBICubeHierarchyImpl.getId(), psAppBICubeHierarchyImpl);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBICubeDimension().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb0", hideempty2=true)
    public String getDimensionTag() {
        return this.getPSSysBICubeDimension().getDimensionTag();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u6807\u8bb02", hideempty2=true)
    public String getDimensionTag2() {
        return this.getPSSysBICubeDimension().getDimensionTag2();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBICube", from_method="getPSAppDataEntityMust().getPSAppDEField", fields={"PSDEFID"})
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppBICube", from_method="getPSAppDataEntityMust().getPSAppDEField", fields={"TEXTPSDEFID"})
    public IPSAppDEField getTextPSAppDEField() {
        return this.textPSAppDEField;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBICUBEDIMENSION";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBICube().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppBICube.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53")
    public IPSAppBICube getPSAppBICube() {
        return this.iPSAppBICube;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6")
    public IPSSysBICubeDimension getPSSysBICubeDimension() {
        return this.iPSSysBICubeDimension;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBICube().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u4f53\u7cfb\u96c6\u5408", child=true)
    public Iterator<IPSAppBICubeHierarchy> getPSAppBICubeHierarchies() throws Exception {
        if (this.psAppBICubeHierarchyMap == null || this.psAppBICubeHierarchyMap.size() == 0) {
            return null;
        }
        return this.psAppBICubeHierarchyMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true, fields={"PSCODELISTID"})
    public IPSAppCodeList getPSAppCodeList() {
        return this.iPSAppCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u7c7b\u578b", codelist="BIDimensionType", fields={"BIDIMENSIONTYPE"})
    public String getDimensionType() {
        return this.getPSSysBICubeDimension().getDimensionType();
    }

    @Override
    @PSModelRTMeta(description="\u7ef4\u5ea6\u516c\u5f0f", fields={"DIMENSIONFORMULA"})
    public String getDimensionFormula() {
        return this.getPSSysBICubeDimension().getDimensionFormula();
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u914d\u7f6e\u754c\u9762\u884c\u4e3a\u5bf9\u8c61", dumpref=true, from="IPSAppBICube", from_method="getPSAppDataEntityMust().getPSAppDEUIAction", fields={"PARAMPSDEUIACTIONID"})
    public IPSAppDEUIAction getParamPSAppDEUIAction() {
        return this.paramPSAppDEUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u7ed8\u5236\u6a21\u677f", fields={"TEXTTEMPLATE"})
    public String getTextTemplate() {
        return this.getPSSysBICubeDimension().getTextTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ed8\u5236\u6a21\u677f", fields={"TIPTEMPLATE"})
    public String getTipTemplate() {
        return this.getPSSysBICubeDimension().getTipTemplate();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"STDDATATYPE"})
    public int getStdDataType() {
        return this.getPSSysBICubeDimension().getStdDataType();
    }
}

