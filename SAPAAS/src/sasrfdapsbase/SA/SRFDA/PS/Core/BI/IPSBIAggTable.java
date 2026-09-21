/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.BI;

import SA.SRFDA.PS.Core.BI.IPSBIAggColumn;
import SA.SRFDA.PS.Core.BI.IPSBICube;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import java.util.Iterator;

@PSModelPFIgnoreMeta
public interface IPSBIAggTable
extends IPSModelObject {
    public IPSDataEntity getPSDataEntity();

    @Override
    public String getCodeName();

    public IPSBICube getPSBICube();

    public Iterator<? extends IPSBIAggColumn> getAllPSBIAggColumns() throws Exception;

    public IPSBIAggColumn getPSBIAggColumn(String var1) throws Exception;

    public IPSBIAggColumn getPSBIAggColumn(String var1, boolean var2) throws Exception;

    public String getTableTag();

    public String getTableTag2();

    public IPSDEDataQuery getPSDEDataQuery();
}

