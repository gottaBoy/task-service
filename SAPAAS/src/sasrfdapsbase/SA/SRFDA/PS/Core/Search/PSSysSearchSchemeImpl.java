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
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.PSSysSearchDEImpl;
import SA.SRFDA.PS.Core.Search.PSSysSearchDocImpl;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSearchDE;
import SA.SRFDA.PS.Data.PSSysSearchDoc;
import SA.SRFDA.PS.Data.PSSysSearchScheme;
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

public class PSSysSearchSchemeImpl
extends PSSystemObjectImpl
implements IPSSysSearchScheme {
    private static final Log log = LogFactory.getLog(PSSysSearchSchemeImpl.class);
    protected PSSysSearchScheme psSysSearchScheme = null;
    private ArrayList<IPSSysSearchDoc> psSysSearchDocList = new ArrayList();
    private Map<String, IPSSysSearchDoc> psSysSearchDocMap = new LinkedHashMap<String, IPSSysSearchDoc>();
    private ArrayList<IPSSysSearchDE> psSysSearchDEList = new ArrayList();
    private Map<String, IPSSysSearchDE> psSysSearchDEMap = new LinkedHashMap<String, IPSSysSearchDE>();
    private String strCodeName = "";
    private IPSSystemModule iPSSystemModule = null;
    private int nDefaultDocReplicas = 1;
    private int nDefaultDocShards = 5;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSSysModelGroup iPSSysModelGroup = null;
    private String strServicePath = null;
    private String strServiceParam = null;
    private String strServiceParam2 = null;
    private String strAuthMode = "NONE";
    private String strAuthClientId = null;
    private String strAuthClientSecret = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSearchScheme psSysSearchScheme) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysSearchScheme = psSysSearchScheme;
            this.setId(this.psSysSearchScheme.getPSSYSSEARCHSCHEMEID());
            this.setName(this.psSysSearchScheme.getPSSYSSEARCHSCHEMENAME());
            this.setPSObjectData(this.psSysSearchScheme);
            this.strCodeName = this.psSysSearchScheme.getCODENAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSearchScheme.getPSSYSMODELGROUPID())) {
                this.iPSSysModelGroup = this.getPSSystem().getPSSysModelGroup(this.psSysSearchScheme.getPSSYSMODELGROUPID());
            } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psSysSearchScheme.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysSearchScheme.getPSMODULEID());
            }
            if (!this.psSysSearchScheme.isDOCREPLICASNull() && this.psSysSearchScheme.getDOCREPLICAS() > 0) {
                this.nDefaultDocReplicas = this.psSysSearchScheme.getDOCREPLICAS();
            }
            if (!this.psSysSearchScheme.isDOCSHARDSNull() && this.psSysSearchScheme.getDOCSHARDS() > 0) {
                this.nDefaultDocShards = this.psSysSearchScheme.getDOCSHARDS();
            }
            this.strAuthMode = this.psSysSearchScheme.getAUTHMODE();
            this.strAuthClientId = this.psSysSearchScheme.getAUTHCLIENTID();
            this.strAuthClientSecret = this.psSysSearchScheme.getAUTHCLIENTSECRET();
            this.strServicePath = this.psSysSearchScheme.getSERVICEPATH();
            this.strServiceParam = this.psSysSearchScheme.getSERVICEPARAM();
            this.strServiceParam2 = this.psSysSearchScheme.getSERVICEPARAM2();
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
        String strPSSysSFPluginId = this.psSysSearchScheme.getPSSYSSFPLUGINID();
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
        this.onPreparePSSysSearchDocs();
        this.onPreparePSSysSearchDEs();
        super.onInit();
    }

    protected void onPreparePSSysSearchDocs() throws Exception {
        this.psSysSearchDocList.clear();
        Vector<PSSysSearchDoc> psSysSearchDocList = new Vector<PSSysSearchDoc>();
        CallResult callResult = this.getPSModelHelper().getPSSysSearchDocs(this.getId(), psSysSearchDocList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5168\u6587\u68c0\u7d22\u6587\u6863\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSearchDoc psSysSearchDoc : psSysSearchDocList) {
            PSSysSearchDocImpl iPSSysSearchDoc = new PSSysSearchDocImpl();
            iPSSysSearchDoc.init(this.getDAGlobalHelper(), this, psSysSearchDoc);
            this.psSysSearchDocList.add(iPSSysSearchDoc);
            this.psSysSearchDocMap.put(iPSSysSearchDoc.getId(), iPSSysSearchDoc);
            this.psSysSearchDocMap.put(iPSSysSearchDoc.getName(), iPSSysSearchDoc);
        }
    }

    protected void onPreparePSSysSearchDEs() throws Exception {
        this.psSysSearchDEList.clear();
        Vector<PSSysSearchDE> psSysSearchDEList = new Vector<PSSysSearchDE>();
        CallResult callResult = this.getPSModelHelper().getPSSysSearchDEs(this.getId(), psSysSearchDEList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSearchDE psSysSearchDE : psSysSearchDEList) {
            PSSysSearchDEImpl iPSSysSearchDE = new PSSysSearchDEImpl();
            iPSSysSearchDE.init(this.getDAGlobalHelper(), this, psSysSearchDE);
            this.psSysSearchDEList.add(iPSSysSearchDE);
            this.psSysSearchDEMap.put(iPSSysSearchDE.getId(), iPSSysSearchDE);
            this.psSysSearchDEMap.put(iPSSysSearchDE.getName(), iPSSysSearchDE);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHSCHEME";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.calcCodeName();
    }

    protected String calcCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false")
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
    @PSModelRTMeta(description="\u641c\u7d22\u5f15\u64ce\u7c7b\u578b", codelist="SearchEngineType", group="\u57fa\u672c", order=125)
    public String getSearchEngineType() {
        return this.psSysSearchScheme.getSEARCHENGINETYPE();
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u6587\u6863\u96c6\u5408", child=true, dynamodelmode=4, group="\u57fa\u672c", order=140)
    public Iterator<? extends IPSSysSearchDoc> getAllPSSysSearchDocs() {
        if (this.psSysSearchDocList == null || this.psSysSearchDocList.size() == 0) {
            return null;
        }
        return this.psSysSearchDocList.iterator();
    }

    @Override
    public Iterator<? extends IPSSearchDoc> getAllPSSearchDocs() {
        return this.getAllPSSysSearchDocs();
    }

    @Override
    public IPSSearchDoc getPSSearchDoc(String strPSSearchDocId) throws Exception {
        return this.getPSSysSearchDoc(strPSSearchDocId);
    }

    @Override
    public IPSSearchDoc getPSSearchDoc(String strPSSearchDocId, boolean bTryMode) throws Exception {
        return this.getPSSysSearchDoc(strPSSearchDocId, bTryMode);
    }

    @Override
    public IPSSysSearchDoc getPSSysSearchDoc(String strPSSysSearchDocId) throws Exception {
        return this.getPSSysSearchDoc(strPSSysSearchDocId, false);
    }

    @Override
    public IPSSysSearchDoc getPSSysSearchDoc(String strPSSysSearchDocId, boolean bTryMode) throws Exception {
        IPSSysSearchDoc iPSSysSearchDoc = null;
        if (this.psSysSearchDocMap != null) {
            iPSSysSearchDoc = this.psSysSearchDocMap.get(strPSSysSearchDocId);
        }
        if (iPSSysSearchDoc != null || bTryMode) {
            return iPSSysSearchDoc;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u6587\u6863[%1$s]", (Object)strPSSysSearchDocId));
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u5b9e\u4f53\u96c6\u5408", child=true, dynamodelmode=4, group="\u57fa\u672c", order=145)
    public Iterator<? extends IPSSysSearchDE> getAllPSSysSearchDEs() {
        if (this.psSysSearchDEList == null || this.psSysSearchDEList.size() == 0) {
            return null;
        }
        return this.psSysSearchDEList.iterator();
    }

    @Override
    public Iterator<? extends IPSSearchDE> getAllPSSearchDEs() {
        return this.getAllPSSysSearchDEs();
    }

    @Override
    public IPSSearchDE getPSSearchDE(String strPSSearchDEId) throws Exception {
        return this.getPSSysSearchDE(strPSSearchDEId);
    }

    @Override
    public IPSSearchDE getPSSearchDE(String strPSSearchDEId, boolean bTryMode) throws Exception {
        return this.getPSSysSearchDE(strPSSearchDEId, bTryMode);
    }

    @Override
    public IPSSysSearchDE getPSSysSearchDE(String strPSSysSearchDEId) throws Exception {
        return this.getPSSysSearchDE(strPSSysSearchDEId, false);
    }

    @Override
    public IPSSysSearchDE getPSSysSearchDE(String strPSSysSearchDEId, boolean bTryMode) throws Exception {
        IPSSysSearchDE iPSSysSearchDE = null;
        if (this.psSysSearchDEMap != null) {
            iPSSysSearchDE = this.psSysSearchDEMap.get(strPSSysSearchDEId);
        }
        if (iPSSysSearchDE != null || bTryMode) {
            return iPSSysSearchDE;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u5b9e\u4f53[%1$s]", (Object)strPSSysSearchDEId));
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6587\u6863\u5206\u7247")
    public int getDefaultDocShards() {
        return this.nDefaultDocShards;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6587\u6863\u526f\u672c")
    public int getDefaultDocReplicas() {
        return this.nDefaultDocReplicas;
    }

    @Override
    public IPSSysSearchDoc getPSSysSearchDoc(IPSSysSearchDE iPSSysSearchDE) throws Exception {
        IPSSysSearchDoc iPSSysSearchDoc = this.getPSSysSearchDoc(iPSSysSearchDE.getName(), true);
        if (iPSSysSearchDoc == null) {
            PSSysSearchDoc psSysSearchDoc = new PSSysSearchDoc();
            psSysSearchDoc.setPSSYSSEARCHDOCID(iPSSysSearchDE.getId());
            psSysSearchDoc.setPSSYSSEARCHDOCNAME(iPSSysSearchDE.getName());
            psSysSearchDoc.setCODENAME(iPSSysSearchDE.getCodeName());
            PSSysSearchDocImpl psSysSearchDocImpl = new PSSysSearchDocImpl();
            psSysSearchDocImpl.init(this.getDAGlobalHelper(), this, psSysSearchDoc);
            this.psSysSearchDocList.add(psSysSearchDocImpl);
            this.psSysSearchDocMap.put(psSysSearchDocImpl.getId(), psSysSearchDocImpl);
            this.psSysSearchDocMap.put(psSysSearchDocImpl.getName(), psSysSearchDocImpl);
            iPSSysSearchDoc = psSysSearchDocImpl;
        }
        return iPSSysSearchDoc;
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb0", hideempty2=true)
    public String getSchemeTag() {
        return this.psSysSearchScheme.getSCHEMETAG();
    }

    @Override
    @PSModelRTMeta(description="\u4f53\u7cfb\u6807\u8bb02", hideempty2=true)
    public String getSchemeTag2() {
        return this.psSysSearchScheme.getSCHEMETAG2();
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
        return this.psSysSearchScheme.getAUTHPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u8ba4\u8bc1\u53c2\u65702", fields={"AUTHPARAM2"})
    public String getAuthParam2() {
        return this.psSysSearchScheme.getAUTHPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u578b\u7ec4", dumpref=true, dynamodelmode=4)
    public IPSSysModelGroup getPSSysModelGroup() {
        return this.iPSSysModelGroup;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u540d\u79f0\u8f6c\u5316", codelist="DBObjNameCaseMode", fields={"OBJNAMECASE"})
    public String getDBObjNameCase() {
        return this.psSysSearchScheme.getOBJNAMECASE();
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

