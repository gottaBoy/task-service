/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSWFProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessParam;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSWFProcessParamImpl
extends PSObjectImpl
implements IPSWFProcessParam {
    private static final Log log = LogFactory.getLog(PSWFProcessParamImpl.class);
    protected IPSWFProcess iPSWFProcess;
    protected PSWFProcParam psWFProcParam;
    protected String strDstFieldName = "";
    protected String strSrcFieldName = "";

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSWFProcess iPSWFProcess, PSWFProcParam psWFProcParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSWFProcess = iPSWFProcess;
            this.psWFProcParam = psWFProcParam;
            this.setId(this.psWFProcParam.getPSWFPROCPARAMID());
            this.setName(this.psWFProcParam.getPSWFPROCPARAMNAME());
            this.setPSObjectData(this.psWFProcParam);
            this.strDstFieldName = this.psWFProcParam.getCUSTOMDSTDEFNAME();
            if (StringHelper.IsNullOrEmpty((String)this.strDstFieldName)) {
                this.strDstFieldName = this.psWFProcParam.getPSDEFNAME();
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    @PSModelRTMeta(description="\u6d41\u7a0b\u5904\u7406")
    public IPSWFProcess getPSWFProcess() {
        return this.iPSWFProcess;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5c5e\u6027", fields={"CUSTOMDSTDEFNAME", "PSDEFNAME"})
    public String getDstField() throws Exception {
        return this.strDstFieldName;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c", fields={"SRCVALUE"})
    public String getSrcValue() {
        return this.psWFProcParam.getSRCVALUE();
    }

    @Override
    public String getDirectCode() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u503c\u7c7b\u578b", codelist="WFProcParamValueType", fields={"SRCVALUETYPE"})
    public String getSrcValueType() {
        return this.psWFProcParam.getSRCVALUETYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSWFProcess.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u89d2\u8272\u6570\u636e", hideempty2=true, fields={"USERDATA"})
    public String getUserData() {
        return this.psWFProcParam.getUSERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u89d2\u8272\u6570\u636e2", hideempty2=true, fields={"USERDATA2"})
    public String getUserData2() {
        return this.psWFProcParam.getUSERDATA2();
    }

    @Override
    public String getModelType() {
        return "PSWFPROCPARAM";
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSWFProcess().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelId() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSWFProcess().getModelId(), (Object)super.getModelId());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSWFProcess().getPSWFVersion().getPSWorkflow().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSWFProcess().getDeployId(), (String)this.getId());
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

