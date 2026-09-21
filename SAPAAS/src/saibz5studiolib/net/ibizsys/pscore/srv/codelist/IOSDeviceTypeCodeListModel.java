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

@CodeList(id="37d808c1cc5aa21c605c19eda5810afa", name="IOS\u8bbe\u5907\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="IPHONE", text="iPhone", realtext="iPhone"), @CodeItem(value="IPAD", text="iPad", realtext="iPad"), @CodeItem(value="APPLEWATCH", text="AppleWatch", realtext="AppleWatch")})
public class IOSDeviceTypeCodeListModel
extends StaticCodeListModelBase {
    public static final String IPHONE = "IPHONE";
    public static final String IPAD = "IPAD";
    public static final String APPLEWATCH = "APPLEWATCH";

    public IOSDeviceTypeCodeListModel() {
        this.initAnnotation(IOSDeviceTypeCodeListModel.class);
        this.setUserData2("IOSDeviceType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSDeviceTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSDeviceTypeCodeListModel");
    }
}

