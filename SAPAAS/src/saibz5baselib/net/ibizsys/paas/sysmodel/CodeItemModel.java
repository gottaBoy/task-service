/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.sysmodel.ICodeItemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

public class CodeItemModel
extends ModelBase3Impl
implements ICodeItemModel {
    protected ArrayList<ICodeItem> childCodeItemList = new ArrayList();
    protected ICodeList iCodeList;
    protected ICodeItem parentCodeItem;
    private String strText = "";
    private String strValue;
    private String strRealText = "";
    private String strParentValue = "";
    private String strColor = "";
    private String strIconPath = "";
    private String strIconCls = "";
    private String strTextCls = "";
    private String strIconPathX = "";
    private String strIconClsX = "";
    private String strMemo = "";
    private String strUserData = "";
    private String strUserData2 = "";
    private boolean bDisableSelect = false;
    private String strTextLanResTag = "";

    public void init(ICodeList iCodeList, ICodeItem parentCodeItem, CodeItem codeItem) {
        this.iCodeList = iCodeList;
        this.parentCodeItem = parentCodeItem;
        if (codeItem != null) {
            this.setRealText(codeItem.realtext());
            this.setText(codeItem.text());
            this.setValue(codeItem.value());
            this.setParentValue(codeItem.parentvalue());
            this.setTextLanResTag(codeItem.textlanrestag());
            this.setTextCls(codeItem.textcls());
            this.setIconCls(codeItem.iconcls());
            this.setIconClsX(codeItem.iconclsx());
            this.setIconPath(codeItem.iconpath());
            this.setIconPathX(codeItem.iconpathx());
            this.setUserData(codeItem.userdata());
            this.setUserData2(codeItem.userdata2());
            this.setDisableSelect(codeItem.disableselect());
        }
    }

    @Override
    public ICodeList getCodeList() {
        return this.iCodeList;
    }

    @Override
    public ICodeItem getParentCodeItem() {
        return this.parentCodeItem;
    }

    @Override
    public Iterator<ICodeItem> getCodeItems() throws Exception {
        return this.childCodeItemList.iterator();
    }

    public void registerChildCodeItemModel(CodeItemModel codeItemModel) {
        this.childCodeItemList.add(codeItemModel);
    }

    @Override
    public String getText() {
        return this.strText;
    }

    public void setText(String strText) {
        this.strText = strText;
    }

    @Override
    public String getValue() {
        return this.strValue;
    }

    public void setValue(String strValue) {
        this.strValue = strValue;
    }

    @Override
    public String getRealText() {
        if (StringHelper.isNullOrEmpty(this.strRealText)) {
            return this.getText();
        }
        return this.strRealText;
    }

    public void setRealText(String strRealText) {
        this.strRealText = strRealText;
    }

    @Override
    public String getParentValue() {
        return this.strParentValue;
    }

    public void setParentValue(String strParentValue) {
        this.strParentValue = strParentValue;
    }

    @Override
    public String getColor() {
        return this.strColor;
    }

    @Override
    public String getIconPath() {
        return this.strIconPath;
    }

    @Override
    public String getIconPathX() {
        return this.strIconPathX;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    public void setColor(String strColor) {
        this.strColor = strColor;
    }

    public void setIconPath(String strIconPath) {
        this.strIconPath = strIconPath;
    }

    public void setIconPathX(String strIconPathX) {
        this.strIconPathX = strIconPathX;
    }

    public void setMemo(String strMemo) {
        this.strMemo = strMemo;
    }

    @Override
    public String getIconCls() {
        return this.strIconCls;
    }

    public void setIconCls(String strIconCls) {
        this.strIconCls = strIconCls;
    }

    @Override
    public String getIconClsX() {
        return this.strIconClsX;
    }

    public void setIconClsX(String strIconClsX) {
        this.strIconClsX = strIconClsX;
    }

    @Override
    public String getTextCls() {
        return this.strTextCls;
    }

    public void setTextCls(String strTextCls) {
        this.strTextCls = strTextCls;
    }

    @Override
    public ICodeItem getCodeItemByText(String strText) throws Exception {
        return this.getCodeItemByText(strText, true);
    }

    @Override
    public ICodeItem getCodeItem(String strValue) throws Exception {
        return this.getCodeItem(strValue, true);
    }

    @Override
    public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
        for (ICodeItem iCodeItem : this.childCodeItemList) {
            if (StringHelper.compare(iCodeItem.getText(), strText, false) != 0) continue;
            return iCodeItem;
        }
        if (bRecursion) {
            for (ICodeItem iCodeItem : this.childCodeItemList) {
                ICodeItem childItem = iCodeItem.getCodeItemByText(strText, bRecursion);
                if (childItem == null) continue;
                return childItem;
            }
        }
        return null;
    }

    @Override
    public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
        for (ICodeItem iCodeItem : this.childCodeItemList) {
            if (StringHelper.compare(iCodeItem.getValue(), strValue, false) != 0) continue;
            return iCodeItem;
        }
        if (bRecursion) {
            for (ICodeItem iCodeItem : this.childCodeItemList) {
                ICodeItem childItem = iCodeItem.getCodeItem(strValue, bRecursion);
                if (childItem == null) continue;
                return childItem;
            }
        }
        return null;
    }

    @Override
    public String getUserData() {
        return this.strUserData;
    }

    @Override
    public String getUserData2() {
        return this.strUserData2;
    }

    public void setUserData(String strUserData) {
        this.strUserData = strUserData;
    }

    public void setUserData2(String strUserData2) {
        this.strUserData2 = strUserData2;
    }

    @Override
    public String getIconPath(int nX) {
        if (nX == 1) {
            return this.getIconPath();
        }
        if (StringHelper.isNullOrEmpty(this.getIconPathX())) {
            return this.getIconPath();
        }
        return this.getIconPathX().replace("{0}", StringHelper.format("%1$s", nX));
    }

    @Override
    public String getIconCls(int nX) {
        if (nX == 1) {
            return this.getIconCls();
        }
        if (StringHelper.isNullOrEmpty(this.getIconClsX())) {
            return this.getIconCls();
        }
        return this.getIconClsX().replace("{0}", StringHelper.format("%1$s", nX));
    }

    @Override
    public boolean isDisableSelect() {
        return this.bDisableSelect;
    }

    public void setDisableSelect(boolean bDisableSelect) {
        this.bDisableSelect = bDisableSelect;
    }

    @Override
    public String getTextLanResTag() {
        return this.strTextLanResTag;
    }

    public void setTextLanResTag(String strTextLanResTag) {
        this.strTextLanResTag = strTextLanResTag;
    }

    @Override
    public String getText(Locale locale) {
        if (!StringHelper.isNullOrEmpty(this.getTextLanResTag()) && WebContext.getCurrent() != null) {
            return WebContext.getCurrent().getLocalization(this.getTextLanResTag(), this.getText(), locale);
        }
        return this.getText();
    }

    @Override
    public String getRealText(Locale locale) {
        return this.getRealText();
    }
}

