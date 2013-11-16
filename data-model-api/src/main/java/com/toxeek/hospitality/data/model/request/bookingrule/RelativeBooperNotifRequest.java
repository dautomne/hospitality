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
public class RelativeBooperNotifRequest
    extends BookingRuleNotifRequest
{
    public RelativeBooperNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                       @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                       @Nullable Integer booperRelativeStart, @Nullable Integer booperRelativeEnd )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, null, null, null, booperRelativeStart, booperRelativeEnd,
               null, null );
        checkNotNull( booperRelativeStart );
        checkNotNull( booperRelativeEnd );
        checkArgument( booperRelativeStart <= 0 );
        checkArgument( booperRelativeEnd <= 0 );
        checkArgument( booperRelativeEnd >= booperRelativeStart );

    }
}
