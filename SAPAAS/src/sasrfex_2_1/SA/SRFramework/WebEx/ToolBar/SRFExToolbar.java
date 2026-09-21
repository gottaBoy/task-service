/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.WebEx.ToolBar;

import SA.SRFramework.WebEx.Builder.BaseBuilder;
import SA.SRFramework.WebEx.Builder.ToolbarBuilder;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.ToolBar.UI.ToolbarConfig;
import java.io.Writer;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExToolbar
extends SRFExControl {
    protected ToolbarConfig toolbarConfig = null;
    private static final Log log = LogFactory.getLog(SRFExToolbar.class);
    protected ToolbarBuilder toolbarBuilder = null;
    public static String BUILDER_TOOLBAR = "TOOLBAR";
    protected TreeMap<String, Object> toolbarObjects = new TreeMap();

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    public ToolbarConfig getToolbarConfig() {
        return this.toolbarConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.toolbarConfig = null;
        if (this.config != null && this.config instanceof ToolbarConfig) {
            this.toolbarConfig = (ToolbarConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        super.OnReloadConfig();
    }

    public void setToolbarObject(String strKey, Object obj) {
        this.toolbarObjects.put(strKey.toUpperCase(), obj);
    }

    public Object getToolbarObject(String strKey) {
        return this.toolbarObjects.get(strKey.toUpperCase());
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            this.PrepareBuilder();
            if (this.toolbarBuilder == null) {
                log.error((Object)"SRFExToolbar\u6784\u5efa\u5668\u65e0\u6548\uff0c\u65e0\u6cd5\u8f93\u51fa\u5de5\u5177\u680f");
                return;
            }
            this.toolbarBuilder.Render(writer, this);
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void PrepareBuilder() {
        if (this.toolbarBuilder != null) {
            return;
        }
        BaseBuilder builder = this.getPage().getWebContext().FindBuilder(BUILDER_TOOLBAR, this.getToolbarConfig().getRenderMode());
        if (builder == null) {
            log.error((Object)"SRFExToolbar\u6784\u5efa\u5668\u65e0\u6548");
            return;
        }
        if (builder instanceof ToolbarBuilder) {
            this.toolbarBuilder = (ToolbarBuilder)builder;
        }
    }
}

