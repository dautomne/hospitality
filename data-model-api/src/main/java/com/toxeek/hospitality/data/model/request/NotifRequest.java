package com.toxeek.hospitality.data.model.request;

import com.toxeek.hospitality.data.model.common.DateRange;

import javax.annotation.Nonnull;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Class description
 *
 * @author <a href="mailto:dautomne@toxeek.com">Dris Automne</a>
 */
public abstract class NotifRequest
{
    @Nonnull
    private final String hotelCode;

    @Nonnull
    private final Collection<String> ratePlans;

    @Nonnull
    private final Collection<String> roomTypes;

    @Nonnull
    private final DateRange dateRange;

    protected NotifRequest( @Nonnull String hotelCode, @Nonnull Collection<String> ratePlans,
                            @Nonnull Collection<String> roomTypes, @Nonnull DateRange dateRange )
    {
        checkNotNull( hotelCode );
        checkNotNull( ratePlans );
        checkNotNull( roomTypes );
        checkNotNull( dateRange );
        this.hotelCode = hotelCode;
        this.ratePlans = ratePlans;
        this.roomTypes = roomTypes;
        this.dateRange = dateRange;
    }

    @Nonnull
    public String getHotelCode()
    {
        return hotelCode;
    }

    @Nonnull
    public Collection<String> getRatePlans()
    {
        return ratePlans;
    }

    @Nonnull
    public Collection<String> getRoomTypes()
    {
        return roomTypes;
    }

    @Nonnull
    public DateRange getDateRange()
    {
        return dateRange;
    }
}
