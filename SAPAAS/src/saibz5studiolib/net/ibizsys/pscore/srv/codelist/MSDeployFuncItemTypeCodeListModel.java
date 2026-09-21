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

@CodeList(id="5d0f31cb04b7b490b7bd9c6cddb2642a", name="\u5f00\u53d1\u7cfb\u7edf\u5fae\u670d\u52a1\u90e8\u7f72\u529f\u80fd\u6210\u5458\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="APP", text="\u5e94\u7528", realtext="\u5e94\u7528", iconpath="msdeployfuncitemtype/icon_app.png", iconpathx="msdeployfuncitemtype/icon_app@{0}x.png"), @CodeItem(value="API", text="\u63a5\u53e3", realtext="\u63a5\u53e3", iconpath="msdeployfuncitemtype/icon_api.png", iconpathx="msdeployfuncitemtype/icon_api@{0}x.png")})
public class MSDeployFuncItemTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String APP = "APP";
    public static final String API = "API";

    public MSDeployFuncItemTypeCodeListModel() {
        this.initAnnotation(MSDeployFuncItemTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MSDeployFuncItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MSDeployFuncItemTypeCodeListModel");
    }
}

