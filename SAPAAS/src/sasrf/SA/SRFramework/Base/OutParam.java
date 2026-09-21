/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

public class OutParam<T> {
    private T realValue = null;

    public T getValue() {
        return this.realValue;
    }

    public void setValue(T value) {
        this.realValue = value;
    }
}

