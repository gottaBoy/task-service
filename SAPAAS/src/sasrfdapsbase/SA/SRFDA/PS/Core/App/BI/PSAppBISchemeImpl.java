/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.BI;

import SA.SRFDA.PS.Core.App.BI.IPSAppBICube;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIReport;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.BI.PSAppBICubeImpl;
import SA.SRFDA.PS.Core.App.BI.PSAppBIReportImpl;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSApplicationObjectImpl;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppBISchemeImpl
extends PSApplicationObjectImpl
implements IPSAppBIScheme {
    private static final Log log = LogFactory.getLog(PSAppBISchemeImpl.class);
    private IPSSysBIScheme iPSSysBIScheme = null;
    private Map<String, IPSAppBICube> psAppBICubeMap = new LinkedHashMap<String, IPSAppBICube>();
    private Map<String, IPSAppBIReport> psAppBIReportMap = new LinkedHashMap<String, IPSAppBIReport>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSSysBIScheme iPSSysBIScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSApplication(iPSApplication);
            this.iPSSysBIScheme = iPSSysBIScheme;
            this.setId(KeyValueHelper.genUniqueId((String)this.getPSApplication().getId(), (String)iPSSysBIScheme.getId()));
            this.setName(iPSSysBIScheme.getName());
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
        Iterator<? extends IPSSysBIReport> psSysBIReports;
        super.onInit();
        Iterator<? extends IPSSysBICube> psSysBICubes = this.getPSSysBIScheme().getAllPSSysBICubes();
        if (psSysBICubes != null) {
            while (psSysBICubes.hasNext()) {
                IPSAppDataEntity iPSAppDataEntity;
                IPSSysBICube iPSSysBICube = psSysBICubes.next();
                if (iPSSysBICube.getPSDataEntity() == null || (iPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(iPSSysBICube.getPSDataEntity(), true)) == null) continue;
                PSAppBICubeImpl psAppBICubeImpl = new PSAppBICubeImpl();
                psAppBICubeImpl.init(this.getDAGlobalHelper(), this, iPSSysBICube);
                this.psAppBICubeMap.put(iPSSysBICube.getId(), psAppBICubeImpl);
            }
        }
        if ((psSysBIReports = this.getPSSysBIScheme().getAllPSSysBIReports()) != null) {
            while (psSysBIReports.hasNext()) {
                IPSSysBIReport iPSSysBIReport = psSysBIReports.next();
                IPSAppBICube iPSAppBICube = this.getPSAppBICube(iPSSysBIReport.getPSSysBICube(), true);
                if (iPSAppBICube == null) continue;
                PSAppBIReportImpl psAppBIReportImpl = new PSAppBIReportImpl();
                psAppBIReportImpl.init(this.getDAGlobalHelper(), this, iPSSysBIReport);
                this.psAppBIReportMap.put(iPSSysBIReport.getId(), psAppBIReportImpl);
            }
        }
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSSysBIScheme();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u4f53\u7cfb")
    public IPSSysBIScheme getPSSysBIScheme() {
        return this.iPSSysBIScheme;
    }

    @Override
    public String getModelType() {
        return "PSAPPBISCHEME";
    }

    @Override
    protected String onGetDynaModelTag() {
        return this.getUniqueTag();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u7acb\u65b9\u4f53\u96c6\u5408", child=true)
    public Iterator<IPSAppBICube> getPSAppBICubes() {
        if (this.psAppBICubeMap == null || this.psAppBICubeMap.size() == 0) {
            return null;
        }
        return this.psAppBICubeMap.values().iterator();
    }

    @Override
    public IPSAppBICube getPSAppBICube(IPSSysBICube iPSSysBICube, boolean bTryMode) throws Exception {
        IPSAppBICube iPSAppBICube = null;
        if (this.psAppBICubeMap != null) {
            iPSAppBICube = this.psAppBICubeMap.get(iPSSysBICube.getId());
        }
        if (iPSAppBICube != null || bTryMode) {
            return iPSAppBICube;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53[%1$s]\u5bf9\u4e8e\u7684\u5e94\u7528\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u5bf9\u8c61", iPSSysBICube.getName()));
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u96c6\u5408", child=true)
    public Iterator<IPSAppBIReport> getPSAppBIReports() {
        if (this.psAppBIReportMap == null || this.psAppBIReportMap.size() == 0) {
            return null;
        }
        return this.psAppBIReportMap.values().iterator();
    }

    @Override
    public IPSAppBIReport getPSAppBIReport(IPSSysBIReport iPSSysBIReport, boolean bTryMode) throws Exception {
        IPSAppBIReport iPSAppBIReport = null;
        if (this.psAppBIReportMap != null) {
            iPSAppBIReport = this.psAppBIReportMap.get(iPSSysBIReport.getId());
        }
        if (iPSAppBIReport != null || bTryMode) {
            return iPSAppBIReport;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u667a\u80fd\u62a5\u8868[%1$s]\u5bf9\u4e8e\u7684\u5e94\u7528\u667a\u80fd\u62a5\u8868\u5bf9\u8c61", iPSSysBIReport.getName()));
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        return this.getPSSysBIScheme().getUniqueTag();
    }
}

