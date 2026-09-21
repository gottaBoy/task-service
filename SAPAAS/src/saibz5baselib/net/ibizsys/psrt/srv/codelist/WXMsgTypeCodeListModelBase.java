/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;

@CodeList(id="160cb29c905b8f5975d3ef6c756b0b40", name="\u5fae\u4fe1\u6d88\u606f\u7c7b\u578b", type="STATIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={@CodeItem(value="text", text="text", realtext="text"), @CodeItem(value="image", text="image", realtext="image"), @CodeItem(value="voice", text="voice", realtext="voice"), @CodeItem(value="video", text="video", realtext="video"), @CodeItem(value="location", text="location", realtext="location"), @CodeItem(value="link", text="link", realtext="link"), @CodeItem(value="event", text="event", realtext="event"), @CodeItem(value="simplenews", text="\u5355\u4e00\u56fe\u6587\uff08\u65e0\u56fe\u7247\uff09", realtext="\u5355\u4e00\u56fe\u6587\uff08\u65e0\u56fe\u7247\uff09")})
public abstract class WXMsgTypeCodeListModelBase
extends StaticCodeListModelBase {
    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    public static final String VOICE = "voice";
    public static final String VIDEO = "video";
    public static final String LOCATION = "location";
    public static final String LINK = "link";
    public static final String EVENT = "event";
    public static final String SIMPLENEWS = "simplenews";

    public WXMsgTypeCodeListModelBase() {
        this.initAnnotation(WXMsgTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WXMsgTypeCodeListModel");
    }
}

