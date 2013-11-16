package com.toxeek.hospitality.data.model.request.bookingrule;

import com.toxeek.hospitality.data.model.common.DateRange;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

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
public class AbsoluteBooperNotifRequest
    extends BookingRuleNotifRequest
{
    public AbsoluteBooperNotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                                       @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange,
                                       @Nullable DateTime booperAbsoluteStartDate,
                                       @Nullable DateTime booperAbsoluteEndDate )
    {
        super( hotelCode, ratePlans, roomTypes, dateRange, null, null, null, null, null, booperAbsoluteStartDate,
               booperAbsoluteEndDate );
        checkNotNull( booperAbsoluteStartDate );
        checkNotNull( booperAbsoluteEndDate );
        checkArgument( !booperAbsoluteEndDate.isBefore( booperAbsoluteStartDate ) );
    }
}
