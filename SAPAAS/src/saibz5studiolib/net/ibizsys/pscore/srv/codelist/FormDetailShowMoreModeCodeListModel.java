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

@CodeList(id="0cdf6ab29c10a3d1068151da8af112f0", name="\u663e\u793a\u66f4\u591a\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u53d7\u63a7\u5185\u5bb9", realtext="\u53d7\u63a7\u5185\u5bb9", userdata="\u6210\u5458\u4f5c\u4e3a\u663e\u793a\u66f4\u591a\u7684\u5185\u5bb9\u63a5\u53d7\u5bb9\u5668\u7684\u7ba1\u7406"), @CodeItem(value="2", text="\u7ba1\u7406\u5bb9\u5668", realtext="\u7ba1\u7406\u5bb9\u5668", userdata="\u6210\u5458\u4f5c\u4e3a\u663e\u793a\u66f4\u591a\u7ba1\u7406\u5bb9\u5668\u7ba1\u7406\u5b50\u6210\u5458\u7684\u663e\u793a\u72b6\u6001")})
public class FormDetailShowMoreModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer CONTENT = 1;
    public static final int INT_CONTENT = 1;
    public static final Integer MANAGE = 2;
    public static final int INT_MANAGE = 2;

    public FormDetailShowMoreModeCodeListModel() {
        this.initAnnotation(FormDetailShowMoreModeCodeListModel.class);
        this.setUserData2("FormDetailShowMoreMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailShowMoreModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormDetailShowMoreModeCodeListModel");
    }
}

