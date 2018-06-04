package com.olsoncb.equality;

import junit.framework.TestSuite;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.util.SerializationUtils.deserialize;
import static org.springframework.util.SerializationUtils.serialize;

public class UserKeyTest extends TestSuite {

  private final UserKey b1 = new UserKey("Bill Smith", "BSMITH");
  private final UserKey b2 = new UserKey("Bill Smith", "BSMITH");
  private final UserKey b3 = new UserKey("Susan Smith", "SSMITH");
  private final UserKey b4 = new UserKey(null,null);

  @Test
  public void getNameTest() {
    assertThat(b1.getName(), is("Bill Smith"));
    assertThat(b2.getName(), is("Bill Smith"));
    assertThat(b3.getName(), is("Susan Smith"));
    assertThat(b4.getName(), nullValue());
  }

  @Test
  public void getUserIDTest() {
    assertThat(b1.getUserID(), is("BSMITH"));
    assertThat(b2.getUserID(), is("BSMITH"));
    assertThat(b3.getUserID(), is("SSMITH"));
    assertThat(b4.getUserID(), nullValue());
  }

  @Test
  public void equalsTest() {

    assertThat(b1, equalTo(b1) );
    assertThat(b1, equalTo(b2) );
    assertThat(b1, not(equalTo(b3)));
    assertThat(b1, notNullValue() );
    assertThat(b1, not(equalTo("Some String")));
    assertThat(b4, not(equalTo(b1)));
  }

  @Test
  public void hashCodeTest() {
    assertThat(b1.hashCode(), equalTo(b1.hashCode()) );
    assertThat(b1.hashCode(), equalTo(b2.hashCode()) );
    assertThat(b1.hashCode(), not(equalTo(b3.hashCode())));
    assertThat(b4.hashCode(), not(equalTo(b1.hashCode())));
  }

  @Test
  public void toStringTest() {
    assertThat(b1.toString(), equalTo("UserKey{name='Bill Smith', userid='BSMITH'}"));
    assertThat(b2.toString(), equalTo("UserKey{name='Bill Smith', userid='BSMITH'}"));
    assertThat(b3.toString(), equalTo("UserKey{name='Susan Smith', userid='SSMITH'}"));
    assertThat(b4.toString(), equalTo("UserKey{name='null', userid='null'}"));
  }

  @Test
  public void should_find_value_in_hashtable_by_key_of_another_equal_object(){
    java.util.Hashtable ht = new java.util.Hashtable();
    ht.put(b1,"Some Data");
    String s = (String) ht.get(b2);
    assertThat(s, equalTo("Some Data"));
  }

  @Test
  public void serializationTest() {

    byte[] byteb1 = serialize(b1);
    byte[] byteb2 = serialize(b2);

    Object objb1 = deserialize(byteb1);
    Object objb2 = deserialize(byteb2);
    assertThat(objb1, equalTo(objb2));
    assertThat(b1, equalTo(objb1));
    assertThat(b1, equalTo(objb2));
  }
}