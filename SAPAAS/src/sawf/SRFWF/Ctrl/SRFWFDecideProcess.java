/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 */
package SRFWF.Ctrl;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Ctrl.ISRFWFContext;
import SRFWF.Ctrl.SRFWFBaseProcess;
import SRFWF.Model.WFBaseConnectionConfig;
import SRFWF.Model.WFConnectionConfig;
import SRFWF.Model.WFDecideProcessConfig;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

public class SRFWFDecideProcess
extends SRFWFBaseProcess {
    private Object realObjectValue = null;

    @Override
    public CallResult Execute(ISRFWFContext context) {
        CallResult callResult = new CallResult();
        WFDecideProcessConfig decideProcessConfig = (WFDecideProcessConfig)context.getCurProcessConfig();
        String strParamId = decideProcessConfig.getParamId();
        if (StringHelper.Length((String)strParamId) > 0) {
            int nObjectDataType = 0;
            Object objValue = context.getActiveObject().GetParamValue(strParamId);
            if (objValue != null) {
                this.realObjectValue = objValue;
                nObjectDataType = this.GetObjectDataType(objValue);
                objValue = this.realObjectValue;
            }
            WFBaseConnectionConfig defaultconnectionConfig = null;
            Iterator iterator = decideProcessConfig.getConnectionsConfig().iterator();
            while (iterator.hasNext()) {
                WFConnectionConfig connectionConfig = (WFConnectionConfig)((Object)iterator.next());
                if (connectionConfig.getDefaultMode()) {
                    defaultconnectionConfig = connectionConfig;
                    continue;
                }
                if (!this.TestConnection(context, objValue, nObjectDataType, decideProcessConfig, connectionConfig)) continue;
                context.setNext(connectionConfig.getNext());
                return callResult;
            }
            if (defaultconnectionConfig != null) {
                context.setNext(defaultconnectionConfig.getNext());
                return callResult;
            }
            callResult.setRetCode(3);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u9009\u62e9\u5408\u9002\u7684\u51b3\u7b56\u8def\u5f84"));
            context.Log(1, this, callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }

    protected boolean TestConnection(ISRFWFContext iEngineContext, Object objValue, int nObjectDataType, WFDecideProcessConfig decisionConfig, WFConnectionConfig connectionConfig) {
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
                    if ((objDest = SRFWFDecideProcess.GetParamValue(iEngineContext, nObjectDataType, (String)opParamList.get(i), bParamAsFunc)) == null) break block7;
                    bRet = DataTypeHelper.IsStringType((int)nObjectDataType) ? SRFWFDecideProcess.CheckStringValueRule(iEngineContext, (Integer)opList.get(i), objValue.toString(), (String)objDest) : SRFWFDecideProcess.CheckNumberValueRule(iEngineContext, nObjectDataType, (Integer)opList.get(i), objValue, objDest);
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
    public static Object GetParamValue(ISRFWFContext iEngineContext, int nDataType, String strParamValue, boolean bParamAsFunc) {
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
                    iEngineContext.Log(2, "GetParamValue", StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                    return null;
                }
                strParamValue = strParamValue.substring(2);
                if (iEngineContext.getActiveObject() == null) {
                    iEngineContext.Log(2, "GetParamValue", StringHelper.Format((String)"\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548\uff0c\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strParamValue));
                    return null;
                }
                return iEngineContext.getActiveObject().GetParamValue(strParamValue);
            }
            catch (Exception ex) {
                iEngineContext.Log(2, "GetParamValue", StringHelper.Format((String)"\u65e0\u6cd5\u5931\u8d25\u7684\u53c2\u6570\u5904\u7406[%1$s]", (Object)strParamValue));
                return null;
            }
        }
        Object objValue = DataTypeParse.Parse((int)nDataType, (String)strParamValue);
        if (objValue == null) {
            iEngineContext.Log(2, "GetParamValue", StringHelper.Format((String)"\u8ba1\u7b97\u53c2\u6570\u503c[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strParamValue));
        }
        return objValue;
    }

    public static boolean CheckStringValueRule(ISRFWFContext iEngineContext, int nOpValue, String strSrc, String strDest) {
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
        iEngineContext.Log(1, "CheckStringValueRule", StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5b57\u7b26\u4e32\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        return false;
    }

    public static boolean CheckNumberValueRule(ISRFWFContext iEngineContext, int nDataType, int nOpValue, Object objSrc, Object objDest) {
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
        iEngineContext.Log(2, "CheckNumberValueRule", StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u503c\u5339\u914d\u7b26\u53f7[%1$s]", (Object)nOpValue));
        return false;
    }

    private int GetObjectDataType(Object obj) {
        String strObjectType = obj.getClass().getName();
        if (strObjectType.equals(String.class.getName())) {
            return 25;
        }
        if (strObjectType.equals(Character.class.getName())) {
            return 25;
        }
        if (strObjectType.equals(java.sql.Date.class.getName())) {
            return 5;
        }
        if (strObjectType.equals(Date.class.getName())) {
            return 5;
        }
        String strValue = obj.toString();
        if (strValue.indexOf(".") == -1) {
            try {
                this.realObjectValue = Integer.parseInt(strValue);
                return 9;
            }
            catch (Exception exception) {}
        } else {
            try {
                this.realObjectValue = Double.parseDouble(strValue);
                return 7;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return 25;
    }
}

