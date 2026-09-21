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

@CodeList(id="f64cc9f553c12812183ea536ec3c4a1b", name="\u8868\u5355\u5206\u9875\u4f4d\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="LEFT", text="\u5de6\u8fb9", realtext="\u5de6\u8fb9"), @CodeItem(value="TOP", text="\u4e0a\u65b9", realtext="\u4e0a\u65b9"), @CodeItem(value="RIGHT", text="\u53f3\u8fb9", realtext="\u53f3\u8fb9"), @CodeItem(value="BOTTOM", text="\u4e0b\u65b9", realtext="\u4e0b\u65b9")})
public class FormTabHeaderPosCodeListModel
extends StaticCodeListModelBase {
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";
    public static final String RIGHT = "RIGHT";
    public static final String BOTTOM = "BOTTOM";

    public FormTabHeaderPosCodeListModel() {
        this.initAnnotation(FormTabHeaderPosCodeListModel.class);
        this.setUserData("IGNOREMODELDSLNAME");
        this.setUserData2("TabHeaderPos");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTabHeaderPosCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormTabHeaderPosCodeListModel");
    }
}

