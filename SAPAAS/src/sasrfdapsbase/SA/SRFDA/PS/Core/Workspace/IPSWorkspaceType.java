/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Workspace;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Workspace.PSWorkspacePeriod;
import SA.SRFDA.PS.Data.PSWorkspaceType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSWorkspaceType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSWorkspaceType var2) throws Exception;

    public int getPSModelLimit(String var1);

    public Iterator<String> getPSModelLimitNames();

    public String getWorkspaceMode();

    public boolean isBMode();

    public boolean isCMode();

    public boolean isTMode();

    public long getExp();

    public long getExp2();

    public Iterator<String> getEntities();

    public PSWorkspacePeriod calcPSWorkspacePeriod(Timestamp var1, boolean var2) throws Exception;
}

