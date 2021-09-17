package demo.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction {

   private int milliSeconds;

   public static Wait forMilliseconds(int milliSeconds) {
      Wait self = instrumented(Wait.class);
      self.milliSeconds = milliSeconds;
      return  self;
   }

   @Override
   public <T extends Actor> void performAs(T t) {
      try {
         Thread.sleep(milliSeconds);
      } catch(InterruptedException e) {
         e.printStackTrace();
      }
   }
}
