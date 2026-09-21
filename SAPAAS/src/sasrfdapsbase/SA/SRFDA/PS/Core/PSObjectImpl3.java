/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import net.ibizsys.paas.util.StringHelper;

public abstract class PSObjectImpl3
extends PSObjectImpl
implements IPSDynaInstSupportable {
    @Override
    @PSModelRTMeta(description="\u652f\u6301\u52a8\u6001\u6a21\u578b", dump=false)
    public boolean isEnableDynaModel() {
        return this.onGetEnableDynaModel();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", ignoredumpvalues="false")
    public boolean isDynaInstModel() {
        return !StringHelper.isNullOrEmpty((String)this.getPSDynaInstId());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6a21\u5f0f", dump=false, codelist="DynaInstMode3")
    public int getDynaInstMode() {
        return this.onGetDynaInstMode();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb0", dump=false)
    public String getDynaInstTag() {
        if (!this.isEnableDynaModel()) {
            return "";
        }
        return this.onGetDynaInstTag();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b9e\u4f8b\u6807\u8bb02", dump=false)
    public String getDynaInstTag2() {
        if (!this.isEnableDynaModel()) {
            return "";
        }
        return this.onGetDynaInstTag2();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u76ee\u5f55", hideempty=true, dump=false)
    public String getDynaModelFolder() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelFolder();
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6587\u4ef6\u8def\u5f84", hideempty=true)
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        String strDynaModelPath = this.getDynaModelFolder();
        if (StringHelper.isNullOrEmpty((String)strDynaModelPath)) {
            return null;
        }
        return String.format("%1$s.json", strDynaModelPath, this.getDumpModelType());
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6807\u8bb0", hideempty=true, dump=false)
    public String getDynaModelTag() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelTag();
    }
}

