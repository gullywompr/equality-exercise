package com.olsoncb.equality;

import java.util.Objects;

/** The type User key. */
public class UserKey {

    private String name;
    private String userid;

  /**
   * Instantiates a new User key.
   *
   * @param name the name
   * @param userid the userid
   */
  public UserKey(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
        return name;
    }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public String getUserID() {
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
