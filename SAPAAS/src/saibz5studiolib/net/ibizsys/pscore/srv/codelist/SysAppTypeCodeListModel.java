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

@CodeList(id="0775C176-93B4-4819-BFFA-C6FC23305536", name="\u7cfb\u7edf\u5e94\u7528\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="WEBAPP_HTML5", text="\u7f51\u9875\u5e94\u7528\uff08HTML5\uff09", realtext="\u7f51\u9875\u5e94\u7528\uff08HTML5\uff09", iconpath="psapptype/icon_webapp_html5.png", iconpathx="psapptype/icon_webapp_html5@{0}x.png"), @CodeItem(value="MOBILEAPP_HTML5", text="\u79fb\u52a8\u5e94\u7528\uff08HTML5\uff09", realtext="\u79fb\u52a8\u5e94\u7528\uff08HTML5\uff09", iconpath="psapptype/icon_mobileapp_html5.png", iconpathx="psapptype/icon_mobileapp_html5@{0}x.png"), @CodeItem(value="IOSAPP", text="iOS\u539f\u751f\u5e94\u7528", realtext="iOS\u539f\u751f\u5e94\u7528", iconpath="psapptype/icon_ios.png", iconpathx="psapptype/icon_ios@{0}x.png"), @CodeItem(value="ANDROIDAPP", text="Android\u539f\u751f\u5e94\u7528", realtext="Android\u539f\u751f\u5e94\u7528", iconpath="psapptype/icon_android.png", iconpathx="psapptype/icon_android@{0}x.png")})
public class SysAppTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String WEBAPP_HTML5 = "WEBAPP_HTML5";
    public static final String MOBILEAPP_HTML5 = "MOBILEAPP_HTML5";
    public static final String IOSAPP = "IOSAPP";
    public static final String ANDROIDAPP = "ANDROIDAPP";

    public SysAppTypeCodeListModel() {
        this.initAnnotation(SysAppTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysAppTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysAppTypeCodeListModel");
    }
}

