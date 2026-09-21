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

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDE;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDTO;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethod;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIMethodReturn;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSubSysServiceAPIMethodReturnImpl
extends PSObjectImpl
implements IPSSubSysServiceAPIMethodReturn {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIMethodReturnImpl.class);
    private IPSSubSysServiceAPIDEMethod iPSSubSysServiceAPIDEMethod = null;
    private String strType = "UNKNOWN";
    private IPSSubSysServiceAPIDTO iPSSubSysServiceAPIDTO = null;
    private int nStdDataType = 0;
    private IPSSubSysServiceAPIDE iPSSubSysServiceAPIDE = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPIMethod iPSSubSysServiceAPIMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setId(KeyValueHelper.genUniqueId((String)iPSSubSysServiceAPIMethod.getId(), (String)"RETURN"));
            this.setName("\u8fd4\u56de\u5bf9\u8c61");
            if (iPSSubSysServiceAPIMethod instanceof IPSSubSysServiceAPIDEMethod) {
                this.iPSSubSysServiceAPIDEMethod = (IPSSubSysServiceAPIDEMethod)iPSSubSysServiceAPIMethod;
            }
            if (this.getPSSubSysServiceAPIMethod() == null) {
                throw new Exception("\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u65e0\u6548");
            }
            this.setAutoModel(true);
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
        IPSDEDataSetReturn iPSDEDataSetReturn;
        IPSDEActionReturn iPSDEActionReturn;
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEAction() != null && (iPSDEActionReturn = this.getPSSubSysServiceAPIMethod().getSourcePSDEAction().getPSDEActionReturn()) != null) {
            this.strType = iPSDEActionReturn.getType();
            this.setCalcPSDEMethodDTO(true);
            return;
        }
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet() != null && (iPSDEDataSetReturn = this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet().getPSDEDataSetReturn()) != null) {
            this.strType = iPSDEDataSetReturn.getType();
            this.setCalcPSDEMethodDTO(true);
            return;
        }
        String strMethodType = this.getPSSubSysServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            String strRetType = this.getPSSubSysServiceAPIMethod().getReturnValueType();
            if (StringHelper.compare((String)"ENTITY", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"ENTITIES", (String)strRetType, (boolean)false) == 0) {
                this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getOutPSSubSysServiceAPIDE();
                if (this.iPSSubSysServiceAPIDE == null) {
                    this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getOutPSSubSysServiceAPIDE();
                }
                this.strType = StringHelper.compare((String)"ENTITIES", (String)strRetType, (boolean)false) == 0 ? "DTOS" : "DTO";
                this.setCalcPSDEMethodDTO(true);
            } else if (StringHelper.compare((String)"SIMPLE", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"SIMPLES", (String)strRetType, (boolean)false) == 0) {
                this.strType = strRetType;
                this.nStdDataType = this.getPSSubSysServiceAPIMethod().getReturnStdDataType();
            } else {
                this.strType = strRetType;
            }
            return;
        }
        if (StringHelper.compare((String)strMethodType, (String)"DEDATASET", (boolean)false) == 0) {
            String strRetType = this.getPSSubSysServiceAPIMethod().getReturnValueType();
            if (StringHelper.isNullOrEmpty((String)strRetType)) {
                this.strType = "PAGE";
            }
            if (StringHelper.compare((String)"ENTITY", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"ENTITIES", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"PAGE", (String)strRetType, (boolean)false) == 0) {
                this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getOutPSSubSysServiceAPIDE();
                if (this.iPSSubSysServiceAPIDE == null) {
                    this.iPSSubSysServiceAPIDE = this.iPSSubSysServiceAPIDEMethod.getOutPSSubSysServiceAPIDE();
                }
                this.setCalcPSDEMethodDTO(true);
            }
            return;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u63a5\u53e3\u65b9\u6cd5\u5bf9\u8c61")
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIMethod() {
        return this.iPSSubSysServiceAPIDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u7c7b\u578b", codelist="DEServiceAPIMethodReturnType")
    public String getType() {
        return this.strType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPIMethod().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSUBSYSSERVICEAPIMETHODRETURN";
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61", dumpref=true, from="IPSSubSysServiceAPI")
    public IPSSubSysServiceAPIDTO getPSSubSysServiceAPIDTO() throws Exception {
        if (this.iPSSubSysServiceAPIDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSSubSysServiceAPIDTO = this.calcPSSubSysServiceAPIDTO();
            this.setCalcPSDEMethodDTO(false);
        }
        return this.iPSSubSysServiceAPIDTO;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u503c\u7c7b\u578b", ignoredumpvalues="0", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
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
        IPSDEDataSetReturn iPSDEDataSetReturn;
        IPSDEActionReturn iPSDEActionReturn;
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEAction() != null && (iPSDEActionReturn = this.getPSSubSysServiceAPIMethod().getSourcePSDEAction().getPSDEActionReturn()) != null) {
            if (iPSDEActionReturn.getPSDEMethodDTO() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(iPSDEActionReturn.getPSDEMethodDTO());
            }
            return null;
        }
        if (this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet() != null && (iPSDEDataSetReturn = this.getPSSubSysServiceAPIMethod().getSourcePSDEDataSet().getPSDEDataSetReturn()) != null) {
            if (iPSDEDataSetReturn.getPSDEMethodDTO() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIDTO(iPSDEDataSetReturn.getPSDEMethodDTO());
            }
            return null;
        }
        String strMethodType = this.getPSSubSysServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            String strRetType = this.getPSSubSysServiceAPIMethod().getReturnValueType();
            if ((StringHelper.compare((String)"ENTITY", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"ENTITIES", (String)strRetType, (boolean)false) == 0) && this.getPSSubSysServiceAPIDE() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIReturnDTO(this);
            }
            return null;
        }
        if (StringHelper.compare((String)strMethodType, (String)"DEDATASET", (boolean)false) == 0) {
            String strRetType = this.getPSSubSysServiceAPIMethod().getReturnValueType();
            if ((StringHelper.compare((String)"ENTITY", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"ENTITIES", (String)strRetType, (boolean)false) == 0 || StringHelper.compare((String)"PAGE", (String)strRetType, (boolean)false) == 0) && this.getPSSubSysServiceAPIDE() != null) {
                return this.getPSSubSysServiceAPIMethod().getPSSubSysServiceAPI().getPSSubSysServiceAPIReturnDTO(this);
            }
            return null;
        }
        return null;
    }
}

