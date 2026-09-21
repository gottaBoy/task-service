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
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionInput;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionParam;
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
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEActionInputImpl
extends PSObjectImpl
implements IPSDEActionInput {
    private static final Log log = LogFactory.getLog(PSDEActionInputImpl.class);
    protected IPSDEAction iPSDEAction;
    private String strType = "UNKNOWN";
    private boolean bIgnoreParam = false;
    private boolean bOutput = false;
    private IPSSysDynaModel refPSSysDynaModel = null;
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private IPSDEFGroup iPSDEFGroup = null;
    private IPSDEField keyPSDEField = null;
    private boolean bDEMethodParamMode = false;
    private String strCodeName = null;
    private boolean bCalcPSDEMethodDTO = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEAction iPSDEAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEAction = iPSDEAction;
            this.setId(KeyValueHelper.genUniqueId((String)iPSDEAction.getId(), (String)"INPUT"));
            this.strCodeName = String.format("%1$sInput", PSModelCodeNameUtils.capitalize(iPSDEAction.getCodeName()));
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
        } else if (StringHelper.compare((String)this.getType(), (String)"KEYFIELD", (boolean)false) == 0 || StringHelper.compare((String)this.getType(), (String)"KEYFIELDS", (boolean)false) == 0) {
            this.keyPSDEField = this.getPSDEAction().getPSDataEntity().getKeyPSDEField();
        }
    }

    protected void initByActionMode(String strActionMode) throws Exception {
        boolean bCustomParam;
        boolean bl = bCustomParam = this.getPSDEAction().getParamMode() == 2;
        if (StringHelper.compare((String)strActionMode, (String)"CHECKKEY", (boolean)false) == 0) {
            if (this.getPSDEAction().isBatchAction()) {
                throw new Exception("\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u72b6\u6001\u884c\u4e3a\u4e0d\u652f\u6301\u6279\u64cd\u4f5c");
            }
            this.strType = "DTO";
            this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"CREATE", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UPDATE", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"CREATEBATCH", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"CREATEBATCH2", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UPDATEBATCH", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UPDATEBATCH2", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"SAVE", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"COPY", (boolean)false) == 0) {
            this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
            this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
            if (this.iPSDEFGroup == null && this.getPSDEAction().getOutPSDEFGroup() == null) {
                this.bOutput = true;
            } else if (this.iPSDEFGroup != null && this.getPSDEAction().getOutPSDEFGroup() != null && StringHelper.compare((String)this.iPSDEFGroup.getId(), (String)this.getPSDEAction().getOutPSDEFGroup().getId(), (boolean)false) == 0) {
                this.bOutput = true;
            }
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"DELETE", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"DELETEBATCH", (boolean)false) == 0) {
            this.strType = this.getPSDEAction().isBatchAction() ? "KEYFIELDS" : "KEYFIELD";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"GETDRAFT", (boolean)false) == 0) {
            if (this.getPSDEAction().isBatchAction()) {
                throw new Exception("\u83b7\u53d6\u6570\u636e\u8349\u7a3f\u884c\u4e3a\u4e0d\u652f\u6301\u6279\u64cd\u4f5c");
            }
            this.strType = "DTO";
            this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"MOVEORDER", (boolean)false) == 0) {
            if (this.getPSDEAction().isBatchAction()) {
                throw new Exception("\u79fb\u52a8\u4f4d\u7f6e\u884c\u4e3a\u4e0d\u652f\u6301\u6279\u64cd\u4f5c");
            }
            this.strType = "DTO";
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"READ", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"GETDRAFTFROM", (boolean)false) == 0) {
            if (this.getPSDEAction().isBatchAction()) {
                throw new Exception("\u83b7\u53d6\u6570\u636e\u884c\u4e3a\u4e0d\u652f\u6301\u6279\u64cd\u4f5c");
            }
            if (!bCustomParam) {
                this.strType = "KEYFIELD";
            } else {
                this.bDEMethodParamMode = true;
                this.strType = "DTO";
            }
            return;
        }
        if (StringHelper.compare((String)strActionMode, (String)"CUSTOM", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"UNKNOWN", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"CUSTOMBATCH", (boolean)false) == 0 || StringHelper.compare((String)strActionMode, (String)"CUSTOMBATCH2", (boolean)false) == 0) {
            if (bCustomParam) {
                this.bDEMethodParamMode = true;
                this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
            } else {
                if (this.getPSDEAction().getParamMode() == 99) {
                    this.strType = "NONE";
                    return;
                }
                if (this.getPSDEAction().getParamMode() == 3) {
                    this.refPSSysDynaModel = this.getPSDEAction().getInPSSysDynaModel();
                    if (this.getRefPSSysDynaModel() == null) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61");
                    }
                } else {
                    this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
                }
                this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
            }
            return;
        }
        if (bCustomParam) {
            this.bDEMethodParamMode = true;
            this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
        } else {
            this.iPSDEFGroup = this.getPSDEAction().getInPSDEFGroup();
            this.strType = this.getPSDEAction().isBatchAction() ? "DTOS" : "DTO";
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
    @PSModelRTMeta(description="\u8f93\u5165\u7c7b\u578b", codelist="DEMethodInputType")
    public String getType() {
        return this.strType;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61")
    public IPSDEFGroup getPSDEFGroup() {
        return this.iPSDEFGroup;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u53c2\u6570\u6a21\u578b\u5bf9\u8c61")
    public IPSSysDynaModel getRefPSSysDynaModel() {
        return this.refPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u53c2\u6570\u96c6\u5408", child=true, ignorepf=true, outputdoc="false")
    public Iterator<IPSDEActionParam> getPSDEActionParams() {
        if (this.bDEMethodParamMode) {
            return this.getPSDEAction().getPSDEActionParams();
        }
        return null;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEAction().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEACTIONINPUT";
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
    @PSModelRTMeta(description="\u8f93\u5165\u5bf9\u8c61\u540c\u65f6\u4e3a\u7ed3\u679c\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isOutput() {
        return this.bOutput;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEMethodDTO getPSDEMethodDTO() throws Exception {
        if (this.iPSDEMethodDTO == null && this.isCalcPSDEMethodDTO()) {
            this.iPSDEMethodDTO = this.bDEMethodParamMode ? this.getPSDEAction().getPSDataEntity().getPSDEActionInputDTO(this) : (this.getRefPSSysDynaModel() != null ? this.getPSDEAction().getPSDataEntity().getPSDEMethodDTO(this.getRefPSSysDynaModel()) : (this.getPSDEFGroup() != null ? this.getPSDEAction().getPSDataEntity().getPSDEMethodDTO(this.getPSDEFGroup()) : this.getPSDEAction().getPSDataEntity().getDefaultPSDEMethodDTO()));
        }
        return this.iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getKeyPSDEField() {
        return this.keyPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dump=false)
    public String getCodeName() {
        return this.strCodeName;
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
}

