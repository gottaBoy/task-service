package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public abstract class StringTransformer extends BaseTransformer {
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

    public static Object ParseValue(String value, String type, String format) throws ParseException {
        if (type == null || TAG_DATATYPE_STRING.equalsIgnoreCase(type)
                || TAG_DATATYPE_NSTRING.equalsIgnoreCase(type) || TAG_DATATYPE_GBSTRING.equalsIgnoreCase(type)) {
            return value;
        }
        if (value == null) throw new ParseException("Missing " + type + " value", 0);
        String text = value.trim();
        try {
            if (TAG_DATATYPE_INTEGER.equalsIgnoreCase(type)) return Integer.valueOf(text);
            if (TAG_DATATYPE_BITINT.equalsIgnoreCase(type)
                    || TAG_DATATYPE_HEADERSIZE.equalsIgnoreCase(type)
                    || TAG_DATATYPE_CONTENTSIZE.equalsIgnoreCase(type)
                    || TAG_DATATYPE_TOTALSIZE.equalsIgnoreCase(type)) return Long.valueOf(text);
            if (TAG_DATATYPE_FLOAT.equalsIgnoreCase(type)) return Float.valueOf(text);
            if (TAG_DATATYPE_DOUBLE.equalsIgnoreCase(type)) return Double.valueOf(text);
            if (TAG_DATATYPE_BOOLEAN.equalsIgnoreCase(type)) {
                if ("1".equals(text) || "true".equalsIgnoreCase(text)) return Boolean.TRUE;
                if ("0".equals(text) || "false".equalsIgnoreCase(text)) return Boolean.FALSE;
                throw new IllegalArgumentException("Invalid boolean: " + text);
            }
            if (TAG_DATATYPE_HEXBINARY.equalsIgnoreCase(type)) {
                if ((text.length() & 1) != 0) throw new IllegalArgumentException("Odd hex length");
                byte[] bytes = new byte[text.length() / 2];
                for (int i = 0; i < bytes.length; i++) {
                    int a = Character.digit(text.charAt(i * 2), 16);
                    int b = Character.digit(text.charAt(i * 2 + 1), 16);
                    if (a < 0 || b < 0) throw new IllegalArgumentException("Invalid hex digit");
                    bytes[i] = (byte)((a << 4) | b);
                }
                return bytes;
            }
        } catch (IllegalArgumentException ex) {
            throw new ParseException("Invalid " + type + " value: " + text, 0);
        }
        if (TAG_DATATYPE_DATE.equalsIgnoreCase(type) || TAG_DATATYPE_TIME.equalsIgnoreCase(type)
                || TAG_DATATYPE_DATETIME.equalsIgnoreCase(type)) {
            String pattern = format != null && format.length() != 0 ? format
                    : TAG_DATATYPE_DATE.equalsIgnoreCase(type) ? "yyyy-MM-dd"
                    : TAG_DATATYPE_TIME.equalsIgnoreCase(type) ? "HH:mm:ss" : "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat parser;
            try {
                parser = new SimpleDateFormat(pattern);
            } catch (IllegalArgumentException ex) {
                throw new ParseException("Invalid date pattern: " + pattern, 0);
            }
            parser.setLenient(false);
            java.text.ParsePosition position = new java.text.ParsePosition(0);
            Date date = parser.parse(text, position);
            if (date == null || position.getIndex() != text.length()) {
                throw new ParseException("Invalid date/time: " + text, position.getErrorIndex());
            }
            return date;
        }
        throw new ParseException("Unknown data type: " + type, 0);
    }

    public static Object ParseValue(String value, PackagePart part) throws ParseException {
        return ParseValue(value, part.getDataType(), part.getFormat());
    }

    public static String GetStuff(int count, String fill) {
        if (count < 0 || fill == null || fill.length() != 1) {
            throw new IllegalArgumentException("Padding requires a single character and nonnegative count");
        }
        StringBuilder result = new StringBuilder(count);
        for (int i = 0; i < count; i++) result.append(fill);
        return result.toString();
    }

    public static String GetStringValue(BaseDataEntity entity, String field, PackagePart part) throws ParseException {
        Object value = entity.GetParamValue(field);
        String type = part.getDataType();
        if (value == null) {
            if (TAG_DATATYPE_STRING.equalsIgnoreCase(type)
                    || TAG_DATATYPE_NSTRING.equalsIgnoreCase(type)
                    || TAG_DATATYPE_GBSTRING.equalsIgnoreCase(type)) return "";
            throw new ParseException("Missing field: " + field, 0);
        }
        if (TAG_DATATYPE_HEXBINARY.equalsIgnoreCase(type)) {
            if (!(value instanceof byte[])) throw new ParseException("Expected byte[]: " + field, 0);
            StringBuilder hex = new StringBuilder();
            for (byte b : (byte[])value) {
                hex.append(Character.forDigit((b >>> 4) & 15, 16));
                hex.append(Character.forDigit(b & 15, 16));
            }
            return hex.toString().toUpperCase(java.util.Locale.ROOT);
        }
        if (TAG_DATATYPE_DATE.equalsIgnoreCase(type) || TAG_DATATYPE_TIME.equalsIgnoreCase(type)
                || TAG_DATATYPE_DATETIME.equalsIgnoreCase(type)) {
            if (!(value instanceof Date)) throw new ParseException("Expected date: " + field, 0);
            String pattern = part.getFormat();
            if (pattern == null || pattern.length() == 0) {
                pattern = TAG_DATATYPE_DATE.equalsIgnoreCase(type) ? "yyyy-MM-dd"
                        : TAG_DATATYPE_TIME.equalsIgnoreCase(type) ? "HH:mm:ss" : "yyyy-MM-dd HH:mm:ss";
            }
            return new SimpleDateFormat(pattern).format((Date)value);
        }
        if (TAG_DATATYPE_BOOLEAN.equalsIgnoreCase(type)) {
            if (value instanceof Boolean) return Boolean.TRUE.equals(value) ? "1" : "0";
            return Boolean.TRUE.equals(ParseValue(value.toString(), type, part.getFormat())) ? "1" : "0";
        }
        ParseValue(value.toString(), type, part.getFormat());
        return value.toString();
    }

    public static TreeMap<Integer, PackagePart> ParseHeaderFormat(String format) throws ParseException {
        return parseFormat(format);
    }

    public static TreeMap<Integer, PackagePart> ParseContentFormat(String format) throws ParseException {
        return parseFormat(format);
    }

    // Entries use FIELD:WIDTH:TYPE[:DATE_PATTERN], separated by commas; width is in characters.
    private static TreeMap<Integer, PackagePart> parseFormat(String format) throws ParseException {
        TreeMap<Integer, PackagePart> parts = new TreeMap<Integer, PackagePart>();
        if (format == null || format.trim().length() == 0) return parts;
        String[] entries = format.split(",", -1);
        for (String entry : entries) {
            String[] fields = entry.trim().split(":", 4);
            if (fields.length < 2 || fields[0].trim().length() == 0) {
                throw new ParseException("Invalid format entry: " + entry, 0);
            }
            int width;
            try {
                width = Integer.parseInt(fields[1].trim());
            } catch (NumberFormatException ex) {
                throw new ParseException("Invalid field width: " + entry, 0);
            }
            if (width <= 0 || parts.size() >= 10000) throw new ParseException("Invalid field width: " + entry, 0);
            PackagePart part = new PackagePart();
            part.setName(fields[0].trim());
            part.setSize(width);
            part.setDataType(fields.length > 2 ? fields[2].trim() : TAG_DATATYPE_STRING);
            part.setFormat(fields.length > 3 ? fields[3] : "");
            for (PackagePart previous : parts.values()) {
                if (previous.getName().equalsIgnoreCase(part.getName())) {
                    throw new ParseException("Duplicate field: " + part.getName(), 0);
                }
            }
            parts.put(parts.size(), part);
        }
        return parts;
    }

    public static int GetHeaderSize(TreeMap<Integer, PackagePart> parts) {
        int size = 0;
        for (Map.Entry<Integer, PackagePart> part : parts.entrySet()) {
            size = Math.addExact(size, part.getValue().getSize());
        }
        return size;
    }
}
