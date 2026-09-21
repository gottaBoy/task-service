/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSBIReportMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBIReportDimensionImpl;
import SA.SRFDA.PS.Core.BI.PSSysBIReportMeasureImpl;
import SA.SRFDA.PS.Core.BI.PSSysBISchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSSysBIReport;
import SA.SRFDA.PS.Data.PSSysBIReportItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBIReportImpl
extends PSSysBISchemeObjectImpl
implements IPSSysBIReport {
    private static final Log log = LogFactory.getLog(PSSysBIReportImpl.class);
    protected PSSysBIReport psSysBIReport = null;
    private ArrayList<IPSSysBIReportMeasure> psSysBIReportMeasureList = new ArrayList();
    private Map<String, IPSSysBIReportMeasure> psSysBIReportMeasureMap = new LinkedHashMap<String, IPSSysBIReportMeasure>();
    private ArrayList<IPSSysBIReportDimension> psSysBIReportDimensionList = new ArrayList();
    private Map<String, IPSSysBIReportDimension> psSysBIReportDimensionMap = new LinkedHashMap<String, IPSSysBIReportDimension>();
    private IPSSysBICube iPSSysBICube = null;
    private IPSSysUniRes iPSSysUniRes = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private Properties reportParams = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysBIScheme iPSSysBIScheme, PSSysBIReport psSysBIReport) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysBIScheme(iPSSysBIScheme);
            this.psSysBIReport = psSysBIReport;
            this.setId(this.psSysBIReport.getPSSYSBIREPORTID());
            this.setName(this.psSysBIReport.getPSSYSBIREPORTNAME());
            this.setPSObjectData(this.psSysBIReport);
            if (this.getPSSysBICube() == null && !StringHelper.isNullOrEmpty((String)this.psSysBIReport.getPSSYSBICUBEID())) {
                this.iPSSysBICube = this.getPSSysBIScheme().getPSSysBICube(this.psSysBIReport.getPSSYSBICUBEID());
            }
            if (this.getPSSysBICube() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIReport.getPSSYSUNIRESID())) {
                this.iPSSysUniRes = this.getPSSysBIScheme().getPSSystem().getPSSysUniRes(this.psSysBIReport.getPSSYSUNIRESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysBIReport.getBIREPORTPARAMS())) {
                this.reportParams = PropertiesHelper.load((String)this.psSysBIReport.getBIREPORTPARAMS());
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
        String strPSSysSFPluginId = this.psSysBIReport.getPSSYSSFPLUGINID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSysBIScheme().getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSysBIScheme().getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSysBIScheme().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysBIReport.getPSSYSPFPLUGINID())) {
            this.iPSSysPFPlugin = this.getPSSysBIScheme().getPSSystem().getPSSysPFPlugin(this.psSysBIReport.getPSSYSPFPLUGINID());
        }
        this.onPreparePSSysBIReportItems();
        super.onInit();
    }

    protected void onPreparePSSysBIReportItems() throws Exception {
        this.psSysBIReportDimensionList.clear();
        this.psSysBIReportMeasureList.clear();
        Vector<PSSysBIReportItem> psSysBIReportItemList = new Vector<PSSysBIReportItem>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIReportItems(this.getId(), psSysBIReportItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u62a5\u8868\u9879\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIReportItem psSysBIReportItem : psSysBIReportItemList) {
            if (StringHelper.compare((String)psSysBIReportItem.getBIREPITEMTYPE(), (String)"MEASURE", (boolean)false) == 0) {
                PSSysBIReportMeasureImpl iPSSysBIReportMeasure = new PSSysBIReportMeasureImpl();
                iPSSysBIReportMeasure.init(this.getDAGlobalHelper(), this, psSysBIReportItem);
                this.psSysBIReportMeasureList.add(iPSSysBIReportMeasure);
                this.psSysBIReportMeasureMap.put(iPSSysBIReportMeasure.getId(), iPSSysBIReportMeasure);
                this.psSysBIReportMeasureMap.put(iPSSysBIReportMeasure.getName(), iPSSysBIReportMeasure);
                continue;
            }
            if (StringHelper.compare((String)psSysBIReportItem.getBIREPITEMTYPE(), (String)"DIMENSION", (boolean)false) != 0) continue;
            PSSysBIReportDimensionImpl iPSSysBIReportDimension = new PSSysBIReportDimensionImpl();
            iPSSysBIReportDimension.init(this.getDAGlobalHelper(), this, psSysBIReportItem);
            this.psSysBIReportDimensionList.add(iPSSysBIReportDimension);
            this.psSysBIReportDimensionMap.put(iPSSysBIReportDimension.getId(), iPSSysBIReportDimension);
            this.psSysBIReportDimensionMap.put(iPSSysBIReportDimension.getName(), iPSSysBIReportDimension);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBIREPORT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysBIReport.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6307\u6807\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIReportMeasure> getAllPSSysBIReportMeasures() throws Exception {
        if (this.psSysBIReportMeasureList == null || this.psSysBIReportMeasureList.size() == 0) {
            return null;
        }
        return this.psSysBIReportMeasureList.iterator();
    }

    @Override
    public IPSSysBIReportMeasure getPSSysBIReportMeasure(String strPSSysBIReportMeasureId) throws Exception {
        return this.getPSSysBIReportMeasure(strPSSysBIReportMeasureId, false);
    }

    @Override
    public IPSBIReportMeasure getPSBIReportMeasure(String strPSBIReportMeasureId, boolean bTryMode) throws Exception {
        return this.getPSSysBIReportMeasure(strPSBIReportMeasureId, bTryMode);
    }

    @Override
    public IPSSysBIReportMeasure getPSSysBIReportMeasure(String strPSSysBIReportMeasureId, boolean bTryMode) throws Exception {
        IPSSysBIReportMeasure iPSSysBIReportMeasure = null;
        if (this.psSysBIReportMeasureMap != null) {
            iPSSysBIReportMeasure = this.psSysBIReportMeasureMap.get(strPSSysBIReportMeasureId);
        }
        if (iPSSysBIReportMeasure != null || bTryMode) {
            return iPSSysBIReportMeasure;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868\u6307\u6807[%1$s]", (Object)strPSSysBIReportMeasureId));
    }

    @Override
    public Iterator<? extends IPSBIReportMeasure> getAllPSBIReportMeasures() throws Exception {
        return this.getAllPSSysBIReportMeasures();
    }

    @Override
    public IPSBIReportMeasure getPSBIReportMeasure(String strPSBIReportMeasureId) throws Exception {
        return this.getPSSysBIReportMeasure(strPSBIReportMeasureId);
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u7ef4\u5ea6\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIReportDimension> getAllPSSysBIReportDimensions() throws Exception {
        if (this.psSysBIReportDimensionList == null || this.psSysBIReportDimensionList.size() == 0) {
            return null;
        }
        return this.psSysBIReportDimensionList.iterator();
    }

    @Override
    public IPSSysBIReportDimension getPSSysBIReportDimension(String strPSSysBIReportDimensionId) throws Exception {
        return this.getPSSysBIReportDimension(strPSSysBIReportDimensionId, false);
    }

    @Override
    public IPSBIReportDimension getPSBIReportDimension(String strPSBIReportDimensionId, boolean bTryMode) throws Exception {
        return this.getPSSysBIReportDimension(strPSBIReportDimensionId, bTryMode);
    }

    @Override
    public IPSSysBIReportDimension getPSSysBIReportDimension(String strPSSysBIReportDimensionId, boolean bTryMode) throws Exception {
        IPSSysBIReportDimension iPSSysBIReportDimension = null;
        if (this.psSysBIReportDimensionMap != null) {
            iPSSysBIReportDimension = this.psSysBIReportDimensionMap.get(strPSSysBIReportDimensionId);
        }
        if (iPSSysBIReportDimension != null || bTryMode) {
            return iPSSysBIReportDimension;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868\u7ef4\u5ea6[%1$s]", (Object)strPSSysBIReportDimensionId));
    }

    @Override
    public Iterator<? extends IPSBIReportDimension> getAllPSBIReportDimensions() throws Exception {
        return this.getAllPSSysBIReportDimensions();
    }

    @Override
    public IPSBIReportDimension getPSBIReportDimension(String strPSBIReportDimensionId) throws Exception {
        return this.getPSSysBIReportDimension(strPSBIReportDimensionId);
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb0", hideempty2=true, fields={"BIREPORTTAG"})
    public String getReportTag() {
        return this.psSysBIReport.getBIREPORTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6807\u8bb02", hideempty2=true, fields={"BIREPORTTAG2"})
    public String getReportTag2() {
        return this.psSysBIReport.getBIREPORTTAG2();
    }

    @Override
    public IPSBICube getPSBICube() {
        return this.getPSSysBICube();
    }

    @Override
    @PSModelRTMeta(description="\u6743\u9650\u7edf\u4e00\u8d44\u6e90\u5bf9\u8c61", dumpref=true, ignorepf=true, fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getPSSysUniRes() {
        if (this.iPSSysUniRes != null) {
            return this.iPSSysUniRes;
        }
        return this.getPSSysBICube().getPSSysUniRes();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u4ee3\u7801", doc="\u7b49\u540c\u8c03\u7528{@link #getPSSysUniRes}.getResCode()")
    public String getSysUniResCode() {
        if (this.getPSSysUniRes() == null) {
            return null;
        }
        return this.getPSSysUniRes().getResCode();
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u6a21\u578b", ignorepf=true, fields={"BIREPORTMODEL"})
    public String getReportModel() {
        return this.psSysBIReport.getBIREPORTMODEL();
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
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53", dumpref=true, from="IPSSysBIScheme", hideempty=true, fields={"PSSYSBICUBEID"})
    public IPSSysBICube getPSSysBICube() {
        return this.iPSSysBICube;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", ignorepf=true, fields={"BIREPORTPARAMS"})
    public Properties getReportParams() {
        return this.reportParams;
    }

    @Override
    @PSModelRTMeta(description="\u62a5\u8868\u754c\u9762\u6a21\u578b", fields={"BIREPORTUIMODEL"})
    public String getReportUIModel() {
        return this.psSysBIReport.getBIREPORTUIMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true, fields={"PSSYSPFPLUGINID"})
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public String getPSLayoutPanelId() {
        return this.psSysBIReport.getPSSYSVIEWPANELID();
    }
}

