/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface DBProcParam {
    public String name() default "";

    public String outputname() default "";

    public int dir() default 1;

    public int datatype() default 0;
}

