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

@CodeList(id="aa6cdab62f318ffa517a5bba604f4bce", name="\u6811\u8282\u70b9\u5173\u7cfb\u7236\u8282\u70b9\u5c42\u7ea7", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="1", text="\u4e0a\u4e00\u7ea7", realtext="\u4e0a\u4e00\u7ea7", userdata="\u5c06\u4e0a\u4e00\u7ea7\u8282\u70b9\u7684\u6807\u8bc6\u4f5c\u4e3a\u7236\u8282\u70b9\u6807\u8bc6"), @CodeItem(value="2", text="\u4e0a\u4e24\u7ea7", realtext="\u4e0a\u4e24\u7ea7", userdata="\u5c06\u4e0a\u4e24\u7ea7\u8282\u70b9\u7684\u6807\u8bc6\u4f5c\u4e3a\u7236\u8282\u70b9\u6807\u8bc6"), @CodeItem(value="3", text="\u4e0a\u4e09\u7ea7", realtext="\u4e0a\u4e09\u7ea7", userdata="\u5c06\u4e0a\u4e09\u7ea7\u8282\u70b9\u7684\u6807\u8bc6\u4f5c\u4e3a\u7236\u8282\u70b9\u6807\u8bc6")})
public class DETreeNodeRSPValueLevelCodeListModel
extends StaticCodeListModelBase {
    public static final Integer LAST = 1;
    public static final int INT_LAST = 1;
    public static final Integer LAST2 = 2;
    public static final int INT_LAST2 = 2;
    public static final Integer LAST3 = 3;
    public static final int INT_LAST3 = 3;

    public DETreeNodeRSPValueLevelCodeListModel() {
        this.initAnnotation(DETreeNodeRSPValueLevelCodeListModel.class);
        this.setUserData2("TreeNodeRSPValueLevel");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeRSPValueLevelCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DETreeNodeRSPValueLevelCodeListModel");
    }
}

