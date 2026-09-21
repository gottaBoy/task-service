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

@CodeList(id="9854ff420ea7ad0fbefeb6e9d17d0a4a", name="\u8868\u5355\u6210\u5458\u903b\u8f91\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PANELVISIBLE", text="\u9762\u677f\u663e\u793a", realtext="\u9762\u677f\u663e\u793a", userdata="\u63a7\u5236\u6210\u5458\u662f\u5426\u663e\u793a"), @CodeItem(value="ITEMENABLE", text="\u8868\u5355\u9879\u542f\u7528", realtext="\u8868\u5355\u9879\u542f\u7528", userdata="\u63a7\u5236\u8868\u5355\u9879\u53ca\u5176\u7f16\u8f91\u5668\u7684\u542f\u7528\u7981\u7528\u72b6\u6001"), @CodeItem(value="ITEMBLANK", text="\u8868\u5355\u9879\u7a7a\u8f93\u5165", realtext="\u8868\u5355\u9879\u7a7a\u8f93\u5165", userdata="\u63a7\u5236\u8868\u5355\u9879\u53ca\u5176\u7f16\u8f91\u5668\u662f\u5426\u5141\u8bb8\u7a7a\u8f93\u5165"), @CodeItem(value="SCRIPTCODE_CHANGE", text="\u8868\u5355\u9879\u503c\u53d8\u66f4\uff08\u811a\u672c\u5904\u7406\uff09", realtext="\u8868\u5355\u9879\u503c\u53d8\u66f4\uff08\u811a\u672c\u5904\u7406\uff09"), @CodeItem(value="SCRIPTCODE_CLICK", text="\u8868\u5355\u9879\u70b9\u51fb\uff08\u811a\u672c\u5904\u7406\uff09", realtext="\u8868\u5355\u9879\u70b9\u51fb\uff08\u811a\u672c\u5904\u7406\uff09"), @CodeItem(value="SCRIPTCODE_FOCUS", text="\u8868\u5355\u9879\u83b7\u53d6\u7126\u70b9\uff08\u811a\u672c\u5904\u7406\uff09", realtext="\u8868\u5355\u9879\u83b7\u53d6\u7126\u70b9\uff08\u811a\u672c\u5904\u7406\uff09"), @CodeItem(value="SCRIPTCODE_BLUR", text="\u8868\u5355\u9879\u5931\u53bb\u7126\u70b9\uff08\u811a\u672c\u5904\u7406\uff09", realtext="\u8868\u5355\u9879\u5931\u53bb\u7126\u70b9\uff08\u811a\u672c\u5904\u7406\uff09")})
public class FDLogicCatCodeListModel
extends StaticCodeListModelBase {
    public static final String PANELVISIBLE = "PANELVISIBLE";
    public static final String ITEMENABLE = "ITEMENABLE";
    public static final String ITEMBLANK = "ITEMBLANK";
    public static final String SCRIPTCODE_CHANGE = "SCRIPTCODE_CHANGE";
    public static final String SCRIPTCODE_CLICK = "SCRIPTCODE_CLICK";
    public static final String SCRIPTCODE_FOCUS = "SCRIPTCODE_FOCUS";
    public static final String SCRIPTCODE_BLUR = "SCRIPTCODE_BLUR";

    public FDLogicCatCodeListModel() {
        this.initAnnotation(FDLogicCatCodeListModel.class);
        this.setUserData2("CtrlDetailLogicCat");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.FDLogicCatCodeListModel");
    }
}

