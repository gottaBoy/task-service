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

@CodeList(id="B865B729-189A-4357-B1B9-0A75A4422DC0", name="\u5b9e\u4f53\u8054\u5408\u952e\u503c\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="DIGEST", text="\u6458\u8981", realtext="\u6458\u8981"), @CodeItem(value="DELIMITER", text="\u5206\u9694\u7b26", realtext="\u5206\u9694\u7b26")})
public class DEUnionKeyModeCodeListModel
extends StaticCodeListModelBase {
    public static final String DIGEST = "DIGEST";
    public static final String DELIMITER = "DELIMITER";

    public DEUnionKeyModeCodeListModel() {
        this.initAnnotation(DEUnionKeyModeCodeListModel.class);
        this.setUserData2("DEUnionKeyMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUnionKeyModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEUnionKeyModeCodeListModel");
    }
}

