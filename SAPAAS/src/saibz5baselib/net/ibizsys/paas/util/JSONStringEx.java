/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSON
 *  net.sf.json.JSONException
 */
package net.ibizsys.paas.util;

import java.io.IOException;
import java.io.Writer;
import net.sf.json.JSON;
import net.sf.json.JSONException;

public class JSONStringEx
implements JSON {
    private String strValue = null;

    public JSONStringEx(String strValue) {
        this.strValue = strValue;
    }

    public boolean equals(Object object) {
        return this.strValue.equals(object);
    }

    public int hashCode() {
        return this.strValue.hashCode();
    }

    public boolean isArray() {
        return false;
    }

    public int length() {
        return this.strValue.length();
    }

    public String toString() {
        return this.strValue;
    }

    public String toString(int indentFactor) {
        return this.toString();
    }

    public String toString(int indentFactor, int indent) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < indent) {
            sb.append(' ');
            ++i;
        }
        sb.append(this.toString());
        return sb.toString();
    }

    public Writer write(Writer writer) {
        try {
            writer.write(this.toString());
            return writer;
        }
        catch (IOException e) {
            throw new JSONException((Throwable)e);
        }
    }
}

