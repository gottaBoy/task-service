/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDESysDBTableActionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDESysDBTableActionLogicImpl
extends PSDELogicNodeImpl
implements IPSDESysDBTableActionLogic {
    private IPSSysDBScheme iPSSysDBScheme = null;
    private IPSSysDBTable iPSSysDBTable = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysDBScheme();
        this.getPSSysDBTable();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDBSCHEMEID"})
    public IPSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.iPSSysDBScheme == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDBSCHEMEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u5e93\u4f53\u7cfb");
            }
            this.iPSSysDBScheme = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysDBScheme(this.psDELogicNode.getPSSYSDBSCHEMEID());
        }
        return this.iPSSysDBScheme;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868", hideempty=true, dumpref=true, ignorepf=true, from="IPSSysDBScheme", fields={"PSSYSDBTABLEID"})
    public IPSSysDBTable getPSSysDBTable() throws Exception {
        if (this.iPSSysDBTable == null) {
            if (StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDBTABLEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u6570\u636e\u8868");
            }
            this.iPSSysDBTable = this.getPSSysDBScheme().getPSSysDBTable(this.psDELogicNode.getPSSYSDBTABLEID(), false);
        }
        return this.iPSSysDBTable;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u64cd\u4f5c", codelist="SysDBTableAction", fields={"PARAM1"})
    public String getDBTableAction() {
        return this.psDELogicNode.getPARAM1();
    }
}

