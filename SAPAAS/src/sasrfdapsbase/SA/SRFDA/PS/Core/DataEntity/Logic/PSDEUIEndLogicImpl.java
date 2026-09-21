/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUIEndLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

public class PSDEUIEndLogicImpl
extends PSDEUILogicNodeImpl
implements IPSDEUIEndLogic {
    private int nRawValueStdDataType = 0;

    @Override
    protected void onInit() throws Exception {
        if (StringHelper.compare((String)this.getReturnType(), (String)"SRCVALUE", (boolean)false) == 0 && !this.psDELogicNode.isPARAM7Null()) {
            this.nRawValueStdDataType = this.psDELogicNode.getPARAM7();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u53c2\u6570", hideempty=true, dumpref=true, from="IPSDEUILogic", fields={"DSTPSDLPARAMID"})
    public IPSDEUILogicParam getReturnParam() throws Exception {
        return super.getDstPSDEUILogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u503c\u7c7b\u578b", codelist="DELogicReturnType", fields={"PARAM1"})
    public String getReturnType() {
        return this.psDELogicNode.getPARAM1();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u76f4\u63a5\u503c", hideempty2=true, fields={"PARAM4"})
    public String getRawValue() {
        return this.psDELogicNode.getPARAM4();
    }

    @Override
    @PSModelRTMeta(description="\u8fd4\u56de\u53c2\u6570\u5c5e\u6027", hideempty2=true, fields={"PARAM2"})
    public String getDstFieldName() throws Exception {
        return this.psDELogicNode.getPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u503c\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", ignoredumpvalues="0", fields={"PARAM7"})
    public int getRawValueStdDataType() {
        return this.nRawValueStdDataType;
    }
}

