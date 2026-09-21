/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.CodeEngine;

public interface IDACodeEngineContext {
    public Object GetAttribute(String var1);

    public void SetAttribute(String var1, Object var2);

    public void ResetPreFix();

    public void IncreasePreFix();

    public void DecreasePreFix();

    public String GetPreFix();
}

