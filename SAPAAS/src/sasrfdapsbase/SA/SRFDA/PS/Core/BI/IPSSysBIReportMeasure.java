/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReportMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportItem;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportObject;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u6307\u6807\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIReportItem")
@PSModelExtendMeta(title="\u667a\u80fd\u62a5\u8868\u6307\u6807\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"MEASURE"})
public interface IPSSysBIReportMeasure
extends IPSSysBIReportItem,
IPSBIReportMeasure,
IPSSysBIReportObject {
    public IPSSysBICubeMeasure getPSSysBICubeMeasure();
}

