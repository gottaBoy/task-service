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

@CodeList(id="a5ba64a48f7584df7a3bc3647e51ff46", name="\u6570\u636e\u5ba1\u8ba1\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u57fa\u672c\u5ba1\u8ba1", realtext="\u57fa\u672c\u5ba1\u8ba1", userdata="\u8bb0\u5f55\u6570\u636e\u7684\u57fa\u672c\u64cd\u4f5c\u8bb0\u5f55\uff0c\u5305\u62ec\u4e86\u64cd\u4f5c\u4eba\u53ca\u64cd\u4f5c\u65f6\u95f4"), @CodeItem(value="2", text="\u8be6\u7ec6\u5ba1\u8ba1\uff08\u542b\u53d8\u5316\u8bb0\u5f55\uff09", realtext="\u8be6\u7ec6\u5ba1\u8ba1\uff08\u542b\u53d8\u5316\u8bb0\u5f55\uff09", userdata="\u8bb0\u5f55\u6570\u636e\u7684\u64cd\u4f5c\u8bb0\u5f55\uff0c\u5305\u62ec\u4e86\u64cd\u4f5c\u4eba\u53ca\u64cd\u4f5c\u65f6\u95f4\u4ee5\u53ca\u5177\u4f53\u7684\u53d8\u66f4\u5185\u5bb9")})
public class DEDataAuditModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NORMAL = 1;
    public static final int INT_NORMAL = 1;
    public static final Integer ADVANCE = 2;
    public static final int INT_ADVANCE = 2;

    public DEDataAuditModeCodeListModel() {
        this.initAnnotation(DEDataAuditModeCodeListModel.class);
        this.setUserData2("DEDataAuditMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataAuditModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDataAuditModeCodeListModel");
    }
}

