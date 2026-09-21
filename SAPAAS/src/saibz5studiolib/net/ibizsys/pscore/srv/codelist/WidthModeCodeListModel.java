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

@CodeList(id="D9FBAC51-6A83-40E6-8492-B1B7323C67EB", name="\u5185\u5bb9\u5bbd\u5ea6\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AUTO", text="\u81ea\u52a8", realtext="\u81ea\u52a8"), @CodeItem(value="FULL", text="\u5168\u90e8\u5bbd\u5ea6", realtext="\u5168\u90e8\u5bbd\u5ea6"), @CodeItem(value="PX", text="\u50cf\u7d20", realtext="\u50cf\u7d20"), @CodeItem(value="PERCENTAGE", text="\u767e\u5206\u6bd4", realtext="\u767e\u5206\u6bd4")})
public class WidthModeCodeListModel
extends StaticCodeListModelBase {
    public static final String AUTO = "AUTO";
    public static final String FULL = "FULL";
    public static final String PX = "PX";
    public static final String PERCENTAGE = "PERCENTAGE";

    public WidthModeCodeListModel() {
        this.initAnnotation(WidthModeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("WidthMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.WidthModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.WidthModeCodeListModel");
    }
}

