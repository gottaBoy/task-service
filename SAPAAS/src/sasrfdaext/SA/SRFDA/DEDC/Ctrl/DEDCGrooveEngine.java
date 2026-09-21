/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.GroovyClassLoader
 *  groovy.lang.GroovyObject
 *  groovy.lang.Script
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;
import java.util.Hashtable;

public class DEDCGrooveEngine
extends Script {
    private static Hashtable<String, GroovyObject> scriptObjectMap = new Hashtable();

    public CallResult Eval(IDEDataCtrlEngineContext dedcContext, String strCode) {
        CallResult callResult = new CallResult();
        try {
            GroovyObject go = DEDCGrooveEngine.GetGroovyObject(this, strCode);
            if (go == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u811a\u672c\u5f15\u64ce\u5bf9\u8c61");
                return callResult;
            }
            Object[] arg = new Object[]{dedcContext};
            go.invokeMethod("Test", (Object)arg);
            return callResult;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult EvalWithReturn(IDEDataCtrlEngineContext dedcContext, String strCode) {
        CallResult callResult = new CallResult();
        try {
            GroovyObject go = DEDCGrooveEngine.GetGroovyObject(this, strCode);
            if (go == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo("\u65e0\u6cd5\u83b7\u53d6\u811a\u672c\u5f15\u64ce\u5bf9\u8c61");
                return callResult;
            }
            Object[] arg = new Object[]{dedcContext};
            Object obj = go.invokeMethod("Test", (Object)arg);
            callResult.setUserObject(obj);
            return callResult;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public Object run() {
        return null;
    }

    protected static GroovyObject GetGroovyObject(DEDCGrooveEngine helper, String strCode) {
        GroovyObject go = scriptObjectMap.get(strCode);
        if (go != null) {
            return go;
        }
        try {
            ClassLoader cl = ((Object)((Object)helper)).getClass().getClassLoader();
            GroovyClassLoader groovyCl = new GroovyClassLoader(cl);
            String strFullCode = StringHelper.Format((String)"class SRFTest {public String Test(ctx){%1$s}}", (Object)strCode);
            Class groovyClass = groovyCl.parseClass(strFullCode);
            GroovyObject groovyObject = (GroovyObject)groovyClass.newInstance();
            if (scriptObjectMap.size() > 2000) {
                scriptObjectMap.clear();
            }
            scriptObjectMap.put(strCode, groovyObject);
            return groovyObject;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

