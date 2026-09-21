/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFSysBDSchemeSourceNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowSourceNodeImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFSYSBDSCHEMESOURCE"})
public class PSDEDFSysBDSchemeSourceNodeImpl
extends PSDEDataFlowSourceNodeImpl
implements IPSDEDFSysBDSchemeSourceNode {
    private String strSubType = "BDTABLE";
    private IPSSysBDScheme iPSSysBDScheme = null;
    private IPSSysBDTable iPSSysBDTable = null;
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
        this.getPSSysBDScheme();
        this.getPSSysBDTable();
        this.getDstPSDataEntity();
        this.getDstPSDEDataSet();
        this.getDstPSDEDataQuery();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7c7b\u578b", hideempty=true, codelist="DEDataFlowSysBDSchemeSourceType", ignoredumpvalues="BDTABLE", fields={"LOGICNODESUBTYPE"})
    public String getSubType() {
        return this.strSubType;
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u5e93\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSBDSCHEMEID"})
    public IPSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.iPSSysBDScheme == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSBDSCHEMEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5927\u6570\u636e\u5e93\u4f53\u7cfb");
            }
            this.iPSSysBDScheme = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysBDScheme(this.psDELogicNode.getPSSYSBDSCHEMEID());
        }
        return this.iPSSysBDScheme;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysBDScheme", fields={"PSSYSBDTABLEID"})
    public IPSSysBDTable getPSSysBDTable() throws Exception {
        if (StringHelper.compare((String)this.getSubType(), (String)"BDTABLE", (boolean)false) == 0) {
            if (this.iPSSysBDTable == null) {
                if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSBDTABLEID())) {
                    throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u8868");
                }
                this.iPSSysBDTable = this.getPSSysBDScheme().getPSSysBDTable(this.psDELogicNode.getPSSYSBDTABLEID(), false);
            }
            return this.iPSSysBDTable;
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
}

