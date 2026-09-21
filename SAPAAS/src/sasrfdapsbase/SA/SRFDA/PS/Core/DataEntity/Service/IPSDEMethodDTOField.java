/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroupDetail;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u65b9\u6cd5DTO\u5c5e\u6027\u5bf9\u8c61\u63a5\u53e3", typefield="sourceType", implement="PSDEMethodDTOFieldImpl")
public interface IPSDEMethodDTOField
extends IPSDEFieldBase,
IPSModelSortable,
IPSModelObject {
    public static final String TYPE_SIMPLE = "SIMPLE";
    public static final String TYPE_SIMPLES = "SIMPLES";
    public static final String TYPE_DTO = "DTO";
    public static final String TYPE_DTOS = "DTOS";
    public static final String SOURCETYPE_DEFIELD = "DEFIELD";
    public static final String SOURCETYPE_DEFGROUPDETAIL = "DEFGROUPDETAIL";
    public static final String SOURCETYPE_DER = "DER";
    public static final String SOURCETYPE_DYNAMODELATTR = "DYNAMODELATTR";

    public IPSDEMethodDTO getPSDEMethodDTO();

    public String getType();

    public int getStdDataType();

    @Override
    public String getCodeName();

    public boolean isReadOnly();

    public IPSDEField getPSDEField();

    public IPSDEFGroupDetail getPSDEFGroupDetail();

    public IPSDERBase getPSDER();

    public IPSDataEntity getRefPSDataEntity() throws Exception;

    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception;

    public String getSourceType();

    public IPSSysDynaModelAttr getSrcPSSysDynaModelAttr();

    public boolean isAllowEmpty();

    public String getLogicName();

    public String getDefaultValueType();

    public String getDefaultValue();

    public String getFieldTag();

    public String getFieldTag2();

    public String getJsonFormat();

    public boolean isListMap();

    public IPSDataEntity getRelatedPSDataEntity() throws Exception;

    public IPSDEMethodDTO getRelatedPSDEMethodDTO() throws Exception;

    public IPSDEMethodDTOField getRelatedPSDEMethodDTOField() throws Exception;

    public boolean isIgnoreOutput();
}

