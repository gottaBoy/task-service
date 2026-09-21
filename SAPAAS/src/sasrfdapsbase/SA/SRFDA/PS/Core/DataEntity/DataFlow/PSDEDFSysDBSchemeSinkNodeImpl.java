/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysDBSchemeSinkNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSinkNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSDBSCHEMESINK"})
public class PSDEDFSysDBSchemeSinkNodeImpl
extends PSDEDataFlowSinkNodeImpl
implements IPSDEDFSysDBSchemeSinkNode {
    private String strSubType = "DBTABLE";
    private IPSSysDBScheme iPSSysDBScheme = null;
    private IPSSysDBTable iPSSysDBTable = null;
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEFGroup dstPSDEFGroup = null;

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getLOGICNODESUBTYPE())) {
            this.strSubType = this.psDELogicNode.getLOGICNODESUBTYPE();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysDBScheme();
        this.getPSSysDBTable();
        this.getDstPSDataEntity();
        this.getDstPSDEFGroup();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7c7b\u578b", hideempty=true, codelist="DEDataFlowSysDBSchemeSinkType", ignoredumpvalues="DBTABLE", fields={"LOGICNODESUBTYPE"})
    public String getSubType() {
        return this.strSubType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDBSCHEMEID"})
    public IPSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.iPSSysDBScheme == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDBSCHEMEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u5e93\u4f53\u7cfb");
            }
            this.iPSSysDBScheme = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysDBScheme(this.psDELogicNode.getPSSYSDBSCHEMEID());
        }
        return this.iPSSysDBScheme;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysDBScheme", fields={"PSSYSDBTABLEID"})
    public IPSSysDBTable getPSSysDBTable() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DBTABLE", (boolean)false) == 0) {
            if (this.iPSSysDBTable == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDBTABLEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u8868");
                }
                this.iPSSysDBTable = this.getPSSysDBScheme().getPSSysDBTable(this.psDELogicNode.getPSSYSDBTABLEID(), false);
            }
            return this.iPSSysDBTable;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEFGROUP", (boolean)false) == 0) {
            if (this.dstPSDataEntity == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6807\u8bc6");
                }
                this.dstPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psDELogicNode.getDSTPSDEID());
            }
            return this.dstPSDataEntity;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEFGroup", fields={"DSTPSDEFGROUPID"})
    public IPSDEFGroup getDstPSDEFGroup() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEFGROUP", (boolean)false) == 0) {
            if (this.dstPSDEFGroup == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEFGROUPID())) {
                    return null;
                }
                this.dstPSDEFGroup = this.getDstPSDataEntity().getPSDEFGroup(this.psDELogicNode.getDSTPSDEFGROUPID());
            }
            return this.dstPSDEFGroup;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u64cd\u4f5c", codelist="SysDBTableAction", fields={"PARAM1"})
    public String getTableAction() {
        return this.psDELogicNode.getPARAM1();
    }
}

