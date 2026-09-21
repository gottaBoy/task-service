/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import java.io.Writer;

public interface IDBOPPublishContext {
    public Writer getWriter();

    public void ShiftLeft();

    public void ShiftRight();

    public void AppendCodeLine(String var1) throws Exception;

    public void AppendNewLine() throws Exception;

    public void AppendCode(String var1) throws Exception;

    public int GetCursorCount();

    public void AppendComment(String var1, String var2) throws Exception;
}

