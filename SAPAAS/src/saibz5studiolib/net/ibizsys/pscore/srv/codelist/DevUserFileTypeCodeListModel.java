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

@CodeList(id="6d7931a94153286d27135ade2c0be38e", name="\u6587\u4ef6\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="SQL", text="sql", realtext="sql"), @CodeItem(value="JS", text="js", realtext="js"), @CodeItem(value="HTML", text="html", realtext="html"), @CodeItem(value="JAVA", text="java", realtext="java"), @CodeItem(value="TXT", text="txt", realtext="txt")})
public class DevUserFileTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String SQL = "SQL";
    public static final String JS = "JS";
    public static final String HTML = "HTML";
    public static final String JAVA = "JAVA";
    public static final String TXT = "TXT";

    public DevUserFileTypeCodeListModel() {
        this.initAnnotation(DevUserFileTypeCodeListModel.class);
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserFileTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DevUserFileTypeCodeListModel");
    }
}

