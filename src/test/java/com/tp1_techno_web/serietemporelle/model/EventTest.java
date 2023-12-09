package com.tp1_techno_web.serietemporelle.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventTest {
    @Test
    void canNotCreateEventWithoutDate() {
        assertThatThrownBy(() -> new Event(null, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void canCreateEventWithoutCommentAndTag() {
        new Event(new Date(), 0, "");
        new Event(new Date(), 0, "comment");
        new Event(new Date(), 0, "", new Tag("MyTag"));
    }

    @Test
    void canCreateEventWithCommentAndTag() {
        new Event(new Date(), 0, "comment", new Tag("MyTag"));
    }

    @Test
    void canCreateEventWithMoreThanOneTag() {
        var tag1 = new Tag("MyTag1");
        var tag2 = new Tag("MyTag2");
        var myTags = new ArrayList<Tag>(List.of(tag1, tag2));
        var myEvent = new Event(new Date(), 0, "comment", tag1, tag2);

        assertThat(myTags.equals(myEvent.getTags())).isTrue();
    }
}
