/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.UtilityEx;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class StringBuilderEx {
    protected Writer writer = null;

    public StringBuilderEx() {
        this.Reset();
    }

    public StringBuilderEx(Writer writer) {
        if (this.writer != null) {
            this.writer = null;
        }
        this.writer = writer;
    }

    public void Reset() {
        if (this.writer != null) {
            this.writer = null;
        }
        this.writer = new StringWriter();
    }

    public void Append(String strFormat) {
        try {
            this.writer.write(strFormat);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AppendEx(String strFormat) {
        try {
            this.writer.write(String.format(strFormat, ""));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1) {
        try {
            this.writer.write(String.format(strFormat, obj1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        try {
            this.writer.write(String.format(strFormat, obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Append(String strFormat, Object[] arrList) {
        try {
            int nArrCount = arrList.length;
            switch (nArrCount) {
                case 0: {
                    this.writer.write(strFormat);
                    break;
                }
                case 1: {
                    this.writer.write(String.format(strFormat, arrList[0]));
                    break;
                }
                case 2: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1]));
                    break;
                }
                case 3: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2]));
                    break;
                }
                case 4: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3]));
                    break;
                }
                case 5: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4]));
                    break;
                }
                case 6: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5]));
                    break;
                }
                case 7: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6]));
                    break;
                }
                case 8: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7]));
                    break;
                }
                case 9: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8]));
                    break;
                }
                case 10: {
                    this.writer.write(String.format(strFormat, arrList[0], arrList[1], arrList[2], arrList[3], arrList[4], arrList[5], arrList[6], arrList[7], arrList[8], arrList[9]));
                    break;
                }
                default: {
                    this.writer.write(strFormat);
                    break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return this.writer.toString();
    }

    public Writer getWriter() {
        return this.writer;
    }
}

