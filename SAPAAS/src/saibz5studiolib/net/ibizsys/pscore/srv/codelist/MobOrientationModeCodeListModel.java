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

@CodeList(id="510de5817cd9f3005a8ba5fcafdee4f7", name="\u79fb\u52a8\u7aef\u6a2a\u7ad6\u5c4f\u8bbe\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PORTRAIT", text="\u7ad6\u5c4f\u663e\u793a", realtext="\u7ad6\u5c4f\u663e\u793a"), @CodeItem(value="LANDSCAPE", text="\u6a2a\u5c4f\u663e\u793a", realtext="\u6a2a\u5c4f\u663e\u793a")})
public class MobOrientationModeCodeListModel
extends StaticCodeListModelBase {
    public static final String PORTRAIT = "PORTRAIT";
    public static final String LANDSCAPE = "LANDSCAPE";

    public MobOrientationModeCodeListModel() {
        this.initAnnotation(MobOrientationModeCodeListModel.class);
        this.setUserData2("MobAppOrientationMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOrientationModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOrientationModeCodeListModel");
    }
}

