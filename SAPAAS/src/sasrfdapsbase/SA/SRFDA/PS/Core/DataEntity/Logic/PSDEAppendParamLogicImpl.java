/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEAppendParamLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public class PSDEAppendParamLogicImpl
extends PSDELogicNodeImpl
implements IPSDEAppendParamLogic {
    private int nSrcIndex = -1;
    private int nSrcSize = -1;
    private int nDstIndex = -1;

    @Override
    protected void onInit() throws Exception {
        if (!this.psDELogicNode.isSRCINDEXNull()) {
            this.nSrcIndex = this.psDELogicNode.getSRCINDEX();
        }
        if (!this.psDELogicNode.isSRCSIZENull()) {
            this.nSrcSize = this.psDELogicNode.getSRCSIZE();
        }
        if (!this.psDELogicNode.isDSTINDEXNull()) {
            this.nDstIndex = this.psDELogicNode.getDSTINDEX();
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"DSTPSDLPARAMID"})
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return super.getDstPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDELogic", fields={"SRCPSDLPARAMID"})
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return super.getSrcPSDELogicParam();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5c5e\u6027\u540d\u79f0", hideempty2=true, fields={"CUSTOMSRCPARAM"})
    public String getSrcFieldName() throws Exception {
        return this.psDELogicNode.getCUSTOMSRCPARAM();
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5217\u8868\u53c2\u6570\u8d77\u59cb\u4f4d\u7f6e", ignoredumpvalues="-1", fields={"SRCINDEX"})
    public int getSrcIndex() {
        return this.nSrcIndex;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u5217\u8868\u53c2\u6570\u5927\u5c0f", ignoredumpvalues="-1", fields={"SRCSIZE"})
    public int getSrcSize() {
        return this.nSrcSize;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u5217\u8868\u53c2\u6570\u8d77\u59cb\u4f4d\u7f6e", ignoredumpvalues="-1", fields={"DSTINDEX"})
    public int getDstIndex() {
        return this.nDstIndex;
    }
}

