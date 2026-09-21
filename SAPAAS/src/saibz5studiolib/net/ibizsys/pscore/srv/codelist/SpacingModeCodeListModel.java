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

@CodeList(id="3ba4e010ef6126d24dda5155dc21eae7", name="\u9762\u677f\u9879\u95f4\u9694\u6a21\u5f0f", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="OUTERNONE", text="Outer none", realtext="Outer none"), @CodeItem(value="OUTERSMALL", text="Outer small", realtext="Outer small"), @CodeItem(value="OUTERMEDIUM", text="Outer medium", realtext="Outer medium"), @CodeItem(value="OUTERLARGE", text="Outer large", realtext="Outer large"), @CodeItem(value="INNERNONE", text="Inner none", realtext="Inner none"), @CodeItem(value="INNERSMALL", text="Inner small", realtext="Inner small"), @CodeItem(value="INNERMEDIUM", text="Inner medium", realtext="Inner medium"), @CodeItem(value="INNERLARGE", text="Inner large", realtext="Inner large")})
public class SpacingModeCodeListModel
extends StaticCodeListModelBase {
    public static final String OUTERNONE = "OUTERNONE";
    public static final String OUTERSMALL = "OUTERSMALL";
    public static final String OUTERMEDIUM = "OUTERMEDIUM";
    public static final String OUTERLARGE = "OUTERLARGE";
    public static final String INNERNONE = "INNERNONE";
    public static final String INNERSMALL = "INNERSMALL";
    public static final String INNERMEDIUM = "INNERMEDIUM";
    public static final String INNERLARGE = "INNERLARGE";

    public SpacingModeCodeListModel() {
        this.initAnnotation(SpacingModeCodeListModel.class);
        this.setUserData2("SpacingMode");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.SpacingModeCodeListModel");
    }
}

