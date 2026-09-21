/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.Data.Toolbar
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFGetIAActionsResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.wltea.expression.ExpressionEvaluator
 *  org.wltea.expression.datameta.Variable
 */
package SA.SRFDA.Ctrl.ToolbarWriter;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.ToolbarWriter.IToolbarItemWriterContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFGetIAActionsResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wltea.expression.ExpressionEvaluator;
import org.wltea.expression.datameta.Variable;

public class DefaultToolbarWriterContext
implements IToolbarItemWriterContext {
    private static final Log log = LogFactory.getLog(DefaultToolbarWriterContext.class);
    public static final String TAG_INFOMODE = "INFOMODE";
    public static final String TBCOND_ROWACTIONBAR = "ROWACTIONBAR";
    protected Toolbar tbData = null;
    protected IDEHelper iDEHelper = null;
    protected Page page = null;
    protected String strViewStyle = "";
    protected WFGetIAActionsResult wfGetIAActionsResult = null;
    protected String strPageModel = "";
    protected String strLanguage;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected boolean bSimpleMode = false;
    protected HashMap<String, Boolean> extCondMap = new HashMap();
    protected HashMap<String, Object> attributes = new HashMap();
    protected HashMap<String, Boolean> defaultMap = new HashMap();

    public IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    public void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    public Page getPage() {
        return this.page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getViewStyle() {
        return this.strViewStyle;
    }

    public void setViewStyle(String strViewStyle) {
        this.strViewStyle = strViewStyle;
    }

    public boolean TestCondition(String strCondition) {
        if (StringHelper.IsNullOrEmpty((String)strCondition)) {
            return true;
        }
        Hashtable<String, Boolean> variableMap = new Hashtable<String, Boolean>();
        this.CalcCondItems(strCondition, variableMap);
        if (variableMap.size() == 1 && variableMap.containsKey(strCondition)) {
            return variableMap.get(strCondition);
        }
        ArrayList<Variable> variables = new ArrayList<Variable>();
        for (String strCondItem : variableMap.keySet()) {
            variables.add(Variable.createVariable((String)strCondItem, (Object)variableMap.get(strCondItem)));
        }
        Object result = ExpressionEvaluator.evaluate((String)strCondition, variables);
        if (result == null) {
            return false;
        }
        return StringHelper.Compare((String)result.toString(), (String)"true", (boolean)true) == 0;
    }

    private void CalcCondItems(String strCondition, Hashtable<String, Boolean> variables) {
        String strLastItem = "";
        strCondition = strCondition.toUpperCase();
        int i = 0;
        while (i < strCondition.length()) {
            char ch = strCondition.charAt(i);
            if (ch >= 'A' && ch <= 'Z' || ch == '_') {
                strLastItem = String.valueOf(strLastItem) + ch;
            } else if (ch >= '0' && ch <= '9') {
                if (!StringHelper.IsNullOrEmpty((String)strLastItem)) {
                    strLastItem = String.valueOf(strLastItem) + ch;
                }
            } else {
                if (!StringHelper.IsNullOrEmpty((String)strLastItem) && !variables.containsKey(strLastItem)) {
                    variables.put(strLastItem, this.GetCondItemValue(strLastItem));
                }
                strLastItem = "";
            }
            ++i;
        }
        if (!StringHelper.IsNullOrEmpty((String)strLastItem) && !variables.containsKey(strLastItem)) {
            variables.put(strLastItem, this.GetCondItemValue(strLastItem));
        }
    }

    protected boolean GetCondItemValue(String strItem) {
        boolean bDefaultValue = true;
        bDefaultValue = this.extCondMap.containsKey(strItem) ? this.extCondMap.get(strItem).booleanValue() : this.GetDefaultAction(strItem);
        if (this.tbData == null) {
            return bDefaultValue;
        }
        return this.tbData.GetParamIntValue(strItem, bDefaultValue ? 1 : 0) == 1;
    }

    protected boolean GetDefaultAction(String strAction) {
        if (this.defaultMap.containsKey(strAction)) {
            return this.defaultMap.get(strAction);
        }
        if (StringHelper.Compare((String)"NEWACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserCreate();
        }
        if (StringHelper.Compare((String)"EDITACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserUpdate();
        }
        if (StringHelper.Compare((String)"VIEWACTION", (String)strAction, (boolean)true) == 0) {
            if (!this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            if (this.GetDefaultAction("EDITACTION")) {
                return false;
            }
            return this.iDEHelper.IsEnableUserView();
        }
        if (StringHelper.Compare((String)"REMOVEACTION", (String)strAction, (boolean)true) == 0 || StringHelper.Compare((String)"REMOVEANDEXITACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserDelete();
        }
        if (StringHelper.Compare((String)"COPYACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserCreate();
        }
        if (StringHelper.Compare((String)"NEWROWACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserCreate();
        }
        if (StringHelper.Compare((String)"VIEWWFSTEPACTOR", (String)strAction, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.Compare((String)"SAVEACTION", (String)strAction, (boolean)true) == 0 || StringHelper.Compare((String)"SAVEANDEXITACTION", (String)strAction, (boolean)true) == 0 || StringHelper.Compare((String)"SAVEANDNEWACTION", (String)strAction, (boolean)true) == 0) {
            if (this.getAttribute(TAG_INFOMODE, false).booleanValue()) {
                return false;
            }
            return this.iDEHelper.IsEnableUserUpdate();
        }
        if (StringHelper.Compare((String)"SAVEANDSTARTWFACTION", (String)strAction, (boolean)true) == 0) {
            return this.iDEHelper.IsEnableWF() && this.iDEHelper.GetDEWF().getUSERSTART();
        }
        if (StringHelper.Compare((String)"DATANAVBAR", (String)strAction, (boolean)true) == 0) {
            return StringHelper.Compare((String)this.iDEHelper.GetProperty("MULTIFORM"), (String)"TRUE", (boolean)true) != 0;
        }
        if (StringHelper.Compare((String)"PRINTACTION", (String)strAction, (boolean)true) == 0) {
            boolean bEnablePrint = this.iDEHelper.IsEnablePrint();
            return bEnablePrint;
        }
        return StringHelper.Compare((String)"NODEFDEBHGROUP", (String)strAction, (boolean)true) != 0;
    }

    public void setToolbar(Toolbar tbData) {
        this.tbData = tbData;
    }

    public WFGetIAActionsResult getWFGetIAActionsResult() {
        return this.wfGetIAActionsResult;
    }

    public void setWFGetIAActionsResult(WFGetIAActionsResult wfGetIAActionsResult) {
        this.wfGetIAActionsResult = wfGetIAActionsResult;
    }

    public String getPageModel() {
        return this.strPageModel;
    }

    public void setPageModel(String strPageModel) {
        this.strPageModel = strPageModel;
    }

    public String getLanguage() {
        return this.strLanguage;
    }

    public ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public void setLanguage(String strLanguage) {
        this.strLanguage = strLanguage;
    }

    public void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    public boolean getSimpleMode() {
        return this.bSimpleMode;
    }

    public void setSimpleMode(boolean bSimpleMode) {
        this.bSimpleMode = bSimpleMode;
    }

    public String FindDEBHGroup(String strGroupId) {
        if (this.tbData == null) {
            return "";
        }
        String strPropertyKey = "";
        strPropertyKey = StringHelper.Compare((String)strGroupId, (String)"1", (boolean)true) == 0 ? "DEBHGROUPID" : StringHelper.Format((String)"DEBHGROUP%1$sID", (Object)strGroupId);
        return this.tbData.GetParamStringValue(strPropertyKey, "");
    }

    public void RegisterGlobal(String strCondition, boolean bValue) {
        this.extCondMap.put(strCondition.toUpperCase(), bValue);
    }

    public void RegisterDefault(String strCondition, boolean bValue) {
        this.defaultMap.put(strCondition.toUpperCase(), bValue);
    }

    public String getDEObjectName() {
        return this.getDEHelper().getLogicName(this.getLanguage());
    }

    public Object getAttribute(String strKey) {
        strKey = strKey.toUpperCase();
        return this.attributes.get(strKey);
    }

    protected Boolean getAttribute(String strKey, boolean bDefault) {
        Object objValue = this.getAttribute(strKey);
        if (objValue == null) {
            return bDefault;
        }
        return (Boolean)objValue;
    }

    public void setAttribute(String strKey, Object objValue) {
        strKey = strKey.toUpperCase();
        if (objValue == null) {
            this.attributes.remove(strKey);
        } else {
            this.attributes.put(strKey, objValue);
        }
    }
}

