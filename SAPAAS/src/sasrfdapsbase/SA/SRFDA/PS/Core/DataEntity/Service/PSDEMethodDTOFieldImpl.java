/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.IPSModelObject
 *  net.ibizsys.pscore.srv.util.IPSRecursionWork
 *  net.ibizsys.pscore.srv.util.PSRecursionHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DEField.IPSInheritDEField;
import SA.SRFDA.PS.Core.DEField.IPSLinkDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2ManyObjDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2OneDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSOne2OneObjDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupDataDEField;
import SA.SRFDA.PS.Core.DEField.IPSPickupObjectDEField;
import SA.SRFDA.PS.Core.DEField.PSDEFieldBaseImpl;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERCustom;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTOField;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.IPSRecursionWork;
import net.ibizsys.pscore.srv.util.PSRecursionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public class PSDEMethodDTOFieldImpl
extends PSDEFieldBaseImpl
implements IPSDEMethodDTOField {
    private static final Log log = LogFactory.getLog(PSDEMethodDTOFieldImpl.class);
    private IPSDEMethodDTO iPSDEMethodDTO = null;
    private IPSDEFGroupDetail iPSDEFGroupDetail = null;
    private IPSDEField iPSDEField = null;
    private int nOrderValue = 99999;
    private String strCodeName = null;
    private boolean bAllowEmpty = true;
    private IPSCodeList iPSCodeList = null;
    private int nUserInputMode = 0;
    private String strType = null;
    private int nStdDataType = 0;
    private IPSDEMethodDTO refPSDEMethodDTO = null;
    private IPSDERBase iPSDERBase = null;
    private IPSDERBase minorPSDERBase = null;
    private IPSSysDynaModelAttr srcPSSysDynaModelAttr = null;
    private String strSourceType = null;
    private String strFieldTag = null;
    private String strFieldTag2 = null;
    private boolean bCalcRefPSDEMethodDTO = false;
    private String strJsonFormat = null;
    private boolean bListMap = false;
    private IPSDEMethodDTOField relatedPSDEMethodDTOField = null;
    private boolean bCalcRelatedPSDEMethodDTOField = false;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMethodDTO iPSDEMethodDTO, Object objField) throws Exception {
        if (objField instanceof IPSSysDynaModelAttr) {
            this.initFromDynaModelAttr(iDAGlobalHelper, iPSDEMethodDTO, (IPSSysDynaModelAttr)objField);
            return;
        }
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMethodDTO = iPSDEMethodDTO;
            boolean bUseServiceCode = this.iPSDEMethodDTO.getPSDataEntity().isDTOUseServiceCodeName();
            if (objField instanceof IPSDEFGroupDetail) {
                this.iPSDEFGroupDetail = (IPSDEFGroupDetail)objField;
                this.iPSDEField = this.iPSDEFGroupDetail.getPSDEField();
                this.strSourceType = "DEFGROUPDETAIL";
            } else if (objField instanceof IPSDEField) {
                this.iPSDEField = (IPSDEField)objField;
                this.strSourceType = "DEFIELD";
            } else if (objField instanceof IPSDERBase) {
                this.iPSDERBase = (IPSDERBase)objField;
                this.strSourceType = "DER";
            }
            if (this.getPSDEField() != null) {
                this.setId(this.getPSDEField().getId());
                if (this.getPSDEFGroupDetail() != null) {
                    this.strCodeName = bUseServiceCode ? this.getPSDEFGroupDetail().getServiceCodeName() : this.getPSDEFGroupDetail().getCodeName();
                    this.nOrderValue = this.getPSDEFGroupDetail().getOrderValue();
                    this.bAllowEmpty = this.getPSDEFGroupDetail().isAllowEmpty();
                    this.iPSCodeList = this.getPSDEFGroupDetail().getPSCodeList();
                    this.nUserInputMode = this.getPSDEFGroupDetail().getUserInputMode();
                    this.setJsonFormat(this.getPSDEFGroupDetail().getJsonFormat());
                    if (this.getPSDEFGroupDetail().getPSDEField().isSystemReserver()) {
                        this.nUserInputMode = 0;
                    }
                } else {
                    this.strCodeName = bUseServiceCode ? this.getPSDEField().getServiceCodeName() : this.getPSDEField().getCodeName();
                    this.nOrderValue = this.getPSDEField().getOrderValue();
                    this.bAllowEmpty = this.getPSDEField().isAllowEmpty();
                    this.iPSCodeList = this.getPSDEField().getPSCodeList();
                    this.nUserInputMode = this.getPSDEField().getUserInputMode();
                    this.setJsonFormat(this.getPSDEField().getJsonFormat());
                    if (this.getPSDEField().isSystemReserver()) {
                        this.nUserInputMode = 0;
                    }
                }
                if (this.getPSDEField().isKeyDEField()) {
                    this.nUserInputMode |= 2;
                    if (this.getPSDEField().getPSDataEntity().getUnionKeyValuePSDEFields() != null) {
                        this.nUserInputMode ^= 1;
                    }
                }
            } else if (this.getPSDER() != null) {
                this.setId(this.getPSDER().getId());
                this.strCodeName = bUseServiceCode ? this.getPSDER().getMinorServiceCodeName() : this.getPSDER().getMinorCodeName();
                this.bAllowEmpty = true;
                this.nUserInputMode = 3;
            } else {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u6216\u5d4c\u5957\u5173\u7cfb\u5bf9\u8c61");
            }
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

    public void initFromDynaModelAttr(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEMethodDTO iPSDEMethodDTO, IPSSysDynaModelAttr srcPSSysDynaModelAttr) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEMethodDTO = iPSDEMethodDTO;
            boolean bUseServiceCode = this.iPSDEMethodDTO.getPSDataEntity().isDTOUseServiceCodeName();
            this.srcPSSysDynaModelAttr = srcPSSysDynaModelAttr;
            this.strSourceType = "DYNAMODELATTR";
            this.strCodeName = this.getSrcPSSysDynaModelAttr().getCodeName();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getSrcPSSysDynaModelAttr().getName();
            }
            if (bUseServiceCode) {
                this.strCodeName = this.iPSDEMethodDTO.getPSDataEntity().getAPICodeName(null, this.strCodeName, null);
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
                    this.setCalcRefPSDEMethodDTO(true);
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
        } else if (StringHelper.compare((String)this.getSourceType(), (String)"DEFIELD", (boolean)false) == 0 || StringHelper.compare((String)this.getSourceType(), (String)"DEFGROUPDETAIL", (boolean)false) == 0) {
            if (this.getPSDEField() != null) {
                if (this.getPSDEField() instanceof IPSInheritDEField || this.getPSDEField() instanceof IPSPickupDataDEField) {
                    this.setCalcRelatedPSDEMethodDTOField(true);
                } else if (this.getPSDEField() instanceof IPSOne2ManyDataDEField) {
                    this.strType = "DTOS";
                    IPSOne2ManyDataDEField iPSOne2ManyDataDEField = (IPSOne2ManyDataDEField)this.getPSDEField();
                    this.iPSDERBase = iPSOne2ManyDataDEField.getPSDER();
                    if (iPSOne2ManyDataDEField.isMap()) {
                        this.bListMap = true;
                    }
                    this.setCalcRefPSDEMethodDTO(true);
                } else if (this.getPSDEField() instanceof IPSOne2OneDataDEField) {
                    this.strType = "DTO";
                    IPSOne2OneDataDEField iPSOne2OneDataDEField = (IPSOne2OneDataDEField)this.getPSDEField();
                    this.iPSDERBase = iPSOne2OneDataDEField.getPSDER();
                    this.setCalcRefPSDEMethodDTO(true);
                } else if (this.getPSDEField() instanceof IPSPickupObjectDEField) {
                    this.strType = "DTO";
                    IPSPickupObjectDEField iPSPickupObjectDEField = (IPSPickupObjectDEField)this.getPSDEField();
                    this.minorPSDERBase = iPSPickupObjectDEField.getPSDER();
                    this.setCalcRefPSDEMethodDTO(true);
                } else if (this.getPSDEField() instanceof IPSOne2ManyObjDEField) {
                    this.strType = "DTOS";
                    IPSOne2ManyObjDEField iPSOne2ManyObjDEField = (IPSOne2ManyObjDEField)this.getPSDEField();
                    if (iPSOne2ManyObjDEField.isMap()) {
                        this.bListMap = true;
                    }
                    if (iPSOne2ManyObjDEField.getRefPSSysDynaModel() != null) {
                        this.setCalcRefPSDEMethodDTO(true);
                    }
                } else if (this.getPSDEField() instanceof IPSOne2OneObjDEField) {
                    this.strType = "DTO";
                    IPSOne2OneObjDEField iPSOne2OneObjDEField = (IPSOne2OneObjDEField)this.getPSDEField();
                    if (iPSOne2OneObjDEField.getRefPSSysDynaModel() != null) {
                        this.setCalcRefPSDEMethodDTO(true);
                    }
                } else {
                    boolean bArray = false;
                    String strDEFDataType = this.getPSDEField().getDataType();
                    if (!StringHelper.isNullOrEmpty((String)strDEFDataType)) {
                        String strRealType = "";
                        int nPos = strDEFDataType.lastIndexOf("ARRAY");
                        if (nPos != -1 && (nPos == strDEFDataType.length() - 5 || nPos == strDEFDataType.length() - 6)) {
                            strRealType = strDEFDataType.substring(0, nPos);
                            bArray = true;
                            this.strType = "SIMPLES";
                            this.nStdDataType = strRealType.equalsIgnoreCase("TEXT") ? 25 : (strRealType.equalsIgnoreCase("FLOAT") ? 7 : (strRealType.equalsIgnoreCase("INT") ? 9 : (strRealType.equalsIgnoreCase("BIGINT") ? 1 : (strRealType.equalsIgnoreCase("DECIMAL") ? 6 : 25))));
                        }
                    }
                    if (!bArray) {
                        this.strType = "SIMPLE";
                        this.nStdDataType = this.getPSDEField().getStdDataType();
                    }
                }
            }
        } else if (StringHelper.compare((String)this.getSourceType(), (String)"DER", (boolean)false) == 0 && this.getPSDER() != null) {
            if (this.getPSDER() instanceof IPSDER1N) {
                this.strType = "DER1N".equals(this.getPSDER().getDERType()) ? "DTOS" : "DTO";
            } else if (this.getPSDER() instanceof IPSDERCustom) {
                IPSDERCustom iPSDERCustom = (IPSDERCustom)this.getPSDER();
                this.strType = "DER1N".equals(iPSDERCustom.getDERSubType()) ? "DTOS" : "DTO";
            }
            this.setCalcRefPSDEMethodDTO(true);
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getRelatedPSDEMethodDTOField();
        this.getRefPSDEMethodDTO();
        return super.onCheck();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSDEMethodDTO();
    }

    protected IPSDEMethodDTO calcRefPSDEMethodDTO(IPSDataEntity refPSDataEntity) throws Exception {
        if (StringHelper.compare((String)refPSDataEntity.getId(), (String)this.getPSDEMethodDTO().getPSDataEntity().getId(), (boolean)false) == 0 && this.getPSDEMethodDTO().getPSDEFGroup() == null) {
            return this.getPSDEMethodDTO();
        }
        return refPSDataEntity.getDefaultPSDEMethodDTO();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", outputdoc="false")
    public IPSDEMethodDTO getPSDEMethodDTO() {
        return this.iPSDEMethodDTO;
    }

    protected void setPSDEMethodDTO(IPSDEMethodDTO iPSDEMethodDTO) {
        this.iPSDEMethodDTO = iPSDEMethodDTO;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity")
    public IPSDEField getPSDEField() {
        return this.iPSDEField;
    }

    protected void setPSDEField(IPSDEField iPSDEField) {
        this.iPSDEField = iPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u7ec4\u6210\u5458", hideempty=true)
    public IPSDEFGroupDetail getPSDEFGroupDetail() {
        return this.iPSDEFGroupDetail;
    }

    @Override
    protected IPSDEFieldBase getProxyPSDEFieldBase() {
        if (this.getPSDEFGroupDetail() != null) {
            return this.getPSDEFGroupDetail();
        }
        return this.getPSDEField();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEMethodDTO().getPSSysModelInstId();
    }

    @Override
    public String getModelType() {
        return "PSDEMETHODDTOFIELD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDEMethodDTO().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEMethodDTO().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEMethodDTO().getModelId(), (Object)this.getName());
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
        if (this.getPSDEFGroupDetail() != null) {
            return this.getPSDEFGroupDetail().getLogicName();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getLogicName();
        }
        if (this.getPSDER() != null) {
            return this.getPSDER().getMinorLogicName();
        }
        return "";
    }

    @Override
    public String getMemo() {
        if (this.getPSDEFGroupDetail() != null) {
            return this.getPSDEFGroupDetail().getMemo();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getMemo();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", hideempty2=true)
    public String getDefaultValueType() {
        if (this.getPSDEFGroupDetail() != null) {
            return this.getPSDEFGroupDetail().getDefaultValueType();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getDefaultValueType();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", hideempty2=true)
    public String getDefaultValue() {
        if (this.getPSDEFGroupDetail() != null) {
            return this.getPSDEFGroupDetail().getDefaultValue();
        }
        if (this.getPSDEField() != null) {
            return this.getPSDEField().getDefaultValue();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53DTO\u5bf9\u8c61\u5c5e\u6027\u7c7b\u578b", codelist="DEMethodDTOFieldType")
    public String getType() {
        if (StringHelper.isNullOrEmpty((String)this.strType)) {
            try {
                this.getRelatedPSDEMethodDTOField();
                this.getRefPSDEMethodDTO();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
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
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53\u65b9\u6cd5DTO\u5bf9\u8c61", hideempty=true, dumpref=true, from="getRefPSDataEntityMust()")
    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception {
        if (this.refPSDEMethodDTO == null && this.isCalcRefPSDEMethodDTO()) {
            if (StringHelper.compare((String)this.getSourceType(), (String)"DYNAMODELATTR", (boolean)false) == 0) {
                if (StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"OBJECT", (boolean)false) == 0) {
                    IPSSysDynaModel refPSSysDynaModel = this.getSrcPSSysDynaModelAttr().getRefPSSysDynaModel();
                    if (refPSSysDynaModel == null) {
                        throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", this.getSrcPSSysDynaModelAttr().getName()));
                    }
                    this.refPSDEMethodDTO = this.getPSDEMethodDTO().getPSDataEntity().getPSDEMethodDTO(refPSSysDynaModel);
                } else if (StringHelper.compare((String)this.getSrcPSSysDynaModelAttr().getValueType(), (String)"DE", (boolean)false) == 0) {
                    IPSDataEntity refPSDataEntity = this.getSrcPSSysDynaModelAttr().getRefPSDataEntity();
                    IPSDEFGroup refPSDEFGroup = this.getSrcPSSysDynaModelAttr().getRefPSDEFGroup();
                    if (refPSDataEntity == null) {
                        throw new Exception(String.format("\u52a8\u6001\u6a21\u578b\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u5b9e\u4f53\u5bf9\u8c61", this.getSrcPSSysDynaModelAttr().getName()));
                    }
                    this.refPSDEMethodDTO = refPSDataEntity.getPSDEMethodDTO(refPSDEFGroup);
                }
            } else if (StringHelper.compare((String)this.getSourceType(), (String)"DEFIELD", (boolean)false) == 0 || StringHelper.compare((String)this.getSourceType(), (String)"DEFGROUPDETAIL", (boolean)false) == 0) {
                if (this.getPSDEField() != null) {
                    if (this.getPSDEField() instanceof IPSOne2ManyDataDEField) {
                        final IPSOne2ManyDataDEField iPSOne2ManyDataDEField = (IPSOne2ManyDataDEField)this.getPSDEField();
                        this.refPSDEMethodDTO = (IPSDEMethodDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                            public IPSDEMethodDTO execute(Object obj) throws Exception {
                                return PSDEMethodDTOFieldImpl.this.calcRefPSDEMethodDTO(iPSOne2ManyDataDEField.getPSDER().getMinorPSDataEntity());
                            }
                        }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)iPSOne2ManyDataDEField.getPSDER().getMinorPSDataEntity());
                    } else if (this.getPSDEField() instanceof IPSOne2OneDataDEField) {
                        final IPSOne2OneDataDEField iPSOne2OneDataDEField = (IPSOne2OneDataDEField)this.getPSDEField();
                        this.refPSDEMethodDTO = (IPSDEMethodDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                            public IPSDEMethodDTO execute(Object obj) throws Exception {
                                return PSDEMethodDTOFieldImpl.this.calcRefPSDEMethodDTO(iPSOne2OneDataDEField.getPSDER().getMinorPSDataEntity());
                            }
                        }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)iPSOne2OneDataDEField.getPSDER().getMinorPSDataEntity());
                    } else if (this.getPSDEField() instanceof IPSPickupObjectDEField) {
                        final IPSPickupObjectDEField iPSPickupObjectDEField = (IPSPickupObjectDEField)this.getPSDEField();
                        this.refPSDEMethodDTO = (IPSDEMethodDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                            public IPSDEMethodDTO execute(Object obj) throws Exception {
                                return PSDEMethodDTOFieldImpl.this.calcRefPSDEMethodDTO(iPSPickupObjectDEField.getPSDER().getMajorPSDataEntity());
                            }
                        }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)iPSPickupObjectDEField.getPSDER().getMajorPSDataEntity());
                    } else if (this.getPSDEField() instanceof IPSOne2ManyObjDEField) {
                        IPSOne2ManyObjDEField iPSOne2ManyObjDEField = (IPSOne2ManyObjDEField)this.getPSDEField();
                        IPSSysDynaModel refPSSysDynaModel = iPSOne2ManyObjDEField.getRefPSSysDynaModel();
                        if (refPSSysDynaModel == null) {
                            throw new Exception(String.format("\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", iPSOne2ManyObjDEField.getName()));
                        }
                        this.refPSDEMethodDTO = this.getPSDEMethodDTO().getPSDataEntity().getPSDEMethodDTO(refPSSysDynaModel);
                    } else if (this.getPSDEField() instanceof IPSOne2OneObjDEField) {
                        IPSOne2OneObjDEField iPSOne2OneObjDEField = (IPSOne2OneObjDEField)this.getPSDEField();
                        IPSSysDynaModel refPSSysDynaModel = iPSOne2OneObjDEField.getRefPSSysDynaModel();
                        if (refPSSysDynaModel == null) {
                            throw new Exception(String.format("\u5c5e\u6027[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u7528\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", iPSOne2OneObjDEField.getName()));
                        }
                        this.refPSDEMethodDTO = this.getPSDEMethodDTO().getPSDataEntity().getPSDEMethodDTO(refPSSysDynaModel);
                    }
                }
            } else if (StringHelper.compare((String)this.getSourceType(), (String)"DER", (boolean)false) == 0 && this.getPSDER() != null) {
                this.refPSDEMethodDTO = (IPSDEMethodDTO)PSRecursionHelper.execute((IPSRecursionWork)new IPSRecursionWork<IPSDEMethodDTO>(){

                    public IPSDEMethodDTO execute(Object obj) throws Exception {
                        return PSDEMethodDTOFieldImpl.this.calcRefPSDEMethodDTO(PSDEMethodDTOFieldImpl.this.getPSDER().getMinorPSDataEntity());
                    }
                }, (net.ibizsys.pscore.srv.util.IPSModelObject)this, (Object)this.getPSDER().getMinorPSDataEntity());
            }
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
        return (this.nUserInputMode & 3) == 0;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u8f93\u51fa", ignoredumpvalues="false")
    public boolean isIgnoreOutput() {
        return (this.nUserInputMode & 4) == 4;
    }

    protected void setUserInputMode(int nUserInputMode) {
        this.nUserInputMode = nUserInputMode;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5957\u6570\u636e\u4e3b\u5173\u7cfb", hideempty=true, dumpref=true, ignorepf=true, from="IPSDataEntity", from_method="getMajorPSDERBase")
    public IPSDERBase getPSDER() {
        return this.iPSDERBase;
    }

    public IPSDERBase getMinorPSDER() {
        return this.minorPSDERBase;
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

    protected boolean isCalcRefPSDEMethodDTO() {
        return this.bCalcRefPSDEMethodDTO;
    }

    protected void setCalcRefPSDEMethodDTO(boolean bCalcRefPSDEMethodDTO) {
        this.bCalcRefPSDEMethodDTO = bCalcRefPSDEMethodDTO;
    }

    protected boolean isCalcRelatedPSDEMethodDTOField() {
        return this.bCalcRelatedPSDEMethodDTOField;
    }

    protected void setCalcRelatedPSDEMethodDTOField(boolean bCalcRelatedPSDEMethodDTOField) {
        this.bCalcRelatedPSDEMethodDTOField = bCalcRelatedPSDEMethodDTOField;
    }

    @Override
    @PSModelRTMeta(description="\u662f\u5426\u4e3aList\u7684MAP\u6295\u5c04", ignoredumpvalues="false")
    public boolean isListMap() {
        return this.bListMap;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7684\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDataEntity getRelatedPSDataEntity() throws Exception {
        if (this.getRelatedPSDEMethodDTO() != null) {
            return this.getRelatedPSDEMethodDTO().getPSDataEntity();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7684DTO\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getRelatedPSDataEntityMust().getPSDEMethodDTO")
    public IPSDEMethodDTO getRelatedPSDEMethodDTO() throws Exception {
        if (this.getRelatedPSDEMethodDTOField() != null) {
            return this.getRelatedPSDEMethodDTOField().getPSDEMethodDTO();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u7684DTO\u5c5e\u6027\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getRelatedPSDEMethodDTOMust().getPSDEMethodDTOField")
    public IPSDEMethodDTOField getRelatedPSDEMethodDTOField() throws Exception {
        if (this.relatedPSDEMethodDTOField == null && this.isCalcRelatedPSDEMethodDTOField()) {
            IPSLinkDEField iPSLinkDEField = (IPSLinkDEField)this.getPSDEField();
            IPSDEField relatedPSDEField = iPSLinkDEField.getRelatedPSDEField();
            IPSDEMethodDTO relatedPSDEMethodDTO = this.getPSDEMethodDTO().getPSDataEntity().getPSSystem().getPSDataEntity2(relatedPSDEField.getPSDataEntity().getId()).getDefaultPSDEMethodDTO();
            Iterator<? extends IPSDEMethodDTOField> psDEMethodDTOFields = relatedPSDEMethodDTO.getPSDEMethodDTOFields();
            if (psDEMethodDTOFields != null) {
                while (psDEMethodDTOFields.hasNext()) {
                    IPSDEMethodDTOField iPSDEMethodDTOField = psDEMethodDTOFields.next();
                    if (iPSDEMethodDTOField.getPSDEField() == null || StringHelper.compare((String)relatedPSDEField.getId(), (String)iPSDEMethodDTOField.getPSDEField().getId(), (boolean)false) != 0) continue;
                    this.relatedPSDEMethodDTOField = iPSDEMethodDTOField;
                    break;
                }
            }
            if (this.relatedPSDEMethodDTOField != null) {
                this.relatedPSDEMethodDTOField.getRelatedPSDEMethodDTOField();
                this.strType = this.relatedPSDEMethodDTOField.getType();
                this.bListMap = this.relatedPSDEMethodDTOField.isListMap();
                this.refPSDEMethodDTO = this.relatedPSDEMethodDTOField.getRefPSDEMethodDTO();
                this.nStdDataType = this.relatedPSDEMethodDTOField.getStdDataType();
                if (!"DTO".equals(this.getType()) && !"DTOS".equals(this.getType())) {
                    this.relatedPSDEMethodDTOField = null;
                    this.setCalcRelatedPSDEMethodDTOField(false);
                }
            } else {
                boolean bArray = false;
                String strDEFDataType = this.getPSDEField().getDataType();
                if (!StringHelper.isNullOrEmpty((String)strDEFDataType)) {
                    String strRealType = "";
                    int nPos = strDEFDataType.lastIndexOf("ARRAY");
                    if (nPos != -1 && (nPos == strDEFDataType.length() - 5 || nPos == strDEFDataType.length() - 6)) {
                        strRealType = strDEFDataType.substring(0, nPos);
                        bArray = true;
                        this.strType = "SIMPLES";
                        this.nStdDataType = strRealType.equalsIgnoreCase("TEXT") ? 25 : (strRealType.equalsIgnoreCase("FLOAT") ? 7 : (strRealType.equalsIgnoreCase("INT") ? 9 : (strRealType.equalsIgnoreCase("BIGINT") ? 1 : (strRealType.equalsIgnoreCase("DECIMAL") ? 6 : 25))));
                    }
                }
                if (!bArray) {
                    this.strType = "SIMPLE";
                    this.nStdDataType = this.getPSDEField().getStdDataType();
                }
                this.relatedPSDEMethodDTOField = null;
                this.setCalcRelatedPSDEMethodDTOField(false);
            }
        }
        return this.relatedPSDEMethodDTOField;
    }
}

