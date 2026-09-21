/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.control.grid.GridRowError;

public class GridRowException
extends Exception {
    private GridRowError gridRowError = null;

    public GridRowException(GridRowError gridRowError) {
        this.gridRowError = gridRowError;
    }

    public GridRowError getGridRowError() {
        return this.gridRowError;
    }
}

