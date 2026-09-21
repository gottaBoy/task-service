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

import SA.SRFDA.PS.Core.EAI.IPSEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDataType;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElement;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.PSSysEAIElementObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIElementRE;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAIElementREImpl
extends PSSysEAIElementObjectImpl
implements IPSSysEAIElementRE {
    private static final Log log = LogFactory.getLog(PSSysEAIElementREImpl.class);
    protected PSSysEAIElementRE psSysEAIElementRE = null;
    private String strDefaultValue = null;
    private String strFixedValue = null;
    private String strElementREType = "SIMPLE";
    private boolean bAllowEmpty = false;
    private IPSSysEAIElement refPSSysEAIElement = null;
    private IPSSysEAIDataType iPSSysEAIDataType = null;
    private int nMaxOccurs = -1;
    private int nMinOccurs = -1;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIElement iPSSysEAIElement, PSSysEAIElementRE psSysEAIElementRE) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIElement(iPSSysEAIElement);
            this.psSysEAIElementRE = psSysEAIElementRE;
            this.setId(this.psSysEAIElementRE.getPSSYSEAIELEMENTREID());
            this.setName(this.psSysEAIElementRE.getPSSYSEAIELEMENTRENAME());
            this.setPSObjectData(this.psSysEAIElementRE);
            if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getEAIELEMENTRETYPE())) {
                this.strElementREType = this.psSysEAIElementRE.getEAIELEMENTRETYPE();
            }
            if ("GROUP".equals(this.getElementREType())) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getREFPSSYSEAIELEMENTID())) {
                    this.refPSSysEAIElement = (IPSSysEAIElement)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIElement>(){

                        public IPSSysEAIElement execute(Object obj) throws Exception {
                            return PSSysEAIElementREImpl.this.getPSSysEAIScheme().getPSSysEAIElement((String)obj);
                        }
                    }, (IPSModelObject)iPSSysEAIElement, (Object)this.psSysEAIElementRE.getREFPSSYSEAIELEMENTID());
                }
                if (this.getRefPSSysEAIElement() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5143\u7d20\u7ec4", new Object[0]));
                }
                if (!"ELEMENTGROUP".equals(this.getRefPSSysEAIElement().getElementType())) {
                    throw new Exception(String.format("\u6307\u5b9a\u5f15\u7528\u7684\u5143\u7d20\u7ec4[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", this.getRefPSSysEAIElement().getName()));
                }
            } else if ("COMPLEX".equals(this.getElementREType())) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getREFPSSYSEAIELEMENTID())) {
                    this.refPSSysEAIElement = (IPSSysEAIElement)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIElement>(){

                        public IPSSysEAIElement execute(Object obj) throws Exception {
                            return PSSysEAIElementREImpl.this.getPSSysEAIScheme().getPSSysEAIElement((String)obj);
                        }
                    }, (IPSModelObject)iPSSysEAIElement, (Object)this.psSysEAIElementRE.getREFPSSYSEAIELEMENTID());
                }
                if (this.getRefPSSysEAIElement() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5143\u7d20\u7ec4", new Object[0]));
                }
                if (!"COMPLEX".equals(this.getRefPSSysEAIElement().getElementType())) {
                    throw new Exception(String.format("\u6307\u5b9a\u5f15\u7528\u7684\u5143\u7d20[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", this.getRefPSSysEAIElement().getName()));
                }
            } else if ("SIMPLE".equals(this.getElementREType())) {
                if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getDEFAULTVALUE())) {
                    this.strDefaultValue = this.psSysEAIElementRE.getDEFAULTVALUE();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getFIXEDVALUE())) {
                    this.strFixedValue = this.psSysEAIElementRE.getFIXEDVALUE();
                }
                if (!this.psSysEAIElementRE.isMAXOCCURSNull()) {
                    this.nMaxOccurs = this.psSysEAIElementRE.getMAXOCCURS();
                }
                if (!this.psSysEAIElementRE.isMINOCCURSNull()) {
                    this.nMinOccurs = this.psSysEAIElementRE.getMINOCCURS();
                }
                if (!StringHelper.isNullOrEmpty((String)this.psSysEAIElementRE.getPSSYSEAIDATATYPEID())) {
                    this.iPSSysEAIDataType = (IPSSysEAIDataType)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIDataType>(){

                        public IPSSysEAIDataType execute(Object obj) throws Exception {
                            return PSSysEAIElementREImpl.this.getPSSysEAIScheme().getPSSysEAIDataType((String)obj);
                        }
                    }, (IPSModelObject)iPSSysEAIElement, (Object)this.psSysEAIElementRE.getPSSYSEAIDATATYPEID());
                }
                if (this.getPSSysEAIDataType() == null) {
                    throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u96c6\u6210\u6570\u636e\u7c7b\u578b", new Object[0]));
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
        return "PSSYSEAIELEMENTRE";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIElementRE.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true)
    public String getRETag() {
        return this.psSysEAIElementRE.getRETAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true)
    public String getRETag2() {
        return this.psSysEAIElementRE.getRETAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5143\u7d20\u5c5e\u6027\u7c7b\u578b", codelist="EAIElementREType")
    public String getElementREType() {
        return this.strElementREType;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true)
    public String getDefaultValue() {
        return this.strDefaultValue;
    }

    @Override
    @PSModelRTMeta(description="\u56fa\u5b9a\u503c", hideempty2=true)
    public String getFixedValue() {
        return this.strFixedValue;
    }

    @Override
    public IPSEAIDataType getPSEAIDataType() {
        return this.getPSSysEAIDataType();
    }

    @Override
    public IPSEAIElement getRefPSEAIElement() {
        return this.getRefPSSysEAIElement();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u6570\u636e\u7c7b\u578b", dumpref=true, from="IPSSysEAIScheme", hideempty=true)
    public IPSSysEAIDataType getPSSysEAIDataType() {
        return this.iPSSysEAIDataType;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5c5e\u6027\u7ec4", dumpref=true, from="IPSSysEAIScheme", hideempty=true)
    public IPSSysEAIElement getRefPSSysEAIElement() {
        return this.refPSSysEAIElement;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u51fa\u73b0\u6b21\u6570", ignoredumpvalues="-1")
    public int getMaxOccurs() {
        return this.nMaxOccurs;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u51fa\u73b0\u6b21\u6570", ignoredumpvalues="-1")
    public int getMinOccurs() {
        return this.nMinOccurs;
    }
}

