/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.PrintForm
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Report.BasePrintFormEngine;
import SA.SRFDA.Report.IPrintFormPlugin;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultPrintFormEngine
extends BasePrintFormEngine {
    public static final String TAG_SRFTAGHEADER = "%%SRF";
    public static final String TAG_SRFTAGEND = ")%%";
    public static final String TAG_SRFDATE = "SRFDATE";
    public static final String TAG_SRFDATETIME = "SRFDATETIME";
    public static final String TAG_SRFTIME = "SRFTIME";
    public static final String TAG_SRFOPPERSON = "SRFOPPERSON";
    public static final String TAG_SRFDEF = "SRFDEF";
    public static final String TAG_SRFOBJ = "SRFOBJ";
    private static final Log log = LogFactory.getLog(DefaultPrintFormEngine.class);

    @Override
    protected String OnOutput(SRFDAWebContext webContext, PrintForm printForm, IDEHelper helper, BaseDataEntity dataEntity) {
        Vector<String> funcList;
        String strFormModel = printForm.getFORMMODEL();
        if (!this.ParseFormModel(strFormModel, funcList = new Vector<String>())) {
            return "";
        }
        TreeMap<String, String> funcValueMap = new TreeMap<String, String>();
        for (String strFunc : funcList) {
            if (funcValueMap.containsKey(strFunc)) continue;
            funcValueMap.put(strFunc, this.GetFuncValue(strFunc, webContext, printForm, helper, dataEntity));
        }
        for (String strKey : funcValueMap.keySet()) {
            strFormModel = strFormModel.replace(strKey, (CharSequence)funcValueMap.get(strKey));
        }
        return strFormModel;
    }

    protected String GetFuncValue(String strFunc, SRFDAWebContext webContext, PrintForm printForm, IDEHelper helper, BaseDataEntity dataEntity) {
        Vector<String> argList = new Vector<String>();
        String strFuncName = this.ParseFunc(strFunc, argList);
        if (StringHelper.IsNullOrEmpty((String)strFuncName)) {
            return "";
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATE, (boolean)true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return StringHelper.Format((String)strFormat, (Object)new Date());
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDATETIME, (boolean)true) == 0) {
            String strFormat = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return StringHelper.Format((String)strFormat, (Object)new Date());
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFTIME, (boolean)true) == 0) {
            String strFormat = "%1$tH:%1$tM:%1$tS";
            if (argList.size() > 0) {
                strFormat = argList.get(0);
            }
            return StringHelper.Format((String)strFormat, (Object)new Date());
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFOPPERSON, (boolean)true) == 0) {
            return webContext.getCurUserName();
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFDEF, (boolean)true) == 0) {
            String strFieldName = "";
            if (argList.size() > 0) {
                strFieldName = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strFieldName)) {
                return "\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027";
            }
            IDEFHelper iDEFHelper = helper.GetDEFHelper(strFieldName);
            if (iDEFHelper == null) {
                return StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", (Object)strFieldName);
            }
            Object objValue = dataEntity.GetParamValue(iDEFHelper.getName());
            if (objValue == null) {
                return "/";
            }
            String strCodeList = iDEFHelper.GetCodeList();
            if (!StringHelper.IsNullOrEmpty((String)strCodeList)) {
                CodeListConfig codeListConfig = webContext.getCodeListMgr().GetCodeListConfig(strCodeList);
                if (codeListConfig == null) {
                    return StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]", (Object)strCodeList);
                }
                objValue = codeListConfig.GetCodeListValue(objValue.toString(), false);
            }
            String strFormat = iDEFHelper.GetFormCtrl().GetItemFormat();
            if (argList.size() > 1) {
                strFormat = argList.get(1);
            }
            if (StringHelper.IsNullOrEmpty((String)strFormat)) {
                strFormat = "%1$s";
            }
            return StringHelper.Format((String)strFormat, (Object)objValue);
        }
        if (StringHelper.Compare((String)strFuncName, (String)TAG_SRFOBJ, (boolean)true) == 0) {
            String strObject = "";
            if (argList.size() > 0) {
                strObject = argList.get(0);
            }
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                return StringHelper.Format((String)"\u9519\u8bef:\u6ca1\u6709\u6307\u5b9a\u81ea\u5b9a\u4e49\u8f93\u51fa\u5bf9\u8c61");
            }
            Object obj = ObjectHelper.Create((String)strObject);
            if (obj == null) {
                return StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u5efa\u7acb\u81ea\u5b9a\u4e49\u8f93\u51fa\u5bf9\u8c61[%1$s]", (Object)strObject);
            }
            if (!(obj instanceof IPrintFormPlugin)) {
                return StringHelper.Format((String)"\u9519\u8bef:\u81ea\u5b9a\u4e49\u8f93\u51fa\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5b9e\u73b0\u76f8\u5e94\u63a5\u53e3", (Object)strObject);
            }
            return ((IPrintFormPlugin)obj).Output(webContext, printForm, helper, dataEntity);
        }
        return StringHelper.Format((String)"\u9519\u8bef:\u65e0\u6cd5\u8bc6\u522b\u7684\u5b8f[%1$s]", (Object)strFunc);
    }

    protected String ParseFunc(String strFunc, Vector<String> argList) {
        int nPos = strFunc.indexOf("(");
        if (nPos == -1) {
            return "";
        }
        String strFuncName = strFunc.substring(2, nPos);
        String strParams = strFunc.substring(nPos + 1, strFunc.length() - 3);
        if (StringHelper.IsNullOrEmpty((String)(strParams = strParams.trim()))) {
            return strFuncName;
        }
        String[] params = strParams.split("[,]");
        int i = 0;
        while (i < params.length) {
            argList.add(params[i].trim());
            ++i;
        }
        return strFuncName;
    }

    protected boolean ParseFormModel(String strFormModel, Vector<String> funcList) {
        int nPos;
        int nStartPos = 0;
        while ((nPos = strFormModel.indexOf(TAG_SRFTAGHEADER, nStartPos)) != -1) {
            int nPos2 = strFormModel.indexOf(TAG_SRFTAGEND, nPos);
            if (nPos2 == -1) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5b8f\u5f00\u59cb\u4f4d\u7f6e[%1$s]\u5bf9\u5e94\u7684\u7ed3\u675f\u7b26", (Object)nPos));
                return false;
            }
            String strTemp = strFormModel.substring(nPos, nPos2 + 3);
            funcList.add(strTemp);
            nStartPos = nPos2 + 3;
            if (nStartPos > strFormModel.length()) continue;
        }
        return true;
    }
}

