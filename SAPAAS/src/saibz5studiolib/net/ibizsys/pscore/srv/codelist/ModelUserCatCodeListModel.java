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

@CodeList(id="7a5ac102cf2b5d996765499d17943147", name="\u6a21\u578b\u7528\u6237\u7c7b\u522b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="CAT1", text="\u7c7b\u522b1", realtext="\u7c7b\u522b1"), @CodeItem(value="CAT2", text="\u7c7b\u578b2", realtext="\u7c7b\u578b2"), @CodeItem(value="CAT3", text="\u7c7b\u522b3", realtext="\u7c7b\u522b3"), @CodeItem(value="CAT4", text="\u7c7b\u522b4", realtext="\u7c7b\u522b4"), @CodeItem(value="CAT5", text="\u7c7b\u522b5", realtext="\u7c7b\u522b5"), @CodeItem(value="CAT6", text="\u7c7b\u522b6", realtext="\u7c7b\u522b6"), @CodeItem(value="CAT7", text="\u7c7b\u522b7", realtext="\u7c7b\u522b7"), @CodeItem(value="CAT8", text="\u7c7b\u522b8", realtext="\u7c7b\u522b8"), @CodeItem(value="CAT9", text="\u7c7b\u522b9", realtext="\u7c7b\u522b9")})
public class ModelUserCatCodeListModel
extends StaticCodeListModelBase {
    public static final String CAT1 = "CAT1";
    public static final String CAT2 = "CAT2";
    public static final String CAT3 = "CAT3";
    public static final String CAT4 = "CAT4";
    public static final String CAT5 = "CAT5";
    public static final String CAT6 = "CAT6";
    public static final String CAT7 = "CAT7";
    public static final String CAT8 = "CAT8";
    public static final String CAT9 = "CAT9";

    public ModelUserCatCodeListModel() {
        this.initAnnotation(ModelUserCatCodeListModel.class);
        this.setUserData("RESERVEMODELV2");
        this.setUserData2("ModelUserCat");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ModelUserCatCodeListModel");
    }
}

