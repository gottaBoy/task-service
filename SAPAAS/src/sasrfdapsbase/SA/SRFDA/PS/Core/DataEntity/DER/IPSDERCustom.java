/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DER;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelExtendMeta(title="\u5b9e\u4f53\u81ea\u5b9a\u4e49\u5173\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DERCUSTOM"})
@PSModelPFIgnoreMeta
public interface IPSDERCustom
extends IPSDERBase,
IPSDER1NBase {
    public static final String DERSUBTYPE_DER1N = "DER1N";
    public static final String DERSUBTYPE_DER11 = "DER11";
    public static final String DERSUBTYPE_USER = "USER";
    public static final String DERSUBTYPE_USER2 = "USER2";
    public static final String DERSUBTYPE_USER3 = "USER3";
    public static final String DERSUBTYPE_USER4 = "USER4";

    public String getPickupDEFName();

    @Override
    public IPSDEField getPickupPSDEField() throws Exception;

    public String getDERSubType();

    public String getTypeValue();

    @Override
    public IPSDEDataSet getNestedPSDEDataSet() throws Exception;

    @Override
    public String getNestedPSDEDataSetId();

    public IPSDEField getPickupTextPSDEField() throws Exception;

    public IPSDEField getOne2XDataPSDEField() throws Exception;

    public boolean isEnablePhysicalDEFieldUpdate();

    @Override
    public String getRefPSDEDataSetId();

    @Override
    public String getRefPSDEDataSetName() throws Exception;

    @Override
    public IPSDEDataSet getRefPSDEDataSet() throws Exception;

    public String getParentType();

    public String getParentSubType();
}

