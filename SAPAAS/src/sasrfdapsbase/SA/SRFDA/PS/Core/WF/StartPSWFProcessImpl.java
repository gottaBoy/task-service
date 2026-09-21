/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.WF.IPSWFStartProcess;
import SA.SRFDA.PS.Core.WF.PSWFProcessImpl;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFramework.Utility.StringHelper;

@PSModelImplementMeta(implement="IPSWFProcess", typevalues={"START"})
public class StartPSWFProcessImpl
extends PSWFProcessImpl
implements IPSWFStartProcess {
    private String strPSDEFormId = "";
    private String strMobPSDEFormId = "";
    private String strFormCodeName = "";
    private String strMobFormCodeName = "";
    private String strPSDEViewId = "";
    private String strMobPSDEViewId = "";
    private PSDEViewBase startPSDEViewBase = null;
    private PSDEViewBase mobStartPSDEViewBase = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getPSDEVIEWBASEID())) {
            this.strPSDEViewId = this.psWFProcess.getPSDEVIEWBASEID();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBPSDEVIEWID())) {
            this.strMobPSDEViewId = this.psWFProcess.getMOBPSDEVIEWID();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getPSDEFORMID())) {
            this.strPSDEFormId = this.psWFProcess.getPSDEFORMID();
            this.strFormCodeName = this.psWFProcess.getFORMCODENAME();
            if (StringHelper.IsNullOrEmpty((String)this.getStartPSDEViewId()) && this.getPSDEWF() != null) {
                this.strPSDEViewId = this.getPSDEWF().getStartPSDEViewId();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strPSDEViewId) && this.getPSDEWF() != null) {
                this.startPSDEViewBase = this.getPSDEWF().getPSDataEntity().getPSDEViewData(this.strPSDEViewId, true);
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psWFProcess.getMOBPSDEFORMID())) {
            this.strMobPSDEFormId = this.psWFProcess.getMOBPSDEFORMID();
            this.strMobFormCodeName = this.psWFProcess.getMOBFORMCODENAME();
            if (StringHelper.IsNullOrEmpty((String)this.getMobStartPSDEViewId()) && this.getPSDEWF() != null) {
                this.strMobPSDEViewId = this.getPSDEWF().getMobStartPSDEViewId();
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strMobPSDEViewId) && this.getPSDEWF() != null) {
                this.mobStartPSDEViewBase = this.getPSDEWF().getPSDataEntity().getPSDEViewData(this.strMobPSDEViewId, true);
            }
        }
    }

    @Override
    public String getStartPSDEViewUserData() {
        return this.psWFProcess.getPSDYNADEVIEWTEMPLID();
    }

    @Override
    public String getMobStartPSDEViewUserData() {
        return this.psWFProcess.getMOBPSDYNADEVIEWTEMPLID();
    }

    @Override
    public String getStartPSDEViewId() {
        return this.strPSDEViewId;
    }

    @Override
    public String getMobStartPSDEViewId() {
        return this.strMobPSDEViewId;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u5904\u7406", staticcode="true")
    public boolean isStartProcess() {
        return true;
    }

    @Override
    protected int getDefaultWidth() {
        return 30;
    }

    @Override
    protected int getDefaultHeight() {
        return 30;
    }

    @Override
    public String getPSDEFormId() {
        return this.strPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"FORMCODENAME"})
    public String getFormCodeName() {
        return this.strFormCodeName;
    }

    @Override
    public String getMobPSDEFormId() {
        return this.strMobPSDEFormId;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u64cd\u4f5c\u8868\u5355\u6807\u8bb0", fields={"MOBFORMCODENAME"})
    public String getMobFormCodeName() {
        return this.strMobFormCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u52a8\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", fields={"VIEWCODENAME"})
    public String getStartViewCodeName() {
        if (this.startPSDEViewBase != null) {
            return this.startPSDEViewBase.getCODENAME();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u52a8\u89c6\u56fe\u540d\u79f0", fields={"PSDEVIEWBASENAME"})
    public String getStartViewName() {
        if (this.startPSDEViewBase != null) {
            return this.startPSDEViewBase.getPSDEVIEWBASENAME();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u542f\u52a8\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", fields={"MOBVIEWCODENAME"})
    public String getMobStartViewCodeName() {
        if (this.mobStartPSDEViewBase != null) {
            return this.mobStartPSDEViewBase.getCODENAME();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u7aef\u542f\u52a8\u89c6\u56fe\u540d\u79f0", fields={"MOBPSDEVIEWNAME"})
    public String getMobStartViewName() {
        if (this.mobStartPSDEViewBase != null) {
            return this.mobStartPSDEViewBase.getPSDEVIEWBASENAME();
        }
        return null;
    }
}

