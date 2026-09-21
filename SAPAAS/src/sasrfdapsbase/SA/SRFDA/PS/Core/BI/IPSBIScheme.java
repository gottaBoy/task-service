/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggTable;
import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.BI.IPSBIDimension;
import SA.SRFDA.PS.Core.BI.IPSBIReport;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBIScheme
extends IPSModelObject {
    @Override
    public String getCodeName();

    public String getBIEngineType();

    public Iterator<? extends IPSBIDimension> getAllPSBIDimensions() throws Exception;

    public IPSBIDimension getPSBIDimension(String var1) throws Exception;

    public IPSBIDimension getPSBIDimension(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSBICube> getAllPSBICubes() throws Exception;

    public IPSBICube getPSBICube(String var1) throws Exception;

    public IPSBICube getPSBICube(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSBIAggTable> getAllPSBIAggTables() throws Exception;

    public IPSBIAggTable getPSBIAggTable(String var1) throws Exception;

    public IPSBIAggTable getPSBIAggTable(String var1, boolean var2) throws Exception;

    public Iterator<? extends IPSBIReport> getAllPSBIReports() throws Exception;

    public IPSBIReport getPSBIReport(String var1) throws Exception;

    public IPSBIReport getPSBIReport(String var1, boolean var2) throws Exception;

    public String getSchemeTag();

    public String getSchemeTag2();

    public String getUniqueTag();
}

