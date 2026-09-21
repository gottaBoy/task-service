/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SearchFormBuilder;
import SA.SRFramework.Web.ButtonClickListener;
import SA.SRFramework.Web.CheckUserInputEvent;
import SA.SRFramework.Web.IWebCtrl2;
import SA.SRFramework.Web.InitFromWebRequestListener;
import SA.SRFramework.Web.SRFForm;
import SA.SRFramework.Web.SRFImgButton;
import SA.SRFramework.Web.SRFWebControl;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.SearchFormConfig;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.Vector;
import javax.servlet.jsp.JspWriter;

public class SRFSearchForm
extends SRFForm
implements ButtonClickListener {
    protected SearchFormConfig curSearchFormConfig = null;
    protected SearchFormBuilder sfBuilder = null;
    protected SRFImgButton normalSearch = null;
    protected SRFImgButton advSearch = null;
    transient Vector initFromWebRequestListeners = null;

    public synchronized void addInitFromWebRequestListener(InitFromWebRequestListener l) {
        if (this.initFromWebRequestListeners == null) {
            this.initFromWebRequestListeners = new Vector();
        }
        this.initFromWebRequestListeners.add(l);
    }

    public synchronized void removeInitFromWebRequestListener(InitFromWebRequestListener l) {
        if (this.initFromWebRequestListeners == null) {
            return;
        }
        this.initFromWebRequestListeners.remove(l);
    }

    protected void fireInitFromWebRequestListener(EventObject eventObject) {
        if (this.initFromWebRequestListeners != null) {
            Vector listeners = this.initFromWebRequestListeners;
            int count = listeners.size();
            int i = 0;
            while (i < count) {
                ((InitFromWebRequestListener)listeners.elementAt(i)).OnInitFromWebRequest(eventObject);
                ++i;
            }
        }
    }

    public void setConfig(SearchFormConfig value) {
        this.curSearchFormConfig = value;
    }

    public boolean ConfigBind() {
        if (this.curSearchFormConfig != null) {
            ArrayList<String> IdList = new ArrayList<String>();
            int i = 0;
            while (i < this.curSearchFormConfig.getSearchItems().size()) {
                String strIdFormat;
                SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
                if ((searchCtrlConfig.getSearchMode() & 1) > 0) {
                    strIdFormat = searchCtrlConfig.getDBField();
                    strIdFormat = "Normal_" + strIdFormat;
                    if (searchCtrlConfig.getSearchRange()) {
                        IdList.add(String.valueOf(strIdFormat) + "_FROM");
                        IdList.add(String.valueOf(strIdFormat) + "_TO");
                    } else {
                        IdList.add(strIdFormat);
                    }
                }
                if ((this.curSearchFormConfig.getMode() & 2) > 0 && (searchCtrlConfig.getSearchMode() & 2) > 0) {
                    strIdFormat = searchCtrlConfig.getDBField();
                    strIdFormat = "Adv_" + strIdFormat;
                    if (searchCtrlConfig.getSearchRange()) {
                        IdList.add(String.valueOf(strIdFormat) + "_FROM");
                        IdList.add(String.valueOf(strIdFormat) + "_TO");
                    } else {
                        IdList.add(strIdFormat);
                    }
                }
                int j = 0;
                while (j < IdList.size()) {
                    String strIdFormat2 = (String)IdList.get(j);
                    SRFWebControl ctrl = this.CreateCtrl(strIdFormat2, searchCtrlConfig);
                    if (ctrl != null) {
                        this.sfBuilder.BindCtrlStyle(ctrl, searchCtrlConfig);
                        this.AddControl(ctrl);
                        this.childCtrlList.put(strIdFormat2.toUpperCase(), ctrl);
                    }
                    ++j;
                }
                IdList.clear();
                ++i;
            }
            SRFImgButton normalBtn = this.sfBuilder.GetSearchButton("Btn_NormalSearch", 1);
            this.AddControl(normalBtn);
            this.childCtrlList.put("BTN_NORMALSEARCH", normalBtn);
            if ((this.curSearchFormConfig.getMode() & 2) > 0) {
                SRFImgButton advBtn = this.sfBuilder.GetSearchButton("Btn_AdvSearch", 2);
                this.AddControl(advBtn);
                this.childCtrlList.put("BTN_ADVSEARCH", advBtn);
            }
            this.LinkToButton();
        }
        this.fireOnChildsCreated(new EventObject(this));
        if (!this.getPage().getIsPostBack()) {
            this.InitFromWebRequest();
            this.fireInitFromWebRequestListener(new EventObject(this));
        }
        return true;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.sfBuilder = this.GetSearchFormBuilder();
    }

    protected void InitFromWebRequest() {
        int nSearchItemCount = this.curSearchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
            String strRequestValueFrom = "";
            String strRequestValueTo = "";
            String strRequestValue = "";
            if (searchCtrlConfig.getSearchRange()) {
                strRequestValueFrom = this.getWebContext().GetParamValue(String.valueOf(searchCtrlConfig.getDBField().toUpperCase()) + "_FROM");
                strRequestValueTo = this.getWebContext().GetParamValue(String.valueOf(searchCtrlConfig.getDBField().toUpperCase()) + "_TO");
            } else {
                strRequestValue = this.getWebContext().GetParamValue(searchCtrlConfig.getDBField().toUpperCase());
            }
            if (StringHelper.StringLength(strRequestValueFrom) > 0) {
                this.FillCtrlsValue(String.valueOf(searchCtrlConfig.getDBField()) + "_FROM", strRequestValueFrom);
            }
            if (StringHelper.StringLength(strRequestValueTo) > 0) {
                this.FillCtrlsValue(String.valueOf(searchCtrlConfig.getDBField()) + "_TO", strRequestValueTo);
            }
            if (StringHelper.StringLength(strRequestValue) > 0) {
                this.FillCtrlsValue(searchCtrlConfig.getDBField(), strRequestValue);
            }
            ++i;
        }
    }

    protected void FillCtrlsValue(String strKey, String strValue) {
        String strNormal_Key = "Normal_" + strKey;
        String strAdv_Key = "Adv_" + strKey;
        this.FillCtrlValue2(strNormal_Key, strValue);
        this.FillCtrlValue2(strAdv_Key, strValue);
    }

    protected void FillCtrlValue2(String strKey, String strValue) {
        Object objWebCtrl = this.childCtrlList.get(strKey.toUpperCase());
        if (objWebCtrl == null) {
            return;
        }
        if (ClassHelper.ContainClass(objWebCtrl.getClass(), IWebCtrl2.class)) {
            IWebCtrl2 interWebCtrl = (IWebCtrl2)objWebCtrl;
            interWebCtrl.SetUrlValue(strValue);
            return;
        }
        super.FillCtrlValue(strKey, strValue);
    }

    @Override
    protected void OnRender(JspWriter output) {
        if (this.sfBuilder == null) {
            return;
        }
        try {
            output.println("<!-- SearchForm:Start -->");
            this.sfBuilder.setControlId(this.getUniqueID());
            this.sfBuilder.setCurWebContext(this.getWebContext());
            this.sfBuilder.setShowView(this.getWebContext().getSearch());
            this.sfBuilder.setChildCtrls(this.childCtrlList);
            this.sfBuilder.setSFConfig(this.curSearchFormConfig);
            this.sfBuilder.setFormError(this.formErrorMgr);
            this.sfBuilder.setShowSearchForm(this.getWebContext().getShowCondition());
            this.sfBuilder.Render(output);
            output.println("<!-- SearchForm:End -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected SearchFormBuilder GetSearchFormBuilder() {
        return this.getWebContext().getCurThemeConfig().GetSearchFormBuilder();
    }

    protected void LinkToButton() {
        if (this.childCtrlList.containsKey("BTN_NORMALSEARCH")) {
            this.normalSearch = (SRFImgButton)this.childCtrlList.get("BTN_NORMALSEARCH");
            this.normalSearch.addButtonClickListener(this);
        }
        if (this.childCtrlList.containsKey("BTN_ADVSEARCH")) {
            this.advSearch = (SRFImgButton)this.childCtrlList.get("BTN_ADVSEARCH");
            this.advSearch.addButtonClickListener(this);
        }
    }

    private void DoUserSearch(boolean bNormal) {
        Hashtable paramList = new Hashtable();
        this.getWebContext().setShowCondition(true);
        this.getWebContext().setLoadSC(false);
        if (bNormal) {
            this.getWebContext().setSearch(1);
        } else {
            this.getWebContext().setSearch(2);
        }
        this.PutUserInputToRequest(bNormal, paramList);
        String strQueryString = this.getWebContext().GetSystemCall();
        ArrayList userParams = this.curSearchFormConfig.getUserParams();
        if (userParams != null) {
            int nParamCount = userParams.size();
            int i = 0;
            while (i < nParamCount) {
                String strUserParamKey = userParams.get(i).toString();
                if (StringHelper.Length(strUserParamKey) != 0) {
                    strUserParamKey = strUserParamKey.toUpperCase();
                    String strKeyValue = this.getWebContext().GetParamValue(strUserParamKey);
                    if (StringHelper.StringLength(strKeyValue) != 0) {
                        try {
                            strKeyValue = URLEncoder.encode(strKeyValue, "UTF-8");
                        }
                        catch (Exception ex) {
                            ex.printStackTrace(System.out);
                        }
                        if (strQueryString.length() > 0) {
                            strQueryString = String.valueOf(strQueryString) + "&";
                        }
                        strQueryString = String.valueOf(strQueryString) + strUserParamKey;
                        strQueryString = String.valueOf(strQueryString) + "=";
                        strQueryString = String.valueOf(strQueryString) + strKeyValue;
                    }
                }
                ++i;
            }
        }
        Enumeration enumeration = paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strKey = (String)enumeration.nextElement();
            String strKeyValue = this.getWebContext().GetParamValue(strKey);
            if (StringHelper.StringLength(strKeyValue) == 0) continue;
            try {
                strKeyValue = URLEncoder.encode(strKeyValue, "UTF-8");
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
            if (strQueryString.length() > 0) {
                strQueryString = String.valueOf(strQueryString) + "&";
            }
            strQueryString = String.valueOf(strQueryString) + strKey;
            strQueryString = String.valueOf(strQueryString) + "=";
            strQueryString = String.valueOf(strQueryString) + strKeyValue;
        }
        try {
            this.getPage().getResponse().sendRedirect(String.valueOf(this.getWebContext().getCurPageName()) + "?" + strQueryString);
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private boolean CheckUserInput(boolean bNormal, Hashtable paramList) {
        this.fireOnBeforeCheckUserInput(new EventObject(this));
        int curCtrlMode = bNormal ? 1 : 2;
        String strPrefixId = bNormal ? "Normal_" : "Adv_";
        int nSearchItemCount = this.curSearchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
            if ((searchCtrlConfig.getSearchMode() & curCtrlMode) > 0) {
                String strIdFormat = searchCtrlConfig.getDBField();
                strIdFormat = String.valueOf(strPrefixId) + strIdFormat;
                if (searchCtrlConfig.getSearchRange()) {
                    String strParamKey;
                    String strCtrlIdFrom = String.valueOf(strIdFormat) + "_FROM";
                    String strCtrlIdTo = String.valueOf(strIdFormat) + "_TO";
                    String strValueFrom = this.GetCtrlValue(strCtrlIdFrom);
                    String strValueTo = this.GetCtrlValue(strCtrlIdTo);
                    Object objValueFrom = null;
                    Object objValueTo = null;
                    strCtrlIdFrom = strCtrlIdFrom.toUpperCase();
                    strCtrlIdTo = strCtrlIdTo.toUpperCase();
                    if (StringHelper.StringLength(strValueFrom) != 0) {
                        objValueFrom = this.CheckInputValue(searchCtrlConfig, strValueFrom);
                        if (objValueFrom == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlIdFrom);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, true, "DataTypeError"));
                        } else {
                            strParamKey = String.valueOf(searchCtrlConfig.getDBField()) + "_FROM";
                            strParamKey = strParamKey.toUpperCase();
                            this.getWebContext().SetParamValue(strParamKey, strValueFrom);
                            paramList.put(strParamKey, objValueFrom);
                        }
                    }
                    if (StringHelper.StringLength(strValueTo) != 0) {
                        objValueTo = this.CheckInputValue(searchCtrlConfig, strValueTo);
                        if (objValueTo == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlIdTo);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, false, "DataTypeError"));
                        } else {
                            strParamKey = String.valueOf(searchCtrlConfig.getDBField()) + "_TO";
                            strParamKey = strParamKey.toUpperCase();
                            this.getWebContext().SetParamValue(strParamKey, strValueTo);
                            if (objValueTo.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                                Timestamp endTime = (Timestamp)objValueTo;
                                endTime.setTime(endTime.getTime() + 86400000L - 1L);
                            }
                            paramList.put(strParamKey, objValueTo);
                        }
                    }
                    if (objValueFrom != null && objValueTo != null && searchCtrlConfig.getCompareCheck() && !DataTypeParse.LessThan(searchCtrlConfig.getDBType(), objValueFrom, objValueTo)) {
                        this.formErrorMgr.AddErrorInput(strCtrlIdFrom);
                        this.formErrorMgr.AddErrorInput(strCtrlIdTo);
                        this.formErrorMgr.AppendErrorMsg(this.GetCompareErrorMsg(searchCtrlConfig));
                    }
                } else {
                    String strCtrlId = strIdFormat.toUpperCase();
                    String strValue = this.GetCtrlValue(strIdFormat);
                    if (StringHelper.StringLength(strValue) != 0) {
                        Object objValue = this.CheckInputValue(searchCtrlConfig, strValue);
                        if (objValue == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlId);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, "DataTypeError"));
                        } else {
                            String strParamKey = searchCtrlConfig.getDBField();
                            strParamKey = strParamKey.toUpperCase();
                            this.getWebContext().SetParamValue(strParamKey, strValue);
                            if (objValue.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                                Timestamp endTime = (Timestamp)objValue;
                                endTime.setTime(endTime.getTime() + 86400000L - 1L);
                            }
                            paramList.put(strParamKey, objValue);
                        }
                    }
                }
            }
            ++i;
        }
        CheckUserInputEvent checkUserInputEvent = new CheckUserInputEvent(this);
        checkUserInputEvent.setUserInputs(paramList);
        this.fireOnAfterCheckUserInput(checkUserInputEvent);
        return !this.formErrorMgr.getHasError();
    }

    protected void PutUserInputToRequest(boolean bNormal, Hashtable paramList) {
        int curCtrlMode = bNormal ? 1 : 2;
        String strPrefixId = bNormal ? "Normal_" : "Adv_";
        int nSearchItemCount = this.curSearchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
            if ((searchCtrlConfig.getSearchMode() & curCtrlMode) > 0) {
                String strIdFormat = searchCtrlConfig.getDBField();
                strIdFormat = String.valueOf(strPrefixId) + strIdFormat;
                if (searchCtrlConfig.getSearchRange()) {
                    String strParamKey;
                    String strCtrlIdFrom = String.valueOf(strIdFormat) + "_FROM";
                    String strCtrlIdTo = String.valueOf(strIdFormat) + "_TO";
                    String strValueFrom = this.GetCtrlURLValue(strCtrlIdFrom);
                    String strValueTo = this.GetCtrlURLValue(strCtrlIdTo);
                    if (StringHelper.StringLength(strValueFrom) != 0) {
                        strParamKey = String.valueOf(searchCtrlConfig.getDBField()) + "_FROM";
                        strParamKey = strParamKey.toUpperCase();
                        this.getWebContext().SetParamValue(strParamKey, strValueFrom);
                        paramList.put(strParamKey, "");
                    }
                    if (StringHelper.StringLength(strValueTo) != 0) {
                        strParamKey = String.valueOf(searchCtrlConfig.getDBField()) + "_TO";
                        strParamKey = strParamKey.toUpperCase();
                        this.getWebContext().SetParamValue(strParamKey, strValueTo);
                        paramList.put(strParamKey, "");
                    }
                } else {
                    String strCtrlId = strIdFormat.toUpperCase();
                    String strValue = this.GetCtrlURLValue(strIdFormat);
                    if (StringHelper.StringLength(strValue) != 0) {
                        String strParamKey = searchCtrlConfig.getDBField();
                        strParamKey = strParamKey.toUpperCase();
                        this.getWebContext().SetParamValue(strParamKey, strValue);
                        paramList.put(strParamKey, "");
                    }
                }
            }
            ++i;
        }
    }

    protected String GetCtrlURLValue(String strKey) {
        Object objWebCtrl = this.childCtrlList.get(strKey.toUpperCase());
        if (objWebCtrl == null) {
            return "";
        }
        if (ClassHelper.ContainClass(objWebCtrl.getClass(), IWebCtrl2.class)) {
            IWebCtrl2 interWebCtrl = (IWebCtrl2)objWebCtrl;
            return interWebCtrl.GetUrlValue();
        }
        return this.GetCtrlValue(strKey);
    }

    public boolean GetUserInput(boolean bNormal, Hashtable paramList) {
        this.formErrorMgr.Reset();
        return this.CheckUserInput(bNormal, paramList);
    }

    protected String GetInputErrorMsg(SearchCtrlConfig searchCtrlConfig, boolean bFrom, String errorType) {
        String strRangeName = bFrom ? "\u8d77\u59cb\u503c" : "\u7ed3\u675f\u503c";
        String strCaption = String.valueOf(searchCtrlConfig.getCaption()) + strRangeName;
        return this.GetInputErrorMsg(strCaption, searchCtrlConfig, errorType);
    }

    protected String GetCompareErrorMsg(SearchCtrlConfig searchCtrlConfig) {
        String strUserErrorMsg = searchCtrlConfig.getCompareErrorMsg();
        if (StringHelper.StringLength(strUserErrorMsg) == 0) {
            strUserErrorMsg = String.format("%1$s[\u8d77\u59cb\u503c]\u5927\u4e8e[\u7ed3\u675f\u503c]", searchCtrlConfig.getCaption());
        }
        return strUserErrorMsg;
    }

    @Override
    public void OnButtonClick(EventObject buttonClickEvent) {
        if (buttonClickEvent.getSource() == this.normalSearch) {
            this.DoUserSearch(true);
            return;
        }
        if (buttonClickEvent.getSource() == this.advSearch) {
            this.DoUserSearch(false);
            return;
        }
    }
}

