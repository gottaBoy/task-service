/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.jsp.JspWriter
 */
package SA.SRFramework.Web;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.Builder.SearchInfoFormBuilder;
import SA.SRFramework.Web.SRFBaseForm;
import SA.SRFramework.Web.SRFText;
import SA.SRFramework.Web.UI.SearchCtrlConfig;
import SA.SRFramework.Web.UI.SearchFormConfig;
import SA.SRFramework.Web.UI.WebCtrlTags;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.servlet.jsp.JspWriter;

public class SRFSearchInfoForm
extends SRFBaseForm {
    protected SearchFormConfig curSearchFormConfig = null;
    protected SearchInfoFormBuilder sifBuilder = null;
    protected Hashtable paramList = new Hashtable();

    public void setConfig(SearchFormConfig value) {
        this.curSearchFormConfig = value;
    }

    public Hashtable GetParamList() {
        return this.paramList;
    }

    public boolean ConfigBind() {
        if (this.curSearchFormConfig != null) {
            ArrayList<String> IdList = new ArrayList<String>();
            int i = 0;
            while (i < this.curSearchFormConfig.getSearchItems().size()) {
                SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
                if ((searchCtrlConfig.getSearchMode() & this.getWebContext().getSearch()) > 0) {
                    String strIdFormat = searchCtrlConfig.getDBField();
                    strIdFormat = "INFO_" + strIdFormat;
                    if (searchCtrlConfig.getSearchRange()) {
                        IdList.add(String.valueOf(strIdFormat) + "_FROM");
                        IdList.add(String.valueOf(strIdFormat) + "_TO");
                    } else {
                        IdList.add(strIdFormat);
                    }
                }
                int j = 0;
                while (j < IdList.size()) {
                    String strIdFormat = (String)IdList.get(j);
                    SRFText text = new SRFText();
                    text.setID(strIdFormat);
                    text.setText("(\u5168\u90e8)");
                    this.sifBuilder.BindCtrlStyle(text, searchCtrlConfig);
                    this.AddControl(text);
                    this.childCtrlList.put(strIdFormat.toUpperCase(), text);
                    ++j;
                }
                IdList.clear();
                ++i;
            }
        }
        this.InitFromWebRequest();
        return true;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.sifBuilder = this.GetSearchInfoFormBuilder();
    }

    protected void InitFromWebRequest() {
        int nSearchItemCount = this.curSearchFormConfig.getSearchItems().size();
        int i = 0;
        while (i < nSearchItemCount) {
            SearchCtrlConfig searchCtrlConfig = (SearchCtrlConfig)this.curSearchFormConfig.getSearchItems().get(i);
            if ((searchCtrlConfig.getSearchMode() & this.getWebContext().getSearch()) != 0) {
                if (searchCtrlConfig.getSearchRange()) {
                    String strParamKey;
                    String strRequestValueFrom = this.getWebContext().GetParamValue(String.valueOf(searchCtrlConfig.getDBField().toUpperCase()) + "_FROM");
                    String strRequestValueTo = this.getWebContext().GetParamValue(String.valueOf(searchCtrlConfig.getDBField().toUpperCase()) + "_TO");
                    String strRequestValueFromText = strRequestValueFrom;
                    String strRequestValueToText = strRequestValueTo;
                    if (searchCtrlConfig.getCtrlStyle() == 7 || searchCtrlConfig.getCtrlStyle() == 6) {
                        String strTempValue;
                        int nPos;
                        String strSeparator = searchCtrlConfig.GetExtValue(WebCtrlTags.SEPARATOR, "|");
                        if (StringHelper.Length(strSeparator) != 1) {
                            strSeparator = "|";
                        }
                        if ((nPos = strRequestValueFrom.indexOf(strSeparator)) != -1) {
                            strTempValue = strRequestValueFrom;
                            strRequestValueFrom = strTempValue.substring(0, nPos);
                            strRequestValueFromText = strTempValue.substring(nPos + 1);
                        }
                        if ((nPos = strRequestValueTo.indexOf(strSeparator)) != -1) {
                            strTempValue = strRequestValueTo;
                            strRequestValueTo = strTempValue.substring(0, nPos);
                            strRequestValueToText = strTempValue.substring(nPos + 1);
                        }
                    }
                    Object objValueFrom = null;
                    Object objValueTo = null;
                    String strCtrlIdFrom = String.valueOf(searchCtrlConfig.getDBField()) + "_FROM";
                    String strCtrlIdTo = String.valueOf(searchCtrlConfig.getDBField()) + "_TO";
                    strCtrlIdFrom = strCtrlIdFrom.toUpperCase();
                    strCtrlIdTo = strCtrlIdTo.toUpperCase();
                    if (StringHelper.StringLength(strRequestValueFrom) != 0) {
                        this.FillCtrlsValue(strCtrlIdFrom, strRequestValueFromText);
                        objValueFrom = this.CheckInputValue(searchCtrlConfig, strRequestValueFrom);
                        if (objValueFrom == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlIdFrom);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, true, "DataTypeError"));
                        } else {
                            strParamKey = strCtrlIdFrom;
                            strParamKey = strParamKey.toUpperCase();
                            this.paramList.put(strParamKey, objValueFrom);
                        }
                    }
                    if (StringHelper.StringLength(strRequestValueTo) != 0) {
                        this.FillCtrlsValue(strCtrlIdTo, strRequestValueToText);
                        objValueTo = this.CheckInputValue(searchCtrlConfig, strRequestValueTo);
                        if (objValueTo == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlIdTo);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, false, "DataTypeError"));
                        } else {
                            strParamKey = strCtrlIdTo;
                            strParamKey = strParamKey.toUpperCase();
                            if (objValueTo.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                                Timestamp endTime = (Timestamp)objValueTo;
                                endTime.setTime(endTime.getTime() + 86400000L - 1L);
                            }
                            this.paramList.put(strParamKey, objValueTo);
                        }
                    }
                    if (objValueFrom != null && objValueTo != null && searchCtrlConfig.getCompareCheck() && !DataTypeParse.LessThan(searchCtrlConfig.getDBType(), objValueFrom, objValueTo)) {
                        this.formErrorMgr.AddErrorInput(strCtrlIdFrom);
                        this.formErrorMgr.AddErrorInput(strCtrlIdTo);
                        this.formErrorMgr.AppendErrorMsg(this.GetCompareErrorMsg(searchCtrlConfig));
                    }
                } else {
                    String strRequestValue;
                    String strRequestValueText = strRequestValue = this.getWebContext().GetParamValue(searchCtrlConfig.getDBField().toUpperCase());
                    if (searchCtrlConfig.getCtrlStyle() == 7 || searchCtrlConfig.getCtrlStyle() == 6) {
                        int nPos;
                        String strSeparator = searchCtrlConfig.GetExtValue(WebCtrlTags.SEPARATOR, "|");
                        if (StringHelper.Length(strSeparator) != 1) {
                            strSeparator = "|";
                        }
                        if ((nPos = strRequestValue.indexOf(strSeparator)) != -1) {
                            String strTempValue = strRequestValue;
                            strRequestValue = strTempValue.substring(0, nPos);
                            strRequestValueText = strTempValue.substring(nPos + 1);
                        }
                    }
                    if (StringHelper.StringLength(strRequestValue) != 0) {
                        String strCtrlId = searchCtrlConfig.getDBField().toUpperCase();
                        this.FillCtrlsValue(strCtrlId, strRequestValueText);
                        Object objValue = this.CheckInputValue(searchCtrlConfig, strRequestValue);
                        if (objValue == null) {
                            this.formErrorMgr.AddErrorInput(strCtrlId);
                            this.formErrorMgr.AppendErrorMsg(this.GetInputErrorMsg(searchCtrlConfig, "DataTypeError"));
                        } else {
                            String strParamKey = searchCtrlConfig.getDBField();
                            strParamKey = strParamKey.toUpperCase();
                            if (objValue.getClass().getName().equals("java.sql.Timestamp") && searchCtrlConfig.GetExtValue("ENDOFDAY", false)) {
                                Timestamp endTime = (Timestamp)objValue;
                                endTime.setTime(endTime.getTime() + 86400000L - 1L);
                            }
                            this.paramList.put(strParamKey, objValue);
                        }
                    }
                }
            }
            ++i;
        }
    }

    protected void FillCtrlsValue(String strKey, String strValue) {
        String strTextKey = "INFO_" + strKey;
        Object objWebCtrl = this.childCtrlList.get(strTextKey.toUpperCase());
        if (objWebCtrl == null) {
            return;
        }
        SRFText text = (SRFText)objWebCtrl;
        text.setText(strValue);
    }

    @Override
    protected void OnRender(JspWriter output) {
        try {
            output.println("<!-- SearchForm:Start -->");
            if (this.sifBuilder == null) {
                output.println("<!-- Invalid searchinfoform-builder -->");
            } else {
                this.sifBuilder.setControlId(this.getUniqueID());
                this.sifBuilder.setCurWebContext(this.getWebContext());
                this.sifBuilder.setShowView(this.getWebContext().getSearch());
                this.sifBuilder.setChildCtrls(this.childCtrlList);
                this.sifBuilder.setSFConfig(this.curSearchFormConfig);
                this.sifBuilder.setFormError(this.formErrorMgr);
                this.sifBuilder.Render(output);
            }
            output.println("<!-- SearchForm:End -->");
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected SearchInfoFormBuilder GetSearchInfoFormBuilder() {
        return this.getWebContext().getCurThemeConfig().GetSearchInfoFormBuilder();
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
}

