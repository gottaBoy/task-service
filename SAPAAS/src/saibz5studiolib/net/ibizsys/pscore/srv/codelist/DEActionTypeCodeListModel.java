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

@CodeList(id="66b0ad41d57d12ea8e7d9643712067c0", name="\u4e91\u5b9e\u4f53\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSDBPROC", text="\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b", realtext="\u7cfb\u7edf\u5b58\u50a8\u8fc7\u7a0b"), @CodeItem(value="USERDBPROC", text="\u7528\u6237\u5b58\u50a8\u8fc7\u7a0b", realtext="\u7528\u6237\u5b58\u50a8\u8fc7\u7a0b"), @CodeItem(value="USERCUSTOM", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91"), @CodeItem(value="BUILTIN", text="\u5185\u7f6e\u65b9\u6cd5", realtext="\u5185\u7f6e\u65b9\u6cd5"), @CodeItem(value="USERCREATE", text="\u7528\u6237\u6269\u5c55\u5efa\u7acb", realtext="\u7528\u6237\u6269\u5c55\u5efa\u7acb"), @CodeItem(value="USERUPDATE", text="\u7528\u6237\u6269\u5c55\u66f4\u65b0", realtext="\u7528\u6237\u6269\u5c55\u66f4\u65b0"), @CodeItem(value="USERSYSUPDATE", text="\u7528\u6237\u6269\u5c55\u7cfb\u7edf\u66f4\u65b0", realtext="\u7528\u6237\u6269\u5c55\u7cfb\u7edf\u66f4\u65b0")})
public class DEActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSDBPROC = "SYSDBPROC";
    public static final String USERDBPROC = "USERDBPROC";
    public static final String USERCUSTOM = "USERCUSTOM";
    public static final String DELOGIC = "DELOGIC";
    public static final String BUILTIN = "BUILTIN";
    public static final String USERCREATE = "USERCREATE";
    public static final String USERUPDATE = "USERUPDATE";
    public static final String USERSYSUPDATE = "USERSYSUPDATE";

    public DEActionTypeCodeListModel() {
        this.initAnnotation(DEActionTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionTypeCodeListModel");
    }
}

