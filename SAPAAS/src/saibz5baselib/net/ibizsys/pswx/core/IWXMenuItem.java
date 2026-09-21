/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.pswx.core;

import java.util.ArrayList;
import net.sf.json.JSONObject;

public interface IWXMenuItem {
    public static final String WXFUNC_CLICK = "click";
    public static final String WXFUNC_VIEW = "view";
    public static final String WXFUNC_SCANCODE_PUSH = "scancode_push";
    public static final String WXFUNC_SCANCODE_WAITMSG = "scancode_waitmsg";
    public static final String WXFUNC_PIC_SYSPHOTO = "pic_sysphoto";
    public static final String WXFUNC_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    public static final String WXFUNC_PIC_WEIXIN = "pic_weixin";
    public static final String WXFUNC_LOCATION_SELECT = "location_select";

    public String getId();

    public String getPId();

    public String getText();

    public ArrayList<IWXMenuItem> getItems();

    public String getWXFunc();

    public String getClickTag();

    public JSONObject toJSON();
}

