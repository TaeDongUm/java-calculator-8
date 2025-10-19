package calculator.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delimiter {

    private static final String DEFAULT_COMMA = ",";
    private static final String DEFAULT_COLON = ":";

    private final Set<String> tokens;
    private final Pattern splitPattern;

    private Delimiter(Set<String> tokens) {
        this.tokens = Collections.unmodifiableSet(new LinkedHashSet<>(tokens));
        this.splitPattern = Pattern.compile(makingUnionRegex(tokens));
    }

    public static Delimiter ofDefault() {
        return new Delimiter(new LinkedHashSet<>(List.of(DEFAULT_COLON, DEFAULT_COMMA)));
    }

    public static Delimiter currentDelimiters(Collection<String> tokens) {
        return new Delimiter(new LinkedHashSet<>(tokens));
    }

    public Delimiter withCustom(char token) {
        Set<String> currentToken = new LinkedHashSet<>(this.tokens);
        currentToken.add(String.valueOf(token));
        return new Delimiter(currentToken);
    }

    public List<String> split(String input) {
        return Arrays.asList(splitPattern.split(input));
    }

    private static String makingUnionRegex(Set<String> tokens) {
        return tokens.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }


}
