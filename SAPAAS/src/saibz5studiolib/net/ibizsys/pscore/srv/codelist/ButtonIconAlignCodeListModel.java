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

@CodeList(id="feba7e77e4bb4150fa50aaf5c9e79526", name="\u6309\u94ae\u56fe\u6807\u65b9\u5411", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u4fa7", realtext="\u5de6\u4fa7"), @CodeItem(value="TOP", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="RIGHT", text="\u53f3\u4fa7", realtext="\u53f3\u4fa7"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9")})
public class ButtonIconAlignCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";
    public static final String RIGHT = "RIGHT";
    public static final String BOTTOM = "BOTTOM";

    public ButtonIconAlignCodeListModel() {
        this.initAnnotation(ButtonIconAlignCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("ButtonIconAlign");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonIconAlignCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ButtonIconAlignCodeListModel");
    }
}

