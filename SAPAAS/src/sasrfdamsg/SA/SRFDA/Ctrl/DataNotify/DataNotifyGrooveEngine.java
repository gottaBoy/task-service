/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext
 *  SA.SRFramework.DataEx.CallResult
 *  groovy.lang.Binding
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DataNotify;

import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelperContext;
import SA.SRFramework.DataEx.CallResult;
import groovy.lang.Binding;
import groovy.lang.Script;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataNotifyGrooveEngine
extends Script {
    private static Log log = LogFactory.getLog(DataNotifyGrooveEngine.class);

    public CallResult EvalWithReturn(IDataNotifyHelperContext dataNotifyContext, String strCode) {
        CallResult callResult = new CallResult();
        try {
            Binding binding = new Binding();
            binding.setVariable("ctx", (Object)dataNotifyContext);
            if (dataNotifyContext.getDataEntity() != null) {
                binding.setVariable("New", (Object)dataNotifyContext.getDataEntity());
            }
            if (dataNotifyContext.getLastDataEntity() != null) {
                binding.setVariable("Old", (Object)dataNotifyContext.getLastDataEntity());
            } else {
                binding.setVariable("Old", null);
            }
            this.setBinding(binding);
            Object objRet = this.evaluate(strCode);
            callResult.setUserObject(objRet);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    public Object run() {
        return null;
    }
}

