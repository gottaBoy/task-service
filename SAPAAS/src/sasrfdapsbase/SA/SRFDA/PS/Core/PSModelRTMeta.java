/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface PSModelRTMeta {
    public String name() default "";

    public String description() default "";

    public int order() default 1000;

    public String codelist() default "";

    public boolean hideempty() default false;

    public boolean hideempty2() default false;

    public String hidevalues() default "";

    public boolean debugmode() default false;

    public boolean hidemethod() default false;

    public String modeltype() default "";

    public String modelcls() default "";

    public String displayvalue() default "";

    public String helpurl() default "";

    public String predefined() default "";

    public String modelattr() default "";

    public boolean dumpref() default false;

    public boolean child() default false;

    public boolean dump() default true;

    public String modelreftype() default "";

    public String ignoredumpvalues() default "";

    public String model() default "";

    public String[] fields() default {};

    public String ignoresetvalues() default "";

    public String from() default "";

    public String from_method() default "";

    public String origin() default "";

    public boolean ignorepf() default false;

    public int dynamodelmode() default 7;

    public boolean allowempty() default true;

    public String group() default "";

    public String alias() default "";

    public String doc() default "";

    public String outputdoc() default "";

    public String doctype() default "";

    public int ignorert() default 0;

    public String rtname() default "";

    public int rtdump() default 0;

    public String rtobj() default "";

    public String staticcode() default "";

    public String calccode() default "";
}

