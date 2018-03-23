import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDebugMode {
  private String CLIENT_ID = "UJYDV4P2EYB4ONWASJTWXA0XZPGCAFM3JUY0PKRVBEMDJYGW";
  private String CLIENT_SECRET = "RMYWEJRXSRQJUWIXLUQNQ3DV115DZYEVYYS5BH2BODENVGAU";
  private String REDIRECT_URL = "";
  FoursquareApi fa;

  /**
   * Setup Foursquare client using TestMode on localhost
   * OBS! Do not forget to run api-mock-server (https://github.com/mskager/api-mock-server)
   */
  @Before
  public void setUp() {
    fa = new FoursquareApi(CLIENT_ID, CLIENT_SECRET,REDIRECT_URL);
    fa.setTestMode(true);
    fa.setVersion("20161210");
    fa.setUseCallback(false);
  }

  /**
   * Test venueSearch at A House with 300m radius
   */
  @Test
  public void testSearchAtAHouse300() {
    List<CompactVenue> venues = new ArrayList<>();
    String location = "59.3436016,18.0678461";
    String categoryId = "4d4b7105d754a06374d81259";
    int radius = 300;
    try {
      Result<VenuesSearchResult>  vsr = fa.venuesSearch(location, null, null, null, null, null, null, categoryId, null, null, null, radius, null);

      // 200: OK
      if (vsr.getMeta().getCode() == 200) {
        venues.addAll(Arrays.asList(vsr.getResult().getVenues()));
      } else{
        System.out.printf("TestDebugMode::testSearchAtAHouse300 - Error getting data from Foursquare, Foursquare return code: %d", vsr.getMeta().getCode());
      }
    } catch (FoursquareApiException e) {
      e.printStackTrace();
    }

    venues.forEach(venue -> System.out.println(venue.getName()));
  }
}
