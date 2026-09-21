/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.counter.IPSCounterType
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.counter;

import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.control.counter.IPSCounterRuntime;
import net.ibizsys.model.control.counter.IPSCounterType;
import net.ibizsys.model.entity.PSCounter;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSCounterImpl
extends PSObjectImpl
implements IPSCounterRuntime {
    protected PSCounter psCounter = null;
    private String strCodeName = "";
    private IPSCounterType iPSCounterType = null;
    private Properties baseClassParams = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSCounter psCounter) throws Exception {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.psCounter = psCounter;
        this.setId(this.psCounter.getPSCOUNTERID());
        this.setName(this.psCounter.getPSCOUNTERNAME());
        this.setPSObjectData(this.psCounter);
        this.iPSCounterType = this.getPSModelStorageContext().getPSCounterType(psCounter.getCOUNTERTYPE());
        this.strCodeName = this.psCounter.getCODENAME();
        this.baseClassParams = PropertiesHelper.load((String)this.psCounter.getBASECLSPARAMS());
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public String getCounterType() {
        return this.iPSCounterType.getId();
    }

    public IPSCounterType getPSCounterType() {
        return this.iPSCounterType;
    }

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
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e73\u53f0\u8ba1\u6570\u5668[%1$s]\u670d\u52a1\u6846\u67b6[%2$s]\u57fa\u7c7b", (Object)this.getName(), (Object)strPSSFStyleId));
        }
        return strBaseClass;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

