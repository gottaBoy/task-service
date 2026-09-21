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
public @interface CodeItem {
    public String value();

    public String parentvalue() default "";

    public String text() default "";

    public String realtext();

    public String color() default "";

    public String iconpath() default "";

    public String iconpathx() default "";

    public String iconcls() default "";

    public String iconclsx() default "";

    public String textcls() default "";

    public String userdata() default "";

    public String userdata2() default "";

    public boolean disableselect() default false;

    public String textlanrestag() default "";
}

