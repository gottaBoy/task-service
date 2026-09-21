/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSBIReportDimension;
import SA.SRFDA.PS.Core.BI.IPSBIReportMeasure;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import java.util.Iterator;
import java.util.Properties;

@PSModelPFIgnoreMeta
public interface IPSBIReport
extends IPSModelObject {
    @Override
    public String getCodeName();

    public IPSBICube getPSBICube();

    public Iterator<? extends IPSBIReportMeasure> getAllPSBIReportMeasures() throws Exception;

    public IPSBIReportMeasure getPSBIReportMeasure(String var1) throws Exception;

    public IPSBIReportMeasure getPSBIReportMeasure(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSBIReportDimension> getAllPSBIReportDimensions() throws Exception;

    public IPSBIReportDimension getPSBIReportDimension(String var1) throws Exception;

    public IPSBIReportDimension getPSBIReportDimension(String var1, boolean var2) throws Exception;

    public String getReportTag();

    public String getReportTag2();

    public IPSSysUniRes getPSSysUniRes();

    public String getReportModel();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getSysUniResCode();

    public Properties getReportParams();

    public String getReportUIModel();

    public IPSSysPFPlugin getPSSysPFPlugin();

    public String getPSLayoutPanelId();
}

