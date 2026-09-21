/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConnectionConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCDecideProcessConfig
 *  SA.SRFDA.Ctrl.IDEDataCtrlEngineContext
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.DEDC.Ctrl;

import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConnectionConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCDecideProcessConfig;
import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;
import SA.SRFDA.DEDC.Ctrl.BaseDEDCProcess;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.util.Date;
import java.util.Hashtable;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDCDecideProcess
extends BaseDEDCProcess {
    private static Log log = LogFactory.getLog(DEDCDecideProcess.class);

    public CallResult Execute(IDEDataCtrlEngineContext dedcContext, DEDCBaseProcessConfig processConfig) {
        CallResult callResult = new CallResult();
        DEDCDecideProcessConfig decideProcessConfig = (DEDCDecideProcessConfig)processConfig;
        String strDataEntity = decideProcessConfig.getDEDCProcess().getSRCDATAENTITY();
        String strParamId = decideProcessConfig.getDEDCProcess().getPARAMID();
        BaseDataEntity activeObject = dedcContext.GetDataEntity(strDataEntity);
        if (activeObject == null) {
            callResult.setRetCode(5);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6307\u5b9a\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548", (Object)strDataEntity));
            dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
            return callResult;
        }
        dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u6e90\u6570\u636e\u5bf9\u8c61[%1$s]", (Object)strDataEntity));
        int nObjectDataType = 0;
        Object objValue = activeObject.GetParamValue(strParamId);
        if (objValue != null) {
            Object realObjectValue = objValue;
            nObjectDataType = DEDCDecideProcess.GetObjectDataType(activeObject, strParamId);
            objValue = activeObject.GetParamValue(strParamId);
            activeObject.SetParamValue(strParamId, realObjectValue);
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u503c\u4e3a[%2$s]", (Object)strParamId, (Object)realObjectValue));
        } else {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u503c\u4e3a\u7a7a\u503c", (Object)strParamId));
        }
        DEDCConnectionConfig defaultconnectionConfig = null;
        for (DEDCConnectionConfig connectionConfig : decideProcessConfig.getConnectionsConfig()) {
            if (connectionConfig.getDefaultMode()) {
                defaultconnectionConfig = connectionConfig;
                continue;
            }
            try {
                if (!this.TestConnection(dedcContext, activeObject, objValue, nObjectDataType, decideProcessConfig, connectionConfig)) continue;
                dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5224\u65ad\u503c[%1$s]\u7b26\u5408\u8fde\u63a5[%2$s]\u89c4\u5219", (Object)objValue, (Object)connectionConfig.getLogicName()));
                dedcContext.Log(0, (Object)this, StringHelper.Format((String)"\u5224\u65ad\u503c[%1$s]\u7b26\u5408\u8fde\u63a5[%2$s]\u89c4\u5219", (Object)objValue, (Object)connectionConfig.getLogicName()));
                dedcContext.setNext(connectionConfig.getNext());
                return callResult;
            }
            catch (Exception ex) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u5224\u65ad\u51b3\u7b56\u8def\u5f84\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
                return callResult;
            }
        }
        if (defaultconnectionConfig != null) {
            dedcContext.DebugOutput((Object)this, StringHelper.Format((String)"\u5224\u65ad\u503c[%1$s]\u4e0d\u7b26\u5408\u4efb\u4f55\u8fde\u63a5\u89c4\u5219\uff0c\u4f7f\u7528\u9ed8\u8ba4\u8fde\u63a5[%2$s]", (Object)objValue, (Object)defaultconnectionConfig.getLogicName()));
            dedcContext.Log(0, (Object)this, StringHelper.Format((String)"\u5224\u65ad\u503c[%1$s]\u4e0d\u7b26\u5408\u4efb\u4f55\u8fde\u63a5\u89c4\u5219\uff0c\u4f7f\u7528\u9ed8\u8ba4\u8fde\u63a5[%2$s]", (Object)objValue, (Object)defaultconnectionConfig.getLogicName()));
            dedcContext.setNext(defaultconnectionConfig.getNext());
            return callResult;
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u9009\u62e9\u5408\u9002\u7684\u51b3\u7b56\u8def\u5f84"));
        dedcContext.Log(1, (Object)this, callResult.getErrorInfo());
        return callResult;
    }

    protected boolean TestConnection(IDEDataCtrlEngineContext dedcContext, BaseDataEntity activeObject, Object objValue, int nObjectDataType, DEDCDecideProcessConfig decisionConfig, DEDCConnectionConfig connectionConfig) throws Exception {
        Hashtable opList = connectionConfig.getOPList();
        Hashtable opParamList = connectionConfig.getOPParamList();
        Hashtable opParamAsFuncList = connectionConfig.getOpParamAsFuncList();
        boolean bAndMode = StringHelper.Compare((String)connectionConfig.getOpMode(), (String)"AND", (boolean)true) == 0;
        int i = 0;
        while (i <= 10) {
            block7: {
                boolean bRet;
                block9: {
                    Object objDest;
                    block11: {
                        block10: {
                            block8: {
                                if (!opList.containsKey(i) || !opParamList.containsKey(i)) break block7;
                                bRet = false;
                                if (objValue != null) break block8;
                                bRet = (Integer)opList.get(i) == 24;
                                break block9;
                            }
                            if ((Integer)opList.get(i) != 24) break block10;
                            bRet = false;
                            break block9;
                        }
                        if ((Integer)opList.get(i) != 25) break block11;
                        bRet = true;
                        break block9;
                    }
                    boolean bParamAsFunc = false;
                    if (opParamAsFuncList != null && opParamAsFuncList.containsKey(i)) {
                        bParamAsFunc = (Boolean)opParamAsFuncList.get(i);
                    }
                    if ((objDest = DEDCDecideProcess.GetParamValue(dedcContext, activeObject, nObjectDataType, (String)opParamList.get(i), bParamAsFunc)) == null) break block7;
                    bRet = DataTypeHelper.IsStringType((int)nObjectDataType) ? DEDCDecideProcess.CheckStringValueRule(dedcContext, (Integer)opList.get(i), objValue.toString(), (String)objDest) : DEDCDecideProcess.CheckNumberValueRule(dedcContext, nObjectDataType, (Integer)opList.get(i), objValue, objDest);
                }
                if (!bRet && bAndMode) {
                    return false;
                }
                if (bRet && !bAndMode) {
                    return true;
                }
            }
            ++i;
        }
        return bAndMode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object GetParamValue(IDEDataCtrlEngineContext dedcContext, BaseDataEntity activeObject, int nDataType, String strParamValue, boolean bParamAsFunc) {
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
                    dedcContext.Log(2, (Object)"GetParamValue", StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                    return null;
                }
                strParamValue = strParamValue.substring(2);
                if (activeObject == null) {
                    dedcContext.Log(2, (Object)"GetParamValue", StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strParamValue));
                    return null;
                }
                return activeObject.GetParamValue(strParamValue);
            }
            catch (Exception ex) {
                dedcContext.Log(2, (Object)"GetParamValue", StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                return null;
            }
        }
        Object objValue = DataTypeParse.Parse((int)nDataType, (String)strParamValue);
        if (objValue == null) {
            dedcContext.Log(2, (Object)"GetParamValue", StringHelper.Format((String)"\u8ba1\u7b97\u53c2\u6570\u503c[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strParamValue));
        }
        return objValue;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object GetParamValue(BaseDataEntity activeObject, int nDataType, String strParamValue, boolean bParamAsFunc) throws Exception {
        if (bParamAsFunc) {
            block7: {
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
                    if (strParamValue.indexOf("##") != 0) throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                    strParamValue = strParamValue.substring(2);
                    if (activeObject != null) break block7;
                    return null;
                }
                catch (Exception ex) {
                    throw new Exception(StringHelper.Format((String)"\u5904\u7406\u53c2\u6570\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strParamValue, (Object)ex.getMessage()));
                }
            }
            return activeObject.GetParamValue(strParamValue);
        }
        Object objValue = DataTypeParse.Parse((int)nDataType, (String)strParamValue);
        if (objValue != null) return objValue;
        throw new Exception(StringHelper.Format((String)"\u8ba1\u7b97\u53c2\u6570\u503c[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strParamValue));
    }

    public static boolean CheckStringValueRule(IDEDataCtrlEngineContext dedcContext, int nOpValue, String strSrc, String strDest) throws Exception {
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
        dedcContext.Log(1, (Object)"CheckStringValueRule", StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
    }

    public static boolean CheckNumberValueRule(IDEDataCtrlEngineContext dedcContext, int nDataType, int nOpValue, Object objSrc, Object objDest) throws Exception {
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
        dedcContext.Log(2, (Object)"CheckNumberValueRule", StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
    }

    public static int GetObjectDataType(BaseDataEntity dataEntity, String strParamId) {
        Object objValue = dataEntity.GetParamValue(strParamId);
        return DataTypeHelper.GetObjectDataType((Object)objValue);
    }

    @Override
    public boolean isSupportGenCode() {
        return true;
    }

    @Override
    public CallResult GenCode(StringBuilderEx output, IDACodeEngineContext iDACodeEngineContext, DEDCBaseProcessConfig baseProcessConfig) {
        CallResult callResult = new CallResult();
        TreeMap processNameMap = (TreeMap)iDACodeEngineContext.GetAttribute("PROCESSNAMEMAP");
        String strProcessName = (String)iDACodeEngineContext.GetAttribute("PROCESSNAME");
        if (iDACodeEngineContext.GetAttribute("DCDECIDEPROCESS_METHOD") == null) {
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "/**\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * \u68c0\u67e5\u503c\u89c4\u5219\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param nDataType\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param nOpValue\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param objSrc\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param objDest\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @return\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @throws Exception \r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " */\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "public static boolean DecideProcess_ChecValueRule(int nDataType,int nOpValue,Object objSrc,Object objDest) throws Exception\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\tif (DataTypeHelper.IsStringType(nDataType))\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t\treturn DecideProcess_CheckStringValueRule(nOpValue,objSrc.toString(),(String)objDest);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\telse\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t\treturn  DecideProcess_CheckNumberValueRule(nDataType,nOpValue,objSrc,objDest);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "/**\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * \u68c0\u67e5\u5b57\u7b26\u4e32\u503c\u89c4\u5219\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param dedcContext\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param nOpValue\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param strSrc\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param strDest\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @return\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @throws Exception \r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " */\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "public static boolean DecideProcess_CheckStringValueRule(int nOpValue,String strSrc,String strDest) throws Exception\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t// \u5b57\u7b26\u4e32\u5904\u7406\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\tswitch (nOpValue)\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_GT:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) == 1);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_GTANDEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) >= 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_EQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) == 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_NOTEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) != 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_LT:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) == -1);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_LTANDEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(DataType.VARCHAR, strSrc, strDest) <= 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "default:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "throw new Exception(StringHelper.Format(\"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]\", nOpValue));\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "/**\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * \u68c0\u67e5\u975e\u5b57\u7b26\u4e32\u503c\u89c4\u5219\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param dedcContext\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param nDataType\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param nOpValue\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param objSrc\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @param objDest\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @return\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * @throws Exception \r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " */\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "public static boolean DecideProcess_CheckNumberValueRule(int nDataType,int nOpValue,Object objSrc,Object objDest) throws Exception\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\t//\u6570\u503c\u7c7b\u578b\u5224\u65ad\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "switch (nOpValue)\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_GT:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) == 1);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_GTANDEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) >= 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_EQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) == 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_NOTEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) != 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_LT:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) == -1);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "case DEDCConnectionConfig.OP_LTANDEQ:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return (DataTypeParse.Compare(nDataType, objSrc, objDest) <= 0);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "default:\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "throw new Exception(StringHelper.Format(\"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]\", nOpValue));\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
            iDACodeEngineContext.SetAttribute("DCDECIDEPROCESS_METHOD", (Object)"1");
        }
        DEDCDecideProcessConfig decideProcessConfig = (DEDCDecideProcessConfig)baseProcessConfig;
        String strDataEntity = decideProcessConfig.getDEDCProcess().getSRCDATAENTITY();
        String strParamId = decideProcessConfig.getDEDCProcess().getPARAMID();
        if (StringHelper.IsNullOrEmpty((String)strParamId)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u5224\u65ad\u53c2\u6570");
            return callResult;
        }
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "/*\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " * %1$s\r\n", (Object)baseProcessConfig.getLogicName());
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " */\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "protected CallResult Deal%1$s(){\r\n", (Object)strProcessName);
        iDACodeEngineContext.IncreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "CallResult callResult = new CallResult();\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + " %1$s processConfig = (%1$s)GetDEDCConfig().getProcessesConfig().FindProcessConfig(\"%2$s\");\r\n", (Object)baseProcessConfig.getClass().getName(), (Object)baseProcessConfig.getID());
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "BaseDataEntity activeObject = this.GetDataEntity(\"%1$s\");\r\n", (Object)strDataEntity);
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "if(activeObject == null)\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
        iDACodeEngineContext.IncreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setRetCode(Errors.INPUTERROR);\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setErrorInfo(\"\u6307\u5b9a\u6570\u636e\u5bf9\u8c61[%1$s]\u65e0\u6548\");\r\n", (Object)strDataEntity);
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return callResult;\r\n");
        iDACodeEngineContext.DecreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "int nObjectDataType = DataType.UNKNOWN;\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "String strParamId = \"%1$s\";\r\n", (Object)strParamId);
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "Object objValue = activeObject.GetParamValue(strParamId);\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "if(objValue != null)\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
        iDACodeEngineContext.IncreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "Object realObjectValue = objValue;\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "nObjectDataType = DEDCDecideProcess.GetObjectDataType(activeObject,strParamId);\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "objValue = activeObject.GetParamValue(strParamId);\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "activeObject.SetParamValue(strParamId,realObjectValue);\r\n");
        iDACodeEngineContext.DecreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "try{\r\n");
        DEDCConnectionConfig defaultconnectionConfig = null;
        for (DEDCConnectionConfig connectionConfig : decideProcessConfig.getConnectionsConfig()) {
            if (connectionConfig.getDefaultMode()) {
                defaultconnectionConfig = connectionConfig;
                continue;
            }
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "//\u5224\u65ad\u8fde\u63a5  %1$s\r\n", (Object)connectionConfig.getLogicName());
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "if(");
            try {
                this.GenTestConnectionCode(output, iDACodeEngineContext, decideProcessConfig, connectionConfig);
            }
            catch (Exception e) {
                e.printStackTrace();
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u4ea7\u751f\u8fde\u63a5\u6761\u4ef6\u4ee3\u7801\u53d1\u9001\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
                return callResult;
            }
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + ")");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "{\r\n");
            iDACodeEngineContext.IncreasePreFix();
            String strNextProcessName = (String)processNameMap.get(connectionConfig.getNext());
            if (StringHelper.IsNullOrEmpty((String)strNextProcessName)) {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return LogAndReturn(\"Deal%1$s\",\"[%2$s]\u8fde\u63a5\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u5904\u7406\u8282\u70b9\",null);\r\n", (Object)strProcessName, (Object)connectionConfig.getLogicName());
            } else if (StringHelper.Compare((String)strNextProcessName, (String)"EndProcess", (boolean)false) == 0) {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "//\u8df3\u8f6c\u81f3\u7ed3\u675f\u8282\u70b9\r\n");
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.Reset();\r\n");
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return callResult;\r\n");
            } else {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return Deal%1$s();\r\n", (Object)strNextProcessName);
            }
            iDACodeEngineContext.DecreasePreFix();
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        }
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "catch(Exception ex){\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "ex.printStackTrace();\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setErrorInfo(StringHelper.Format(\"\u5224\u65ad\u51b3\u7b56\u8def\u5f84\u51fa\u73b0\u5f02\u5e38\uff0c%1$s\",ex.getMessage()));\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return callResult;\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        if (defaultconnectionConfig != null) {
            String strNextProcessName = (String)processNameMap.get(defaultconnectionConfig.getNext());
            if (StringHelper.IsNullOrEmpty((String)strNextProcessName)) {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return LogAndReturn(\"Deal%1$s\",\"[%2$s]\u8fde\u63a5\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u5904\u7406\u8282\u70b9\",null);\r\n", (Object)strProcessName, (Object)defaultconnectionConfig.getLogicName());
            } else if (StringHelper.Compare((String)strNextProcessName, (String)"EndProcess", (boolean)false) == 0) {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.Reset();\r\n");
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return callResult;\r\n");
            } else {
                output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return Deal%1$s();\r\n", (Object)strNextProcessName);
            }
        } else {
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "//\u6ca1\u6709\u7b26\u5408\u8981\u6c42\u7684\u51b3\u7b56\u8def\u5f84\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "callResult.setErrorInfo(StringHelper.Format(\"\u65e0\u6cd5\u9009\u62e9\u5408\u9002\u7684\u51b3\u7b56\u8def\u5f84\"));\r\n");
            output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "return callResult;\r\n");
        }
        iDACodeEngineContext.DecreasePreFix();
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "}\r\n");
        output.Append(String.valueOf(iDACodeEngineContext.GetPreFix()) + "\r\n");
        callResult.Reset();
        return callResult;
    }

    protected CallResult GenTestConnectionCode(StringBuilderEx output, IDACodeEngineContext iDACodeEngineContext, DEDCDecideProcessConfig decisionConfig, DEDCConnectionConfig connectionConfig) throws Exception {
        Hashtable opList = connectionConfig.getOPList();
        Hashtable opParamList = connectionConfig.getOPParamList();
        Hashtable opParamAsFuncList = connectionConfig.getOpParamAsFuncList();
        boolean bAndMode = StringHelper.Compare((String)connectionConfig.getOpMode(), (String)"AND", (boolean)true) == 0;
        boolean bFirst = true;
        int i = 0;
        while (i <= 10) {
            if (opList.containsKey(i) && opParamList.containsKey(i)) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    output.Append("\r\n %1$s", (Object)(bAndMode ? "&&" : "||"));
                }
                int nAction = (Integer)opList.get(i);
                if (nAction == 24) {
                    output.Append("(objValue == null)");
                } else if (nAction == 25) {
                    output.Append("(objValue != null)");
                } else {
                    boolean bParamAsFunc = false;
                    if (opParamAsFuncList != null && opParamAsFuncList.containsKey(i)) {
                        bParamAsFunc = (Boolean)opParamAsFuncList.get(i);
                    }
                    output.Append(" DecideProcess_ChecValueRule(nObjectDataType,%1$s,objValue,DEDCDecideProcess.GetParamValue(activeObject,nObjectDataType,\"%2$s\",%3$s))", (Object)DEDCDecideProcess.GetOpType((Integer)opList.get(i)), opParamList.get(i), (Object)(bParamAsFunc ? "true" : "false"));
                }
            }
            ++i;
        }
        return new CallResult();
    }

    private static String GetOpType(int nType) throws Exception {
        switch (nType) {
            case 0: {
                return "DEDCConnectionConfig.OP_UNKNOWN";
            }
            case 1: {
                return "DEDCConnectionConfig.OP_GT";
            }
            case 2: {
                return "DEDCConnectionConfig.OP_GTANDEQ";
            }
            case 3: {
                return "DEDCConnectionConfig.OP_EQ";
            }
            case 4: {
                return "DEDCConnectionConfig.OP_LT";
            }
            case 5: {
                return "DEDCConnectionConfig.OP_LTANDEQ";
            }
            case 8: {
                return "DEDCConnectionConfig.OP_NOTEQ";
            }
            case 12: {
                return "DEDCConnectionConfig.OP_AND";
            }
            case 23: {
                return "DEDCConnectionConfig.OP_OR";
            }
            case 24: {
                return "DEDCConnectionConfig.OP_ISNULL";
            }
            case 25: {
                return "DEDCConnectionConfig.OP_ISNOTNULL";
            }
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u64cd\u4f5c\u503c[%1$s]", (Object)nType));
    }
}

