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

@CodeList(id="1766BF6F-A3FD-4CEB-98C0-8E9A6711CB14", name="\u5de5\u5177Console\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="COMMAND", text="\u547d\u4ee4\u6d88\u606f", realtext="\u547d\u4ee4\u6d88\u606f"), @CodeItem(value="CONSOLE", text="\u63a7\u5236\u53f0\u6d88\u606f", realtext="\u63a7\u5236\u53f0\u6d88\u606f")})
public class StudioConsoleMsgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String COMMAND = "COMMAND";
    public static final String CONSOLE = "CONSOLE";

    public StudioConsoleMsgTypeCodeListModel() {
        this.initAnnotation(StudioConsoleMsgTypeCodeListModel.class);
        this.setUserData2("StudioConsoleMsgType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioConsoleMsgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioConsoleMsgTypeCodeListModel");
    }
}

