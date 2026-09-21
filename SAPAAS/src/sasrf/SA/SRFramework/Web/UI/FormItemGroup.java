/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web.UI;

import SA.SRFramework.Utility.ClassHelper;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.UI.BaseFormItemGroup;
import SA.SRFramework.Web.UI.FormItemConfig;
import SA.SRFramework.Web.UI.FormItemExConfig;
import org.w3c.dom.Node;

public class FormItemGroup
extends BaseFormItemGroup {
    protected static String NAME = "NAME";
    protected static String FORMITEMEX = "FORMITEMEX";
    protected static String SHOWHIDE = "SHOWHIDE";
    protected static String SHOW = "SHOW";
    protected String strCaption = "";
    protected boolean bShowHideMode = true;
    protected boolean bShow = true;

    public FormItemGroup() {
        this.strId = Helper.GenGuid();
    }

    public String getCaption() {
        return this.strCaption;
    }

    public boolean getShowHideMode() {
        return this.bShowHideMode;
    }

    public boolean getShow() {
        return this.bShow;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (strName.compareToIgnoreCase(NAME) == 0) {
            this.strCaption = strValue;
            return;
        }
        if (strName.compareToIgnoreCase(SHOWHIDE) == 0) {
            this.bShowHideMode = FormItemGroup.GetValue(strValue, this.bShowHideMode);
            return;
        }
        if (strName.compareToIgnoreCase(SHOW) == 0) {
            this.bShow = FormItemGroup.GetValue(strValue, this.bShow);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (strName.compareToIgnoreCase(FORMITEMEX) == 0) {
            FormItemExConfig formItemEx = new FormItemExConfig();
            if (formItemEx.LoadConfig(xmlNode)) {
                this.groupItemList.add(formItemEx);
            }
            return;
        }
        if (strName.compareToIgnoreCase(FORMITEM) == 0) {
            FormItemConfig formItemConfig = new FormItemConfig();
            if (formItemConfig.LoadConfig(xmlNode)) {
                String strGroupId = formItemConfig.getGroup();
                if (StringHelper.Length(strGroupId) == 0) {
                    this.groupItemList.add(formItemConfig);
                } else {
                    FormItemExConfig formItemEx = this.FindFormItemEx(strGroupId);
                    if (formItemEx == null) {
                        int nCount = this.groupItemList.size();
                        int i = 0;
                        while (i < nCount) {
                            FormItemConfig temp;
                            Object obj = this.groupItemList.get(i);
                            if (ClassHelper.ContainClass(obj.getClass(), FormItemConfig.class) && (temp = (FormItemConfig)obj).getID().compareToIgnoreCase(strGroupId) == 0) {
                                formItemEx = new FormItemExConfig();
                                formItemEx.setID(temp.getID());
                                formItemEx.setCaption(temp.getCaption());
                                formItemEx.setAllowEmpty(temp.getAllowEmpty());
                                formItemEx.setSingleRow(temp.getSingleRow());
                                this.groupItemList.set(i, formItemEx);
                                formItemEx.getItems().add(temp);
                                break;
                            }
                            ++i;
                        }
                    }
                    if (formItemEx == null) {
                        this.groupItemList.add(formItemConfig);
                    } else {
                        formItemConfig.setGroup(formItemEx.getID());
                        formItemEx.getItems().add(formItemConfig);
                    }
                }
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    protected FormItemExConfig FindFormItemEx(String strId) {
        int nCount = this.groupItemList.size();
        int i = 0;
        while (i < nCount) {
            Object obj = this.groupItemList.get(i);
            if (ClassHelper.ContainClass(obj.getClass(), FormItemExConfig.class)) {
                return (FormItemExConfig)obj;
            }
            ++i;
        }
        return null;
    }
}

