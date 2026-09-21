/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface DEDataQueryCode {
    public String dbtype() default "";

    public String querycode() default "";

    public String querycodetemp() default "";

    public String declarecode() default "";

    public DEDataQueryCodeExp[] fieldexps();

    public DEDataQueryCodeCond[] conds();
}

