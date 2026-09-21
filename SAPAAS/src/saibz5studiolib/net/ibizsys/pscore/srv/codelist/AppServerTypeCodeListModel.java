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

@CodeList(id="0ac168a038646fcbb20e34cb9feee57f", name="\u4e91\u5e73\u53f0\u5e94\u7528\u670d\u52a1\u5668\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="TOMCAT7", text="Apache Tomcat 7.0", realtext="Apache Tomcat 7.0", iconpath="default/psdevcenteras/icon_astype_tomcat7.png", iconpathx="default/psdevcenteras/icon_astype_tomcat7@{0}x.png"), @CodeItem(value="APPBOOT", text="\u81ea\u542f\u52a8\u5e94\u7528", realtext="\u81ea\u542f\u52a8\u5e94\u7528", iconpath="default/psdevcenteras/icon_astype_appboot.png", iconpathx="default/psdevcenteras/icon_astype_appboot@{0}x.png")})
public class AppServerTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String TOMCAT7 = "TOMCAT7";
    public static final String APPBOOT = "APPBOOT";

    public AppServerTypeCodeListModel() {
        this.initAnnotation(AppServerTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppServerTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppServerTypeCodeListModel");
    }
}

