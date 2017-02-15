package fi.foyt.foursquare.api.entities;

import fi.foyt.foursquare.api.FoursquareEntity;


public class CompactPhoto implements FoursquareEntity {

    private static final long serialVersionUID = 1L;

    private String prefix;

    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }


    /**
     * Returns the url for the original uploaded file.
     *
     * @return the url for the original uploaded file.
     */
    public String getUrl() {
        return this.getPrefix() + "original" + this.getSuffix();
    }

    /**
     * Returns the url for the original uploaded file forcing XXxYY scale.
     *
     * @return the url for the original uploaded file forcing XXxYY scale.
     */
    public String getUrlXXxYY(Integer xx, Integer yy) {
        return this.getPrefix() + xx.toString() + "x" + yy.toString() + this.getSuffix();
    }

    /**
     * Returns the url for the original uploaded file capping the photo with a width or height of XX (whichever is larger). Scales the other, smaller dimension proportionally.
     *
     * @return the url for the original uploaded file capping the photo with a width or height of XX (whichever is larger). Scales the other, smaller dimension proportionally.
     */
    public String getUrlCapXX(Integer xx) {
        return this.getPrefix() + "cap" + xx.toString() + this.getSuffix();
    }

    /**
     * Returns the url for the original uploaded file forcing the width to be XX and scales the height proportionally.
     *
     * @return the url for the original uploaded file forcing the width to be XX and scales the height proportionally.
     */
    public String getUrlWidthXX(Integer xx) {
        return this.getPrefix() + "width" + xx.toString() + this.getSuffix();
    }

    /**
     * Returns the url for the original uploaded file forcing the height to be YY and scales the width proportionally.
     *
     * @return the url for the original uploaded file forcing the height to be YY and scales the width proportionally.
     */
    public String getUrlHeightYY(Integer yy) {
        return this.getPrefix() + "height" + yy.toString() + this.getSuffix();
    }

}
