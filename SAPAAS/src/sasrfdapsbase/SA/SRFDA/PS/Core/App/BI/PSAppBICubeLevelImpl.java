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

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeHierarchy;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeLevel;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeLevel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBICubeLevelImpl
extends PSObjectImpl
implements IPSAppBICubeLevel {
    private static final Log log = LogFactory.getLog(PSAppBICubeLevelImpl.class);
    private IPSAppBICubeHierarchy iPSAppBICubeHierarchy = null;
    private IPSSysBICubeLevel iPSSysBICubeLevel = null;
    private IPSAppDEField iPSAppDEField = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBICubeHierarchy iPSAppBICubeHierarchy, IPSSysBICubeLevel iPSSysBICubeLevel) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBICubeHierarchy = iPSAppBICubeHierarchy;
            this.iPSSysBICubeLevel = iPSSysBICubeLevel;
            this.setId(this.iPSSysBICubeLevel.getId());
            this.setName(this.iPSSysBICubeLevel.getName());
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
        return this.getPSSysBICubeLevel();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSAppBICubeHierarchy().getPSAppDataEntity() != null && this.getPSSysBICubeLevel().getPSDEField() != null) {
            this.iPSAppDEField = this.getPSAppBICubeHierarchy().getPSAppDataEntity().getPSAppDEField(this.getPSSysBICubeLevel().getPSDEField(), false);
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBICubeLevel().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb0", hideempty2=true)
    public String getLevelTag() {
        return this.getPSSysBICubeLevel().getLevelTag();
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u6807\u8bb02", hideempty2=true)
    public String getLevelTag2() {
        return this.getPSSysBICubeLevel().getLevelTag2();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBICubeHierarchy().getPSAppBICubeDimension().getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBICUBELEVEL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBICubeHierarchy().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppBICubeHierarchy.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6")
    public IPSAppBICubeHierarchy getPSAppBICubeHierarchy() {
        return this.iPSAppBICubeHierarchy;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6")
    public IPSSysBICubeLevel getPSSysBICubeLevel() {
        return this.iPSSysBICubeLevel;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBICubeHierarchy().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5c5e\u6027", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEField getPSAppDEField() {
        return this.iPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5c42\u7ea7\u7c7b\u578b", codelist="BILevelType", ignoredumpvalues="COMMON")
    public String getLevelType() {
        return this.getPSSysBICubeLevel().getPSSysBILevel().getLevelType();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u9879\u6807\u8bc6")
    public String getTextItemName() {
        if (this.getPSSysBICubeLevel().getPSSysBILevel().getTextPSDEField() != null) {
            return this.getPSSysBICubeLevel().getPSSysBILevel().getTextPSDEField().getCodeName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u6807\u8bb0\u6210\u5458", ignoredumpvalues="false")
    public boolean isUniqueMembers() {
        return this.getPSSysBICubeLevel().getPSSysBILevel().isUniqueMembers();
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6807\u9898")
    public String getAggCaption() {
        return this.getPSSysBICubeLevel().getPSSysBILevel().getAggCaption();
    }
}

