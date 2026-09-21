/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIReport;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReportMeasure;
import SA.SRFDA.PS.Core.BI.IPSSysBISchemeObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIReport")
public interface IPSSysBIReport
extends IPSBIReport,
IPSSysBISchemeObject {
    public IPSSysBICube getPSSysBICube();

    public Iterator<? extends IPSSysBIReportMeasure> getAllPSSysBIReportMeasures() throws Exception;

    public IPSSysBIReportMeasure getPSSysBIReportMeasure(String var1) throws Exception;

    public IPSSysBIReportMeasure getPSSysBIReportMeasure(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysBIReportDimension> getAllPSSysBIReportDimensions() throws Exception;

    public IPSSysBIReportDimension getPSSysBIReportDimension(String var1) throws Exception;

    public IPSSysBIReportDimension getPSSysBIReportDimension(String var1, boolean var2) throws Exception;
}

