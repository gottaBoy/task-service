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
public @interface DER {
    public String id() default "";

    public String name() default "";

    public String type() default "";

    public String majordeid() default "";

    public String majordename() default "";

    public String minordeid() default "";

    public String minordename() default "";

    public String pickupdefname() default "";

    public int masterrs() default 0;

    public String indexvalue() default "";
}

