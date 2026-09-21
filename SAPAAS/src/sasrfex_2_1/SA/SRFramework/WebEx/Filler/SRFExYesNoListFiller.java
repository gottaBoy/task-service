/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Web.ListItem
 */
package SA.SRFramework.WebEx.Filler;

import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Filler.ISRFExListControlFiller;
import SA.SRFramework.WebEx.SRFExListControl;
import SA.SRFramework.WebEx.UI.ListControlConfig;

public class SRFExYesNoListFiller
implements ISRFExListControlFiller {
    @Override
    public void Fill(SRFExListControl listControl) {
        ListControlConfig listControlConfig = listControl.getListControlConfig();
        if (listControlConfig == null) {
            return;
        }
        listControlConfig.getListItems().Clear();
        listControlConfig.getListItems().Add(new ListItem("\u662f", "1"));
        listControlConfig.getListItems().Add(new ListItem("\u5426", "0"));
        listControl.ReloadConfig();
    }
}

