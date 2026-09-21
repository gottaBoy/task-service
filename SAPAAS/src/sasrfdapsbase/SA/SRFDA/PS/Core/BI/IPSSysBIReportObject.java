/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReportObject;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSSysBIReportObject
extends IPSBIReportObject {
    public IPSSysBIReport getPSSysBIReport();
}

