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

@CodeList(id="5de1ed1fefa522b93877ca9951811877", name="\u5b9e\u4f53\u6620\u5c04\u76ee\u6807\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SYSCUR", text="\u5f53\u524d\u7cfb\u7edf\u5b9e\u4f53", realtext="\u5f53\u524d\u7cfb\u7edf\u5b9e\u4f53", userdata="\u6620\u5c04\u5230\u5f53\u524d\u7cfb\u7edf\u5b9e\u4f53")})
public class DEMapTargetTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SYSCUR = "SYSCUR";

    public DEMapTargetTypeCodeListModel() {
        this.initAnnotation(DEMapTargetTypeCodeListModel.class);
        this.setUserData2("DEMapTargetType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapTargetTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEMapTargetTypeCodeListModel");
    }
}

