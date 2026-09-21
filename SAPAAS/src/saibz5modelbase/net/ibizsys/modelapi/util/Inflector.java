/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.modelapi.util;

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

    protected Inflector(Inflector original) {
        this.plurals.addAll(original.plurals);
        this.singulars.addAll(original.singulars);
        this.uncountables.addAll(original.uncountables);
    }

    public Inflector clone() {
        return new Inflector(this);
    }

    public String pluralize(Object word) {
        if (word == null) {
            return null;
        }
        String wordStr = word.toString().trim();
        if (wordStr.length() == 0) {
            return wordStr;
        }
        if (this.isUncountable(wordStr)) {
            return wordStr;
        }
        for (Rule rule : this.plurals) {
            String result = rule.apply(wordStr);
            if (result == null) continue;
            return result;
        }
        return wordStr;
    }

    public String pluralize(Object word, int count) {
        if (word == null) {
            return null;
        }
        if (count == 1 || count == -1) {
            return word.toString();
        }
        return this.pluralize(word);
    }

    public String singularize(Object word) {
        if (word == null) {
            return null;
        }
        String wordStr = word.toString().trim();
        if (wordStr.length() == 0) {
            return wordStr;
        }
        if (this.isUncountable(wordStr)) {
            return wordStr;
        }
        for (Rule rule : this.singulars) {
            String result = rule.apply(wordStr);
            if (result == null) continue;
            return result;
        }
        return wordStr;
    }

    public String lowerCamelCase(String lowerCaseAndUnderscoredWord, char ... delimiterChars) {
        return this.camelCase(lowerCaseAndUnderscoredWord, false, delimiterChars);
    }

    public String upperCamelCase(String lowerCaseAndUnderscoredWord, char ... delimiterChars) {
        return this.camelCase(lowerCaseAndUnderscoredWord, true, delimiterChars);
    }

    public String camelCase(String lowerCaseAndUnderscoredWord, boolean uppercaseFirstLetter, char ... delimiterChars) {
        if (lowerCaseAndUnderscoredWord == null) {
            return null;
        }
        if ((lowerCaseAndUnderscoredWord = lowerCaseAndUnderscoredWord.trim()).length() == 0) {
            return "";
        }
        if (uppercaseFirstLetter) {
            String result = lowerCaseAndUnderscoredWord;
            if (delimiterChars != null) {
                char[] cArray = delimiterChars;
                int n = delimiterChars.length;
                int n2 = 0;
                while (n2 < n) {
                    char delimiterChar = cArray[n2];
                    result = result.replace(delimiterChar, '_');
                    ++n2;
                }
            }
            return Inflector.replaceAllWithUppercase(result, "(^|_)(.)", 2);
        }
        if (lowerCaseAndUnderscoredWord.length() < 2) {
            return lowerCaseAndUnderscoredWord;
        }
        return Character.toLowerCase(lowerCaseAndUnderscoredWord.charAt(0)) + this.camelCase(lowerCaseAndUnderscoredWord, true, delimiterChars).substring(1);
    }

    public String underscore(String camelCaseWord, char ... delimiterChars) {
        if (camelCaseWord == null) {
            return null;
        }
        String result = camelCaseWord.trim();
        if (result.length() == 0) {
            return "";
        }
        result = result.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2");
        result = result.replaceAll("([a-z\\d])([A-Z])", "$1_$2");
        result = result.replace('-', '_');
        if (delimiterChars != null) {
            char[] cArray = delimiterChars;
            int n = delimiterChars.length;
            int n2 = 0;
            while (n2 < n) {
                char delimiterChar = cArray[n2];
                result = result.replace(delimiterChar, '_');
                ++n2;
            }
        }
        return result.toLowerCase();
    }

    public String capitalize(String words) {
        if (words == null) {
            return null;
        }
        String result = words.trim();
        if (result.length() == 0) {
            return "";
        }
        if (result.length() == 1) {
            return result.toUpperCase();
        }
        return Character.toUpperCase(result.charAt(0)) + result.substring(1).toLowerCase();
    }

    public String humanize(String lowerCaseAndUnderscoredWords, String ... removableTokens) {
        if (lowerCaseAndUnderscoredWords == null) {
            return null;
        }
        String result = lowerCaseAndUnderscoredWords.trim();
        if (result.length() == 0) {
            return "";
        }
        result = result.replaceAll("_id$", "");
        if (removableTokens != null) {
            String[] stringArray = removableTokens;
            int n = removableTokens.length;
            int n2 = 0;
            while (n2 < n) {
                String removableToken = stringArray[n2];
                result = result.replaceAll(removableToken, "");
                ++n2;
            }
        }
        result = result.replaceAll("_+", " ");
        return this.capitalize(result);
    }

    public String titleCase(String words, String ... removableTokens) {
        String result = this.humanize(words, removableTokens);
        result = Inflector.replaceAllWithUppercase(result, "\\b([a-z])", 1);
        return result;
    }

    public String ordinalize(int number) {
        int remainder = number % 100;
        String numberStr = Integer.toString(number);
        if (11 <= number && number <= 13) {
            return String.valueOf(numberStr) + "th";
        }
        remainder = number % 10;
        if (remainder == 1) {
            return String.valueOf(numberStr) + "st";
        }
        if (remainder == 2) {
            return String.valueOf(numberStr) + "nd";
        }
        if (remainder == 3) {
            return String.valueOf(numberStr) + "rd";
        }
        return String.valueOf(numberStr) + "th";
    }

    public boolean isUncountable(String word) {
        if (word == null) {
            return false;
        }
        String trimmedLower = word.trim().toLowerCase();
        return this.uncountables.contains(trimmedLower);
    }

    public Set<String> getUncountables() {
        return this.uncountables;
    }

    public void addPluralize(String rule, String replacement) {
        Rule pluralizeRule = new Rule(rule, replacement);
        this.plurals.addFirst(pluralizeRule);
    }

    public void addSingularize(String rule, String replacement) {
        Rule singularizeRule = new Rule(rule, replacement);
        this.singulars.addFirst(singularizeRule);
    }

    public void addIrregular(String singular, String plural) {
        String singularRemainder = singular.length() > 1 ? singular.substring(1) : "";
        String pluralRemainder = plural.length() > 1 ? plural.substring(1) : "";
        this.addPluralize("(" + singular.charAt(0) + ")" + singularRemainder + "$", "$1" + pluralRemainder);
        this.addSingularize("(" + plural.charAt(0) + ")" + pluralRemainder + "$", "$1" + singularRemainder);
    }

    public void addUncountable(String ... words) {
        if (words == null || words.length == 0) {
            return;
        }
        String[] stringArray = words;
        int n = words.length;
        int n2 = 0;
        while (n2 < n) {
            String word = stringArray[n2];
            if (word != null) {
                this.uncountables.add(word.trim().toLowerCase());
            }
            ++n2;
        }
    }

    protected static String replaceAllWithUppercase(String input, String regex, int groupNumberToUppercase) {
        Pattern underscoreAndDotPattern = Pattern.compile(regex);
        Matcher matcher = underscoreAndDotPattern.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(groupNumberToUppercase).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public void clear() {
        this.uncountables.clear();
        this.plurals.clear();
        this.singulars.clear();
    }

    protected void initialize() {
        Inflector inflect = this;
        inflect.addPluralize("$", "s");
        inflect.addPluralize("s$", "s");
        inflect.addPluralize("(ax|test)is$", "$1es");
        inflect.addPluralize("(octop|vir)us$", "$1i");
        inflect.addPluralize("(octop|vir)i$", "$1i");
        inflect.addPluralize("(alias|status)$", "$1es");
        inflect.addPluralize("(bu)s$", "$1ses");
        inflect.addPluralize("(buffal|tomat)o$", "$1oes");
        inflect.addPluralize("([ti])um$", "$1a");
        inflect.addPluralize("([ti])a$", "$1a");
        inflect.addPluralize("sis$", "ses");
        inflect.addPluralize("(?:([^f])fe|([lr])f)$", "$1$2ves");
        inflect.addPluralize("(hive)$", "$1s");
        inflect.addPluralize("([^aeiouy]|qu)y$", "$1ies");
        inflect.addPluralize("(x|ch|ss|sh)$", "$1es");
        inflect.addPluralize("(matr|vert|ind)ix|ex$", "$1ices");
        inflect.addPluralize("([m|l])ouse$", "$1ice");
        inflect.addPluralize("([m|l])ice$", "$1ice");
        inflect.addPluralize("^(ox)$", "$1en");
        inflect.addPluralize("(quiz)$", "$1zes");
        inflect.addPluralize("(people|men|children|sexes|moves|stadiums)$", "$1");
        inflect.addPluralize("(oxen|octopi|viri|aliases|quizzes)$", "$1");
        inflect.addSingularize("s$", "");
        inflect.addSingularize("(s|si|u)s$", "$1s");
        inflect.addSingularize("(n)ews$", "$1ews");
        inflect.addSingularize("([ti])a$", "$1um");
        inflect.addSingularize("((a)naly|(b)a|(d)iagno|(p)arenthe|(p)rogno|(s)ynop|(t)he)ses$", "$1$2sis");
        inflect.addSingularize("(^analy)ses$", "$1sis");
        inflect.addSingularize("(^analy)sis$", "$1sis");
        inflect.addSingularize("([^f])ves$", "$1fe");
        inflect.addSingularize("(hive)s$", "$1");
        inflect.addSingularize("(tive)s$", "$1");
        inflect.addSingularize("([lr])ves$", "$1f");
        inflect.addSingularize("([^aeiouy]|qu)ies$", "$1y");
        inflect.addSingularize("(s)eries$", "$1eries");
        inflect.addSingularize("(m)ovies$", "$1ovie");
        inflect.addSingularize("(x|ch|ss|sh)es$", "$1");
        inflect.addSingularize("([m|l])ice$", "$1ouse");
        inflect.addSingularize("(bus)es$", "$1");
        inflect.addSingularize("(o)es$", "$1");
        inflect.addSingularize("(shoe)s$", "$1");
        inflect.addSingularize("(cris|ax|test)is$", "$1is");
        inflect.addSingularize("(cris|ax|test)es$", "$1is");
        inflect.addSingularize("(octop|vir)i$", "$1us");
        inflect.addSingularize("(octop|vir)us$", "$1us");
        inflect.addSingularize("(alias|status)es$", "$1");
        inflect.addSingularize("(alias|status)$", "$1");
        inflect.addSingularize("^(ox)en", "$1");
        inflect.addSingularize("(vert|ind)ices$", "$1ex");
        inflect.addSingularize("(matr)ices$", "$1ix");
        inflect.addSingularize("(quiz)zes$", "$1");
        inflect.addIrregular("person", "people");
        inflect.addIrregular("man", "men");
        inflect.addIrregular("child", "children");
        inflect.addIrregular("sex", "sexes");
        inflect.addIrregular("move", "moves");
        inflect.addIrregular("stadium", "stadiums");
        inflect.addUncountable("equipment", "information", "rice", "money", "species", "series", "fish", "sheep");
    }

    protected class Rule {
        protected final String expression;
        protected final Pattern expressionPattern;
        protected final String replacement;

        protected Rule(String expression, String replacement) {
            this.expression = expression;
            this.replacement = replacement != null ? replacement : "";
            this.expressionPattern = Pattern.compile(this.expression, 2);
        }

        protected String apply(String input) {
            Matcher matcher = this.expressionPattern.matcher(input);
            if (!matcher.find()) {
                return null;
            }
            return matcher.replaceAll(this.replacement);
        }

        public int hashCode() {
            return this.expression.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == this.getClass()) {
                Rule that = (Rule)obj;
                if (this.expression.equalsIgnoreCase(that.expression)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.valueOf(this.expression) + ", " + this.replacement;
        }
    }
}

