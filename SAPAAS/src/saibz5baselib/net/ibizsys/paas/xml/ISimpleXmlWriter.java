/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.xml;

public interface ISimpleXmlWriter {
    public void writeRaw(String var1);

    public void writeStartElement(String var1);

    public void writeComment(String var1);

    public void writeCDATA(String var1);

    public void writeValue(String var1);

    public void writeAttributeString(String var1, String var2);

    public void writeEndElement();
}

