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

@CodeList(id="9e1ab19dda309b8ece46430de91703e9", name="\u5b9e\u4f53\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e3b\u5b9e\u4f53", realtext="\u4e3b\u5b9e\u4f53", userdata="\u5b9e\u4f53\u5177\u5907\u6709\u76f8\u5bf9\u72ec\u7acb\u7684\u4e1a\u52a1\u80fd\u529b"), @CodeItem(value="2", text="\u9644\u5c5e\u5b9e\u4f53", realtext="\u9644\u5c5e\u5b9e\u4f53", userdata="\u5b9e\u4f53\u4e0d\u5177\u5907\u72ec\u7acb\u7684\u4e1a\u52a1\u80fd\u529b\uff0c\u4e00\u822c\u4e3a\u4e3b\u5b9e\u4f53\u7684\u6210\u5458\u6570\u636e"), @CodeItem(value="3", text="\u5173\u7cfb\u5b9e\u4f53", realtext="\u5173\u7cfb\u5b9e\u4f53", userdata="\u7528\u4e8e\u5bf9\u4e24\u4e2a\u4e3b\u5b9e\u4f53\u8fdb\u884c\u8fde\u63a5\u7684\u5b9e\u4f53"), @CodeItem(value="4", text="\u52a8\u6001\u9644\u5c5e\u5b9e\u4f53", realtext="\u52a8\u6001\u9644\u5c5e\u5b9e\u4f53", userdata="\u5b9e\u4f53\u4e0d\u5177\u5907\u72ec\u7acb\u7684\u4e1a\u52a1\u80fd\u529b\uff0c\u4e3a\u52a8\u6001\u6307\u5b9a\u7684\u7236\u5b9e\u4f53\u7684\u6210\u5458\u6570\u636e"), @CodeItem(value="6", text="\u62bd\u8c61\u5b9e\u4f53", realtext="\u62bd\u8c61\u5b9e\u4f53", userdata="\u200b\u200b\u62bd\u8c61\u5b9e\u4f53\u62bd\u8c61\u5171\u6027\u7684\u5c5e\u6027\u6216\u884c\u4e3a\u89c4\u5219")})
public class DETypeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer MAJOR = 1;
    public static final int INT_MAJOR = 1;
    public static final Integer ATTACHED = 2;
    public static final int INT_ATTACHED = 2;
    public static final Integer RELATED = 3;
    public static final int INT_RELATED = 3;
    public static final Integer DYNAATTACHED = 4;
    public static final int INT_DYNAATTACHED = 4;
    public static final Integer ABSTRACT = 6;
    public static final int INT_ABSTRACT = 6;

    public DETypeCodeListModel() {
        this.initAnnotation(DETypeCodeListModel.class);
        this.setUserData2("DEType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETypeCodeListModel");
    }
}

