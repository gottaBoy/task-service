/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub.Util;

import SA.SRFDA.PS.Core.Pub.Util.PSTemplLimitException;
import java.io.StringWriter;

public class PSTemplWriter
extends StringWriter {
    private int nLength = 0;
    private int nLimit = -1;

    @Override
    public StringWriter append(char c) {
        ++this.nLength;
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        return super.append(c);
    }

    @Override
    public StringWriter append(CharSequence csq, int start, int end) {
        this.nLength += end - start;
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        return super.append(csq, start, end);
    }

    @Override
    public StringWriter append(CharSequence csq) {
        this.nLength += csq.length();
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        return super.append(csq);
    }

    @Override
    public void write(char[] cbuf, int off, int len) {
        this.nLength += len;
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(int c) {
        ++this.nLength;
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        super.write(c);
    }

    @Override
    public void write(String str, int off, int len) {
        this.nLength += len;
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        super.write(str, off, len);
    }

    @Override
    public void write(String str) {
        this.nLength += str.length();
        if (this.nLimit > 0 && this.nLength > this.nLimit) {
            throw new PSTemplLimitException(this.nLimit, null);
        }
        super.write(str);
    }

    public int length() {
        return this.nLength;
    }
}

