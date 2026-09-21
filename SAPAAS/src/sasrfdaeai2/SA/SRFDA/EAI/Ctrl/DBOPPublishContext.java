/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Ctrl.IDBOPPublishContext;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.Writer;

public class DBOPPublishContext
implements IDBOPPublishContext {
    private int nTabCount = 0;
    private Writer writer = null;
    private String strPreFix = "";
    private int nCursorCount = 1;

    @Override
    public void AppendCodeLine(String strCode) throws Exception {
        String line;
        BufferedReader br = new BufferedReader(new StringReader(strCode));
        while ((line = br.readLine()) != null) {
            this.writer.write(this.strPreFix);
            this.writer.write(line);
            this.writer.write("\n");
        }
        br.close();
    }

    @Override
    public void AppendComment(String strCommentStart, String strCode) throws Exception {
        String line;
        BufferedReader br = new BufferedReader(new StringReader(strCode));
        while ((line = br.readLine()) != null) {
            this.writer.write(this.strPreFix);
            this.writer.write(strCommentStart);
            this.writer.write(line);
            this.writer.write("\n");
        }
        br.close();
    }

    @Override
    public int GetCursorCount() {
        return this.nCursorCount++;
    }

    @Override
    public void AppendCode(String strCode) throws Exception {
        this.writer.write(strCode);
    }

    @Override
    public void AppendNewLine() throws Exception {
        this.writer.write("\n");
        this.writer.write(this.strPreFix);
    }

    @Override
    public void ShiftLeft() {
        --this.nTabCount;
        if (this.nTabCount < 0) {
            this.nTabCount = 0;
        }
        this.CalcPreFix();
    }

    @Override
    public void ShiftRight() {
        ++this.nTabCount;
        this.CalcPreFix();
    }

    private void CalcPreFix() {
        this.strPreFix = "";
        int i = 0;
        while (i < this.nTabCount) {
            this.strPreFix = String.valueOf(this.strPreFix) + "    ";
            ++i;
        }
    }

    @Override
    public Writer getWriter() {
        return this.writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}

