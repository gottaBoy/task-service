/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDEHelper;
import java.util.Properties;

public interface IDAObjectHelper {
    public String getId();

    public String getName();

    public int getVersion();

    public IDEHelper getDEHelper() throws Exception;

    public boolean isExpired();

    public Properties getParams();
}

