/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDASystemAdmin
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.IS.Ctrl;

import SA.SRFDA.Ctrl.IDASystemAdmin;
import SA.SRFDA.IS.Ctrl.DefaultIndexGroupEraseHelper;
import SA.SRFDA.IS.Ctrl.DefaultIndexGroupHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.TreeMap;

public class ISSystemAdmin
implements IDASystemAdmin {
    public static final String FUNC_INDEXALL = "INDEXALL";
    public static final String FUNC_INDEXFROMLAST = "INDEXFROMLAST";
    public static final String FUNC_ERASEINDEX = "ERASEINDEX";
    protected static TreeMap<String, Boolean> funcMap = new TreeMap();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    static {
        funcMap.put(FUNC_INDEXALL, false);
        funcMap.put(FUNC_INDEXFROMLAST, false);
        funcMap.put(FUNC_ERASEINDEX, false);
    }

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    public boolean isContainsFunc(String strFunc) {
        return funcMap.containsKey(strFunc.toUpperCase());
    }

    public CallResult CallFunc(String strFunc, String strParam) {
        CallResult callResult = new CallResult();
        if (StringHelper.Compare((String)FUNC_INDEXALL, (String)strFunc, (boolean)true) == 0) {
            DefaultIndexGroupHelper indexGroupHelper = new DefaultIndexGroupHelper();
            callResult = indexGroupHelper.Index(this.iDAGlobalHelper, strParam, true, null);
            if (callResult.getRetCode() == 0) {
                callResult.setUserObject((Object)"\u6570\u636e\u7d22\u5f15(\u91cd\u5efa)\u6210\u529f\uff01");
            }
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_INDEXFROMLAST, (String)strFunc, (boolean)true) == 0) {
            DefaultIndexGroupHelper indexGroupHelper = new DefaultIndexGroupHelper();
            callResult = indexGroupHelper.Index(this.iDAGlobalHelper, strParam, false, null);
            if (callResult.getRetCode() == 0) {
                callResult.setUserObject((Object)"\u6570\u636e\u7d22\u5f15(\u4ece\u4e0a\u6b21\u7d22\u5f15)\u6210\u529f\uff01");
            }
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_ERASEINDEX, (String)strFunc, (boolean)true) == 0) {
            DefaultIndexGroupEraseHelper indexGroupEraseHelper = new DefaultIndexGroupEraseHelper();
            callResult = indexGroupEraseHelper.Erase(this.iDAGlobalHelper, strParam);
            if (callResult.getRetCode() == 0) {
                callResult.setUserObject((Object)"\u6570\u636e\u7d22\u5f15(\u6e05\u9664)\u6210\u529f\uff01");
            }
            return callResult;
        }
        return callResult;
    }

    public CallResult GetFuncScript(String strFunc) {
        return null;
    }

    public boolean isFuncScript(String strFunc) {
        if (funcMap.containsKey(strFunc = strFunc.toUpperCase())) {
            return funcMap.get(strFunc);
        }
        return false;
    }
}

