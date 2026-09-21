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

@CodeList(id="C8835BCD-E16A-4490-8EB5-4343EA66F3B2", name="\u5b9e\u4f53\u884c\u4e3a\u540c\u6b65\u4e8b\u4ef6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="-1", text="\u81ea\u52a8", realtext="\u81ea\u52a8"), @CodeItem(value="0", text="\u65e0", realtext="\u65e0"), @CodeItem(value="1", text="\u65b0\u5efa", realtext="\u65b0\u5efa"), @CodeItem(value="2", text="\u66f4\u65b0", realtext="\u66f4\u65b0"), @CodeItem(value="4", text="\u5220\u9664", realtext="\u5220\u9664"), @CodeItem(value="256", text="\u81ea\u5b9a\u4e49", realtext="\u81ea\u5b9a\u4e49"), @CodeItem(value="512", text="\u81ea\u5b9a\u4e492", realtext="\u81ea\u5b9a\u4e492")})
public class DEActionSyncEventCodeListModel
extends StaticCodeListModelBase {
    public static final Integer AUTO = -1;
    public static final int INT_AUTO = -1;
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer CREATE = 1;
    public static final int INT_CREATE = 1;
    public static final Integer UPDATE = 2;
    public static final int INT_UPDATE = 2;
    public static final Integer REMVOE = 4;
    public static final int INT_REMVOE = 4;
    public static final Integer USER = 256;
    public static final int INT_USER = 256;
    public static final Integer USER2 = 512;
    public static final int INT_USER2 = 512;

    public DEActionSyncEventCodeListModel() {
        this.initAnnotation(DEActionSyncEventCodeListModel.class);
        this.setUserData2("DEActionSyncEvent");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionSyncEventCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionSyncEventCodeListModel");
    }
}

