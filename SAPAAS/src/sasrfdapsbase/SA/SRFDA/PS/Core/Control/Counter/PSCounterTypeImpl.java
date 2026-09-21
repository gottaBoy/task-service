/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.PSCounterImpl;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterImpl;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITCounter;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITCounterType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCounterHandler;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSCounter;
import SA.SRFDA.PS.Data.PSCounterType;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSCounterTypeImpl
extends PSObjectImpl
implements IPSCounterType,
IPSJITCounterType {
    protected PSCounterType psCounterType = null;
    private static final Log log = LogFactory.getLog(PSCounterTypeImpl.class);
    private Properties typeParams = null;
    private Properties baseClassParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSCounterType psCounterType) throws Exception {
        this.psCounterType = psCounterType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psCounterType.getPSCOUNTERTYPEID());
        this.setName(psCounterType.getPSCOUNTERTYPENAME());
        this.setPSObjectData(this.psCounterType);
        this.typeParams = PropertiesHelper.Load((String)this.psCounterType.getTYPEPARAMS());
        this.baseClassParams = PropertiesHelper.Load((String)this.psCounterType.getBASECLSPARAMS());
        this.onInit();
    }

    @Override
    public IPSSysCounter createPSSysCounter(PSSysCounter psSysCounter) throws Exception {
        String strCounterObj = this.psCounterType.getCOUNTEROBJ();
        if (StringHelper.isNullOrEmpty((String)strCounterObj)) {
            return new PSSysCounterImpl();
        }
        return (IPSSysCounter)ObjectHelper.Create((String)strCounterObj);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
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
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u8ba1\u6570\u5668\u7c7b\u578b[%1$s]\u670d\u52a1\u6846\u67b6[%2$s]\u57fa\u7c7b", (Object)this.getName(), (Object)strPSSFStyleId));
        }
        return strBaseClass;
    }

    @Override
    public IPSCounter createPSCounter(PSCounter psCounter) throws Exception {
        return new PSCounterImpl();
    }

    @Override
    public IPSJITCounterHandler createPSJITConterHandler(IPSSysCounter iPSSysCounter) throws Exception {
        IPSJITCounterHandler iPSJITCounterHandler;
        if (iPSSysCounter.getPSCounter() != null && (iPSJITCounterHandler = ((IPSJITCounter)iPSSysCounter.getPSCounter()).createPSJITConterHandler(true)) != null) {
            return iPSJITCounterHandler;
        }
        if (StringHelper.isNullOrEmpty((String)this.psCounterType.getJITCTRLOBJ())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u8ba1\u6570\u5668[%1$s]\u90e8\u4ef6\u5373\u65f6\u5904\u7406\u5bf9\u8c61", (Object)this.getId()));
        }
        iPSJITCounterHandler = (IPSJITCounterHandler)ObjectHelper.Create((String)this.psCounterType.getJITCTRLOBJ());
        return iPSJITCounterHandler;
    }
}

