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
public @interface DataEntity {
    public String id() default "";

    public String name() default "";

    public String logicname() default "";

    public String tablename() default "";

    public String viewname() default "";

    public boolean logicvalid() default false;

    public String validvalue() default "1";

    public String invalidvalue() default "0";
}

