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

@CodeList(id="8139873D-3B05-4BB6-BCA9-DB5CA08ED6C7", name="\u754c\u9762\u884c\u4e3a\u5bf9\u8bdd\u6846\u7ed3\u679c", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OK", text="\u786e\u5b9a", realtext="\u786e\u5b9a"), @CodeItem(value="CANCEL", text="\u53d6\u6d88", realtext="\u53d6\u6d88"), @CodeItem(value="YES", text="\u662f", realtext="\u662f"), @CodeItem(value="NO", text="\u5426", realtext="\u5426")})
public class UIActionDialogResultCodeListModel
extends StaticCodeListModelBase {
    public static final String OK = "OK";
    public static final String CANCEL = "CANCEL";
    public static final String YES = "YES";
    public static final String NO = "NO";

    public UIActionDialogResultCodeListModel() {
        this.initAnnotation(UIActionDialogResultCodeListModel.class);
        this.setUserData2("UIActionDialogResult");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionDialogResultCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.UIActionDialogResultCodeListModel");
    }
}

