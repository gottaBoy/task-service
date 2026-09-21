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

@CodeList(id="F6DD3A5C-635B-49CD-A1FC-58154CC531B1", name="\u5e94\u7528\u9884\u89c8\u7f29\u653e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="50", text="50%", realtext="50%"), @CodeItem(value="75", text="75%", realtext="75%"), @CodeItem(value="100", text="100%", realtext="100%"), @CodeItem(value="125", text="125%", realtext="125%"), @CodeItem(value="150", text="150%", realtext="150%")})
public class AppPreviewZoomCodeListModel
extends StaticCodeListModelBase {
    public static final String ITEM_50 = "50";
    public static final String ITEM_75 = "75";
    public static final String ITEM_100 = "100";
    public static final String ITEM_125 = "125";
    public static final String ITEM_150 = "150";

    public AppPreviewZoomCodeListModel() {
        this.initAnnotation(AppPreviewZoomCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPreviewZoomCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppPreviewZoomCodeListModel");
    }
}

