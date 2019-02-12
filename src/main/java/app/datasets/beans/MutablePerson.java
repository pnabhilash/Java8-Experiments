package app.datasets.beans;

import java.util.Objects;
import java.util.StringJoiner;

public class MutablePerson {

  private String firstName;
  private String lastName;

  public MutablePerson(String firstName , String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MutablePerson)) {
      return false;
    }
    MutablePerson that = (MutablePerson) o;
    return getFirstName ().equals (that.getFirstName ()) &&
        getLastName ().equals (that.getLastName ());
  }

  @Override
  public int hashCode() {
    return Objects.hash (getFirstName () , getLastName ());
  }

  @Override
  public String toString() {
    return new StringJoiner (", " , MutablePerson.class.getSimpleName () + "[" , "]")
        .add ("firstName='" + firstName + "'")
        .add ("lastName='" + lastName + "'")
        .toString ();
  }
}
