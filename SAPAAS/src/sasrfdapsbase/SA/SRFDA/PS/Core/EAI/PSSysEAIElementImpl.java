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

import SA.SRFDA.PS.Core.EAI.IPSEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIScheme;
import SA.SRFDA.PS.Core.EAI.PSSysEAIElementAttrImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAIElementREImpl;
import SA.SRFDA.PS.Core.EAI.PSSysEAISchemeObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIElement;
import SA.SRFDA.PS.Data.PSSysEAIElementAttr;
import SA.SRFDA.PS.Data.PSSysEAIElementRE;
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

public class PSSysEAIElementImpl
extends PSSysEAISchemeObjectImpl
implements IPSSysEAIElement {
    private static final Log log = LogFactory.getLog(PSSysEAIElementImpl.class);
    protected PSSysEAIElement psSysEAIElement = null;
    private ArrayList<IPSSysEAIElementAttr> psSysEAIElementAttrList = new ArrayList();
    private Map<String, IPSSysEAIElementAttr> psSysEAIElementAttrMap = new LinkedHashMap<String, IPSSysEAIElementAttr>();
    private ArrayList<IPSSysEAIElementRE> psSysEAIElementREList = new ArrayList();
    private Map<String, IPSSysEAIElementRE> psSysEAIElementREMap = new LinkedHashMap<String, IPSSysEAIElementRE>();
    private String strElementType = "COMPLEX";
    private String strOrderMode = "SEQUENCE";

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIScheme iPSSysEAIScheme, PSSysEAIElement psSysEAIElement) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIScheme(iPSSysEAIScheme);
            this.psSysEAIElement = psSysEAIElement;
            this.setId(this.psSysEAIElement.getPSSYSEAIELEMENTID());
            this.setName(this.psSysEAIElement.getPSSYSEAIELEMENTNAME());
            this.setPSObjectData(this.psSysEAIElement);
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElement.getEAIELEMENTTYPE())) {
                this.strElementType = this.psSysEAIElement.getEAIELEMENTTYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElement.getORDERMODE())) {
                this.strOrderMode = this.psSysEAIElement.getORDERMODE();
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
        if ("ATTRIBUTEGROUP".equals(this.getElementType()) || "COMPLEX".equals(this.getElementType())) {
            this.onPreparePSSysEAIElementAttrs();
        }
        if ("ELEMENTGROUP".equals(this.getElementType()) || "COMPLEX".equals(this.getElementType())) {
            this.onPreparePSSysEAIElementREs();
        }
        super.onInit();
    }

    protected void onPreparePSSysEAIElementAttrs() throws Exception {
        this.psSysEAIElementAttrList.clear();
        Vector<PSSysEAIElementAttr> psSysEAIElementAttrList = new Vector<PSSysEAIElementAttr>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIElementAttrs(this.getId(), psSysEAIElementAttrList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u96c6\u6210\u5143\u7d20\u5c5e\u6027\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIElementAttr psSysEAIElementAttr : psSysEAIElementAttrList) {
            PSSysEAIElementAttrImpl iPSSysEAIElementAttr = new PSSysEAIElementAttrImpl();
            iPSSysEAIElementAttr.init(this.getDAGlobalHelper(), this, psSysEAIElementAttr);
            this.psSysEAIElementAttrList.add(iPSSysEAIElementAttr);
            this.psSysEAIElementAttrMap.put(iPSSysEAIElementAttr.getId(), iPSSysEAIElementAttr);
            this.psSysEAIElementAttrMap.put(iPSSysEAIElementAttr.getName(), iPSSysEAIElementAttr);
        }
    }

    protected void onPreparePSSysEAIElementREs() throws Exception {
        this.psSysEAIElementREList.clear();
        Vector<PSSysEAIElementRE> psSysEAIElementREList = new Vector<PSSysEAIElementRE>();
        CallResult callResult = this.getPSModelHelper().getPSSysEAIElementREs(this.getId(), psSysEAIElementREList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSSysEAIElementRE psSysEAIElementRE : psSysEAIElementREList) {
            PSSysEAIElementREImpl iPSSysEAIElementRE = new PSSysEAIElementREImpl();
            iPSSysEAIElementRE.init(this.getDAGlobalHelper(), this, psSysEAIElementRE);
            this.psSysEAIElementREList.add(iPSSysEAIElementRE);
            this.psSysEAIElementREMap.put(iPSSysEAIElementRE.getId(), iPSSysEAIElementRE);
            this.psSysEAIElementREMap.put(iPSSysEAIElementRE.getName(), iPSSysEAIElementRE);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSEAIELEMENT";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIElement.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5143\u7d20\u6807\u8bb0")
    public String getElementTag() {
        return this.psSysEAIElement.getEAIELEMENTTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5143\u7d20\u6807\u8bb02")
    public String getElementTag2() {
        return this.psSysEAIElement.getEAIELEMENTTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u5c5e\u6027\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIElementAttr> getAllPSSysEAIElementAttrs() throws Exception {
        if (this.psSysEAIElementAttrList == null || this.psSysEAIElementAttrList.size() == 0) {
            return null;
        }
        return this.psSysEAIElementAttrList.iterator();
    }

    @Override
    public IPSSysEAIElementAttr getPSSysEAIElementAttr(String strPSSysEAIElementAttrId) throws Exception {
        return this.getPSSysEAIElementAttr(strPSSysEAIElementAttrId, false);
    }

    @Override
    public IPSEAIElementAttr getPSEAIElementAttr(String strPSEAIElementAttrId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIElementAttr(strPSEAIElementAttrId, bTryMode);
    }

    @Override
    public IPSSysEAIElementAttr getPSSysEAIElementAttr(String strPSSysEAIElementAttrId, boolean bTryMode) throws Exception {
        IPSSysEAIElementAttr iPSSysEAIElementAttr = null;
        if (this.psSysEAIElementAttrMap != null) {
            iPSSysEAIElementAttr = this.psSysEAIElementAttrMap.get(strPSSysEAIElementAttrId);
        }
        if (iPSSysEAIElementAttr != null || bTryMode) {
            return iPSSysEAIElementAttr;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5143\u7d20\u5c5e\u6027[%1$s]", (Object)strPSSysEAIElementAttrId));
    }

    @Override
    public Iterator<? extends IPSEAIElementAttr> getAllPSEAIElementAttrs() throws Exception {
        return this.getAllPSSysEAIElementAttrs();
    }

    @Override
    public IPSEAIElementAttr getPSEAIElementAttr(String strPSEAIElementAttrId) throws Exception {
        return this.getPSSysEAIElementAttr(strPSEAIElementAttrId);
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20\u96c6\u5408", child=true)
    public Iterator<? extends IPSSysEAIElementRE> getAllPSSysEAIElementREs() throws Exception {
        if (this.psSysEAIElementREList == null || this.psSysEAIElementREList.size() == 0) {
            return null;
        }
        return this.psSysEAIElementREList.iterator();
    }

    @Override
    public IPSSysEAIElementRE getPSSysEAIElementRE(String strPSSysEAIElementREId) throws Exception {
        return this.getPSSysEAIElementRE(strPSSysEAIElementREId, false);
    }

    @Override
    public IPSEAIElementRE getPSEAIElementRE(String strPSEAIElementREId, boolean bTryMode) throws Exception {
        return this.getPSSysEAIElementRE(strPSEAIElementREId, bTryMode);
    }

    @Override
    public IPSSysEAIElementRE getPSSysEAIElementRE(String strPSSysEAIElementREId, boolean bTryMode) throws Exception {
        IPSSysEAIElementRE iPSSysEAIElementRE = null;
        if (this.psSysEAIElementREMap != null) {
            iPSSysEAIElementRE = this.psSysEAIElementREMap.get(strPSSysEAIElementREId);
        }
        if (iPSSysEAIElementRE != null || bTryMode) {
            return iPSSysEAIElementRE;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20[%1$s]", (Object)strPSSysEAIElementREId));
    }

    @Override
    public Iterator<? extends IPSEAIElementRE> getAllPSEAIElementREs() throws Exception {
        return this.getAllPSSysEAIElementREs();
    }

    @Override
    public IPSEAIElementRE getPSEAIElementRE(String strPSEAIElementREId) throws Exception {
        return this.getPSSysEAIElementRE(strPSEAIElementREId);
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u7c7b\u578b", codelist="EAIElementType")
    public String getElementType() {
        return this.strElementType;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5143\u7d20\u6392\u5e8f\u6a21\u5f0f", codelist="EAIElementREOrderMode")
    public String getOrderMode() {
        return this.strOrderMode;
    }
}

