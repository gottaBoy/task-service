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

@CodeList(id="150aaacb47474586705bafa0013a17a5", name="\u5927\u6570\u636e\u8868\u5217\u6dfb\u52a0\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u624b\u52a8\u6dfb\u52a0", realtext="\u624b\u52a8\u6dfb\u52a0"), @CodeItem(value="1", text="\u81ea\u52a8\u6dfb\u52a0\uff08\u6392\u9664\u6307\u5b9a\uff09", realtext="\u81ea\u52a8\u6dfb\u52a0\uff08\u6392\u9664\u6307\u5b9a\uff09"), @CodeItem(value="2", text="\u81ea\u52a8\u6dfb\u52a0\uff08\u9009\u62e9\u6307\u5b9a\uff09", realtext="\u81ea\u52a8\u6dfb\u52a0\uff08\u9009\u62e9\u6307\u5b9a\uff09")})
public class BDTableColModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer MANUAL = 0;
    public static final int INT_MANUAL = 0;
    public static final Integer AUTO_EXCLUDE = 1;
    public static final int INT_AUTO_EXCLUDE = 1;
    public static final Integer AUTO_INCLUDE = 2;
    public static final int INT_AUTO_INCLUDE = 2;

    public BDTableColModeCodeListModel() {
        this.initAnnotation(BDTableColModeCodeListModel.class);
        this.setUserData2("BDTableColMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableColModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.BDTableColModeCodeListModel");
    }
}

