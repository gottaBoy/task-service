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

@CodeList(id="DCCD1023-5353-48B7-A388-4702840EC4DB", name="\u90e8\u4ef6\u52a8\u6001\u7cfb\u7edf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u4e0d\u542f\u7528\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4e0d\u542f\u7528", realtext="\u4e0d\u542f\u7528"), @CodeItem(value="1", text="\u542f\u7528", realtext="\u542f\u7528"), @CodeItem(value="2", text="\u542f\u52a8\uff08\u9ad8\u7ea7\uff09", realtext="\u542f\u52a8\uff08\u9ad8\u7ea7\uff09")})
public class ControlDynaSysModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer DISABLED = 0;
    public static final int INT_DISABLED = 0;
    public static final Integer ENABLED = 1;
    public static final int INT_ENABLED = 1;
    public static final Integer ADVANCED = 2;
    public static final int INT_ADVANCED = 2;

    public ControlDynaSysModeCodeListModel() {
        this.initAnnotation(ControlDynaSysModeCodeListModel.class);
        this.setUserData2("ControlDynaSysMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlDynaSysModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ControlDynaSysModeCodeListModel");
    }
}

