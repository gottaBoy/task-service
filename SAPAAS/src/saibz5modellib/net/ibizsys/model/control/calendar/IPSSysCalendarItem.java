/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.control.calendar;

import java.util.Iterator;
import net.ibizsys.model.control.calendar.IPSCalendarItem;
import net.ibizsys.model.control.calendar.IPSSysCalendar;
import net.ibizsys.model.control.calendar.IPSSysCalendarItemRV;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;

public interface IPSSysCalendarItem
extends IPSCalendarItem {
    public IPSSysCalendar getPSSysCalendar();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDEAction getCreatePSDEAction();

    public IPSDEOPPriv getCreatePSDEOPPriv();

    public IPSDEAction getUpdatePSDEAction();

    public IPSDEOPPriv getUpdatePSDEOPPriv();

    public IPSDEAction getRemovePSDEAction();

    public IPSDEOPPriv getRemovePSDEOPPriv();

    public IPSDELogic getActiveDataPSDELogic();

    public IPSDEField getIdPSDEField();

    public IPSDEField getTextPSDEField();

    public IPSDEField getIconPSDEField();

    public IPSDEField getContentPSDEField();

    public IPSDEField getBeginTimePSDEField();

    public IPSDEField getEndTimePSDEField();

    public IPSDEField getColorPSDEField();

    public IPSDEField getBKColorPSDEField();

    public IPSDEField getTipsPSDEField();

    public Iterator<IPSSysCalendarItemRV> getPSSysCalendarItemRVs();
}

