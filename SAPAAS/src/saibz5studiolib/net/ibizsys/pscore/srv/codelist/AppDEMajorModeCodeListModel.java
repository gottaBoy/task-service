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

@CodeList(id="e3fea6bb19bc37886840e73eed4faa30", name="\u4e3b\u5b9e\u4f53\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\u81ea\u52a8\u8ba1\u7b97")
@CodeItems(value={@CodeItem(value="0", text="\u5426", realtext="\u5426"), @CodeItem(value="1", text="\u662f", realtext="\u662f"), @CodeItem(value="2", text="\u81ea\u52a8\u8ba1\u7b97", realtext="\u81ea\u52a8\u8ba1\u7b97")})
public class AppDEMajorModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NO = 0;
    public static final int INT_NO = 0;
    public static final Integer YES = 1;
    public static final int INT_YES = 1;
    public static final Integer AUTO = 2;
    public static final int INT_AUTO = 2;

    public AppDEMajorModeCodeListModel() {
        this.initAnnotation(AppDEMajorModeCodeListModel.class);
        this.setUserData2("AppDEMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEMajorModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEMajorModeCodeListModel");
    }
}

