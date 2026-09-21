/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Search;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Search.IPSSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDE;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDEField;
import SA.SRFDA.PS.Core.Search.IPSSysSearchDoc;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Search.PSSysSearchDEFieldImpl;
import SA.SRFDA.PS.Core.Search.PSSysSearchSchemeObjectImpl;
import SA.SRFDA.PS.Data.PSSysSearchDE;
import SA.SRFDA.PS.Data.PSSysSearchDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysSearchDEImpl
extends PSSysSearchSchemeObjectImpl
implements IPSSysSearchDE {
    private static final Log log = LogFactory.getLog(PSSysSearchDEImpl.class);
    protected PSSysSearchDE psSysSearchDE = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysSearchDoc iPSSysSearchDoc = null;
    private ArrayList<IPSSysSearchDEField> psSysSearchDEFieldList = new ArrayList();
    private Map<String, IPSSysSearchDEField> psSysSearchDEFieldMap = new LinkedHashMap<String, IPSSysSearchDEField>();
    private ArrayList<IPSSysSearchDEField> unionKeyValuePSSysSearchDEFieldList = new ArrayList();
    private String strCodeName = null;
    private boolean bNoSQLStorage = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysSearchScheme iPSSysSearchScheme, PSSysSearchDE psSysSearchDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysSearchScheme(iPSSysSearchScheme);
            this.psSysSearchDE = psSysSearchDE;
            this.setId(this.psSysSearchDE.getPSSYSSEARCHDEID());
            this.setName(this.psSysSearchDE.getPSSYSSEARCHDENAME());
            this.setPSObjectData(this.psSysSearchDE);
            this.iPSDataEntity = this.getPSSysSearchScheme().getPSSystem().getPSDataEntity2(this.psSysSearchDE.getPSDEID());
            this.strCodeName = this.psSysSearchDE.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getPSDataEntity().getCodeName();
            }
            this.iPSSysSearchDoc = !StringHelper.isNullOrEmpty((String)this.psSysSearchDE.getPSSYSSEARCHDOCID()) ? this.getPSSysSearchScheme().getPSSysSearchDoc(this.psSysSearchDE.getPSSYSSEARCHDOCID()) : this.getPSSysSearchScheme().getPSSysSearchDoc(this);
            if (!this.psSysSearchDE.isNOSQLFLAGNull()) {
                this.bNoSQLStorage = this.psSysSearchDE.getNOSQLFLAG();
            }
            this.getPSSysSearchDoc().registerPSSysSearchDE(this);
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
        this.onPreparePSSysSearchDEFields();
        super.onInit();
    }

    protected void onPreparePSSysSearchDEFields() throws Exception {
        Iterator<IPSDEField> psDEFields;
        this.psSysSearchDEFieldList.clear();
        Vector<PSSysSearchDEField> psSysSearchDEFieldList = new Vector<PSSysSearchDEField>();
        CallResult callResult = this.getPSModelHelper().getPSSysSearchDEFields(this.getId(), psSysSearchDEFieldList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysSearchDEField psSysSearchDEField : psSysSearchDEFieldList) {
            PSSysSearchDEFieldImpl iPSSysSearchDEField = new PSSysSearchDEFieldImpl();
            iPSSysSearchDEField.init(this.getDAGlobalHelper(), this, psSysSearchDEField);
            this.psSysSearchDEFieldList.add(iPSSysSearchDEField);
            this.psSysSearchDEFieldMap.put(iPSSysSearchDEField.getId(), iPSSysSearchDEField);
            this.psSysSearchDEFieldMap.put(iPSSysSearchDEField.getName(), iPSSysSearchDEField);
        }
        if (this.isNoSQLStorage() && (psDEFields = this.getPSDataEntity().getAllPSDEFields()) != null) {
            while (psDEFields.hasNext()) {
                IPSDEField iPSDEField = psDEFields.next();
                if (!iPSDEField.isPhisicalDEField() || this.psSysSearchDEFieldMap.containsKey(iPSDEField.getName())) continue;
                PSSysSearchDEField psSysSearchDEField = new PSSysSearchDEField();
                psSysSearchDEField.setPSDEFID(iPSDEField.getId());
                psSysSearchDEField.setPSDEFNAME(iPSDEField.getName());
                psSysSearchDEField.setPSSYSSEARCHDEFIELDID(iPSDEField.getId());
                psSysSearchDEField.setPSSYSSEARCHDEFIELDNAME(iPSDEField.getName());
                psSysSearchDEField.setPSSYSSEARCHDEID(this.getId());
                psSysSearchDEField.setPSSYSSEARCHDENAME(this.getName());
                PSSysSearchDEFieldImpl iPSSysSearchDEField = new PSSysSearchDEFieldImpl();
                iPSSysSearchDEField.init(this.getDAGlobalHelper(), this, psSysSearchDEField);
                this.psSysSearchDEFieldList.add(iPSSysSearchDEField);
                this.psSysSearchDEFieldMap.put(iPSSysSearchDEField.getId(), iPSSysSearchDEField);
                this.psSysSearchDEFieldMap.put(iPSSysSearchDEField.getName(), iPSSysSearchDEField);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public String getModelType() {
        return "PSSYSSEARCHDE";
    }

    @Override
    @PSModelRTMeta(description="\u5168\u6587\u68c0\u7d22\u6587\u6863", dumpref=true, from="IPSSysSearchScheme")
    public IPSSysSearchDoc getPSSysSearchDoc() {
        return this.iPSSysSearchDoc;
    }

    @Override
    public IPSSearchDoc getPSSearchDoc() {
        return this.getPSSysSearchDoc();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408", child=true, dynamodelmode=4)
    public Iterator<? extends IPSSysSearchDEField> getAllPSSysSearchDEFields() throws Exception {
        if (this.psSysSearchDEFieldList == null || this.psSysSearchDEFieldList.size() == 0) {
            return null;
        }
        return this.psSysSearchDEFieldList.iterator();
    }

    @Override
    public IPSSysSearchDEField getPSSysSearchDEField(String strPSSysSearchDEFieldId) throws Exception {
        return this.getPSSysSearchDEField(strPSSysSearchDEFieldId, false);
    }

    @Override
    public IPSSearchDEField getPSSearchDEField(String strPSSearchDEFieldId, boolean bTryMode) throws Exception {
        return this.getPSSysSearchDEField(strPSSearchDEFieldId, bTryMode);
    }

    @Override
    public IPSSysSearchDEField getPSSysSearchDEField(String strPSSysSearchDEFieldId, boolean bTryMode) throws Exception {
        IPSSysSearchDEField iPSSysSearchDEField = null;
        if (this.psSysSearchDEFieldMap != null) {
            iPSSysSearchDEField = this.psSysSearchDEFieldMap.get(strPSSysSearchDEFieldId);
        }
        if (iPSSysSearchDEField != null || bTryMode) {
            return iPSSysSearchDEField;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5168\u6587\u68c0\u7d22\u5b9e\u4f53\u5c5e\u6027[%1$s]", (Object)strPSSysSearchDEFieldId));
    }

    @Override
    public Iterator<? extends IPSSearchDEField> getAllPSSearchDEFields() throws Exception {
        return this.getAllPSSysSearchDEFields();
    }

    @Override
    public IPSSearchDEField getPSSearchDEField(String strPSSearchDEFieldId) throws Exception {
        return this.getPSSysSearchDEField(strPSSearchDEFieldId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb0", hideempty2=true)
    public String getDETag() {
        return this.psSysSearchDE.getDETAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6807\u8bb02", hideempty2=true)
    public String getDETag2() {
        return this.psSysSearchDE.getDETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u4f5c\u4e3aNoSQL\u5b58\u50a8", ignoredumpvalues="false")
    public boolean isNoSQLStorage() {
        return this.bNoSQLStorage;
    }
}

