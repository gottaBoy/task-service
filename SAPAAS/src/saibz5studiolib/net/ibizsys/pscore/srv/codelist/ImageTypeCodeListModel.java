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

@CodeList(id="239500a699f573c973c72433cd6a700b", name="\u56fe\u7247\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={@CodeItem(value="ICON", text="\u56fe\u6807", realtext="\u56fe\u6807"), @CodeItem(value="IMAGE", text="\u56fe\u7247", realtext="\u56fe\u7247")})
public class ImageTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String ICON = "ICON";
    public static final String IMAGE = "IMAGE";

    public ImageTypeCodeListModel() {
        this.initAnnotation(ImageTypeCodeListModel.class);
        this.setUserData2("ImageType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ImageTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ImageTypeCodeListModel");
    }
}

