/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTableObject;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u805a\u5408\u8868\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIAggColumn")
public interface IPSSysBIAggColumn
extends IPSBIAggColumn,
IPSSysBIAggTableObject {
    public IPSSysBICubeDimension getPSSysBICubeDimension();

    public IPSSysBICubeMeasure getPSSysBICubeMeasure();
}

