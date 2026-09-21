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

@CodeList(id="bcd1356fa2e33ddf70d97dc73e204efe", name="\u4e91\u7cfb\u7edf\u540e\u53f0\u4efb\u52a1\u8fd0\u884c\u5bb9\u5668", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SC01", text="\u670d\u52a1\u5bb9\u566801", realtext="\u670d\u52a1\u5bb9\u566801"), @CodeItem(value="SC02", text="\u670d\u52a1\u5bb9\u566802", realtext="\u670d\u52a1\u5bb9\u566802"), @CodeItem(value="SC03", text="\u670d\u52a1\u5bb9\u566803", realtext="\u670d\u52a1\u5bb9\u566803"), @CodeItem(value="SC04", text="\u670d\u52a1\u5bb9\u566804", realtext="\u670d\u52a1\u5bb9\u566804"), @CodeItem(value="USER", text="\u81ea\u5b9a\u4e49\u5bb9\u5668", realtext="\u81ea\u5b9a\u4e49\u5bb9\u5668")})
public class SysBackServiceContainerCodeListModel
extends StaticCodeListModelBase {
    public static final String SC01 = "SC01";
    public static final String SC02 = "SC02";
    public static final String SC03 = "SC03";
    public static final String SC04 = "SC04";
    public static final String USER = "USER";

    public SysBackServiceContainerCodeListModel() {
        this.initAnnotation(SysBackServiceContainerCodeListModel.class);
        this.setUserData2("BackendTaskContainer");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceContainerCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SysBackServiceContainerCodeListModel");
    }
}

