/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.CodeEngine.BaseDACodeEngine
 *  SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCEndProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig
 *  SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCStartProcessConfig
 *  SA.SRFDA.Ctrl.Data.DEDCProcess
 *  SA.SRFDA.Ctrl.Data.DEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDCProcess
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 */
package SA.SRFDA.Ctrl.CodeEngine;

import SA.SRFDA.Ctrl.CodeEngine.BaseDACodeEngine;
import SA.SRFDA.Ctrl.CodeEngine.IDACodeEngineContext;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCEndProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCProcessConfig;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCStartProcessConfig;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.IDEDCProcess;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.TreeMap;

public class DEDCCodeEngine
extends BaseDACodeEngine {
    public CallResult GenCode(Writer writer, BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            DEDataCtrl deDataCtrl = new DEDataCtrl();
            deDataCtrl.Proxy(dataEntity);
            this.Log(0, StringHelper.Format((String)"\u5f00\u59cb\u53d1\u5e03\u5b9e\u4f53\u5904\u7406\u903b\u8f91[%1$s][%2$s][%3$s]", (Object)deDataCtrl.getDENAME(), (Object)deDataCtrl.getDEDATACTRLNAME(), (Object)deDataCtrl.getDEDATACTRLID()));
            boolean bNewWriter = false;
            String strCodeName = deDataCtrl.getDEDCCODE();
            if (StringHelper.IsNullOrEmpty((String)strCodeName)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801"));
                this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u5931\u8d25\uff0c\u6ca1\u6709\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801\u8def\u5f84"));
                return callResult;
            }
            String strPackageName = "";
            String strClassName = "";
            String[] parts = strCodeName.split("[.]");
            int i = 0;
            while (i < parts.length - 1) {
                if (strPackageName.length() != 0) {
                    strPackageName = String.valueOf(strPackageName) + ".";
                }
                strPackageName = String.valueOf(strPackageName) + parts[i];
                ++i;
            }
            strClassName = parts[parts.length - 1];
            if (writer == null) {
                String strCodePath = this.GetCodePath("", strCodeName, ".java");
                if (StringHelper.IsNullOrEmpty((String)strCodePath)) {
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u83b7\u53d6\u53d1\u5e03\u4ee3\u7801\u8def\u5f84"));
                    this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u5931\u8d25\uff0c\u6ca1\u6709\u6307\u5b9a\u53d1\u5e03\u4ee3\u7801\u8def\u5f84"));
                    return callResult;
                }
                File file = new File(strCodePath);
                if (file.exists()) {
                    if (!file.canWrite()) {
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u6587\u4ef6[%1$s]\u4e0d\u80fd\u88ab\u5199\u5165", (Object)strCodePath));
                        this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u5931\u8d25\uff0c\u6587\u4ef6[%1$s]\u4e0d\u80fd\u88ab\u5199\u5165", (Object)strCodePath));
                        return callResult;
                    }
                } else {
                    File folder = new File(file.getParent());
                    folder.mkdirs();
                }
                writer = new OutputStreamWriter(new FileOutputStream(strCodePath));
                bNewWriter = true;
                this.Log(0, StringHelper.Format((String)"\u8ba1\u7b97\u4ee3\u7801\u53d1\u5e03\u8def\u5f84[%1$s]", (Object)strCodePath));
            }
            StringBuilderEx output = new StringBuilderEx();
            output.Append("package %1$s;\r\n", (Object)strPackageName);
            output.Append("\r\n");
            this.OutputImport(output, deDataCtrl);
            output.Append("\r\n");
            output.Append("/**\r\n");
            output.Append(" * \u5b9e\u4f53\u5904\u7406\u903b\u8f91 [%1$s][%2$s] \r\n", (Object)deDataCtrl.getDEDATACTRLNAME(), (Object)deDataCtrl.getDEDATACTRLID());
            output.Append(" * \u76f8\u5173\u5b9e\u4f53 [%1$s][%2$s] \r\n", (Object)deDataCtrl.getDENAME(), (Object)deDataCtrl.getDEID());
            output.Append(" * \u53d1\u5e03\u65f6\u95f4  %1$s  \r\n", (Object)DateParser.toDateTimeString((Date)new Date()));
            output.Append(" * @author\r\n");
            output.Append(" *\r\n");
            output.Append(" */\r\n");
            output.Append("public class %1$s extends SA.SRFDA.DEDC.Ctrl.DefaultDEDCEngine{\r\n", (Object)strClassName);
            output.Append("\r\n");
            output.Append("\tprivate static final Log log = LogFactory.getLog(%1$s.class);\r\n", (Object)strClassName);
            output.Append("\r\n");
            output.Append("\r\n");
            callResult = this.OutputProcess(output, deDataCtrl);
            if (callResult.IsError()) {
                this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            output.Append("}");
            writer.write(output.toString());
            if (bNewWriter) {
                writer.flush();
                writer.close();
            }
            this.Log(0, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u6210\u529f"));
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801\u51fa\u73b0\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            this.Log(1, StringHelper.Format((String)"\u4ee3\u7801\u53d1\u5e03\u5931\u8d25\uff0c%1$s", (Object)ex.getMessage()));
            return callResult;
        }
        callResult.Reset();
        return callResult;
    }

    protected CallResult OutputProcess(StringBuilderEx output, DEDataCtrl deDataCtrl) {
        String strProcessName;
        CallResult callResult = new CallResult();
        DEDCConfig dedcConfig = deDataCtrl.getDEDCConfig();
        if (dedcConfig == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u6ca1\u6709\u83b7\u53d6\u5904\u7406\u914d\u7f6e");
            return new CallResult();
        }
        for (DEDCBaseProcessConfig processConfig : deDataCtrl.getDEDCConfig().getProcessesConfig()) {
            if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
            DEDCProcess dedcProcess = new DEDCProcess();
            callResult = this.iDAGlobalHelper.getDAModelHelper().GetDEDCProcess(processConfig.getProcessConfigId(), dedcProcess);
            if (callResult.IsError()) {
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)processConfig.getProcessConfigId(), (Object)callResult.getErrorInfo()));
                this.Log(1, callResult.getErrorInfo());
                return callResult;
            }
            processConfig.setDEDCProcess(dedcProcess);
        }
        this.ResetPreFix();
        this.IncreasePreFix();
        output.Append(String.valueOf(this.GetPreFix()) + "@Override\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "protected CallResult InternalExecute(DEDCBaseProcessConfig processConfig){\r\n");
        this.IncreasePreFix();
        if (dedcConfig.getProcessesConfig().GetStartProcessConfig() == null) {
            output.Append(String.valueOf(this.GetPreFix()) + "//\u6ca1\u6709\u5b9a\u4e49\u5f00\u59cb\u5904\u7406\u8282\u70b9\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "CallResult callResult = new CallResult();\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "callResult.setErrorInfo(\"\u6ca1\u6709\u5b9a\u4e49\u5f00\u59cb\u5904\u7406\u8282\u70b9\");\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "return callResult;\r\n");
        } else {
            output.Append(String.valueOf(this.GetPreFix()) + "return DealStartProcess();\r\n");
        }
        this.DecreasePreFix();
        output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
        TreeMap<String, String> processNameMap = new TreeMap<String, String>();
        int nIndex = 0;
        for (DEDCBaseProcessConfig baseProcessConfig : dedcConfig.getProcessesConfig()) {
            if (baseProcessConfig instanceof DEDCStartProcessConfig) {
                processNameMap.put(baseProcessConfig.getID(), StringHelper.Format((String)"StartProcess"));
                continue;
            }
            if (baseProcessConfig instanceof DEDCEndProcessConfig) {
                processNameMap.put(baseProcessConfig.getID(), StringHelper.Format((String)"EndProcess"));
                continue;
            }
            processNameMap.put(baseProcessConfig.getID(), StringHelper.Format((String)"Process_%1$s", (Object)nIndex));
            ++nIndex;
        }
        output.Append(String.valueOf(this.GetPreFix()) + "/*\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + " * %1$s\r\n", (Object)"\u901a\u8fc7\u5904\u7406\u7f16\u53f7\u9009\u62e9\u5904\u7406");
        output.Append(String.valueOf(this.GetPreFix()) + " */\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "protected CallResult SwitchProcess(String strProcessId){\r\n");
        this.IncreasePreFix();
        for (String strKey : processNameMap.keySet()) {
            strProcessName = (String)processNameMap.get(strKey);
            if (StringHelper.Compare((String)strProcessName, (String)"StartProcess", (boolean)true) == 0) {
                output.Append(String.valueOf(this.GetPreFix()) + "if(StringHelper.Compare(strProcessId,\"%1$s\",false)==0)\r\n", (Object)strKey);
                output.Append(String.valueOf(this.GetPreFix()) + "{\r\n");
                this.IncreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "CallResult callResult = new CallResult();\r\n");
                output.Append(String.valueOf(this.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
                output.Append(String.valueOf(this.GetPreFix()) + "callResult.setErrorInfo(\"\u4e0d\u80fd\u8df3\u8f6c\u81f3\u5f00\u59cb\u5904\u7406\u8282\u70b9\");\r\n");
                output.Append(String.valueOf(this.GetPreFix()) + "return callResult;\r\n");
                this.DecreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
                continue;
            }
            if (StringHelper.Compare((String)strProcessName, (String)"EndProcess", (boolean)true) == 0) {
                output.Append(String.valueOf(this.GetPreFix()) + "if(StringHelper.Compare(strProcessId,\"%1$s\",false)==0)\r\n", (Object)strKey);
                this.IncreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "return new CallResult();\r\n");
                this.DecreasePreFix();
                continue;
            }
            output.Append(String.valueOf(this.GetPreFix()) + "if(StringHelper.Compare(strProcessId,\"%1$s\",false)==0)\r\n", (Object)strKey);
            this.IncreasePreFix();
            output.Append(String.valueOf(this.GetPreFix()) + "return Deal%1$s();\r\n", (Object)strProcessName);
            this.DecreasePreFix();
        }
        output.Append(String.valueOf(this.GetPreFix()) + "\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "//\u65e0\u6cd5\u8bc6\u522b\u7684\u5904\u7406\u8282\u70b9\u7f16\u53f7\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "CallResult callResult = new CallResult();\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "callResult.setErrorInfo(\"\u65e0\u6cd5\u8bc6\u522b\u7684\u5904\u7406\u8282\u70b9\");\r\n");
        output.Append(String.valueOf(this.GetPreFix()) + "return callResult;\r\n");
        this.DecreasePreFix();
        output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
        this.SetAttribute("PROCESSNAMEMAP", processNameMap);
        for (DEDCBaseProcessConfig baseProcessConfig : dedcConfig.getProcessesConfig()) {
            strProcessName = (String)processNameMap.get(baseProcessConfig.getID());
            if (baseProcessConfig instanceof DEDCStartProcessConfig) {
                DEDCStartProcessConfig startProcessConfig = (DEDCStartProcessConfig)baseProcessConfig;
                output.Append(String.valueOf(this.GetPreFix()) + "protected CallResult DealStartProcess(){\r\n");
                this.IncreasePreFix();
                String strNextProcessName = (String)processNameMap.get(startProcessConfig.getNext());
                if (StringHelper.IsNullOrEmpty((String)strNextProcessName)) {
                    output.Append(String.valueOf(this.GetPreFix()) + "CallResult callResult = new CallResult();\r\n");
                    output.Append(String.valueOf(this.GetPreFix()) + "callResult.setRetCode(Errors.INTERNALERROR);\r\n");
                    output.Append(String.valueOf(this.GetPreFix()) + "callResult.setErrorInfo(\"\u6ca1\u6709\u4e3a\u5f00\u59cb\u5904\u7406\u6307\u5b9a\u540e\u7eed\u6267\u884c\u5904\u7406\");\r\n");
                    output.Append(String.valueOf(this.GetPreFix()) + "return callResult;\r\n");
                } else if (StringHelper.Compare((String)strNextProcessName, (String)"EndProcess", (boolean)false) == 0) {
                    output.Append(String.valueOf(this.GetPreFix()) + "return new CallResult();\r\n");
                } else {
                    output.Append(String.valueOf(this.GetPreFix()) + "return Deal%1$s();\r\n", (Object)strNextProcessName);
                }
                this.DecreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
                continue;
            }
            if (baseProcessConfig instanceof DEDCEndProcessConfig) continue;
            this.SetAttribute("PROCESSNAME", strProcessName);
            IDEDCProcess iDEDCProcess = this.iDAGlobalHelper.getDEDCProcessStorage().FindDEDCProcess(baseProcessConfig);
            if (iDEDCProcess == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5904\u7406\u914d\u7f6e[%1$s]\u6240\u5bf9\u5e94\u7684\u5904\u7406\u5bf9\u8c61", (Object)baseProcessConfig.getClass().getName()));
                this.Log(1, callResult.getErrorInfo());
                return callResult;
            }
            if (iDEDCProcess.isSupportGenCode()) {
                callResult = iDEDCProcess.GenCode(output, (IDACodeEngineContext)this, baseProcessConfig);
                if (!callResult.IsError()) continue;
                this.Log(1, callResult.getErrorInfo());
                return callResult;
            }
            output.Append(String.valueOf(this.GetPreFix()) + "/*\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + " * %1$s\r\n", (Object)baseProcessConfig.getLogicName());
            output.Append(String.valueOf(this.GetPreFix()) + " */\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "protected CallResult Deal%1$s(){\r\n", (Object)strProcessName);
            this.IncreasePreFix();
            output.Append(String.valueOf(this.GetPreFix()) + " %1$s processConfig = (%1$s)GetDEDCConfig().getProcessesConfig().FindProcessConfig(\"%2$s\");\r\n", (Object)baseProcessConfig.getClass().getName(), (Object)baseProcessConfig.getID());
            output.Append(String.valueOf(this.GetPreFix()) + "CallResult callResult = InternalExecuteProcess(processConfig);\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "if(callResult == null || callResult.getRetCode()!=Errors.OK)\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "{\r\n");
            this.IncreasePreFix();
            output.Append(String.valueOf(this.GetPreFix()) + "return LogAndReturn(\"InternalExecute\",StringHelper.Format(\"\u6267\u884c\u5904\u7406[%1$s]\",processConfig.getLogicName()),callResult);\r\n");
            this.DecreasePreFix();
            output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
            String strNext = "";
            if (baseProcessConfig instanceof DEDCProcessConfig) {
                DEDCProcessConfig processConfig = (DEDCProcessConfig)baseProcessConfig;
                strNext = processConfig.getNext();
            }
            if (StringHelper.IsNullOrEmpty((String)strNext)) {
                output.Append(String.valueOf(this.GetPreFix()) + "if(StringHelper.IsNullOrEmpty(this.getNext()))\r\n");
                output.Append(String.valueOf(this.GetPreFix()) + "{\r\n");
                this.IncreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "return LogAndReturn(\"InternalExecute\",StringHelper.Format(\"[%1$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9\",processConfig.getLogicName()),null);\r\n");
                this.DecreasePreFix();
                output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
                output.Append(String.valueOf(this.GetPreFix()) + "return SwitchProcess(this.getNext());\r\n");
            } else {
                String strNextProcessName = (String)processNameMap.get(strNext);
                if (StringHelper.IsNullOrEmpty((String)strNextProcessName)) {
                    output.Append(String.valueOf(this.GetPreFix()) + "return LogAndReturn(\"InternalExecute\",StringHelper.Format(\"[%1$s]\u6267\u884c\u540e\uff0c\u6ca1\u6709\u6307\u5b9a\u540e\u7eed\u8282\u70b9\",processConfig.getLogicName()),null);\r\n");
                } else if (StringHelper.Compare((String)strNextProcessName, (String)"EndProcess", (boolean)false) == 0) {
                    output.Append(String.valueOf(this.GetPreFix()) + "callResult.Reset();\r\n");
                    output.Append(String.valueOf(this.GetPreFix()) + "return callResult;\r\n");
                } else {
                    output.Append(String.valueOf(this.GetPreFix()) + "return Deal%1$s();\r\n", (Object)strNextProcessName);
                }
            }
            this.DecreasePreFix();
            output.Append(String.valueOf(this.GetPreFix()) + "}\r\n");
            output.Append(String.valueOf(this.GetPreFix()) + "\r\n");
        }
        return callResult;
    }

    protected void OutputImport(StringBuilderEx output, DEDataCtrl deDataCtrl) {
        output.Append("import java.util.TreeMap;\r\n");
        output.Append("import java.util.Vector;\r\n");
        output.Append("import org.apache.commons.logging.Log;\r\n");
        output.Append("import org.apache.commons.logging.LogFactory;\r\n");
        output.Append("import SA.SRFDA.Ctrl.IDEDCProcess;\r\n");
        output.Append("import SA.SRFDA.Ctrl.IDEDataCtrl;\r\n");
        output.Append("import SA.SRFDA.Ctrl.IDEDataCtrlEngine;\r\n");
        output.Append("import SA.SRFDA.Ctrl.IDEDataCtrlEngineContext;\r\n");
        output.Append("import SA.SRFDA.Ctrl.IDEHelper;\r\n");
        output.Append("import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;\r\n");
        output.Append("import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConfig;\r\n");
        output.Append("import SA.SRFDA.Ctrl.Data.DEDataCtrl;\r\n");
        output.Append("import SA.SRFDA.Web.ISRFDAWebContext;\r\n");
        output.Append("import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;\r\n");
        output.Append("import SA.SRFramework.CommonEx.Errors;\r\n");
        output.Append("import SA.SRFramework.CommonEx.LogLevels;\r\n");
        output.Append("import SA.SRFramework.DataEx.BaseDataEntity;\r\n");
        output.Append("import SA.SRFramework.DataEx.CallResult;\r\n");
        output.Append("import SA.SRFramework.DataEx.ValueError;\r\n");
        output.Append("import SA.SRFramework.Utility.StringHelper;\r\n");
        output.Append("import SA.SRFramework.Data.DataType;\r\n");
        output.Append("import SA.SRFramework.Data.DataTypeHelper;\r\n");
        output.Append("import SA.SRFramework.Data.DataTypeParse;\r\n");
        output.Append("import SA.SRFDA.DEDC.Ctrl.DEDCDecideProcess;\r\n");
        output.Append("import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCConnectionConfig;\r\n");
    }
}

