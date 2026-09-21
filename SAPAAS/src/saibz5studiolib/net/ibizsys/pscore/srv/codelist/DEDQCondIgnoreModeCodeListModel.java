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

@CodeList(id="44DE34B8-AF99-48F9-B975-D0C55BBE51BE", name="\u5b9e\u4f53\u67e5\u8be2\u6761\u4ef6\u5ffd\u7565\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u65e0\u503c\u65f6\u5ffd\u7565", realtext="\u65e0\u503c\u65f6\u5ffd\u7565"), @CodeItem(value="2", text="\u5ffd\u7565\u5916\u90e8\u4f20\u5165", realtext="\u5ffd\u7565\u5916\u90e8\u4f20\u5165", userdata="\u5ffd\u7565\u5916\u90e8\u4f20\u5165\u7684\u8be5\u5c5e\u6027\u6761\u4ef6")})
public class DEDQCondIgnoreModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer EMPTY = 1;
    public static final int INT_EMPTY = 1;
    public static final Integer OTHER = 2;
    public static final int INT_OTHER = 2;

    public DEDQCondIgnoreModeCodeListModel() {
        this.initAnnotation(DEDQCondIgnoreModeCodeListModel.class);
        this.setUserData2("DEDQCondIgnoreMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQCondIgnoreModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQCondIgnoreModeCodeListModel");
    }
}

