/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.data;

import java.util.HashMap;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;

public interface IDataObject
extends ISimpleDataObject {
    public void set(String var1, Object var2) throws Exception;

    public boolean remove(String var1) throws Exception;

    public void reset();

    public void copyTo(IDataObject var1, String var2, boolean var3) throws Exception;

    @Override
    public boolean contains(String var1) throws Exception;

    public void fillMap(HashMap<String, Object> var1) throws Exception;

    public void fillJSONObject(JSONObject var1, boolean var2) throws Exception;

    public void fillJSONObject(JSONObject var1, boolean var2, boolean var3) throws Exception;

    public void fillXmlNode(XmlNode var1, boolean var2) throws Exception;

    public void copyTo(IDataObject var1, boolean var2) throws Exception;

    public void copyTo(IDataObject var1, boolean var2, boolean var3) throws Exception;

    public void proxy(IDataObject var1);
}

