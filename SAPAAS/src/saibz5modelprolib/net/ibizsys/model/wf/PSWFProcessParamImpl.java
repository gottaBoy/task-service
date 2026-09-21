/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.wf.IPSWFProcess
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.wf;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.wf.IPSWFProcess;
import net.ibizsys.model.wf.IPSWFProcessParamRuntime;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWFProcessParamImpl
extends PSObjectImpl
implements IPSWFProcessParamRuntime {
    private static final Log log = LogFactory.getLog(PSWFProcessParamImpl.class);
    protected IPSWFProcess iPSWFProcess;
    protected PSWFProcParam psWFProcParam;
    protected String strDstFieldName = "";
    protected String strSrcFieldName = "";

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSWFProcess iPSWFProcess, PSWFProcParam psWFProcParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSWFProcess = iPSWFProcess;
            this.psWFProcParam = psWFProcParam;
            this.setId(this.psWFProcParam.getPSWFPROCPARAMID());
            this.setName(this.psWFProcParam.getPSWFPROCPARAMNAME());
            this.setPSObjectData(this.psWFProcParam);
            this.strDstFieldName = this.psWFProcParam.getCUSTOMDSTDEFNAME();
            if (StringHelper.isNullOrEmpty((String)this.strDstFieldName)) {
                this.strDstFieldName = this.psWFProcParam.getPSDEFNAME();
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

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    public IPSWFProcess getPSWFProcess() {
        return this.iPSWFProcess;
    }

    public String getDstField() throws Exception {
        return this.strDstFieldName;
    }

    public String getSrcValue() {
        return this.psWFProcParam.getSRCVALUE();
    }

    public String getDirectCode() {
        return "";
    }

    public String getSrcValueType() {
        return this.psWFProcParam.getSRCVALUETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSWFProcess);
    }
}

