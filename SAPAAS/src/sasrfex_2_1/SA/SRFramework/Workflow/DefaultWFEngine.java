/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.Workflow;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.Workflow.DefaultWFEngineContext;
import SA.SRFramework.Workflow.IWFDecision;
import SA.SRFramework.Workflow.IWFEngine;
import SA.SRFramework.Workflow.IWFEngineContext;
import SA.SRFramework.Workflow.IWFProcess;
import SA.SRFramework.Workflow.WFConfig;
import SA.SRFramework.Workflow.WFConfigMgr;
import SA.SRFramework.Workflow.WFConnectionConfig;
import SA.SRFramework.Workflow.WFDecisionConfig;
import SA.SRFramework.Workflow.WFEndConfig;
import SA.SRFramework.Workflow.WFEntitiesConfig;
import SA.SRFramework.Workflow.WFEntityConfig;
import SA.SRFramework.Workflow.WFGroupProcessConfig;
import SA.SRFramework.Workflow.WFParamConfig;
import SA.SRFramework.Workflow.WFProcessConfig;
import SA.SRFramework.Workflow.WFStartConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class DefaultWFEngine
implements IWFEngine {
    public static final String TAG_SUBENGINE = "SUBENGINE";
    public static final String TAG_REPLACE = "REPLACE";
    public static final String TAG_PARAMASFUNC = "PARAMASFUNC";
    public static final String TAG_DATATYPE = "DATATYPE";
    protected WFConfig wfConfig = null;
    protected IWFEngineContext iWFEngineContext = null;
    protected BaseDBCallerHelperEx baseDBCallerHelperEx = null;
    protected String strOpPersonId = "";
    protected WFConfigMgr wfConfigMgr = null;
    protected ArrayList processes = new ArrayList();

    protected IWFEngineContext CreateWFEngineContext() {
        DefaultWFEngineContext wfEngineContext = new DefaultWFEngineContext();
        wfEngineContext.setWFEngine(this);
        wfEngineContext.setDBCallerHelper(this.baseDBCallerHelperEx);
        wfEngineContext.setOpPersonId(this.strOpPersonId);
        return wfEngineContext;
    }

    public void setDBCallerHelperEx(BaseDBCallerHelperEx dbCallerHelperEx) {
        this.baseDBCallerHelperEx = dbCallerHelperEx;
    }

    @Override
    public boolean Init(WFConfig wfConfig) {
        this.wfConfig = wfConfig;
        this.iWFEngineContext = this.CreateWFEngineContext();
        return true;
    }

    @Override
    public boolean Execute(BaseDataEntity value, BaseDataEntity globalDataEntity) {
        this.iWFEngineContext.setActiveDataEntity(value);
        this.iWFEngineContext.setGlobalDataEntity(globalDataEntity);
        this.processes.clear();
        if (!this.InternalExecute()) {
            int nSize = this.processes.size();
            int i = nSize - 1;
            while (i >= 0) {
                try {
                    IWFProcess iWFProcess = (IWFProcess)this.processes.get(i);
                    iWFProcess.Rollback();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                --i;
            }
            return false;
        }
        this.processes.clear();
        return true;
    }

    @Override
    public void Quit() {
    }

    @Override
    public IWFEngineContext getContext() {
        return this.iWFEngineContext;
    }

    public void Log(int level, String strInfo) {
        System.out.print(StringHelper.Format((String)"WFENGINE[%1$s][%2$s]\r\n", (Object)level, (Object)strInfo));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean InternalExecute() {
        try {
            WFEntitiesConfig wfEntitiesConfig = this.wfConfig.getEntitiesConfig();
            WFStartConfig wfStartConfig = wfEntitiesConfig.getStartConfig();
            if (wfStartConfig == null) {
                this.Log(2, "\u65e0\u6cd5\u5b9a\u4f4d\u6d41\u7a0b\u5f00\u59cb\u8282\u70b9");
                return false;
            }
            String strNextId = wfStartConfig.getNext();
            while (true) {
                ArrayList params;
                if (StringHelper.Length((String)strNextId) == 0) {
                    return true;
                }
                WFEntityConfig entityConfig = wfEntitiesConfig.FindEntityConfig(strNextId);
                if (entityConfig == null) {
                    this.Log(2, StringHelper.Format((String)"\u65e0\u6cd5\u5b9a\u4f4d\u6d41\u7a0b\u5b9e\u4f53[%1$s]", (Object)strNextId));
                    return false;
                }
                strNextId = "";
                BaseDataEntity baseDataEntity = this.iWFEngineContext.getActiveDataEntity();
                if (this.iWFEngineContext.getActiveDataEntity() != null && this.iWFEngineContext.getGlobalDataEntity() != null) {
                    BaseDataEntity globalDataEntity = this.iWFEngineContext.getGlobalDataEntity();
                    Hashtable hashTable = globalDataEntity.getParamList();
                    Enumeration en = hashTable.keys();
                    while (en.hasMoreElements()) {
                        String strKey = (String)en.nextElement();
                        if (baseDataEntity.ContainesParam(strKey)) continue;
                        baseDataEntity.SetParamValue(strKey, globalDataEntity.GetParamValue(strKey));
                    }
                }
                if (entityConfig.getParams() != null && (params = entityConfig.getParams().getList()) != null) {
                    int nCount = params.size();
                    int i = 0;
                    while (i < nCount) {
                        WFParamConfig wfParamConfig = (WFParamConfig)((Object)params.get(i));
                        boolean bReplace = wfParamConfig.GetExtValue(TAG_REPLACE, false);
                        if (!baseDataEntity.ContainesParam(wfParamConfig.getParamName()) || bReplace) {
                            boolean bParamAsFunc = wfParamConfig.GetExtValue(TAG_PARAMASFUNC, false);
                            String strDataType = wfParamConfig.GetExtValue(TAG_DATATYPE, "varchar");
                            int nDataType = DataTypeHelper.FromString((String)strDataType);
                            Object objValue = DefaultWFEngine.GetParamValue(this.iWFEngineContext, nDataType, wfParamConfig.getParamValue(), bParamAsFunc);
                            baseDataEntity.SetParamValue(wfParamConfig.getParamName(), objValue);
                        }
                        ++i;
                    }
                }
                if (entityConfig instanceof WFGroupProcessConfig) {
                    WFGroupProcessConfig groupProcessConfig = (WFGroupProcessConfig)entityConfig;
                    if (!this.DealGroupProcess(groupProcessConfig)) {
                        return false;
                    }
                    strNextId = groupProcessConfig.getNext();
                    continue;
                }
                if (entityConfig instanceof WFProcessConfig) {
                    WFProcessConfig processConfig = (WFProcessConfig)entityConfig;
                    if (!this.DealProcess(processConfig)) {
                        return false;
                    }
                    strNextId = processConfig.getNext();
                    continue;
                }
                if (entityConfig instanceof WFDecisionConfig) {
                    WFDecisionConfig decisionConfig = (WFDecisionConfig)entityConfig;
                    if (!this.DealDecision(decisionConfig)) {
                        return false;
                    }
                    strNextId = this.iWFEngineContext.getNext();
                    continue;
                }
                if (entityConfig instanceof WFEndConfig) break;
            }
            return true;
        }
        catch (Exception ex) {
            this.Log(1, StringHelper.Format((String)"Workflow\u5f15\u64ce\u6267\u884c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
        }
        return true;
    }

    protected boolean DealGroupProcess(WFGroupProcessConfig groupProcessConfig) {
        ArrayList childs = groupProcessConfig.getChildList();
        int nSize = childs.size();
        int i = 0;
        while (i < nSize) {
            WFProcessConfig processConfig = (WFProcessConfig)((Object)childs.get(i));
            if (!this.DealProcess(processConfig) && processConfig.getTransaction()) {
                return false;
            }
            ++i;
        }
        return true;
    }

    protected boolean DealProcess(WFProcessConfig processConfig) {
        if (processConfig.GetExtValue(TAG_SUBENGINE, false)) {
            if (this.wfConfigMgr == null) {
                this.Log(2, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u914d\u7f6e\u7ba1\u7406\u5668\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bf9\u5e94\u5f15\u64ce\uff01"));
                return false;
            }
            IWFEngine iWFEngine = this.CloneEngine();
            if (iWFEngine == null) {
                this.Log(2, StringHelper.Format((String)"\u65e0\u6cd5\u590d\u5236\u5b50\u5de5\u4f5c\u6d41\u5f15\u64ce\uff01"));
                return false;
            }
            if (!iWFEngine.Init(this.wfConfigMgr.GetWFConfigConfig(processConfig.getObject()))) {
                this.Log(2, StringHelper.Format((String)"\u521d\u59cb\u5316\u5b50\u5de5\u4f5c\u6d41\u5f15\u64ce[%1$s]\u9519\u8bef\uff01", (Object)processConfig.getObject()));
                return false;
            }
            if (!iWFEngine.Execute(this.iWFEngineContext.getActiveDataEntity(), this.iWFEngineContext.getGlobalDataEntity())) {
                this.Log(2, StringHelper.Format((String)"\u6267\u884c\u5b50\u5de5\u4f5c\u6d41\u5f15\u64ce[%1$s]\u9519\u8bef\uff01", (Object)processConfig.getObject()));
                return false;
            }
            iWFEngine.Quit();
            return true;
        }
        Object obj = ObjectHelper.Create(processConfig.getObject());
        if (obj == null) {
            return false;
        }
        if (obj instanceof IWFProcess) {
            return this.DealProcess((IWFProcess)obj, processConfig);
        }
        return false;
    }

    protected boolean DealProcess(IWFProcess iWFProcess, WFProcessConfig processConfig) {
        if (iWFProcess == null) {
            return false;
        }
        if (!iWFProcess.Init(processConfig)) {
            return false;
        }
        if (!iWFProcess.Execute(this.iWFEngineContext) && !processConfig.getAlwaySuccess()) {
            return false;
        }
        this.processes.add(iWFProcess);
        return true;
    }

    protected boolean DealDecision(WFDecisionConfig decisionConfig) {
        this.iWFEngineContext.setNext("");
        String strObjectId = decisionConfig.getObject();
        if (StringHelper.Length((String)strObjectId) > 0) {
            Object obj = ObjectHelper.Create(decisionConfig.getObject());
            if (obj == null) {
                this.Log(2, StringHelper.Format((String)"\u5efa\u7acbIWFDecision\u5bf9\u8c61[%1$s]\u5931\u8d25\uff01", (Object)decisionConfig.getObject()));
                return false;
            }
            if (obj instanceof IWFDecision) {
                IWFDecision iWPDecision = (IWFDecision)obj;
                if (!iWPDecision.Init(decisionConfig)) {
                    this.Log(2, StringHelper.Format((String)"\u521d\u59cb\u5316IWFDecision\u5bf9\u8c61[%1$s]\u5931\u8d25\uff01", (Object)decisionConfig.getObject()));
                    return false;
                }
                if (!iWPDecision.Execute(this.iWFEngineContext)) {
                    this.Log(2, StringHelper.Format((String)"\u6267\u884cIWFDecision\u5bf9\u8c61[%1$s]\u5931\u8d25\uff01", (Object)decisionConfig.getObject()));
                    iWPDecision.Quit();
                    return false;
                }
                iWPDecision.Quit();
                return true;
            }
            this.Log(2, StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u4e0d\u5305\u542b\u63a5\u53e3IWFDecision\u5931\u8d25\uff01", (Object)decisionConfig.getObject()));
            return false;
        }
        String strParamId = decisionConfig.getParamId();
        if (StringHelper.Length((String)strParamId) > 0) {
            Object objValue = this.iWFEngineContext.getActiveDataEntity().GetParamValue(strParamId);
            if (objValue == null) {
                this.Log(2, StringHelper.Format((String)"\u6fc0\u6d3b\u5bf9\u8c61\u5c5e\u6027[%1$s]\u503c\u65e0\u6548\uff01", (Object)strParamId));
                return false;
            }
            WFConnectionConfig defaultconnectionConfig = null;
            ArrayList connections = decisionConfig.getConnectionsConfig().getConnections();
            int nConnectionCount = connections.size();
            int i = 0;
            while (i < nConnectionCount) {
                WFConnectionConfig connectionConfig = (WFConnectionConfig)((Object)connections.get(i));
                if (connectionConfig.getDefaultMode()) {
                    defaultconnectionConfig = connectionConfig;
                } else if (this.TestConnection(this.iWFEngineContext, objValue, decisionConfig, connectionConfig)) {
                    this.iWFEngineContext.setNext(connectionConfig.getDst());
                    return true;
                }
                ++i;
            }
            if (defaultconnectionConfig != null) {
                this.iWFEngineContext.setNext(defaultconnectionConfig.getDst());
                return true;
            }
        }
        return false;
    }

    protected boolean TestConnection(IWFEngineContext iEngineContext, Object objValue, WFDecisionConfig decisionConfig, WFConnectionConfig connectionConfig) {
        Hashtable opList = connectionConfig.getOPList();
        Hashtable opParamList = connectionConfig.getOPParamList();
        Hashtable opParamAsFuncList = connectionConfig.getOpParamAsFuncList();
        boolean bAndMode = StringHelper.Compare((String)connectionConfig.getOpMode(), (String)"AND", (boolean)true) == 0;
        int i = 0;
        while (i <= 10) {
            if (opList.containsKey(i) && opParamList.containsKey(i)) {
                Object objDest;
                boolean bParamAsFunc = false;
                if (opParamAsFuncList != null && opParamAsFuncList.containsKey(i)) {
                    bParamAsFunc = (Boolean)opParamAsFuncList.get(i);
                }
                if ((objDest = DefaultWFEngine.GetParamValue(iEngineContext, decisionConfig.getDataType(), (String)opParamList.get(i), bParamAsFunc)) != null) {
                    boolean bRet = false;
                    bRet = DataTypeHelper.IsStringType((int)decisionConfig.getDataType()) ? DefaultWFEngine.CheckStringValueRule(iEngineContext, (Integer)opList.get(i), objValue.toString(), (String)objDest) : DefaultWFEngine.CheckNumberValueRule(iEngineContext, decisionConfig.getDataType(), (Integer)opList.get(i), objValue, objDest);
                    if (!bRet && bAndMode) {
                        return false;
                    }
                    if (bRet && !bAndMode) {
                        return true;
                    }
                }
            }
            ++i;
        }
        return bAndMode;
    }

    public static boolean CheckStringValueRule(IWFEngineContext iEngineContext, int nOpValue, String strSrc, String strDest) {
        switch (nOpValue) {
            case 1: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == 1L;
            }
            case 2: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) >= 0L;
            }
            case 3: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == 0L;
            }
            case 8: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) != 0L;
            }
            case 4: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) == -1L;
            }
            case 5: {
                return DataTypeParse.Compare((int)25, (Object)strSrc, (Object)strDest) <= 0L;
            }
        }
        iEngineContext.Log(1, StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        return false;
    }

    public static boolean CheckNumberValueRule(IWFEngineContext iEngineContext, int nDataType, int nOpValue, Object objSrc, Object objDest) {
        switch (nOpValue) {
            case 1: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == 1L;
            }
            case 2: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) >= 0L;
            }
            case 3: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == 0L;
            }
            case 8: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) != 0L;
            }
            case 4: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) == -1L;
            }
            case 5: {
                return DataTypeParse.Compare((int)nDataType, (Object)objSrc, (Object)objDest) <= 0L;
            }
        }
        iEngineContext.Log(2, StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object GetParamValue(IWFEngineContext iEngineContext, int nDataType, String strParamValue, boolean bParamAsFunc) {
        if (bParamAsFunc) {
            try {
                if (strParamValue.compareToIgnoreCase("@@DATETIME") == 0) {
                    return DataTypeParse.Parse((int)5, (String)DateParser.toDateTimeString((Date)new Date()));
                }
                if (strParamValue.compareToIgnoreCase("@@DATE") == 0) {
                    return DataTypeParse.Parse((int)27, (String)DateParser.toDateString((Date)new Date()));
                }
                if (strParamValue.compareToIgnoreCase("@@TIME") == 0) {
                    return DataTypeParse.Parse((int)28, (String)DateParser.toTimeString((Date)new Date()));
                }
                if (strParamValue.indexOf("##") != 0) {
                    iEngineContext.Log(2, StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                    return null;
                }
                strParamValue = strParamValue.substring(2);
                if (iEngineContext.getActiveDataEntity() == null) {
                    iEngineContext.Log(2, StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strParamValue));
                    return null;
                }
                return iEngineContext.getActiveDataEntity().GetParamValue(strParamValue);
            }
            catch (Exception ex) {
                iEngineContext.Log(2, StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                return null;
            }
        }
        Object objValue = DataTypeParse.Parse((int)nDataType, (String)strParamValue);
        if (objValue == null) {
            iEngineContext.Log(2, StringHelper.Format((String)"\u8ba1\u7b97\u53c2\u6570\u503c[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strParamValue));
        }
        return objValue;
    }

    public String getOpPersonId() {
        return this.strOpPersonId;
    }

    public void setOpPersonId(String strOpPersonId) {
        this.strOpPersonId = strOpPersonId;
    }

    protected IWFEngine CloneEngine() {
        DefaultWFEngine defaultWFEngine = new DefaultWFEngine();
        defaultWFEngine.setDBCallerHelperEx(this.baseDBCallerHelperEx);
        defaultWFEngine.setOpPersonId(this.strOpPersonId);
        defaultWFEngine.setWFConfigMgr(this.wfConfigMgr);
        return defaultWFEngine;
    }

    public WFConfigMgr getWFConfigMgr() {
        return this.wfConfigMgr;
    }

    public void setWFConfigMgr(WFConfigMgr wfConfigMgr) {
        this.wfConfigMgr = wfConfigMgr;
    }
}

