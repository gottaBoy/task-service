/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItem
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  net.ibizsys.paas.sysmodel.StaticCodeListModelBase
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="fb75fe1996cd70c96e39c94e87ca1cff", name="\u4ee3\u7801\u8868\u8f93\u51fa\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u53ea\u8f93\u51fa\u9009\u62e9\u9879", realtext="\u53ea\u8f93\u51fa\u9009\u62e9\u9879"), @CodeItem(value="2", text="\u8f93\u51fa\u5b50\u9879", realtext="\u8f93\u51fa\u5b50\u9879")})
public class OutputCodeListConfigModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer SELECTEDONLY = 1;
    public static final int INT_SELECTEDONLY = 1;
    public static final Integer INCLUDECHILD = 2;
    public static final int INT_INCLUDECHILD = 2;

    public OutputCodeListConfigModeCodeListModel() {
        this.initAnnotation(OutputCodeListConfigModeCodeListModel.class);
        this.setUserData2("OutputCodeListMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.OutputCodeListConfigModeCodeListModel");
    }
}

