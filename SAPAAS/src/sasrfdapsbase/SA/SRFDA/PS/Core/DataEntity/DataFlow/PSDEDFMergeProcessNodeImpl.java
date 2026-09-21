/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDFMergeProcessNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowProcessNodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
@PSModelImplementMeta(implement="IPSDEDataFlowNode", typevalues={"DFMERGEPROCESS"})
public class PSDEDFMergeProcessNodeImpl
extends PSDEDataFlowProcessNodeImpl
implements IPSDEDFMergeProcessNode {
    private static final Log log = LogFactory.getLog(PSDEDFMergeProcessNodeImpl.class);
    private String strMergeType = null;
    private boolean bCopyIfNotExists = false;
    private boolean bMergeIntoField = false;
    private String strDataStreamMergeField = null;
    private String strDataStream2MergeField = null;

    @Override
    protected void onInit() throws Exception {
        this.strMergeType = this.psDELogicNode.getPARAM1();
        if (!this.psDELogicNode.isPARAM10Null()) {
            this.bMergeIntoField = this.psDELogicNode.getPARAM10();
        }
        if (this.isMergeIntoField()) {
            this.strDataStreamMergeField = this.psDELogicNode.getPARAM2();
            this.strDataStream2MergeField = this.psDELogicNode.getPARAM3();
        } else if (!this.psDELogicNode.isPARAM9Null()) {
            this.bCopyIfNotExists = this.psDELogicNode.getPARAM9();
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        int nRet = 0;
        return nRet + super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u62f7\u8d1d\u4e0d\u5b58\u5728\u5c5e\u6027", ignoredumpvalues="false", fields={"PARAM9"})
    public boolean isCopyIfNotExists() {
        return this.bCopyIfNotExists;
    }

    @Override
    @PSModelRTMeta(description="\u5408\u5e76\u5230\u6307\u5b9a\u5c5e\u6027", ignoredumpvalues="false", fields={"PARAM10"})
    public boolean isMergeIntoField() {
        return this.bMergeIntoField;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6e90\u5408\u5e76\u5c5e\u6027", fields={"PARAM2"})
    public String getMergeField() {
        return this.strDataStreamMergeField;
    }

    @Override
    @PSModelRTMeta(description="\u5408\u5e76\u6a21\u5f0f", codelist="DEDataFlowMergeType", fields={"PARAM1"})
    public String getMergeType() {
        return this.strMergeType;
    }
}

