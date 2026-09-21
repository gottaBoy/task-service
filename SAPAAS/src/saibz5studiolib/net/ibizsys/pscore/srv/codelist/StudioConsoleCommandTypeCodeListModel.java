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

@CodeList(id="4550FE55-1958-45D7-9CF9-583789EC8F62", name="\u5de5\u5177Console\u547d\u4ee4\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OBJECTCREATED", text="\u5bf9\u8c61\u5efa\u7acb\u901a\u77e5", realtext="\u5bf9\u8c61\u5efa\u7acb\u901a\u77e5"), @CodeItem(value="OBJECTUPDATED", text="\u5bf9\u8c61\u66f4\u65b0\u901a\u77e5", realtext="\u5bf9\u8c61\u66f4\u65b0\u901a\u77e5"), @CodeItem(value="OBJECTREMOVED", text="\u5bf9\u8c61\u5220\u9664\u901a\u77e5", realtext="\u5bf9\u8c61\u5220\u9664\u901a\u77e5")})
public class StudioConsoleCommandTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String OBJECTCREATED = "OBJECTCREATED";
    public static final String OBJECTUPDATED = "OBJECTUPDATED";
    public static final String OBJECTREMOVED = "OBJECTREMOVED";

    public StudioConsoleCommandTypeCodeListModel() {
        this.initAnnotation(StudioConsoleCommandTypeCodeListModel.class);
        this.setUserData2("StudioConsoleCommandType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioConsoleCommandTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.StudioConsoleCommandTypeCodeListModel");
    }
}

