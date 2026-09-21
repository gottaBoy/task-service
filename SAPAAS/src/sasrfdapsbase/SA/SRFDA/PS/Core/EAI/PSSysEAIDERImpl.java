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

import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.EAI.IPSEAIElementRE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDE;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIDER;
import SA.SRFDA.PS.Core.EAI.IPSSysEAIElementRE;
import SA.SRFDA.PS.Core.EAI.PSSysEAIDEObjectImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSSysEAIDER;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSModelObject;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysEAIDERImpl
extends PSSysEAIDEObjectImpl
implements IPSSysEAIDER {
    private static final Log log = LogFactory.getLog(PSSysEAIDERImpl.class);
    protected PSSysEAIDER psSysEAIDER = null;
    private IPSDERBase iPSDER = null;
    private IPSSysEAIElementRE iPSSysEAIElementRE = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysEAIDE iPSSysEAIDE, PSSysEAIDER psSysEAIDER) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSysEAIDE(iPSSysEAIDE);
            this.psSysEAIDER = psSysEAIDER;
            this.setId(this.psSysEAIDER.getPSSYSEAIDERID());
            this.setName(this.psSysEAIDER.getPSSYSEAIDERNAME());
            this.setPSObjectData(this.psSysEAIDER);
            if (this.getPSDER() == null && !StringHelper.isNullOrEmpty((String)this.psSysEAIDER.getPSDERID())) {
                this.iPSDER = this.getPSSysEAIDE().getPSDataEntity().getPSSystem().getPSDER(this.psSysEAIDER.getPSDERID());
            }
            if (this.getPSDER() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5173\u7cfb", new Object[0]));
            }
            if (this.getPSSysEAIElementRE() == null && !StringHelper.isNullOrEmpty((String)this.psSysEAIDER.getPSSYSEAIELEMENTREID())) {
                this.iPSSysEAIElementRE = (IPSSysEAIElementRE)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSSysEAIElementRE>(){

                    public IPSSysEAIElementRE execute(Object obj) throws Exception {
                        return PSSysEAIDERImpl.this.getPSSysEAIDE().getPSSysEAIElement().getPSSysEAIElementRE((String)obj);
                    }
                }, (IPSModelObject)iPSSysEAIDE, (Object)this.psSysEAIDER.getPSSYSEAIELEMENTREID());
            }
            if (this.getPSSysEAIElementRE() == null) {
                throw new Exception(String.format("\u6ca1\u6709\u6307\u5b9a\u6620\u5c04\u7684\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5143\u7d20", new Object[0]));
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
        return "PSSYSEAIDER";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysEAIDER.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb", dumpref=true)
    public IPSDERBase getPSDER() {
        return this.iPSDER;
    }

    @Override
    public IPSEAIElementRE getPSEAIElementRE() {
        return this.getPSSysEAIElementRE();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04\u6807\u8bb0", hideempty2=true)
    public String getDERTag() {
        return this.psSysEAIDER.getEAIDERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb\u6620\u5c04\u6807\u8bb02", hideempty2=true)
    public String getDERTag2() {
        return this.psSysEAIDER.getEAIDERTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u96c6\u6210\u5143\u7d20\u5f15\u7528\u5c5e\u6027", dumpref=true, from="IPSSysEAIElement", hideempty=true)
    public IPSSysEAIElementRE getPSSysEAIElementRE() {
        return this.iPSSysEAIElementRE;
    }
}

