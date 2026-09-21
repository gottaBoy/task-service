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

import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeHierarchy;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeLevel;
import SA.SRFDA.PS.Core.App.BI.PSAppBICubeLevelImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
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

public class PSAppBICubeHierarchyImpl
extends PSObjectImpl
implements IPSAppBICubeHierarchy {
    private static final Log log = LogFactory.getLog(PSAppBICubeHierarchyImpl.class);
    private IPSAppBICubeDimension iPSAppBICubeDimension = null;
    private IPSSysBIHierarchy iPSSysBIHierarchy = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private Map<String, IPSAppBICubeLevel> psAppBICubeLevelMap = new LinkedHashMap<String, IPSAppBICubeLevel>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBICubeDimension iPSAppBICubeDimension, IPSSysBIHierarchy iPSSysBIHierarchy) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBICubeDimension = iPSAppBICubeDimension;
            this.iPSSysBIHierarchy = iPSSysBIHierarchy;
            this.setId(this.iPSSysBIHierarchy.getId());
            this.setName(this.iPSSysBIHierarchy.getName());
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
        return this.getPSSysBIHierarchy();
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSSysBIHierarchy().getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSAppBICubeDimension().getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSAppDataEntity(this.getPSSysBIHierarchy().getPSDataEntity(), true);
        }
        super.onInit();
        Iterator<? extends IPSSysBICubeLevel> psSysBICubeLevels = this.getPSAppBICubeDimension().getPSSysBICubeDimension().getAllPSSysBICubeLevels();
        if (psSysBICubeLevels != null) {
            while (psSysBICubeLevels.hasNext()) {
                IPSSysBICubeLevel iPSSysBICubeLevel = psSysBICubeLevels.next();
                IPSSysBIHierarchy iPSSysBIHierarchy = iPSSysBICubeLevel.getPSSysBIHierarchy();
                if (this.getPSSysBIHierarchy() != iPSSysBIHierarchy) continue;
                PSAppBICubeLevelImpl psAppBICubeLevelImpl = new PSAppBICubeLevelImpl();
                psAppBICubeLevelImpl.init(this.getDAGlobalHelper(), this, iPSSysBICubeLevel);
                this.psAppBICubeLevelMap.put(psAppBICubeLevelImpl.getId(), psAppBICubeLevelImpl);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBIHierarchy().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getHierarchyTag() {
        return this.getPSSysBIHierarchy().getHierarchyTag();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getHierarchyTag2() {
        return this.getPSSysBIHierarchy().getHierarchyTag2();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBICubeDimension().getPSAppBICube().getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getModelType() {
        return "PSAPPBICUBEHIERARCHY";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBICubeDimension().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.iPSAppBICubeDimension.getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6")
    public IPSAppBICubeDimension getPSAppBICubeDimension() {
        return this.iPSAppBICubeDimension;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6")
    public IPSSysBIHierarchy getPSSysBIHierarchy() {
        return this.iPSSysBIHierarchy;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBICubeDimension().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u4f53\u7cfb\u7ea7\u522b\u96c6\u5408", child=true)
    public Iterator<IPSAppBICubeLevel> getPSAppBICubeLevels() throws Exception {
        if (this.psAppBICubeLevelMap == null || this.psAppBICubeLevelMap.size() == 0) {
            return null;
        }
        return this.psAppBICubeLevelMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5168\u90e8\u6570\u636e", ignoredumpvalues="false")
    public boolean hasAll() {
        return this.getPSSysBIHierarchy().hasAll();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u6570\u636e\u6807\u9898")
    public String getAllCaption() {
        return this.getPSSysBIHierarchy().getAllCaption();
    }
}

