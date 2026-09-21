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

@CodeList(id="05a26e093314b3d0bc4e9c90fb07b9e6", name="\u4e91\u7cfb\u7edf\u5e94\u7528\u670d\u52a1\u5668\u6807\u8bc6", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="AS01", text="\u670d\u52a1\u566801", realtext="\u670d\u52a1\u566801"), @CodeItem(value="AS02", text="\u670d\u52a1\u566802", realtext="\u670d\u52a1\u566802"), @CodeItem(value="AS03", text="\u670d\u52a1\u566803", realtext="\u670d\u52a1\u566803"), @CodeItem(value="AS04", text="\u670d\u52a1\u566804", realtext="\u670d\u52a1\u566804")})
public class SystemASSNCodeListModel
extends StaticCodeListModelBase {
    public static final String AS01 = "AS01";
    public static final String AS02 = "AS02";
    public static final String AS03 = "AS03";
    public static final String AS04 = "AS04";

    public SystemASSNCodeListModel() {
        this.initAnnotation(SystemASSNCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemASSNCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SystemASSNCodeListModel");
    }
}

