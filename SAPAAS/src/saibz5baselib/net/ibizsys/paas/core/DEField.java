/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.ibizsys.paas.core.DEFSearchMode;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface DEField {
    public String id() default "";

    public String name() default "";

    public String logicname() default "";

    public String datatype() default "";

    public int stddatatype() default 0;

    public DEFSearchMode[] defsearchmodes();

    public boolean keyfield() default false;

    public boolean majorfield() default false;

    public boolean linkfield() default false;

    public String pdt() default "";

    public boolean formulafield() default false;

    public boolean phisicalfield() default true;

    public boolean inheritfield() default false;
}

