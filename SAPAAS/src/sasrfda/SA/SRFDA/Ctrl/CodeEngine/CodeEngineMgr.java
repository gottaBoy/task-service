/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CommonEx.LogLevels
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.CodeEngine;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngine;
import SA.SRFDA.Ctrl.Data.DevCodeEngine;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.LogLevels;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CodeEngineMgr {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected Writer logWriter = null;
    protected String strLanguage = "JAVA";
    private TreeMap<String, IDACodeEngine> codeEngineMap = new TreeMap();
    private IDEDataCtrl devCodeEngineDataCtrl = null;
    private static final Log log = LogFactory.getLog(CodeEngineMgr.class);

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, String strLanguage, Writer logWriter) {
        CallResult callResult = new CallResult();
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.logWriter = logWriter;
        this.strLanguage = strLanguage;
        if (StringHelper.IsNullOrEmpty((String)this.strLanguage)) {
            this.strLanguage = "JAVA";
        }
        this.devCodeEngineDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0253", "SYSTEM", null);
        if (this.devCodeEngineDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0253"));
            return callResult;
        }
        callResult.Reset();
        return callResult;
    }

    public CallResult GenCode(String strCodeType, String[] objectIds) {
        CallResult callResult = new CallResult();
        if (objectIds.length == 0) {
            return callResult;
        }
        IDACodeEngine iCodeEngine = this.GetCodeEngine(strCodeType, this.strLanguage);
        if (iCodeEngine == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801[%1$s]\u751f\u6210\u5f15\u64ce", (Object)strCodeType));
            return callResult;
        }
        IDEHelper iDEHelper = this.iDAGlobalHelper.getDAModelStorage().FindDEHelper(iCodeEngine.getDevCodeEngine().getDEID());
        if (iDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iCodeEngine.getDevCodeEngine().getDEID()));
            return callResult;
        }
        IDEDataCtrl iDataCtrl = iDEHelper.GetDEDataCtrl("SYSTEM", null);
        if (iDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iCodeEngine.getDevCodeEngine().getDEID()));
            return callResult;
        }
        Vector<BaseDataEntity> dataEntities = new Vector<BaseDataEntity>();
        int i = 0;
        while (i < objectIds.length) {
            Object objValue = iDEHelper.GetKeyDEFHelper().GetDEFValue(objectIds[i]);
            if (objValue == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u8f6c\u6362\u4e3b\u952e\u503c[%1$s]\u5931\u8d25", (Object)objectIds[i]));
                return callResult;
            }
            BaseDataEntity dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), objValue);
            callResult = iDataCtrl.Get(dataEntity);
            if (callResult.IsError()) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u5931\u8d25\uff0c%3$s", (Object)iCodeEngine.getDevCodeEngine().getDEID(), (Object)objValue, (Object)callResult.getErrorInfo()));
                return callResult;
            }
            dataEntities.add(dataEntity);
            ++i;
        }
        return this.GenCode(strCodeType, dataEntities);
    }

    public CallResult GenCode(String strCodeType, Vector<BaseDataEntity> dataEntities) {
        CallResult callResult = new CallResult();
        this.Log(0, StringHelper.Format((String)"\u4ee3\u7801\u5f15\u64ce\u5f00\u59cb\u53d1\u5e03\u4ee3\u7801"));
        if (dataEntities.size() == 0) {
            this.Log(0, StringHelper.Format((String)"\u4ee3\u7801\u5f15\u64ce\u7ed3\u675f\u53d1\u5e03\u4ee3\u7801"));
            return callResult;
        }
        IDACodeEngine iCodeEngine = this.GetCodeEngine(strCodeType, this.strLanguage);
        if (iCodeEngine == null) {
            this.Log(1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801[%1$s]\u751f\u6210\u5f15\u64ce", (Object)strCodeType));
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801[%1$s]\u751f\u6210\u5f15\u64ce", (Object)strCodeType));
            return callResult;
        }
        for (BaseDataEntity dataEntity : dataEntities) {
            callResult = iCodeEngine.GenCode(null, dataEntity);
            if (!callResult.IsError()) continue;
            this.Log(1, StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        this.Log(0, StringHelper.Format((String)"\u4ee3\u7801\u5f15\u64ce\u7ed3\u675f\u53d1\u5e03\u4ee3\u7801"));
        return callResult;
    }

    private IDACodeEngine GetCodeEngine(String strCodeType, String strLanguage) {
        String strEngineId = StringHelper.Format((String)"CODEENGINE_%1$s_%2$s", (Object)strCodeType, (Object)strLanguage);
        if (this.codeEngineMap.containsKey(strEngineId = strEngineId.toUpperCase())) {
            return this.codeEngineMap.get(strEngineId);
        }
        DevCodeEngine devCodeEngine = new DevCodeEngine();
        devCodeEngine.setDEVCODEENGINEID(strEngineId);
        CallResult callResult = this.devCodeEngineDataCtrl.Get(devCodeEngine);
        if (callResult.IsError()) {
            this.Log(1, StringHelper.Format((String)"\u83b7\u53d6\u4ee3\u7801\u5f15\u64ce[%1$s]\u6570\u636e\u5931\u8d25\uff0c%2$s", (Object)strEngineId, (Object)callResult.getErrorInfo()));
            return null;
        }
        String strObject = devCodeEngine.getCODEENGINEOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u5f15\u64ce[%1$s]\u6ca1\u6709\u6307\u5b9a\u5f15\u64ce\u5bf9\u8c61", (Object)strEngineId));
            return null;
        }
        Object objEngine = ObjectHelper.Create((String)strObject);
        if (objEngine == null) {
            this.Log(1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u4ee3\u7801\u5f15\u64ce[%1$s]\u5bf9\u8c61[%2$s]", (Object)strEngineId, (Object)strObject));
            return null;
        }
        if (!(objEngine instanceof IDACodeEngine)) {
            this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u5f15\u64ce[%1$s]\u5bf9\u8c61[%2$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strEngineId, (Object)strObject));
            return null;
        }
        IDACodeEngine iDACodeEngine = (IDACodeEngine)objEngine;
        iDACodeEngine.Init(this.iDAGlobalHelper, devCodeEngine, this.logWriter);
        this.codeEngineMap.put(strEngineId, iDACodeEngine);
        return iDACodeEngine;
    }

    protected void Log(int nLogLevel, String strLogInfo) {
        switch (nLogLevel) {
            case 0: {
                log.info((Object)strLogInfo);
                break;
            }
            case 1: {
                log.error((Object)strLogInfo);
                break;
            }
            case 5: {
                log.debug((Object)strLogInfo);
                break;
            }
            case 4: {
                log.warn((Object)strLogInfo);
                break;
            }
            case 2: {
                log.fatal((Object)strLogInfo);
            }
        }
        if (this.logWriter != null) {
            String strInfo = StringHelper.Format((String)"[%3$s]\t[%1$s] %2$s\r\n", (Object)DateParser.toDateTimeString((Date)new Date()), (Object)strLogInfo, (Object)LogLevels.ToString((int)nLogLevel));
            try {
                this.logWriter.write(strInfo);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

