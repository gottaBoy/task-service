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

@CodeList(id="5f6f35ce0ad9958937b03c9e2ff0c250", name="\u5b9e\u4f53\u5c5e\u6027\u4e3b\u952e\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u5426", realtext="\u5426"), @CodeItem(value="1", text="\u4e3b\u952e", realtext="\u4e3b\u952e", userdata="\u6570\u636e\u7684\u4e3b\u952e"), @CodeItem(value="2", text="\u552f\u4e00\u8bc6\u522b\u6807\u8bb0", realtext="\u552f\u4e00\u8bc6\u522b\u6807\u8bb0", userdata="\u5b9e\u4f53\u652f\u6301\u7531\u591a\u4e2a\u5c5e\u6027\u7684\u503c\u54c8\u5e0c\u5f97\u51fa\u6570\u636e\u7684\u8bc6\u522b\u6807\u8bb0\uff0c\u5982\u679c\u4e3b\u952e\u4e3a\u6587\u672c\u7c7b\u578b\uff0c\u6570\u636e\u8bc6\u522b\u6807\u8bb0\u5c06\u4f5c\u4e3a\u4e3b\u952e\u8fdb\u884c\u5b58\u50a8\uff0c\u5982\u679c\u4e3b\u952e\u4e3a\u6570\u503c\uff0c\u5219\u9700\u8981\u989d\u5916\u6307\u5b9a\u4e00\u4e2a\u5c5e\u6027\u6765\u5b58\u50a8\u8fd9\u4e2a\u8bc6\u522b\u6807\u8bb0")})
public class DEFPKeyModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer PKEY = 1;
    public static final int INT_PKEY = 1;
    public static final Integer UNITAG = 2;
    public static final int INT_UNITAG = 2;

    public DEFPKeyModeCodeListModel() {
        this.initAnnotation(DEFPKeyModeCodeListModel.class);
        this.setUserData2("FieldPKeyMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFPKeyModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFPKeyModeCodeListModel");
    }
}

