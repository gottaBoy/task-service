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

@CodeList(id="d4f21447a96f23efaad970006ecbe75a", name="\u8868\u683c\u5217\u5bbd\u5ea6\u5355\u4f4d", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="PX", text="px", realtext="px", userdata="\u50cf\u7d20\u5355\u4f4d"), @CodeItem(value="STAR", text="*", realtext="*", userdata="\u5269\u4f59\u5bbd\u5ea6\u7684\u5757\uff0c\u4e00\u4e2a\u661f\u4ee3\u8868\u4e00\u5757\uff0c\u5269\u4f59\u5bbd\u5ea6\u9664\u4ee5\u603b\u5757\u6570\u5f97\u51fa\u6bcf\u5757\u7684\u5bbd\u5ea6\uff0c\u5bbd\u5ea6\u4e58\u4ee5\u5757\u5bbd\u5ea6\u5c31\u662f\u5b9e\u9645\u5bbd\u5ea6")})
public class DEGridColWidthUnitTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String PX = "PX";
    public static final String STAR = "STAR";

    public DEGridColWidthUnitTypeCodeListModel() {
        this.initAnnotation(DEGridColWidthUnitTypeCodeListModel.class);
        this.setUserData("IGNOREMODELDSL2");
        this.setUserData2("GridColWidthUnitType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColWidthUnitTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEGridColWidthUnitTypeCodeListModel");
    }
}

