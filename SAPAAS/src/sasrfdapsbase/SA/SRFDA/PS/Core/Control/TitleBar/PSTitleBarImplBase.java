/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.TitleBar;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.PSControlContainerImpl;
import SA.SRFDA.PS.Core.Control.TitleBar.IPSTitleBar;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PSTitleBarImplBase
extends PSControlContainerImpl
implements IPSTitleBar {
    private String strCaption = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private ArrayList<IPSControl> leftPSControlList = new ArrayList();
    private ArrayList<IPSControl> rightPSControlList = new ArrayList();

    @Override
    protected String onGetControlType() {
        return "TITLEBAR";
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    protected void setCaption(String strCaption) {
        this.strCaption = strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    protected void setCapPSLanguageRes(IPSLanguageRes capPSLanguageRes) {
        this.capPSLanguageRes = capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSControl> getLeftPSControls() {
        if (this.leftPSControlList == null) {
            return null;
        }
        return this.leftPSControlList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u53f3\u4fa7\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSControl> getRightPSControls() {
        if (this.rightPSControlList == null) {
            return null;
        }
        return this.rightPSControlList.iterator();
    }

    protected void registerLeftPSControl(IPSControl iPSControl) {
        this.leftPSControlList.add(iPSControl);
    }

    protected void registerRightPSControl(IPSControl iPSControl) {
        this.rightPSControlList.add(iPSControl);
    }
}

