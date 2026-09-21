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
package SA.SRFDA.PS.Core.DataEntity.Action;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionReturn;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.PSModelCodeNameUtils;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEActionReturnImpl
extends PSObjectImpl
implements IPSDEActionReturn {
    private static final Log log = LogFactory.getLog(PSDEActionReturnImpl.class);
    protected IPSDEAction iPSDEAction;
    private int nStdDataType = 0;
    private String strType = "UNKNOWN";
    private IPSDEFGroup iPSDEFGroup = null;
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private IPSSysDynaModel refPSSysDynaModel = null;
    private String strCodeName = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEAction = iPSDEAction;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEAction.getId(), (String)"RETURN"));
            this.strCodeName = String.format("%1$sResult", PSModelCodeNameUtils.capitalize(iPSDEAction.getCodeName()));
            this.setName(this.getCodeName());
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
        String strActionMode = this.getPSDEAction().getActionMode();
        this.initByActionMode(strActionMode);
        super.onInit();
        if (StringHelper.compare((String)this.getType(), (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"DTOS", (boolean)false) == 0) {
            this.setCalcPSDEMethodDTO(true);
        }
    }

    protected void initByActionMode(String strActionMode) throws Exception {
        if (StringHelper.compare((String)strActionMode, (String)"CHECKKEY", (boolean)false) == 0) {
            this.strType = "SIMPLE";
            this.nStdDataType = 9;
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"CREATE", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UPDATE", (boolean)false) == 0) {
            if (this.getPSDEAction().getPSDEActionInput().isOutput()) {
                this.strType = "VOID";
            } else {
                this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
                this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            }
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"DELETE", (boolean)false) == 0) {
            this.strType = this.getPSDEAction().isBatchAction() ? "VOID" : "VOID";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"GETDRAFT", (boolean)false) == 0) {
            this.strType = this.getPSDEAction().getReturnValueType();
            if (StringHelper.compare((String)this.strType, (String)"OBJECT", (boolean)false) == 0) {
                this.refPSSysDynaModel = this.getPSDEAction().getOutPSSysDynaModel();
                if (this.getRefPSSysDynaModel() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8fd4\u56de\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61");
                }
                this.strType = "DTO";
                return;
            }
            this.strType = "DTO";
            this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"MOVEORDER", (boolean)false) == 0) {
            this.strType = "DTOS";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"READ", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"GETDRAFTFROM", (boolean)false) == 0) {
            this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            this.strType = "DTO";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"COPY", (boolean)false) == 0) {
            this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            if (this.iPSDEFGroup == null) {
                this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
            }
            this.strType = "DTO";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"CUSTOM", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UNKNOWN", (boolean)false) == 0) {
            this.strType = this.getPSDEAction().getReturnValueType();
            if (StringHelper.isNullOrEmpty((String)this.strType)) {
                this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
                this.strType = this.iPSDEFGroup == null ? "VOID" : "DTO";
            } else if (StringHelper.compare((String)this.strType, (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"DTOS", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"ENTITY", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"ENTITIES", (boolean)false) == 0) {
                this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
                if ("ENTITY".equals(this.strType)) {
                    this.strType = "DTO";
                } else if ("ENTITIES".equals(this.strType)) {
                    this.strType = "DTOS";
                }
            } else if (StringHelper.compare((String)this.strType, (String)"OBJECT", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"OBJECTS", (boolean)false) == 0) {
                this.refPSSysDynaModel = this.getPSDEAction().getOutPSSysDynaModel();
                if (this.getRefPSSysDynaModel() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8fd4\u56de\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61");
                }
                if ("OBJECT".equals(this.strType)) {
                    this.strType = "DTO";
                } else if ("OBJECTS".equals(this.strType)) {
                    this.strType = "DTOS";
                }
            } else if (StringHelper.compare((String)this.strType, (String)"LINKENTITY", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"LINKENTITIES", (boolean)false) == 0) {
                if ("LINKENTITY".equals(this.strType)) {
                    this.strType = "DTO";
                } else if ("LINKENTITIES".equals(this.strType)) {
                    this.strType = "DTOS";
                }
            } else if (StringHelper.compare((String)this.strType, (String)"SIMPLE", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"SIMPLES", (boolean)false) == 0) {
                this.nStdDataType = this.getPSDEAction().getReturnStdDataType();
                if (this.nStdDataType == 0) {
                    this.nStdDataType = 9;
                }
            }
            return;
        }
        this.strType = this.getPSDEAction().getReturnValueType();
        if (StringHelper.isNullOrEmpty((String)this.strType)) {
            this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            this.strType = this.iPSDEFGroup == null ? "VOID" : "DTO";
        } else if (StringHelper.compare((String)this.strType, (String)"DTO", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"DTOS", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"ENTITY", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"ENTITIES", (boolean)false) == 0) {
            this.iPSDEFGroup = this.getPSDEAction().getOutPSDEFGroup();
            if ("ENTITY".equals(this.strType)) {
                this.strType = "DTO";
            } else if ("ENTITIES".equals(this.strType)) {
                this.strType = "DTOS";
            }
        } else if (StringHelper.compare((String)this.strType, (String)"OBJECT", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"OBJECTS", (boolean)false) == 0) {
            this.refPSSysDynaModel = this.getPSDEAction().getOutPSSysDynaModel();
            if (this.getRefPSSysDynaModel() == null) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u8fd4\u56de\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61");
            }
            if ("OBJECT".equals(this.strType)) {
                this.strType = "DTO";
            } else if ("OBJECTS".equals(this.strType)) {
                this.strType = "DTOS";
            }
        } else if (StringHelper.compare((String)this.strType, (String)"LINKENTITY", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"LINKENTITIES", (boolean)false) == 0) {
            if ("LINKENTITY".equals(this.strType)) {
                this.strType = "DTO";
            } else if ("LINKENTITIES".equals(this.strType)) {
                this.strType = "DTOS";
            }
        } else if (StringHelper.compare((String)this.strType, (String)"SIMPLE", (boolean)false) == 0 || StringHelper.compare((String)this.strType, (String)"SIMPLES", (boolean)false) == 0) {
            this.nStdDataType = this.getPSDEAction().getReturnStdDataType();
            if (this.nStdDataType == 0) {
                this.nStdDataType = 9;
            }
        }
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSDEMethodDTO();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", outputdoc="false")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u7c7b\u578b", codelist="DEMethodReturnType")
    public String getType() {
        return this.strType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u7b80\u5355\u503c\u7c7b\u578b", ignoredumpvalues="0", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEAction().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONRETURN";
    }

    @Override
    public String getModelId() {
        if (this.getPSDEAction() != null) {
            return String.format("%1$s#%2$s", this.getPSDEAction().getModelId(), this.getId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEAction().getPSDataEntity().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", dumpref=true, from="IPSDataEntity")
    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEMethodDTO = this.getRefPSSysDynaModel() != null ? this.getPSDEAction().getPSDataEntity().getPSDEMethodDTO(this.getRefPSSysDynaModel()) : (this.getRefPSDataEntity() != null ? this.getPSDEAction().getPSDataEntity().getPSLinkDEMethodDTO(this.getRefPSDataEntity(), this.getRefPSDEFGroup()) : (this.getPSDEFGroup() != null ? this.getPSDEAction().getPSDataEntity().getPSDEMethodDTO(this.getPSDEFGroup()) : this.getPSDEAction().getPSDataEntity().getDefaultPSDEMethodDTO()));
        }
        return this.iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61")
    public IPSSysDynaModel getRefPSSysDynaModel() {
        return this.refPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5173\u8054\u67e5\u8be2", dumpref=true, from="IPSDataEntity")
    public IPSDEDataQuery getPSDEDataQuery() {
        return null;
    }

    protected boolean isCalcPSDEMethodDTO() {
        return this.bCalcPSDEMethodDTO;
    }

    protected void setCalcPSDEMethodDTO(boolean bCalcPSDEMethodDTO) {
        this.bCalcPSDEMethodDTO = bCalcPSDEMethodDTO;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEAction();
    }

    @Override
    protected String onGetRTMOSFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61")
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        return this.getPSDEAction().getOutRefPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getRefPSDEFGroup() throws Exception {
        return this.getPSDEAction().getOutRefPSDEFGroup();
    }
}

