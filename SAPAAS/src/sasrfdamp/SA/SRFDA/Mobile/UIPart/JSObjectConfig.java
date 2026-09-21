/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Mobile.UIPart;

import java.util.Hashtable;

public class JSObjectConfig {
    protected String strName;
    protected Hashtable<String, String> properties = new Hashtable();
    protected Hashtable<String, Integer> listeners = new Hashtable();

    public String getName() {
        return this.strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public Hashtable<String, String> getProperties() {
        return this.properties;
    }

    public Hashtable<String, Integer> getListeners() {
        return this.listeners;
    }
}

