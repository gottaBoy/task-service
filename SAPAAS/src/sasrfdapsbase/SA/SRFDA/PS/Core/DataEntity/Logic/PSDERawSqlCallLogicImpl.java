/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDERawSqlCallLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelPFIgnoreMeta
public class PSDERawSqlCallLogicImpl
extends PSDELogicNodeImpl
implements IPSDERawSqlCallLogic {
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
    @PSModelRTMeta(description="\u6267\u884c\u7ed3\u679c\u586b\u5145\u76ee\u6807\u53c2\u6570", ignoredumpvalues="false", fields={"PARAM9"})
    public boolean isFillDstLogicParam() {
        return this.psDELogicNode.GetParamIntValue("PARAM9", 0) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u91cd\u7f6e\u76ee\u6807\u53c2\u6570", ignoredumpvalues="true", fields={"PARAM7"})
    public boolean isIgnoreResetDstLogicParam() {
        return this.psDELogicNode.GetParamIntValue("PARAM7", 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }
}

