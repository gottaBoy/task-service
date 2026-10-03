package SA.SRFDA.EAI.Ctrl.Transformer;

import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import java.util.Date;
import java.util.regex.Pattern;

public abstract class GrooveStringEngine extends Script {
    protected BaseDataEntity dataEntity;

    protected boolean InternalTest(String expression, boolean onError) {
        try {
            Binding binding = new Binding();
            binding.setVariable("dp", this);
            Object result = new GroovyShell(getClass().getClassLoader(), binding).evaluate(expression);
            return result instanceof Boolean ? ((Boolean)result).booleanValue() : onError;
        } catch (Exception ex) {
            return onError;
        }
    }

    public Object run() {
        return null;
    }

    public void Part(int offset, int width, String field, String source) {
        if (dataEntity == null || source == null || offset < 0 || width < 0
                || offset > source.length() || width > source.length() - offset) {
            throw new IllegalArgumentException("Invalid string part");
        }
        dataEntity.SetParamValue(field, source.substring(offset, offset + width));
    }

    public boolean IsNull(String field) {
        return dataEntity.GetParamValue(field) == null;
    }

    public int Int(String field, int fallback) {
        return dataEntity.GetParamIntValue(field, fallback);
    }

    public String Val(String field, String fallback) {
        return dataEntity.GetParamStringValue(field, fallback);
    }

    public String Val(String field) {
        return Val(field, "");
    }

    public String String(String field, String fallback) {
        return Val(field, fallback);
    }

    public double Double(String field, double fallback) {
        return dataEntity.GetParamDoubleValue(field, fallback);
    }

    public float Float(String field, float fallback) {
        return dataEntity.GetParamFloatValue(field, fallback);
    }

    public boolean Bool(String field, boolean fallback) {
        return dataEntity.GetParamBoolValue(field, fallback);
    }

    public long GetTime(String value) {
        if (value == null || value.length() == 0) return System.currentTimeMillis();
        Date now = new Date();
        String text;
        if ("NOHOUR".equalsIgnoreCase(value)) text = String.format("%1$tY-%1$tm-%1$td 00:00:00", now);
        else if ("NOMINUTE".equalsIgnoreCase(value)) text = String.format("%1$tY-%1$tm-%1$td %1$tH:00:00", now);
        else if ("NOSECOND".equalsIgnoreCase(value)) text = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:00", now);
        else text = value;
        try {
            return ((Date)StringTransformer.ParseValue(text, "DATETIME", "")).getTime();
        } catch (java.text.ParseException ex) {
            throw new IllegalArgumentException("Invalid time: " + value, ex);
        }
    }

    public long Time(String field) {
        Date date = dataEntity.GetParamDateValue(field, null);
        if (date == null) throw new IllegalArgumentException("Missing date: " + field);
        return date.getTime();
    }

    public long TimeDiff(String left, String right) {
        return Compare(5, left, right);
    }

    public long IntDiff(String left, String right) {
        return Compare(9, left, right);
    }

    public long FloatDiff(String left, String right) {
        return Compare(7, left, right);
    }

    public long DoubleDiff(String left, String right) {
        return Compare(6, left, right);
    }

    public long StringDiff(String left, String right) {
        return Compare(25, left, right);
    }

    public long Compare(int type, String left, String right) {
        Object first = dataEntity.GetParamValue(left);
        Object second = dataEntity.GetParamValue(right);
        if (first == null && second == null) return 0;
        if (first == null) return 1;
        if (second == null) return -1;
        if (!first.getClass().equals(second.getClass())) return -100;
        return DataTypeParse.Compare(type, first, second);
    }

    public boolean RegEx(String field, String pattern) {
        return Pattern.compile(pattern).matcher(Val(field)).matches();
    }
}
