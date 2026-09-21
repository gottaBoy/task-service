/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.PSDEFieldBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTOField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSSysMethodDTOFieldImpl
extends PSDEFieldBaseImpl
implements IPSSysMethodDTOField {
    private static final Log log = LogFactory.getLog(PSSysMethodDTOFieldImpl.class);
    private IPSSysMethodDTO iPSSysMethodDTO = null;
    private int nOrderValue = 99999;
    private String strCodeName = null;
    private boolean bAllowEmpty = true;
    private int nUserInputMode = 0;
    private String strType = null;
    private int nStdDataType = 0;
    private IPSSysMethodDTO refPSSysMethodDTO = null;
    private IPSDEMethodDTO refPSDEMethodDTO = null;
    private IPSSysDynaModelAttr srcPSSysDynaModelAttr = null;
    private String strSourceType = null;
    private String strFieldTag = null;
    private String strFieldTag2 = null;
    private boolean bCalcRefPSSysMethodDTO = false;
    private boolean bCalcRefPSDEMethodDTO = false;
    private String strJsonFormat = null;

    public void initFromDynaModelAttr(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysMethodDTO iPSSysMethodDTO, IPSSysDynaModelAttr srcPSSysDynaModelAttr) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSSysMethodDTO = iPSSysMethodDTO;
            this.srcPSSysDynaModelAttr = srcPSSysDynaModelAttr;
            this.strSourceType = "DYNAMODELATTR";
            this.strCodeName = this.getSrcPSSysDynaModelAttr().getCodeName();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getSrcPSSysDynaModelAttr().getName();
            }
            boolean bUseServiceCode = false;
            if (this.iPSSysMethodDTO.getPSSystemModule() != null) {
                bUseServiceCode = this.iPSSysMethodDTO.getPSSystemModule().isDTOUseServiceCodeName();
                if (bUseServiceCode) {
                    this.strCodeName = this.iPSSysMethodDTO.getPSSystemModule().getAPICodeName(null, this.strCodeName, null);
                }
            } else {
                bUseServiceCode = this.iPSSysMethodDTO.getPSSystem().isDTOUseServiceCodeName();
                if (bUseServiceCode) {
                    this.strCodeName = this.iPSSysMethodDTO.getPSSystem().getAPICodeName(null, this.strCodeName, null);
                }
            }
            this.nOrderValue = this.getSrcPSSysDynaModelAttr().getOrderValue();
            this.bAllowEmpty = this.getSrcPSSysDynaModelAttr().isAllowEmpty();
            this.setJsonFormat(this.getSrcPSSysDynaModelAttr().getJsonFormat());
            this.nUserInputMode = 3;
            this.setName(this.getCodeName());
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
        if (StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODELATTR", (boolean)false) == 0) {
            if (StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"OBJECT", (boolean)false) == 0) {
                IPSSysDynaModel refPSSysDynaModel = this.getSrcPSSysDynaModelAttr().getRefPSSysDynaModel();
                this.strType = this.getSrcPSSysDynaModelAttr().isArray() ? "DTOS" : "DTO";
                if (refPSSysDynaModel != null) {
                    this.setCalcRefPSSysMethodDTO(true);
                }
            } else if (StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"DE", (boolean)false) == 0) {
                IPSDataEntity refPSDataEntity = this.getSrcPSSysDynaModelAttr().getRefPSDataEntity();
                if (refPSDataEntity == null) {
                    throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5b9e\u4f53\u5bf9\u8c61", this.getSrcPSSysDynaModelAttr().getName()));
                }
                this.strType = this.getSrcPSSysDynaModelAttr().isArray() ? "DTOS" : "DTO";
                this.setCalcRefPSDEMethodDTO(true);
            } else {
                this.strType = this.getSrcPSSysDynaModelAttr().isArray() ? "SIMPLES" : "SIMPLE";
                this.nStdDataType = this.getSrcPSSysDynaModelAttr().getStdDataType();
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        if (this.getRefPSSysMethodDTO() != null) {
            this.getRefPSSysMethodDTO().check();
        }
        if (this.getRefPSDEMethodDTO() != null) {
            this.getRefPSDEMethodDTO().check();
        }
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysMethodDTO();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u65b9\u6cd5DTO\u5bf9\u8c61", outputdoc="false")
    public IPSSysMethodDTO getPSSysMethodDTO() {
        return this.iPSSysMethodDTO;
    }

    protected void setPSSysMethodDTO(IPSSysMethodDTO iPSSysMethodDTO) {
        this.iPSSysMethodDTO = iPSSysMethodDTO;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysMethodDTO().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSSYSMETHODDTOFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSSysMethodDTO().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysMethodDTO().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSSysMethodDTO().getModelId(), (Object)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6", dynamodelmode=8)
    public String getCodeName() {
        return this.strCodeName;
    }

    protected void setCodeName(String strCodeName) {
        this.strCodeName = strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignoredumpvalues="99999", dump=false)
    public int getOrderValue() {
        return this.nOrderValue;
    }

    protected void setOrderValue(int nOrderValue) {
        this.nOrderValue = nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u8f93\u5165", ignoredumpvalues="true")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    protected void setAllowEmpty(boolean bAllowEmpty) {
        this.bAllowEmpty = bAllowEmpty;
    }

    @Override
    protected boolean onGetAutoModel() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u4e2d\u6587\u540d\u79f0")
    public String getLogicName() {
        return "";
    }

    @Override
    public String getMemo() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", hideempty2=true)
    public String getDefaultValueType() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true)
    public String getDefaultValue() {
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edfDTO\u5bf9\u8c61\u5c5e\u6027\u7c7b\u578b", codelist="DEMethodDTOFieldType")
    public String getType() {
        return this.strType;
    }

    protected void setType(String strType) {
        this.strType = strType;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    protected void setStdDataType(int nStdDataType) {
        this.nStdDataType = nStdDataType;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7cfb\u7edf\u65b9\u6cd5DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSSystem")
    public IPSSysMethodDTO getRefPSSysMethodDTO() throws Exception {
        if (this.refPSSysMethodDTO == null && this.isCalcRefPSSysMethodDTO() && StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODELATTR", (boolean)false) == 0 && StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"OBJECT", (boolean)false) == 0) {
            IPSSysDynaModel refPSSysDynaModel = this.getSrcPSSysDynaModelAttr().getRefPSSysDynaModel();
            if (refPSSysDynaModel == null) {
                throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", this.getSrcPSSysDynaModelAttr().getName()));
            }
            if (this.getPSSysMethodDTO().getSrcPSSysDynaModel() != null && StringHelper.compare((String)this.getPSSysMethodDTO().getSrcPSSysDynaModel().getId(), (String)this.getPSSysMethodDTO().getId(), (boolean)false) == 0) {
                this.refPSSysMethodDTO = this.getPSSysMethodDTO();
                return this.refPSSysMethodDTO;
            }
            this.refPSSysMethodDTO = this.getPSSysMethodDTO().getPSSystem().getPSSysMethodDTO(refPSSysDynaModel);
        }
        return this.refPSSysMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="getRefPSDataEntityMust()")
    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception {
        if (this.refPSDEMethodDTO == null && this.isCalcRefPSDEMethodDTO() && StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODELATTR", (boolean)false) == 0 && StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"DE", (boolean)false) == 0) {
            IPSDataEntity refPSDataEntity = this.getSrcPSSysDynaModelAttr().getRefPSDataEntity();
            IPSDEFGroup refPSDEFGroup = this.getSrcPSSysDynaModelAttr().getRefPSDEFGroup();
            if (refPSDataEntity == null) {
                throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5b9e\u4f53\u5bf9\u8c61", this.getSrcPSSysDynaModelAttr().getName()));
            }
            this.refPSDEMethodDTO = refPSDataEntity.getPSDEMethodDTO(refPSDEFGroup);
        }
        return this.refPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true)
    public IPSDataEntity getRefPSDataEntity() throws Exception {
        if (this.getRefPSDEMethodDTO() != null) {
            return this.getRefPSDEMethodDTO().getPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53ea\u8bfb\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isReadOnly() {
        return this.nUserInputMode == 0;
    }

    protected void setUserInputMode(int nUserInputMode) {
        this.nUserInputMode = nUserInputMode;
    }

    @Override
    @PSModelRTMeta(description="DTO\u5c5e\u6027\u6765\u6e90\u7c7b\u578b", codelist="DEMethodDTOFieldSourceType")
    public String getSourceType() {
        return this.strSourceType;
    }

    protected void setSourceType(String strSourceType) {
        this.strSourceType = strSourceType;
    }

    @Override
    @PSModelRTMeta(description="\u6765\u6e90\u52a8\u6001\u6a21\u578b\u5c5e\u6027", hideempty=true)
    public IPSSysDynaModelAttr getSrcPSSysDynaModelAttr() {
        return this.srcPSSysDynaModelAttr;
    }

    @Override
    protected boolean isExportModelCodeName() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty=true)
    public String getFieldTag() {
        return this.strFieldTag;
    }

    protected void setFieldTag(String strFieldTag) {
        this.strFieldTag = strFieldTag;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty=true)
    public String getFieldTag2() {
        return this.strFieldTag2;
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", hideempty=true)
    public String getJsonFormat() {
        return this.strJsonFormat;
    }

    protected void setJsonFormat(String strJsonFormat) {
        this.strJsonFormat = strJsonFormat;
    }

    protected void setFieldTag2(String strFieldTag2) {
        this.strFieldTag2 = strFieldTag2;
    }

    protected boolean isCalcRefPSSysMethodDTO() {
        return this.bCalcRefPSSysMethodDTO;
    }

    protected void setCalcRefPSSysMethodDTO(boolean bCalcRefPSSysMethodDTO) {
        this.bCalcRefPSSysMethodDTO = bCalcRefPSSysMethodDTO;
    }

    protected boolean isCalcRefPSDEMethodDTO() {
        return this.bCalcRefPSDEMethodDTO;
    }

    protected void setCalcRefPSDEMethodDTO(boolean bCalcRefPSDEMethodDTO) {
        this.bCalcRefPSDEMethodDTO = bCalcRefPSDEMethodDTO;
    }

    @Override
    protected IPSDEFieldBase getProxyPSDEFieldBase() {
        return null;
    }
}

