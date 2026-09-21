/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowSinkNode;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;

@PSModelPFIgnoreMeta
public interface IPSDEDFSysDBSchemeSinkNode
extends IPSDEDataFlowSinkNode {
    public static final String SUBTYPE_DBTABLE = "DBTABLE";
    public static final String SUBTYPE_DEFGROUP = "DEFGROUP";

    public String getSubType();

    public IPSSysDBScheme getPSSysDBScheme() throws Exception;

    public IPSSysDBTable getPSSysDBTable() throws Exception;

    public IPSDataEntity getDstPSDataEntity() throws Exception;

    public IPSDEFGroup getDstPSDEFGroup() throws Exception;

    public String getTableAction();
}

