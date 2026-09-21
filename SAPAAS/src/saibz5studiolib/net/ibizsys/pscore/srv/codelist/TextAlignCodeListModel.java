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

@CodeList(id="f688fe28a5296cd46618eaa81a165665", name="\u5185\u5bb9\u6c34\u5e73\u5bf9\u9f50\u65b9\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u5bf9\u9f50", realtext="\u5de6\u5bf9\u9f50"), @CodeItem(value="CENTER", text="\u5c45\u4e2d", realtext="\u5c45\u4e2d"), @CodeItem(value="RIGHT", text="\u53f3\u5bf9\u9f50", realtext="\u53f3\u5bf9\u9f50"), @CodeItem(value="JUSTIFY", text="\u4e24\u7aef\u5bf9\u9f50", realtext="\u4e24\u7aef\u5bf9\u9f50")})
public class TextAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String CENTER = "CENTER";
    public static final String RIGHT = "RIGHT";
    public static final String JUSTIFY = "JUSTIFY";

    public TextAlignCodeListModel() {
        this.initAnnotation(TextAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("TextAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TextAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TextAlignCodeListModel");
    }
}

