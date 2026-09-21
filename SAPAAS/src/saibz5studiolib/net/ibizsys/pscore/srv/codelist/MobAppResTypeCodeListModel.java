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

@CodeList(id="bfad45da1d80d6c8b809fd41c1cc87b5", name="\u8d44\u6e90\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="STARTPAGE", text="\u6b22\u8fce\u9875", realtext="\u6b22\u8fce\u9875"), @CodeItem(value="ICON", text="\u56fe\u6807", realtext="\u56fe\u6807")})
public class MobAppResTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String STARTPAGE = "STARTPAGE";
    public static final String ICON = "ICON";

    public MobAppResTypeCodeListModel() {
        this.initAnnotation(MobAppResTypeCodeListModel.class);
        this.setUserData2("MobAppResType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobAppResTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobAppResTypeCodeListModel");
    }
}

