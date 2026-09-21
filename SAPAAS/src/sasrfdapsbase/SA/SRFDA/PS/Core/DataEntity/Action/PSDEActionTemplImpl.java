/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionTempl;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSDEActionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEActionTemplImpl
extends PSSystemObjectImpl
implements IPSDEActionTempl {
    private static final Log log = LogFactory.getLog(PSDEActionTemplImpl.class);
    protected PSDEActionTempl psDEActionTempl = null;
    private String strPredefinedTempl = null;
    private ThreadLocal<Integer> currentThreadCallCount = new ThreadLocal();
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSDEActionTempl psDEActionTempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psDEActionTempl = psDEActionTempl;
            this.setId(this.psDEActionTempl.getPSDEACTIONTEMPLID());
            this.setName(this.psDEActionTempl.getPSDEACTIONTEMPLNAME());
            this.setPSObjectData(this.psDEActionTempl);
            this.strPredefinedTempl = this.psDEActionTempl.getPDTTEMPL();
            if (!StringHelper.isNullOrEmpty((String)this.psDEActionTempl.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psDEActionTempl.getPSMODULEID());
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
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONTEMPL";
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u6a21\u677f")
    public String getPredefinedTempl() {
        return this.strPredefinedTempl;
    }

    @Override
    public IPSDCCodeSnippet getPSDCCodeSnippet() throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psDEActionTempl.getPSDCCODESNIPPETID())) {
            return null;
        }
        return this.getPSModelStorage().getPSDCCodeSnippet(this.psDEActionTempl.getPSDCCODESNIPPETID());
    }

    @Override
    public String getCode(IPSDEAction iPSDEAction) throws Exception {
        try {
            IPSDCCodeSnippet iPSDCCodeSnippet;
            String strTemplCode = this.psDEActionTempl.getTEMPLCODEEX();
            if (StringHelper.isNullOrEmpty((String)strTemplCode) && (iPSDCCodeSnippet = this.getPSDCCodeSnippet()) != null) {
                strTemplCode = iPSDCCodeSnippet.getPSDCCodeSnippetData().getTEMPLCODE();
            }
            if (!StringHelper.isNullOrEmpty((String)strTemplCode)) {
                HashMap<String, Object> params = new HashMap<String, Object>();
                this.logCallCount(1);
                params.put("item", iPSDEAction);
                params.put("de", iPSDEAction.getPSDataEntity());
                params.put("sys", iPSDEAction.getPSDataEntity().getPSSystem());
                strTemplCode = PSTemplHelper.generateCode2(strTemplCode, params);
                this.logCallCount(-1);
            }
            return strTemplCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public boolean hasCode() throws Exception {
        IPSDCCodeSnippet iPSDCCodeSnippet;
        String strTemplCode = this.psDEActionTempl.getTEMPLCODEEX();
        if (StringHelper.isNullOrEmpty((String)strTemplCode) && (iPSDCCodeSnippet = this.getPSDCCodeSnippet()) != null) {
            strTemplCode = iPSDCCodeSnippet.getPSDCCodeSnippetData().getTEMPLCODE();
        }
        return !StringHelper.isNullOrEmpty((String)strTemplCode);
    }

    private void logCallCount(int nStep) throws Exception {
        Integer nValue = this.currentThreadCallCount.get();
        if (nValue == null) {
            if (nStep <= 0) {
                return;
            }
            nValue = 0;
        }
        if ((nValue = Integer.valueOf(nValue + nStep)) <= 0) {
            this.currentThreadCallCount.set(null);
        } else {
            if (nValue >= 3) {
                this.currentThreadCallCount.set(null);
                throw new Exception(StringHelper.format((String)"\u5b9e\u4f53\u884c\u4e3a\u6a21\u677f[%1$s]\u5b58\u5728\u9012\u5f52\u8c03\u7528", (Object)this.getName()));
            }
            this.currentThreadCallCount.set(nValue);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDEActionTempl.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }
}

