package app.memorymgt;

import static java.util.List.of;

import app.datasets.beans.MutablePerson;
import app.datasets.beans.Person;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestImmutableList {



  private  List<MutablePerson> peopleList=null;
  private  TestImmutableList newTest;
  MutablePerson person=null;

  public TestImmutableList(){
     person=new MutablePerson ("Abhilash", "Peethan");
        testImmutability (getPeopleListAsNewList(),"AS-New-ArrayList-Mutation-Expected",person);
        testImmutability (getPeopleArraysAsList() ,"Arrays.asList-Mutation-Denied",person);
        testImmutability ( getIterablePersonList() ,"Iterator List on new ArrayList-Mutation Expected",person);
        testImmutability (getGooglesImmutableList (),"GoogleImmutbaleList",person);
        testImmutability (getPeopleArraysAsListOf(),"List.ofImmutability Test-Mutation Denied",person);

  }

  /**
   *
   *     Direct Arrays.asList makes arrays unmodifiable array on the structure -
   *     (peopleList= Arrays.asList (new MutablePerson ("Abhilash","Peethan"), ......)
   *     though you can modify data content inside.
   *
   *     To overcome this we need to new ArrayList and copy the elements from original list)
   *
   * @return
   */



  private List<MutablePerson> getPeopleListAsNewList(){
    List<MutablePerson> peopleList= new ArrayList<MutablePerson> (Arrays.asList (
        new MutablePerson ("Abhilash","Peethan"),
        new MutablePerson ("Charles","Matt"),
        new MutablePerson ("Tom", "Dick")));
    return peopleList;

  }

  /**
   *
   *     Direct Arrays.asList makes arrays unmodifiable array on the structure -
   *     (peopleList= Arrays.asList (new MutablePerson ("Abhilash","Peethan"), ......)
   *     though you can modify data content inside - i:e MutablePerson
   *
   *     To overcome this we need to apply a wrapper on wrapper !! (Arrays.asList - is itself as wrapper)
   *
   * @return
   */


  private List<MutablePerson> getPeopleArraysAsList(){

    List<MutablePerson>  listOfModelPerson= Arrays.asList(
        new MutablePerson ("Abhilash", "Peethan"),
        new MutablePerson ("Charles","Matt"),
        new MutablePerson ("Tom", "Dick")
    );

    return listOfModelPerson;

  }

  private List<MutablePerson> getPeopleArraysAsListOf(){

    List<MutablePerson>  listOfModelPerson= List.of (
        new MutablePerson ("Abhilash", "Peethan"),
        new MutablePerson ("Charles","Matt"),
        new MutablePerson ("Tom", "Dick")
    );

    return listOfModelPerson;

  }


  private Iterator<MutablePerson> getIterablePersonList(){
    List<MutablePerson> peopleList= new ArrayList<MutablePerson> (Arrays.asList (
        new MutablePerson ("Abhilash","Peethan"),
        new MutablePerson ("Charles","Matt"),
        new MutablePerson ("Tom", "Dick")));

    return peopleList.iterator ();
  }




   private List<MutablePerson> getGooglesImmutableList(){
     List<MutablePerson> peopleList= new ArrayList<MutablePerson> (Arrays.asList (
         new MutablePerson ("Abhilash","Peethan"),
         new MutablePerson ("Charles","Matt"),
         new MutablePerson ("Tom", "Dick")));
    return ImmutableList.copyOf (peopleList);
   }


   private void testImmutability(Collection<MutablePerson> immutablePeopleListContainer,String immutablityNature,MutablePerson person){
     System.out.println ("Testing :  ==> "+immutablityNature);
     System.out.println ("Before Change Attempt: Size "+immutablePeopleListContainer.size ());
      try{
        immutablePeopleListContainer.remove (person);
      }
      catch (Exception e){
       System.out.println ("Container is immutable  ");
     }

     System.out.println ("After Change Attempt: Size "+immutablePeopleListContainer.size ());
     System.out.println ();

   }



  private void testImmutability(Iterator<MutablePerson> immutablePeopleListContainer,String immutablityNature,MutablePerson person){
    System.out.println ("Testing Iterator :"+immutablityNature);

   // System.out.println ("Before Change "+Iterators.size (immutablePeopleListContainer));
    try{
      while(immutablePeopleListContainer.hasNext ())
        if(immutablePeopleListContainer.next ().equals (person)){
          immutablePeopleListContainer.remove ();
          System.out.println ("Person Located & Removed "+person);
        }
      System.out.println ("After Change "+Iterators.size (immutablePeopleListContainer));
    }
    catch (Exception e){
      System.out.println ("Container is immutable  ");
    }


    System.out.println ();

  }



  public static void main(String[] args) {
    new TestImmutableList ();

  }



}
