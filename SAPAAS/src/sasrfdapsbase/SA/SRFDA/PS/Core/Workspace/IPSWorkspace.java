/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.pscore.srv.util.IPSWorkspace
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import java.sql.Timestamp;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSWorkspace
extends net.ibizsys.pscore.srv.util.IPSWorkspace,
IPSModelObject {
    public Iterator<String> getPSModelLimitNames();

    public int getTotalPSModelLimit();

    public int getPSModelLimit(String var1);

    public int getTotalFileCountLimit();

    public int getFileSizeLimit();

    public int getTotalFileSizeLimit();

    public Timestamp getExpiredTime();

    public Iterator<String> getEntities();

    public Timestamp getCurActiveTime();

    public Timestamp getCurExpiredTime();

    public boolean isBMode();

    public boolean isCMode();

    public boolean isTMode();

    public PSWorkspacePeriod calcPSWorkspacePeriod(Timestamp var1, boolean var2) throws Exception;
}

