/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSBIReportItem;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSBIReportDimension
extends IPSBIReportItem {
    public IPSBICubeDimension getPSBICubeDimension();

    public String getPlaceType();

    public String getPlacement();
}

