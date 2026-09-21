/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEThrowExceptionLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEThrowExceptionLogicImpl
extends PSDELogicNodeImpl
implements IPSDEThrowExceptionLogic {
    private String strErrorInfo = null;
    private String strExceptionObj = null;
    private int nErrorCode = 0;

    @Override
    protected void onInit() throws Exception {
        this.strErrorInfo = this.psDELogicNode.getPARAM3();
        this.strExceptionObj = this.psDELogicNode.getPARAM11();
        if (!this.psDELogicNode.isPARAM8Null()) {
            this.nErrorCode = this.psDELogicNode.getPARAM8();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u4fe1\u606f", fields={"PARAM3"})
    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u5bf9\u8c61", fields={"PARAM11"})
    public String getExceptionObj() {
        return this.strExceptionObj;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u4ee3\u7801", fields={"PARAM8"})
    public int getErrorCode() {
        return this.nErrorCode;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u5e38\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getExceptionParam() throws Exception {
        return this.getDstPSDELogicParam();
    }
}

