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

@CodeList(id="9eec4752f9360f733aa4920f7c4b0006", name="\u4efb\u52a1\u670d\u52a1\u5668\u6253\u5305\u90e8\u7f72\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u672c\u5730", realtext="\u672c\u5730"), @CodeItem(value="2", text="\u8fdc\u7aef", realtext="\u8fdc\u7aef"), @CodeItem(value="3", text="\u672c\u5730\u53ca\u8fdc\u7aef", realtext="\u672c\u5730\u53ca\u8fdc\u7aef")})
public class DevSysDeployModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer LOCAL = 1;
    public static final int INT_LOCAL = 1;
    public static final Integer REMOTE = 2;
    public static final int INT_REMOTE = 2;
    public static final Integer LOCALANDREMOTE = 3;
    public static final int INT_LOCALANDREMOTE = 3;

    public DevSysDeployModeCodeListModel() {
        this.initAnnotation(DevSysDeployModeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysDeployModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevSysDeployModeCodeListModel");
    }
}

