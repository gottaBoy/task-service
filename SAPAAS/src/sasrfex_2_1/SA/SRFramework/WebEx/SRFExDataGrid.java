/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.DataGridBuilder;
import SA.SRFramework.WebEx.ISRFExUserDataGridTheme;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExHidden;
import SA.SRFramework.WebEx.UI.DataGridConfig;
import java.io.Writer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExDataGrid
extends SRFExControl {
    protected DataGridConfig dataGridConfig = null;
    private static final Log log = LogFactory.getLog(SRFExDataGrid.class);
    public static String BUILDER_DATAGRID = "DATAGRID";
    protected SRFExHidden hiddenCondition = null;
    protected boolean bEnableUserDGTheme = true;
    protected boolean bEnableItemPrivilege = false;
    protected static ISRFExUserDataGridTheme userDataGridTheme = null;

    public static void setUserDataGridTheme(ISRFExUserDataGridTheme value) {
        userDataGridTheme = value;
    }

    public void setEnableUserDGTheme(boolean bEnableUserDGTheme) {
        this.bEnableUserDGTheme = bEnableUserDGTheme;
    }

    public boolean getEnableUserDGTheme() {
        return this.bEnableUserDGTheme;
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        this.hiddenCondition = new SRFExHidden();
        this.hiddenCondition.InitConfig();
        this.hiddenCondition.setID(StringHelper.Format((String)"COND_%1$s", (Object)this.getID()));
        this.AddControl(this.hiddenCondition);
    }

    public DataGridConfig getDataGridConfig() {
        return this.dataGridConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.dataGridConfig = null;
        if (this.config != null && this.config instanceof DataGridConfig) {
            this.dataGridConfig = (DataGridConfig)this.config;
        }
    }

    protected DataGridConfig GetUserDGConfig(DataGridConfig originConfig) {
        Object obj;
        if (this.getPage().IsBackEndMode()) {
            return originConfig;
        }
        if (!originConfig.isUserTheme()) {
            return originConfig;
        }
        if (userDataGridTheme != null) {
            return userDataGridTheme.GetUserDGConfig(this.getPage().getWebContext(), originConfig);
        }
        String strObjId = this.getPage().getWebContext().getWebConfig().GetExtValue("USERDATAGRIDTHEME", "");
        if (StringHelper.Length((String)strObjId) > 0 && (obj = ObjectHelper.Create(strObjId)) != null && obj instanceof ISRFExUserDataGridTheme) {
            ISRFExUserDataGridTheme iUserDataGridTheme = (ISRFExUserDataGridTheme)obj;
            return iUserDataGridTheme.GetUserDGConfig(this.getPage().getWebContext(), originConfig);
        }
        return originConfig;
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
        if (this.bEnableUserDGTheme && this.dataGridConfig != null) {
            this.dataGridConfig = this.GetUserDGConfig(this.dataGridConfig);
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        DataGridBuilder dataGridBuilder = null;
        try {
            dataGridBuilder = this.PrepareBuilder();
            if (dataGridBuilder == null) {
                return;
            }
            try {
                this.hiddenCondition.getHiddenConfig().setValue(this.dataGridConfig.getDefaultCondition());
                super.OnRender(writer);
                dataGridBuilder.Render(writer, this);
            }
            catch (Exception ex) {
                log.error((Object)this, (Throwable)ex);
            }
        }
        finally {
            if (dataGridBuilder != null) {
                this.getPage().getWebContext().getCurBuilderConfig().ReleaseBuilder(BUILDER_DATAGRID, this.getDataGridConfig().getRenderMode(), dataGridBuilder);
            }
        }
    }

    protected DataGridBuilder PrepareBuilder() {
        BaseBuilder builder = this.getPage().getWebContext().getCurBuilderConfig().GetBuilderFromPool(BUILDER_DATAGRID, this.getDataGridConfig().getRenderMode());
        if (builder == null) {
            return null;
        }
        if (builder instanceof DataGridBuilder) {
            return (DataGridBuilder)builder;
        }
        return null;
    }

    public SRFExHidden GetConditionHidden() {
        return this.hiddenCondition;
    }

    public boolean isEnableItemPrivilege() {
        return this.bEnableItemPrivilege;
    }

    public void setEnableItemPrivilege(boolean bEnableItemPrivilege) {
        this.bEnableItemPrivilege = bEnableItemPrivilege;
    }
}

