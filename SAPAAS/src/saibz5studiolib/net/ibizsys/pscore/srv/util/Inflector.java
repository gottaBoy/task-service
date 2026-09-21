/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pscore.srv.util;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inflector {
    protected static final Inflector INSTANCE = new Inflector();
    private LinkedList<Rule> plurals = new LinkedList();
    private LinkedList<Rule> singulars = new LinkedList();
    private final Set<String> uncountables = new HashSet<String>();

    public static final Inflector getInstance() {
        return INSTANCE;
    }

    public Inflector() {
        this.initialize();
    }

    protected Inflector(Inflector inflector) {
        this.plurals.addAll(inflector.plurals);
        this.singulars.addAll(inflector.singulars);
        this.uncountables.addAll(inflector.uncountables);
    }

    public Inflector clone() {
        return new Inflector(this);
    }

    public String pluralize(Object object) {
        if (object == null) {
            return null;
        }
        String string = object.toString().trim();
        if (string.length() == 0) {
            return string;
        }
        if (this.isUncountable(string)) {
            return string;
        }
        for (Rule rule : this.plurals) {
            String string2 = rule.apply(string);
            if (string2 == null) continue;
            return string2;
        }
        return string;
    }

    public String pluralize(Object object, int n) {
        if (object == null) {
            return null;
        }
        if (n == 1 || n == -1) {
            return object.toString();
        }
        return this.pluralize(object);
    }

    public String singularize(Object object) {
        if (object == null) {
            return null;
        }
        String string = object.toString().trim();
        if (string.length() == 0) {
            return string;
        }
        if (this.isUncountable(string)) {
            return string;
        }
        for (Rule rule : this.singulars) {
            String string2 = rule.apply(string);
            if (string2 == null) continue;
            return string2;
        }
        return string;
    }

    public String lowerCamelCase(String string, char ... cArray) {
        return this.camelCase(string, false, cArray);
    }

    public String upperCamelCase(String string, char ... cArray) {
        return this.camelCase(string, true, cArray);
    }

    public String camelCase(String string, boolean bl, char ... cArray) {
        if (string == null) {
            return null;
        }
        if ((string = string.trim()).length() == 0) {
            return "";
        }
        if (bl) {
            String string2 = string;
            if (cArray != null) {
                for (char c : cArray) {
                    string2 = string2.replace(c, '_');
                }
            }
            return Inflector.replaceAllWithUppercase(string2, "(^|_)(.)", 2);
        }
        if (string.length() < 2) {
            return string;
        }
        return "" + Character.toLowerCase(string.charAt(0)) + this.camelCase(string, true, cArray).substring(1);
    }

    public String underscore(String string, char ... cArray) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.length() == 0) {
            return "";
        }
        string2 = string2.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2");
        string2 = string2.replaceAll("([a-z\\d])([A-Z])", "$1_$2");
        string2 = string2.replace('-', '_');
        if (cArray != null) {
            for (char c : cArray) {
                string2 = string2.replace(c, '_');
            }
        }
        return string2.toLowerCase();
    }

    public String capitalize(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.length() == 0) {
            return "";
        }
        if (string2.length() == 1) {
            return string2.toUpperCase();
        }
        return "" + Character.toUpperCase(string2.charAt(0)) + string2.substring(1).toLowerCase();
    }

    public String humanize(String string, String ... stringArray) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.length() == 0) {
            return "";
        }
        string2 = string2.replaceAll("_id$", "");
        if (stringArray != null) {
            for (String string3 : stringArray) {
                string2 = string2.replaceAll(string3, "");
            }
        }
        string2 = string2.replaceAll("_+", " ");
        return this.capitalize(string2);
    }

    public String titleCase(String string, String ... stringArray) {
        String string2 = this.humanize(string, stringArray);
        string2 = Inflector.replaceAllWithUppercase(string2, "\\b([a-z])", 1);
        return string2;
    }

    public String ordinalize(int n) {
        int n2 = n % 100;
        String string = Integer.toString(n);
        if (11 <= n && n <= 13) {
            return string + "th";
        }
        n2 = n % 10;
        if (n2 == 1) {
            return string + "st";
        }
        if (n2 == 2) {
            return string + "nd";
        }
        if (n2 == 3) {
            return string + "rd";
        }
        return string + "th";
    }

    public boolean isUncountable(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.trim().toLowerCase();
        return this.uncountables.contains(string2);
    }

    public Set<String> getUncountables() {
        return this.uncountables;
    }

    public void addPluralize(String string, String string2) {
        Rule rule = new Rule(string, string2);
        this.plurals.addFirst(rule);
    }

    public void addSingularize(String string, String string2) {
        Rule rule = new Rule(string, string2);
        this.singulars.addFirst(rule);
    }

    public void addIrregular(String string, String string2) {
        String string3 = string.length() > 1 ? string.substring(1) : "";
        String string4 = string2.length() > 1 ? string2.substring(1) : "";
        this.addPluralize("(" + string.charAt(0) + ")" + string3 + "$", "$1" + string4);
        this.addSingularize("(" + string2.charAt(0) + ")" + string4 + "$", "$1" + string3);
    }

    public void addUncountable(String ... stringArray) {
        if (stringArray == null || stringArray.length == 0) {
            return;
        }
        for (String string : stringArray) {
            if (string == null) continue;
            this.uncountables.add(string.trim().toLowerCase());
        }
    }

    protected static String replaceAllWithUppercase(String string, String string2, int n) {
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(n).toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public void clear() {
        this.uncountables.clear();
        this.plurals.clear();
        this.singulars.clear();
    }

    protected void initialize() {
        Inflector inflector = this;
        inflector.addPluralize("$", "s");
        inflector.addPluralize("s$", "s");
        inflector.addPluralize("(ax|test)is$", "$1es");
        inflector.addPluralize("(octop|vir)us$", "$1i");
        inflector.addPluralize("(octop|vir)i$", "$1i");
        inflector.addPluralize("(alias|status)$", "$1es");
        inflector.addPluralize("(bu)s$", "$1ses");
        inflector.addPluralize("(buffal|tomat)o$", "$1oes");
        inflector.addPluralize("([ti])um$", "$1a");
        inflector.addPluralize("([ti])a$", "$1a");
        inflector.addPluralize("sis$", "ses");
        inflector.addPluralize("(?:([^f])fe|([lr])f)$", "$1$2ves");
        inflector.addPluralize("(hive)$", "$1s");
        inflector.addPluralize("([^aeiouy]|qu)y$", "$1ies");
        inflector.addPluralize("(x|ch|ss|sh)$", "$1es");
        inflector.addPluralize("(matr|vert|ind)ix|ex$", "$1ices");
        inflector.addPluralize("([m|l])ouse$", "$1ice");
        inflector.addPluralize("([m|l])ice$", "$1ice");
        inflector.addPluralize("^(ox)$", "$1en");
        inflector.addPluralize("(quiz)$", "$1zes");
        inflector.addPluralize("(people|men|children|sexes|moves|stadiums)$", "$1");
        inflector.addPluralize("(oxen|octopi|viri|aliases|quizzes)$", "$1");
        inflector.addSingularize("s$", "");
        inflector.addSingularize("(s|si|u)s$", "$1s");
        inflector.addSingularize("(n)ews$", "$1ews");
        inflector.addSingularize("([ti])a$", "$1um");
        inflector.addSingularize("((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$", "$1$2sis");
        inflector.addSingularize("(^analy)ses$", "$1sis");
        inflector.addSingularize("(^analy)sis$", "$1sis");
        inflector.addSingularize("([^f])ves$", "$1fe");
        inflector.addSingularize("(hive)s$", "$1");
        inflector.addSingularize("(tive)s$", "$1");
        inflector.addSingularize("([lr])ves$", "$1f");
        inflector.addSingularize("([^aeiouy]|qu)ies$", "$1y");
        inflector.addSingularize("(s)eries$", "$1eries");
        inflector.addSingularize("(m)ovies$", "$1ovie");
        inflector.addSingularize("(x|ch|ss|sh)es$", "$1");
        inflector.addSingularize("([m|l])ice$", "$1ouse");
        inflector.addSingularize("(bus)es$", "$1");
        inflector.addSingularize("(o)es$", "$1");
        inflector.addSingularize("(shoe)s$", "$1");
        inflector.addSingularize("(cris|ax|test)is$", "$1is");
        inflector.addSingularize("(cris|ax|test)es$", "$1is");
        inflector.addSingularize("(octop|vir)i$", "$1us");
        inflector.addSingularize("(octop|vir)us$", "$1us");
        inflector.addSingularize("(alias|status)es$", "$1");
        inflector.addSingularize("(alias|status)$", "$1");
        inflector.addSingularize("^(ox)en", "$1");
        inflector.addSingularize("(vert|ind)ices$", "$1ex");
        inflector.addSingularize("(matr)ices$", "$1ix");
        inflector.addSingularize("(quiz)zes$", "$1");
        inflector.addIrregular("person", "people");
        inflector.addIrregular("man", "men");
        inflector.addIrregular("child", "children");
        inflector.addIrregular("sex", "sexes");
        inflector.addIrregular("move", "moves");
        inflector.addIrregular("stadium", "stadiums");
        inflector.addUncountable("equipment", "information", "rice", "money", "species", "series", "fish", "sheep");
    }

    protected class Rule {
        protected final String expression;
        protected final Pattern expressionPattern;
        protected final String replacement;

        protected Rule(String string, String string2) {
            this.expression = string;
            this.replacement = string2 != null ? string2 : "";
            this.expressionPattern = Pattern.compile(this.expression, 2);
        }

        protected String apply(String string) {
            Matcher matcher = this.expressionPattern.matcher(string);
            if (!matcher.find()) {
                return null;
            }
            return matcher.replaceAll(this.replacement);
        }

        public int hashCode() {
            return this.expression.hashCode();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object != null && object.getClass() == this.getClass()) {
                Rule rule = (Rule)object;
                if (this.expression.equalsIgnoreCase(rule.expression)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return this.expression + ", " + this.replacement;
        }
    }
}

