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
public class MaxStayNotifRequest
    extends BookingRuleNotifRequest
{
    public MaxStayNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                @Nullable Integer maxStay )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, null, maxStay, null, null, null, null, null );
        checkNotNull( maxStay );
        checkArgument( maxStay > 0 );
    }
}
