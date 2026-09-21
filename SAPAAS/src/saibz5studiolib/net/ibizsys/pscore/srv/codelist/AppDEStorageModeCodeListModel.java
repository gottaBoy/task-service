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

@CodeList(id="222499CA-81E7-462B-A5B7-C4173E2F37D3", name="\u5e94\u7528\u5b9e\u4f53\u5b58\u50a8\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u65e0\u672c\u5730\u5b58\u50a8\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u4ec5\u8fdc\u7a0b\u5b58\u50a8", realtext="\u4ec5\u8fdc\u7a0b\u5b58\u50a8"), @CodeItem(value="1", text="\u4ec5\u672c\u5730\u5b58\u50a8", realtext="\u4ec5\u672c\u5730\u5b58\u50a8"), @CodeItem(value="3", text="\u672c\u5730\u53ca\u8fdc\u7a0b\u5b58\u50a8", realtext="\u672c\u5730\u53ca\u8fdc\u7a0b\u5b58\u50a8"), @CodeItem(value="4", text="DTO\u6210\u5458\uff08\u65e0\u5b58\u50a8\uff09", realtext="DTO\u6210\u5458\uff08\u65e0\u5b58\u50a8\uff09")})
public class AppDEStorageModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOLOCAL = 0;
    public static final int INT_NOLOCAL = 0;
    public static final Integer LOCALONLY = 1;
    public static final int INT_LOCALONLY = 1;
    public static final Integer LOCALANDREMOTE = 3;
    public static final int INT_LOCALANDREMOTE = 3;
    public static final Integer DTOONLY = 4;
    public static final int INT_DTOONLY = 4;

    public AppDEStorageModeCodeListModel() {
        this.initAnnotation(AppDEStorageModeCodeListModel.class);
        this.setUserData2("AppDEStorageMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEStorageModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppDEStorageModeCodeListModel");
    }
}

