/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BA.IPSSysBDTable;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysBDTableActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESysBDTableActionLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysBDTableActionLogic {
    private IPSSysBDScheme iPSSysBDScheme = null;
    private IPSSysBDTable iPSSysBDTable = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysBDScheme();
        this.getPSSysBDTable();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u5927\u6570\u636e\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSBDSCHEMEID"})
    public IPSSysBDScheme getPSSysBDScheme() throws Exception {
        if (this.iPSSysBDScheme == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSBDSCHEMEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5927\u6570\u636e\u4f53\u7cfb");
            }
            this.iPSSysBDScheme = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysBDScheme(this.psDELogicNode.getPSSYSBDSCHEMEID());
        }
        return this.iPSSysBDScheme;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysBDScheme", fields={"PSSYSBDTABLEID"})
    public IPSSysBDTable getPSSysBDTable() throws Exception {
        if (this.iPSSysBDTable == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSBDTABLEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u8868");
            }
            this.iPSSysBDTable = this.getPSSysBDScheme().getPSSysBDTable(this.psDELogicNode.getPSSYSBDTABLEID(), false);
        }
        return this.iPSSysBDTable;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u64cd\u4f5c", codelist="SysDBTableAction", fields={"PARAM1"})
    public String getBDTableAction() {
        return this.psDELogicNode.getPARAM1();
    }
}

