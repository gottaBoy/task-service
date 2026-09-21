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

@CodeList(id="cb00799a521c268edd53a84b2b731812", name="\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b\u540c\u6b65\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="IGNORE", text="\u4e0d\u540c\u6b65", realtext="\u4e0d\u540c\u6b65"), @CodeItem(value="TODE", text="\u540c\u6b65\u5230\u5b9e\u4f53", realtext="\u540c\u6b65\u5230\u5b9e\u4f53", userdata="\u5c06\u670d\u52a1\u63a5\u53e3\u5b9e\u4f53\u7684\u4fe1\u606f\u540c\u6b65\u81f3\u7cfb\u7edf\u5b9e\u4f53")})
public class SADESyncModeCodeListModel
extends StaticCodeListModelBase {
    public static final String IGNORE = "IGNORE";
    public static final String TODE = "TODE";

    public SADESyncModeCodeListModel() {
        this.initAnnotation(SADESyncModeCodeListModel.class);
        this.setUserData2("SADESyncMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SADESyncModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SADESyncModeCodeListModel");
    }
}

