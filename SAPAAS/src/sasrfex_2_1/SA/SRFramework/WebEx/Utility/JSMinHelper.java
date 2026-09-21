/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx.Utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class JSMinHelper {
    private static final int EOF = -1;
    private PushbackInputStream in;
    private OutputStream out;
    private int theA;
    private int theB;

    public JSMinHelper(InputStream in, OutputStream out) {
        this.in = new PushbackInputStream(in);
        this.out = out;
    }

    static boolean isAlphanum(int c) {
        return c >= 97 && c <= 122 || c >= 48 && c <= 57 || c >= 65 && c <= 90 || c == 95 || c == 36 || c == 92 || c > 126;
    }

    int get() throws IOException {
        int c = this.in.read();
        if (c >= 32 || c == 10 || c == -1) {
            return c;
        }
        if (c == 13) {
            return 10;
        }
        return 32;
    }

    int peek() throws IOException {
        int lookaheadChar = this.in.read();
        this.in.unread(lookaheadChar);
        return lookaheadChar;
    }

    int next() throws IOException, UnterminatedCommentException {
        int c = this.get();
        if (c == 47) {
            switch (this.peek()) {
                case 47: {
                    while ((c = this.get()) > 10) {
                    }
                    return c;
                }
                case 42: {
                    this.get();
                    block9: while (true) {
                        switch (this.get()) {
                            case 42: {
                                if (this.peek() != 47) continue block9;
                                this.get();
                                return 32;
                            }
                            case -1: {
                                throw new UnterminatedCommentException();
                            }
                        }
                    }
                }
            }
            return c;
        }
        return c;
    }

    void action(int d) throws IOException, UnterminatedRegExpLiteralException, UnterminatedCommentException, UnterminatedStringLiteralException {
        switch (d) {
            case 1: {
                this.out.write(this.theA);
            }
            case 2: {
                this.theA = this.theB;
                if (this.theA == 39 || this.theA == 34) {
                    while (true) {
                        this.out.write(this.theA);
                        this.theA = this.get();
                        if (this.theA == this.theB) break;
                        if (this.theA <= 10) {
                            throw new UnterminatedStringLiteralException();
                        }
                        if (this.theA != 92) continue;
                        this.out.write(this.theA);
                        this.theA = this.get();
                    }
                }
            }
            case 3: {
                this.theB = this.next();
                if (this.theB != 47 || this.theA != 40 && this.theA != 44 && this.theA != 61 && this.theA != 58 && this.theA != 91 && this.theA != 33 && this.theA != 38 && this.theA != 124 && this.theA != 63 && this.theA != 123 && this.theA != 125 && this.theA != 59 && this.theA != 10) break;
                this.out.write(this.theA);
                this.out.write(this.theB);
                while (true) {
                    this.theA = this.get();
                    if (this.theA == 47) break;
                    if (this.theA == 92) {
                        this.out.write(this.theA);
                        this.theA = this.get();
                    } else if (this.theA <= 10) {
                        throw new UnterminatedRegExpLiteralException();
                    }
                    this.out.write(this.theA);
                }
                this.theB = this.next();
            }
        }
    }

    public void jsmin() throws IOException, UnterminatedRegExpLiteralException, UnterminatedCommentException, UnterminatedStringLiteralException {
        this.theA = 10;
        this.action(3);
        while (this.theA != -1) {
            block0 : switch (this.theA) {
                case 32: {
                    if (JSMinHelper.isAlphanum(this.theB)) {
                        this.action(1);
                        break;
                    }
                    this.action(2);
                    break;
                }
                case 10: {
                    switch (this.theB) {
                        case 40: 
                        case 43: 
                        case 45: 
                        case 91: 
                        case 123: {
                            this.action(1);
                            break block0;
                        }
                        case 32: {
                            this.action(3);
                            break block0;
                        }
                    }
                    if (JSMinHelper.isAlphanum(this.theB)) {
                        this.action(1);
                        break;
                    }
                    this.action(2);
                    break;
                }
                default: {
                    switch (this.theB) {
                        case 32: {
                            if (JSMinHelper.isAlphanum(this.theA)) {
                                this.action(1);
                                break block0;
                            }
                            this.action(3);
                            break block0;
                        }
                        case 10: {
                            switch (this.theA) {
                                case 34: 
                                case 39: 
                                case 41: 
                                case 43: 
                                case 45: 
                                case 93: 
                                case 125: {
                                    this.action(1);
                                    break block0;
                                }
                            }
                            if (JSMinHelper.isAlphanum(this.theA)) {
                                this.action(1);
                                break block0;
                            }
                            this.action(3);
                            break block0;
                        }
                    }
                    this.action(1);
                }
            }
        }
        this.out.flush();
    }

    class UnterminatedCommentException
    extends Exception {
        UnterminatedCommentException() {
        }
    }

    class UnterminatedRegExpLiteralException
    extends Exception {
        UnterminatedRegExpLiteralException() {
        }
    }

    class UnterminatedStringLiteralException
    extends Exception {
        UnterminatedStringLiteralException() {
        }
    }
}

