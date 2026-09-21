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

@CodeList(id="D6134C26-F92E-4F05-BBEF-D397D07F015F", name="\u7cfb\u7edf\u8fd0\u884c\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSINFO", text="\u7cfb\u7edf\u4fe1\u606f", realtext="\u7cfb\u7edf\u4fe1\u606f"), @CodeItem(value="SYSDEINFO", text="\u7cfb\u7edf\u5b9e\u4f53\u4fe1\u606f", realtext="\u7cfb\u7edf\u5b9e\u4f53\u4fe1\u606f")})
public class SysRTMsgTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSINFO = "SYSINFO";
    public static final String SYSDEINFO = "SYSDEINFO";

    public SysRTMsgTypeCodeListModel() {
        this.initAnnotation(SysRTMsgTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRTMsgTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysRTMsgTypeCodeListModel");
    }
}

