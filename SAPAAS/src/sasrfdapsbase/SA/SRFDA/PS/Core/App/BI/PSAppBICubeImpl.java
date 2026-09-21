/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeDimension;
import SA.SRFDA.PS.Core.App.BI.IPSAppBICubeMeasure;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.BI.PSAppBICubeDimensionImpl;
import SA.SRFDA.PS.Core.App.BI.PSAppBICubeMeasureImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl3;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBICubeImpl
extends PSObjectImpl3
implements IPSAppBICube {
    private static final Log log = LogFactory.getLog(PSAppBICubeImpl.class);
    private IPSSysBICube iPSSysBICube = null;
    private IPSAppBIScheme iPSAppBIScheme = null;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private Map<String, IPSAppBICubeMeasure> psAppBICubeMeasureMap = new LinkedHashMap<String, IPSAppBICubeMeasure>();
    private Map<String, IPSAppBICubeDimension> psAppBICubeDimensionMap = new LinkedHashMap<String, IPSAppBICubeDimension>();
    private IPSUIActionGroup portalPSUIActionGroup = null;
    private IPSAppView drillDetailPSAppView = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppBIScheme iPSAppBIScheme, IPSSysBICube iPSSysBICube) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSAppBIScheme = iPSAppBIScheme;
            this.iPSSysBICube = iPSSysBICube;
            this.setId(iPSSysBICube.getId());
            this.setName(iPSSysBICube.getName());
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
        Iterator<? extends IPSSysBICubeDimension> psSysBICubeDimensions;
        Iterator<? extends IPSSysBICubeMeasure> psSysBICubeMeasures;
        if (this.getPSSysBICube().getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSAppBIScheme().getPSApplication().getPSAppDataEntity(this.getPSSysBICube().getPSDataEntity(), false);
        }
        super.onInit();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysBICube().getPortletPSDEUIActionGroupId())) {
            this.portalPSUIActionGroup = this.getPSAppDataEntity().getPSAppDEUIActionGroup(this.getPSSysBICube().getPortletPSDEUIActionGroupId());
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysBICube().getDrillDetailPSDEViewId())) {
            this.drillDetailPSAppView = this.getPSAppBIScheme().getPSApplication().getPSAppView(this.getPSSysBICube().getDrillDetailPSDEViewId(), false);
        }
        if ((psSysBICubeMeasures = this.getPSSysBICube().getAllPSSysBICubeMeasures()) != null) {
            while (psSysBICubeMeasures.hasNext()) {
                IPSSysBICubeMeasure iPSSysBICubeMeasure = psSysBICubeMeasures.next();
                PSAppBICubeMeasureImpl psAppBICubeMeasureImpl = new PSAppBICubeMeasureImpl();
                psAppBICubeMeasureImpl.init(this.getDAGlobalHelper(), this, iPSSysBICubeMeasure);
                this.psAppBICubeMeasureMap.put(iPSSysBICubeMeasure.getId(), psAppBICubeMeasureImpl);
            }
        }
        if ((psSysBICubeDimensions = this.getPSSysBICube().getAllPSSysBICubeDimensions()) != null) {
            while (psSysBICubeDimensions.hasNext()) {
                IPSSysBICubeDimension iPSSysBICubeDimension = psSysBICubeDimensions.next();
                PSAppBICubeDimensionImpl psAppBICubeDimensionImpl = new PSAppBICubeDimensionImpl();
                psAppBICubeDimensionImpl.init(this.getDAGlobalHelper(), this, iPSSysBICubeDimension);
                this.psAppBICubeDimensionMap.put(iPSSysBICubeDimension.getId(), psAppBICubeDimensionImpl);
            }
        }
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysBICube();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u667a\u80fd\u62a5\u8868\u4f53\u7cfb")
    public IPSAppBIScheme getPSAppBIScheme() {
        return this.iPSAppBIScheme;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53")
    public IPSSysBICube getPSSysBICube() {
        return this.iPSSysBICube;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    public String getModelType() {
        return "PSAPPBICUBE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.getPSSysBICube().getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6\u96c6\u5408", child=true)
    public Iterator<IPSAppBICubeDimension> getPSAppBICubeDimensions() {
        if (this.psAppBICubeDimensionMap == null || this.psAppBICubeDimensionMap.size() == 0) {
            return null;
        }
        return this.psAppBICubeDimensionMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807\u96c6\u5408", child=true)
    public Iterator<IPSAppBICubeMeasure> getPSAppBICubeMeasures() {
        if (this.psAppBICubeMeasureMap == null || this.psAppBICubeMeasureMap.size() == 0) {
            return null;
        }
        return this.psAppBICubeMeasureMap.values().iterator();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppBIScheme().getPSApplication().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSAppBIScheme().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppBIScheme().getModelId(), (Object)this.getDynaModelTag());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSAppBIScheme();
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSAppBIScheme() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSAppBIScheme().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSAppBIScheme().getPSSysModelInstId();
    }

    @Override
    protected boolean onGetEnableDynaModel() {
        return this.getPSAppBIScheme().getPSApplication().isEnableDynaSys();
    }

    @Override
    @PSModelRTMeta(description="\u8bbf\u95ee\u6807\u8bc6")
    public String getAccessKey() {
        if (this.getPSSysBICube().getPSSysUniRes() != null) {
            return this.getPSSysBICube().getPSSysUniRes().getResCode();
        }
        return null;
    }

    @Override
    public IPSAppBICubeDimension getPSAppBICubeDimension(IPSSysBICubeDimension iPSSysBICubeDimension) throws Exception {
        IPSAppBICubeDimension iPSAppBICubeDimension = this.psAppBICubeDimensionMap.get(iPSSysBICubeDimension.getId());
        if (iPSAppBICubeDimension != null) {
            return iPSAppBICubeDimension;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u4f20\u5165\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6[%1$s]\u7684\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u7ef4\u5ea6", iPSSysBICubeDimension.getName()));
    }

    @Override
    public IPSAppBICubeMeasure getPSAppBICubeMeasure(IPSSysBICubeMeasure iPSSysBICubeMeasure) throws Exception {
        IPSAppBICubeMeasure iPSAppBICubeMeasure = this.psAppBICubeMeasureMap.get(iPSSysBICubeMeasure.getId());
        if (iPSAppBICubeMeasure != null) {
            return iPSAppBICubeMeasure;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u4f20\u5165\u7cfb\u7edf\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807[%1$s]\u7684\u5e94\u7528\u667a\u80fd\u7acb\u65b9\u4f53\u6307\u6807", iPSSysBICubeMeasure.getName()));
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u9ed8\u8ba4\u754c\u9762\u884c\u4e3a\u7ec4\u5bf9\u8c61", child=true, ignorert=3)
    public IPSUIActionGroup getPorletPSUIActionGroup() {
        return this.portalPSUIActionGroup;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53cd\u67e5\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61", dumpref=true, ignorert=3)
    public IPSAppView getDrillDetailPSAppView() {
        return this.drillDetailPSAppView;
    }
}

