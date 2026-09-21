/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReportObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Properties;

@PSModelPFIgnoreMeta
public interface IPSBIReportItem
extends IPSBIReportObject,
IPSModelObject {
    public static final String ITEMTYPE_MEASURE = "MEASURE";
    public static final String ITEMTYPE_DIMENSION = "DIMENSION";
    public static final String ITEMTYPE_USER = "USER";

    @Override
    public String getCodeName();

    public String getItemType();

    public String getItemTag();

    public String getItemTag2();

    public Properties getItemParams();
}

