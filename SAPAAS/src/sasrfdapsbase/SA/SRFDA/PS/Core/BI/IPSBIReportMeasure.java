/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSBIReportItem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBIReportMeasure
extends IPSBIReportItem {
    public IPSBICubeMeasure getPSBICubeMeasure();

    public String getPlaceType();

    public String getAggMode();
}

