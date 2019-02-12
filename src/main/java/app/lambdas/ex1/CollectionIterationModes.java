package app.lambdas.ex1;

import app.datasets.beans.Person;
import app.datasets.beans.utils.TimeIt;
import app.datasets.mockdata.MockData;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class CollectionIterationModes {

  private static List<Person> peopleList;

  public static void main(String[] args) {
    try {

      peopleList = MockData.getPeople ();
      countMalePeople_ImperativeMode ();
      countMalePeople_DeclarativeMode ();

      countMalePeople_ImperativeMode2 ();
      countMalePeople_DeclarativeMode2 ();


      // 2 types if iteration mode and find time.

    }catch (Exception e){
      System.out.println ("Error in retrieving data "+e.getMessage ());
    }

  }





  private  static void countMalePeople_ImperativeMode(){
    Instant start=Instant.now();
    int count=0;
    for(Person person : peopleList){
      if(person.getGender ().equalsIgnoreCase ("Male")){
        count++;
      }
    }
    Instant end=Instant.now ();
    Duration timeConsumed=Duration.between (start, end);
    System.out.println ("No of Males in the given list "+count  + " Time taken ms "+timeConsumed.getNano ()/1000000);
  }


  private static void countMalePeople_DeclarativeMode(){

    Long maleCount = TimeIt.getCodeExecutiionTime (() -> peopleList.stream ().
        filter (person -> person.getGender ().equalsIgnoreCase ("Male"))
        .count ());

    System.out.println ("Male Count "+maleCount);

  }


  private  static List<Person> countMalePeople_ImperativeMode2(){
    List<Person> males = new ArrayList<Person> ();
    for(Person person : peopleList){
      if(person.getGender ().equalsIgnoreCase ("Male")){
        males.add (person);
      }
    }

    System.out.println ("No of Males in the given list "+males.size ());

    return males;
  }


  private  static void countMalePeople_DeclarativeMode2(){
    List<Person> maleList = peopleList.stream ().
        filter (p -> p.getGender ().equalsIgnoreCase ("Male"))
        .collect (Collectors.toList ());

    System.out.println ("No of Males in the given list "+maleList.size ());
  }



}
