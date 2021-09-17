package demo.cucumber.steps;

import demo.screenplay.actions.Wait;
import demo.screenplay.targets.WikipediaTargets;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MyStepdefs {
   @Given("{actor} has access to wikipedia")
   public void johnDoeHasAccessToWikipedia(Actor actor) {
      BrowseTheWeb.as(actor).getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
   }

   @When("he looks up the meaning of his name")
   public void heLooksUpTheMeaningOfHisName() {
      theActorInTheSpotlight().attemptsTo(
         Clear.field(WikipediaTargets.SEARCH_FOR_INPUT),
         Enter.theValue("John Doe").into(WikipediaTargets.SEARCH_FOR_INPUT).thenHit(Keys.ENTER)

      );
   }

   @Then("he shall be enlightened")
   public void heShallBeEnlightened() {
      theActorInTheSpotlight().attemptsTo(
         Wait.forMilliseconds(500), // Yes, this is bad, I know. It is a quick ans dirty solution
         Ensure.thatTheCurrentPage().currentUrl().contains("/John_Doe")
      );
   }
}
