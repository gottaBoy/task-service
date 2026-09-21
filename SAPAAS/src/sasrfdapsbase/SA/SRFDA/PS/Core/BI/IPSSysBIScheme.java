/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSSysBICube;
import SA.SRFDA.PS.Core.BI.IPSSysBIDimension;
import SA.SRFDA.PS.Core.BI.IPSSysBIReport;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPubObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIBase;
import SA.SRFDA.PS.Core.System.IPSSysModelGroup;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import java.util.Iterator;

@PSModelPFIgnoreMeta
@PSModelInterfaceMeta(title="\u667a\u80fd\u62a5\u8868\u4f53\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSSysBIScheme")
public interface IPSSysBIScheme
extends IPSBIScheme,
IPSSystemObject,
IPSSysSFPubObject,
IPSSubSysServiceAPIBase {
    public Iterator<? extends IPSSysBIDimension> getAllPSSysBIDimensions() throws Exception;

    public IPSSysBIDimension getPSSysBIDimension(String var1) throws Exception;

    public IPSSysBIDimension getPSSysBIDimension(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysBICube> getAllPSSysBICubes() throws Exception;

    public IPSSysBICube getPSSysBICube(String var1) throws Exception;

    public IPSSysBICube getPSSysBICube(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysBIAggTable> getAllPSSysBIAggTables() throws Exception;

    public IPSSysBIAggTable getPSSysBIAggTable(String var1) throws Exception;

    public IPSSysBIAggTable getPSSysBIAggTable(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSSysBIReport> getAllPSSysBIReports() throws Exception;

    public IPSSysBIReport getPSSysBIReport(String var1) throws Exception;

    public IPSSysBIReport getPSSysBIReport(String var1, boolean var2) throws Exception;

    public IPSSystemModule getPSSystemModule();

    public IPSSysSFPlugin getPSSysSFPlugin();

    public IPSSFXCodeObject getRender();

    public String getDBObjNameCase();

    public IPSSysModelGroup getPSSysModelGroup();
}

