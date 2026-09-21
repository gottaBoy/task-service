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
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIField;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEServiceAPIMethodInput;
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
public class PSDEServiceAPIMethodInputImpl
extends PSObjectImpl
implements IPSDEServiceAPIMethodInput {
    private static final Log log = LogFactory.getLog(PSDEServiceAPIMethodInputImpl.class);
    protected IPSDEServiceAPIMethod iPSDEServiceAPIMethod;
    private String strType = "UNKNOWN";
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEServiceAPIMethod iPSDEServiceAPIMethod) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEServiceAPIMethod = iPSDEServiceAPIMethod;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEServiceAPIMethod.getId(), (String)"INPUT"));
            this.setName("\u8f93\u5165\u5bf9\u8c61");
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
                IPSDEActionInput iPSDEActionInput = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput();
                if (StringHelper.compare((String)"DTO", (String)iPSDEActionInput.getType(), (boolean)false) == 0 || StringHelper.compare((String)"DTOS", (String)iPSDEActionInput.getType(), (boolean)false) == 0) {
                    this.strType = iPSDEActionInput.getType();
                    this.setCalcPSDEMethodDTO(true);
                } else if (StringHelper.compare((String)"KEYFIELD", (String)iPSDEActionInput.getType(), (boolean)false) == 0 || StringHelper.compare((String)"KEYFIELDS", (String)iPSDEActionInput.getType(), (boolean)false) == 0 || StringHelper.compare((String)"NONE", (String)iPSDEActionInput.getType(), (boolean)false) == 0) {
                    this.strType = iPSDEActionInput.getType();
                }
            }
            return;
        }
        if (StringHelper.compare((String)strMethodType, (String)"FETCH", (boolean)false) == 0 || StringHelper.compare((String)strMethodType, (String)"FETCHTEMP", (boolean)false) == 0) {
            IPSDEDataSetInput iPSDEDataSetInput;
            if (this.getPSDEServiceAPIMethod().getPSDEDataSet() != null && StringHelper.compare((String)"DTO", (String)(iPSDEDataSetInput = this.getPSDEServiceAPIMethod().getPSDEDataSet().getPSDEDataSetInput()).getType(), (boolean)false) == 0) {
                this.strType = "DTO";
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
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="DEServiceAPIMethodInputType")
    public String getType() {
        return this.strType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEServiceAPIMethod().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDESERVICEAPIMETHODINPUT";
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
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDEServiceAPI", from_method="getPSDataEntityMust().getPSDEMethodDTO")
    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEMethodDTO = this.calcPSDEMethodDTO();
            this.setCalcPSDEMethodDTO(false);
        }
        return this.iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u4e3b\u952e\u5c5e\u6027", hideempty=true, dumpref=true, ignorert=3, from="IPSDEServiceAPI", dynamodelmode=8)
    public IPSDEServiceAPIField getKeyPSDEServiceAPIField() {
        if (StringHelper.compare((String)this.getType(), (String)"KEYFIELD", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"KEYFIELDS", (boolean)false) == 0) {
            return this.getPSDEServiceAPIMethod().getPSDEServiceAPI().getKeyPSDEServiceAPIField();
        }
        return null;
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
            IPSDEActionInput iPSDEActionInput;
            if (this.getPSDEServiceAPIMethod().getPSDEAction() != null && (StringHelper.compare((String)"DTO", (String)(iPSDEActionInput = this.getPSDEServiceAPIMethod().getPSDEAction().getPSDEActionInput()).getType(), (boolean)false) == 0 || StringHelper.compare((String)"DTOS", (String)iPSDEActionInput.getType(), (boolean)false) == 0)) {
                return iPSDEActionInput.getPSDEMethodDTO();
            }
            return null;
        }
        if (StringHelper.compare((String)strMethodType, (String)"FETCH", (boolean)false) == 0 || StringHelper.compare((String)strMethodType, (String)"FETCHTEMP", (boolean)false) == 0) {
            IPSDEDataSetInput iPSDEDataSetInput;
            if (this.getPSDEServiceAPIMethod().getPSDEDataSet() != null && StringHelper.compare((String)"DTO", (String)(iPSDEDataSetInput = this.getPSDEServiceAPIMethod().getPSDEDataSet().getPSDEDataSetInput()).getType(), (boolean)false) == 0) {
                return iPSDEDataSetInput.getPSDEFilterDTO();
            }
            return null;
        }
        return null;
    }
}

