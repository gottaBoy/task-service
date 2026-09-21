/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.ibizsys.paas.data.DataItem;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface DEACMode {
    public String id() default "";

    public String name() default "";

    public DataItem[] dataitems();

    public boolean defaultmode() default false;
}

