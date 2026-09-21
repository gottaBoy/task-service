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

@CodeList(id="3744114B-834C-4247-A9D0-E21EF6202C77", name="\u5b9e\u4f53\u67e5\u8be2\u8fde\u63a5\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="MAIN", text="\u4e3b\u8fde\u63a5", realtext="\u4e3b\u8fde\u63a5", userdata="\u6570\u636e\u67e5\u8be2\u7684\u9876\u7ea7\u8fde\u63a5"), @CodeItem(value="N1", text="\u76f8\u5173N:1\uff08INNER JOIN\uff09", realtext="\u76f8\u5173N:1\uff08INNER JOIN\uff09", userdata="\u9700\u6307\u5b9a\u7236\u8fde\u63a5\u5b9e\u4f53\u7684N1\u5173\u7cfb"), @CodeItem(value="1N", text="\u5b58\u57281:N\uff08EXISTS (SELECT)\uff09", realtext="\u5b58\u57281:N\uff08EXISTS (SELECT)\uff09", userdata="\u9700\u6307\u5b9a\u7236\u8fde\u63a5\u5b9e\u4f53\u76841N\u5173\u7cfb"), @CodeItem(value="1NNOT", text="\u4e0d\u5b58\u57281:N\uff08NOT EXISTS (SELECT)\uff09", realtext="\u4e0d\u5b58\u57281:N\uff08NOT EXISTS (SELECT)\uff09", userdata="\u9700\u6307\u5b9a\u7236\u8fde\u63a5\u5b9e\u4f53\u76841N\u5173\u7cfb"), @CodeItem(value="INDEX", text="\u7d22\u5f15/\u7ee7\u627f-\u4e3b\u5b9e\u4f53", realtext="\u7d22\u5f15/\u7ee7\u627f-\u4e3b\u5b9e\u4f53"), @CodeItem(value="INDEXM", text="\u7d22\u5f15/\u7ee7\u627f-\u9644\u5c5e\u5b9e\u4f53", realtext="\u7d22\u5f15/\u7ee7\u627f-\u9644\u5c5e\u5b9e\u4f53"), @CodeItem(value="N1RIGHT", text="\u53f3\u8054\u63a5N:1", realtext="\u53f3\u8054\u63a5N:1"), @CodeItem(value="1NLEFTOUT", text="\u5de6\u5916\u8054\u63a5 1:N", realtext="\u5de6\u5916\u8054\u63a5 1:N"), @CodeItem(value="11", text="1:1-\u4e3b\u5b9e\u4f53", realtext="1:1-\u4e3b\u5b9e\u4f53"), @CodeItem(value="11M", text="1:1-\u9644\u5c5e\u5b9e\u4f53", realtext="1:1-\u9644\u5c5e\u5b9e\u4f53"), @CodeItem(value="CUSTOMN1", text="\u81ea\u5b9a\u4e49\u76f8\u5173N:1\uff08INNER JOIN\uff09", realtext="\u81ea\u5b9a\u4e49\u76f8\u5173N:1\uff08INNER JOIN\uff09"), @CodeItem(value="CUSTOM1NNOT", text="\u81ea\u5b9a\u4e49\u4e0d\u5b58\u57281:N\uff08NOT EXISTS (SELECT)\uff09", realtext="\u81ea\u5b9a\u4e49\u4e0d\u5b58\u57281:N\uff08NOT EXISTS (SELECT)\uff09"), @CodeItem(value="CUSTOM1N", text="\u81ea\u5b9a\u4e49\u5b58\u57281:N\uff08EXISTS (SELECT)\uff09", realtext="\u81ea\u5b9a\u4e49\u5b58\u57281:N\uff08EXISTS (SELECT)\uff09")})
public class DEDQJoinTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String MAIN = "MAIN";
    public static final String NO = "N1";
    public static final String ON = "1N";
    public static final String ONNOT = "1NNOT";
    public static final String INDEX = "INDEX";
    public static final String INDEXM = "INDEXM";
    public static final String NORIGHT = "N1RIGHT";
    public static final String ONLEFTOUT = "1NLEFTOUT";
    public static final String OO = "11";
    public static final String OOM = "11M";
    public static final String CUSTOMNO = "CUSTOMN1";
    public static final String CUSTOMONNOT = "CUSTOM1NNOT";
    public static final String CUSTOMON = "CUSTOM1N";

    public DEDQJoinTypeCodeListModel() {
        this.initAnnotation(DEDQJoinTypeCodeListModel.class);
        this.setUserData2("DEDQJoinType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQJoinTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEDQJoinTypeCodeListModel");
    }
}

