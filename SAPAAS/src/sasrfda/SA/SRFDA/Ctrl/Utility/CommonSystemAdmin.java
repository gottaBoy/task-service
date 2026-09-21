/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.FileHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.IDASystemAdmin;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.FileHelper;
import SA.SRFramework.Utility.StringHelper;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonSystemAdmin
implements IDASystemAdmin {
    private static final Log log = LogFactory.getLog(CommonSystemAdmin.class);
    public static final String FUNC_RESETREGISTRY = "RESETREGISTRY";
    public static final String FUNC_RESETCODELIST = "RESETCODELIST";
    public static final String FUNC_RESETLOCALIZATION = "RESETLOCALIZATION";
    public static final String FUNC_RESETRUNTIME = "RESETRUNTIME";
    public static final String FUNC_RESETTEMPFOLDER = "RESETTEMPFOLDER";
    public static final String FUNC_RESETREXPIREDPROC = "RESETREXPIREDPROC";
    protected static TreeMap<String, Boolean> funcMap = new TreeMap();
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;

    static {
        funcMap.put(FUNC_RESETREGISTRY, false);
        funcMap.put(FUNC_RESETCODELIST, false);
        funcMap.put(FUNC_RESETLOCALIZATION, false);
        funcMap.put(FUNC_RESETRUNTIME, false);
        funcMap.put(FUNC_RESETTEMPFOLDER, false);
        funcMap.put(FUNC_RESETREXPIREDPROC, false);
    }

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    @Override
    public boolean isContainsFunc(String strFunc) {
        return funcMap.containsKey(strFunc.toUpperCase());
    }

    @Override
    public CallResult CallFunc(String strFunc, String strParam) {
        CallResult callResult = new CallResult();
        if (StringHelper.Compare((String)FUNC_RESETREGISTRY, (String)strFunc, (boolean)true) == 0) {
            this.iDAGlobalHelper.getRegisterMgr().Reset();
            callResult.setUserObject((Object)"\u7cfb\u7edf\u914d\u7f6e\u91cd\u7f6e\u6210\u529f\uff01");
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETCODELIST, (String)strFunc, (boolean)true) == 0) {
            this.iDAGlobalHelper.getCodeListMgr().ResetAllCodeList();
            callResult.setUserObject((Object)"\u7cfb\u7edf\u4ee3\u7801\u8868\u91cd\u7f6e\u6210\u529f\uff01");
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETLOCALIZATION, (String)strFunc, (boolean)true) == 0) {
            this.iDAGlobalHelper.getLocalizationHelper().Reload();
            callResult.setUserObject((Object)"\u7cfb\u7edf\u672c\u5730\u8bed\u8a00\u5b9a\u4e49\u91cd\u65b0\u52a0\u8f7d\u6210\u529f\uff01");
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETTEMPFOLDER, (String)strFunc, (boolean)true) == 0) {
            try {
                FileHelper.RemoveFolder((String)this.iDAGlobalHelper.GetTempPath(), (boolean)true);
                callResult.setUserObject((Object)"\u6e05\u9664\u4e34\u65f6\u6587\u4ef6\u5939\u5185\u5bb9\u6210\u529f\uff01");
            }
            catch (IOException e) {
                log.error((Object)e);
                e.printStackTrace();
                callResult.setUserObject((Object)StringHelper.Format((String)"\u6e05\u9664\u4e34\u65f6\u6587\u4ef6\u5939\u5185\u5bb9\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETRUNTIME, (String)strFunc, (boolean)true) == 0) {
            try {
                String strPath = String.valueOf(this.iDAGlobalHelper.GetAppRootPath()) + "configex_runtime";
                FileHelper.RemoveFolder((String)strPath, (boolean)true);
                callResult.setUserObject((Object)"\u6e05\u9664\u52a8\u6001\u8fd0\u884c\u6587\u4ef6\u5939\u5185\u5bb9\u6210\u529f\uff01");
            }
            catch (IOException e) {
                log.error((Object)e);
                e.printStackTrace();
                callResult.setUserObject((Object)StringHelper.Format((String)"\u6e05\u9664\u52a8\u6001\u8fd0\u884c\u6587\u4ef6\u5939\u5185\u5bb9\u5931\u8d25\uff0c%1$s", (Object)e.getMessage()));
                callResult.setRetCode(1);
            }
            return callResult;
        }
        if (StringHelper.Compare((String)FUNC_RESETREXPIREDPROC, (String)strFunc, (boolean)true) == 0) {
            Vector<DataEntity> list = new Vector<DataEntity>();
            callResult = this.iDAGlobalHelper.getDAModelHelper().GetDataEntities("SRFDA", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6846\u67b6\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult = this.iDAGlobalHelper.getDAModelHelper().GetDataEntities("APPLICATION", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            callResult = this.iDAGlobalHelper.getDAModelHelper().GetDataEntities("USER", list);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u7528\u6237\u5b9e\u4f53\u5217\u8868\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            boolean bError = false;
            for (DataEntity dataEntity : list) {
                IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(dataEntity.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)dataEntity.getDEID()));
                    continue;
                }
                callResult = iDEHelper.RemoveExpiredProc();
                if (callResult.IsError()) {
                    bError = true;
                    log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6e05\u9664\u8fc7\u671f\u8fc7\u7a0b\u5931\u8d25\uff0c%2$s", (Object)dataEntity.getDEID(), (Object)callResult.getErrorInfo()));
                    continue;
                }
                log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6e05\u9664\u8fc7\u671f\u8fc7\u7a0b\u6210\u529f", (Object)dataEntity.getDEID()));
            }
            if (bError) {
                callResult.setUserObject((Object)"\u6e05\u9664\u8fc7\u671f\u8fc7\u7a0b\u5b8c\u6210\uff0c\u4e2d\u95f4\u51fa\u73b0\u4e86\u9519\u8bef\uff01");
            } else {
                callResult.setUserObject((Object)"\u6e05\u9664\u8fc7\u671f\u8fc7\u7a0b\u6210\u529f\uff01");
            }
            return callResult;
        }
        return callResult;
    }

    @Override
    public CallResult GetFuncScript(String strFunc) {
        return null;
    }

    @Override
    public boolean isFuncScript(String strFunc) {
        if (funcMap.containsKey(strFunc = strFunc.toUpperCase())) {
            return funcMap.get(strFunc);
        }
        return false;
    }
}

