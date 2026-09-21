/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBICubeDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportItem;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportObject;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIReportItem")
@PSModelExtendMeta(title="\u667a\u80fd\u62a5\u8868\u7ef4\u5ea6\u9879\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DIMENSION"})
public interface IPSSysBIReportDimension
extends IPSSysBIReportItem,
IPSBIReportDimension,
IPSSysBIReportObject {
    public IPSSysBICubeDimension getPSSysBICubeDimension();
}

