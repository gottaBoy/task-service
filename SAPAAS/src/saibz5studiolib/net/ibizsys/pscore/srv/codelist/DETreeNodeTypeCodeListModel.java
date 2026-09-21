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

@CodeList(id="18ef2a01cf8f35e8aa30e7dd217f3dae", name="\u4e91\u6811\u89c6\u56fe\u8282\u70b9\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STATIC", text="\u9759\u6001", realtext="\u9759\u6001", userdata="\u9759\u6001\u5b9a\u4e49\u7684\u6811\u8282\u70b9"), @CodeItem(value="DE", text="\u52a8\u6001\uff08\u5b9e\u4f53\uff09", realtext="\u52a8\u6001\uff08\u5b9e\u4f53\uff09", userdata="\u4ece\u5b9e\u4f53\u6570\u636e\u96c6\u52a0\u8f7d\u7684\u52a8\u6001\u6811\u8282\u70b9"), @CodeItem(value="CODELIST", text="\u52a8\u6001\uff08\u4ee3\u7801\u8868\uff09", realtext="\u52a8\u6001\uff08\u4ee3\u7801\u8868\uff09", userdata="\u4ece\u4ee3\u7801\u8868\u52a0\u8f7d\u7684\u52a8\u6001\u6811\u8282\u70b9")})
public class DETreeNodeTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String STATIC = "STATIC";
    public static final String DE = "DE";
    public static final String CODELIST = "CODELIST";

    public DETreeNodeTypeCodeListModel() {
        this.initAnnotation(DETreeNodeTypeCodeListModel.class);
        this.setUserData2("TreeNodeType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeTypeCodeListModel");
    }
}

