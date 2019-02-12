package app.datasets.beans.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

public class TimeIt {


  public static <T> T getCodeExecutiionTime(Callable<T> task){
    T call=null;

    try{
          Instant start= Instant.now ();
          call=task.call ();
          Instant end=Instant.now ();
          Duration interval=Duration.between (start, end);
          System.out.println (interval.getNano () /1000000 +"ms");
    }catch (Exception e){
      System.out.println ("Timer Error "+e.getMessage ());
    }
      return call;
  }


}
