package com.tp1_techno_web.serietemporelle.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    void usernameCanNotBeBlankOrNull() {
        assertThatThrownBy(() -> new User("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User("  ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void usernameCanNotBeLongerThan40() {
        assertThatThrownBy(() -> new User("erfgyyuazeviuhaezivhjiahvaihkazvdfvbazjkhfgzdhjhkcbjhkazdvbfjhkdbkc" +
                "jhkazbjhvbkhzbzhkdakhczdkjhehfhdjbvfazjhvkjhfg")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void usernameCanNotContainSpecialCarac() {
        assertThatThrownBy(() -> new User("Tagé")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new User("&-§")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void verifyUsernameCanOnlyContainLettersAndBlank() {
        new User("My Tag");
    }
}
