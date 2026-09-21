/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

public interface IViewMessage {
    public static final String MSGPOS_TOP = "TOP";
    public static final String MSGPOS_BODY = "BODY";
    public static final String MSGPOS_BOTTOM = "BOTTOM";
    public static final String MSGPOS_POPUP = "POPUP";
    public static final String MSGTYPE_INFO = "INFO";
    public static final String MSGTYPE_WARN = "WARN";
    public static final String MSGTYPE_ERROR = "ERROR";
    public static final String MSGTYPE_CUSTOM = "CUSTOM";

    public String getId();

    public String getPosition();

    public String getMessage();

    public String getMessageType();

    public String getTitle();

    public boolean isEnableRemove();
}

