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

@CodeList(id="5ed4c07b98e9c4c091f767627a1ec805", name="\u56fe\u7247\u6765\u6e90", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="FONTAWESOME", text="Font Awesome", realtext="Font Awesome"), @CodeItem(value="OTHER", text="\u5176\u5b83", realtext="\u5176\u5b83")})
public class ImageSourceCodeListModel
extends StaticCodeListModelBase {
    public static final String FONTAWESOME = "FONTAWESOME";
    public static final String OTHER = "OTHER";

    public ImageSourceCodeListModel() {
        this.initAnnotation(ImageSourceCodeListModel.class);
        this.setUserData2("ImageSource");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ImageSourceCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ImageSourceCodeListModel");
    }
}

