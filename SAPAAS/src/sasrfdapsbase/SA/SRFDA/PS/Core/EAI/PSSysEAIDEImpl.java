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
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.EAI.IPSEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDEFieldImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDERImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIDE;
import SA.SRFDA.PS.Data.PSSysEAIDEField;
import SA.SRFDA.PS.Data.PSSysEAIDER;
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

public class PSSysEAIDEImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIDE {
    private static final Log log = LogFactory.getLog(PSSysEAIDEImpl.class);
    protected PSSysEAIDE psSysEAIDE = null;
    private ArrayList<IPSSysEAIDEField> psSysEAIDEFieldList = new ArrayList();
    private Map<String, IPSSysEAIDEField> psSysEAIDEFieldMap = new LinkedHashMap<String, IPSSysEAIDEField>();
    private ArrayList<IPSSysEAIDER> psSysEAIDERList = new ArrayList();
    private Map<String, IPSSysEAIDER> psSysEAIDERMap = new LinkedHashMap<String, IPSSysEAIDER>();
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysEAIElement iPSSysEAIElement = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIScheme iPSSysEAIScheme, PSSysEAIDE psSysEAIDE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIScheme(iPSSysEAIScheme);
            this.psSysEAIDE = psSysEAIDE;
            this.setId(this.psSysEAIDE.getPSSYSEAIDEID());
            this.setName(this.psSysEAIDE.getPSSYSEAIDENAME());
            this.setPSObjectData(this.psSysEAIDE);
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDE.getPSDEID())) {
                this.iPSDataEntity = this.getPSSysEAIScheme().getPSSystem().getPSDataEntity2(this.psSysEAIDE.getPSDEID());
            }
            if (this.getPSDataEntity() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDE.getPSSYSEAIELEMENTID())) {
                this.iPSSysEAIElement = this.getPSSysEAIScheme().getPSSysEAIElement(this.psSysEAIDE.getPSSYSEAIELEMENTID());
            }
            if (this.getPSSysEAIElement() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u96c6\u6210\u5143\u7d20");
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
        this.onPreparePSSysEAIDEFields();
        this.onPreparePSSysEAIDERs();
        super.onInit();
    }

    protected void onPreparePSSysEAIDEFields() throws Exception {
        this.psSysEAIDEFieldList.clear();
        Vector<PSSysEAIDEField> psSysEAIDEFieldList = new Vector<PSSysEAIDEField>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIDEFields(this.getId(), psSysEAIDEFieldList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIDEField psSysEAIDEField : psSysEAIDEFieldList) {
            PSSysEAIDEFieldImpl iPSSysEAIDEField = new PSSysEAIDEFieldImpl();
            iPSSysEAIDEField.init(this.getDAGlobalHelper(), this, psSysEAIDEField);
            this.psSysEAIDEFieldList.add(iPSSysEAIDEField);
            this.psSysEAIDEFieldMap.put(iPSSysEAIDEField.getId(), iPSSysEAIDEField);
            this.psSysEAIDEFieldMap.put(iPSSysEAIDEField.getName(), iPSSysEAIDEField);
        }
    }

    protected void onPreparePSSysEAIDERs() throws Exception {
        this.psSysEAIDERList.clear();
        Vector<PSSysEAIDER> psSysEAIDERList = new Vector<PSSysEAIDER>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIDERs(this.getId(), psSysEAIDERList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIDER psSysEAIDER : psSysEAIDERList) {
            PSSysEAIDERImpl iPSSysEAIDER = new PSSysEAIDERImpl();
            iPSSysEAIDER.init(this.getDAGlobalHelper(), this, psSysEAIDER);
            this.psSysEAIDERList.add(iPSSysEAIDER);
            this.psSysEAIDERMap.put(iPSSysEAIDER.getId(), iPSSysEAIDER);
            this.psSysEAIDERMap.put(iPSSysEAIDER.getName(), iPSSysEAIDER);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSEAIDE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIDE.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIDEField> getAllPSSysEAIDEFields() throws Exception {
        if (this.psSysEAIDEFieldList == null || this.psSysEAIDEFieldList.size() == 0) {
            return null;
        }
        return this.psSysEAIDEFieldList.iterator();
    }

    @Override
    public IPSSysEAIDEField getPSSysEAIDEField(String strPSSysEAIDEFieldId) throws Exception {
        return this.getPSSysEAIDEField(strPSSysEAIDEFieldId, false);
    }

    @Override
    public IPSEAIDEField getPSEAIDEField(String strPSEAIDEFieldId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIDEField(strPSEAIDEFieldId, bTryMode);
    }

    @Override
    public IPSSysEAIDEField getPSSysEAIDEField(String strPSSysEAIDEFieldId, boolean bTryMode) throws Exception {
        IPSSysEAIDEField iPSSysEAIDEField = null;
        if (this.psSysEAIDEFieldMap != null) {
            iPSSysEAIDEField = this.psSysEAIDEFieldMap.get(strPSSysEAIDEFieldId);
        }
        if (iPSSysEAIDEField != null || bTryMode) {
            return iPSSysEAIDEField;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04[%1$s]", (Object)strPSSysEAIDEFieldId));
    }

    @Override
    public Iterator<? extends IPSEAIDEField> getAllPSEAIDEFields() throws Exception {
        return this.getAllPSSysEAIDEFields();
    }

    @Override
    public IPSEAIDEField getPSEAIDEField(String strPSEAIDEFieldId) throws Exception {
        return this.getPSSysEAIDEField(strPSEAIDEFieldId);
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIDER> getAllPSSysEAIDERs() throws Exception {
        if (this.psSysEAIDERList == null || this.psSysEAIDERList.size() == 0) {
            return null;
        }
        return this.psSysEAIDERList.iterator();
    }

    @Override
    public IPSSysEAIDER getPSSysEAIDER(String strPSSysEAIDERId) throws Exception {
        return this.getPSSysEAIDER(strPSSysEAIDERId, false);
    }

    @Override
    public IPSEAIDER getPSEAIDER(String strPSEAIDERId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIDER(strPSEAIDERId, bTryMode);
    }

    @Override
    public IPSSysEAIDER getPSSysEAIDER(String strPSSysEAIDERId, boolean bTryMode) throws Exception {
        IPSSysEAIDER iPSSysEAIDER = null;
        if (this.psSysEAIDERMap != null) {
            iPSSysEAIDER = this.psSysEAIDERMap.get(strPSSysEAIDERId);
        }
        if (iPSSysEAIDER != null || bTryMode) {
            return iPSSysEAIDER;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04[%1$s]", (Object)strPSSysEAIDERId));
    }

    @Override
    public Iterator<? extends IPSEAIDER> getAllPSEAIDERs() throws Exception {
        return this.getAllPSSysEAIDERs();
    }

    @Override
    public IPSEAIDER getPSEAIDER(String strPSEAIDERId) throws Exception {
        return this.getPSSysEAIDER(strPSEAIDERId);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u6807\u8bb0", hideempty2=true)
    public String getDETag() {
        return this.psSysEAIDE.getEAIDETAG();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u5b9e\u4f53\u6807\u8bb02", hideempty2=true)
    public String getDETag2() {
        return this.psSysEAIDE.getEAIDETAG2();
    }

    @Override
    public IPSEAIElement getPSEAIElement() {
        return this.getPSSysEAIElement();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u96c6\u6210\u5143\u7d20", dumpref=true, from="IPSSysEAIScheme", hideempty=true)
    public IPSSysEAIElement getPSSysEAIElement() {
        return this.iPSSysEAIElement;
    }
}

