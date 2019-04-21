package org.pitrecki.codewars;

import static java.lang.String.format;

public class Solution {

    private static final String LIKES_THIS = "likes this";
    private static final String LIKE_THIS = "like this";

    public String whoLikesIt(String... names) {
        switch (names.length) {
            case 0:
                return format("no one %s", LIKES_THIS);

            case 1:
                return format("%s %s", names[0], LIKES_THIS);

            case 2:
                return format("%s and %s %s", names[0], names[1], LIKE_THIS);

            case 3:
                return format("%s, %s and %s %s", names[0], names[1], names[2], LIKE_THIS);

            default:
                return format("%s, %s and %d others %s", names[0], names[1], (names.length - 2), LIKE_THIS);

        }
    }

}
