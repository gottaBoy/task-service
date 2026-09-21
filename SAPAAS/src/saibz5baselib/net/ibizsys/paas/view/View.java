/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.view;

import net.ibizsys.paas.control.Control;

public @interface View {
    public String id() default "";

    public String name() default "";

    public Control[] controls();
}

