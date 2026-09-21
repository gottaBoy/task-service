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

@CodeList(id="dc6b80b7e77d58207b5a05cecbec4830", name="Android\u6743\u9650\u8bbe\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="PHONE", text="Phone", realtext="Phone"), @CodeItem(value="SMS", text="SMS", realtext="SMS"), @CodeItem(value="LOCATION", text="Location", realtext="Location"), @CodeItem(value="CONTACTS", text="Contacts", realtext="Contacts"), @CodeItem(value="CAMERA", text="Camera", realtext="Camera"), @CodeItem(value="BLUETOOTH", text="Bluetooth", realtext="Bluetooth"), @CodeItem(value="FLASHLIGHT", text="Flashlight", realtext="Flashlight"), @CodeItem(value="SYSLOG", text="Sys log", realtext="Sys log"), @CodeItem(value="AUTOSTART", text="Autostart", realtext="Autostart"), @CodeItem(value="RECORD", text="Record", realtext="Record")})
public class AndroidPermissionCodeListModel
extends StaticCodeListModelBase {
    public static final String PHONE = "PHONE";
    public static final String SMS = "SMS";
    public static final String LOCATION = "LOCATION";
    public static final String CONTACTS = "CONTACTS";
    public static final String CAMERA = "CAMERA";
    public static final String BLUETOOTH = "BLUETOOTH";
    public static final String FLASHLIGHT = "FLASHLIGHT";
    public static final String SYSLOG = "SYSLOG";
    public static final String AUTOSTART = "AUTOSTART";
    public static final String RECORD = "RECORD";

    public AndroidPermissionCodeListModel() {
        this.initAnnotation(AndroidPermissionCodeListModel.class);
        this.setUserData2("AndroidPermission");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AndroidPermissionCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AndroidPermissionCodeListModel");
    }
}

