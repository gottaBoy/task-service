/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.grid;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.ibizsys.paas.control.Control;
import net.ibizsys.paas.control.grid.GridColumn;
import net.ibizsys.paas.data.DataItem;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
@Control
public @interface Grid {
    public String name() default "";

    public String type() default "GRID";

    public GridColumn[] gridcolumns();

    public DataItem[] griddataitems();
}

