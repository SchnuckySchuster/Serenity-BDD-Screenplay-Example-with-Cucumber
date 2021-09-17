package demo.screenplay.targets;

import net.serenitybdd.screenplay.targets.Target;

public class WikipediaTargets {
   public final static Target SEARCH_FOR_INPUT = Target.the("Search input field").locatedBy("//input[@type='search']");
}
