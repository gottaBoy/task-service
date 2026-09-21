/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.DEField.IPSDEFieldBase;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEMethodDTO;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModelAttr;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Service.IPSSysMethodDTO;

@PSModelPFIgnoreMeta
public interface IPSSysMethodDTOField
extends IPSDEFieldBase,
IPSModelSortable,
IPSModelObject {
    public static final String TYPE_SIMPLE = "SIMPLE";
    public static final String TYPE_SIMPLES = "SIMPLES";
    public static final String TYPE_DTO = "DTO";
    public static final String TYPE_DTOS = "DTOS";
    public static final String SOURCETYPE_DYNAMODELATTR = "DYNAMODELATTR";

    public IPSSysMethodDTO getPSSysMethodDTO();

    public String getType();

    public int getStdDataType();

    public IPSDataEntity getRefPSDataEntity() throws Exception;

    public IPSDEMethodDTO getRefPSDEMethodDTO() throws Exception;

    public IPSSysMethodDTO getRefPSSysMethodDTO() throws Exception;

    @Override
    public String getCodeName();

    public boolean isReadOnly();

    public boolean isAllowEmpty();

    public String getDefaultValueType();

    public String getDefaultValue();

    public String getFieldTag();

    public String getFieldTag2();

    public String getJsonFormat();

    public String getSourceType();

    public IPSSysDynaModelAttr getSrcPSSysDynaModelAttr();

    public String getLogicName();
}

