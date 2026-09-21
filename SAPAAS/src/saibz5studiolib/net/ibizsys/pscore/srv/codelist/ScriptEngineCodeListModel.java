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

@CodeList(id="3D3788AE-CD2D-432B-8DB6-FE9928D955B2", name="\u811a\u672c\u5f15\u64ce", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="JavaScript", text="JavaScript", realtext="JavaScript"), @CodeItem(value="Groovy", text="Groovy", realtext="Groovy")})
public class ScriptEngineCodeListModel
extends StaticCodeListModelBase {
    public static final String JAVASCRIPT = "JavaScript";
    public static final String GROOVY = "Groovy";

    public ScriptEngineCodeListModel() {
        this.initAnnotation(ScriptEngineCodeListModel.class);
        this.setUserData2("ScriptEngine");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ScriptEngineCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ScriptEngineCodeListModel");
    }
}

