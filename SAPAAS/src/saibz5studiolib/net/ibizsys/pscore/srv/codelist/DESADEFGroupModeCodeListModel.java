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

@CodeList(id="5965171e41895766a3574291f1fcc3eb", name="\u5b9e\u4f53\u670d\u52a1\u63a5\u53e3\u5c5e\u6027\u7ec4\u8054\u5408\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="REPLACE", text="\u66ff\u6362\u5b9e\u4f53\u5c5e\u6027", realtext="\u66ff\u6362\u5b9e\u4f53\u5c5e\u6027", userdata="\u76f4\u63a5\u4f7f\u7528\u5c5e\u6027\u7ec4\u5b9a\u4e49\u7684\u5c5e\u6027\u96c6\u5408"), @CodeItem(value="OVERWRITE", text="\u91cd\u5b9a\u4e49\u5b9e\u4f53\u5c5e\u6027", realtext="\u91cd\u5b9a\u4e49\u5b9e\u4f53\u5c5e\u6027", userdata="\u4f7f\u7528\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\uff0c\u5c5e\u6027\u7ec4\u5b9a\u4e49\u7684\u5c5e\u6027\u5c06\u9010\u4e2a\u66ff\u6362\u9ed8\u8ba4\u5b9e\u4f53\u5c5e\u6027"), @CodeItem(value="EXCLUDE", text="\u6392\u9664\u5c5e\u6027\u7ec4\u5c5e\u6027", realtext="\u6392\u9664\u5c5e\u6027\u7ec4\u5c5e\u6027", userdata="\u4f7f\u7528\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\uff0c\u6392\u9664\u5c5e\u6027\u7ec4\u5b9a\u4e49\u7684\u5c5e\u6027")})
public class DESADEFGroupModeCodeListModel
extends StaticCodeListModelBase {
    public static final String REPLACE = "REPLACE";
    public static final String OVERWRITE = "OVERWRITE";
    public static final String EXCLUDE = "EXCLUDE";

    public DESADEFGroupModeCodeListModel() {
        this.initAnnotation(DESADEFGroupModeCodeListModel.class);
        this.setUserData2("SADEDEFGroupMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADEFGroupModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DESADEFGroupModeCodeListModel");
    }
}

