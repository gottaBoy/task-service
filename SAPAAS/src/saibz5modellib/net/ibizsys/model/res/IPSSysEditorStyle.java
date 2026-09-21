/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.res;

import java.util.Properties;
import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.control.IPSEditorType;

public interface IPSSysEditorStyle
extends IPSSystemObject {
    public String getPSEditorTypeId();

    public boolean isReplaceDefault();

    public double getEditorWidth();

    public double getEditorHeight();

    public Properties getEditorParams();

    public int getEditorParam(String var1, int var2);

    public String getEditorParam(String var1, String var2);

    public double getEditorParam(String var1, double var2);

    public boolean getEditorParam(String var1, boolean var2);

    public String getAjaxHandlerType();

    public String getPSAjaxHandlerId();

    public IPSEditorType getPSEditorType() throws Exception;

    public String getRefViewShowMode();

    public String getLinkViewShowMode();
}

