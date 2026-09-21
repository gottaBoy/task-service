/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Model;

import SA.SRFDA.Model.SearchFormItemConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class SearchItemConfig
extends XMLConfig {
    public static final String TAG_SEARCHITEM = "SRFDASEARCHITEM";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_GROUP = "GROUP";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_FUNC = "FUNC";
    public static final String TAG_FORMITEM = "FORMITEM";
    public static final String TAG_FORMITEMPARAM = "FORMITEMPARAM";
    public static final String TAG_FORMITEMPARAMS = "FORMITEMPARAMS";
    public static final String TAG_CTRLPARAMS = "CTRLPARAMS";
    public static final String TAG_SHOWORDER = "SHOWORDER";
    public static final String TAG_COLSPAN = "COLSPAN";
    protected String strCaption = "";
    protected String strGroup = "";
    protected String strAction = "";
    protected String strFunc = "";
    protected String strFormItem = "";
    protected String strFormItemParam = "";
    protected String strFormItemParams = "";
    protected int nShowOrder = 100;
    protected int nColSpan = 1;
    protected String strCtrlParams = "";
    protected SearchFormItemConfig searchFormItemConfig = null;

    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare((String)strName, (String)TAG_CAPTION, (boolean)true) == 0) {
            this.setCaption(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_GROUP, (boolean)true) == 0) {
            this.setGroup(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_ACTION, (boolean)true) == 0) {
            this.setAction(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FUNC, (boolean)true) == 0) {
            this.setFunc(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMITEM, (boolean)true) == 0) {
            this.setFormItem(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMITEMPARAM, (boolean)true) == 0) {
            this.setFormItemParam(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_FORMITEMPARAMS, (boolean)true) == 0) {
            this.setFormItemParams(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_CTRLPARAMS, (boolean)true) == 0) {
            this.setCtrlParams(strValue);
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_SHOWORDER, (boolean)true) == 0) {
            this.setShowOrder(SearchItemConfig.GetValue((String)strValue, (int)this.nShowOrder));
            return;
        }
        if (StringHelper.Compare((String)strName, (String)TAG_COLSPAN, (boolean)true) == 0) {
            this.setColSpan(SearchItemConfig.GetValue((String)strValue, (int)this.nColSpan));
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)"SRFDASEARCHFORMITEM", (boolean)true) == 0) {
            if (this.searchFormItemConfig == null) {
                this.searchFormItemConfig = new SearchFormItemConfig();
            }
            this.searchFormItemConfig.LoadConfig(xmlNode);
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    public String getCaption() {
        return this.strCaption;
    }

    public void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    public String getGroup() {
        return this.strGroup;
    }

    public void setGroup(String strGroup) {
        this.strGroup = strGroup;
    }

    public String getAction() {
        return this.strAction;
    }

    public void setAction(String strAction) {
        this.strAction = strAction;
    }

    public String getFunc() {
        return this.strFunc;
    }

    public void setFunc(String strFunc) {
        this.strFunc = strFunc;
    }

    public String getFormItem() {
        return this.strFormItem;
    }

    public void setFormItem(String strFormItem) {
        this.strFormItem = strFormItem;
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    public void setShowOrder(int showOrder) {
        this.nShowOrder = showOrder;
    }

    public SearchFormItemConfig getSearchFormItemConfig() {
        return this.searchFormItemConfig;
    }

    public String getFormItemParam() {
        return this.strFormItemParam;
    }

    public void setFormItemParam(String strFormItemParam) {
        this.strFormItemParam = strFormItemParam;
    }

    public String getFormItemParams() {
        return this.strFormItemParams;
    }

    public void setFormItemParams(String strFormItemParams) {
        this.strFormItemParams = strFormItemParams;
    }

    public int getColSpan() {
        return this.nColSpan;
    }

    public void setColSpan(int nColSpan) {
        this.nColSpan = nColSpan;
        if (this.nColSpan <= 0) {
            this.nColSpan = 1;
        }
    }

    public String getCtrlParams() {
        return this.strCtrlParams;
    }

    public void setCtrlParams(String strCtrlParams) {
        this.strCtrlParams = strCtrlParams;
    }
}

