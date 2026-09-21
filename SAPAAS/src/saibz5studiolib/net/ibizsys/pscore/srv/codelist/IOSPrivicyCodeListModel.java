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

@CodeList(id="c681fd1763b77b01901af35c0a33f29d", name="IOS\u6743\u9650\u8bbe\u7f6e", type="STATIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={@CodeItem(value="CAMERA", text="Camera", realtext="Camera"), @CodeItem(value="MICROPHONE", text="Microphone", realtext="Microphone"), @CodeItem(value="READIMAGE", text="Read Image", realtext="Read Image"), @CodeItem(value="ADDIMAGE", text="Add Image", realtext="Add Image"), @CodeItem(value="CONTACTS", text="Contacts", realtext="Contacts"), @CodeItem(value="LOC", text="Loc\uff08while using\uff09", realtext="Loc\uff08while using\uff09"), @CodeItem(value="LOCATION", text="Location\uff08always\uff09", realtext="Location\uff08always\uff09"), @CodeItem(value="BLUETOOTHSHARING", text="Bluetooth Sharing", realtext="Bluetooth Sharing"), @CodeItem(value="CALENDARS", text="Calendars", realtext="Calendars"), @CodeItem(value="HEALTHSHARING", text="Health Sharing", realtext="Health Sharing"), @CodeItem(value="HEALTHUPDATE", text="Health Update", realtext="Health Update"), @CodeItem(value="HOMEKIT", text="HomeKit", realtext="HomeKit"), @CodeItem(value="MOTION_FITNESS", text="Motion & Fitness", realtext="Motion & Fitness"), @CodeItem(value="REMINDERS", text="Reminders", realtext="Reminders"), @CodeItem(value="SIRI", text="SIRI", realtext="SIRI"), @CodeItem(value="SPEECHRECOG", text="Speech Recog", realtext="Speech Recog"), @CodeItem(value="MEDIALIBRARY", text="Media Library", realtext="Media Library"), @CodeItem(value="READNFC", text="Read NFC", realtext="Read NFC")})
public class IOSPrivicyCodeListModel
extends StaticCodeListModelBase {
    public static final String CAMERA = "CAMERA";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String READIMAGE = "READIMAGE";
    public static final String ADDIMAGE = "ADDIMAGE";
    public static final String CONTACTS = "CONTACTS";
    public static final String LOC = "LOC";
    public static final String LOCATION = "LOCATION";
    public static final String BLUETOOTHSHARING = "BLUETOOTHSHARING";
    public static final String CALENDARS = "CALENDARS";
    public static final String HEALTHSHARING = "HEALTHSHARING";
    public static final String HEALTHUPDATE = "HEALTHUPDATE";
    public static final String HOMEKIT = "HOMEKIT";
    public static final String MOTION_FITNESS = "MOTION_FITNESS";
    public static final String REMINDERS = "REMINDERS";
    public static final String SIRI = "SIRI";
    public static final String SPEECHRECOG = "SPEECHRECOG";
    public static final String MEDIALIBRARY = "MEDIALIBRARY";
    public static final String READNFC = "READNFC";

    public IOSPrivicyCodeListModel() {
        this.initAnnotation(IOSPrivicyCodeListModel.class);
        this.setUserData2("IOSPrivicy");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSPrivicyCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.IOSPrivicyCodeListModel");
    }
}

