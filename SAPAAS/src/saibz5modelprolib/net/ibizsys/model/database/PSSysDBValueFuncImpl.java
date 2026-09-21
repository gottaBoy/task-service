/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.database;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.database.IPSSysDBValueFuncRuntime;
import net.ibizsys.model.entity.PSSysDBValueFunc;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDBValueFuncImpl
extends PSSystemObjectImpl
implements IPSSysDBValueFuncRuntime {
    private static final Log log = LogFactory.getLog(PSSysDBValueFuncImpl.class);
    protected PSSysDBValueFunc psSysDBValueFunc = null;
    protected String strDBVFType = null;
    protected String strCodeName = null;
    private String strOutputValueFormat = "%1$s";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSSysDBValueFunc psSysDBValueFunc) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSSystem(iPSSystem);
            this.psSysDBValueFunc = psSysDBValueFunc;
            this.setId(this.psSysDBValueFunc.getPSSYSDBVFID());
            this.setName(this.psSysDBValueFunc.getPSSYSDBVFNAME());
            this.setPSObjectData(this.psSysDBValueFunc);
            this.strDBVFType = this.psSysDBValueFunc.getVFTYPE();
            this.strCodeName = this.psSysDBValueFunc.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysDBValueFunc.getOUTPUTVALUEFORMAT())) {
                this.strOutputValueFormat = this.psSysDBValueFunc.getOUTPUTVALUEFORMAT();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u8f93\u5165\u503c\u6570\u636e\u5e93\u7c7b\u578b", codelist="StdDataType")
    public int getInputStdDataType() {
        return this.psSysDBValueFunc.getINPUTSTDDATATYPE();
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u6570\u636e\u5e93\u7c7b\u578b", codelist="StdDataType")
    public int getOutputStdDataType() {
        return this.psSysDBValueFunc.getOUTPUTSTDDATATYPE();
    }

    @PSModelRTMeta(description="\u51fd\u6570\u7c7b\u578b", codelist="SysDBVFType")
    public String getDBValueFuncType() {
        return this.strDBVFType;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u8f93\u51fa\u503c\u683c\u5f0f\u5316")
    public String getOutputValueFormat() {
        return this.strOutputValueFormat;
    }
}

