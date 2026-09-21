/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDERawSqlAndLoopCallLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERawSqlAndLoopCallLogicImpl
extends PSDELogicNodeImpl
implements IPSDERawSqlAndLoopCallLogic {
    private IPSSysDBScheme iPSSysDBScheme = null;

    @Override
    protected int onCheck() throws Exception {
        this.getPSSysDBScheme();
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u4f53\u7cfb", hideempty=true, dumpref=true, ignorepf=true, fields={"PSSYSDBSCHEMEID"})
    public IPSSysDBScheme getPSSysDBScheme() throws Exception {
        if (this.iPSSysDBScheme == null && !StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSDBSCHEMEID())) {
            this.iPSSysDBScheme = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysDBScheme(this.psDELogicNode.getPSSYSDBSCHEMEID());
        }
        return this.iPSSysDBScheme;
    }

    @Override
    @PSModelRTMeta(description="SQL\u4ee3\u7801", fields={"PARAM4"})
    public String getSql() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEID"})
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return super.getDstPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"DSTPSDEACTIONID"})
    public IPSDEAction getDstPSDEAction() throws Exception {
        return super.getDstPSDEAction();
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u6e90\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"SRCPSDLPARAMID"})
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return super.getSrcPSDELogicParam();
    }
}

