/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.model.app.view;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;

public interface IPSAppViewRef
extends IPSModelObject,
IPSModelJsonExporter {
    public IPSAppView getPSAppView();

    public String getRefPSAppViewId();

    public IPSAppView getRefPSAppView() throws Exception;

    public String getOpenMode();

    public String getEmbedId();

    public int getHeight();

    public int getWidth();

    public ObjectNode getViewParam(boolean var1);

    public ObjectNode getViewParam();

    public ObjectNode getViewParamJO(boolean var1);

    public ObjectNode getViewParamJO();

    public ObjectNode getParentModeJO(boolean var1);

    public ObjectNode getParentModeJO();

    public ObjectNode getParentDataJO(boolean var1);

    public ObjectNode getParentDataJO();

    public String getRealTitle() throws Exception;

    public int getRealWidth(int var1) throws Exception;

    public int getRealHeight(int var1) throws Exception;

    public String getRealOpenMode() throws Exception;

    public String getRealTitleLanResTag() throws Exception;

    public String getRefModeDesc();
}

