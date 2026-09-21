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

@CodeList(id="8296263B-3382-4BD3-9D7E-6C5559F54C81", name="\u8868\u683c\u5217\u9690\u85cf\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="0", text="\u9ed8\u8ba4\u4e0d\u9690\u85cf", realtext="\u9ed8\u8ba4\u4e0d\u9690\u85cf"), @CodeItem(value="1", text="\u9ed8\u8ba4\u9690\u85cf", realtext="\u9ed8\u8ba4\u9690\u85cf"), @CodeItem(value="2", text="\u59cb\u7ec8\u9690\u85cf", realtext="\u59cb\u7ec8\u9690\u85cf"), @CodeItem(value="3", text="\u4ece\u4e0d\u9690\u85cf", realtext="\u4ece\u4e0d\u9690\u85cf")})
public class DEGridColHideModeCodeListModel
extends StaticCodeListModelBase {
    public static final Integer NOTHIDE = 0;
    public static final int INT_NOTHIDE = 0;
    public static final Integer HIDE = 1;
    public static final int INT_HIDE = 1;
    public static final Integer ALWAYSHIDE = 2;
    public static final int INT_ALWAYSHIDE = 2;
    public static final Integer NEVELHIDE = 3;
    public static final int INT_NEVELHIDE = 3;

    public DEGridColHideModeCodeListModel() {
        this.initAnnotation(DEGridColHideModeCodeListModel.class);
        this.setUserData2("DEGridColHideMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColHideModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColHideModeCodeListModel");
    }
}

