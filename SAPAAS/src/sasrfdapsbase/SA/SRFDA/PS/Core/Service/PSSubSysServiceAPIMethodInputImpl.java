/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodInput;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIMethodInputImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIMethodInput {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIMethodInputImpl.class);
    private String strType = "UNKNOWN";
    private IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = null;
    private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
    private IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(KeyValueHelper.genUniqueId((String)iPSSubSysServiceAPIMethod.getId(), (String)"INPUT"));
            this.setName("\u8f93\u5165\u5bf9\u8c61");
            this.setAutoModel(true);
            if (iPSSubSysServiceAPIMethod instanceof IPSSubSysServiceAPIDEMethod) {
                this.iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)iPSSubSysServiceAPIMethod;
            }
            if (this.getPSSubSysServiceAPIMethod() == null) {
                throw new Exception("\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u65e0\u6548");
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
        this.initParam();
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getPSSubSysServiceAPIDTO() != null) {
            this.getPSSubSysServiceAPIDTO().check();
        }
        return super.onCheck();
    }

    protected void initParam() throws Exception {
        IPSDEDataSetInput iPSDEDataSetInput;
        IPSDEActionInput iPSDEActionInput;
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEAction() != null && (iPSDEActionInput = this.getPSSubSysServiceAPIMethod().getSourcePSDEAction().getPSDEActionInput()) != null) {
            this.strType = iPSDEActionInput.getType();
            this.setCalcPSDEMethodDTO(true);
            return;
        }
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet() != null && (iPSDEDataSetInput = this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet().getPSDEDataSetInput()) != null) {
            this.strType = iPSDEDataSetInput.getType();
            this.setCalcPSDEMethodDTO(true);
            return;
        }
        String strMethodType = this.getPSSubSysServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            String strRequestParamType = this.getPSSubSysServiceAPIMethod().getRequestParamType();
            if (StringHelper.compare((String)strRequestParamType, (String)"FIELD", (boolean)false) == 0) {
                this.strType = "KEYFIELD";
            } else if (StringHelper.compare((String)strRequestParamType, (String)"FIELDS", (boolean)false) == 0) {
                this.strType = "KEYFIELDS";
            } else if (StringHelper.compare((String)strRequestParamType, (String)"ENTITY", (boolean)false) == 0 || StringHelper.compare((String)strRequestParamType, (String)"ENTITIES", (boolean)false) == 0) {
                this.strType = StringHelper.compare((String)strRequestParamType, (String)"ENTITIES", (boolean)false) == 0 ? "DTOS" : "DTO";
                this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getInPSSubSysServiceAPIDE();
                if (this.iPSSubSysServiceAPIDE == null) {
                    this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getPSSubSysServiceAPIDE();
                }
                this.setCalcPSDEMethodDTO(true);
            }
            return;
        }
        if (StringHelper.compare((String)strMethodType, (String)"DEDATASET", (boolean)false) == 0) {
            return;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u65b9\u6cd5\u5bf9\u8c61")
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIMethod() {
        return this.iPSSubSysServiceAPIDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="DEServiceAPIMethodInputType")
    public String getType() {
        return this.strType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPIMethod().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSERVICEAPIMETHODINPUT";
    }

    @Override
    public String getModelId() {
        if (this.getPSSubSysServiceAPIMethod() != null) {
            return String.format("%1$s#%2$s", this.getPSSubSysServiceAPIMethod().getModelId(), this.getId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSubSysServiceAPIMethod().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSubSysServiceAPIMethod();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO() throws Exception {
        if (this.iPSSubSysServiceAPIDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSSubSysServiceAPIDTO = this.calcPSSubSysServiceAPIDTO();
            this.setCalcPSDEMethodDTO(false);
        }
        return this.iPSSubSysServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u4e3b\u952e\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSSubSysServiceAPIDEMethod", from_method="getPSSubSysServiceAPIDEMust().getPSSubSysServiceAPIDEField")
    public IPSSubSysServiceAPIDEField getKeyPSSubSysServiceAPIField() {
        if (StringHelper.compare((String)this.getType(), (String)"KEYFIELD", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"KEYFIELDS", (boolean)false) == 0) {
            return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPIDE().getKeyPSSubSysServiceAPIDEField();
        }
        return null;
    }

    @Override
    public IPSSubSysServiceAPIDE getPSSubSysServiceAPIDE() {
        return this.iPSSubSysServiceAPIDE;
    }

    protected boolean isCalcPSDEMethodDTO() {
        return this.bCalcPSDEMethodDTO;
    }

    protected void setCalcPSDEMethodDTO(boolean bCalcPSDEMethodDTO) {
        this.bCalcPSDEMethodDTO = bCalcPSDEMethodDTO;
    }

    protected IPSSubSysServiceAPIDTO calcPSSubSysServiceAPIDTO() throws Exception {
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEAction() != null) {
            IPSDEActionInput iPSDEActionInput = this.getPSSubSysServiceAPIMethod().getSourcePSDEAction().getPSDEActionInput();
            if (iPSDEActionInput != null && iPSDEActionInput.getPSDEMethodDTO() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(iPSDEActionInput.getPSDEMethodDTO());
            }
            return null;
        }
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet() != null) {
            IPSDEDataSetInput iPSDEDataSetInput = this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet().getPSDEDataSetInput();
            if (iPSDEDataSetInput != null && iPSDEDataSetInput.getPSDEFilterDTO() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(iPSDEDataSetInput.getPSDEFilterDTO());
            }
            return null;
        }
        String strMethodType = this.getPSSubSysServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            String strRequestParamType = this.getPSSubSysServiceAPIMethod().getRequestParamType();
            if (StringHelper.compare((String)strRequestParamType, (String)"FIELD", (boolean)false) != 0 && StringHelper.compare((String)strRequestParamType, (String)"FIELDS", (boolean)false) != 0 && (StringHelper.compare((String)strRequestParamType, (String)"ENTITY", (boolean)false) == 0 || StringHelper.compare((String)strRequestParamType, (String)"ENTITIES", (boolean)false) == 0) && this.getPSSubSysServiceAPIDE() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIInputDTO(this);
            }
            return null;
        }
        return null;
    }
}

