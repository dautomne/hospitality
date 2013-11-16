package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public class MinStayNotifRequest
    extends BookingRuleNotifRequest
{
    public MinStayNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                @Nullable Integer minStay )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, minStay, null, null, null, null, null, null );
        checkNotNull( minStay );
        checkArgument( minStay > 0 );
    }
}
