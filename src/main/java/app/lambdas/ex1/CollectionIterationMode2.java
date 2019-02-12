package app.lambdas.ex1;

import app.datasets.beans.Person;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class CollectionIterationMode2 {

  private static List<String> nameList= Arrays.asList ("Jack","Jill","Butter","Nemo");

  public static void main(String[] args) {
    findNames_ImperativeMode ();
    findNames_DeclarativeMode ();

  }

  private static void findNames_ImperativeMode(){
    for(String names:nameList){
        if(names.equalsIgnoreCase ("Nemo")){
          System.out.println ("true ");
          break;
        }
    }

  }

  private static void findNames_DeclarativeMode(){

    System.out.println (nameList.contains ("Nemo"));


  }


}
