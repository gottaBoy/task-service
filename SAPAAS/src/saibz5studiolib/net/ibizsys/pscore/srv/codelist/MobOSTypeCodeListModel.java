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

@CodeList(id="cacabfe99914c2a8a7f6a8435ddbc547", name="\u79fb\u52a8\u7aef\u7cfb\u7edf\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="IOS", text="iOS", realtext="iOS"), @CodeItem(value="ANDROID", text="Android", realtext="Android")})
public class MobOSTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";

    public MobOSTypeCodeListModel() {
        this.initAnnotation(MobOSTypeCodeListModel.class);
        this.setUserData2("MobOSType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOSTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobOSTypeCodeListModel");
    }
}

