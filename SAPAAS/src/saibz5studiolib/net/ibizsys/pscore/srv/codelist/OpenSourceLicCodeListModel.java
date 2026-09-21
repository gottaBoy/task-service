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

@CodeList(id="89ad1b6be3ec1701a69b5442c4cdc391", name="\u5f00\u6e90\u534f\u8bae\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="BSD", text="BSD", realtext="BSD"), @CodeItem(value="APACHE", text="Apache Licence 2.0", realtext="Apache Licence 2.0"), @CodeItem(value="GPL", text="GPL", realtext="GPL"), @CodeItem(value="GPL2", text="GPLv2", realtext="GPLv2"), @CodeItem(value="GPL3", text="GPLv3", realtext="GPLv3"), @CodeItem(value="LGPL", text="LGPL", realtext="LGPL"), @CodeItem(value="MIT", text="MIT", realtext="MIT")})
public class OpenSourceLicCodeListModel
extends StaticCodeListModelBase {
    public static final String BSD = "BSD";
    public static final String APACHE = "APACHE";
    public static final String GPL = "GPL";
    public static final String GPL2 = "GPL2";
    public static final String GPL3 = "GPL3";
    public static final String LGPL = "LGPL";
    public static final String MIT = "MIT";

    public OpenSourceLicCodeListModel() {
        this.initAnnotation(OpenSourceLicCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.OpenSourceLicCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.OpenSourceLicCodeListModel");
    }
}

