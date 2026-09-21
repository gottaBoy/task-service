/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFDA.EAI.Ctrl.Transformer.BaseTransformer;
import SA.SRFDA.EAI.Ctrl.Transformer.PackagePart;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.text.ParseException;
import java.util.TreeMap;

public abstract class StringTransformer
extends BaseTransformer {
    public static final String TAG_HEADERBYTESIZE = "HEADERBYTESIZE";
    public static final String TAG_HEADER = "HEADER";
    public static final String TAG_HEADERFORMAT = "HEADERFORMAT";
    public static final String TAG_CONTENTFORMAT = "CONTENTFORMAT";
    public static final String TAG_STUFFCHAR = "STUFFCHAR";
    public static final String TAG_ENCODING = "ENCODING";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_SEPERATOR = "SEPERATOR";
    public static final String TAG_DATATYPE_STRING = "STRING";
    public static final String TAG_DATATYPE_NSTRING = "NSTRING";
    public static final String TAG_DATATYPE_GBSTRING = "GBSTRING";
    public static final String TAG_DATATYPE_INTEGER = "INTEGER";
    public static final String TAG_DATATYPE_DATE = "DATE";
    public static final String TAG_DATATYPE_TIME = "TIME";
    public static final String TAG_DATATYPE_DATETIME = "DATETIME";
    public static final String TAG_DATATYPE_HEXBINARY = "HEXBINARY";
    public static final String TAG_DATATYPE_BOOLEAN = "BOOLEAN";
    public static final String TAG_DATATYPE_FLOAT = "FLOAT";
    public static final String TAG_DATATYPE_DOUBLE = "DOUBLE";
    public static final String TAG_DATATYPE_BITINT = "BITINT";
    public static final String TAG_DATATYPE_HEADERSIZE = "HEADERSIZE";
    public static final String TAG_DATATYPE_CONTENTSIZE = "CONTENTSIZE";
    public static final String TAG_DATATYPE_TOTALSIZE = "TOTALSIZE";
    public static final String TAG_XMLHEADER = "XMLHEADER";

    public StringTransformer() {
        throw new Error("Unresolved compilation problems: \n\tThe import org.mule cannot be resolved\n\tThe hierarchy of the type StringTransformer is inconsistent\n");
    }

    public static Object ParseValue(String string, String string2, String string3) throws ParseException {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static Object ParseValue(String string, PackagePart packagePart) throws ParseException {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static String GetStuff(int n, String string) {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static String GetStringValue(BaseDataEntity baseDataEntity, String string, PackagePart packagePart) throws ParseException {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static TreeMap<Integer, PackagePart> ParseHeaderFormat(String string) throws ParseException {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static TreeMap<Integer, PackagePart> ParseContentFormat(String string) throws ParseException {
        throw new Error("Unresolved compilation problem: \n");
    }

    public static int GetHeaderSize(TreeMap<Integer, PackagePart> treeMap) {
        throw new Error("Unresolved compilation problem: \n");
    }
}

