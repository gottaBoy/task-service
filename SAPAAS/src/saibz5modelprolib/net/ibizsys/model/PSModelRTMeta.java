/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model;

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

    public boolean debugmode() default false;

    public boolean hidemethod() default false;

    public String modeltype() default "";

    public String modelcls() default "";

    public String displayvalue() default "";

    public boolean child() default false;

    public boolean dump() default true;
}

