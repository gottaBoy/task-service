/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.data;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface DataItemParam {
    public String format() default "";

    public String name() default "";

    public String defaultvalue() default "";

    public String codelistid() default "";
}

