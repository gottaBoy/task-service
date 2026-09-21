/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Ajax;

import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelInterfaceMeta(title="\u5f02\u6b65\u5904\u7406\u5355\u9879\u6570\u636e\u754c\u9762\u90e8\u4ef6\u5904\u7406\u5668\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
@PSModelRTIgnoreMeta
public interface IPSSDAjaxControlHandler
extends IPSAjaxControlHandler {
    public static final String ACTION_LOAD = "load";
    public static final String ACTION_CREATE = "create";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_REMOVE = "remove";
    public static final String ACTION_CLONE = "clone";
    public static final String ACTION_WFSTART = "wfstart";

    public int getReadTimeout();

    public int getCreateTimeout();

    public int getUpdateTimeout();

    public int getRemoveTimeout();
}

