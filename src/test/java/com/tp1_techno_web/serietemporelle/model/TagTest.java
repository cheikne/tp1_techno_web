package com.tp1_techno_web.serietemporelle.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TagTest {
    @Test
    void labelCanNotBeBlank() {
        assertThatThrownBy(() -> new Tag("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Tag("  ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Tag(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void labelCanNotBeLongerThan40() {
        assertThatThrownBy(() -> new Tag("erfgyyuazeviuhaezivhjiahvaihkazvdfvbazjkhfgzdhjhkcbjhkazdvbfjhkdbkc" +
                "jhkazbjhvbkhzbzhkdakhczdkjhehfhdjbvfazjhvkjhfg")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void labelCanNotContainSpecialCarac() {
        assertThatThrownBy(() -> new Tag("Tagé")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Tag("&-§")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void verifyLabelCanOnlyContainAlphanumericBlankAndUnderscore() {
        new Tag("My Tag_23");
    }
}
