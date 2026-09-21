/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  groovy.lang.Binding
 *  groovy.lang.Script
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.DAQueryModelAlias;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.IDAQueryModelContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import groovy.lang.Binding;
import groovy.lang.Script;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DAQueryModelGrooveEngine
extends Script
implements IDAQueryModelContext {
    private BaseDAQueryModelHelper baseDAQueryModelHelper = null;
    private static final Log log = LogFactory.getLog(DAQueryModelGrooveEngine.class);

    public boolean Init(BaseDAQueryModelHelper baseDAQueryModelHelper) {
        this.baseDAQueryModelHelper = baseDAQueryModelHelper;
        return true;
    }

    public CallResult GetCustomCondition(String strCondition) {
        CallResult callResult = new CallResult();
        try {
            String strRet = "";
            Binding binding = new Binding();
            binding.setVariable("qm", (Object)this);
            this.setBinding(binding);
            String strExpression = strCondition;
            strRet = (String)this.evaluate(strExpression);
            callResult.setUserObject((Object)strRet);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u8ba1\u7b97\u81ea\u5b9a\u4e49\u903b\u8f91[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strCondition));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    public Object run() {
        return null;
    }

    @Override
    public String CurField(String strFieldName) {
        return this.Field("CUR", strFieldName);
    }

    @Override
    public String Field(String strAlias, String strFieldName) {
        DAQueryModelAlias qmAlias = this.baseDAQueryModelHelper.FindQMAlias(strAlias);
        if (qmAlias == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u522b\u540d[%1$s]\u76f8\u5173\u5bf9\u8c61", (Object)strAlias));
            return null;
        }
        IDEHelper iDEHelper = qmAlias.getIDEHelper();
        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(strFieldName);
        if (iDEFHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61\uff0c\u5c06\u68c0\u67e5\u5c5e\u6027\u662f\u5426\u5b58\u5728", (Object)iDEHelper.getName(), (Object)strFieldName));
            return null;
        }
        CallResult callResult = this.baseDAQueryModelHelper.GetDEFieldExp(iDEFHelper, qmAlias.getParentDER(), qmAlias.getDERAliasMap(), qmAlias.getDERList());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8868\u8fbe\u5f0f\uff0c%3$s", (Object)iDEHelper.getName(), (Object)strFieldName, (Object)callResult.getErrorInfo()));
            return null;
        }
        return (String)callResult.getUserObject();
    }

    @Override
    public String Table(String strAlias, boolean bMain) {
        DAQueryModelAlias qmAlias = this.baseDAQueryModelHelper.FindQMAlias(strAlias);
        if (qmAlias == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u522b\u540d[%1$s]\u76f8\u5173\u5bf9\u8c61", (Object)strAlias));
            return null;
        }
        IDEHelper iDEHelper = qmAlias.getIDEHelper();
        CallResult callResult = this.baseDAQueryModelHelper.GetTableAlias(iDEHelper, bMain, qmAlias.getParentDER(), qmAlias.getDERAliasMap(), qmAlias.getDERList());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u4e3b\u8868[%2$s]\u8868\u8fbe\u5f0f\uff0c%3$s", (Object)iDEHelper.getName(), (Object)bMain, (Object)callResult.getErrorInfo()));
            return null;
        }
        return (String)callResult.getUserObject();
    }

    @Override
    public String MainField(String strFieldName) {
        return this.Field("MAIN", strFieldName);
    }

    @Override
    public String Param(String strParamName) {
        CallParam callParam = new CallParam();
        callParam.setParamName(strParamName);
        this.baseDAQueryModelHelper.RegisterCallParam(strParamName, null);
        return "?";
    }

    @Override
    public String StaticParam(String strParamName) {
        return this.baseDAQueryModelHelper.GetStaticParamValue(strParamName);
    }

    @Override
    public String DBType() {
        return this.baseDAQueryModelHelper.GetDBType();
    }
}

