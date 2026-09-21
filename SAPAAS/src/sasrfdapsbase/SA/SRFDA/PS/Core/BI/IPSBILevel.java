/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIHierarchy;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBILevel
extends IPSModelObject {
    public static final String LEVELTYPE_COMMON = "COMMON";
    public static final String LEVELTYPE_TIME_YEARS = "TIME_YEARS";
    public static final String LEVELTYPE_TIME_HALFYEARS = "TIME_HALFYEARS";
    public static final String LEVELTYPE_TIME_QUARTERS = "TIME_QUARTERS";
    public static final String LEVELTYPE_TIME_MONTHS = "TIME_MONTHS";
    public static final String LEVELTYPE_TIME_WEEKS = "TIME_WEEKS";
    public static final String LEVELTYPE_TIME_DAYS = "TIME_DAYS";
    public static final String LEVELTYPE_TIME_HOURS = "TIME_HOURS";
    public static final String LEVELTYPE_TIME_MINUTES = "TIME_MINUTES";

    public IPSBIHierarchy getPSBIHierarchy();

    public String getLevelType();

    public IPSDEField getTextPSDEField();

    public IPSDEField getValuePSDEField();

    public String getLevelTag();

    public String getLevelTag2();

    public boolean isUniqueMembers();

    public String getAggCaption();
}

