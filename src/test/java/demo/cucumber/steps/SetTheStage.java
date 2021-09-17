package demo.cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class SetTheStage {

   @Managed
   WebDriver driver;

   @Before
   public void set_the_stage() {
      Cast cast = Cast.whereEveryoneCan(BrowseTheWeb.with(driver));

      setTheStage(cast);
   }

   @ParameterType(".*")
   public Actor actor(String actor) {
      return OnStage.theActorCalled(actor);
   }
}
