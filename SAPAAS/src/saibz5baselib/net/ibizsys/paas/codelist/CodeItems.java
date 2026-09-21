/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.codelist;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.ibizsys.paas.codelist.CodeItem;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
public @interface CodeItems {
    public CodeItem[] value();
}

