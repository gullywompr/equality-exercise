package com.olsoncb.equality;

import java.io.Serializable;
import java.util.Objects;

/** The type User key. */
public class UserKey implements Serializable {

    private String name;
    private String userid;

  /**
   * Instantiates a new User key.
   *
   * @param name the name
   * @param userid the userid
   */
  UserKey(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName() {
        return name;
    }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  String getUserID() {
        return userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserKey userKey = (UserKey) o;
        return Objects.equals(userid, userKey.userid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userid);
    }

    @Override
    public String toString() {
        return "UserKey{" +
                "name='" + name + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
