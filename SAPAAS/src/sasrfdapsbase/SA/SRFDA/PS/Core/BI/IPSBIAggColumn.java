/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggTableObject;
import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBIAggColumn
extends IPSBIAggTableObject,
IPSModelObject {
    public static final String COLUMNTYPE_MEASURE = "MEASURE";
    public static final String COLUMNTYPE_DIMENSION = "DIMENSION";
    public static final String COLUMNTYPE_USER = "USER";

    public IPSDEField getPSDEField();

    @Override
    public String getCodeName();

    public String getColumnType();

    public IPSBICubeDimension getPSBICubeDimension();

    public IPSBICubeMeasure getPSBICubeMeasure();

    public String getColumnTag();

    public String getColumnTag2();
}

