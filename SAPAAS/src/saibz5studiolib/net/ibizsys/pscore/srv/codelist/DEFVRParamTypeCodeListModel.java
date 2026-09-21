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

@CodeList(id="bb678309947d60f846cfb8915fde9756", name="\u5b9e\u4f53\u5c5e\u6027\u503c\u89c4\u5219\u6761\u4ef6\u53c2\u6570\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ENTITYFIELD", text="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", realtext="\u6570\u636e\u5bf9\u8c61\u5c5e\u6027", userdata="\u503c\u6765\u81ea\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u7684\u6307\u5b9a\u5c5e\u6027"), @CodeItem(value="CURTIME", text="\u5f53\u524d\u65f6\u95f4", realtext="\u5f53\u524d\u65f6\u95f4", userdata="\u503c\u4e3a\u5f53\u524d\u65f6\u95f4")})
public class DEFVRParamTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ENTITYFIELD = "ENTITYFIELD";
    public static final String CURTIME = "CURTIME";

    public DEFVRParamTypeCodeListModel() {
        this.initAnnotation(DEFVRParamTypeCodeListModel.class);
        this.setUserData2("DEFVRParamType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRParamTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFVRParamTypeCodeListModel");
    }
}

