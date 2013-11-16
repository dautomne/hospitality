package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class MinMaxStayNotifRequest
    extends BookingRuleNotifRequest
{
    public MinMaxStayNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                   @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                   @Nonnull Integer minStay, @Nonnull Integer maxStay )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, minStay, maxStay, null, null, null, null, null );
        checkNotNull( minStay );
        checkNotNull( maxStay );
        checkArgument( minStay > 0 && minStay <= maxStay );
        checkArgument( maxStay > 0 && minStay <= maxStay );
    }
}
