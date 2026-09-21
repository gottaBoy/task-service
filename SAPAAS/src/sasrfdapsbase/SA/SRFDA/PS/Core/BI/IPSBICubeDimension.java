/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeLevel;
import SA.SRFDA.PS.Core.BI.IPSBICubeObject;
import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBICubeDimension
extends IPSBICubeObject {
    public static final String DIMENSIONTYPE_COMMON = "COMMON";
    public static final String DIMENSIONTYPE_CALCULATED = "CALCULATED";

    @Override
    public String getCodeName();

    public String getDimensionType();

    public IPSDEField getPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSBIDimension getPSBIDimension();

    public String getDimensionTag();

    public String getDimensionTag2();

    public Iterator<? extends IPSBICubeLevel> getAllPSBICubeLevels() throws Exception;

    public IPSBICubeLevel getPSBICubeLevel(String var1) throws Exception;

    public IPSBICubeLevel getPSBICubeLevel(String var1, boolean var2) throws Exception;

    public IPSCodeList getPSCodeList();

    public String getDimensionFormula();

    public boolean isAllHierarchy();

    public boolean isDefault();

    public String getParamPSDEUIActionId();

    public String getParamPSDEUIActionTag() throws Exception;

    public int getStdDataType();

    public String getTextTemplate();

    public String getTipTemplate();
}

