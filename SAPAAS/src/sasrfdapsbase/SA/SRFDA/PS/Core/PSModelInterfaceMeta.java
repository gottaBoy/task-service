/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
public @interface PSModelInterfaceMeta {
    public String typefield() default "";

    public boolean stringtype() default true;

    public String implement() default "";

    public String extend() default "";

    public boolean util() default false;

    public String model() default "";

    public String title() default "";

    public String description() default "";

    public String typefield2() default "";
}

