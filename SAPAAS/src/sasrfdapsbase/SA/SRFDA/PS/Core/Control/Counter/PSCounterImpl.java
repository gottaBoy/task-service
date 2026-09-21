/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITCounter;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;

public class PSCounterImpl
extends PSObjectImpl
implements IPSCounter,
IPSJITCounter {
    protected PSCounter psCounter = null;
    private String strCodeName = "";
    private IPSCounterType iPSCounterType = null;
    private Properties baseClassParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSCounter psCounter) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psCounter = psCounter;
        this.setId(this.psCounter.getPSCOUNTERID());
        this.setName(this.psCounter.getPSCOUNTERNAME());
        this.setPSObjectData(this.psCounter);
        this.iPSCounterType = this.getPSModelStorage().getPSCounterType(psCounter.getCOUNTERTYPE());
        this.strCodeName = this.psCounter.getCODENAME();
        this.baseClassParams = PropertiesHelper.Load((String)this.psCounter.getBASECLSPARAMS());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getCounterType() {
        return this.iPSCounterType.getId();
    }

    @Override
    public IPSCounterType getPSCounterType() {
        return this.iPSCounterType;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        String strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strPSSFStyleId);
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && this.baseClassParams != null) {
            for (Object objKey : this.baseClassParams.keySet()) {
                String strKey = (String)objKey;
                if (strPSSFStyleId.indexOf(strKey) != 0) continue;
                strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strKey);
                break;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strBaseClass)) {
            strBaseClass = strBaseClass.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strBaseClass)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e73\u53f0\u8ba1\u6570\u5668[%1$s]\u670d\u52a1\u6846\u67b6[%2$s]\u57fa\u7c7b", (Object)this.getName(), (Object)strPSSFStyleId));
        }
        return strBaseClass;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSJITCounterHandler createPSJITConterHandler(boolean bTryMode) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psCounter.getJITCTRLOBJ())) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u9884\u7f6e\u8ba1\u6570\u5668[%1$s]\u5373\u65f6\u5904\u7406\u5bf9\u8c61", (Object)this.getName()));
        }
        IPSJITCounterHandler iPSJITCounterHandler = (IPSJITCounterHandler)ObjectHelper.Create((String)this.psCounter.getJITCTRLOBJ());
        return iPSJITCounterHandler;
    }
}

