/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util.gitlab.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DurationUtils {
    private static final String[] TIME_UNITS = new String[]{"mo", "w", "d", "h", "m", "s"};
    private static final int[] TIME_UNIT_MULTIPLIERS = new int[]{576000, 144000, 28800, 3600, 60, 1};
    private static Pattern durationPattern = Pattern.compile("(\\s*(\\d+)(mo|[wdhms]))");

    public static final String toString(int n) {
        return DurationUtils.toString(n, true);
    }

    public static final String toString(int n, boolean bl) {
        int n2 = n;
        int n3 = bl ? n2 / TIME_UNIT_MULTIPLIERS[0] : 0;
        int n4 = (n2 -= n3 * TIME_UNIT_MULTIPLIERS[0]) / TIME_UNIT_MULTIPLIERS[1];
        int n5 = (n2 -= n4 * TIME_UNIT_MULTIPLIERS[1]) / TIME_UNIT_MULTIPLIERS[2];
        int n6 = (n2 -= n5 * TIME_UNIT_MULTIPLIERS[2]) / 3600;
        int n7 = (n2 -= n6 * 3600) / 60;
        n2 -= n7 * 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (n3 > 0) {
            stringBuilder.append(n3).append("mo");
            if (n4 > 0) {
                stringBuilder.append(n4).append('w');
            }
            if (n2 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h').append(n7).append('m').append(n2).append('s');
            } else if (n7 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h').append(n7).append('m');
            } else if (n6 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h');
            } else if (n5 > 0) {
                stringBuilder.append(n5).append('d');
            }
        } else if (n4 > 0) {
            stringBuilder.append(n4).append('w');
            if (n2 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h').append(n7).append('m').append(n2).append('s');
            } else if (n7 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h').append(n7).append('m');
            } else if (n6 > 0) {
                stringBuilder.append(n5).append('d').append(n6).append('h');
            } else if (n5 > 0) {
                stringBuilder.append(n5).append('d');
            }
        } else if (n5 > 0) {
            stringBuilder.append(n5).append('d');
            if (n2 > 0) {
                stringBuilder.append(n6).append('h').append(n7).append('m').append(n2).append('s');
            } else if (n7 > 0) {
                stringBuilder.append(n6).append('h').append(n7).append('m');
            } else if (n6 > 0) {
                stringBuilder.append(n6).append('h');
            }
        } else if (n6 > 0) {
            stringBuilder.append(n6).append('h');
            if (n2 > 0) {
                stringBuilder.append(n7).append('m').append(n2).append('s');
            } else if (n7 > 0) {
                stringBuilder.append(n7).append('m');
            }
        } else if (n7 > 0) {
            stringBuilder.append(n7).append('m');
            if (n2 > 0) {
                stringBuilder.append(n2).append('s');
            }
        } else {
            stringBuilder.append(' ').append(n2).append('s');
        }
        return stringBuilder.toString();
    }

    public static final int parse(String string) {
        string = string.toLowerCase();
        Matcher matcher = durationPattern.matcher(string);
        int n = -1;
        int n2 = 0;
        Boolean bl = null;
        while (matcher.find() && bl != Boolean.FALSE) {
            bl = true;
            int n3 = matcher.groupCount();
            if (n3 == 3) {
                String string2 = matcher.group(3);
                int n4 = DurationUtils.getUnitIndex(string2);
                if (n4 > n) {
                    n = n4;
                    try {
                        n2 = (int)((long)n2 + Long.parseLong(matcher.group(2)) * (long)TIME_UNIT_MULTIPLIERS[n4]);
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl = false;
                    }
                    continue;
                }
                bl = false;
                continue;
            }
            bl = false;
        }
        if (bl != Boolean.TRUE) {
            throw new IllegalArgumentException(String.format("'%s' is not a valid duration", string));
        }
        return n2;
    }

    private static final int getUnitIndex(String string) {
        for (int i = 0; i < TIME_UNITS.length; ++i) {
            if (!string.equals(TIME_UNITS[i])) continue;
            return i;
        }
        return -1;
    }
}

