/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BI.PSSysBIAggTableImpl;
import SA.SRFDA.PS.Core.BI.PSSysBICubeImpl;
import SA.SRFDA.PS.Core.BI.PSSysBIDimensionImpl;
import SA.SRFDA.PS.Core.BI.PSSysBIReportImpl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysBIAggTable;
import SA.SRFDA.PS.Data.PSSysBICube;
import SA.SRFDA.PS.Data.PSSysBIDimension;
import SA.SRFDA.PS.Data.PSSysBIReport;
import SA.SRFDA.PS.Data.PSSysBIScheme;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysBISchemeImpl
extends PSSystemObjectImpl
implements IPSSysBIScheme {
    private static final Log log = LogFactory.getLog(PSSysBISchemeImpl.class);
    protected PSSysBIScheme psSysBIScheme = null;
    private ArrayList<IPSSysBIDimension> psSysBIDimensionList = new ArrayList();
    private Map<String, IPSSysBIDimension> psSysBIDimensionMap = new LinkedHashMap<String, IPSSysBIDimension>();
    private ArrayList<IPSSysBICube> psSysBICubeList = new ArrayList();
    private Map<String, IPSSysBICube> psSysBICubeMap = new LinkedHashMap<String, IPSSysBICube>();
    private ArrayList<IPSSysBIAggTable> psSysBIAggTableList = new ArrayList();
    private Map<String, IPSSysBIAggTable> psSysBIAggTableMap = new LinkedHashMap<String, IPSSysBIAggTable>();
    private ArrayList<IPSSysBIReport> psSysBIReportList = new ArrayList();
    private Map<String, IPSSysBIReport> psSysBIReportMap = new LinkedHashMap<String, IPSSysBIReport>();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysBIScheme psSysBIScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysBIScheme = psSysBIScheme;
            this.setId(this.psSysBIScheme.getPSSYSBISCHEMEID());
            this.setName(this.psSysBIScheme.getPSSYSBISCHEMENAME());
            this.setPSObjectData(this.psSysBIScheme);
            this.strCodeName = this.psSysBIScheme.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysBIScheme.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSysBIScheme.getPSSYSMODELGROUPID());
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysBIScheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysBIScheme.getPSMODULEID());
            }
            this.strAuthMode = this.psSysBIScheme.getAUTHMODE();
            this.strAuthClientId = this.psSysBIScheme.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysBIScheme.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysBIScheme.getSERVICEPATH();
            this.strServiceParam = this.psSysBIScheme.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysBIScheme.getSERVICEPARAM2();
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
        String strPSSysSFPluginId = this.psSysBIScheme.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        this.onPreparePSSysBIDimensions();
        this.onPreparePSSysBICubes();
        this.onPreparePSSysBIAggTables();
        this.onPreparePSSysBIReports();
        super.onInit();
    }

    protected void onPreparePSSysBIDimensions() throws Exception {
        this.psSysBIDimensionList.clear();
        Vector<PSSysBIDimension> psSysBIDimensionList = new Vector<PSSysBIDimension>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIDimensions(this.getId(), psSysBIDimensionList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIDimension psSysBIDimension : psSysBIDimensionList) {
            PSSysBIDimensionImpl iPSSysBIDimension = new PSSysBIDimensionImpl();
            iPSSysBIDimension.init(this.getDAGlobalHelper(), this, psSysBIDimension);
            this.psSysBIDimensionList.add(iPSSysBIDimension);
            this.psSysBIDimensionMap.put(iPSSysBIDimension.getId(), iPSSysBIDimension);
            this.psSysBIDimensionMap.put(iPSSysBIDimension.getName(), iPSSysBIDimension);
        }
    }

    protected void onPreparePSSysBICubes() throws Exception {
        this.psSysBICubeList.clear();
        Vector<PSSysBICube> psSysBICubeList = new Vector<PSSysBICube>();
        CallResult callResult = this.getPSModelHelper().getPSSysBICubes(this.getId(), psSysBICubeList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBICube psSysBICube : psSysBICubeList) {
            PSSysBICubeImpl iPSSysBICube = new PSSysBICubeImpl();
            iPSSysBICube.init(this.getDAGlobalHelper(), this, psSysBICube);
            this.psSysBICubeList.add(iPSSysBICube);
            this.psSysBICubeMap.put(iPSSysBICube.getId(), iPSSysBICube);
            this.psSysBICubeMap.put(iPSSysBICube.getName(), iPSSysBICube);
        }
    }

    protected void onPreparePSSysBIAggTables() throws Exception {
        this.psSysBIAggTableList.clear();
        Vector<PSSysBIAggTable> psSysBIAggTableList = new Vector<PSSysBIAggTable>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIAggTables(this.getId(), psSysBIAggTableList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIAggTable psSysBIAggTable : psSysBIAggTableList) {
            PSSysBIAggTableImpl iPSSysBIAggTable = new PSSysBIAggTableImpl();
            iPSSysBIAggTable.init(this.getDAGlobalHelper(), this, psSysBIAggTable);
            this.psSysBIAggTableList.add(iPSSysBIAggTable);
            this.psSysBIAggTableMap.put(iPSSysBIAggTable.getId(), iPSSysBIAggTable);
            this.psSysBIAggTableMap.put(iPSSysBIAggTable.getName(), iPSSysBIAggTable);
        }
    }

    protected void onPreparePSSysBIReports() throws Exception {
        this.psSysBIReportList.clear();
        Vector<PSSysBIReport> psSysBIReportList = new Vector<PSSysBIReport>();
        CallResult callResult = this.getPSModelHelper().getPSSysBIReports(this.getId(), psSysBIReportList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u667a\u80fd\u62a5\u8868\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysBIReport psSysBIReport : psSysBIReportList) {
            PSSysBIReportImpl iPSSysBIReport = new PSSysBIReportImpl();
            iPSSysBIReport.init(this.getDAGlobalHelper(), this, psSysBIReport);
            this.psSysBIReportList.add(iPSSysBIReport);
            this.psSysBIReportMap.put(iPSSysBIReport.getId(), iPSSysBIReport);
            this.psSysBIReportMap.put(iPSSysBIReport.getName(), iPSSysBIReport);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSBISCHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u5f15\u64ce\u7c7b\u578b", codelist="BIEngineType")
    public String getBIEngineType() {
        return this.psSysBIScheme.getBIENGINETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIDimension> getAllPSSysBIDimensions() {
        if (this.psSysBIDimensionList == null || this.psSysBIDimensionList.size() == 0) {
            return null;
        }
        return this.psSysBIDimensionList.iterator();
    }

    @Override
    public Iterator<? extends IPSBIDimension> getAllPSBIDimensions() {
        return this.getAllPSSysBIDimensions();
    }

    @Override
    public IPSBIDimension getPSBIDimension(String strPSBIDimensionId) throws Exception {
        return this.getPSSysBIDimension(strPSBIDimensionId);
    }

    @Override
    public IPSBIDimension getPSBIDimension(String strPSBIDimensionId, boolean bTryMode) throws Exception {
        return this.getPSSysBIDimension(strPSBIDimensionId, bTryMode);
    }

    @Override
    public IPSSysBIDimension getPSSysBIDimension(String strPSSysBIDimensionId) throws Exception {
        return this.getPSSysBIDimension(strPSSysBIDimensionId, false);
    }

    @Override
    public IPSSysBIDimension getPSSysBIDimension(String strPSSysBIDimensionId, boolean bTryMode) throws Exception {
        IPSSysBIDimension iPSSysBIDimension = null;
        if (this.psSysBIDimensionMap != null) {
            iPSSysBIDimension = this.psSysBIDimensionMap.get(strPSSysBIDimensionId);
        }
        if (iPSSysBIDimension != null || bTryMode) {
            return iPSSysBIDimension;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6[%1$s]", (Object)strPSSysBIDimensionId));
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u805a\u5408\u6570\u636e\u8868\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIAggTable> getAllPSSysBIAggTables() {
        if (this.psSysBIAggTableList == null || this.psSysBIAggTableList.size() == 0) {
            return null;
        }
        return this.psSysBIAggTableList.iterator();
    }

    @Override
    public Iterator<? extends IPSBIAggTable> getAllPSBIAggTables() {
        return this.getAllPSSysBIAggTables();
    }

    @Override
    public IPSBIAggTable getPSBIAggTable(String strPSBIAggTableId) throws Exception {
        return this.getPSSysBIAggTable(strPSBIAggTableId);
    }

    @Override
    public IPSBIAggTable getPSBIAggTable(String strPSBIAggTableId, boolean bTryMode) throws Exception {
        return this.getPSSysBIAggTable(strPSBIAggTableId, bTryMode);
    }

    @Override
    public IPSSysBIAggTable getPSSysBIAggTable(String strPSSysBIAggTableId) throws Exception {
        return this.getPSSysBIAggTable(strPSSysBIAggTableId, false);
    }

    @Override
    public IPSSysBIAggTable getPSSysBIAggTable(String strPSSysBIAggTableId, boolean bTryMode) throws Exception {
        IPSSysBIAggTable iPSSysBIAggTable = null;
        if (this.psSysBIAggTableMap != null) {
            iPSSysBIAggTable = this.psSysBIAggTableMap.get(strPSSysBIAggTableId);
        }
        if (iPSSysBIAggTable != null || bTryMode) {
            return iPSSysBIAggTable;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u805a\u5408\u6570\u636e\u8868[%1$s]", (Object)strPSSysBIAggTableId));
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u7acb\u65b9\u4f53\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBICube> getAllPSSysBICubes() {
        if (this.psSysBICubeList == null || this.psSysBICubeList.size() == 0) {
            return null;
        }
        return this.psSysBICubeList.iterator();
    }

    @Override
    public Iterator<? extends IPSBICube> getAllPSBICubes() {
        return this.getAllPSSysBICubes();
    }

    @Override
    public IPSBICube getPSBICube(String strPSBICubeId) throws Exception {
        return this.getPSSysBICube(strPSBICubeId);
    }

    @Override
    public IPSBICube getPSBICube(String strPSBICubeId, boolean bTryMode) throws Exception {
        return this.getPSSysBICube(strPSBICubeId, bTryMode);
    }

    @Override
    public IPSSysBICube getPSSysBICube(String strPSSysBICubeId) throws Exception {
        return this.getPSSysBICube(strPSSysBICubeId, false);
    }

    @Override
    public IPSSysBICube getPSSysBICube(String strPSSysBICubeId, boolean bTryMode) throws Exception {
        IPSSysBICube iPSSysBICube = null;
        if (this.psSysBICubeMap != null) {
            iPSSysBICube = this.psSysBICubeMap.get(strPSSysBICubeId);
        }
        if (iPSSysBICube != null || bTryMode) {
            return iPSSysBICube;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7acb\u65b9\u4f53[%1$s]", (Object)strPSSysBICubeId));
    }

    @Override
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u667a\u80fd\u62a5\u8868\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysBIReport> getAllPSSysBIReports() {
        if (this.psSysBIReportList == null || this.psSysBIReportList.size() == 0) {
            return null;
        }
        return this.psSysBIReportList.iterator();
    }

    @Override
    public Iterator<? extends IPSBIReport> getAllPSBIReports() {
        return this.getAllPSSysBIReports();
    }

    @Override
    public IPSBIReport getPSBIReport(String strPSBIReportId) throws Exception {
        return this.getPSSysBIReport(strPSBIReportId);
    }

    @Override
    public IPSBIReport getPSBIReport(String strPSBIReportId, boolean bTryMode) throws Exception {
        return this.getPSSysBIReport(strPSBIReportId, bTryMode);
    }

    @Override
    public IPSSysBIReport getPSSysBIReport(String strPSSysBIReportId) throws Exception {
        return this.getPSSysBIReport(strPSSysBIReportId, false);
    }

    @Override
    public IPSSysBIReport getPSSysBIReport(String strPSSysBIReportId, boolean bTryMode) throws Exception {
        IPSSysBIReport iPSSysBIReport = null;
        if (this.psSysBIReportMap != null) {
            iPSSysBIReport = this.psSysBIReportMap.get(strPSSysBIReportId);
        }
        if (iPSSysBIReport != null || bTryMode) {
            return iPSSysBIReport;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u667a\u80fd\u62a5\u8868[%1$s]", (Object)strPSSysBIReportId));
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getSchemeTag() {
        return this.psSysBIScheme.getBISCHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getSchemeTag2() {
        return this.psSysBIScheme.getBISCHEMETAG2();
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
    @PSModelRTMeta(description="\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8def\u5f84", fields={"SERVICEPATH"})
    public String getServicePath() {
        return this.strServicePath;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u6570", fields={"SERVICEPARAM"})
    public String getServiceParam() {
        return this.strServiceParam;
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u53c2\u65702", fields={"SERVICEPARAM2"})
    public String getServiceParam2() {
        return this.strServiceParam2;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u6a21\u5f0f", codelist="APIAuthMode", fields={"AUTHMODE"})
    public String getAuthMode() {
        return this.strAuthMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u6807\u8bc6", fields={"AUTHCLIENTID"})
    public String getAuthClientId() {
        return this.strAuthClientId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u5ba2\u6237\u7aef\u5bc6\u7801", fields={"AUTHCLIENTSECRET"})
    public String getAuthClientSecret() {
        return this.strAuthClientSecret;
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u6570", fields={"AUTHPARAM"})
    public String getAuthParam() {
        return this.psSysBIScheme.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysBIScheme.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", dumpref=true, dynamodelmode=4)
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode", fields={"OBJNAMECASE"})
    public String getDBObjNameCase() {
        return this.psSysBIScheme.getOBJNAMECASE();
    }

    @Override
    public String getAuthAccessTokenUrl() {
        return null;
    }

    @Override
    public int getAuthTimeout() {
        return 0;
    }
}

