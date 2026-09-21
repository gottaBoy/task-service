/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.control.menu;

import java.util.ArrayList;
import net.ibizsys.paas.control.menu.IMenuItem;
import net.sf.json.JSONObject;

public interface IMenuItemFiller {
    public ArrayList<JSONObject> toJSONObjects(IMenuItem var1) throws Exception;
}

