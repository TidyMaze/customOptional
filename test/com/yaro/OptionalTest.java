package com.yaro;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by yann on 23/06/15.
 */
public class OptionalTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testOf() throws Exception {
        Optional<Integer> opt1= Optional.of(1);
        assertThat(opt1.get(), is(1));

        try {
            Optional.of(null);
            fail("Must throw exception on null value");
        }catch (NullPointerException e){
            assertTrue(true);
        }
    }

    @Test
    public void testGet() throws Exception {
        Optional<Integer> opt1 = Optional.of(1);
        assertThat(opt1.get(), is(1));

        try {
            Optional<Integer> opt2 = Optional.empty();
            opt2.get();
            fail("Must throw NoSuchElementException on empty value");
        } catch (NoSuchElementException e){
            assertTrue(true);
        }
    }

    @Test
    public void testIsPresent() throws Exception {
        Optional<Integer> opt1 = Optional.of(1);
        assertThat(opt1.isPresent(), is(true));

        Optional<Integer> opt2 = Optional.empty();
        assertThat(opt2.isPresent(), is(false));
    }

    @Test
    public void testOrElse() throws Exception {
        Optional<Integer> opt1 = Optional.of(1);
        assertThat(opt1.orElse(2), is(1));

        Optional<Integer> opt2 = Optional.empty();
        assertThat(opt2.orElse(2), is(2));
    }

    @Test
    public void testEquals() throws Exception {
        Optional<Integer> optEmpty = Optional.empty();
        Optional<Integer> opt1 = Optional.of(1);
        Optional<Integer> opt2 = Optional.of(2);

        assertThat(opt1, is(equalTo(opt1)));
        assertThat(opt1, is(not(equalTo(opt2))));
        assertThat(opt1, is(not(equalTo(optEmpty))));
        assertThat(optEmpty, is(not(equalTo(opt1))));
        assertThat(optEmpty, is(equalTo(optEmpty)));
    }
}