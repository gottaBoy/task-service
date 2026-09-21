/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeObject;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBICubeMeasure
extends IPSBICubeObject {
    public static final String MEASURETYPE_COMMON = "COMMON";
    public static final String MEASURETYPE_CALCULATED = "CALCULATED";

    @Override
    public String getCodeName();

    public IPSDEField getPSDEField();

    public String getMeasureType();

    public boolean isDataItem();

    public String getMeasureFormula();

    public String getValueFormat();

    public String getMeasureTag();

    public String getMeasureTag2();

    public String getMeasureGroup();

    public String getJsonFormat();

    public String getAggMode();

    public IPSCodeList getPSCodeList();

    public String getDrillDownPSDEViewId();

    public String getDrillDetailPSDEViewId();

    public String getParamPSDEUIActionId();

    public String getParamPSDEUIActionTag() throws Exception;

    public String getDrillDetailCustomCond();

    public int getStdDataType();

    public String getTextTemplate();

    public String getTipTemplate();
}

