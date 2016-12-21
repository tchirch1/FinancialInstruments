package model;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
//Repackaging of Bonds to make them sellable
class Tranche
{

    private TrancheLevel trancheLevel;
    private double yield;
    private Rating rating;

    public Tranche(TrancheLevel trancheLevel, double yield, Rating rating)
    {
        this.trancheLevel = trancheLevel;
        this.yield = yield;
        this.rating = rating;
    }
}
