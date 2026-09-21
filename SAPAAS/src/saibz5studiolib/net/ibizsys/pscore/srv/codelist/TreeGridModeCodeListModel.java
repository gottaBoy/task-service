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

@CodeList(id="5A7FCC93-B47C-453B-A773-A3ACD0215764", name="\u6811\u8868\u683c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u65e0", realtext="\u65e0", userdata="\u4e0d\u542f\u7528\u6811\u8868\u683c"), @CodeItem(value="1", text="\u5e38\u89c4\u6811\u8868\u683c", realtext="\u5e38\u89c4\u6811\u8868\u683c", userdata="\u5e38\u89c4\u6811\u8868\u683c\u5c55\u73b0\uff0c\u9700\u5728\u6811\u89c6\u56fe\u5b9a\u4e49\u5176\u5b83\u8868\u683c\u5217\uff0c\u6bcf\u79cd\u6811\u8282\u70b9\u4e5f\u9700\u8981\u4e3a\u6bcf\u4e2a\u8868\u683c\u5217\u5b9a\u4e49\u4f9b\u6570\uff08\u6811\u8282\u70b9\u8868\u683c\u5217\uff09"), @CodeItem(value="2", text="\u7518\u7279\u56fe\u6811\u8868\u683c", realtext="\u7518\u7279\u56fe\u6811\u8868\u683c", userdata="\u7518\u7279\u56fe\u6811\u8868\u683c\u5c55\u73b0\uff0c\u5728\u5e38\u89c4\u6811\u8868\u683c\u7684\u57fa\u7840\u4e0a\uff0c\u7ea6\u5b9a\u5f00\u59cb\u65f6\u95f4\u3001\u7ed3\u675f\u65f6\u95f4\u3001\u4efb\u52a1\u7f16\u53f7\u3001\u524d\u7f6e\u7f16\u53f7\u7b49\u4efb\u52a1\u76f8\u5173\u6570\u636e\u9879")})
public class TreeGridModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NONE = 0;
    public static final int INT_NONE = 0;
    public static final Integer TREEGRID = 1;
    public static final int INT_TREEGRID = 1;
    public static final Integer GANTT = 2;
    public static final int INT_GANTT = 2;

    public TreeGridModeCodeListModel() {
        this.initAnnotation(TreeGridModeCodeListModel.class);
        this.setUserData2("TreeGridMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.TreeGridModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.TreeGridModeCodeListModel");
    }
}

