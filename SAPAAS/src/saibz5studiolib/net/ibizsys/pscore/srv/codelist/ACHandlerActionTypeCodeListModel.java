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

@CodeList(id="b70a8e4fd305f57bb7fc48fc176a9d08", name="\u90e8\u4ef6\u540e\u53f0\u5904\u7406\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DEACTION", text="\u5b9e\u4f53\u884c\u4e3a", realtext="\u5b9e\u4f53\u884c\u4e3a", userdata="\u754c\u9762\u8bf7\u6c42\u7531\u5b9e\u4f53\u884c\u4e3a\u5904\u7406\u53cd\u9988\uff0c\u4e00\u822c\u4e3a\u5bf9\u5355\u9879\u6570\u636e\u7684\u64cd\u4f5c"), @CodeItem(value="DEDATASET", text="\u5b9e\u4f53\u7ed3\u679c\u96c6", realtext="\u5b9e\u4f53\u7ed3\u679c\u96c6", userdata="\u754c\u9762\u8bf7\u6c42\u7531\u5b9e\u4f53\u6570\u636e\u96c6\u5904\u7406\u53cd\u9988\uff0c\u4e00\u822c\u4e3a\u6570\u636e\u67e5\u8be2\u6216\u5bfc\u51fa")})
public class ACHandlerActionTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String DEACTION = "DEACTION";
    public static final String DEDATASET = "DEDATASET";

    public ACHandlerActionTypeCodeListModel() {
        this.initAnnotation(ACHandlerActionTypeCodeListModel.class);
        this.setUserData2("CtrlHandlerActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ACHandlerActionTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ACHandlerActionTypeCodeListModel");
    }
}

