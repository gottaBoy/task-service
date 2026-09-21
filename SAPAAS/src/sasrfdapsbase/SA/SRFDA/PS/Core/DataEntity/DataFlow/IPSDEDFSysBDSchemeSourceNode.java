/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSourceNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysBDSchemeSourceNode
extends IPSDEDataFlowSourceNode {
    public static final String SUBTYPE_BDTABLE = "BDTABLE";
    public static final String SUBTYPE_DEDATASET = "DEDATASET";
    public static final String SUBTYPE_DEDATAQUERY = "DEDATAQUERY";
    public static final String SUBTYPE_SQL = "SQL";

    public String getSubType();

    public IPSSysBDScheme getPSSysBDScheme() throws Exception;

    public IPSSysBDTable getPSSysBDTable() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEDataSet getDstPSDEDataSet() throws Exception;

    public IPSDEDataQuery getDstPSDEDataQuery() throws Exception;
}

