/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysDBSchemeSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSDBSCHEMESOURCE"})
public class PSDEDFSysDBSchemeSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFSysDBSchemeSourceNode {
    private String strSubType = "DBTABLE";
    private IPSSysDBScheme iPSSysDBScheme = null;
    private IPSSysDBTable iPSSysDBTable = null;
    private IPSDataEntity dstPSDataEntity = null;
    private IPSDEDataSet dstPSDEDataSet = null;
    private IPSDEDataQuery dstPSDEDataQuery = null;

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
        this.getDstPSDEDataSet();
        this.getDstPSDEDataQuery();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7c7b\u578b", hideempty=true, codelist="DEDataFlowSysDBSchemeSourceType", ignoredumpvalues="DBTABLE", fields={"LOGICNODESUBTYPE"})
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
        if (StringHelper.compare((String)this.getSubType(), (String)"DEDATASET", (boolean)false) == 0 || StringHelper.compare((String)this.getSubType(), (String)"DEDATAQUERY", (boolean)false) == 0) {
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
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataSet", fields={"DSTPSDEDATASETID"})
    public IPSDEDataSet getDstPSDEDataSet() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEDATASET", (boolean)false) == 0) {
            if (this.dstPSDEDataSet == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATASETID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u96c6\u6807\u8bc6");
                }
                this.dstPSDEDataSet = this.getDstPSDataEntity().getPSDEDataSet(this.psDELogicNode.getDSTPSDEDATASETID());
            }
            return this.dstPSDEDataSet;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, from="__self__", from_method="getDstPSDataEntityMust().getPSDEDataQuery", fields={"DSTPSDEDATAQUERYID"})
    public IPSDEDataQuery getDstPSDEDataQuery() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"DEDATAQUERY", (boolean)false) == 0) {
            if (this.dstPSDEDataQuery == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEDATAQUERYID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u5b9e\u4f53\u6570\u636e\u67e5\u8be2\u6807\u8bc6");
                }
                this.dstPSDEDataQuery = this.getDstPSDataEntity().getPSDEDataQuery(this.psDELogicNode.getDSTPSDEDATAQUERYID());
            }
            return this.dstPSDEDataQuery;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="SQL\u4ee3\u7801", fields={"PARAM4"})
    public String getSql() {
        if (StringHelper.compare((String)this.getSubType(), (String)"SQL", (boolean)false) == 0) {
            return this.psDELogicNode.getPARAM4();
        }
        return null;
    }
}

