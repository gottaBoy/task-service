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

@CodeList(id="9a5478a794847401671ebe3a2ff9852c", name="\u8868\u5355\u5206\u7ec4\u5feb\u6377\u64cd\u4f5c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa", userdata="\u754c\u9762\u5206\u7ec4\u63d0\u4f9b\u65b0\u5efa\u64cd\u4f5c\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u63d0\u4f9b\u7684\u65b0\u5efa\u64cd\u4f5c"), @CodeItem(value="2", text="\u66f4\u591a\u64cd\u4f5c", realtext="\u66f4\u591a\u64cd\u4f5c", userdata="\u754c\u9762\u5206\u7ec4\u63d0\u4f9b\u66f4\u591a\u64cd\u4f5c\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u663e\u793a\u66f4\u591a\u64cd\u4f5c\u529f\u80fd"), @CodeItem(value="4", text="\u5237\u65b0", realtext="\u5237\u65b0", userdata="\u754c\u9762\u5206\u7ec4\u63d0\u4f9b\u5237\u65b0\u64cd\u4f5c\uff0c\u4e00\u822c\u5e94\u7528\u4e8e\u5206\u7ec4\u5305\u542b\u591a\u6570\u636e\u754c\u9762\u90e8\u4ef6\u573a\u5408\uff0c\u8c03\u7528\u591a\u6570\u636e\u90e8\u4ef6\u754c\u9762\u63d0\u4f9b\u7684\u5237\u65b0\u64cd\u4f5c")})
public class FormGroupMoreActionsCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer MORE = 2;
    public static final int INT_MORE = 2;
    public static final Integer REFRESH = 4;
    public static final int INT_REFRESH = 4;

    public FormGroupMoreActionsCodeListModel() {
        this.initAnnotation(FormGroupMoreActionsCodeListModel.class);
        this.setUserData2("GroupBarMoreAction");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FormGroupMoreActionsCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FormGroupMoreActionsCodeListModel");
    }
}

