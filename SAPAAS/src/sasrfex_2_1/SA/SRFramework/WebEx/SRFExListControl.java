/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.Web.ListItemCollection
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.Web.ListItemCollection;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.UI.ListControlConfig;
import SA.SRFramework.WebEx.UI.ListFillerConfig;
import java.util.ArrayList;

public abstract class SRFExListControl
extends SRFExFormItem {
    protected ListControlConfig listControlConfig = null;
    protected String strSelectValue = "";
    protected boolean bInitListItem = false;

    public ListControlConfig getListControlConfig() {
        return this.listControlConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.listControlConfig = null;
        if (this.config != null && this.config instanceof ListControlConfig) {
            this.listControlConfig = (ListControlConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        this.InitListItems();
        super.OnReloadConfig();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    protected void AppendCodeListItem(String strPreFix, CodeItemConfig codeItemConfig) {
        ListItem listItem = new ListItem(String.valueOf(strPreFix) + codeItemConfig.getText(), codeItemConfig.getValue());
        listItem.setDisabled(codeItemConfig.getDisabled());
        this.listControlConfig.getListItems().Add(listItem);
        ArrayList list = codeItemConfig.getCodeItems();
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                CodeItemConfig codeItem2Config = (CodeItemConfig)((Object)list.get(i));
                this.AppendCodeListItem("&nbsp;&nbsp;&nbsp;&nbsp;" + strPreFix, codeItem2Config);
                ++i;
            }
        }
    }

    protected void InitListItems() {
        ListFillerConfig listFillerConfig;
        if (this.bInitListItem) {
            return;
        }
        this.bInitListItem = true;
        if (this.listControlConfig != null && (listFillerConfig = this.listControlConfig.getListFillerConfig()) != null && !listFillerConfig.isFill()) {
            ArrayList list;
            CodeListConfig codeListConfig;
            if (StringHelper.Length((String)listFillerConfig.getCodeList()) > 0 && (codeListConfig = this.getPage().getWebContext().getCodeListMgr().GetCodeListConfig(listFillerConfig.getCodeList(), this.getWebContext().getLocalization())) != null && (list = codeListConfig.getCodeItems()) != null) {
                int i = 0;
                while (i < list.size()) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)((Object)list.get(i));
                    this.AppendCodeListItem("", codeItemConfig);
                    ++i;
                }
            }
            if (StringHelper.Length((String)listFillerConfig.getRawCodeList()) > 0) {
                String[] sets = listFillerConfig.getRawCodeList().split("[;]");
                int i = 0;
                while (i < sets.length) {
                    String[] keyvalue;
                    String strTemp = sets[i].trim();
                    if (!(StringHelper.IsNullOrEmpty((String)strTemp) || (keyvalue = strTemp.split("[|]")).length != 2 || StringHelper.IsNullOrEmpty((String)keyvalue[0]) || StringHelper.IsNullOrEmpty((String)keyvalue[1]))) {
                        this.listControlConfig.getListItems().Add(new ListItem(keyvalue[0], keyvalue[1]));
                    }
                    ++i;
                }
            }
            if (listFillerConfig.getEmptySupported()) {
                ListItem listItem = new ListItem(listFillerConfig.getEmptyText(), "");
                if (listFillerConfig.getEmptyAtFirst()) {
                    this.listControlConfig.getListItems().Insert(0, listItem);
                } else {
                    this.listControlConfig.getListItems().Add(listItem);
                }
            }
            listFillerConfig.setFill(true);
        }
    }

    public ListItemCollection getListItems() {
        if (this.listControlConfig == null) {
            return null;
        }
        return this.listControlConfig.getListItems();
    }
}

