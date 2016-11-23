package controller;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class PassThruValuer<T extends Double> implements Valuer<T> {
    @Override
    public Double valueOf(T value) {
        return value;
    }
    public static PassThruValuer create()
    {
        return new PassThruValuer();
    }
}
