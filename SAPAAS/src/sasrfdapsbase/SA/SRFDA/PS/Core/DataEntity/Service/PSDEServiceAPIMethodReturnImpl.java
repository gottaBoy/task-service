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
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodReturn;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEServiceAPIMethodReturnImpl
extends PSObjectImpl
implements IPSDEServiceAPIMethodReturn {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIMethodReturnImpl.class);
    protected IPSDEServiceAPIMethod iPSDEServiceAPIMethod;
    private String strType = "UNKNOWN";
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private int nStdDataType = 0;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPIMethod iPSDEServiceAPIMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEServiceAPIMethod = iPSDEServiceAPIMethod;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEServiceAPIMethod.getId(), (String)"RETURN"));
            this.setName("\u8fd4\u56de\u5bf9\u8c61");
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

    protected void initParam() throws Exception {
        String strMethodType = this.getPSDEServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            if (this.getPSDEServiceAPIMethod().getPSDEAction() != null) {
                IPSDEActionReturn iPSDEActionReturn = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionReturn();
                if (StringHelper.compare((String)"DTO", (String)iPSDEActionReturn.getType(), (boolean)false) == 0 || StringHelper.compare((String)"DTOS", (String)iPSDEActionReturn.getType(), (boolean)false) == 0) {
                    this.strType = iPSDEActionReturn.getType();
                    this.setCalcPSDEMethodDTO(true);
                } else if (StringHelper.compare((String)"SIMPLE", (String)iPSDEActionReturn.getType(), (boolean)false) == 0 || StringHelper.compare((String)"SIMPLES", (String)iPSDEActionReturn.getType(), (boolean)false) == 0) {
                    this.strType = iPSDEActionReturn.getType();
                    this.nStdDataType = iPSDEActionReturn.getStdDataType();
                } else {
                    IPSDEActionInput iPSDEActionInput;
                    this.strType = iPSDEActionReturn.getType();
                    if (StringHelper.compare((String)"VOID", (String)iPSDEActionReturn.getType(), (boolean)false) == 0 && (iPSDEActionInput = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput()).isOutput() && this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput() != null) {
                        this.strType = this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput().getType();
                        this.setCalcPSDEMethodDTO(true);
                    }
                }
            }
            return;
        }
        if (StringHelper.compare((String)strMethodType, (String)"FETCH", (boolean)false) == 0 || StringHelper.compare((String)strMethodType, (String)"FETCHTEMP", (boolean)false) == 0) {
            IPSDEDataSetReturn iPSDEDataSetReturn;
            if (this.getPSDEServiceAPIMethod().getPSDEDataSet() != null && StringHelper.compare((String)"PAGE", (String)(iPSDEDataSetReturn = this.getPSDEServiceAPIMethod().getPSDEDataSet().getPSDEDataSetReturn()).getType(), (boolean)false) == 0) {
                this.strType = "PAGE";
                this.setCalcPSDEMethodDTO(true);
            }
            return;
        }
        if (StringHelper.compare((String)strMethodType, (String)"SELECT", (boolean)false) == 0 || StringHelper.compare((String)strMethodType, (String)"SELECTTEMP", (boolean)false) == 0) {
            return;
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEMethodDTO();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5\u5bf9\u8c61", outputdoc="false")
    public IPSDEServiceAPIMethod getPSDEServiceAPIMethod() {
        return this.iPSDEServiceAPIMethod;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u7c7b\u578b", codelist="DEServiceAPIMethodReturnType")
    public String getType() {
        return this.strType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEServiceAPIMethod().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDESERVICEAPIMETHODRETURN";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEServiceAPIMethod() != null) {
            return String.format("%1$s#%2$s", this.getPSDEServiceAPIMethod().getModelId(), this.getId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEServiceAPIMethod().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEServiceAPIMethod();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEServiceAPIMethod().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61", dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEMethodDTO")
    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEMethodDTO = this.calcPSDEMethodDTO();
            this.setCalcPSDEMethodDTO(false);
        }
        return this.iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u503c\u7c7b\u578b", ignoredumpvalues="0", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    protected boolean isCalcPSDEMethodDTO() {
        return this.bCalcPSDEMethodDTO;
    }

    protected void setCalcPSDEMethodDTO(boolean bCalcPSDEMethodDTO) {
        this.bCalcPSDEMethodDTO = bCalcPSDEMethodDTO;
    }

    protected IPSDEMethodDTO calcPSDEMethodDTO() throws Exception {
        String strMethodType = this.getPSDEServiceAPIMethod().getMethodType();
        if (StringHelper.compare((String)strMethodType, (String)"DEACTION", (boolean)false) == 0) {
            if (this.getPSDEServiceAPIMethod().getPSDEAction() != null) {
                IPSDEActionInput iPSDEActionInput;
                IPSDEActionReturn iPSDEActionReturn = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionReturn();
                if (StringHelper.compare((String)"DTO", (String)iPSDEActionReturn.getType(), (boolean)false) == 0 || StringHelper.compare((String)"DTOS", (String)iPSDEActionReturn.getType(), (boolean)false) == 0) {
                    return this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionReturn().getPSDEMethodDTO();
                }
                if (StringHelper.compare((String)"SIMPLE", (String)iPSDEActionReturn.getType(), (boolean)false) != 0 && StringHelper.compare((String)"SIMPLES", (String)iPSDEActionReturn.getType(), (boolean)false) != 0 && StringHelper.compare((String)"VOID", (String)iPSDEActionReturn.getType(), (boolean)false) == 0 && (iPSDEActionInput = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput()).isOutput() && this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput() != null) {
                    return this.getPSDEServiceAPIMethod().getPSDEServiceAPIMethodInput().getPSDEMethodDTO();
                }
            }
            return null;
        }
        if (StringHelper.compare((String)strMethodType, (String)"FETCH", (boolean)false) == 0 || StringHelper.compare((String)strMethodType, (String)"FETCHTEMP", (boolean)false) == 0) {
            IPSDEDataSetReturn iPSDEDataSetReturn;
            if (this.getPSDEServiceAPIMethod().getPSDEDataSet() != null && StringHelper.compare((String)"PAGE", (String)(iPSDEDataSetReturn = this.getPSDEServiceAPIMethod().getPSDEDataSet().getPSDEDataSetReturn()).getType(), (boolean)false) == 0) {
                return this.getPSDEServiceAPIMethod().getPSDEDataSet().getPSDEDataSetReturn().getPSDEMethodDTO();
            }
            return null;
        }
        return null;
    }
}

