/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.XML;

import java.io.IOException;
import java.io.Writer;
import java.util.Stack;

public class XmlWriter {
    private Writer writer;
    private Stack stack;
    private StringBuffer attrs;
    private boolean empty;
    private boolean closed;

    public XmlWriter(Writer writer) {
        this.writer = writer;
        this.closed = true;
        this.stack = new Stack();
    }

    public XmlWriter writeEntity(String name) throws Exception {
        this.closeOpeningTag();
        this.closed = false;
        this.writer.write("<");
        this.writer.write(name);
        this.stack.add(name);
        this.empty = true;
        return this;
    }

    private void closeOpeningTag() throws IOException {
        if (!this.closed) {
            this.writeAttributes();
            this.closed = true;
            this.writer.write(">");
        }
    }

    private void writeAttributes() throws IOException {
        if (this.attrs != null) {
            this.writer.write(this.attrs.toString());
            this.attrs.setLength(0);
            this.empty = false;
        }
    }

    public XmlWriter writeAttribute(String attr, String value) throws Exception {
        if (this.attrs == null) {
            this.attrs = new StringBuffer();
        }
        this.attrs.append(" ");
        this.attrs.append(attr);
        this.attrs.append("=\"");
        this.attrs.append(XmlWriter.escapeXml(value));
        this.attrs.append("\"");
        return this;
    }

    public XmlWriter endEntity() throws Exception {
        if (this.stack.empty()) {
            throw new Exception("Called endEntity too many times. ");
        }
        String name = (String)this.stack.pop();
        if (name != null) {
            if (this.empty) {
                this.writeAttributes();
                this.writer.write("/>");
            } else {
                this.writer.write("</");
                this.writer.write(name);
                this.writer.write(">");
            }
            this.empty = false;
            this.closed = true;
        }
        return this;
    }

    public void close() throws Exception {
        if (!this.stack.empty()) {
            throw new Exception("Tags are not all closed. Possibly, " + this.stack.pop() + " is unclosed. ");
        }
    }

    public XmlWriter writeText(String text) throws Exception {
        this.closeOpeningTag();
        this.empty = false;
        this.writer.write(XmlWriter.escapeXml(text));
        return this;
    }

    public static String escapeXml(String str) {
        str = XmlWriter.replaceString(str, "&", "&amp;");
        str = XmlWriter.replaceString(str, "<", "&lt;");
        str = XmlWriter.replaceString(str, ">", "&gt;");
        str = XmlWriter.replaceString(str, "\"", "&quot;");
        str = XmlWriter.replaceString(str, "'", "&apos;");
        return str;
    }

    public static String replaceString(String text, String repl, String with) {
        return XmlWriter.replaceString(text, repl, with, -1);
    }

    public static String replaceString(String text, String repl, String with, int max) {
        if (text == null) {
            return null;
        }
        StringBuffer buffer = new StringBuffer(text.length());
        int start = 0;
        int end = 0;
        while ((end = text.indexOf(repl, start)) != -1) {
            buffer.append(text.substring(start, end)).append(with);
            start = end + repl.length();
            if (--max == 0) break;
        }
        buffer.append(text.substring(start));
        return buffer.toString();
    }
}

