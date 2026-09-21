/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.EAI.Ctrl.Form;

import SA.SRFDA.Ctrl.Form.BaseDAFormActionHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class EAIAppIntFormActionHelper
extends BaseDAFormActionHelper {
    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterInsert(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteEAIAppIntAction(dataEntity);
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        if ((callResult = super.OnSaveActionAfterUpdate(callResult, dataEntity)).getRetCode() != 0) {
            return callResult;
        }
        return this.ExecuteEAIAppIntAction(dataEntity);
    }

    protected CallResult ExecuteEAIAppIntAction(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strEaiAppIntAction = this.getWebContext().GetPostValue("srfeaiappint");
        if (StringHelper.IsNullOrEmpty((String)strEaiAppIntAction)) {
            return callResult;
        }
        if (StringHelper.Compare((String)strEaiAppIntAction, (String)"COMPILE", (boolean)true) == 0) {
            return this.Complie(dataEntity);
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo("\u65e0\u6cd5\u8bc6\u522b\u7684\u96c6\u6210\u63a5\u53e3\u64cd\u4f5c\u6307\u4ee4");
        return callResult;
    }

    /*
     * Exception decompiling
     */
    protected CallResult Complie(BaseDataEntity dataEntity) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 10[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

