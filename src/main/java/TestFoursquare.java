import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

import java.util.Arrays;
import java.util.List;

public class TestFoursquare {
  FoursquareApi fa;
  private final String CLIENT_ID = "UJYDV4P2EYB4ONWASJTWXA0XZPGCAFM3JUY0PKRVBEMDJYGW";
  private final String CLIENT_SECRET = "RMYWEJRXSRQJUWIXLUQNQ3DV115DZYEVYYS5BH2BODENVGAU";
  private final String REDIRECT_URL = "";

  TestFoursquare() {
    fa = new FoursquareApi(CLIENT_ID, CLIENT_SECRET, REDIRECT_URL, true);
    int LIMIT = 50;

    try {
      Result<VenuesSearchResult> foursquareVenueSearchResult = fa.venuesSearch("59.3436016,18.0678461", null, null, null, "", LIMIT, "browse", "4d4b7105d754a06374d81259",null, null, null, 300, null);
      if (foursquareVenueSearchResult.getMeta().getCode() == 200) {
        // Remove some duplicates. If the venue appears multiple times in a single search will result duplicates
        List<CompactVenue> venues = Arrays.asList(foursquareVenueSearchResult.getResult().getVenues());

        venues.forEach(x -> System.out.println(x.getName()));

      }
    } catch (FoursquareApiException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new TestFoursquare();
  }
}
