/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonCreator
 *  com.fasterxml.jackson.annotation.JsonValue
 */
package net.ibizsys.pscore.srv.util.gitlab.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import net.ibizsys.pscore.srv.util.gitlab.util.DurationUtils;

public class Duration {
    private int seconds;
    private String durationString;

    public Duration(String string) {
        this.seconds = DurationUtils.parse(string);
        this.durationString = this.seconds == 0 ? "0m" : DurationUtils.toString(this.seconds);
    }

    public Duration(int n) {
        this.seconds = n;
        this.durationString = n == 0 ? "0m" : DurationUtils.toString(n);
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int n) {
        this.seconds = n;
    }

    @JsonValue
    public String toString() {
        return this.durationString;
    }

    @JsonCreator
    public static Duration forValue(String string) {
        return new Duration(string);
    }
}

