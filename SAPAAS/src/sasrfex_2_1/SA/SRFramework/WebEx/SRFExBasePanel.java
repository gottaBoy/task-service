/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExControlPanel;
import SA.SRFramework.WebEx.SRFExGroupPanel;
import SA.SRFramework.WebEx.SRFExHiddenPanel;
import SA.SRFramework.WebEx.SRFExPanel;
import SA.SRFramework.WebEx.SRFExRemotePanel;
import SA.SRFramework.WebEx.SRFExTabPanel;
import SA.SRFramework.WebEx.UI.ControlPanelConfig;
import SA.SRFramework.WebEx.UI.GroupPanelConfig;
import SA.SRFramework.WebEx.UI.HiddenPanelConfig;
import SA.SRFramework.WebEx.UI.PanelConfig;
import SA.SRFramework.WebEx.UI.RemotePanelConfig;
import SA.SRFramework.WebEx.UI.TabPanelConfig;

public class SRFExBasePanel
extends SRFExControl {
    public static SRFExControl CreatePanel(Object objPanel) {
        if (objPanel == null) {
            return null;
        }
        if (objPanel instanceof HiddenPanelConfig) {
            return new SRFExHiddenPanel();
        }
        if (objPanel instanceof RemotePanelConfig) {
            return new SRFExRemotePanel();
        }
        if (objPanel instanceof TabPanelConfig) {
            return new SRFExTabPanel();
        }
        if (objPanel instanceof ControlPanelConfig) {
            return new SRFExControlPanel();
        }
        if (objPanel instanceof GroupPanelConfig) {
            return new SRFExGroupPanel();
        }
        if (objPanel instanceof PanelConfig) {
            return new SRFExPanel();
        }
        return null;
    }
}

