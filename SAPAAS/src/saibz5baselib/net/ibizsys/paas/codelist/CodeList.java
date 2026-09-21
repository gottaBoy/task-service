/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface CodeList {
    public String id() default "";

    public String name() default "";

    public String type() default "";

    public boolean userscope();

    public String ormode() default "";

    public String valueseparator() default ";";

    public String textseparator() default "\u3001";

    public String emptytext() default "\u672a\u5b9a\u4e49";
}

