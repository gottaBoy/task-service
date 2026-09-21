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

@CodeList(id="376f606e8d4e0e124349b335ac3dc9a2", name="\u90e8\u4ef6\u5904\u7406\u7ec4\u7ec7\u6570\u636e\u8303\u56f4", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="NUM", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="1", text="\u5f53\u524d\u7ec4\u7ec7", realtext="\u5f53\u524d\u7ec4\u7ec7", userdata="\u5f53\u524d\u7528\u6237\u7684\u7ec4\u7ec7"), @CodeItem(value="2", text="\u4e0a\u7ea7\u7ec4\u7ec7", realtext="\u4e0a\u7ea7\u7ec4\u7ec7", userdata="\u5f53\u524d\u7528\u6237\u7684\u7ec4\u7ec7\u7684\u4e0a\u7ea7\u7ec4\u7ec7\uff08\u9012\u5f52\uff09"), @CodeItem(value="4", text="\u4e0b\u7ea7\u7ec4\u7ec7", realtext="\u4e0b\u7ea7\u7ec4\u7ec7", userdata="\u5f53\u524d\u7528\u6237\u7684\u7ec4\u7ec7\u7684\u4e0b\u7ea7\u7ec4\u7ec7\uff08\u9012\u5f52\uff09"), @CodeItem(value="8", text="\u65e0\u7ec4\u7ec7\u503c", realtext="\u65e0\u7ec4\u7ec7\u503c", userdata="\u6570\u636e\u672a\u6307\u5b9a\u7ec4\u7ec7\u503c")})
public class ACHOrgDRCodeListModel
extends StaticCodeListModelBase {
    public static final Integer CURRENT = 1;
    public static final int INT_CURRENT = 1;
    public static final Integer PARENT = 2;
    public static final int INT_PARENT = 2;
    public static final Integer SUBORDINATE = 4;
    public static final int INT_SUBORDINATE = 4;
    public static final Integer EMPTY = 8;
    public static final int INT_EMPTY = 8;

    public ACHOrgDRCodeListModel() {
        this.initAnnotation(ACHOrgDRCodeListModel.class);
        this.setUserData2("OrgScope");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ACHOrgDRCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ACHOrgDRCodeListModel");
    }
}

