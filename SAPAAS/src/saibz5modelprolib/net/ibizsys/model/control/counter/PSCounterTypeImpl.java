/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounter
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.counter;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.counter.IPSCounter;
import net.ibizsys.model.control.counter.IPSCounterTypeRuntime;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.PSCounterImpl;
import net.ibizsys.model.control.counter.PSSysCounterImpl;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.model.entity.PSCounterType;
import net.ibizsys.model.entity.PSSysCounter;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCounterTypeImpl
extends PSObjectImpl
implements IPSCounterTypeRuntime {
    protected PSCounterType psCounterType = null;
    private static final Log log = LogFactory.getLog(PSCounterTypeImpl.class);
    private Properties typeParams = null;
    private Properties baseClassParams = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSCounterType psCounterType) throws Exception {
        this.psCounterType = psCounterType;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psCounterType.getPSCOUNTERTYPEID());
        this.setName(psCounterType.getPSCOUNTERTYPENAME());
        this.setPSObjectData(this.psCounterType);
        this.typeParams = PropertiesHelper.load((String)this.psCounterType.getTYPEPARAMS());
        this.baseClassParams = PropertiesHelper.load((String)this.psCounterType.getBASECLSPARAMS());
        this.onInit();
    }

    @Override
    public IPSSysCounter createPSSysCounter(PSSysCounter psSysCounter) throws Exception {
        String strCounterObj = this.psCounterType.getCOUNTEROBJ();
        if (StringHelper.isNullOrEmpty((String)strCounterObj)) {
            return new PSSysCounterImpl();
        }
        return (IPSSysCounter)this.getPSModelStorageContext().createObject(strCounterObj);
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        String strBaseClass = PropertiesHelper.getProperty((Properties)this.baseClassParams, (String)strPSSFStyleId);
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && this.baseClassParams != null) {
            for (Object objKey : this.baseClassParams.keySet()) {
                String strKey = (String)objKey;
                if (strPSSFStyleId.indexOf(strKey) != 0) continue;
                strBaseClass = PropertiesHelper.getProperty((Properties)this.baseClassParams, (String)strKey);
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
}

