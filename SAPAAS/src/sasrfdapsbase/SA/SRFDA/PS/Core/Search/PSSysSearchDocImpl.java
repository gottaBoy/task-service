/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Search.IPSSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSearchField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.PSSysSearchFieldImpl;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeObjectImpl;
import SA.SRFDA.PS.Data.PSSysSearchDoc;
import SA.SRFDA.PS.Data.PSSysSearchField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchDocImpl
extends PSSysSearchSchemeObjectImpl
implements IPSSysSearchDoc {
    private static final Log log = LogFactory.getLog(PSSysSearchDocImpl.class);
    protected PSSysSearchDoc psSysSearchDoc = null;
    private ArrayList<IPSSysSearchField> psSysSearchFieldList = new ArrayList();
    private Map<String, IPSSysSearchField> psSysSearchFieldMap = new LinkedHashMap<String, IPSSysSearchField>();
    private ArrayList<IPSSysSearchDE> psSysSearchDEList = new ArrayList();
    private Map<String, IPSSysSearchDE> psSysSearchDEMap = new LinkedHashMap<String, IPSSysSearchDE>();
    private int nShards = 5;
    private int nReplicas = 1;
    private Properties docParams = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSearchScheme iPSSysSearchScheme, PSSysSearchDoc psSysSearchDoc) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysSearchScheme(iPSSysSearchScheme);
            this.psSysSearchDoc = psSysSearchDoc;
            this.setId(this.psSysSearchDoc.getPSSYSSEARCHDOCID());
            this.setName(this.psSysSearchDoc.getPSSYSSEARCHDOCNAME());
            this.setPSObjectData(this.psSysSearchDoc);
            this.nShards = !this.psSysSearchDoc.isSHARDSNull() && this.psSysSearchDoc.getSHARDS() > 0 ? this.psSysSearchDoc.getSHARDS() : this.getPSSysSearchScheme().getDefaultDocShards();
            this.nReplicas = !this.psSysSearchDoc.isREPLICASNull() && this.psSysSearchDoc.getREPLICAS() > 0 ? this.psSysSearchDoc.getREPLICAS() : this.getPSSysSearchScheme().getDefaultDocReplicas();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSearchDoc.getDOCPARAMS())) {
                this.docParams = PropertiesHelper.Load((String)this.psSysSearchDoc.getDOCPARAMS());
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
        this.onPreparePSSysSearchFields();
        super.onInit();
    }

    protected void onPreparePSSysSearchFields() throws Exception {
        this.psSysSearchFieldList.clear();
        Vector<PSSysSearchField> psSysSearchFieldList = new Vector<PSSysSearchField>();
        CallResult callResult = this.getPSModelHelper().getPSSysSearchFields(this.getId(), psSysSearchFieldList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u6587\u68c0\u7d22\u6587\u6863\u5c5e\u6027\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSearchField psSysSearchField : psSysSearchFieldList) {
            PSSysSearchFieldImpl iPSSysSearchField = new PSSysSearchFieldImpl();
            iPSSysSearchField.init(this.getDAGlobalHelper(), this, psSysSearchField);
            this.psSysSearchFieldList.add(iPSSysSearchField);
            this.psSysSearchFieldMap.put(iPSSysSearchField.getId(), iPSSysSearchField);
            this.psSysSearchFieldMap.put(iPSSysSearchField.getName(), iPSSysSearchField);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHDOC";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", fields={"CODENAME"})
    public String getCodeName() {
        return this.psSysSearchDoc.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.psSysSearchDoc.getLOGICNAME();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7247\u6570", fields={"SHARDS"})
    public int getShards() {
        return this.nShards;
    }

    @Override
    @PSModelRTMeta(description="\u526f\u672c\u6570", fields={"REPLICAS"})
    public int getReplicas() {
        return this.nReplicas;
    }

    @Override
    public Iterator<? extends IPSSearchDE> getAllPSSearchDEs() throws Exception {
        return this.getAllPSSysSearchDEs();
    }

    @Override
    public IPSSearchDE getPSSearchDE(String strSearchDEId) throws Exception {
        return this.getPSSysSearchDE(strSearchDEId);
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u96c6\u5408")
    public Iterator<? extends IPSSysSearchDE> getAllPSSysSearchDEs() throws Exception {
        if (this.psSysSearchDEList == null || this.psSysSearchDEList.size() == 0) {
            return null;
        }
        return this.psSysSearchDEList.iterator();
    }

    @Override
    public IPSSysSearchDE getPSSysSearchDE(String strPSSysSearchDEId) throws Exception {
        return this.getPSSysSearchDE(strPSSysSearchDEId, false);
    }

    @Override
    public IPSSearchDE getPSSearchDE(String strSearchDEId, boolean bTryMode) throws Exception {
        return this.getPSSysSearchDE(strSearchDEId, bTryMode);
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
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u5c5e\u6027[%1$s]", (Object)strPSSysSearchDEId));
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u5c5e\u6027\u96c6\u5408", child=true, dynamodelmode=4)
    public Iterator<? extends IPSSysSearchField> getAllPSSysSearchFields() throws Exception {
        if (this.psSysSearchFieldList == null || this.psSysSearchFieldList.size() == 0) {
            return null;
        }
        return this.psSysSearchFieldList.iterator();
    }

    @Override
    public IPSSysSearchField getPSSysSearchField(String strPSSysSearchFieldId) throws Exception {
        return this.getPSSysSearchField(strPSSysSearchFieldId, false);
    }

    @Override
    public IPSSearchField getPSSearchField(String strPSSearchFieldId, boolean bTryMode) throws Exception {
        return this.getPSSysSearchField(strPSSearchFieldId, bTryMode);
    }

    @Override
    public IPSSysSearchField getPSSysSearchField(String strPSSysSearchFieldId, boolean bTryMode) throws Exception {
        IPSSysSearchField iPSSysSearchField = null;
        if (this.psSysSearchFieldMap != null) {
            iPSSysSearchField = this.psSysSearchFieldMap.get(strPSSysSearchFieldId);
        }
        if (iPSSysSearchField != null || bTryMode) {
            return iPSSysSearchField;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u5c5e\u6027[%1$s]", (Object)strPSSysSearchFieldId));
    }

    @Override
    public Iterator<? extends IPSSearchField> getAllPSSearchFields() throws Exception {
        return this.getAllPSSysSearchFields();
    }

    @Override
    public IPSSearchField getPSSearchField(String strPSSearchFieldId) throws Exception {
        return this.getPSSysSearchField(strPSSearchFieldId);
    }

    @Override
    public void registerPSSysSearchDE(IPSSysSearchDE iPSSysSearchDE) {
        this.psSysSearchDEList.add(iPSSysSearchDE);
        this.psSysSearchDEMap.put(iPSSysSearchDE.getId(), iPSSysSearchDE);
        this.psSysSearchDEMap.put(iPSSysSearchDE.getName(), iPSSysSearchDE);
    }

    @Override
    public IPSSysSearchField getPSSysSearchField(IPSSysSearchDEField iPSSysSearchDEField) throws Exception {
        IPSSysSearchField iPSSysSearchField = this.getPSSysSearchField(iPSSysSearchDEField.getName(), true);
        if (iPSSysSearchField == null) {
            PSSysSearchField psSysSearchField = new PSSysSearchField();
            psSysSearchField.setPSSYSSEARCHFIELDID(iPSSysSearchDEField.getId());
            psSysSearchField.setPSSYSSEARCHFIELDNAME(iPSSysSearchDEField.getName());
            psSysSearchField.setCODENAME(iPSSysSearchDEField.getCodeName());
            if (iPSSysSearchDEField.getPSDEField() != null) {
                psSysSearchField.setSTDDATATYPE(iPSSysSearchDEField.getPSDEField().getStdDataType());
                if (iPSSysSearchDEField.getPSDEField().isKeyDEField()) {
                    psSysSearchField.setPKEY(true);
                }
            }
            PSSysSearchFieldImpl psSysSearchFieldImpl = new PSSysSearchFieldImpl();
            psSysSearchFieldImpl.init(this.getDAGlobalHelper(), this, psSysSearchField);
            this.psSysSearchFieldList.add(psSysSearchFieldImpl);
            this.psSysSearchFieldMap.put(psSysSearchFieldImpl.getId(), psSysSearchFieldImpl);
            this.psSysSearchFieldMap.put(psSysSearchFieldImpl.getName(), psSysSearchFieldImpl);
            iPSSysSearchField = psSysSearchFieldImpl;
        }
        return iPSSysSearchField;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u6863\u6807\u8bb0", fields={"DOCTAG"})
    public String getDocTag() {
        return this.psSysSearchDoc.getDOCTAG();
    }

    @Override
    @PSModelRTMeta(description="\u6587\u6863\u6807\u8bb02", fields={"DOCTAG2"})
    public String getDocTag2() {
        return this.psSysSearchDoc.getDOCTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570", fields={"DOCPARAMS"})
    public Properties getDocParams() {
        return this.docParams;
    }
}

