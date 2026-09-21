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

@CodeList(id="40A4598B-4032-4A2F-AF3D-1D4AA2E1F96A", name="\u5b9e\u4f53\u884c\u4e3a\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="USERCUSTOM", text="\u7528\u6237\u81ea\u5b9a\u4e49", realtext="\u7528\u6237\u81ea\u5b9a\u4e49"), @CodeItem(value="DELOGIC", text="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", realtext="\u5b9e\u4f53\u5904\u7406\u903b\u8f91"), @CodeItem(value="BUILTIN", text="\u5185\u7f6e\u65b9\u6cd5", realtext="\u5185\u7f6e\u65b9\u6cd5"), @CodeItem(value="SELECTBYKEY", text="\u901a\u8fc7\u952e\u503c\u83b7\u53d6", realtext="\u901a\u8fc7\u952e\u503c\u83b7\u53d6"), @CodeItem(value="USERCREATE", text="\u7528\u6237\u6269\u5c55\u5efa\u7acb", realtext="\u7528\u6237\u6269\u5c55\u5efa\u7acb"), @CodeItem(value="USERUPDATE", text="\u7528\u6237\u6269\u5c55\u66f4\u65b0", realtext="\u7528\u6237\u6269\u5c55\u66f4\u65b0"), @CodeItem(value="USERSYSUPDATE", text="\u7528\u6237\u6269\u5c55\u7cfb\u7edf\u66f4\u65b0", realtext="\u7528\u6237\u6269\u5c55\u7cfb\u7edf\u66f4\u65b0"), @CodeItem(value="SCRIPT", text="\u811a\u672c\u4ee3\u7801", realtext="\u811a\u672c\u4ee3\u7801"), @CodeItem(value="REMOTE", text="\u8fdc\u7a0b\u63a5\u53e3\u884c\u4e3a", realtext="\u8fdc\u7a0b\u63a5\u53e3\u884c\u4e3a"), @CodeItem(value="INHERIT", text="\u7ee7\u627f\u884c\u4e3a", realtext="\u7ee7\u627f\u884c\u4e3a")})
public class DEActionType2CodeListModel
extends StaticCodeListModelBase {
    public static final String USERCUSTOM = "USERCUSTOM";
    public static final String DELOGIC = "DELOGIC";
    public static final String BUILTIN = "BUILTIN";
    public static final String SELECTBYKEY = "SELECTBYKEY";
    public static final String USERCREATE = "USERCREATE";
    public static final String USERUPDATE = "USERUPDATE";
    public static final String USERSYSUPDATE = "USERSYSUPDATE";
    public static final String SCRIPT = "SCRIPT";
    public static final String REMOTE = "REMOTE";
    public static final String INHERIT = "INHERIT";

    public DEActionType2CodeListModel() {
        this.initAnnotation(DEActionType2CodeListModel.class);
        this.setUserData2("DEActionType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEActionType2CodeListModel");
    }
}

