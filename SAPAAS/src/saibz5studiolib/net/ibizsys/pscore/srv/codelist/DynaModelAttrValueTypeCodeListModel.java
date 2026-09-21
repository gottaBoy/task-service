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

@CodeList(id="e2e46128cc96af5b26ce5963de804405", name="\u7cfb\u7edf\u52a8\u6001\u6a21\u578b\u503c\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="VALUE", text="\u76f4\u63a5\u503c", realtext="\u76f4\u63a5\u503c", userdata="\u503c\u6765\u81ea\u5f53\u524d\u5c5e\u6027\u5b9a\u4e49"), @CodeItem(value="OBJECT", text="\u6a21\u578b\u5bf9\u8c61", realtext="\u6a21\u578b\u5bf9\u8c61", userdata="\u503c\u4e3a\u5f15\u7528\u7684\u52a8\u6001\u6a21\u578b\u5bf9\u8c61"), @CodeItem(value="DE", text="\u5b9e\u4f53\u5bf9\u8c61", realtext="\u5b9e\u4f53\u5bf9\u8c61", userdata="\u503c\u4e3a\u5f15\u7528\u7684\u5b9e\u4f53\u5bf9\u8c61")})
public class DynaModelAttrValueTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String VALUE = "VALUE";
    public static final String OBJECT = "OBJECT";
    public static final String DE = "DE";

    public DynaModelAttrValueTypeCodeListModel() {
        this.initAnnotation(DynaModelAttrValueTypeCodeListModel.class);
        this.setUserData2("DynaModelAttrValueType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelAttrValueTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DynaModelAttrValueTypeCodeListModel");
    }
}

