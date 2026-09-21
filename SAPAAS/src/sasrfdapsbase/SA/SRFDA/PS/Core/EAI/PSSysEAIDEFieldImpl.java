/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.EAI;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDEField;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementAttr;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDEObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAIDEFieldImpl
extends PSSysEAIDEObjectImpl
implements IPSSysEAIDEField {
    private static final Log log = LogFactory.getLog(PSSysEAIDEFieldImpl.class);
    protected PSSysEAIDEField psSysEAIDEField = null;
    private String strDstType = "ATTRIBUTE";
    private IPSDEField iPSDEField = null;
    private IPSSysEAIElementAttr iPSSysEAIElementAttr = null;
    private IPSSysEAIElementRE iPSSysEAIElementRE = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIDE iPSSysEAIDE, PSSysEAIDEField psSysEAIDEField) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIDE(iPSSysEAIDE);
            this.psSysEAIDEField = psSysEAIDEField;
            this.setId(this.psSysEAIDEField.getPSSYSEAIDEFIELDID());
            this.setName(this.psSysEAIDEField.getPSSYSEAIDEFIELDNAME());
            this.setPSObjectData(this.psSysEAIDEField);
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDEField.getMAPTYPE())) {
                this.strDstType = this.psSysEAIDEField.getMAPTYPE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIDEField.getPSDEFID())) {
                this.iPSDEField = this.getPSSysEAIDE().getPSDataEntity().getPSDEField(this.psSysEAIDEField.getPSDEFID());
            }
            if (this.getPSDEField() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027", new Object[0]));
            }
            if ("ATTRIBUTE".equals(this.getDstType())) {
                if (this.getPSSysEAIElementAttr() == null && !StringHelper.isNullOrEmpty((String)this.psSysEAIDEField.getPSSYSEAIELEMENTATTRID())) {
                    this.iPSSysEAIElementAttr = (IPSSysEAIElementAttr)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIElementAttr>(){

                        public IPSSysEAIElementAttr execute(Object obj) throws Exception {
                            return PSSysEAIDEFieldImpl.this.getPSSysEAIDE().getPSSysEAIElement().getPSSysEAIElementAttr((String)obj);
                        }
                    }, (IPSModelObject)iPSSysEAIDE, (Object)this.psSysEAIDEField.getPSSYSEAIELEMENTATTRID());
                }
                if (this.getPSSysEAIElementAttr() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u7684\u96c6\u6210\u5143\u7d20\u5c5e\u6027", new Object[0]));
                }
            } else if ("ELEMENT".equals(this.getDstType())) {
                if (this.getPSSysEAIElementRE() == null && !StringHelper.isNullOrEmpty((String)this.psSysEAIDEField.getPSSYSEAIELEMENTREID())) {
                    this.iPSSysEAIElementRE = (IPSSysEAIElementRE)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIElementRE>(){

                        public IPSSysEAIElementRE execute(Object obj) throws Exception {
                            return PSSysEAIDEFieldImpl.this.getPSSysEAIDE().getPSSysEAIElement().getPSSysEAIElementRE((String)obj);
                        }
                    }, (IPSModelObject)iPSSysEAIDE, (Object)this.psSysEAIDEField.getPSSYSEAIELEMENTREID());
                }
                if (this.getPSSysEAIElementRE() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u7684\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20", new Object[0]));
                }
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
    public String getModelType() {
        return "PSSYSEAIDEFIELD";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIDEField.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u6620\u5c04\u76ee\u6807\u7c7b\u578b", codelist="EAIDEFieldMapType")
    public String getDstType() {
        return this.strDstType;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    @Override
    public IPSEAIElementAttr getPSEAIElementAttr() {
        return this.getPSSysEAIElementAttr();
    }

    @Override
    public IPSEAIElementRE getPSEAIElementRE() {
        return this.getPSSysEAIElementRE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u6807\u8bb0", hideempty2=true)
    public String getFieldTag() {
        return this.psSysEAIDEField.getEAIDEFTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u6620\u5c04\u6807\u8bb02", hideempty2=true)
    public String getFieldTag2() {
        return this.psSysEAIDEField.getEAIDEFTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u5c5e\u6027", dumpref=true, from="IPSSysEAIElement", hideempty=true)
    public IPSSysEAIElementAttr getPSSysEAIElementAttr() {
        return this.iPSSysEAIElementAttr;
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5c5e\u6027", dumpref=true, from="IPSSysEAIElement", hideempty=true)
    public IPSSysEAIElementRE getPSSysEAIElementRE() {
        return this.iPSSysEAIElementRE;
    }
}

