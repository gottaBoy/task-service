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

@CodeList(id="2B10C14E-2318-4B3F-8086-5A350C4BB154", name="\u7cfb\u7edf\u7528\u6237\u89d2\u8272\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CUSTOM", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", realtext="\u5b9e\u4f53\u6570\u636e\u96c6\u5408", userdata="\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u96c6\u5408")})
public class SysUserRoleTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String CUSTOM = "CUSTOM";
    public static final String DEDATASET = "DEDATASET";

    public SysUserRoleTypeCodeListModel() {
        this.initAnnotation(SysUserRoleTypeCodeListModel.class);
        this.setUserData2("SysUserRoleType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUserRoleTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysUserRoleTypeCodeListModel");
    }
}

