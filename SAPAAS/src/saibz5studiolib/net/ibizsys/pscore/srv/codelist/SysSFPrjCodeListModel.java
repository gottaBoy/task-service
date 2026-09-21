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

@CodeList(id="cfe708e139d9970cbeb834d3d9544d03", name="\u7cfb\u7edf\u670d\u52a1\u4f53\u7cfb\u4ee3\u7801\u9879\u76ee", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SRV_PUB", text="\u670d\u52a1\u9879\u76ee\uff08PUB\uff09", realtext="\u670d\u52a1\u9879\u76ee\uff08PUB\uff09"), @CodeItem(value="WEB_PUB", text="WEB\u9879\u76ee\uff08PUB\uff09", realtext="WEB\u9879\u76ee\uff08PUB\uff09")})
public class SysSFPrjCodeListModel
extends StaticCodeListModelBase {
    public static final String SRV_PUB = "SRV_PUB";
    public static final String WEB_PUB = "WEB_PUB";

    public SysSFPrjCodeListModel() {
        this.initAnnotation(SysSFPrjCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPrjCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysSFPrjCodeListModel");
    }
}

