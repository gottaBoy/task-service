/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFCallOrgActivityProcess;
import SA.SRFDA.PS.Core.WF.IPSWFProcessRole;
import SA.SRFDA.PS.Core.WF.PSWFCallActivityProcessImplBase;
import SA.SRFDA.PS.Core.WF.PSWFProcessRoleImpl;
import SA.SRFDA.PS.Data.PSWFProcRole;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"CALLORGACTIVITY"})
@PSModelPFIgnoreMeta
public class PSWFCallOrgActivityProcessImpl
extends PSWFCallActivityProcessImplBase
implements IPSWFCallOrgActivityProcess {
    protected ArrayList<IPSWFProcessRole> psWFProcessRoleList = new ArrayList();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSWFProcessRoles();
    }

    protected void preparePSWFProcessRoles() throws Exception {
        this.psWFProcessRoleList.clear();
        ArrayList<PSWFProcRole> psWFProcessRoleList = this.psWFProcess.getPSWFProcRoles(false);
        if (psWFProcessRoleList == null) {
            return;
        }
        for (PSWFProcRole psWFProcRole : psWFProcessRoleList) {
            PSWFProcessRoleImpl iPSWFVersionProcessRole = new PSWFProcessRoleImpl();
            iPSWFVersionProcessRole.init(this.getDAGlobalHelper(), this, psWFProcRole);
            this.psWFProcessRoleList.add(iPSWFVersionProcessRole);
        }
    }

    @Override
    @PSModelRTMeta(description="\u7ec4\u7ec7\u89d2\u8272\u96c6\u5408", child=true)
    public Iterator<IPSWFProcessRole> getPSWFProcessRoles() {
        return this.psWFProcessRoleList.iterator();
    }
}

