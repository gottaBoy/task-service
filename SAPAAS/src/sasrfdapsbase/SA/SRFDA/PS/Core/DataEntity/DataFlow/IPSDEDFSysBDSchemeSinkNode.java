/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysBDSchemeSinkNode
extends IPSDEDataFlowSinkNode {
    public static final String SUBTYPE_BDTABLE = "BDTABLE";
    public static final String SUBTYPE_DEFGROUP = "DEFGROUP";

    public String getSubType();

    public IPSSysBDScheme getPSSysBDScheme() throws Exception;

    public IPSSysBDTable getPSSysBDTable() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEFGroup getDstPSDEFGroup() throws Exception;

    public String getTableAction();
}

