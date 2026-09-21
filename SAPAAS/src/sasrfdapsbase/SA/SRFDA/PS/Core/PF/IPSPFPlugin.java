/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSPFPlugin
extends IPSObject {
    public static final String PLUGINTYPE_UIENGINE = "UIENGINE";
    public static final int RTOBJECTSOURCE_UNKNOWN = 0;
    public static final int RTOBJECTSOURCE_LOCAL = 1;
    public static final int RTOBJECTSOURCE_REMOTE = 2;

    public String getPFPluginTag();

    public String getPFPluginType();

    public IPSPFPluginType getPSPFPluginType();

    public String getCode(String var1, String var2, String var3, Object var4, Object var5, Object var6) throws Exception;

    public String getCode(String var1, String var2, String var3, String var4, Object var5, Object var6, Object var7) throws Exception;

    public String getCode(String var1) throws Exception;

    public String getCode(String var1, String var2) throws Exception;

    public boolean hasCode(String var1) throws Exception;

    public boolean hasCode(String var1, String var2) throws Exception;

    public boolean hasCode(String var1, String var2, String var3, String var4) throws Exception;

    public boolean hasCode2(String var1) throws Exception;

    public boolean hasCode3(String var1) throws Exception;

    public boolean hasCode4(String var1) throws Exception;

    public String getCode2(String var1) throws Exception;

    public String getCode3(String var1) throws Exception;

    public String getCode4(String var1) throws Exception;

    public String getPSPFPluginId();

    public IPSPFPluginTempl getPSPFPluginTempl(String var1) throws Exception;

    public IPSPFPluginTempl getPSPFPluginTempl(String var1, String var2, boolean var3) throws Exception;

    public String getPreviewHtml();

    public boolean isRuntimeObject();

    public int getRTObjectSource();

    public String getRTObjectName();

    public String getRTObjectRepo();
}

