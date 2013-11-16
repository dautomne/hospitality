package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class CloArrNotifRequest
    extends BookingRuleNotifRequest
{
    public CloArrNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                               @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange, boolean cloarr )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, null, null, cloarr, null, null, null, null );
    }
}
